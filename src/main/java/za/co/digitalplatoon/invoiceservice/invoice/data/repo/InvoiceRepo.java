package za.co.digitalplatoon.invoiceservice.invoice.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.digitalplatoon.invoiceservice.invoice.data.entity.Invoice;

/**
 * JPA Repository class to manage Invoice entity/table.
 * 
 * @author Samuel Radingwane <mailto: makelepe1@gmail.com>
 * @since 2018-06-29
 */

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

}
