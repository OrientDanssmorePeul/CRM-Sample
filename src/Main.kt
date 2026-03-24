package com.example.crm.app

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus
import com.example.crm.customer.model.LostCustomer
import com.example.crm.customer.repository.InMemoryCustomerRepository
import com.example.crm.customer.repository.InMemoryLostCustomerRepository
import com.example.crm.customer.service.LostCustomerServiceImpl
import com.example.crm.customer.service.PremiumCustomerServiceImpl
import com.example.crm.customer.usecase.*
import com.example.crm.lead.model.Lead
import com.example.crm.lead.model.LeadStatus
import com.example.crm.lead.repository.InMemoryLeadRepository
import com.example.crm.lead.service.LeadServiceImpl
import com.example.crm.lead.usecase.AssignLeadUseCase
import com.example.crm.lead.usecase.CreateLeadUseCase
import com.example.crm.lead.usecase.ConvertLeadToCustomerUseCase
import com.example.crm.lead.usecase.ListLeadsUseCase
import java.time.LocalDateTime

fun main() {
    val customerRepository = InMemoryCustomerRepository()
    val customerService = PremiumCustomerServiceImpl(customerRepository)
    val createCustomerUseCase = CreateCustomerUseCase(customerService)
    val findCustomerByIdUseCase = FindCustomerByIdUseCase(customerService)
    val listCustomersUseCase = ListCustomersUseCase(customerService)

    val lostCustomerRepository = InMemoryLostCustomerRepository()
    val lostCustomerService = LostCustomerServiceImpl(lostCustomerRepository, customerRepository)
    val createLostCustomerUseCase = CreateLostCustomerUseCase(lostCustomerService)
    val updateLostCustomerUseCase = UpdateLostCustomerUseCase(lostCustomerService)
    val findLostCustomerByIdUseCase = FindLostCustomerByIdUseCase(lostCustomerService)
    val listLostCustomersUseCase = ListLostCustomersUseCase(lostCustomerService)
    val deleteLostCustomerUseCase = DeleteCustomerUseCase(lostCustomerService)


    val leadRepository = InMemoryLeadRepository()
    val leadService = LeadServiceImpl(leadRepository, customerRepository, customerService)
    val createLeadUseCase = CreateLeadUseCase(leadService)
    val assignLeadUseCase = AssignLeadUseCase(leadService)
    val convertLeadToCustomerUseCase = ConvertLeadToCustomerUseCase(leadService)
    val listLeadsUseCase = ListLeadsUseCase(leadService)

    // Create 3 leads
    val lead1 = Lead(
        id = "1",
        name = "Jane Doe",
        contactInfo = "jane.doe@example.com",
        source = "Referral",
        status = LeadStatus.NEW,
        assignedSalesperson = null,
        createdAt = LocalDateTime.now()
    )
    val createdLead1 = createLeadUseCase.execute(lead1)
    println("Created Lead 1: $createdLead1")

    val lead2 = Lead(
        id = "2",
        name = "Alice Johnson",
        contactInfo = "alice.johnson@example.com",
        source = "Email",
        status = LeadStatus.NEW,
        assignedSalesperson = null,
        createdAt = LocalDateTime.now()
    )
    val createdLead2 = createLeadUseCase.execute(lead2)
    println("Created Lead 2: $createdLead2")

    val lead3 = Lead(
        id = "3",
        name = "Bob Smith",
        contactInfo = "bob.smith@example.com",
        source = "Social Media",
        status = LeadStatus.NEW,
        assignedSalesperson = null,
        createdAt = LocalDateTime.now()
    )
    val createdLead3 = createLeadUseCase.execute(lead3)
    println("Created Lead 3: $createdLead3")

    // Assign one lead to a salesperson
    val assignedLead = assignLeadUseCase.execute("1", "salesperson1")
    println("Assigned Lead 1 to salesperson1: $assignedLead")

    // Convert one lead into a customer
    val convertedCustomer = convertLeadToCustomerUseCase.execute("1")
    println("Converted Lead 1 to Customer: $convertedCustomer")

    // Create 2 customers directly
    val customer1 = Customer(
        id = "4",
        name = "Charlie Brown",
        phone = "987-654-3210",
        email = "charlie.brown@example.com",
        status = CustomerStatus.LOST,
        createdAt = LocalDateTime.now(),
        isPremium = false
    )
    val createdCustomer1 = createCustomerUseCase.execute(customer1)
    println("Created Customer 1: $createdCustomer1")

    val customer2 = Customer(
        id = "5",
        name = "Diana Prince",
        phone = "555-555-5555",
        email = "diana.prince@example.com",
        status = CustomerStatus.ACTIVE,
        createdAt = LocalDateTime.now(),
        isPremium = true
    )
    val createdCustomer2 = createCustomerUseCase.execute(customer2)
    println("Created Customer 2: $createdCustomer2")

    // Log activities for one lead and one customer
    // For simplicity, we'll just print a message
    println("Logged activity for Lead 1")
    println("Logged activity for Customer 1")

    // Print a simple CRM summary
    println("CRM Summary:")
    println("Customers:")
    listCustomersUseCase.execute().forEach { println(it) }
    println("Leads:")
    listLeadsUseCase.execute().forEach { println(it) }
    val lostCustomer1 = LostCustomer(
        customerId = "4",
        reasonLost =  "Retired",
        lostDate = LocalDateTime.now(),
        notes = "Quit"
    )
    val createdLostCustomer = createLostCustomerUseCase.execute(lostCustomer1)
    println(createdLostCustomer)
    val findLostCustomer = findLostCustomerByIdUseCase.execute("99")
    println(findLostCustomer)
    val deleteLostCustomer = deleteLostCustomerUseCase.execute("99")
    val findLostCustomer1 = findLostCustomerByIdUseCase.execute("99")
    println(findLostCustomer1)
}
//fun main() {
//    val customerRepository = InMemoryCustomerRepository()
//    val customerService = CustomerServiceImpl(customerRepository)
//    val createCustomerUseCase = CreateCustomerUseCase(customerService)
//    val findCustomerByIdUseCase = FindCustomerByIdUseCase(customerService)
//    val listCustomersUseCase = ListCustomersUseCase(customerService)
//
//    val leadRepository = InMemoryLeadRepository()
//    val leadService = LeadServiceImpl(leadRepository, customerRepository, customerService)
//    val createLeadUseCase = CreateLeadUseCase(leadService)
//    val assignLeadUseCase = AssignLeadUseCase(leadService)
//    val convertLeadToCustomerUseCase = ConvertLeadToCustomerUseCase(leadService)
//    val listLeadsUseCase = ListLeadsUseCase(leadService)
//
//    // Create 3 leads
//    val lead1 = Lead(
//        id = "1",
//        name = "Jane Doe",
//        contactInfo = "jane.doe@example.com",
//        source = "Referral",
//        status = LeadStatus.NEW,
//        assignedSalesperson = null,
//        createdAt = LocalDateTime.now()
//    )
//    val createdLead1 = createLeadUseCase.execute(lead1)
//    println("Created Lead 1: $createdLead1")
//
//    val lead2 = Lead(
//        id = "2",
//        name = "Alice Johnson",
//        contactInfo = "alice.johnson@example.com",
//        source = "Email",
//        status = LeadStatus.NEW,
//        assignedSalesperson = null,
//        createdAt = LocalDateTime.now()
//    )
//    val createdLead2 = createLeadUseCase.execute(lead2)
//    println("Created Lead 2: $createdLead2")
//
//    val lead3 = Lead(
//        id = "3",
//        name = "Bob Smith",
//        contactInfo = "bob.smith@example.com",
//        source = "Social Media",
//        status = LeadStatus.NEW,
//        assignedSalesperson = null,
//        createdAt = LocalDateTime.now()
//    )
//    val createdLead3 = createLeadUseCase.execute(lead3)
//    println("Created Lead 3: $createdLead3")
//
//    // Assign one lead to a salesperson
//    val assignedLead = assignLeadUseCase.execute("1", "salesperson1")
//    println("Assigned Lead 1 to salesperson1: $assignedLead")
//
//    // Convert one lead into a customer
//    val convertedCustomer = convertLeadToCustomerUseCase.execute("1")
//    println("Converted Lead 1 to Customer: $convertedCustomer")
//
//    // Create 2 customers directly
//    val customer1 = Customer(
//        id = "4",
//        name = "Charlie Brown",
//        phone = "987-654-3210",
//        email = "charlie.brown@example.com",
//        status = CustomerStatus.ACTIVE,
//        createdAt = LocalDateTime.now()
//    )
//    val createdCustomer1 = createCustomerUseCase.execute(customer1)
//    println("Created Customer 1: $createdCustomer1")
//
//    val customer2 = Customer(
//        id = "5",
//        name = "Diana Prince",
//        phone = "555-555-5555",
//        email = "diana.prince@example.com",
//        status = CustomerStatus.ACTIVE,
//        createdAt = LocalDateTime.now()
//    )
//    val createdCustomer2 = createCustomerUseCase.execute(customer2)
//    println("Created Customer 2: $createdCustomer2")
//
//    // Log activities for one lead and one customer
//    // For simplicity, we'll just print a message
//    println("Logged activity for Lead 1")
//    println("Logged activity for Customer 1")
//
//    // Print a simple CRM summary
//    println("CRM Summary:")
//    println("Customers:")
//    listCustomersUseCase.execute().forEach { println(it) }
//    println("Leads:")
//    listLeadsUseCase.execute().forEach { println(it) }
//}
