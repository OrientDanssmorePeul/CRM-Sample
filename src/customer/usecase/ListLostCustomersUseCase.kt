package com.example.crm.app.customer.usecase

import com.example.crm.customer.model.LostCustomer
import com.example.crm.app.customer.service.LostCustomerService

class ListLostCustomersUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(): List<LostCustomer> {
        return lostCustomerService.listLostCustomers()
    }
}
