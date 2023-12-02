package org.carlosjgr7.blogweb.data

import com.varabyte.kobweb.api.data.add
import com.varabyte.kobweb.api.init.InitApi
import com.varabyte.kobweb.api.init.InitApiContext
import kotlinx.coroutines.reactive.awaitFirst
import org.carlosjgr7.blogweb.models.User
import org.carlosjgr7.blogweb.util.Constants.DATA_BASE
import org.litote.kmongo.and
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.reactivestreams.getCollection

@InitApi
fun initMongoDb(context: InitApiContext) {
    System.setProperty(
        "org.litote.mongo.test.mapping.service",
        "org.litote.kmongo.serialization.SerializationClassMappingTypeService",
    )
    context.data.add(MongoDB(context))
}

class MongoDB(val context: InitApiContext) : MongoRepository {

    private val client = KMongo.createClient()
    private val database = client.getDatabase(DATA_BASE)
    private val usersCollection = database.getCollection<User>()
    override suspend fun checkUserExistence(user: User): User? {
        return try {
            usersCollection.find(
                and(
                    User::username eq user.username,
                    User::password eq user.password,
                ),
            ).awaitFirst()
        } catch (e: Exception) {
            context.logger.error(e.message.toString())
            null
        }
    }
}
