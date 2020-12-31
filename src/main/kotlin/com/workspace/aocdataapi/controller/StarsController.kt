package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.service.AoCEvent
import com.workspace.aocdataapi.service.Session
import com.workspace.aocdataapi.service.retrieveStarsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class StarsController {

    @Autowired
    lateinit var session: Session

    @GetMapping("/stars")
    fun retrieveStars(): List<AoCEvent> {
        val sessionCookie: String = session.sessionCookie
        return retrieveStarsService(sessionCookie)
    }

    @Scheduled(cron = "* */30 * * * *")
    fun cronJob() {
        val s = "Cron job run at " + Date()
        println(s)
    }
}