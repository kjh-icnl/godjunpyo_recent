package com.example.godjunpyo_recent.ui.eng_math;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EngMathViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EngMathViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is EngMath fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}