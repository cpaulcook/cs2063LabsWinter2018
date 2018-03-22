package mobiledev.unb.ca.labexam;

public class LakeInfo {

    private String mId;
    private String mName;
    private String mLatitude;
    private String mLongitude;
    private String mWikiURL;

    public LakeInfo (String id, String name, String latitude,
                     String longitude, String wikiURL) {
        mId = id;
        mName = name;
        mLatitude = latitude;
        mLongitude = longitude;
        mWikiURL = wikiURL;

        if (mWikiURL.equals("null")) {
            mWikiURL = null;
        }
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public boolean hasWikiURL() {
        return mWikiURL != null;
    }

    public String getWikiURL() {
        return mWikiURL;
    }
}
