package vn.herta.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import vn.herta.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

@restcontroller
@EnableMethodSecurity
public class CustomerController {

	private final List<Customer> customers = List.of(
			Customer.builder().id("001").name("Tien Chinh").email("chinh@gmail.com").build(),
			Customer.builder().id("002").name("Tien Chinh 2").email("Chinh2@gmail.com").build());

	// Endpoint: /hello
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello is Guest");
	}

	// Endpoint: /customer/all (Chỉ ROLE_ADMIN được truy cập)
	@GetMapping("/customer/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Customer>> getCustomerList() {
		return ResponseEntity.ok(customers);
	}

	// Endpoint: /customer/{id} (Chỉ ROLE_USER được truy cập)
	@GetMapping("/customer/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
		return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
