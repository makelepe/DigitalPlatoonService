package za.co.digitalplatoon.invoiceservice.invoice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.invoiceservice.invoice.data.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.data.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.data.repo.InvoiceRepo;
import za.co.digitalplatoon.invoiceservice.invoice.data.repo.LineItemRepo;

/**
 * This service class is responsible for fetching and processing data from database.
 * 
 * @author Samuel Radingwane <mailto: makelepe1@gmail.com>
 * @since 2018-06-29
 */

@Service
public class InvoiceService {
	private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);
	 
	@Autowired
	private InvoiceRepo invoiceRepo;
	
	@Autowired
	private LineItemRepo lineItemRepo;
	
	/**
	 * 	save invoice to database.  
	 */
	public Invoice addInvoice(Invoice invoice) {
		if (invoice!=null){
			invoiceRepo.save(invoice);
			/** 
			 * item's invoiceId are NULLs after commit
			 * this seems to be a bug in spring-boot and bi-directional mapping  */
			if (invoice.getLineItems().size() > 0) {
				for (LineItem item : invoice.getLineItems()) {
					item.setInvoiceId(invoice.getId());
					lineItemRepo.save(item);
				}
			}
			log.debug("saved invoice ("+invoice.getId()+") to database!");
		}
		return invoice;
	}
	
	/**
	 * 	fetch invoice by ID from database.  
	 */
	public Invoice fetchInvoice(Long invoiceId) {
		Optional<Invoice> opt = invoiceRepo.findById(invoiceId);
		
		Invoice invoice = null;
		if (opt.isPresent()) {
			invoice = opt.get();
			log.info("Invoice["+ invoice.getId() +"] fetched!");
		}
		
		return invoice;
	}

	/**
	 * fetches all available invoices from database
	 */
	public List<Invoice> fetchAllInvoices () {
		List<Invoice> invoices = invoiceRepo.findAll();
		if (invoices!=null){
			log.info("Invoices[size="+invoices.size()+"] retrieved");
		}
		return invoices;
	}

}
