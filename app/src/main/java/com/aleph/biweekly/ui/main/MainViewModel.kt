package com.aleph.biweekly.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.aleph.biweekly.ui.NavigationActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    fun getNavigationType() = savedStateHandle.get<NavigationActivity.Companion.NavigationType>(NavigationActivity.NAVIGATION_TYPE_KEY)
}