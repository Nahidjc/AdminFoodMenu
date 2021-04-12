package com.example.foodadmin.ui.AddRestaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddRestaurantModel extends ViewModel {
    private MutableLiveData<String> mText;
    public MutableLiveData<String> getmText() {
        return mText;
    }

    public AddRestaurantModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Restaurant fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
