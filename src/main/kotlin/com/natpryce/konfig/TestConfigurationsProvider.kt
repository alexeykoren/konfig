package com.natpryce.konfig

import java.util.*

interface TestConfigurationsProvider {


    companion object {

        var provider : TestConfigurationsProvider = InMemoryStorage()

        fun config(name: String): Configuration? = provider.getConfig(name)

        fun inMemory(): InMemoryStorage? = provider as? InMemoryStorage
    }

    fun getConfig(name: String): Configuration?


    class InMemoryStorage : TestConfigurationsProvider {

        val configurations = HashMap<String, Configuration>()

        override fun getConfig(name: String): Configuration? = configurations[name]

        fun putConfig(name: String, configuration: Configuration) { configurations[name] = configuration }
    }

}