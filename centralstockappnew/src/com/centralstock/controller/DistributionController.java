package com.centralstock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.centralstock.model.Distribution;
import com.centralstock.model.DistributionList;
import com.centralstock.model.Item;
import com.centralstock.model.StockBill;
import com.centralstock.service.DistributionService;
import com.centralstock.service.ItemService;

@Controller
@RequestMapping("/stock")
public class DistributionController {

	private static final Logger log = Logger.getLogger(DistributionController.class);

	@Autowired(required = true)
	private DistributionService distributionService;

	@Autowired(required = true)
	private ItemService itemService;

	@RequestMapping(value = "/newDistribution")
	public String getNewDistribution() {
		return "cs_new_distribution";
	}

	@RequestMapping(value = "/viewDistributionIns")
	public String getViewDistribution() {
		return "cs_view_distribution";
	}

	@RequestMapping(value = "/saveDistribution")
	public ModelAndView saveDistribution(@ModelAttribute("distribution")
	Distribution distribution, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		log.info("Storing new Distribution is called");
		try {
			distributionService.insertDistribution(distribution);
		} catch (Exception e) {

			log.info(e);
		}
		model.put("didno", distribution.getDid());
		model.put("ins_name",distribution.getInsName());
		model.put("issuedDate",distribution.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		return new ModelAndView("cs_new_distribution_items", model);

	}

	@RequestMapping(value = "/saveDistributionItem")
	public ModelAndView saveDistributionList(@ModelAttribute("distributionItem")DistributionList distributionItem, BindingResult result) {
		Item item = new Item();
		item.setCategory(distributionItem.getCategory());
		item.setItemName(distributionItem.getItemName());
		item.setQuantity(distributionItem.getQuantity());
		item.setQuantity1(distributionItem.getQuantity());
		item.setUnits(distributionItem.getUnits());

		Map<String, Object> model = new HashMap<String, Object>();
		log.info("Storing new Distribution Items is called");
		try {

			distributionService.insertDistributionItems(distributionItem);
			itemService.deductEditItem(item);
		} catch (Exception e) {

			model.put("errorMessage", "Not Enough Stock To Issue Items... ");
			model.put("list", itemService.getItemList());
			model.put("list1", itemService.getItemList1());
			model.put("list2", itemService.getItemList2());
			model.put("didno", distributionItem.getDid());
			model.put("ins_name", distributionItem.getInsName());
			model.put("issuedDate",distributionItem.getIssuedDate());
	
			model.put("distList", distributionService.getAllDistributionList(distributionItem.getDid()));
	
		}
		model.put("didno", distributionItem.getDid());
		model.put("ins_name",distributionItem.getInsName());
		model.put("issuedDate",distributionItem.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("distList", distributionService.getAllDistributionList(distributionItem.getDid()));
		return new ModelAndView("cs_new_distribution_items", model);
	}

	
	@RequestMapping(value = "/saveDistributionItem1")
	public ModelAndView saveDistributionList1(
			@ModelAttribute("distributionItem")
			DistributionList distributionItem, BindingResult result) {

		Item item = new Item();

		item.setCategory(distributionItem.getCategory());
		item.setItemName(distributionItem.getItemName());
		item.setQuantity(distributionItem.getQuantity());
		item.setQuantity1(distributionItem.getQuantity());
		item.setUnits(distributionItem.getUnits());

		Map<String, Object> model = new HashMap<String, Object>();
		log.info("Storing new Distribution Items is called");
		try {

			distributionService.insertDistributionItems(distributionItem);
			itemService.deductEditItem(item);
		} catch (Exception e) {

			model.put("errorMessage", "Not Enough Stock To Issue Items... ");
			model.put("list", itemService.getItemList());
			model.put("list1", itemService.getItemList1());
			model.put("list2", itemService.getItemList2());
			model.put("didno", distributionItem.getDid());
			model.put("ins_name", distributionItem.getInsName());
			model.put("issuedDate",distributionItem.getIssuedDate());
	
			model.put("distList", distributionService
					.getAllDistributionList(distributionItem.getDid()));
	
		}
		model.put("didno", distributionItem.getDid());
		model.put("ins_name",distributionItem.getInsName());
		model.put("issuedDate",distributionItem.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("distList", distributionService
				.getAllDistributionList(distributionItem.getDid()));
		return new ModelAndView("cs_new_distribution_items", model);
	}
	
	
	
	
	@RequestMapping(value = "/searchDistribution")
	public ModelAndView searchDistributionList(@RequestParam("insName")
	String insName, @RequestParam("fromDate")
	String fromDate, @RequestParam("toDate")
	String toDate) {

		log.debug("ll" + insName + fromDate + toDate);
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("instName", insName);
		model.put("distAllList", distributionService.searchDistributionList(
				insName, fromDate, toDate));
		
		return new ModelAndView("cs_view_distribution", model);

	}

	@RequestMapping(value = "/viewDistributionPre")
	public ModelAndView getDistributionPreList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("distAllList", distributionService.getDistributionPreList());
		return new ModelAndView("cs_view_distributionPreview", model);
	}
	@RequestMapping(value = "/allDistributionList")
	public ModelAndView getAllDistributionList(@RequestParam("did")
	Integer did, @RequestParam("insName")
	String insName, @RequestParam("issuedDate")
	String issuedDate, @RequestParam("receivedperson")
	String receivedperson) {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("did", did);
		model.put("insName", insName);
		model.put("issuedDate", issuedDate);
		model.put("receivedperson", receivedperson);
		model.put("itemdistAllList", distributionService.getAllDistributionList(did));

		return new ModelAndView("itemDistributionList", model);

	}
	
	@RequestMapping(value = "/orgCurrentStock.html")
	public ModelAndView searchInstitutionStock(@RequestParam("organisation")String organisation , HttpServletRequest req) {

		log.debug("current stock in institution");
		Map<String, Object> model = new HashMap<String, Object>();

		/*model.put("distList", distributionService.getCurrentStock(organisation));*/
		
		req.setAttribute("fl", distributionService.getCurrentStock(organisation));
		return new ModelAndView("cs_view_currentStock", model);

	}
	
	@RequestMapping(value = "/orgCurrentStat.html")
	public ModelAndView searchInstitutionStock1(@RequestParam("organisation")String organisation , HttpServletRequest req) {
		log.debug("current stock in institution");
		Map<String, Object> model = new HashMap<String, Object>();

		/*model.put("distList", distributionService.getCurrentStock(organisation));*/
		
		req.setAttribute("fl", distributionService.getCurrentStat(organisation));
		return new ModelAndView("cs_view_currentStat", model);

	}
	
	@RequestMapping(value = "/orgCurrentClean.html")
	public ModelAndView searchInstitutionStocks(@RequestParam("organisation")String organisation , HttpServletRequest req) {

		log.debug("current stock in institution");
		Map<String, Object> model = new HashMap<String, Object>();

		/*model.put("distList", distributionService.getCurrentStock(organisation));*/
		
		req.setAttribute("fl", distributionService.getCurrentClean(organisation));
		return new ModelAndView("cs_view_currentClean", model);

	}
	
	

}