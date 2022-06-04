package com.example.godjunpyo_recent.ui.material_behavior;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MaterialBehaviorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MaterialBehaviorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MaterialBehavior fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}