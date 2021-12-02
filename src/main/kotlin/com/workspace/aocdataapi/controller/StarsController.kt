package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.service.AoCEvent
import com.workspace.aocdataapi.service.Session
import com.workspace.aocdataapi.service.retrieveStarsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
class StarsController {

    @Autowired
    lateinit var session: Session

    @GetMapping("/stars")
    fun retrieveStars(): List<AoCEvent> {
        val sessionCookie: String = session.sessionCookie
        val eventList: List<AoCEvent> = retrieveStarsService(sessionCookie)
        if (eventList.isNotEmpty()) {
            return eventList
        } else {
            throw HttpClientErrorException(
                HttpStatus.BAD_REQUEST,
                "Could not retrieve stars - maybe the session cookie has expired?"
            )
        }
    }
}