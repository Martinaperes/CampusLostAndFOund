package com.example.campuslostandfound.data.session

import android.content.Context

class SessionManager(context: Context) {

    private val preferences =
        context.getSharedPreferences(
            "campus_lost_and_found_session",
            Context.MODE_PRIVATE
        )

    fun saveUserId(userId: Int) {
        preferences.edit()
            .putInt("user_id", userId)
            .apply()
    }

    fun getUserId(): Int {
        return preferences.getInt("user_id", -1)
    }

    fun clearSession() {
        preferences.edit()
            .clear()
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return getUserId() != -1
    }
}