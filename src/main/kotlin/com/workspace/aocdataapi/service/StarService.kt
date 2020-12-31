package com.workspace.aocdataapi.service

import io.github.cdimascio.dotenv.Dotenv
import org.jsoup.Jsoup

data class AoCEvent(var year: Int, var stars: Int)

fun retrieveStarsService(): List<AoCEvent> {
    val dotenv = Dotenv.load()
    val sessionCookie: String = dotenv.get("SESSION_COOKIE") ?: "default"
    val cookie = mapOf("session" to sessionCookie)

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
