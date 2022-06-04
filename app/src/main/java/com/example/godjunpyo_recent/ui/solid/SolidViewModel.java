package com.example.godjunpyo_recent.ui.solid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SolidViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SolidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Solid fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}