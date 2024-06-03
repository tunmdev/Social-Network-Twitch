package com.tunm17.socialnetworktwitch.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandardScaffoldViewModel @Inject constructor(): ViewModel() {

    private val _selectedBottomNavItem = mutableIntStateOf(0)
    val selectedBottomNavItem: State<Int> = _selectedBottomNavItem

    fun setSelectedBottomNavItem(item: Int) {
        _selectedBottomNavItem.intValue = item
    }
}