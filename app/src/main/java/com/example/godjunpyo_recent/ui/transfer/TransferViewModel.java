package com.example.godjunpyo_recent.ui.transfer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransferViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TransferViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Transfer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}