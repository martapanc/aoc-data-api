package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.service.Session
import com.workspace.aocdataapi.service.retrieveStarsService
import org.jsoup.HttpStatusException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StarsController {

    @Autowired
    lateinit var session: Session

    @GetMapping("/stars")
    fun retrieveStars(): ResponseEntity<String> {
        val sessionCookie: String = session.sessionCookie
        return try {
            val list = retrieveStarsService(sessionCookie)
            ResponseEntity.ok(list.toString())
        } catch (e: HttpStatusException) {
            ResponseEntity.status(504).body("Error 504 connecting to https://adventofcode.com/")
        } catch (e: Exception) {
            ResponseEntity.status(500).body("Error connecting to https://adventofcode.com/")
        }
    }
}