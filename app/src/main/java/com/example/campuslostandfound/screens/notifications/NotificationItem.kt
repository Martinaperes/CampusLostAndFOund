package com.example.campuslostandfound.screens.notifications

data class NotificationItem(
    val title: String,
    val message: String,
    val time: String,
    val isRead: Boolean
)