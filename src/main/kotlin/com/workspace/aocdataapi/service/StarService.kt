package com.workspace.aocdataapi.service

import com.workspace.aocdataapi.model.AoCEvent
import org.jsoup.Jsoup

fun retrieveStars(session: String): List<AoCEvent> {
    val cookie = mapOf("session" to session)
    val document = Jsoup.connect("https://adventofcode.com/events").cookies(cookie).get()
    val eventListDivs = document.getElementsByClass("eventlist-event")

    val events = mutableListOf<AoCEvent>()

    // If the user is not logged in, the `eventlist-event` div only contains the link to the year's event
    if (eventListDivs[0].childNodeSize() < 3) {
        return events
    }

    for (div in eventListDivs) {
        val anchor = div.getElementsByTag("a")[0]
        val year = anchor.text().substring(1, 5).toInt()
        val span = div.getElementsByClass("star-count")
        val stars = if (span.size > 0) span[0].text().replace("*", "").toInt() else 0
        events.add(AoCEvent(year, stars))
    }

    return events
}
