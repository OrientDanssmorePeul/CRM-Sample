package com.example.crm.customer.service

import com.example.crm.app.Constants.CRMConstants
import com.example.crm.customer.model.Customer
import com.example.crm.customer.repository.ICustomerRepository

class PremiumCustomerServiceImpl(private val customerRepository: ICustomerRepository) : CustomerServiceImpl(customerRepository) {
    override fun createCustomer(customer: Customer): Customer {
        if (!customer.isPremium) {
            throw IllegalArgumentException("Premium Only")
        }
        return super.createCustomer(customer)
    }

    override fun updateCustomer(customer: Customer): Customer {
        validateCustomer(customer)
        if(!customer.isPremium){
            throw IllegalArgumentException("Premium Only")
        }
        return super.updateCustomer(customer)
    }

    override fun findCustomerById(id: String): Customer {
        val data = customerRepository.findById(id) ?: throw IllegalArgumentException("No Customer Found")
        if(!data.isPremium){
            throw IllegalArgumentException("Premium Only")
        }
        return data
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


        require(customer.id.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_ID_REQUIRED }
        require(customer.firstName.isNotBlank()) { CRMConstants.ERROR_FIRST_NAME_REQUIRED }
        require(customer.lastName.isNotBlank()) { CRMConstants.ERROR_LAST_NAME_REQUIRED }
        require(customer.phone.isNotBlank()) { CRMConstants.ERROR_PHONE_REQUIRED }
        require(customer.email.isNotBlank()) { CRMConstants.ERROR_EMAIL_REQUIRED }
        require(customer.status != null) { CRMConstants.ERROR_STATUS_REQUIRED }
        require(customer.createdAt != null) { CRMConstants.ERROR_CREATED_AT_REQUIRED }
    }

}
