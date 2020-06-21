package com.andrewtarry.opsley.backendtest.twitter

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ResilientTwitterRepositoryTest {

    @Autowired
    lateinit var resilientDecorator: ResilientDecorator

    @Test
    fun getPhotoTest() {
        val result = listOf(Tweet("a", "b"))
        val request = mock<TweetRequest> {
            on { getTweets() }.doReturn(result)
        }

        val repo = ResilientTwitterRepository(request, resilientDecorator)
        val posts = repo.requestTweets()

        assertEquals(1, posts.size)
    }

    @Test
    fun getPhotoErrorTest() {
        val request = mock<TweetRequest> {
            on { getTweets() }.doThrow(RuntimeException::class)
        }

        val repo = ResilientTwitterRepository(request, resilientDecorator)
        val posts = repo.requestTweets()

        assertEquals(0, posts.size)
    }
}