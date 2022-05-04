package com.dealership.controller.request

import com.dealership.model.CustomerModel

data class UpdateCustomerRequest (
    var name: String,

    var email: String
) {
    fun toCustomerModel(id: Int): CustomerModel {
        return CustomerModel(id = id, name = this.name, email = this.email)
    }

}
