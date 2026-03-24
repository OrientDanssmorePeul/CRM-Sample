package com.example.crm.customer.repository

import com.example.crm.customer.model.LostCustomer

interface ILostCustomerRepository {
    fun create(customer: LostCustomer): LostCustomer
    fun update(customer: LostCustomer): LostCustomer
    fun findById(id: String): LostCustomer?
    fun findAll(): List<LostCustomer>
    fun delete(id: String): LostCustomer?
}
