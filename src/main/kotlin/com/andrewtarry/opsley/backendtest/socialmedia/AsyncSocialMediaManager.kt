package com.andrewtarry.opsley.backendtest.socialmedia

import com.andrewtarry.opsley.backendtest.facebook.FacebookRepository
import com.andrewtarry.opsley.backendtest.instagram.InstagramRepository
import com.andrewtarry.opsley.backendtest.twitter.TwitterRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.springframework.stereotype.Service

@Service
class AsyncSocialMediaManager(
        private val twitterRepository: TwitterRepository,
        private val facebookRepository: FacebookRepository,
        private val instagramRepository: InstagramRepository
): SocialMediaManager {

    /**
     * Get social media data as a single object
     */
    override suspend fun getSocialMedia(): SocialMediaResult {
        val twitter = GlobalScope.async { twitterRepository.requestTweets() }
        val facebook = GlobalScope.async { facebookRepository.getFacebookPosts() }
        val instagram = GlobalScope.async { instagramRepository.getInstagramPhotos() }

        return SocialMediaResult(twitter = twitter.await(),
                facebook = facebook.await(),
                instagram = instagram.await())
    }
}