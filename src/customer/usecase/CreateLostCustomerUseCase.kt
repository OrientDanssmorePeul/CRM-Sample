package com.example.crm.app.customer.usecase

import com.example.crm.customer.model.LostCustomer
import com.example.crm.app.customer.service.LostCustomerService

class CreateLostCustomerUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(customer: LostCustomer): LostCustomer {
        return lostCustomerService.createLostCustomer(customer)
    }
}
