package com.example.crm.customer.usecase

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.LostCustomer
import com.example.crm.customer.service.CustomerService
import com.example.crm.customer.service.LostCustomerService

class DeleteCustomerUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(id: String): LostCustomer? {
        return lostCustomerService.deleteLostCustomers(id)
    }
}
