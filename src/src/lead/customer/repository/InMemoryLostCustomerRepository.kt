package com.example.crm.customer.repository

import com.example.crm.customer.model.LostCustomer
import java.util.concurrent.ConcurrentHashMap

class InMemoryLostCustomerRepository : ILostCustomerRepository {
    private val lostCustomers = ConcurrentHashMap<String, LostCustomer>()

    override fun create(customer: LostCustomer): LostCustomer {
        lostCustomers[customer.customerId] = customer
        return customer
    }

    override fun update(customer: LostCustomer): LostCustomer {
        lostCustomers[customer.customerId] = customer
        return customer
    }

    override fun findById(id: String): LostCustomer? {
        return lostCustomers[id]
    }

    override fun findAll(): List<LostCustomer> {
        return lostCustomers.values.toList()
    }

    override fun delete(id: String): LostCustomer? {
        return lostCustomers.remove(id)
    }
}
