package com.centralstock.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.centralstock.model.Consumption;
import com.centralstock.model.ConsumptionList;
import com.centralstock.model.Distribution;
import com.centralstock.service.ConsumptionService;
import com.centralstock.service.ItemService;

@Controller
@RequestMapping("/stock")
public class ConsumptionController {

	private static final Logger log = Logger.getLogger(ConsumptionController.class);

	@Autowired(required = true)
	ConsumptionService consumptionService;

	@Autowired(required = true)
	private ItemService itemService;

	@RequestMapping(value = "/newConsumption")
	public String getNewConsumption() {
		return "cs_consumption_entry_details";
	}

	@RequestMapping(value = "/saveConsumptionDetails")
	public ModelAndView saveConsumptionDetails(@ModelAttribute("consumption") Consumption consumption, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			consumptionService.insertConsumption(consumption);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("cidno", consumption.getCid());
		model.put("insName", consumption.getInsName());
		model.put("issuedDate",consumption.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		return new ModelAndView("cs_consumption_entry_items", model);
	}

	@RequestMapping(value = "/saveConsumptionItems")
	public ModelAndView saveConsumptionItems(@ModelAttribute("consumptionList") ConsumptionList consumptionList, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			consumptionService.insertConsumptionItems(consumptionList);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("cidno", consumptionList.getCid());
		model.put("insName", consumptionList.getInsName());
		model.put("issuedDate", consumptionList.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("consumedList", consumptionService.getConsumptionList(consumptionList.getCid()));
		return new ModelAndView("cs_consumption_entry_items", model);
	}
	
	@RequestMapping(value = "/saveConsumptionItems1")
	public ModelAndView saveConsumptionItems1(@ModelAttribute("consumptionList") ConsumptionList consumptionList, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			consumptionService.insertConsumptionItems(consumptionList);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("cidno", consumptionList.getCid());
		model.put("insName", consumptionList.getInsName());
		model.put("issuedDate", consumptionList.getIssuedDate());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("consumedList", consumptionService.getConsumptionList(consumptionList.getCid()));
		return new ModelAndView("cs_consumption_entry_items", model);
	}

	@RequestMapping(value = "/viewConsumption")
	public String getViewConsumption() {
		return "cs_view_consumption";
	}

	@RequestMapping(value = "/searchConsumption")
	public ModelAndView searchDistributionList(@RequestParam("insName")String insName, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
		log.debug("ll" + insName + fromDate + toDate);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("instName", insName);
		model.put("consumedAllList", consumptionService.getConsumedItems(insName, fromDate, toDate));
		return new ModelAndView("cs_view_consumption", model);
	}

	@RequestMapping(value = "/viewConsumption1")
	public String getViewConsumption1() {
		return "cs_view_consumption1";
	}
	
	@RequestMapping(value = "/searchConsumption1")
	public ModelAndView searchDistributionList1(@RequestParam("insName")String insName, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
		log.debug("ll" + insName + fromDate + toDate);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("instName", insName);
		model.put("consumedAllList", consumptionService.getConsumedItems(insName, fromDate, toDate));
		return new ModelAndView("cs_view_consumption1", model);
	}
}
