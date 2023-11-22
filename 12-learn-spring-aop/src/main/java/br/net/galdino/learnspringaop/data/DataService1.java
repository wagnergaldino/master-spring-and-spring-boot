package br.net.galdino.learnspringaop.data;

import org.springframework.stereotype.Repository;

import br.net.galdino.learnspringaop.annotations.TrackTime;

@Repository
public class DataService1 {
	
	@TrackTime
	public int[] retrieveData() {
		return new int[] {11, 22, 33, 44, 55};
	}

}
