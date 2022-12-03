package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.model.Status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class StatusController {

    @GetMapping(value = ["/", "/health", "/status"])
    fun home(): Status {
        return Status(Date(), "UP")
    }
}
