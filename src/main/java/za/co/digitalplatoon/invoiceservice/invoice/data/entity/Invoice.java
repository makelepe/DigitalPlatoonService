package za.co.digitalplatoon.invoiceservice.invoice.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "invoice")
@XmlRootElement
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client")
    private String client;

    @Column(name = "vat_rate")
    private Integer vatRate = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "invoice_date")
    private Date invoiceDate = new Date();
    
    @OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="invoiceId")
    private List<LineItem> lineItems = new ArrayList<>();
    
    @Column(name = "sub_total")
    public BigDecimal subTotal = BigDecimal.ZERO; 

    @Column(name = "vat")
    public BigDecimal vat = BigDecimal.ZERO; 
    
    @Column(name = "total")
    public BigDecimal total = BigDecimal.ZERO; 

    public Invoice () {
    }

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		if (this.getLineItems()!=null) {
			this.getLineItems().forEach(lineItem -> {
					this.subTotal = this.subTotal.add(lineItem.getLineItemTotal());
				});
		}
		else {
			this.subTotal = BigDecimal.ZERO;
		}
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = (new BigDecimal(this.getVatRate())
				.divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP))
				.multiply(this.getSubTotal())
				.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = this.getSubTotal().add(this.getVat()).setScale(2, RoundingMode.HALF_UP);
	}    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getVatRate() {
		return vatRate;
	}

	public void setVatRate(Integer vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

}
