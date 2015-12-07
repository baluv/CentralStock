package com.centralstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.dao.ConsumptionDao;
import com.centralstock.dao.DistributionDao;
import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.exception.CentralStockServiceException;
import com.centralstock.model.Consumption;
import com.centralstock.model.ConsumptionDTO;
import com.centralstock.model.ConsumptionList;


@Service("ConsumptionService")
@Transactional
public class ConsumptionServiceImpl implements ConsumptionService {
	
	@Autowired(required = true)
	private ConsumptionDao consumptionDao;

	
	public void insertConsumption(Consumption consumption)throws CentralStockServiceException {

		try {
			consumptionDao.insertConsumption(consumption);
		} catch (CentralStockDAOException se) {

			throw new CentralStockServiceException(se + "");
		}
	}
	
	public void insertConsumptionItems(ConsumptionList consumptionList)throws CentralStockServiceException{
		
		try {
			consumptionDao.insertConsumptionItems(consumptionList);
		} catch (CentralStockDAOException se) {

			throw new CentralStockServiceException(se + "");
		}
	}
	
	public List<ConsumptionList> getConsumptionList(int cid) {
		
		return consumptionDao.getConsumptionList(cid);
	}
	
	public List<ConsumptionDTO>  getConsumedItems(String insName,
			String fromDate, String toDate){
		return consumptionDao.getConsumedItems(insName, fromDate, toDate);
	}

}
