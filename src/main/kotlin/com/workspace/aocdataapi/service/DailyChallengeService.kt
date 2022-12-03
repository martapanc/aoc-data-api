package com.workspace.aocdataapi.service

import com.workspace.aocdataapi.model.Code
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


fun getTestInput(year: Int, day: Int): Code {
    val document = Jsoup.connect("https://adventofcode.com/${year}/day/${day}").get()

    val codeElements = document.getElementsByTag("code")
    if (codeElements.size > 0) {
        return Code(codeElements.map { it.text() }.toSet().maxBy { it.length })
    }

    return Code("not found")
}

fun getInput(year: Int, day: Int, session: String): Code {
    val url = URL("https://adventofcode.com/${year}/day/${day}/input")
    val con: HttpURLConnection = url.openConnection() as HttpURLConnection
    con.requestMethod = "GET"
    con.setRequestProperty("Content-Type", "text/plain")
    con.setRequestProperty("Cookie", "session=${session}")

    val inputStream = BufferedReader(InputStreamReader(con.inputStream))
    var inputLine: String?
    val content = StringBuffer()
    while (inputStream.readLine().also { inputLine = it } != null) {
        content.append("$inputLine\n")
    }
    inputStream.close()
    con.disconnect()

    return Code(content.toString())
}

