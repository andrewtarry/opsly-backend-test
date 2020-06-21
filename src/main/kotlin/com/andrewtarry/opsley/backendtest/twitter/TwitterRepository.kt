package com.andrewtarry.opsley.backendtest.twitter

/**
 * Manage interaction with Twitter
 */
interface TwitterRepository {

    /**
     * Get latest tweet list
     */
    fun requestTweets(): List<Tweet>
}