package io.example.toggled.service

//import arrow.core.Either
//
//interface HttpService {
//    enum class HttpMethod { GET }
//
//    suspend fun <T> exchange(
//        uri: String,
//        method: HttpMethod
//    ): Either<Exception, T>
//
//}
//
//suspend inline fun <reified T> HttpService.getForBody(
//    uri: String,
//    method: HttpService.HttpMethod,
//    noinline f: suspend T.() -> Either<Exception, T?>
//): Either<Exception, T?> = exchange(uri, method)