package com.novatech.learnspringframework.businesscalculationservice;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5} ;
	}

}
