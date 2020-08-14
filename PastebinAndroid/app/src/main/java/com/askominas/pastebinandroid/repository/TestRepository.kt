package com.askominas.pastebinandroid.repository

interface TestRepository {
    fun helloTestRepository(): String
}

class TestRepositoryImpl : TestRepository {
    override fun helloTestRepository(): String {
        return "Hello Test Repository!"
    }
}
