package com.andrewtarry.opsley.backendtest.instagram

import com.andrewtarry.opsley.backendtest.BackendTestApplication
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = BackendTestApplication.DOMAIN, name = "instagram")
interface InstagramRequest {

    @RequestMapping(method = [RequestMethod.GET], path = ["/instagram"])
    fun getPhotos(): List<InstagramPhoto>
}