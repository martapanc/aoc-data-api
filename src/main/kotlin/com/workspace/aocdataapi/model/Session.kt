package com.workspace.aocdataapi.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Session {

    @Value("\${SESSION_COOKIE}")
    lateinit var sessionCookie: String
}
