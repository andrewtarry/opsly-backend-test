package com.andrewtarry.opsley.backendtest.facebook

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import org.springframework.stereotype.Service

@Service
class ResilientFacebookRepository(facebookRequest: FacebookRequest,
                                  resilientDecorator: ResilientDecorator) : FacebookRepository {

    private val request = resilientDecorator.decorate("facebook") { facebookRequest.getFacebookPosts() }

    /**
     * Get the latest facebook posts
     */
    override fun getFacebookPosts(): List<FacebookPost> {
        return request.get()
    }
}