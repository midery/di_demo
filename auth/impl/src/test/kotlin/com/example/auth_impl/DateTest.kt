package com.example.auth_impl

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

class DateTest {

    @Test
    fun test() {
        val parsedDate = parseISO8601DateTime(dateString)
        assertEquals(date, parsedDate)
    }

    private fun parseISO8601DateTime(dateTimeString: String): LocalDateTime {
        return ZonedDateTime.parse(dateTimeString)
            .withZoneSameInstant(ZoneId.systemDefault())
            .toLocalDateTime()
    }


    companion object {
        private val dateString = "2023-02-20T16:06:58+01:00"
        private val date = ZonedDateTime.parse(dateString).toLocalDateTime()
    }
}