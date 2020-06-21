package com.andrewtarry.opsley.backendtest.facebook

import com.andrewtarry.opsley.backendtest.BackendTestApplication
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = BackendTestApplication.DOMAIN, name = "facebook")
interface FacebookRequest {

    @RequestMapping(method = [RequestMethod.GET], path = ["/facebook"])
    fun getFacebookPosts(): List<FacebookPost>
}