package br.dev.mhc.financialassistantapi.dto;

import java.io.Serializable;

import br.dev.mhc.financialassistantapi.entities.Account;
import br.dev.mhc.financialassistantapi.entities.accounts.BankAccount;
import br.dev.mhc.financialassistantapi.entities.accounts.CreditCard;
import br.dev.mhc.financialassistantapi.entities.enums.AccountType;

public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Account
	private Long id;
	private String name;
	private Double balance;
	private AccountType accountType;

	// BankAccount
	private Double bankInterestRate;
	private Double limitValueBankAccount;

	// CreditCard
	private Integer closingDay;
	private Integer dueDay;
	private Double limitValueCard;

	// Wallet
	// Não possui atributos exclusivos

	public AccountDTO() {
	}

	public AccountDTO(Long id, String name, Double balance, AccountType accountType,
			Double bankInterestRate, Double limitValueBankAccount, Integer closingDay, Integer dueDay,
			Double limitValueCard) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
		this.bankInterestRate = bankInterestRate;
		this.limitValueBankAccount = limitValueBankAccount;
		this.closingDay = closingDay;
		this.dueDay = dueDay;
		this.limitValueCard = limitValueCard;
	}

	public AccountDTO(Account obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.balance = obj.getBalance();
		this.accountType = obj.getAccountType();

		switch (obj.getAccountType()) {

		case WALLET:
			break;

		case BANK_ACCOUNT:
			BankAccount bankAccount = (BankAccount) obj;
			this.bankInterestRate = bankAccount.getBankInterestRate();
			this.limitValueBankAccount = bankAccount.getLimitValueBankAccount();
			break;

		case CREDIT_CARD:
			CreditCard creditCard = (CreditCard) obj;
			this.closingDay = creditCard.getClosingDay();
			this.dueDay = creditCard.getDueDay();
			this.limitValueCard = creditCard.getLimitValueCard();
			break;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getBankInterestRate() {
		return bankInterestRate;
	}

	public void setBankInterestRate(Double bankInterestRate) {
		this.bankInterestRate = bankInterestRate;
	}

	public Double getLimitValueBankAccount() {
		return limitValueBankAccount;
	}

	public void setLimitValueBankAccount(Double limitValueBankAccount) {
		this.limitValueBankAccount = limitValueBankAccount;
	}

	public Integer getClosingDay() {
		return closingDay;
	}

	public void setClosingDay(Integer closingDay) {
		this.closingDay = closingDay;
	}

	public Integer getDueDay() {
		return dueDay;
	}

	public void setDueDay(Integer dueDay) {
		this.dueDay = dueDay;
	}

	public Double getLimitValueCard() {
		return limitValueCard;
	}

	public void setLimitValueCard(Double limitValueCard) {
		this.limitValueCard = limitValueCard;
	}
}
