package gpaCalculator;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Utilities;

public class GPACalculator {
	public static void main(String[] args)
	{
		JFrame frame = new GPAFrame();
		frame.setName("GPA & CGPA Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

class GPAFrame extends JFrame
{
	public GPAFrame()
	{
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 100,  (Toolkit.getDefaultToolkit().getScreenSize().height/2 + 100));
		setResizable(false);
		add(new GPAComponent());
	}
}

class GPAComponent extends JPanel
{
	JLabel empty = new JLabel(" ");
	JLabel title = new JLabel("GPA & CGPA Calculator", SwingConstants.CENTER);
	JLabel subjects = new JLabel("How many Subjects?");
	JLabel subjOne = new JLabel("Subject 1: ");
	JLabel subjTwo = new JLabel("Subject 2: ");
	JLabel subjThree = new JLabel("Subject 3: ");
	JLabel subjFour = new JLabel("Subject 4: ");
	JLabel subjFive = new JLabel("Subject 5: ");
	JLabel subjSix = new JLabel("Subject 6: ");
	
	JLabel semCredits = new JLabel("Total Credits this Semester: ");
	JLabel totCredits = new JLabel("Total Credits Before this Semester: ");
	JLabel curCGPA = new JLabel("Current CGPA: ");
	JLabel newGPA = new JLabel("New GPA: ");
	JLabel newCGPA = new JLabel("New CGPA: ");
	
	JTextField semesterCredits = new JTextField();
	JTextField totalCredits = new JTextField();
	JTextField currentCGPA = new JTextField();
	JTextField oneCredits = new JTextField();
	JTextField twoCredits = new JTextField();
	JTextField threeCredits = new JTextField();
	JTextField fourCredits = new JTextField();
	JTextField fiveCredits = new JTextField();
	JTextField sixCredits = new JTextField();
	
	String[] subjNo = {"5", "6"};
	String[] grades = {"A", "A-", "B+", "B", "B-", "C+"};
	
	JComboBox subjectList = new JComboBox(subjNo);
	JComboBox gradeOneList = new JComboBox(grades);
	JComboBox gradeTwoList = new JComboBox(grades);
	JComboBox gradeThreeList = new JComboBox(grades);
	JComboBox gradeFourList = new JComboBox(grades);
	JComboBox gradeFiveList = new JComboBox(grades);
	JComboBox gradeSixList = new JComboBox(grades);

	JButton calcGPA = new JButton("Calculate GPA");
	JButton calcCGPA = new JButton("Calculate CGPA");
	
	
	Dimension subjSize = subjects.getPreferredSize();
	Dimension titleSize = title.getPreferredSize();
	
	Component spaceOne;
	Component spaceLabelOne, spaceLabelTwo, spaceLabelThree, spaceLabelFour, spaceLabelFive, spaceLabelSix;
	
	int creditsAdd;
	double GPAvalue;
	
	public GPAComponent()
	{
		
		semesterCredits.setEditable(false);
		semesterCredits.setBorder(null);
		JPanel grid7 = new JPanel();
		grid7.setLayout(new BoxLayout(grid7,BoxLayout.Y_AXIS));
		spaceLabelOne = Box.createRigidArea(new Dimension(80,58));
		spaceLabelTwo = Box.createRigidArea(new Dimension(80,58));
		spaceLabelThree = Box.createRigidArea(new Dimension(80,58));
		spaceLabelFour = Box.createRigidArea(new Dimension(80,58));
		spaceLabelFive = Box.createRigidArea(new Dimension(80,58));
		spaceLabelSix = Box.createRigidArea(new Dimension(80,58));
		
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border padding2 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		setBorder(padding);
		setLayout(new BorderLayout());
		
		subjects.setBounds(15, 30, subjSize.width, subjSize.height);
		add(title, BorderLayout.PAGE_START);
		JPanel grid1 = new JPanel(new GridLayout(1,2));
		JPanel grid2 = new JPanel();
		JPanel grid3 = new JPanel();
		
		grid2.setLayout(new BoxLayout(grid2, BoxLayout.Y_AXIS));
		grid3.setLayout(new BoxLayout(grid3, BoxLayout.Y_AXIS));
		grid1.add(grid2);
		grid1.add(grid3);
		subjectList.setBorder(padding2);
		gradeOneList.setBorder(padding2);
		gradeTwoList.setBorder(padding2);
		gradeThreeList.setBorder(padding2);
		gradeFourList.setBorder(padding2);
		gradeFiveList.setBorder(padding2);
		gradeSixList.setBorder(padding2);
		
		
		grid2.add(Box.createRigidArea(new Dimension(80,25)));
		grid2.add(subjects);

		grid3.add(subjectList);
		spaceOne = Box.createRigidArea(new Dimension(80,50));
		
		grid2.add(spaceOne);
				
		grid2.add(subjOne);
		grid3.add(gradeOneList);
		grid2.add(Box.createRigidArea(new Dimension(80,48)));

		grid2.add(subjTwo);
		grid3.add(gradeTwoList);
		grid2.add(Box.createRigidArea(new Dimension(80,48)));

		grid2.add(subjThree);
		grid3.add(gradeThreeList);
		grid2.add(Box.createRigidArea(new Dimension(80,48)));

		grid2.add(subjFour);
		grid3.add(gradeFourList);
		grid2.add(Box.createRigidArea(new Dimension(80,48)));

		grid2.add(subjFive);
		grid3.add(gradeFiveList);
		
		grid2.add(Box.createRigidArea(new Dimension(80,48)));
		
		subjSix.setVisible(false);
		gradeSixList.setEnabled(false);
		
		grid2.add(subjSix);
		grid3.add(gradeSixList);

		subjectList.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				if(subjectList.getSelectedIndex() == 1)
				{
					subjSix.setVisible(true);
					gradeSixList.setEnabled(true);
					sixCredits.setVisible(true);
					grid2.updateUI();
					
				}
				else {
					subjSix.setVisible(false);
					gradeSixList.setEnabled(false);
					sixCredits.setVisible(false);
				}
				}});
		JPanel grid4 = new JPanel(new GridLayout(1,2));
		
		//semesterCredits.setBorder(padding2);
		
		JPanel grid5 = new JPanel();
		grid5.setLayout(new BoxLayout(grid5, BoxLayout.Y_AXIS));
		grid4.add(grid5);
		
		grid5.add(Box.createRigidArea(new Dimension(80,30)));
		grid5.add(semCredits);
		grid5.add(Box.createRigidArea(new Dimension(80,40)));
		grid5.add(totCredits);
		grid5.add(Box.createRigidArea(new Dimension(80,40)));
		grid5.add(curCGPA);
		grid5.add(Box.createRigidArea(new Dimension(80,40)));
		grid5.add(calcGPA);
		grid5.add(Box.createRigidArea(new Dimension(80,20)));
		grid5.add(calcCGPA);
		grid5.add(Box.createRigidArea(new Dimension(80,40)));
		grid5.add(newGPA);
		grid5.add(Box.createRigidArea(new Dimension(80,40)));
		grid5.add(newCGPA);
		
		JPanel grid6 = new JPanel();
		grid6.setLayout(new BoxLayout(grid6, BoxLayout.Y_AXIS));
		grid4.add(grid6);
		
		//JPanel grid6 = new JPanel(new FlowLayout());
	
		semesterCredits.setMinimumSize(new Dimension(100,30));
		semesterCredits.setPreferredSize(new Dimension(100,30));
		semesterCredits.setMaximumSize(new Dimension(100,30));
		
		totalCredits.setMinimumSize(new Dimension(100,30));
		totalCredits.setPreferredSize(new Dimension(100,30));
		totalCredits.setMaximumSize(new Dimension(100,30));
		
		currentCGPA.setMinimumSize(new Dimension(100,30));
		currentCGPA.setPreferredSize(new Dimension(100,30));
		currentCGPA.setMaximumSize(new Dimension(100,30));
		
		grid6.add(Box.createRigidArea(new Dimension(80,25)));

		grid6.add(semesterCredits);
		grid6.add(Box.createRigidArea(new Dimension(80,25)));

		grid6.add(totalCredits);
		grid6.add(Box.createRigidArea(new Dimension(80,25)));

		grid6.add(currentCGPA);
		
		
		
		
		oneCredits.setMinimumSize(new Dimension(100,30));
		oneCredits.setPreferredSize(new Dimension(100,30));
		oneCredits.setMaximumSize(new Dimension(100,30));
		
		twoCredits.setMinimumSize(new Dimension(100,30));
		twoCredits.setPreferredSize(new Dimension(100,30));
		twoCredits.setMaximumSize(new Dimension(100,30));
		
		threeCredits.setMinimumSize(new Dimension(100,30));
		threeCredits.setPreferredSize(new Dimension(100,30));
		threeCredits.setMaximumSize(new Dimension(100,30));

		fourCredits.setMinimumSize(new Dimension(100,30));
		fourCredits.setPreferredSize(new Dimension(100,30));
		fourCredits.setMaximumSize(new Dimension(100,30));
  
		fiveCredits.setMinimumSize(new Dimension(100,30));
		fiveCredits.setPreferredSize(new Dimension(100,30));
		fiveCredits.setMaximumSize(new Dimension(100,30));
		
		fiveCredits.setMinimumSize(new Dimension(100,30));
		fiveCredits.setPreferredSize(new Dimension(100,30));
		fiveCredits.setMaximumSize(new Dimension(100,30));
		
		sixCredits.setMinimumSize(new Dimension(100,30));
		sixCredits.setPreferredSize(new Dimension(100,30));
		sixCredits.setMaximumSize(new Dimension(100,30));
		
		grid7.add(Box.createRigidArea(new Dimension(80, 82)));
		grid7.add(oneCredits);

		
		grid7.add(Box.createRigidArea(new Dimension(80, 35)));
		grid7.add(twoCredits);
		
		grid7.add(Box.createRigidArea(new Dimension(80, 35)));
		grid7.add(threeCredits);
		
		grid7.add(Box.createRigidArea(new Dimension(80, 35)));
		grid7.add(fourCredits);
		
		grid7.add(Box.createRigidArea(new Dimension(80, 35)));
		grid7.add(fiveCredits);
		
		grid7.add(Box.createRigidArea(new Dimension(80, 35)));
		sixCredits.setVisible(false);
		grid7.add(sixCredits);
		
		calcGPA.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				creditsAdd = Integer.parseInt(oneCredits.getText()) + Integer.parseInt(twoCredits.getText()) + Integer.parseInt(threeCredits.getText()) + Integer.parseInt(fourCredits.getText()) + Integer.parseInt(fiveCredits.getText());
				semesterCredits.setText(String.valueOf(creditsAdd));
				double sum = 0;
				
					int selection = gradeOneList.getSelectedIndex();
					
					switch(selection) {
					case 0:
						sum+= 4.00 * Integer.parseInt(oneCredits.getText());
						break;
					case 1:
						sum+= 3.70 * Integer.parseInt(oneCredits.getText());
						break;
					case 2:
						sum+= 3.30 * Integer.parseInt(oneCredits.getText());
						break;
					case 3:
						sum+= 3.00 * Integer.parseInt(oneCredits.getText());
						break;
					case 4:
						sum+= 2.70 * Integer.parseInt(oneCredits.getText());
						break;
					case 5:
						sum+= 2.40 * Integer.parseInt(oneCredits.getText());
						break;						
					}
					
					selection = gradeTwoList.getSelectedIndex();
					
					switch(selection) {
					case 0:
						sum+= 4.00 * Integer.parseInt(twoCredits.getText());
						break;
					case 1:
						sum+= 3.70 * Integer.parseInt(twoCredits.getText());
						break;
					case 2:
						sum+= 3.30 * Integer.parseInt(twoCredits.getText());
						break;
					case 3:
						sum+= 3.00 * Integer.parseInt(twoCredits.getText());
						break;
					case 4:
						sum+= 2.70 * Integer.parseInt(twoCredits.getText());
						break;
					case 5:
						sum+= 2.40 * Integer.parseInt(twoCredits.getText());
						break;						
					}
					selection = gradeThreeList.getSelectedIndex();
					
					switch(selection) {
					case 0:
						sum+= 4.00 * Integer.parseInt(threeCredits.getText());
						break;
					case 1:
						sum+= 3.70 * Integer.parseInt(threeCredits.getText());
						break;
					case 2:
						sum+= 3.30 * Integer.parseInt(threeCredits.getText());
						break;
					case 3:
						sum+= 3.00 * Integer.parseInt(threeCredits.getText());
						break;
					case 4:
						sum+= 2.70 * Integer.parseInt(threeCredits.getText());
						break;
					case 5:
						sum+= 2.40 * Integer.parseInt(threeCredits.getText());
						break;						
					}
					selection = gradeFourList.getSelectedIndex();
					
					switch(selection) {
					case 0:
						sum+= 4.00 * Integer.parseInt(fourCredits.getText());
						break;
					case 1:
						sum+= 3.70 * Integer.parseInt(fourCredits.getText());
						break;
					case 2:
						sum+= 3.30 * Integer.parseInt(fourCredits.getText());
						break;
					case 3:
						sum+= 3.00 * Integer.parseInt(fourCredits.getText());
						break;
					case 4:
						sum+= 2.70 * Integer.parseInt(fourCredits.getText());
						break;
					case 5:
						sum+= 2.40 * Integer.parseInt(fourCredits.getText());
						break;						
					}
					selection = gradeFiveList.getSelectedIndex();
					
					switch(selection) {
					case 0:
						sum+= 4.00 * Integer.parseInt(fiveCredits.getText());
						break;
					case 1:
						sum+= 3.70 * Integer.parseInt(fiveCredits.getText());
						break;
					case 2:
						sum+= 3.30 * Integer.parseInt(fiveCredits.getText());
						break;
					case 3:
						sum+= 3.00 * Integer.parseInt(fiveCredits.getText());
						break;
					case 4:
						sum+= 2.70 * Integer.parseInt(fiveCredits.getText());
						break;
					case 5:
						sum+= 2.40 * Integer.parseInt(fiveCredits.getText());
						break;						
					}
					
					if(subjectList.getSelectedIndex() == 1)
					{
						selection = gradeSixList.getSelectedIndex();
					
						switch(selection) {
						case 0:
							sum+= 4.00 * Integer.parseInt(sixCredits.getText());
							break;
						case 1:
							sum+= 3.70 * Integer.parseInt(sixCredits.getText());
							break;
						case 2:
							sum+= 3.30 * Integer.parseInt(sixCredits.getText());
							break;
						case 3:
							sum+= 3.00 * Integer.parseInt(sixCredits.getText());
							break;
						case 4:
							sum+= 2.70 * Integer.parseInt(sixCredits.getText());
							break;
						case 5:
							sum+= 2.40 * Integer.parseInt(sixCredits.getText());
							break;	
						}
					
					}
					
					GPAvalue = sum/Integer.parseInt(semesterCredits.getText());
					Math.round(GPAvalue);
					newGPA.setText("New GPA: " + GPAvalue);
					
				
				}});
		
		calcCGPA.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					if(semesterCredits.getText().isEmpty() || totalCredits.getText().isEmpty() || currentCGPA.getText().isEmpty())
					{
						newCGPA.setText("New CGPA: Error" );
					}
					else
					{
						double value = (Double.parseDouble(currentCGPA.getText()) + GPAvalue) / (Integer.parseInt(semesterCredits.getText() + Integer.parseInt(totalCredits.getText())));
						newCGPA.setText("New CGPA: " + String.valueOf(value));
					}
				}});
		
		//add(subjects, );
		//add(title);
		add(grid1, BorderLayout.LINE_START);
		add(grid7, BorderLayout.CENTER);
		add(grid4, BorderLayout.LINE_END);
		//add(grid6, BorderLayout.LINE_END);
	}
	
	
}
