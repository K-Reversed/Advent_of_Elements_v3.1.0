package Java.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class AudioPlayer {
    private Clip clip;
    private final URL[] audioURL = new URL[30];

    public AudioPlayer() {
        audioURL[0] = getClass().getResource("/res/audio/Cave Music V2.wav");
        audioURL[1] = getClass().getResource("/res/audio/Title Screen Music.wav");
        audioURL[2] = getClass().getResource("/res/audio/SoundEffects/70142__robinhood76__00984-wood-hit-4.wav");
        audioURL[3] = getClass().getResource("/res/audio/SoundEffects/566434__merrick079__punch3.wav");
        audioURL[4] = getClass().getResource("/res/audio/Acoustic Plains - FM Piano Version.wav");
        audioURL[5] = getClass().getResource("/res/audio/SoundEffects/519065__angelkunev__door-unlock.wav");
        audioURL[6] = getClass().getResource("/res/audio/SoundEffects/426596__mootmcnoodles__clink.wav");
        audioURL[7] = getClass().getResource("/res/audio/SoundEffects/123018__j1987__cardoorlock.wav");
        audioURL[8] = getClass().getResource("/res/audio/Acoustic Plains - Acoustic Guitar Version.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e){
            clip = null;
        }

    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
