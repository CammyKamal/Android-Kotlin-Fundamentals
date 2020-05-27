package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.repository

 import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
 import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.domain.DevByteVideo
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.network.DevByteNetwork
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
 import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.database.VideosDatabase
 import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.database.asDomainModel
import timber.log.Timber

/**
 * Repository for fetching devbyte videos from the network and storing them on disk
 */
class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }

    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh videos is called");
            val playlist = DevByteNetwork.devbytes.getPlaylist().await()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }

}
