package com.example.android.di

import android.app.Activity
import com.example.android.api.TextFormatter
import com.example.scopes.ActivityScope
import com.example.scopes.FragmentScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(ActivityScope::class)
@ContributesBinding(FragmentScope::class)
class LocaleFormatter @Inject constructor(activity: Activity) : TextFormatter {

    override fun format(text: String): String {
        return "$text, hola!"
    }
}

