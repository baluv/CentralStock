package com.centralstock.controller;
import java.awt.List;
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

import com.centralstock.model.Item;
import com.centralstock.model.StockBill;
import com.centralstock.model.StockItems;
import com.centralstock.service.ItemService;
import com.centralstock.service.StockItemService;

@Controller
@RequestMapping("/stock")
public class MainController {
	private static final Logger log = Logger.getLogger(MainController.class);
	
	@Autowired(required = true)
	private ItemService itemService;

	@Autowired(required = true)
	private StockItemService stockItemService;

	@RequestMapping(value = "/home")
	public String getHome() {
		log.info("home");
		return "home";
	}

	@RequestMapping(value = "/include")
	public String getIncludePage() {
		return "include";
	}

	@RequestMapping(value = "/newStock")
	public String getNewStock() {
		return "cs_new_stock_bill";
	}

	 //here New Items will be saved in stock table 
	@RequestMapping(value = "/save")
	public ModelAndView saveItem(@ModelAttribute("item")Item item, BindingResult result) {
		
		Item newitem = new Item();
		newitem.setCategory(item.getCategory());
		newitem.setItemName(item.getItemName());
		newitem.setQuantity(item.getQuantity());
		newitem.setQuantity1(item.getQuantity());
		newitem.setUnits(item.getUnits());
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			itemService.saveItem(newitem);
		} catch (Exception e) {
			model.put("errorMessage", "Item Already Existed!!!!");
			model.put("list", itemService.getItemList());
			return new ModelAndView("cs_add_item", model);

		}
		model.put("message", "Item Saved successfully");
		model.put("list", itemService.getItemList());
		return new ModelAndView("cs_add_item", model);
	}

	@RequestMapping(value = "/addItem")
	public ModelAndView getAddItem() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("list", itemService.getItemList());
		log.info("add item");
		return new ModelAndView("cs_add_item", model);

	}

	@RequestMapping(value = "/saveStockBill")
	public ModelAndView getNewStockItBill(@ModelAttribute("stockBill")
	StockBill stockBill,String string,List list1, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		log.info("Storing new stockBill is called");
		try {
			stockItemService.insertStockBill(stockBill);
		} catch (Exception e) {
			log.info(e);
		}
		model.put("invoiceNumber", stockBill.getInvoiceNumber());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("s", itemService.getItemListSta());
		model.put("c", itemService.getItemListCle());
		return new ModelAndView("cs_new_stock_item", model);
	}

	@RequestMapping(value = "/cs_new_stock_item")
	public String getNewStocKItem() {

		return "cs_new_stock_item";

	}

	@RequestMapping(value = "/saveStockItems")
	public ModelAndView getNewStockItems(@ModelAttribute("stockItems")
	StockItems stockItems, BindingResult result) {

		Item item = new Item();

		item.setCategory(stockItems.getCategory());
		item.setItemName(stockItems.getItemName());
		item.setQuantity(stockItems.getQuantity());
		item.setQuantity1(stockItems.getQuantity());
		item.setUnits(stockItems.getUnits());
		log.info("Storing new stock is called");
		try {

			stockItemService.insertStockItems(stockItems);
			itemService.updateItem(item);

		} catch (Exception e) {
			log.debug(e);
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("invoiceNumber", stockItems.getInvoiceNumber());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("stockList", stockItemService.getStockItems(stockItems.getInvoiceNumber()));
		return new ModelAndView("cs_new_stock_item", model);
	}
	
	@RequestMapping(value = "/saveStockItems1")
	public ModelAndView getNewStockItems1(@ModelAttribute("stockItems")
	StockItems stockItems, BindingResult result) {
		Item item = new Item();
		item.setCategory(stockItems.getCategory());
		item.setItemName(stockItems.getItemName());
		item.setQuantity(stockItems.getQuantity());
		item.setQuantity1(stockItems.getQuantity());
		item.setUnits(stockItems.getUnits());
		log.info("Storing new stock is called");
		try {
			stockItemService.insertStockItems(stockItems);
			itemService.updateItem(item);

		} catch (Exception e) {
			log.debug(e);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("invoiceNumber", stockItems.getInvoiceNumber());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("stockList", stockItemService.getStockItems(stockItems.getInvoiceNumber()));
		return new ModelAndView("cs_new_stock_item", model);
	}
	
	@RequestMapping(value = "/editStockItems")
	public ModelAndView editNewStockItems(@RequestParam("sno")
	Integer sno, @RequestParam("invoiceNumber")
	String invoiceNumber, @RequestParam("category")
	String category, @RequestParam("itemName")
	String itemName, @RequestParam("quantity")
	double quantity, @RequestParam("units")
	String units) {
		Map<String, Object> model = new HashMap<String, Object>();
		Item item = new Item();
		item.setCategory(category);
		item.setItemName(itemName);
		item.setQuantity(quantity);
		item.setQuantity1(quantity);
		item.setUnits(units);
		try {
			itemService.deductEditItem(item);
			model.put("editstock", stockItemService.editStockItems(sno,invoiceNumber));
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		return new ModelAndView("cs_edit_stock", model);
	}
	
	@RequestMapping(value = "/deleteStockItems")
	public ModelAndView deleteNewStockItems(@RequestParam("sno")
	Integer sno, @RequestParam("invoiceNumber")
	String invoiceNumber, @RequestParam("category")
	String category, @RequestParam("itemName")
	String itemName, @RequestParam("quantity")
	double quantity, @RequestParam("units")
	String units) {
		Map<String, Object> model = new HashMap<String, Object>();
		Item item = new Item();
		item.setCategory(category);
		item.setItemName(itemName);
		item.setQuantity(quantity);
		item.setQuantity1(quantity);
		item.setUnits(units);
		try {
			itemService.deductEditItem(item);
			stockItemService.deleteStockItem(sno, invoiceNumber);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("invoiceNumber", invoiceNumber);
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("stockList", stockItemService.getStockItems(invoiceNumber));
		return new ModelAndView("cs_new_stock_item", model);
	}

	@RequestMapping(value = "/viewStock")
	public ModelAndView getViewStockDetails() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("list", itemService.getItemList());
		// log.info("add item");
		return new ModelAndView("cs_view_stock", model);
	}

	@RequestMapping(value = "/search")
	public ModelAndView searchItem(@ModelAttribute("itemSearch")
	StockItems stockItems, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (stockItems.getInvoiceNumber().equals("")) {
			model.put("itemlist", itemService.getAllItemList(stockItems.getItemName()));
		}
		else {
			model.put("stockbill", stockItemService.getStockBill(stockItems.getInvoiceNumber()));
			model.put("stockItems", stockItemService.getStockItems(stockItems.getInvoiceNumber()));
		}
		model.put("list", itemService.getItemList());
		return new ModelAndView("cs_view_stock", model);
	}

	@RequestMapping(value = "/updateStockItems")
	public ModelAndView updateStockDetails(@ModelAttribute("stockItems")
	StockItems stockItems, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		Item item = new Item();
		item.setCategory(stockItems.getCategory());
		item.setItemName(stockItems.getItemName());
		item.setQuantity(stockItems.getQuantity());
		item.setQuantity1(stockItems.getQuantity());
		item.setUnits(stockItems.getUnits());
		log.info("Storing new stock is called");
		try {
			stockItemService.updateStockItems(stockItems.getQuantity(),stockItems.getAmount(), stockItems.getInvoiceNumber(),stockItems.getSno());
			itemService.updateItem(item);
		} catch (Exception e) {
			log.debug(e);
		}
		model.put("invoiceNumber", stockItems.getInvoiceNumber());
		model.put("list", itemService.getItemList());
		model.put("list1", itemService.getItemList1());
		model.put("list2", itemService.getItemList2());
		model.put("stockList", stockItemService.getStockItems(stockItems.getInvoiceNumber()));
		return new ModelAndView("cs_new_stock_item", model);
	}
	
	@Controller
	@RequestMapping(value="/foo") 
	public class Foo  
	{  
	    public void foo(@RequestParam("category") String value)  
	    {
	        System.out.println("SATYA SOlutions");
	    }  
	}  
}
