package com.evosoft.javasetraining.webshop.service;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.evosoft.javasetraining.webshop.model.CurrencyTypes;
import com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap;
import com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoapProxy;

@Service
public class DefaultExchangeService implements ExchangeService {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private MNBArfolyamServiceSoap s = new MNBArfolyamServiceSoapProxy();

	private Logger log = LoggerFactory.getLogger(DefaultExchangeService.class);

	public Double exchangeHufToEur(Double amountInHuf) {

		Double currentExchangeRate = getCurrentExchangeRateOfCurrencies(CurrencyTypes.HUF.name(),
				CurrencyTypes.EUR.name());

		Double result = amountInHuf / currentExchangeRate;

		log.info(amountInHuf + " amount in HUF is " + result + " amount in EUR");

		return result;
	}

	private Double getCurrentExchangeRateOfCurrencies(String fromCurrency, String toCurrency) {

		Calendar cal = Calendar.getInstance();

		if (Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK) || Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {

			cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}

		String lastBankDay = DATE_FORMAT.format(cal.getTime());
		Double exchangeRate = null;

		String rate;
		try {
			rate = s.getExchangeRates(lastBankDay, lastBankDay,
					fromCurrency.toUpperCase() + "," + toCurrency.toUpperCase());

			log.info("Current exchange rate: " + rate);

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(rate.getBytes("utf-8"))));

			exchangeRate = Double.valueOf(doc.getDocumentElement().getTextContent().replaceAll(",", "."));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return exchangeRate;
	}

}
