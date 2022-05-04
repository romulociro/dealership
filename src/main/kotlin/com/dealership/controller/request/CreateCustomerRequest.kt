package com.dealership.controller.request

import com.dealership.model.CustomerModel

data class CreateCustomerRequest (
    var name: String,
    var email: String
    ) {
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(name = this.name, email = this.email)
    }
}