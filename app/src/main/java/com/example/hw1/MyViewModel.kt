package com.example.hw1

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var myList = mutableStateListOf<Int>()
}