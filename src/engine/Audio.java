package engine;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Audio {
    //test
    private Clip clip;
    private File audioFile;
    private AudioInputStream audioInputStream;
    private boolean isLoop;

    public Audio(String pathName, boolean isLoop) {
        try {
            clip = AudioSystem.getClip();
            audioFile = new File(pathName);
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        clip.setFramePosition(0);
        clip.start();
        if(isLoop) clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
