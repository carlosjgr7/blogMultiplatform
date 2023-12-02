package org.carlosjgr7.blogweb.data

import org.carlosjgr7.blogweb.models.User

interface MongoRepository {
    suspend fun checkUserExistence(user: User): User?
}