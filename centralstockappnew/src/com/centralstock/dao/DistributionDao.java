package com.centralstock.dao;

import java.util.List;

import com.centralstock.model.Distribution;
import com.centralstock.model.DistributionList;
import com.centralstock.model.DistributionListDTO;

public interface DistributionDao {
	
	public void insertDistribution(Distribution distribution);
	public void insertDistributionItems(DistributionList distributionList);
	public List<DistributionList> getAllDistributionList(int did);
	public List<DistributionListDTO> searchDistributionList(String insName,String fromDate,String toDate);
	public List<Distribution> getDistributionPreList();
	public List<DistributionList> getCurrentStock(String organisation);
	public List<DistributionList> getCurrentStat(String organisation);
	public List<DistributionList> getCurrentClean(String organisation);
}
