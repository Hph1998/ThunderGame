package Game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {

	private File file;
	private AudioInputStream stream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip clip;
	
	void open(String s) {
		file = new File(s);
		try {
			stream = AudioSystem.getAudioInputStream(file);
			format = stream.getFormat();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void play() {
		info = new DataLine.Info(Clip.class, format);
		try {
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);//将音频数据读入音频行
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void stop() {
		clip.stop();//暂停音频播放
	}
	
	void start() {
		clip.start();//播放音频
	}
	
	void loop() {
		clip.loop(20);//回放
	}
}
