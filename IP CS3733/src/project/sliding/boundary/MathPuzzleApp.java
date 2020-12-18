package project.sliding.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.sliding.controller.MoveTileController;
import project.sliding.controller.ResetController;
import project.sliding.controller.SelectTileController;
import project.sliding.model.Model;
import project.sliding.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MathPuzzleApp extends JFrame {

	private JPanel contentPane;

	PuzzlePanel panel;
	Model model;
    JButton btnUp, btnDown, btnLeft, btnRight, btnReset;
	
    public PuzzlePanel getPuzzlePanel() { return panel; }
    
    public JButton getUpButton() { return btnUp; }
    public JButton getDownButton() { return btnDown; }
    public JButton getLeftButton() { return btnLeft; }
    public JButton getRightButton() { return btnRight; }
	/**
	 * Create the frame.
	 */
	public MathPuzzleApp(Model m) {
		super();
		setTitle("Math Puzzle Application");
		this.model = m;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 621, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(m);
		panel.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, MathPuzzleApp.this).process(me.getPoint());
			}
		});
		
		btnUp = new JButton("^");
		btnDown = new JButton("v");
		btnLeft = new JButton("<");
		btnRight = new JButton(">");
		btnReset = new JButton("Reset");
		
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, MathPuzzleApp.this).move(MoveType.Up);
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, MathPuzzleApp.this).move(MoveType.Down);
			}
		});
		
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, MathPuzzleApp.this).move(MoveType.Left);
			}
		});
		
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, MathPuzzleApp.this).move(MoveType.Right);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, MathPuzzleApp.this).reset();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(94)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnDown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addComponent(btnLeft)
									.addGap(72)
									.addComponent(btnRight)))
							.addGap(60))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addComponent(btnUp)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLeft)
								.addComponent(btnRight))
							.addGap(15)
							.addComponent(btnDown)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
