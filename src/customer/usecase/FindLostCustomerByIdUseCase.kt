package com.example.crm.app.customer.usecase

import com.example.crm.customer.model.LostCustomer
import com.example.crm.app.customer.service.LostCustomerService

class FindLostCustomerByIdUseCase(private val lostCustomerService: LostCustomerService) {
    fun execute(id: String): LostCustomer? {
        return lostCustomerService.findLostCustomerById(id)
    }
}
