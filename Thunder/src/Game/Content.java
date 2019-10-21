package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Content extends JPanel implements KeyListener {
	//����
	private Image background1, background2;
	//����ͼƬ��y����
	private int background1_y;
	private int background2_y;
	
	private int life = 3;
	private long score = 0;
	
	private List<Life> lifes = new ArrayList<Life>();
	Font font = new Font("����", Font.BOLD, 30);
	//�ɻ�
	private Myplane me1;
	//�ҵ��ӵ�
	private List<Mybullet> mybullet1 = new ArrayList<Mybullet>();
	//�л�
	private List<Enemyplane> enemy1 = new ArrayList<Enemyplane>();
	//�����ӵ�
	private List<Enemybullet> enemybullet1 = new ArrayList<Enemybullet>();
	//���˱�ը
	private List<Break> breakplane = new ArrayList<Break>();
	
	//�������
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	//��Ϸ����
	private Gameover gameover;
	
	public Content(Home h) {
		this.addKeyListener(this);
		lifes.add(new Life(90, 715));
		me1 = new Myplane(200, 650);
		background1_y = 0;
		background2_y = -800;
		
		Thread thread = new Thread() {
			public void run() {
				background1 = background2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/map.jpg"));
				long time = 0;
				while (true) {
					//�ҷ��ƶ�
					if (up)
						me1.Up(2);
					if (down)
						me1.Down(2);
					if (left)
						me1.Left(2);
					if (right)
						me1.Right(2);
					//�л��ƶ�
					Enemymove(time);
					//����л�
					Addnewenemy1(time,score);
					Addnewenemy2(time,score);
					Addnewenemy3(time,score);
					Addnewenemy4(time,score);
					Addnewenemy5(time,score);
					Addnewenemy6(time,score);
					//�л������ӵ�
					Enemybullet(time);
					//��ͼ�ƶ�
					Mapmove();
					//ȥ����ը
					Breakremove(time);
					//�ҷ��ӵ�
					for (int i = 0; i < mybullet1.size(); i++) {
						mybullet1.get(i).move(time);
						mybullet1VSEnemy(i);
					}
					if (time % 150 == 0) {
						Mybullet bullet = me1.fire();
						mybullet1.add(bullet);
					}
					//�з��ӵ�
					for (int i = 0; i < enemybullet1.size(); i++) {
						// ebul1ÿ��һ��ʱ���ƶ�һ��
						enemybullet1.get(i).move(time);
						//�е�
						Enemybullet1VSmyplane(i);
					}
					//�з��ɻ�
					for (int i = 0; i < enemy1.size(); i++) {
						Enemy1VSmyplane(i);
					}
					time += 30;
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			//������ͼ�ƶ�
			private void Mapmove() {
				background1_y += 1;
				background2_y += 1;
				if(background1_y == 800)
					background1_y = -800;
				if(background2_y == 800)
					background2_y = -800;
			}
			//�з��ƶ�
			private void Enemymove(long time) {
				for (Enemyplane enemy1 : enemy1) {
					enemy1.move(time);
				}
			}
			//�����µ���
			private void Addnewenemy1(long time,long score) {
				if (time % 3000 == 0 && score <=500) {
					Enemyplane e1 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy1png);
					enemy1.add(e1);
				}
			}
			private void Addnewenemy2(long time,long score){
				if (time % 2400 == 0 && score>=500 && score<=1200) {
					Enemyplane e2 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy2png);
					enemy1.add(e2);
				}
			}
			private void Addnewenemy3(long time,long score){
				if (time % 1800 == 0 && score>=1200 && score<=2000) {
					Enemyplane e3 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy3png);
					enemy1.add(e3);
				}
			}
			private void Addnewenemy4(long time,long score){
				if (time % 1500 == 0 && score>=2000 && score<=4000) {
					Enemyplane e4 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy4png);
					enemy1.add(e4);
				}
			}
			private void Addnewenemy5(long time,long score){
				if (time % 1200 == 0 && score>=4000 && score<=7000) {
					Enemyplane e5 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy5png);
					enemy1.add(e5);
				}
			}
			private void Addnewenemy6(long time,long score){
				if (time % 900 == 0 && score>=7000 && score<=10000) {
					Enemyplane e5 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy5png);
					enemy1.add(e5);
				}
				if (time % 1200 == 0 && score>=7000 && score<=10000) {
					Enemyplane e4 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy4png);
					enemy1.add(e4);
				}
				if (time % 1500 == 0 && score>=7000 && score<=10000) {
					Enemyplane e3 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy3png);
					enemy1.add(e3);
				}
				if (time % 1800 == 0 && score>=7000 && score<=10000) {
					Enemyplane e2 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy2png);
					enemy1.add(e2);
				}
				if (time % 2400 == 0 && score>=7000 && score<=10000) {
					Enemyplane e1 = new Enemyplane((int) (Math.random() * 390)+1, 0,100, 100, PM.enemy1png);
					enemy1.add(e1);
				}
			}
			//�з��ӵ�
			private void Enemybullet(long time) {
				if (time % 4500 == 0) {
					for (Enemyplane e1 : enemy1) {
						Enemybullet b1 = e1.fire(35, 35, PM.enemybulletpng);
						enemybullet1.add(b1);
					}
				}			
			}
			//�ɻ���ը
			private void Breakplane() {
					for (Enemyplane e1 : enemy1) {
						Break b1 = e1.breakplane(70, 70, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/break.gif")));
						breakplane.add(b1);
					}
			}
			private void Breakremove(long time) {
					if (time % 3000 == 0) 
						breakplane.removeAll(breakplane);
			}
			private void mybullet1VSEnemy(int i) {
				int mb1x = mybullet1.get(i).getX();
				int mb1y = mybullet1.get(i).getY();
				if (mb1y < 0) {
					mybullet1.remove(mybullet1.get(i));
					return;
				}
				boolean isCovered = true;
				for (int j = 0; j < enemy1.size(); j++) {
					int e1x = enemy1.get(j).getX();
					int e1y = enemy1.get(j).getY();
					if (e1x - mb1x < 10 && mb1x - e1x < 70 && mb1y - e1y > 0 && mb1y - e1y < 30) {
						Breakplane();
						enemy1.remove(enemy1.get(j));
						if (isCovered) {
							mybullet1.remove(mybullet1.get(i));
							isCovered = false;
						}
						score += 20;
					}
				}
			}
			private void Enemy1VSmyplane(int i) {
				int mpx = me1.getX();
				int mpy = me1.getY();
				int e1x = enemy1.get(i).x;
				int e1y = enemy1.get(i).y;
				if (mpx - e1x < 90 && e1x - mpx < 55 && mpy - e1y < 40
						&& e1y - mpy < 50) {
					Breakplane();
					enemy1.remove(enemy1.get(i));
					life = life - 1;
				}
				if (e1y > 800) {
					enemy1.remove(enemy1.get(i));
				}
			}
			private void Enemybullet1VSmyplane(int i) {
				int mpx = me1.getX();
				int mpy = me1.getY();
				int eb1x = enemybullet1.get(i).getX();
				int eb1y = enemybullet1.get(i).getY();
				if (mpx - eb1x < 30 && eb1x - mpx < 60 && mpy - eb1y < 10
						&& eb1y - mpy < 50) {
					Breakplane();
					enemybullet1.remove(enemybullet1.get(i));
					life = life - 1;
				}
				if (eb1y > 800) {
					enemybullet1.remove(enemybullet1.get(i));
				}
			}
		};
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(background1, 0, background1_y, 500, 800, this);
		g.drawImage(background2, 0, background2_y, 500, 800, this);
		g.setFont(font);
		g.setColor(Color.GREEN);
		g.drawString("score:" + score, 10, 27);
		g.drawString("����:  X" + life, 10, 740);
		for (Life lifes : lifes)
			lifes.draw(g);
		me1.draw(g);
		for (Mybullet bullet : mybullet1)
			bullet.draw(g);
		for (Enemyplane enemy1 : enemy1)
			enemy1.draw(g);
		for (Enemybullet enemybullet1 : enemybullet1)
			enemybullet1.draw(g);
		for (Break breakplane : breakplane)
			breakplane.draw(g);
		//��Ϸ����
		if (life <= 0) {
			gameover = new Gameover(0, 0, PM.gameoverjpg);
			gameover.draw(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
		int key = e.getKeyCode();
		//�����س�����
		if(key == KeyEvent.VK_ENTER&&life <= 0) {
			score = 0;
			life = 3;
			me1.x = 200;
			me1.y = 650;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}
}
