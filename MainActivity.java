package com.melora.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER_VERTICAL);
        return t;
    }

    private GradientDrawable bg(int color, float radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    private TextView button(String label) {
        TextView b = text(label, 14, Color.WHITE);
        b.setGravity(Gravity.CENTER);
        b.setBackground(bg(Color.rgb(38, 38, 48), 18));
        b.setPadding(dp(18), 0, dp(18), 0);
        return b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int bg = Color.rgb(11, 11, 16);
        final int card = Color.rgb(24, 24, 32);
        final int white = Color.WHITE;
        final int muted = Color.rgb(170, 170, 184);
        final int purple = Color.rgb(190, 105, 255);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(18), dp(16), dp(18), dp(12));
        root.setBackgroundColor(bg);

        TextView title = text("MELORA", 30, white);
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        root.addView(title, new LinearLayout.LayoutParams(-1, dp(52)));

        TextView subtitle = text("Music that feels like yours.", 15, muted);
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, dp(32)));

        LinearLayout search = new LinearLayout(this);
        search.setGravity(Gravity.CENTER_VERTICAL);
        search.setPadding(dp(16), 0, dp(12), 0);
        search.setBackground(bg(Color.rgb(29, 29, 38), 22));

        TextView searchText = text("⌕   Search songs, artists or albums", 15, muted);
        search.addView(searchText, new LinearLayout.LayoutParams(0, dp(50), 1));
        TextView go = button("Search");
        search.addView(go, new LinearLayout.LayoutParams(dp(82), dp(40)));
        root.addView(search, new LinearLayout.LayoutParams(-1, dp(52)));

        TextView section = text("Quick access", 21, white);
        section.setTypeface(null, android.graphics.Typeface.BOLD);
        section.setPadding(0, dp(22), 0, dp(8));
        root.addView(section, new LinearLayout.LayoutParams(-1, dp(58)));

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);

        String[] actions = {"♡  Favorites", "◉  Playlists", "◷  Recent"};
        for (String a : actions) {
            TextView v = button(a);
            LinearLayout.LayoutParams p =
                    new LinearLayout.LayoutParams(0, dp(48), 1);
            p.setMargins(dp(3), 0, dp(3), 0);
            row.addView(v, p);
        }
        root.addView(row, new LinearLayout.LayoutParams(-1, dp(54)));

        TextView made = text("Made for you", 21, white);
        made.setTypeface(null, android.graphics.Typeface.BOLD);
        made.setPadding(0, dp(22), 0, dp(8));
        root.addView(made, new LinearLayout.LayoutParams(-1, dp(58)));

        LinearLayout playlist = new LinearLayout(this);
        playlist.setOrientation(LinearLayout.VERTICAL);
        playlist.setPadding(dp(16), dp(12), dp(16), dp(12));
        playlist.setBackground(bg(card, 20));

        TextView p1 = text("MELORA MIX", 18, white);
        p1.setTypeface(null, android.graphics.Typeface.BOLD);
        playlist.addView(p1, new LinearLayout.LayoutParams(-1, dp(34)));

        TextView p2 = text("A personal mix for your mood", 14, muted);
        playlist.addView(p2, new LinearLayout.LayoutParams(-1, dp(30)));

        TextView play = button("▶  Play");
        play.setBackground(bg(Color.rgb(120, 55, 180), 20));
        play.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "MELORA MIX is ready to play",
                        Toast.LENGTH_SHORT).show());
        LinearLayout.LayoutParams playParams =
                new LinearLayout.LayoutParams(dp(110), dp(42));
        playParams.topMargin = dp(8);
        playlist.addView(play, playParams);

        root.addView(playlist, new LinearLayout.LayoutParams(-1, dp(136)));

        TextView now = text("Now playing", 21, white);
        now.setTypeface(null, android.graphics.Typeface.BOLD);
        now.setPadding(0, dp(22), 0, dp(8));
        root.addView(now, new LinearLayout.LayoutParams(-1, dp(58)));

        LinearLayout player = new LinearLayout(this);
        player.setGravity(Gravity.CENTER_VERTICAL);
        player.setPadding(dp(16), dp(10), dp(16), dp(10));
        player.setBackground(bg(Color.rgb(30, 25, 39), 22));

        LinearLayout names = new LinearLayout(this);
        names.setOrientation(LinearLayout.VERTICAL);
        TextView song = text("Choose a song", 17, white);
        song.setTypeface(null, android.graphics.Typeface.BOLD);
        TextView artist = text("MELORA", 13, muted);
        names.addView(song, new LinearLayout.LayoutParams(-1, dp(28)));
        names.addView(artist, new LinearLayout.LayoutParams(-1, dp(24)));

        player.addView(names, new LinearLayout.LayoutParams(0, dp(58), 1));

        TextView previous = button("◀");
        TextView playMain = button("▶");
        TextView next = button("▶");
        playMain.setBackground(bg(purple, 24));

        player.addView(previous, new LinearLayout.LayoutParams(dp(46), dp(46)));
        LinearLayout.LayoutParams pp = new LinearLayout.LayoutParams(dp(54), dp(46));
        pp.setMargins(dp(6), 0, dp(6), 0);
        player.addView(playMain, pp);
        player.addView(next, new LinearLayout.LayoutParams(dp(46), dp(46)));

        playMain.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Add your music player here",
                        Toast.LENGTH_SHORT).show());

        LinearLayout.LayoutParams playerParams =
                new LinearLayout.LayoutParams(-1, dp(78));
        playerParams.weight = 1;
        root.addView(player, playerParams);

        TextView nav = text("⌂  Home        ♫  Library        ⚙  Settings", 14, muted);
        nav.setGravity(Gravity.CENTER);
        nav.setPadding(0, dp(8), 0, 0);
        root.addView(nav, new LinearLayout.LayoutParams(-1, dp(48)));

        setContentView(root);
    }
}
