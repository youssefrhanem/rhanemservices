package com.rhanem.customer.web;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
