package Game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {
	static Home h;
	public static void main(String[] args) {
		h = new Home();
		//监听关闭窗体按钮
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置可视
		h.setVisible(true);
		//设置不可拉伸
		h.setResizable(false);
	}
}
