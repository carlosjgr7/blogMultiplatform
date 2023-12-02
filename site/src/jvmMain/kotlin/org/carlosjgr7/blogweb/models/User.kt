package org.carlosjgr7.blogweb.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.litote.kmongo.id.ObjectIdGenerator

@Serializable
data class User(
    @SerialName("_id")
    val id: String = ObjectIdGenerator.newObjectId<String>().id.toHexString(),
    val username: String = "",
    val password: String = ""
)
