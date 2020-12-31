package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.service.AoCEvent
import com.workspace.aocdataapi.service.retrieveStarsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StarsController {

    @GetMapping("/stars")
    fun retrieveStars(): List<AoCEvent> {
        return retrieveStarsService()
    }
}