package edu.wit.comp2000.jasonfagerberg.application2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JFrame implements ActionListener
	{

		private String input = "";
		private Calculator calculator = new Calculator();
		private JPanel[] row = new JPanel[6];// number of rows in the calc
		private JButton[] buttons = new JButton[20]; // number of buttons on the calc
		private String[] buttonString =
			{
					"C", "<", "Q", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", "(", ")", "="
			};// all button strings
		private int[] dimW =
			{
					300, 45, 45, 45
			};// dimensions for the width
		private int[] dimH =
			{
					35, 40
			};// dimensions for the height
		private Dimension displayDimension = new Dimension(dimW[0], dimH[0]);// display
																		// dimensions
		private Dimension regularDimension = new Dimension(dimW[1], dimH[1]);//
		private Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
		private Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
		private boolean[] function = new boolean[4];
		private double[] temporary =
			{
					0, 0
			};
		private JTextArea display = new JTextArea(1, 21);
		private Font font = new Font("Times new Roman", Font.BOLD, 14);

		public Gui()
			{
				super("Test Calculator");
				setDesign();
				setSize(400, 500);// sets the size of the window
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				GridLayout grid = new GridLayout(5, 5);
				setLayout(grid);
				for (int i = 0; i < 4; i++)
					function[i] = false;
				FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
				FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);

				// This code is what I think is jumbling the buttons
				/**
				 * for(int i = 0; i < 5; i++) row[i] = new JPanel();
				 * row[0].setLayout(f1); for(int i = 1; i < 5; i++)
				 * row[i].setLayout(f2); for(int i = 0; i < 19; i++) {
				 * buttons[i] = new JButton();
				 * buttons[i].setText(buttonString[i]);
				 * buttons[i].setFont(font); buttons[i].addActionListener(this);
				 * }
				 */

				// heres my attempt at fixing this code without loops
				row[0] = new JPanel();
				row[1] = new JPanel();
				row[2] = new JPanel();
				row[3] = new JPanel();
				row[4] = new JPanel();
				row[0].setLayout(f1);
				row[1].setLayout(f2);
				row[2].setLayout(f2);
				row[3].setLayout(f2);
				row[4].setLayout(f2);
				// for button 1
				buttons[0] = new JButton();
				buttons[0].setText(buttonString[0]);
				buttons[0].setFont(font);
				buttons[0].addActionListener(this);
				// for button 2
				buttons[1] = new JButton();
				buttons[1].setText(buttonString[1]);
				buttons[1].setFont(font);
				buttons[1].addActionListener(this);
				// for button 3
				buttons[2] = new JButton();
				buttons[2].setText(buttonString[2]);
				buttons[2].setFont(font);
				buttons[2].addActionListener(this);
				// button 4
				buttons[3] = new JButton();
				buttons[3].setText(buttonString[3]);
				buttons[3].setFont(font);
				buttons[3].addActionListener(this);
				// button 5
				buttons[4] = new JButton();
				buttons[4].setText(buttonString[4]);
				buttons[4].setFont(font);
				buttons[4].addActionListener(this);
				// button 6
				buttons[5] = new JButton();
				buttons[5].setText(buttonString[5]);
				buttons[5].setFont(font);
				buttons[5].addActionListener(this);
				// button 7
				buttons[6] = new JButton();
				buttons[6].setText(buttonString[6]);
				buttons[6].setFont(font);
				buttons[6].addActionListener(this);
				// button 8
				buttons[7] = new JButton();
				buttons[7].setText(buttonString[7]);
				buttons[7].setFont(font);
				buttons[7].addActionListener(this);
				// button 9
				buttons[8] = new JButton();
				buttons[8].setText(buttonString[8]);
				buttons[8].setFont(font);
				buttons[8].addActionListener(this);
				// button 10
				buttons[9] = new JButton();
				buttons[9].setText(buttonString[9]);
				buttons[9].setFont(font);
				buttons[9].addActionListener(this);
				// button 11
				buttons[10] = new JButton();
				buttons[10].setText(buttonString[10]);
				buttons[10].setFont(font);
				buttons[10].addActionListener(this);
				// button 12
				buttons[11] = new JButton();
				buttons[11].setText(buttonString[11]);
				buttons[11].setFont(font);
				buttons[11].addActionListener(this);
				// button 13
				buttons[12] = new JButton();
				buttons[12].setText(buttonString[12]);
				buttons[12].setFont(font);
				buttons[12].addActionListener(this);
				// button 14
				buttons[13] = new JButton();
				buttons[13].setText(buttonString[13]);
				buttons[13].setFont(font);
				buttons[13].addActionListener(this);
				// button 15
				buttons[14] = new JButton();
				buttons[14].setText(buttonString[14]);
				buttons[14].setFont(font);
				buttons[14].addActionListener(this);
				// button 16
				buttons[15] = new JButton();
				buttons[15].setText(buttonString[15]);
				buttons[15].setFont(font);
				buttons[15].addActionListener(this);
				// button 17
				buttons[16] = new JButton();
				buttons[16].setText(buttonString[16]);
				buttons[16].setFont(font);
				buttons[16].addActionListener(this);
				// button 18
				buttons[17] = new JButton();
				buttons[17].setText(buttonString[17]);
				buttons[17].setFont(font);
				buttons[17].addActionListener(this);
				// button 19
				buttons[18] = new JButton();
				buttons[18].setText(buttonString[18]);
				buttons[18].setFont(font);
				buttons[18].addActionListener(this);
				// button 20
				buttons[19] = new JButton();
				buttons[19].setText(buttonString[19]);
				buttons[19].setFont(font);
				buttons[19].addActionListener(this);

				display.setFont(font);
				display.setEditable(false);
				display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				display.setPreferredSize(displayDimension);
				for (int i = 0; i < 19; i++)
					buttons[i].setPreferredSize(regularDimension);
				// for(int i = 14; i < 19; i++)
				// buttons[i].setPreferredSize(regularDimension);
				// buttons[17].setPreferredSize(regularDimension);
				// adds the display and components for row 1
				row[0].add(display);

				row[0].add(buttons[0]);
				row[0].add(buttons[1]);
				row[0].add(buttons[2]);
				row[0].add(buttons[3]);
				add(row[0]);

				// row[1].add(display);
				row[1].add(buttons[4]);
				row[1].add(buttons[5]);
				row[1].add(buttons[6]);
				row[1].add(buttons[7]);
				add(row[1]);

				// row[2].add(display);
				row[2].add(buttons[8]);
				row[2].add(buttons[9]);
				row[2].add(buttons[10]);
				row[2].add(buttons[11]);
				add(row[2]);

				// row[3].add(display);
				row[3].add(buttons[12]);
				row[3].add(buttons[13]);
				row[3].add(buttons[14]);
				row[3].add(buttons[15]);
				add(row[3]);

				// row[4].add(display);
				row[4].add(buttons[16]);
				row[4].add(buttons[17]);
				row[4].add(buttons[18]);
				row[4].add(buttons[19]);
				add(row[4]);

				// This is where my loop messed up the buttons
				/**
				 * //for row 2 for(int i = 0; i < 4; i++){
				 * row[1].add(buttons[i]); row[1].add(buttons[14]); add(row[1]);
				 * } //for row 3 for(int i = 4; i < 8; i++){
				 * row[2].add(buttons[i]); row[2].add(buttons[15]); add(row[2]);
				 * } //for row 4 for(int i = 8; i < 12; i++){
				 * row[3].add(buttons[i]); row[3].add(buttons[16]); add(row[3]);
				 * } //for row 5 row[4].add(buttons[18]); for(int i = 12; i <
				 * 14; i++){ row[4].add(buttons[i]); row[4].add(buttons[17]);
				 * add(row[4]); }
				 */
				setVisible(true);
			}

		public final void setDesign()
			{
				try
					{
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					}
				catch (Exception e)
					{
					}
			}

		// button labels are wrong and methods wont be included in this
		@Override
		public void actionPerformed(ActionEvent ae)
			{
				if (ae.getSource() == buttons[0])
					{
					display.append("C");
					display.setText("");
					input="";
				// add clear code here
					}
				if (ae.getSource() == buttons[1])
					{
					display.append("<");
				// button not needed
					}
				if (ae.getSource() == buttons[2])
					{
					display.append("Q");
				// button not needed
					}
				if (ae.getSource() == buttons[3])
				// divide
					{
						display.append("/");
						// add divide code here'
						input += "/";
					}
				if (ae.getSource() == buttons[4])
					{
						display.append("7");
						input += "7";
					}
				if (ae.getSource() == buttons[5])
					{
						display.append("8");
						input += "8";
					}
				if (ae.getSource() == buttons[6])
					{
						display.append("9");
						input += "9";
					}
				if (ae.getSource() == buttons[7])
				// multiply
					{
						display.append("*");
						input += "*";
					}
				// add multiply code here
				if (ae.getSource() == buttons[8])
					{
						display.append("4");
						input += "4";
					}
				if (ae.getSource() == buttons[9])
					{
						display.append("5");
						input += "5";
					}
				if (ae.getSource() == buttons[10])
					{
						display.append("6");
						input += "6";
					}
				if (ae.getSource() == buttons[11])
				// subtract
					{
						display.append("-");
						input += "-";
					}
				// add subtract code here
				if (ae.getSource() == buttons[12])
					{
						display.append("1");
						input += "1";
					}
				if (ae.getSource() == buttons[13])
					{
						display.append("2");
						input += "2";
					}
				if (ae.getSource() == buttons[14])
					{
						display.append("3");
						input += "3";
					}
				if (ae.getSource() == buttons[15])
				// add
					{
						display.append("+");
						input += "+";
					}
				// add addition code here
				if (ae.getSource() == buttons[16])
					{
						display.append("0");
						input += "0";
					}
				if (ae.getSource() == buttons[17])
					{
						display.append("(");
						input += "(";
					}
				// button not used
				if (ae.getSource() == buttons[18])
					{
						display.append(")");
						input += ")";
					}
				// button not used
				if (ae.getSource() == buttons[19])
					{
						display.append("=");
						calculator.setInput(input);
						display.append(String.valueOf(calculator.giveAnswer()));
					}
				// add evaluate code here

			}

		public static void main(String[] args)
			{
				Gui c = new Gui();
			}

	}
