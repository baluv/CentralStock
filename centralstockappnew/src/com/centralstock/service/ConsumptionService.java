package com.centralstock.service;

import java.util.List;

import com.centralstock.model.Consumption;
import com.centralstock.model.ConsumptionDTO;
import com.centralstock.model.ConsumptionList;

public interface ConsumptionService {
	public void insertConsumption(Consumption consumption);
	public void insertConsumptionItems(ConsumptionList consumptionList);
	public List<ConsumptionList> getConsumptionList(int cid);
	public List<ConsumptionDTO>  getConsumedItems(String insName,
			String fromDate, String toDate);

}
