package model;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.io.FileInputStream;

public class MusicTest implements Runnable {

    public MusicTest() {
    }

    public void playMusic() {
        AudioPlayer player = AudioPlayer.player;
        AudioStream stream;
        AudioData data;

        ContinuousAudioDataStream loop = null;

        try {
            stream = new AudioStream(new FileInputStream("src/main/khalidfloating.mp3"));
            data = stream.getData();
            loop = new ContinuousAudioDataStream(data);
            player.start(stream);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @Override
    public void run() {
        playMusic();
    }
}
