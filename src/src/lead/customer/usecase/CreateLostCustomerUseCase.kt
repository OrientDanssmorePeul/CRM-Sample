package com.example.crm.customer.usecase

import com.example.crm.customer.model.LostCustomer
import com.example.crm.customer.service.LostCustomerService

class CreateLostCustomerUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(customer: LostCustomer): LostCustomer {
        return lostCustomerService.createLostCustomer(customer)
    }
}
