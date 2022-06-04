package com.example.godjunpyo_recent.ui.thermo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThermoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThermoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Thermo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}