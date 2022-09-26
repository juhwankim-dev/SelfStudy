package com.example.domain.util

// 저는 주로 서버에서 넘겨주는 값을 아래 형태로 통일해서 받았었어요.
// Result<User>, Result<Post> 이런 식으루요.
data class Result<out T>(
    val status: Status,
    var data: @UnsafeVariance T?,
    val message: String?
){
    companion object{
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Result<T> {
            return Result(Status.ERROR, data, msg)
        }

        fun <T> fail(): Result<T> {
            return Result(Status.FAIL, null, null)
        }
    }
}