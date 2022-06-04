package com.example.godjunpyo_recent.ui.normal_mentoring;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NormalMentoringViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NormalMentoringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}