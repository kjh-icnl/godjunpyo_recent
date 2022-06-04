package com.example.godjunpyo_recent.ui.fluid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FluidViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FluidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fluid fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}