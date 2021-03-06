package com.workspace.aocdataapi.service

import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

data class AoCEvent(var year: Int, var stars: Int)

@Component
class Session {
    @Value("\${SESSION_COOKIE}")
    lateinit var sessionCookie: String
}

fun retrieveStarsService(session: String): List<AoCEvent> {
    val cookie = mapOf("session" to session)
    val document = Jsoup.connect("https://adventofcode.com/events").cookies(cookie).get()
    val eventListDivs = document.getElementsByClass("eventlist-event")

    val events = mutableListOf<AoCEvent>()
    for (div in eventListDivs) {
        val anchor = div.getElementsByTag("a")[0]
        val year = anchor.text().substring(1, 5).toInt()
        val span = div.getElementsByTag("span")
        val stars = if (span.size > 0) span[0].text().replace("*", "").toInt() else 0
        events.add(AoCEvent(year, stars))
    }

    return events
}
