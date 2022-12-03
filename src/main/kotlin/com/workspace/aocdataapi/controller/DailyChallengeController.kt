package com.workspace.aocdataapi.controller

import com.workspace.aocdataapi.model.Session
import com.workspace.aocdataapi.service.getInput
import com.workspace.aocdataapi.service.getTestInput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/daily")
class DailyChallengeController {

    @Autowired
    lateinit var session: Session

    @GetMapping(value = ["/{year}/{day}/test-input"], produces = ["text/plain"])
    fun getDailyChallengeTestInput(@PathVariable("year") year: Int, @PathVariable("day") day: Int): String {
        return getTestInput(year, day).content
    }

    @GetMapping(value = ["/{year}/{day}/input"], produces = ["text/plain"])
    fun getDailyChallengeInput(@PathVariable("year") year: Int, @PathVariable("day") day: Int): String {
        val sessionCookie: String = session.sessionCookie
        return getInput(year, day, sessionCookie).content
    }
}
