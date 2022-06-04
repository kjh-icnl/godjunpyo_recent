package com.example.godjunpyo_recent.ui.prof_mentoring;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfMentoringViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProfMentoringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ProfMentoring fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}