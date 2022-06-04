package com.example.godjunpyo_recent.ui.vibration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VibrationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VibrationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Vibration fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}