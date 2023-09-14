package com.example.composecleanarchitecture.base

import org.json.JSONObject

interface IBaseRepository {
    fun  cacheResources(resourcesResponse: JSONObject)

    fun  getCachedResources(): JSONObject

    fun destroyCache()
}