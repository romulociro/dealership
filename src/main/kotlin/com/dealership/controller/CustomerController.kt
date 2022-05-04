package com.dealership.controller

import com.dealership.controller.request.CreateCustomerRequest
import com.dealership.controller.request.UpdateCustomerRequest
import com.dealership.model.CustomerModel
import com.dealership.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.listCustomers(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CreateCustomerRequest) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: UpdateCustomerRequest) {
        customerService.update(customer.toCustomerModel(id))
    }
}