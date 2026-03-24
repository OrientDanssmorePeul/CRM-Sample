package com.example.crm.customer.repository

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap

class PremiumInMemoryCustomerRepository : ICustomerRepository {
    private val customers = ConcurrentHashMap<String, Customer>()

    override fun create(customer: Customer): Customer {
        customers[customer.id] = customer
        return customer
    }

    override fun update(customer: Customer): Customer {
        val updated = customer.copy(
            firstName = "UpdatedJane",
        )
        customers[customer.id] = updated
        println(customers[customer.id])
        return updated
    }

    override fun findById(id: String): Customer? {
        return customers[id]
    }

    override fun findAll(): List<Customer> {
        return customers.values.filter { it.isPremium }
    }

    override fun findActive(): List<Customer> {
        return customers.values.filter { it.status == CustomerStatus.ACTIVE && it.isPremium }
    }
}
