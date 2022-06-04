package com.example.godjunpyo_recent.ui.see_all;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeeAllViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SeeAllViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is SeeAll fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}