package com.example.godjunpyo_recent.ui.dynamics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DynamicsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DynamicsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Dynamics fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}