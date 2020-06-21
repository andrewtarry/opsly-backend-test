package com.andrewtarry.opsley.backendtest.socialmedia

interface SocialMediaManager {

    /**
     * Get social media data as a single object
     */
    suspend fun getSocialMedia(): SocialMediaResult
}