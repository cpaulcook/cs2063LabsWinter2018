package mobiledev.unb.ca.myapplication;

public class Course {

    private String mId = "None";
    private String mName = "None";
    private String mDesc = "None";

    public Course(String id, String name, String desc) {
        mId = id;
        mName = name;
        mDesc = desc;
    }

    public String getDescription() {
        return mDesc;
    }

    public String getTitle() {
        return mId + " " + mName;
    }

}
