package com.centralstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.dao.DistributionDao;
import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.exception.CentralStockServiceException;
import com.centralstock.model.Distribution;
import com.centralstock.model.DistributionList;
import com.centralstock.model.DistributionListDTO;

@Service("DistributionService")
@Transactional
public class DistributionServiceImpl implements DistributionService {

	@Autowired(required = true)
	private DistributionDao distributionDao;

	
	public void insertDistribution(Distribution distribution)
			throws CentralStockServiceException {

		try {
			distributionDao.insertDistribution(distribution);
		} catch (CentralStockDAOException se) {

			throw new CentralStockServiceException(se + "");
		}
	}
	public void insertDistributionItems(DistributionList distributionList)throws CentralStockServiceException {

		try {
			distributionDao.insertDistributionItems(distributionList);
		} catch (CentralStockDAOException se) {

			throw new CentralStockServiceException(se + "");
		}
	}
	
	public List<DistributionList> getAllDistributionList(int did){
		
		return distributionDao.getAllDistributionList(did);
	}

	public List<DistributionListDTO> searchDistributionList(String insName,String fromDate,String toDate){
		
		return distributionDao.searchDistributionList(insName, fromDate, toDate);
	}
	
	public List<Distribution> getDistributionPreList(){
		
		return distributionDao.getDistributionPreList();
	}
	public List<DistributionList> getCurrentStock(String organisation)
	{
		return distributionDao.getCurrentStock(organisation);
	}
	
	public List<DistributionList> getCurrentStat(String organisation)
	{
		return distributionDao.getCurrentStat(organisation);
	}
	public List<DistributionList> getCurrentClean(String organisation)
	{
		return distributionDao.getCurrentClean(organisation);
	}
	}

