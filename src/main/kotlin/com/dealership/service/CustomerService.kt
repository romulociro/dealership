package com.dealership.service

import com.dealership.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun listCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun createCustomer(customer: CustomerModel) {
        val id = if(customers.isEmpty()) {
            1
        } else{
            customers.last().id!! + 1
        }.toString()

        customer.id = id.toInt()

        customers.add(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers.first { it.id == id }
    }

    fun update(customer: CustomerModel) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }
}