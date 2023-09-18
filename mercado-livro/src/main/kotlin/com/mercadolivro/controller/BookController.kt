package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.extension.toBoolModel
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.CustomerService
import com.mercadolivro.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController (
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody resquest: PostBookRequest){
        val customer = customerService.getById(resquest.customerId)
        bookService.create(resquest.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/actives")
    fun findActives(): List<BookModel> {
        return bookService.findActives()
    }

    @GetMapping("/{id}")
    fun findByid(@PathVariable id : Int) : BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id : Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id : Int, @RequestBody request: PutBookRequest) {
        var book = bookService.findById(id)
        bookService.update(request.toBoolModel(book))
    }

}