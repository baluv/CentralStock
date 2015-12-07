package com.centralstock.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.centralstock.model.Item;
import com.centralstock.model.OrderedItems;
import com.centralstock.model.PurchaseOrders;
import com.centralstock.model.RequestOrder;
import com.centralstock.model.RequestOrderedItem;
import com.centralstock.service.ItemService;
import com.centralstock.service.RequestOrderService;

@Controller
@RequestMapping("/stock")
public class RequestOrderController {

	private static final Logger log = Logger.getLogger(RequestOrderController.class);

	@Autowired(required = true)
	private RequestOrderService requestOrderService;

	@Autowired(required = true)
	private ItemService itemService;

	@RequestMapping(value = "/newRequestOrder")
	public String getLogin() {
		return "cs_new_request_order";
	}

	@RequestMapping(value = "/viewPurchaseDetails")
	public ModelAndView getViewPurchaseDetails() {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("orderList", requestOrderService.getRequestOrerPreDetails());

		return new ModelAndView("cs_view_purchaseorder", model);
	}

	@RequestMapping(value = "/ins_home")
	public String getInsHome() {

		return "ins_home";
	}

	@RequestMapping(value = "/saveRequestOrder")
	public ModelAndView getRequestOrder(@ModelAttribute("requestOrder")
	RequestOrder requestOrder, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			requestOrderService.insertRequestOrder(requestOrder);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("ridno", requestOrder.getRid());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		return new ModelAndView("cs_new_request_order_details", model);
	}

	@RequestMapping(value = "/saveRquestOrderedItems")
	public String getRequestOrderList(@ModelAttribute("orderedItems")
	RequestOrderedItem orderedItems, ModelMap model) {

		OrderedItems oi = new OrderedItems();

		oi.setRid(orderedItems.getRid());
		oi.setSno(orderedItems.getSno());
		oi.setCategory(orderedItems.getCategory());
		oi.setItemName(orderedItems.getItemName());
		oi.setQuantity(orderedItems.getQuantity());
		oi.setUnits(orderedItems.getUnits());

		try {

			requestOrderService.insertRequestOdererItems(orderedItems);
			requestOrderService.insertOrderedItems(oi);

		} catch (Exception e) {

			log.debug(e);
		}

		model.put("ridno", orderedItems.getRid());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("orderList", requestOrderService
				.getRequestOrderItemList(orderedItems.getRid()));

		return "cs_new_request_order_details";
	}
	
	
	@RequestMapping(value = "/saveRquestOrderedItems1")
	public String getRequestOrderList1(@ModelAttribute("orderedItems")
	RequestOrderedItem orderedItems, ModelMap model) {

		OrderedItems oi = new OrderedItems();

		oi.setRid(orderedItems.getRid());
		oi.setSno(orderedItems.getSno());
		oi.setCategory(orderedItems.getCategory());
		oi.setItemName(orderedItems.getItemName());
		oi.setQuantity(orderedItems.getQuantity());
		oi.setUnits(orderedItems.getUnits());

		try {

			requestOrderService.insertRequestOdererItems(orderedItems);
			requestOrderService.insertOrderedItems(oi);

		} catch (Exception e) {

			log.debug(e);
		}

		model.put("ridno", orderedItems.getRid());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("orderList", requestOrderService
				.getRequestOrderItemList(orderedItems.getRid()));

		return "cs_new_request_order_details";
	}
	
	
	

	@RequestMapping(value = "/viewPurchaseIns")
	public String getViewPurchasePre() {

		return "cs_view_purchaseIns";
	}

	@RequestMapping(value = "/saveOrderedItemsExcelFormate")
	public ModelAndView saveOrderedItemsExcel(@RequestParam("rid")
	Integer rid, @RequestParam("insName")
	String insName, @RequestParam("orderedDate")
	String orderedDate, @RequestParam("orderedPerson")
	String orderedPerson) {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rid", rid);
		model.put("insName", insName);
		model.put("orderedDate", orderedDate);
		model.put("orderedPerson", orderedPerson);
		model.put("requestOrderList", requestOrderService
				.getRequestOrderItemList(rid));

		return new ModelAndView("orderedListReport", model);

	}
	@RequestMapping(value = "/requestOrderList")
	public ModelAndView getAllDistributionList(@RequestParam("rid")
	Integer rid, @RequestParam("insName")
	String insName, @RequestParam("orderedDate")
	String orderedDate, @RequestParam("orderedPerson")
	String orderedPerson) {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rid", rid);
		model.put("insName", insName);
		model.put("orderedDate", orderedDate);
		model.put("orderedPerson", orderedPerson);
		model.put("requestOrderList", requestOrderService.getRequestOrderItemList(rid));

		return new ModelAndView("orderedItemList", model);

	}

	@RequestMapping(value = "/searchRequestedOrders")
	public ModelAndView searchDistributionList(@RequestParam("insName") String insName) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("insName", insName);
		model.put("rquestedOrderList", requestOrderService.getRequestOrderList(insName));
		return new ModelAndView("cs_view_purchaseIns", model);

	}

	@RequestMapping(value = "/confirmPurchaseDetails")
	public ModelAndView getConfirmPurchaseDetails() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orderList", requestOrderService.getRequestOrerPreDetails());
		return new ModelAndView("cs_confirm_purchaseOrders", model);
	}

	@RequestMapping(value = "/viewPreConfirmStockItemsDetails")
	public ModelAndView confirmPreStockItems(@RequestParam("rid")
	Integer rid, @RequestParam("insName")
	String insName, @RequestParam("orderedDate")
	String orderedDate, @RequestParam("orderedPerson")
	String orderedPerson) {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rid", rid);
		model.put("insName", insName);
		model.put("orderedDate", orderedDate);
		model.put("orderedPerson", orderedPerson);
		model.put("requestOrderList", requestOrderService.getOrderedItems(rid));

		return new ModelAndView("cs_view_preconfirmStock", model);

	}

	@RequestMapping(value = "/confirmedOrderedItems")
	public ModelAndView confirmedStockItems(@RequestParam("rid")
	Integer rid, @RequestParam("insName")
	String insName, @RequestParam("orderedDate")
	String orderedDate, @RequestParam("orderedPerson")
	String orderedPerson, @RequestParam("sno")
	Integer sno, @RequestParam("category")
	String category, @RequestParam("itemName")
	String itemName, @RequestParam("quantity")
	double quantity, @RequestParam("units")
	String units) {

		PurchaseOrders purchaseOrders = new PurchaseOrders();
		purchaseOrders.setRid(rid);
		purchaseOrders.setSno(sno);
		purchaseOrders.setCategory(category);
		purchaseOrders.setItemName(itemName);
		purchaseOrders.setQuantity(quantity);
		purchaseOrders.setUnits(units);
		
		Item item = new Item();
		
		item.setCategory(category);
		item.setItemName(itemName);
		item.setQuantity(quantity);
		item.setQuantity1(quantity);
		item.setUnits(units);
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		try{
				
			requestOrderService.insertPurchaseOrderItems(purchaseOrders);
			
			
		}catch(Exception e){
			
			model.put("StockMessage", "Requested Stock Is Available");
			
		}
		
		itemService.updateItemOfOrderes(item);
		requestOrderService.deletOrderedItems(rid, sno);
		model.put("rid", rid);
		model.put("insName", insName);
		model.put("orderedDate", orderedDate);
		model.put("orderedPerson", orderedPerson);
		model.put("requestOrderList", requestOrderService.getOrderedItems(rid));
		model.put("purchaseList",requestOrderService.getPurchaseOrderList(rid) );
		

		return new ModelAndView("cs_view_preconfirmStock", model);

	}
	
	@RequestMapping(value = "/saveExcelFormate")
	public ModelAndView savePurchaseOrdersExcelFormate(@RequestParam("rid")
	Integer rid, @RequestParam("insName")
	String insName, @RequestParam("orderedDate")
	String orderedDate, @RequestParam("orderedPerson")
	String orderedPerson) {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rid", rid);
		model.put("insName", insName);
		model.put("orderedDate", orderedDate);
		model.put("orderedPerson", orderedPerson);
		model.put("purchaseList",requestOrderService.getPurchaseOrderList(rid) );

		return new ModelAndView("purchaseOrderReport", model);

	}
	
		

	
	
	

}
