package com.andrewtarry.opsley.backendtest.facebook

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResilientFacebookRepositoryTest {

    @Autowired
    lateinit var resilientDecorator: ResilientDecorator

    @Test
    fun getPostsTest() {
        val result = listOf(FacebookPost("a", "b"))
        val facebookRequest = mock<FacebookRequest> {
            on { getFacebookPosts() }.doReturn(result)
        }

        val repo = ResilientFacebookRepository(facebookRequest, resilientDecorator)
        val posts = repo.getFacebookPosts()

        assertEquals(1, posts.size)
    }

    @Test
    fun getPostsErrorTest() {
        val facebookRequest = mock<FacebookRequest> {
            on { getFacebookPosts() }.doThrow(RuntimeException::class)
        }

        val repo = ResilientFacebookRepository(facebookRequest, resilientDecorator)
        val posts = repo.getFacebookPosts()

        assertEquals(0, posts.size)
    }
}