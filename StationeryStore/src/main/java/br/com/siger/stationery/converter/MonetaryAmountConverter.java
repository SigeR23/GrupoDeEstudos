package br.com.siger.stationery.converter;

import java.math.BigDecimal;
import java.util.Optional;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryQuery;
import javax.persistence.AttributeConverter;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {
	private static final CurrencyUnit CURRENCY = Monetary.getCurrency("BRL");
	
	private static final MonetaryQuery<BigDecimal> EXTRACT_BIG_DECIMAL
			= (m) -> m.getNumber().numberValue(BigDecimal.class);
	@Override
	public BigDecimal convertToDatabaseColumn(MonetaryAmount attribute) {
		return Optional.ofNullable(attribute).orElse(FastMoney.zero(CURRENCY)).query(EXTRACT_BIG_DECIMAL);
	}

	@Override
	public MonetaryAmount convertToEntityAttribute(BigDecimal dbData) {
		return Money.of(dbData, CURRENCY);
	}

}
