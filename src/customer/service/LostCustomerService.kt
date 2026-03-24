package com.example.crm.app.customer.service

import com.example.crm.customer.model.LostCustomer

interface LostCustomerService {
    fun createLostCustomer(customer: LostCustomer): LostCustomer
    fun updateLostCustomer(customer: LostCustomer): LostCustomer
    fun findLostCustomerById(id: String): LostCustomer?
    fun listLostCustomers(): List<LostCustomer>
    fun deleteLostCustomers(id: String): LostCustomer?
}
