package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import Validator.PhoneValidation;

@Entity
@Table(name = "customer")
public class Customer {

	// cus_id, cus_name, cus_phone
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private Integer customerId;
	@Column(name = "cus_name")
	@NotBlank(message = "Please enter a Valid name")
	@Size(min = 3, message = "must be at least 3 characters")
	private String name;
	@Size(min = 10, max = 10, message = "Please enter a 10 digit phone number")
	@PhoneValidation(message = "Please enter a valid phone number, use Digits only")
	@Column(name = "cus_phone")
	private String phoneNumber;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
