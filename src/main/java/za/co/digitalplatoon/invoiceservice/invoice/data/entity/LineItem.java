package za.co.digitalplatoon.invoiceservice.invoice.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "line_item")
@XmlRootElement
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;
 
    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice = BigDecimal.ZERO;
    
    @Column(name = "line_item_total")
    public BigDecimal lineItemTotal = BigDecimal.ZERO; 
    
    @Column(name = "invoice_id")
    private Long invoiceId;

    
    public LineItem () {
    }
    
	public BigDecimal getLineItemTotal() {
		return lineItemTotal;
	}

	public void setLineItemTotal(BigDecimal lineItemTotal) {
		this.lineItemTotal = this.getUnitPrice().setScale(2, RoundingMode.HALF_UP)
							.multiply(new BigDecimal(this.getQuantity()))
							.setScale(2, RoundingMode.HALF_UP);
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

}
