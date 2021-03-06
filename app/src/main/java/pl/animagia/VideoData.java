package pl.animagia;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class VideoData implements Parcelable {

    public static final String NAME_OF_INTENT_EXTRA = "video data";
    public static final String NAME_OF_URL = "video url";


    private final String title;
    private String posterAsssetUri;
    private final String videoUrl;
    private final int episodes;

    public VideoData(String title, String posterAssetUri, String videoUrl, int episodes) {
        this.title = title;
        this.posterAsssetUri = posterAssetUri;
        this.videoUrl = videoUrl;
        this.episodes = episodes;
    }

    public void setUri(String uri){
        this.posterAsssetUri = uri;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterAsssetUri() {
        return posterAsssetUri;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public int getEpisodes() {
        return episodes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VideoData) {
            return title.equals(((VideoData) obj).getTitle()) &&
                    posterAsssetUri.equals(((VideoData) obj).getPosterAsssetUri());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return title.hashCode() ^ posterAsssetUri.hashCode();
    }

    @Override
    public String toString() {
        return title;
    }

    protected VideoData(Parcel in) {
        this.posterAsssetUri = in.readString();
        this.title = in.readString();
        this.videoUrl = in.readString();
        this.episodes = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterAsssetUri);
        dest.writeString(title);
        dest.writeString(videoUrl);
        dest.writeInt(episodes);
    }

    public static final Creator<VideoData> CREATOR = new Creator<VideoData>() {
        @Override
        public VideoData createFromParcel(Parcel in) {
            return new VideoData(in);
        }

        @Override
        public VideoData[] newArray(int size) {
            return new VideoData[size];
        }
    };

}
