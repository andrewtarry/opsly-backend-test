package com.andrewtarry.opsley.backendtest.twitter

import com.andrewtarry.opsley.backendtest.BackendTestApplication
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = BackendTestApplication.DOMAIN, name = "twitter")
interface TweetRequest {

    @RequestMapping(method = [RequestMethod.GET], path = ["/twitter"])
    fun getTweets(): List<Tweet>
}