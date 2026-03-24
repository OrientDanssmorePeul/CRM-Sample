package com.example.crm.customer.repository

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus

interface ICustomerRepository {
    fun create(customer: Customer): Customer
    fun update(customer: Customer): Customer
    fun findById(id: String): Customer?
    fun findAll(): List<Customer>
    fun findActive(): List<Customer>
}
