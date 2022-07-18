package com.example.practiceone

import android.content.Context
import com.example.practiceone.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner



class AffirmationAdapterTest {
    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {
        val data = arrayListOf(
            Affirmation("d"),
            Affirmation("s")
        )
        val adapter = JamesAdapter(data)
        assertEquals("JamesAdapter is not the correct size", data.size, adapter.itemCount)
    }
}