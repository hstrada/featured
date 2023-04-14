package io.example.toggled.cache

/**
 *
 * Cache interface that will have the get on set methods
 * to load and save cache data into service
 */
interface CacheService {
    /**
     * This method is used to save data into cache
     * @param   key     key name that will be used to save data into cache
     * @param   value   value that will be saved into key
     */
    fun set(key: String, value: String)

    /**
     * This method is used to load data from cache
     * @param   key     key name that will be used to search for data from cache
     */
    fun get(key: String): String?
}