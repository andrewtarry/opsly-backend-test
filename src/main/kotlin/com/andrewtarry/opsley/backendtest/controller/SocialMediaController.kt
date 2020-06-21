package com.andrewtarry.opsley.backendtest.controller

import com.andrewtarry.opsley.backendtest.socialmedia.SocialMediaManager
import com.andrewtarry.opsley.backendtest.socialmedia.SocialMediaResult
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SocialMediaController(private val socialMediaManager: SocialMediaManager) {

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun getSocialMedia(): SocialMediaResult = socialMediaManager.getSocialMedia()
}