package br.net.galdino.learnspringaop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.net.galdino.learnspringaop.data.DataService2;

@Service
public class BusinessService2 {
	
	private DataService2 dataService;
	
	public BusinessService2(DataService2 dataService) {
		this.dataService = dataService;
	}
	
	public int calculateMin() {
		int[] data = dataService.retrieveData();
		return Arrays.stream(data).min().orElse(0);
	}

}
