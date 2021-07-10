package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

import java.math.BigDecimal;
import java.util.List;

public class MyCustomerBOImplRefactor implements CustomerBO {

	@Override
	public Amount getCustomerProductsSum(List<Product> products) throws DifferentCurrenciesException {
		BigDecimal result = BigDecimal.ZERO;
		// SHIFT + F6 to rename (and for all occurrences)
		if (products.size() == 0) return new AmountImpl(result, Currency.EURO);

		// Throw Exception If Any of the product has a currency different from
		// the first product
		result = getSum(products, result, products.get(0).getAmount().getCurrency());

		// Calculate Sum of Products
//		for (Product product : products) {
//			result = result.add(product.getAmount().getValue());
//		}
		
		// Create new product
		return new AmountImpl(result, products.get(0).getAmount().getCurrency());
	}

	private BigDecimal getSum(List<Product> products, BigDecimal temp, Currency firstProductCurrency) throws DifferentCurrenciesException {
		for (Product product : products) {
			// do all of the products have the same currency
			boolean currencySameAsFirstProduct = product.getAmount().getCurrency().equals(firstProductCurrency);
			if (currencySameAsFirstProduct) {
				temp = temp.add(product.getAmount().getValue());
			}
			// Calculate Sum of Products

		}
		return temp;

		// even shorter way could be to do something like
//		return products.stream().map(product ->
//			product.getAmount().getValue()
//		).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}