package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyCustomerBOTestRefactor {

	private CustomerBO customerBO = new CustomerBOImpl();

	private void assertCurrency(Amount expected, Amount actual) {
		assertEquals(expected.getCurrency(), actual.getCurrency());
		assertEquals(expected.getValue(), actual.getValue());
	}

	private List<Product> createProductsWithAmounts(Amount[] amounts) {
		return Arrays
				.stream(amounts)
				.map(amount ->
						new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
				amount))
				.collect(Collectors.toList());
	}

	@Test
	public void testCustomerProductSum_TwoProductsSameCurrencies() throws DifferentCurrenciesException {
		//setup
		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.EURO)
		};

		Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
		List<Product> products = createProductsWithAmounts(amounts);

		// verify
		assertCurrency(expected, customerBO.getCustomerProductsSum(products));
	}

	@Test
	public void testCustomerProductSum_TwoProductsDifferentCurrencies() {
		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.INDIAN_RUPEE),
				new AmountImpl(new BigDecimal("6.0"), Currency.EURO)
		};

		List<Product> products = createProductsWithAmounts(amounts);

		Assertions.assertThrows(DifferentCurrenciesException.class, () -> {
			customerBO.getCustomerProductsSum(products);
		});

//		@SuppressWarnings("unused")
//		Amount temp = null;
//
//		try {
//			temp = customerBO.getCustomerProductsSum(products);
//			fail("DifferentCurrenciesException is expected");
//		} catch (DifferentCurrenciesException e) {
//		}
	}

	@Test
	public void testCustomerProductSum_EmptyProducts() throws DifferentCurrenciesException {

//		List<Product> products = new ArrayList<Product>();

//		Amount temp = null;
		Amount actual = customerBO.getCustomerProductsSum(new ArrayList<Product>());
		Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);

//		temp = customerBO.getCustomerProductsSum(products);

		assertCurrency(expected, actual);
//		assertEquals(expected.getCurrency(), temp.getCurrency());
//		assertEquals(expected.getValue(), temp.getValue());
	}

}