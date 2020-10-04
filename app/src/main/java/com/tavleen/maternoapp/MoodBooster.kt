package com.tavleen.maternoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MoodBooster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_booster)
        val youTubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view1)
        lifecycle.addObserver(youTubePlayerView)
    }
}

