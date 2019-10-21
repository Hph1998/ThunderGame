package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JLabel background1, start, prompt;
	private Home h;
	static Music m;
	public Home() {
		super("雷电");
		setSize(500, 800);//设置窗体大小
		setIconImage(PM.icon);
		setLayout(null);//清除布局管理			
		Background();//设置背景	
		Label();//显示界面	
		Keyborad();//监听键盘
		if(m == null) {
			//声音设置
			m = new Music();
			m.open("D:\\eclipse\\Thunder\\src\\music.wav");	
			m.play();
			m.loop();
			m.start();
			
		}
		h = this;
	}

	public void Keyborad() {
		
		addKeyListener(new KeyAdapter() {	
			@Override
			public void keyPressed(KeyEvent e) {				
				int key = e.getKeyCode();
				//监听回车按键
				if(key == KeyEvent.VK_ENTER) {
					Content game = new Content(h);
					add(game);
					game.setSize(500, 800);
					game.setFocusable(true);
					game.requestFocus();
					//移除组件
					remove(start);
					remove(prompt);
				}
			}		
		});		
	}

	private void Background() {
		
		 //背景图片
	 	 ImageIcon background = new ImageIcon(getClass().getResource("/Home.jpg"));
	  	 //设置背景标签
	 	 background1 = new JLabel(background);
         //设置背景图片位置大小
	 	 background1.setBounds(0, 0, 500, 800);
         //面板透明
         JPanel j = (JPanel)getContentPane();
         j.setOpaque(false);
         //设置背景
         getLayeredPane().add(background1, new Integer(Integer.MIN_VALUE));
	}

	private void Label() {
		
		 //指示
	   	 ImageIcon icon = new ImageIcon(getClass().getResource("/prompt.gif"));
		 //设置标签
	   	 start = new JLabel("回车开始游戏");
	   	 start.setFont(new Font("黑体", Font.BOLD, 50));
	   	 start.setForeground(Color.black);
	   	 start.setBounds(135, 500, 400, 120);
		 
	   	 prompt = new JLabel(icon);
	   	 prompt.setBounds(-50, 500, 250, 120);

		 add(start);
		 add(prompt);

	}
	}
