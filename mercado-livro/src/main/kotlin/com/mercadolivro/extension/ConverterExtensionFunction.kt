package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.controller.response.CustomerResponse

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
}

fun PutCustomerRequest.toCustomerModel(previousCustomer: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousCustomer.id,
        name = this.name,
        email = this.email,
        status = previousCustomer.status
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel?): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBoolModel(previousBook: BookModel): BookModel {
    return BookModel(
        id = previousBook.id,
        name = this.name ?: previousBook.name,
        price = this.price ?: previousBook.price,
        status = previousBook.status,
        customer = previousBook.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer
    )
}
