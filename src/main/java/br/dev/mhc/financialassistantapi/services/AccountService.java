package br.dev.mhc.financialassistantapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.mhc.financialassistantapi.dto.AccountDTO;
import br.dev.mhc.financialassistantapi.entities.Account;
import br.dev.mhc.financialassistantapi.entities.accounts.BankAccount;
import br.dev.mhc.financialassistantapi.entities.accounts.CreditCard;
import br.dev.mhc.financialassistantapi.entities.accounts.Wallet;
import br.dev.mhc.financialassistantapi.repositories.AccountRepository;
import br.dev.mhc.financialassistantapi.security.UserSpringSecurity;
import br.dev.mhc.financialassistantapi.security.enums.AuthorizationType;
import br.dev.mhc.financialassistantapi.services.exceptions.ObjectNotFoundException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private UserService userService;

	@Transactional
	public Account insert(Account obj) {
		UserSpringSecurity userSS = AuthService.getAuthenticatedUserSpringSecurity();
		AuthService.validatesUserAuthorization(userSS.getId(), AuthorizationType.USER_ONLY);

		obj.setId(null);
		obj.setUser(userService.findById(userSS.getId()));
		obj = repository.save(obj);

		return obj;
	}

	public List<Account> findAllByUser() {
		UserSpringSecurity userSS = AuthService.getAuthenticatedUserSpringSecurity();
		AuthService.validatesUserAuthorization(userSS.getId(), AuthorizationType.USER_ONLY);

		return repository.findAllByUser(userService.findById(userSS.getId()));
	}

	public Account findById(Long id) {
		Optional<Account> obj = repository.findById(id);
		Account account = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Account.class.getName()));
		AuthService.validatesUserAuthorization(account.getUser().getId(), AuthorizationType.USER_ONLY);
		return account;
	}

	@Transactional
	public Account update(Account obj) {
		Account newObj = findById(obj.getId());
		AuthService.validatesUserAuthorization(newObj.getUser().getId(), AuthorizationType.USER_ONLY);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Account newObj, Account obj) {
		newObj.setName(obj.getName());

		switch (obj.getAccountType()) {
		case WALLET:
			break;

		case BANK_ACCOUNT:
			((BankAccount) newObj).setBankInterestRate(((BankAccount) obj).getBankInterestRate());
			((BankAccount) newObj).setLimitValue(((BankAccount) obj).getLimitValueBankAccount());
			break;

		case CREDIT_CARD:
			((CreditCard) newObj).setClosingDay(((CreditCard) obj).getClosingDay());
			((CreditCard) newObj).setDueDay(((CreditCard) obj).getDueDay());
			((CreditCard) newObj).setLimitValueCard(((CreditCard) obj).getLimitValueCard());
			break;
		}
	}

	public Account fromDTO(AccountDTO objDTO) {
		switch (objDTO.getAccountType()) {
		case WALLET:
			return new Wallet(objDTO.getId(), objDTO.getName(), objDTO.getBalance());

		case BANK_ACCOUNT:
			return new BankAccount(objDTO.getId(), objDTO.getName(), objDTO.getBalance(), objDTO.getBankInterestRate(),
					objDTO.getLimitValueBankAccount());

		case CREDIT_CARD:
			return new CreditCard(objDTO.getId(), objDTO.getName(), objDTO.getBalance(), objDTO.getClosingDay(),
					objDTO.getDueDay(), objDTO.getLimitValueCard());

		default:
			return null;
		}
	}
}
