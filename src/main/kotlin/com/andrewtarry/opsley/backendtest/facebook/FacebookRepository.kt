package com.andrewtarry.opsley.backendtest.facebook

interface FacebookRepository {

    /**
     * Get the latest facebook posts
     */
    fun getFacebookPosts(): List<FacebookPost>
}