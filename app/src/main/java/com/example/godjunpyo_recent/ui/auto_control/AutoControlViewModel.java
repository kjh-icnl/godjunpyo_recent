package com.example.godjunpyo_recent.ui.auto_control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AutoControlViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AutoControlViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is AutoControl fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}