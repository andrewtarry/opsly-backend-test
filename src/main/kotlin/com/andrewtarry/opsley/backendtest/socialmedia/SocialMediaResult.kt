package com.andrewtarry.opsley.backendtest.socialmedia

import com.andrewtarry.opsley.backendtest.facebook.FacebookPost
import com.andrewtarry.opsley.backendtest.instagram.InstagramPhoto
import com.andrewtarry.opsley.backendtest.twitter.Tweet

data class SocialMediaResult(
        val twitter: List<Tweet>,
        val facebook: List<FacebookPost>,
        val instagram: List<InstagramPhoto>
)