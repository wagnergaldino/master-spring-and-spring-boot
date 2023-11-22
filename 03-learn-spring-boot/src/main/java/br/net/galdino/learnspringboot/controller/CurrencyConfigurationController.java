package br.net.galdino.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.galdino.learnspringboot.configuration.CurrencyServiceConfiguration;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveConfiguration() {
		return configuration;
	}

}
