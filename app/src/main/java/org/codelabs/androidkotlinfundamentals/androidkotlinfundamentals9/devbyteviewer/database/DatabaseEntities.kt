package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.domain.DevByteVideo

@Entity
data class DatabaseVideo constructor(
        @PrimaryKey
        val url: String,
        val updated: String,
        val title: String,
        val description: String,
        val thumbnail: String)


fun List<DatabaseVideo>.asDomainModel(): List<DevByteVideo> {
        return map {
                DevByteVideo(
                        url = it.url,
                        title = it.title,
                        description = it.description,
                        updated = it.updated,
                        thumbnail = it.thumbnail)
        }
}
