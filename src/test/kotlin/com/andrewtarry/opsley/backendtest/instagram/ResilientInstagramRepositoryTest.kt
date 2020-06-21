package com.andrewtarry.opsley.backendtest.instagram

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResilientInstagramRepositoryTest {

    @Autowired
    lateinit var resilientDecorator: ResilientDecorator

    @Test
    fun getPhotoTest() {
        val result = listOf(InstagramPhoto("a", "b"))
        val request = mock<InstagramRequest> {
            on { getPhotos() }.doReturn(result)
        }

        val repo = ResilientInstagramRepository(request, resilientDecorator)
        val posts = repo.getInstagramPhotos()

        assertEquals(1, posts.size)
    }

    @Test
    fun getPhotoErrorTest() {
        val request = mock<InstagramRequest> {
            on { getPhotos() }.doThrow(RuntimeException::class)
        }

        val repo = ResilientInstagramRepository(request, resilientDecorator)
        val posts = repo.getInstagramPhotos()

        assertEquals(0, posts.size)
    }
}