package com.example.crm.customer.usecase

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.LostCustomer
import com.example.crm.customer.service.CustomerService
import com.example.crm.customer.service.LostCustomerService

class ListLostCustomersUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(): List<LostCustomer> {
        return lostCustomerService.listLostCustomers()
    }
}
