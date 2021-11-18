package com.bilgeadam.aliergul.controller;

import com.bilgeadam.aliergul.dao.DaoCsvToPostgreSql;
import com.bilgeadam.aliergul.dao.ICsvProgress;

public class ControllerCSVTransfer implements ICsvProgress {
	private DaoCsvToPostgreSql dao;
	
	public ControllerCSVTransfer() {
		
		dao = new DaoCsvToPostgreSql();
	}
	
	@Override
	public boolean transferCsvoDatabase() {
		
		return dao.transferCsvoDatabase();
	}
	
	@Override
	public boolean isThereDatabase() {
		return dao.isThereDatabase();
	}
	
}
