package com.mercadolivro.controller.response

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var erros: List<fieldErrorResponse>?
)