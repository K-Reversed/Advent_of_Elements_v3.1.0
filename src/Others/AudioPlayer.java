package Others;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;


public class AudioPlayer {
    private Clip clip;
    private AudioInputStream aIS;
    private String status;
    private static String filePath;

    public AudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        aIS = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(aIS);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play(){
        clip.start();

        status = ("playing.");
    }

    public static void setFilePath(String filePath) {
        AudioPlayer.filePath = filePath;
    }
}