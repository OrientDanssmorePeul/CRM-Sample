package com.example.crm.customer.service

import com.example.crm.customer.model.Customer
import com.example.crm.customer.repository.ICustomerRepository

open class CustomerServiceImpl(private val customerRepository: ICustomerRepository) : CustomerService {
    override fun createCustomer(customer: Customer): Customer {
        validateCustomer(customer)
        return customerRepository.create(customer)
    }

    override fun updateCustomer(customer: Customer): Customer {
        validateCustomer(customer)
        return customerRepository.update(customer)
    }

    override fun findCustomerById(id: String): Customer? {
        return customerRepository.findById(id)
    }

    override fun listCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    private fun validateCustomer(customer: Customer) {
        require(customer.id.isNotBlank()) { "Customer ID cannot be blank" }
        require(customer.name.isNotBlank()) { "Customer name cannot be blank" }
        require(customer.phone.isNotBlank()) { "Customer phone cannot be blank" }
        require(customer.email.isNotBlank()) { "Customer email cannot be blank" }
        require(customer.status != null) { "Customer status cannot be null" }
        require(customer.createdAt != null) { "Customer creation date cannot be null" }
    }
}
