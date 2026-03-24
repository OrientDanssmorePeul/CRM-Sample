package com.example.crm.customer.service

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus
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
        val data = customerRepository.findById(id)
        if(data != null){
            return data
        }else{
            throw IllegalArgumentException("No Customer Found")
        }
    }

    override fun listCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    override fun listActiveCustomers(): List<Customer> {
        return customerRepository.findActive()
    }

    private fun validateCustomer(customer: Customer) {

//        if(customer.status == CustomerStatus.INACTIVE){
//            throw IllegalArgumentException("Customer cannot be inactive")
//        }

//        val alreadyExist = findCustomerById(customer.id)
//        if(alreadyExist != null){
//            throw IllegalArgumentException("Customer already exist")
//        }


        require(customer.id.isNotBlank()) { "Customer ID cannot be blank" }
        require(customer.firstName.isNotBlank()) {"Lead firstName cannot be blank"}
        require(customer.lastName.isNotBlank()) {"Lead firstName cannot be blank"}
        require(customer.phone.isNotBlank()) { "Customer phone cannot be blank" }
        require(customer.email.isNotBlank()) { "Customer email cannot be blank" }
        require(customer.status != null) { "Customer status cannot be null" }
        require(customer.createdAt != null) { "Customer creation date cannot be null" }
    }

}
