package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot base application class to bootstrap the application
 * 
 * 
 * @author Samuel Radingwane <mailto: makelepe1@gmail.com>
 * @since 2018-06-29
 * 
 */

@SpringBootApplication (scanBasePackages = {"za.co.digitalplatoon.invoiceservice.invoice"})
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}
}
