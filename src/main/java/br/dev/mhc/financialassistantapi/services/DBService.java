package br.dev.mhc.financialassistantapi.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.dev.mhc.financialassistantapi.entities.Category;
import br.dev.mhc.financialassistantapi.entities.CurrencyType;
import br.dev.mhc.financialassistantapi.entities.User;
import br.dev.mhc.financialassistantapi.entities.enums.Profile;
import br.dev.mhc.financialassistantapi.repositories.CategoryRepository;
import br.dev.mhc.financialassistantapi.repositories.CurrencyTypeRepository;
import br.dev.mhc.financialassistantapi.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;

	@Value("${dbseed.admin_user.email}")
	private String adminEmail;

	@Value("${dbseed.admin_user.password}")
	private String adminPassword;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private CurrencyTypeRepository currencyRepository;

	@Autowired
	private CurrencyTypeService currencyService;

	@Autowired
	private CategoryRepository categoryRepository;

	public void databaseSeeding() throws ParseException {
		// add user admin
		User user;
		if (userRepository.count() > 0) {
			user = userRepository.findById(1l).get();
		} else {
			user = new User(1l, null, "Administrador", "Admin", adminEmail, pe.encode(adminPassword), null, null);
			user.addProfile(Profile.ADMIN);
			user = userRepository.save(user);
		}

		// add currencies
		Instant momentUpdate = Instant.now().minusMillis(300000L);
		List<CurrencyType> currencies = new ArrayList<>();
		currencies.add(new CurrencyType(1L, "BRL", "Real", "R$", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(2L, "USD", "Dólar Americano", "US$", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(3L, "EUR", "Euro", "€", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(4L, "GBP", "Libra Esterlina", "£", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(5L, "ARS", "Peso Argentino", "ARS", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(6L, "CAD", "Dólar Canadense", "C$", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(8L, "AUD", "Dólar Australiano", "AU$", 2, BigDecimal.ZERO));
		currencies.add(new CurrencyType(9L, "JPY", "Iene", "¥", 0, BigDecimal.ZERO));
		currencies.add(new CurrencyType(10L, "CNY", "Renminbi", "CN¥", 1, BigDecimal.ZERO));
		currencies.add(new CurrencyType(11L, "BTC", "Bitcoin", "₿", 5, BigDecimal.ZERO));
		Long registers = currencyRepository.count();
		for (CurrencyType x : currencies) {
			if(x.getId() < registers) {
				currencies.remove(x);
			} else {
				x.setCreationMoment(momentUpdate);
				x.setLastUpdate(momentUpdate);
			}
		}
		currencyRepository.saveAll(currencies);
		currencyService.updateCurrencyExchange();
		
		// add categories
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1L, "Alimentação", "", user, true));
		categories.add(new Category(2L, "Automotivo", "", user, true));
		categories.add(new Category(3L, "Cartão de crédito", "", user, true));
		categories.add(new Category(4L, "Doações/Presentes", "", user, true));
		categories.add(new Category(5L, "Educação", "", user, true));
		categories.add(new Category(6L, "Impostos/Tributos", "", user, true));
		categories.add(new Category(7L, "Investimento", "", user, true));
		categories.add(new Category(8L, "Lazer", "", user, true));
		categories.add(new Category(9L, "Moradia", "", user, true));
		categories.add(new Category(10L, "Pet", "", user, true));
		categories.add(new Category(11L, "Produtos de Limpeza", "", user, true));
		categories.add(new Category(12L, "Saque", "", user, true));
		categories.add(new Category(13L, "Saúde", "", user, true));
		categories.add(new Category(14L, "Seguros", "", user, true));
		categories.add(new Category(15L, "Tarifas Bancárias", "", user, true));
		categories.add(new Category(16L, "Trabalho", "", user, true));
		categories.add(new Category(17L, "Transporte", "", user, true));
		categories.add(new Category(18L, "Vestuário", "", user, true));
		categories.add(new Category(19L, "Viagens", "", user, true));
		for (Long i = categoryRepository.count(); i > 0; i--) {
			categories.remove(0);
		}
		categoryRepository.saveAll(categories);

	}
}
