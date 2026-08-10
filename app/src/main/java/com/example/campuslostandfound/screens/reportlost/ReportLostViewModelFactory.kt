package com.example.campuslostandfound.screens.reportlost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.campuslostandfound.data.repository.LostFoundRepository

class ReportLostViewModelFactory(
    private val repository: LostFoundRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(ReportLostViewModel::class.java)) {
            return ReportLostViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}