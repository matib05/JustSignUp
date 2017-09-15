package com.matib05.android.justsignup.model;

import android.media.Image;

/**
 * Created by matib05 on 9/7/2017.
 */

public class QuranActivityModel {

    private String activityName;
    private String activityDescription;
    private Image activityImage;

    public QuranActivityModel(String activityName, String activityDescription) {
        this.activityName = activityName;
        this.activityDescription = activityDescription;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Image getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(Image activityImage) {
        this.activityImage = activityImage;
    }
}
