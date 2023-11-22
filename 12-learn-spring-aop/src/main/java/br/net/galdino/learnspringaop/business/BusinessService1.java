package br.net.galdino.learnspringaop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.net.galdino.learnspringaop.annotations.TrackTime;
import br.net.galdino.learnspringaop.data.DataService1;

@Service
public class BusinessService1 {
	
	private DataService1 dataService;
	
	public BusinessService1(DataService1 dataService) {
		this.dataService = dataService;
	}
	
	@TrackTime
	public int calculateMax() {
		int[] data = dataService.retrieveData();
		return Arrays.stream(data).max().orElse(0);
	}

}
