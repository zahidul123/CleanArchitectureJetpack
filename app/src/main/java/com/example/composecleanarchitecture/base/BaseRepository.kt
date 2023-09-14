package com.example.composecleanarchitecture.base

import com.example.composecleanarchitecture.data.network.AppNetworkState
import com.example.composecleanarchitecture.data.network.IApiService
import com.example.composecleanarchitecture.data.network.NetworkErrorExceptions
import com.example.composecleanarchitecture.data.network.resolveError
import com.example.composecleanarchitecture.db.room.RoomHelper
import com.example.composecleanarchitecture.db.shared_preference.SharedPreferencesHelper
import com.example.composecleanarchitecture.models.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


abstract class BaseRepository : IBaseRepository {
    abstract var apiService: IApiService
    abstract var preferencesHelper: SharedPreferencesHelper
    abstract var roomHelper: RoomHelper

    protected suspend fun <T : Any> apiCallingState(callback: suspend () -> T): Flow<AppNetworkState<T>> =
        flow {
            emit(AppNetworkState.Loading)
            try {
                val networkCall = AppNetworkState.Data(callback())
                val baseData = networkCall.data as BaseResponse
                when (baseData.code) {
                    200, 201 -> {
                        emit(networkCall)
                    }
                    else -> {
                        if (!baseData.message.isNullOrEmpty()) {
                            throw NetworkErrorExceptions(
                                errorCode = baseData.code ?: -1,
                                errorBody = baseData,
                                errorMessage = baseData.message,
                                unauthorized = baseData.code == 401
                            )
                        }

                        throw NetworkErrorExceptions(
                            errorCode = baseData.code ?: -1,
                            errorBody = baseData,
                            unauthorized = baseData.code == 401
                        )
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()

                emit(e.resolveError())
            }
        }

}