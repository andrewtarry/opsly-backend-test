package com.andrewtarry.opsley.backendtest.twitter

import com.andrewtarry.opsley.backendtest.ResilientDecorator
import org.springframework.stereotype.Service

@Service
class ResilientTwitterRepository(
        tweetRequest: TweetRequest,
        resilientDecorator: ResilientDecorator
): TwitterRepository {

    private val request = resilientDecorator.decorate("twitter") {tweetRequest.getTweets()}

    /**
     * Get latest tweet list
     */
    override fun requestTweets(): List<Tweet> {
        return request.get()
    }
}