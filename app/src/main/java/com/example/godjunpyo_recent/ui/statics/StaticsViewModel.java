package com.example.godjunpyo_recent.ui.statics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StaticsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StaticsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Statics fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}