package za.co.digitalplatoon.invoiceservice.invoice.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import za.co.digitalplatoon.invoiceservice.invoice.config.ApplicationConfiguration;
import za.co.digitalplatoon.invoiceservice.invoice.data.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class InvoiceServiceTest {
	
	@Autowired
	private InvoiceService invoiceService;

	@Test
	public void testAddInvoice() {
		List<Invoice> invoices = invoiceService.fetchAllInvoices();
		assertTrue ("Units failed to load", invoices!=null && invoices.size() > 1);
	}

	@Test
	public void testFetchInvoice() {
		Invoice invoice = invoiceService.fetchInvoice(1L);
		assertTrue ("Units failed to load", invoice!=null && invoice.getId() != null);
	}

	@Test
	public void testFetchAllInvoices() {
		List<Invoice> invoices = invoiceService.fetchAllInvoices();
		assertTrue ("Invoices failed to load", invoices!=null && invoices.size() > 0);
	}
}
