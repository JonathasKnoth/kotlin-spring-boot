package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    private val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, ignoreCase = true) }
        }
        return customers
    }

    fun createCustomer(request: CustomerModel) {
        val id = if (customers.isEmpty()) 1 else customers.last().id!!.toInt() + 1
        request.id = id
        customers.add(CustomerModel(id, request.name, request.email))
    }

    fun getCustomer(id: Int): CustomerModel? {
        val customer: CustomerModel? = customers.find { it -> it.id == id }
        return customer;
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deletar(id: Int) {
        customers.removeIf { it.id == id }
    }
}