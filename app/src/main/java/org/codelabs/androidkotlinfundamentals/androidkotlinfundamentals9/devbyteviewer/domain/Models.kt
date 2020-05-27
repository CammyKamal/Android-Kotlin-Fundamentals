package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.domain

import org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals9.devbyteviewer.util.smartTruncate


/**
 * Videos represent a devbyte that can be played.
 */
data class DevByteVideo(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */
    val shortDescription: String
        get() = description.smartTruncate(200)
}