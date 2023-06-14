package com.rhanem.customer.service;

import com.rhanem.clients.fraud.FraudCheckResponse;
import com.rhanem.clients.fraud.FraudClient;
import com.rhanem.customer.model.Customer;
import com.rhanem.customer.repository.CustomerRepository;
import com.rhanem.customer.web.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
/*        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );*/

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }

}
