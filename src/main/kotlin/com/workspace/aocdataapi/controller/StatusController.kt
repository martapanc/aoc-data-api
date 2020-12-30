package com.workspace.aocdataapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class StatusController {

    @GetMapping("/health")
    fun greeting(): Status {
        return Status(Date(), "UP")
    }
}

data class Status(val date: Date, val status: String)