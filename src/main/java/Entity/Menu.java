package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menuItem_id")
	private int id;
	@NotBlank(message = "Please enter a Item")
	@Column(name = "item")
	private String item;
	@Min(value = 1, message = "Price must be greater than 0")
	@Column(name = "price")
	private double price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detail_id")
	@Valid private MenuDetail menuDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuDetail getMenuDetail() {
		return menuDetail;
	}

	public void setMenuDetail(MenuDetail menuDetail) {
		this.menuDetail = menuDetail;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", item=" + item + ", price=" + price + ", menuDetail=" + menuDetail + "]";
	}

}
