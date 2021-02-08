package Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Orders {

	// order_id, menuItem_id, order Type, date, cus_id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;
	@Column(name = "order_type")
	private String orderType;
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cus_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "menuItem_id")
	private Menu menu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderType=" + orderType + ", date=" + date + ", customer=" + customer + ", menu="
				+ menu + "]";
	}

}
