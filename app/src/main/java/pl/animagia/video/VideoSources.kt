package pl.animagia.video

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util

fun prepareFromAsset(activity: android.support.v7.app.AppCompatActivity, url: String, videoTitle: String): MediaSource {

    val dataSourceFactory: DataSource.Factory = object : DataSource.Factory {
        override fun createDataSource(): DataSource {
            val source = DefaultHttpDataSource(Util.getUserAgent(activity, "animagia"), null)
            if (videoTitle != "A feature film" && videoTitle != "A TV series") {
                source.setRequestProperty("Range", "0-1023")
            }
            return source
        }
    }

    val videoSource : MediaSource
        videoSource = ExtractorMediaSource(Uri.parse(url),
                dataSourceFactory, DefaultExtractorsFactory(), null, null)

    return videoSource
}
