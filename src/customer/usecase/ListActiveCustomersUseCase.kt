package com.example.crm.customer.usecase

import com.example.crm.customer.model.Customer
import com.example.crm.customer.service.CustomerService

class ListActiveCustomersUseCase(private val customerService: CustomerService) {
    fun execute(): List<Customer> {
        return customerService.listActiveCustomers()
    }
}
