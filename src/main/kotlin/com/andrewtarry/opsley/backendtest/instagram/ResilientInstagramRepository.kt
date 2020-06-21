package com.andrewtarry.opsley.backendtest.instagram

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import org.springframework.stereotype.Service

@Service
class ResilientInstagramRepository(instagramRequest: InstagramRequest, resilientDecorator: ResilientDecorator): InstagramRepository {

    private val request = resilientDecorator.decorate("instagram") { instagramRequest.getPhotos() }

    /**
     * Get Instagram photos
     */
    override fun getInstagramPhotos(): List<InstagramPhoto> {
        return request.get()
    }
}