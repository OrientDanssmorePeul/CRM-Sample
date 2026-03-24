package com.example.crm.customer.service

import com.example.crm.customer.model.CustomerStatus
import com.example.crm.customer.model.LostCustomer
import com.example.crm.customer.repository.ICustomerRepository
import com.example.crm.customer.repository.ILostCustomerRepository

open class LostCustomerServiceImpl(private val lostCustomerRepository: ILostCustomerRepository
,private val customerRepository: ICustomerRepository ) : LostCustomerService {
    override fun createLostCustomer(lostCustomer: LostCustomer): LostCustomer {
        val customer = customerRepository.findById(lostCustomer.customerId)

        if (customer == null){
            throw IllegalArgumentException("Not found")
        } else if (customer.status != CustomerStatus.LOST){
            throw IllegalArgumentException("Customer has to be lost status")
        }

        return lostCustomerRepository.create(lostCustomer)
    }

    override fun updateLostCustomer(customer: LostCustomer): LostCustomer {
        return lostCustomerRepository.update(customer)
    }

    override fun findLostCustomerById(id: String): LostCustomer? {
        return lostCustomerRepository.findById(id)
    }

    override fun listLostCustomers(): List<LostCustomer> {
        return lostCustomerRepository.findAll()
    }

    override fun deleteLostCustomers(id: String): LostCustomer? {
        return lostCustomerRepository.delete(id)
    }

//    private fun validateCustomer(customer: LostCustomer) {
//        require(customer.id.isNotBlank()) { "Customer ID cannot be blank" }
//        require(customer.name.isNotBlank()) { "Customer name cannot be blank" }
//        require(customer.phone.isNotBlank()) { "Customer phone cannot be blank" }
//        require(customer.email.isNotBlank()) { "Customer email cannot be blank" }
//        require(customer.status != null) { "Customer status cannot be null" }
//        require(customer.createdAt != null) { "Customer creation date cannot be null" }
//    }
}
