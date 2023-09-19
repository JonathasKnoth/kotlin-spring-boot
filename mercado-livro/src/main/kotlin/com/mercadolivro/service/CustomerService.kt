package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(
        val customerRepository: CustomerRepository,
        val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        //println("Valor de nome: $name")
        name?.let {
            return customerRepository.findByNameContaining(it)
        }

        return customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {
       if(!customerRepository.existsById(customer.id!!)){
           throw Exception("Registro não existe");
       }
        customerRepository.save(customer)
    }

    fun deletar(id: Int) {
        var customer = findById(id)
        customer.status = CustomerStatus.INATIVO
        bookService.findByCustomer(customer)
        customerRepository.save(customer)
    }

}