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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private int id;
	@NotBlank(message = "Username can not be blank")
	@Size(min = 2, message = "Username must be at least 2 characters")
	@Column(name = "username")
	private String username;
	@NotBlank(message = "Password can't be blank")
	@Size(min = 5, message = "Password must be at least 5 Characters")
	@Column(name = "password")
	private String password;
	@Email
	@NotBlank(message = "Email can't be blank")
	@Column(name = "email")
	private String email;
	@Column(name = "roles")
	private String roles;
	@Column(name = "enabled")
	private int enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
	@Valid
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", roles=" + roles + ", enabled=" + enabled + ", customer=" + customer + "]";
	}

}
