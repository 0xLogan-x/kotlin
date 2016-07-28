package net

import require

/**
 * Created by user on 7/28/16.
 */
val http = require("http")

fun sendRequest(dataBuffer: dynamic, url: String, successCallback: (responseData: ByteArray) -> Unit, errorCallback: (err: dynamic) -> Unit) {
    val options: dynamic = {}
    val serverAddress = "127.0.0.1"
    val port = 7925
    js("options = {hostname:serverAddress, port:port, path:url, method:'POST'}")

    val request = http.request(options, { response ->
        val resData = mutableListOf<Byte>()
        response.on("data", { datas ->
            for (i in 0..datas.length - 1) {
                resData.add(datas[i])
            }
        })
        response.on("end", {
            successCallback.invoke(resData.toByteArray())
        })
    })
    request.on("error", { err ->
        errorCallback.invoke(err)
    })
    request.write(dataBuffer)
    request.end()
}