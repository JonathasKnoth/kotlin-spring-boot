package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(
        val customerRepository: CustomerRepository
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

    fun getById(id: Int): CustomerModel? {
        return customerRepository.findByIdOrNull(id)
    }

    fun update(customer: CustomerModel) {
       if(!customerRepository.existsById(customer.id!!)){
           throw Exception("Registro não existe");
       }
        customerRepository.save(customer)
    }

    fun deletar(id: Int) {
        if(!customerRepository.existsById(id)){
            throw Exception("Registro não existe");
        }
        customerRepository.deleteById(id)
    }
}