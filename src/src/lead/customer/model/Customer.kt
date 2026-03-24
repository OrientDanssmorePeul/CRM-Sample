package com.example.crm.customer.model

import java.time.LocalDateTime

enum class CustomerStatus {
    ACTIVE,
    INACTIVE,
    LOST
}

data class Customer(
    val id: String,
    val name: String,
    val phone: String,
    val email: String,
    val status: CustomerStatus,
    val createdAt: LocalDateTime,
    val isPremium: Boolean
)

data class LostCustomer(
    val customerId: String,
    val reasonLost: String,
    val lostDate: LocalDateTime,
    val notes: String
)


