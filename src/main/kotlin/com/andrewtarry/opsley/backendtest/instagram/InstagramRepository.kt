package com.andrewtarry.opsley.backendtest.instagram

interface InstagramRepository {

    /**
     * Get Instagram photos
     */
    fun getInstagramPhotos(): List<InstagramPhoto>
}