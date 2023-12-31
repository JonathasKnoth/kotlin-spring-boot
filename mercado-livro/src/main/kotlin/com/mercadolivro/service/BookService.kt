package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
        val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        var book = findById(id)

        book.status = BookStatus.DELETADO

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun findByCustomer(customer: CustomerModel) {
        var books = bookRepository.findByCustomer(customer)

        books.forEach{book -> book.status = BookStatus.DELETADO}

        bookRepository.saveAll(books)
    }

}