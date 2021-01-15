package audio;

import javax.sound.sampled.*;
import java.io.File;

public class Audio implements Runnable, java.io.Serializable {
    // VARIABLES
    private Clip clip;
    private String filepath;
    private double volume;

    // GETS
    public Clip getClip() {
        return clip;
    }

    public String getFilepath() {
        return filepath;
    }

    public double getVolume() {
        return volume;
    }

    // SETS
    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    // METHODS
    public void playMusic(String pFilePath, double pVolume, double pUpVolume) {
        try {
            File musicPath = new File(pFilePath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                setVolume(pVolume, clip);
                clip.start();
                upVolume(clip, pUpVolume);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("The filepath doesn't exist.");
            }
        } catch (Exception ignored) {
        }
    }

    public void playSFX(String pFilePath, double pVolume) {
        Thread t1 = new Thread() {
            public void run() {
                try {
                    File sfxPath = new File(pFilePath);

                    if (sfxPath.exists()) {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(sfxPath);
                        clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        if (clip.isActive()) {
                            setVolume(pVolume, clip);
                        }
                        clip.start();
                        audioInput.close();
                    } else {
                        System.out.println("The filepath doesn't exist.");
                    }
                    Thread.sleep(1100);
                    clip.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }

    public void upVolume(Clip pClip, double pVolume) {
        Thread t1 = new Thread(new Audio()) {
            public void run() {
                try {
                    double volume = getVolume();

                    while (volume < pVolume) {
                        Thread.sleep(100);
                        volume += 0.01;
                        setVolume(volume, pClip);
                    }
                } catch (Exception ignored) {
                }
            }
        };
        t1.start();
    }

    public void endVolume(Clip pClip) {
        Thread t1 = new Thread(new Audio()) {
            public void run() {
                try {
                    double volume1 = getVolume();

                    while (volume1 > 0) {
                        Thread.sleep(100);
                        volume1 -= 0.01;
                        setVolume(volume1, pClip);
                    }
                    pClip.stop();
                    setVolume(0.0, pClip);
                } catch (Exception ignored) {
                }
            }
        };
        t1.start();
    }

    public void stopMusic(Clip pClip) {
        try {
            pClip = getClip();
            pClip.stop();
        } catch (Exception ignored) {
        }
    }

    public void setVolume(double pVolume, Clip pClip) {
        FloatControl gain = (FloatControl) pClip.getControl((FloatControl.Type.MASTER_GAIN));
        float dB = (float) (Math.log(pVolume) / Math.log(10) * 20);
        gain.setValue(dB);
        this.volume = pVolume;
    }

    @Override
    public void run() {
    }
}
