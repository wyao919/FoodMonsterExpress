package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Entity.Customer;
import Service.CustomerService;

@Component
public class CustomerConverter implements Converter<Integer, Customer>{
	
	@Autowired
	private CustomerService customerService;

	@Override
	public Customer convert(Integer id) {
		
		System.out.println("Customer Converter called************************************************");
		System.out.println("Customer Converter called************************************************");

		System.out.println("Customer Converter called************************************************");

		System.out.println("Customer Converter called************************************************");

		System.out.println("Customer Converter called************************************************");

		Customer customer = customerService.getCustomer(id);
		
		return customer;
	}

	

}
