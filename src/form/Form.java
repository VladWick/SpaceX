package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import classes.Company;
import classes.MyException;
import classes.Subscriber;
import classes.TarifPerMinute;
import classes.TarifPerSecond;
import classes.Tariff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Form {
	
						/***********************/
					    /*Initialize Components*/
					    /***********************/
	
	static Font font1 = new Font("Verdana", Font.PLAIN, 25);
	static Font font2 = new Font("Verdana", Font.PLAIN, 15);
	static Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
	
		/*Information menu*/
	Company myCompany = new Company();
	Tariff tarifBasic = new Tariff();
	TarifPerMinute tarifMinute = new TarifPerMinute();
	TarifPerSecond tarifSecond = new TarifPerSecond();
	Subscriber sub1 = new Subscriber();
	Subscriber sub2 = new Subscriber();
	Subscriber sub3 = new Subscriber();
	
		/*Add subscriber menu*/
	ArrayList<String> subsBasicName = new ArrayList<String>();
	ArrayList<String> subsSecondName = new ArrayList<String>();
	ArrayList<String> subsMinuteName = new ArrayList<String>();

	ArrayList<String> subsBasicPhone = new ArrayList<String>();
	ArrayList<String> subsSecondPhone = new ArrayList<String>();
	ArrayList<String> subsMinutePhone = new ArrayList<String>();

	ArrayList<String> subsBasicMoneyLeft = new ArrayList<String>();
	ArrayList<String> subsSecondMoneyLeft = new ArrayList<String>();
	ArrayList<String> subsMinuteMoneyLeft = new ArrayList<String>();

	ArrayList<ArrayList<String>> subsBasic = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> subsSecond = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> subsMinute = new ArrayList<ArrayList<String>>();

    /*Main method*/
    public void createGUI() throws MyException, IOException {

        myCompany.setName("SpaceX");

        tarifBasic.setNameOfTariff("Basic-tarif-#1");
        tarifBasic.setInfo("information about basic tarif");
        tarifBasic.setNumberOfSubscribers(25);

        tarifMinute.setInfo("information about tarif per minute");
        tarifMinute.setNumberOfMinutes(20);
        tarifMinute.setNumberOfSubscribers(40);
        tarifMinute.setNameOfTariff("Tarif-per-minute #1");

        tarifSecond.setInfo("information about tarif per second");
        tarifSecond.setNumberOfSeconds(100);
        tarifSecond.setNumberOfSubscribers(97);
        tarifMinute.setNameOfTariff("Tarif-per-second #1");

        sub1.setNewMoneyLeft("13900");
        sub1.setPhoneNumber("+78909876565");
        sub1.setFullName("Vladislav Butorin");

        sub2.setNewMoneyLeft("12300");
        sub2.setPhoneNumber("+79702876852");
        sub2.setFullName("Andrew Steve");

        sub3.setNewMoneyLeft("18500");
        sub3.setPhoneNumber("+87322838787");
        sub3.setFullName("Danil Klimov");

        /*----------------------------------*/
        /*----------------------------------*/
        /*----------Creating windows--------*/
        /*----------------------------------*/
        /*----------------------------------*/

        Font font1 = new Font("Verdana", Font.PLAIN, 25);
        Font font2 = new Font("Verdana", Font.PLAIN, 15);

                            /*----------------------------------*/
                            /*------------Information-----------*/
                            /*----------------------------------*/

        JFrame mainFrame = new JFrame();
        JMenuBar mb = new JMenuBar();

        /*-----------------------------------------*/
        JMenu info = new JMenu("");
        info.setText("Information");
        /*
        info.setHorizontalAlignment(JMenu.CENTER);
        info.setVerticalAlignment(JMenu.CENTER);
*/
        info.setPreferredSize(new Dimension(145, 50));
        info.setFont(new Font("sans-serif", Font.BOLD, 20));
        info.setBorder(BorderFactory.createLineBorder(Color.black));

        JMenuItem companyInfo = new JMenuItem("Information about 'SpaceX'");
        JMenuItem basicInfo = new JMenuItem("Information about tariff 'Basic'");
        JMenuItem secondInfo = new JMenuItem("Information about tariff 'Second'");
        JMenuItem minuteInfo = new JMenuItem("Information about tariff 'Minute'");

        info.add(companyInfo);
        info.add(basicInfo);
        info.add(secondInfo);
        info.add(minuteInfo);

        /*-----------------------------------------*/
        /*-----------------------------------------*/
        
        companyInfo.addActionListener(new CompanyInfoPressed());
        basicInfo.addActionListener(new TarifBasicInfoPressed());
        secondInfo.addActionListener(new TarifSecondInfoPressed());
        minuteInfo.addActionListener(new TarifMinuteInfoPressed());

					        /****************/
					        /*Add subscriber*/
					        /****************/

        JMenu addSub = new JMenu("Add subscriber");
        addSub.setPreferredSize(new Dimension(210 , 50));
        addSub.setFont(new Font("sans-serif", Font.ITALIC, 20));
        //addSub.setBorder(BorderFactory.createLineBorder(Color.black));
        //pane.setBorder(BorderFactory.createLineBorder(Color.black));

        JMenuItem basicOption = new JMenuItem("Tariff 'Basic'");
        JMenuItem secondOption = new JMenuItem("Tariff 'Second'");
        JMenuItem minuteOption = new JMenuItem("Tariff 'Minute'");

        addSub.add(basicOption);
        addSub.add(secondOption);
        addSub.add(minuteOption);

        /*-----------------------------------------*/
       
        subsBasicName.add(sub1.getFullName()); //subsBasicName.add(sub1.getFullName());
        subsSecondName.add(sub2.getFullName());
        subsMinuteName.add(sub3.getFullName());

        subsBasicPhone.add(sub1.getPhoneNumber()); //subsBasicPhone.add(sub1.getPhoneNumber());
        subsSecondPhone.add(sub2.getPhoneNumber());
        subsMinutePhone.add(sub3.getPhoneNumber());
        
        subsBasicMoneyLeft.add(sub1.getMoneyLeft()); //subsBasicMoneyLeft.add(sub1.getMoneyLeft());
        subsSecondMoneyLeft.add(sub2.getMoneyLeft());
        subsMinuteMoneyLeft.add(sub3.getMoneyLeft());

        subsBasic.add(subsBasicName); subsBasic.add(subsBasicPhone); subsBasic.add(subsBasicMoneyLeft);
        subsSecond.add(subsSecondName); subsSecond.add(subsSecondPhone); subsSecond.add(subsSecondMoneyLeft);
        subsMinute.add(subsMinuteName); subsMinute.add(subsMinutePhone); subsMinute.add(subsMinuteMoneyLeft);
        /*-----------------------------------------*/
        
        basicOption.addActionListener(new AddToBasicPressed());
        secondOption.addActionListener(new AddToSecondPressed());
        minuteOption.addActionListener(new AddToMinutePressed());
       
					        /*******************/
					        /*Delete subscriber*/
					        /*******************/
        
        JMenu removeSub = new JMenu("Delete subscriber");
        removeSub.setPreferredSize(new Dimension(200, 50));
        removeSub.setFont(new Font("sans-serif", Font.ITALIC, 20));
        //removeSub.setBorder(BorderFactory.createLineBorder(Color.black));

        JMenuItem basicRemove = new JMenuItem("Delete subscriber in tariff 'Basic'");
        JMenuItem secondRemove = new JMenuItem("Number of subscribers in tariff 'Second'");
        JMenuItem minuteRemove = new JMenuItem("Number of subscribers in tariff 'Minute'");

        removeSub.add(basicRemove);
        removeSub.add(secondRemove);
        removeSub.add(minuteRemove);

        /*-----------------------------------------*/

        basicRemove.addActionListener(new RemoveFromBasicPressed());
        secondRemove.addActionListener(new RemoveFromSecondPressed());
        minuteRemove.addActionListener(new RemoveFromMinutePressed());
        
					        /*******************/
					        /*Change subscriber*/
					        /*******************/

        JMenu changeSub = new JMenu("Change subscriber");
        changeSub.setPreferredSize(new Dimension(210, 50));
        changeSub.setFont(new Font("sans-serif", Font.ITALIC, 20));
        //changeSub.setBorder(BorderFactory.createLineBorder(Color.black));

        /*JLabel welcomeLabel= new JLabel();
        welcomeLabel.setFont(new Font("Name Of Font Suitable Font", Font.BOLD + Font.ITALIC, 100));
        welcomeLabel.setText("Welcome");*/

        JMenuItem basicChange = new JMenuItem("Change subscriber in tariff 'Basic'");
        JMenuItem secondChange = new JMenuItem("Change subscriber in tariff 'Second'");
        JMenuItem minuteChange = new JMenuItem("Change subscriber in tariff 'Minute'");

        changeSub.add(basicChange);
        changeSub.add(secondChange);
        changeSub.add(minuteChange);

        /*-----------------------------------------*/

        basicChange.addActionListener(new ChangeFromBasicPressed());
        secondChange.addActionListener(new ChangeFromSecondPressed());
        minuteChange.addActionListener(new ChangeFromMinutePressed());

					        /*********************/
					        /*List of subscribers*/
					        /*********************/

        JMenu listOfSubs = new JMenu("List of subscribers");
        listOfSubs.setPreferredSize(new Dimension(195, 50));
        listOfSubs.setFont(new Font("sans-serif", Font.BOLD, 20));
        listOfSubs.setBorder(BorderFactory.createLineBorder(Color.black));

        JMenuItem basicList = new JMenuItem("Number of subscribers in tariff 'Basic'");
        JMenuItem secondList = new JMenuItem("Number of subscribers in tariff 'Second'");
        JMenuItem minuteList = new JMenuItem("Number of subscribers in tariff 'Minute'");

        listOfSubs.add(basicList);
        listOfSubs.add(secondList);
        listOfSubs.add(minuteList);

        basicList.addActionListener(new ListOfBasicTariffPressed());
        secondList.addActionListener(new ListOfSecondTariffPressed());
        minuteList.addActionListener(new ListOfMinuteTariffPressed());
       

					       /*********************/
					       /***Main-area-frame***/
					       /*********************/
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(10, 10, 940, 600);
        BoxLayout boxLayoutMain = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayoutMain);

        /*-----------------------------------------*/

        JPanel instructionPanel = new JPanel();
        instructionPanel.setBounds(10, 10, 470, 337);
        instructionPanel.setBorder(solidBorder);

        BoxLayout boxLayoutLocal = new BoxLayout(instructionPanel, BoxLayout.Y_AXIS);
        //instructionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        instructionPanel.setLayout(boxLayoutLocal);

        JLabel instructionWordLabel = new JLabel("<html>Instruction<html/>");
        //instructionWordLabel.setBounds(0,0,980,100);
        instructionWordLabel.setVerticalAlignment(JLabel.CENTER);
        instructionWordLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionWordLabel.setFont(font1);
        instructionWordLabel.setBorder(solidBorder);
        //instructionWordLabel.setLayout(BorderLayout.WEST);

        /*-----------------------------------------*/

        JLabel instructionLabel = new JLabel();
        instructionLabel.setText("<html><br/><strong>Information:</strong><br/>&emsp Here you can read about tariffs that SpaceX has<br/>" +
                "<br/><strong>Add subscriber:</strong><br/>&emsp You can add subscribers to any tariff in this menu<br/>" +
                "<br/><strong>Delete subscriber:</strong><br/>&emsp You can delete subscribers from any tariff here.<br/>" +
                "<br/><strong>Change subscriber:</strong><br/>&emsp Here you can change any subscriber that you like<br/>" +
                "<br/><strong>List of subscribers:</strong><br/>&emsp Get information about subscribers in any tariff<br/><br/>" + "</html>");

        //instructionLabel.setBounds(10,10,960,400);
        instructionLabel.setBorder(solidBorder);
        instructionLabel.setFont(font2);
        instructionLabel.setVerticalAlignment(JLabel.CENTER);
        instructionLabel.setHorizontalAlignment(JLabel.CENTER);

        //instructionPanel.add(instructionWordLabel);
        instructionPanel.add(instructionLabel);

        /*-----------------------------------------*/

        BufferedImage spaceImage = ImageIO.read(Form.class.getResource("/images/spacex.jpg"));
        JLabel iconLabel = new JLabel(new ImageIcon(spaceImage));
        iconLabel.setBounds(10, 400, 200, 200);

        /*-----------------------------------------*/
        mainPanel.add(iconLabel);
        mainPanel.add(instructionPanel);
        /*
        instructionPanel.add(instructionWordLabel, BorderLayout.NORTH);
        instructionPanel.add(instructionLabel, BorderLayout.EAST);
*/

        /*-----------------------------------------*/
        /*-----------------------------------------*/

        mb.add(info);
        mb.add(addSub);
        mb.add(removeSub);
        mb.add(changeSub);
        mb.add(listOfSubs);

        mainFrame.add(mb);
        mainFrame.add(mainPanel);
        
        /*
        mainFrame.add(instructionWordLabel);
        mainFrame.add(instructionLabel);
*/
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setJMenuBar(mb);

        mainFrame.setBackground(Color.yellow);
        mainFrame.setName("JAVA. LAB-8.");
        mainFrame.setTitle("JAVA. LAB-8.");
        mainFrame.setLayout(null);
        mainFrame.pack();

        mainFrame.setSize(975,700);
        mainFrame.setVisible(true);

        mainFrame.setLocationRelativeTo(null);

        Image icon3 = new ImageIcon(Form.class.getResource("/icons/icon4.jpg")).getImage();
        mainFrame.setIconImage(icon3);

    }
}

					/******************/
					/*Action Listeners*/
					/******************/

class CompanyInfoPressed extends Form implements ActionListener{
	public CompanyInfoPressed() throws MyException, IOException {
							super();
							// TODO Auto-generated constructor stub
						}

	public void actionPerformed(ActionEvent e) { 
		System.out.println("'companyInfo' was used");

        JFrame f1 = new JFrame();
        
        String companyInfo = "'SpaceX' information";
        JDialog dialog = new JDialog(f1, companyInfo);
        dialog.setBounds(200+335, 260, 385, 220);
        //mainFrame.setSize(975,700);

        JLabel infoLabel = new JLabel();
        infoLabel.setFont(font2);
        infoLabel.setBounds(0,0,200, 180);

        String text2 = myCompany.getInfo();
        infoLabel.setText(text2);
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        dialog.add(infoLabel);
        dialog.setVisible(true);
	}
}

class TarifBasicInfoPressed extends Form implements ActionListener {
	public TarifBasicInfoPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) { 
        JFrame f1 = new JFrame();

        JDialog dialog = new JDialog(f1, "'Basic' tariff information");
        dialog.setBounds(200+335, 260, 325, 220);
        //mainFrame.setSize(975,700);

        JLabel infoLabel = new JLabel();
        infoLabel.setText(tarifBasic.getInfo());
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        dialog.add(infoLabel);
        dialog.setVisible(true);
	}
}

class TarifSecondInfoPressed extends Form implements ActionListener {
	
	
	public TarifSecondInfoPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) { 
		JFrame f1 = new JFrame();

        JDialog dialog = new JDialog(f1, "'Second' tariff information");
        dialog.setBounds(200+335, 260, 325, 220);
        //mainFrame.setSize(975,700);

        JLabel infoLabel = new JLabel();
        infoLabel.setText(tarifSecond.getInfo());
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        dialog.add(infoLabel);
        dialog.setVisible(true);
	}
}

class TarifMinuteInfoPressed extends Form implements ActionListener {
	public TarifMinuteInfoPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) { 
		JFrame f1 = new JFrame();

        JDialog dialog = new JDialog(f1, "'Minute' tariff information");
        dialog.setBounds(200+335, 140, 325, 420);
        //mainFrame.setSize(975,700);

        JLabel infoLabel = new JLabel();
        infoLabel.setText(tarifMinute.getInfo());
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        dialog.add(infoLabel);
        dialog.setVisible(true);
	}
}

class AddToBasicPressed extends Form implements ActionListener {
	public AddToBasicPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
        System.out.println("'basicOption' was used. ");

        JFrame f1 = new JFrame();
        String strNameFromInput, strPhoneNumberFromInput=null, strMoneyLeftFromInput;
        strNameFromInput = JOptionPane.showInputDialog("Enter name of subscriber...");

        if(!strNameFromInput.isEmpty()){
            strPhoneNumberFromInput = JOptionPane.showInputDialog("Enter phone of subscriber...");
            if(!strPhoneNumberFromInput.isEmpty() && (Integer.parseInt(strPhoneNumberFromInput)) > 0) {
                strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter balance of subscriber...");
                if(!strMoneyLeftFromInput.isEmpty() && (Integer.parseInt(strMoneyLeftFromInput)) > 0) {
                    String message = "New subscriber\n" +
                            "      Name: " + strNameFromInput + "\n" +
                            "      Phone: " + strPhoneNumberFromInput + "\n" +
                            "      Balance: " + strMoneyLeftFromInput;
                    JOptionPane.showMessageDialog(f1, message);

                    subsBasicName.add(strNameFromInput);
                    subsBasicPhone.add(strPhoneNumberFromInput);
                    subsBasicMoneyLeft.add(strMoneyLeftFromInput);

                    ArrayList<String> array = new ArrayList<String>();
                    array.add(subsBasicName.get(subsBasicName.size() - 1));
                    array.add(subsBasicPhone.get(subsBasicPhone.size() - 1));
                    array.add(subsBasicMoneyLeft.get(subsBasicMoneyLeft.size() - 1));

                    subsBasic.add(array);

                    System.out.println("New subscriber was added to a 'Basic' tarif.");

                } else {
                    JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid name. \nTry again.");
        }
    }
}

class AddToSecondPressed extends Form implements ActionListener {
	public AddToSecondPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();
        String strNameFromInput, strPhoneNumberFromInput = null, strMoneyLeftFromInput = null;
        strNameFromInput = JOptionPane.showInputDialog("Enter name of subscriber...");

        if(!strNameFromInput.isEmpty()){
            strPhoneNumberFromInput = JOptionPane.showInputDialog("Enter phone of subscriber...");

            if(!strPhoneNumberFromInput.isEmpty()){
                strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter balance of subscriber...");

                if(!strMoneyLeftFromInput.isEmpty()) {

                    String message = "New subscriber\n" +
                            "      Name: " + strNameFromInput + "\n" +
                            "      Phone: " + strPhoneNumberFromInput + "\n" +
                            "      Balance: " + strMoneyLeftFromInput;
                    JOptionPane.showMessageDialog(f1, message);

                    subsSecondName.add(strNameFromInput);
                    subsSecondPhone.add(strPhoneNumberFromInput);
                    subsSecondMoneyLeft.add(strMoneyLeftFromInput);

                    ArrayList<String> array = new ArrayList<String>();
                    array.add(subsSecondName.get(subsSecondName.size() - 1));
                    array.add(subsSecondPhone.get(subsSecondPhone.size() - 1));
                    array.add(subsSecondMoneyLeft.get(subsSecondMoneyLeft.size() - 1));

                    subsSecond.add(array);

                    System.out.println("New subscriber was added to a 'Second' tarif.");

                } else {
                    JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid name. \nTry again.");
        }
    }
}

class AddToMinutePressed extends Form implements ActionListener {
	public AddToMinutePressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();
        String strNameFromInput, strPhoneNumberFromInput = null, strMoneyLeftFromInput = null;
        strNameFromInput = JOptionPane.showInputDialog("Enter name of subscriber...");

        if(strNameFromInput != "567"){
            strPhoneNumberFromInput = JOptionPane.showInputDialog("Enter phone of subscriber...");
            if(strPhoneNumberFromInput!=""){
                strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter balance of subscriber...");
                if(strMoneyLeftFromInput!="0") {

                    String message = "New subscriber\n" +
                            "      Name: " + strNameFromInput + "\n" +
                            "      Phone: " + strPhoneNumberFromInput + "\n" +
                            "      Balance: " + strMoneyLeftFromInput;
                    JOptionPane.showMessageDialog(f1, message);

                    subsMinuteName.add(strNameFromInput);
                    subsMinutePhone.add(strPhoneNumberFromInput);
                    subsMinuteMoneyLeft.add(strMoneyLeftFromInput);

                    ArrayList<String> array = new ArrayList<String>();
                    array.add(subsMinuteName.get(subsMinuteName.size() - 1));
                    array.add(subsMinutePhone.get(subsMinutePhone.size() - 1));
                    array.add(subsMinuteMoneyLeft.get(subsMinuteMoneyLeft.size() - 1));

                    subsMinute.add(array);

                    System.out.println("New subscriber was added to a 'Minute' tarif.");

                } else {
                    JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter invalid number.\nTry again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid name. \nTry again.");
        }
	}
}

class RemoveFromBasicPressed extends Form implements ActionListener {
	public RemoveFromBasicPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to remove\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsBasicName.size(); ++i){
            message += (i+1) + ") ";
            message += subsBasicName.get(i) + "\n";
            message += "    Phone : " + subsBasicPhone.get(i) + "\n";
            message += "    Balance: " + subsBasicMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsBasicName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsBasicName.size()){
            indexFromInput -= 1;

            String prev = subsBasicName.get(indexFromInput);

            subsBasicName.remove(indexFromInput);
            subsBasicPhone.remove(indexFromInput);
            subsBasicMoneyLeft.remove(indexFromInput);

            JOptionPane.showMessageDialog(f1, "Subscriber '" + prev + "' was removed.");
            System.out.println("Subscriber was removed from the 'Basic' tarif.");
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number. (out of bounds probably...)");
        }
	}
}

class RemoveFromSecondPressed extends Form implements ActionListener {
	public RemoveFromSecondPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to change\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsSecondName.size(); ++i){
            message += (i+1) + ") ";
            message += subsSecondName.get(i) + "\n";
            message += "    Phone : " + subsSecondPhone.get(i) + "\n";
            message += "    Balance: " + subsSecondMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsSecondName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsSecondName.size()){
            indexFromInput -= 1;

            String prev = subsSecondName.get(indexFromInput);

            subsSecondName.remove(indexFromInput);
            subsSecondPhone.remove(indexFromInput);
            subsSecondMoneyLeft.remove(indexFromInput);

            JOptionPane.showMessageDialog(f1, "Subscriber '" + prev + "' was removed.");
            System.out.println("Subscriber was removed from the 'Basic' tarif.");
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number. (out of bounds probably...)");
        }
	}
}

class RemoveFromMinutePressed extends Form implements ActionListener {
	public RemoveFromMinutePressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to change\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsMinuteName.size(); ++i){
            message += (i+1) + ") ";
            message += subsMinuteName.get(i) + "\n";
            message += "    Phone : " + subsMinutePhone.get(i) + "\n";
            message += "    Balance: " + subsMinuteMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsMinuteName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsMinuteName.size()){
            indexFromInput -= 1;

            String prev = subsMinuteName.get(indexFromInput);

            subsMinuteName.remove(indexFromInput);
            subsMinutePhone.remove(indexFromInput);
            subsMinuteMoneyLeft.remove(indexFromInput);

            JOptionPane.showMessageDialog(f1, "Subscriber '" + prev + "' was removed.");
            System.out.println("Subscriber was removed from the 'Basic' tarif.");
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number. (out of bounds probably...)");
        }
	}
}

class ChangeFromBasicPressed extends Form implements ActionListener {
	public ChangeFromBasicPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to change\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsBasicName.size(); ++i){
            message += (i+1) + ") ";
            message += subsBasicName.get(i) + "\n";
            message += "    Phone : " + subsBasicPhone.get(i) + "\n";
            message += "    Balance: " + subsBasicMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsBasicName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsBasicName.size()){
            indexFromInput -= 1;
            String strNameFromInput = JOptionPane.showInputDialog("Enter a new name...");

            if(!strNameFromInput.isEmpty()) {
                String previousNameFromInput = subsBasicName.get(indexFromInput);
                String strPhoneFromInput = JOptionPane.showInputDialog("Enter a new phone number...");

                if(!strPhoneFromInput.isEmpty()) {

                    String previousPhoneFromInput = subsBasicPhone.get(indexFromInput);
                    String strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter a new balance...");

                    if(!strMoneyLeftFromInput.isEmpty()) {

                        String previousMoneyLeftFromInput = subsBasicMoneyLeft.get(indexFromInput);

                        subsBasicName.remove(indexFromInput);
                        subsBasicName.add(indexFromInput, strNameFromInput);
                        subsBasicPhone.remove(indexFromInput);
                        subsBasicPhone.add(indexFromInput, strPhoneFromInput);
                        subsBasicMoneyLeft.remove(indexFromInput);
                        subsBasicMoneyLeft.add(indexFromInput, strMoneyLeftFromInput);

                        String finalMessage = "Subscriber`s name was changed from: " +
                                "'" + previousNameFromInput +
                                "' " + " to '" + strNameFromInput + "'\n" + "Subscriber`s phone was changed from: " +
                                "'" + previousPhoneFromInput +
                                "' " + " to '" + strPhoneFromInput + "'\n" + "Subscriber`s balance was changed from: " +
                                "'" + previousMoneyLeftFromInput +
                                "' " + " to '" + strMoneyLeftFromInput + "'\n" + "           Subscriber was successfully changed!";

                        //"Subscriber was successfully changed!"

                        JOptionPane.showMessageDialog(f1, finalMessage);

                        System.out.println("Subscriber from 'Basic' tariff was changed.");

                    } else {
                        JOptionPane.showMessageDialog(f1, "You enter an invalid balance (empty). Try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(f1, "You enter an invalid phone number (empty). Try again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter an invalid name (empty). Try again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number.\n (index out of bounds probably...)");
        }
	}
}

class ChangeFromSecondPressed extends Form implements ActionListener {
	public ChangeFromSecondPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to change\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsSecondName.size(); ++i){
            message += (i+1) + ") ";
            message += subsSecondName.get(i) + "\n";
            message += "    Phone : " + subsSecondPhone.get(i) + "\n";
            message += "    Balance: " + subsSecondMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsSecondName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsSecondName.size()){
            indexFromInput -= 1;
            String strNameFromInput = JOptionPane.showInputDialog("Enter a new name...");

            if(!strNameFromInput.isEmpty()) {
                String previousNameFromInput = subsSecondName.get(indexFromInput);
                String strPhoneFromInput = JOptionPane.showInputDialog("Enter a new phone number...");

                if(!strPhoneFromInput.isEmpty()) {
                    String previousPhoneFromInput = subsSecondPhone.get(indexFromInput);
                    String strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter a new balance...");

                    if(!strMoneyLeftFromInput.isEmpty()) {

                        String previousMoneyLeftFromInput = subsSecondMoneyLeft.get(indexFromInput);

                        String finalMessage = "Subscriber`s name was changed from: " +
                                "'" + previousNameFromInput +
                                "' " + " to '" + strNameFromInput + "'\n" + "Subscriber`s phone was changed from: " +
                                "'" + previousPhoneFromInput +
                                "' " + " to '" + strPhoneFromInput + "'\n" + "Subscriber`s balance was changed from: " +
                                "'" + previousMoneyLeftFromInput +
                                "' " + " to '" + strMoneyLeftFromInput + "'\n" + "           Subscriber was successfully changed!";

                        subsSecondName.remove(indexFromInput);
                        subsSecondName.add(indexFromInput, strNameFromInput);
                        subsSecondPhone.remove(indexFromInput);
                        subsSecondPhone.add(indexFromInput, strPhoneFromInput);
                        subsSecondMoneyLeft.remove(indexFromInput);
                        subsSecondMoneyLeft.add(indexFromInput, strMoneyLeftFromInput);

                        JOptionPane.showMessageDialog(f1, finalMessage);

                        System.out.println("Subscriber from 'Basic' tariff was changed.");

                    } else {
                        JOptionPane.showMessageDialog(f1, "You enter an invalid balance (empty). Try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(f1, "You enter an invalid phone number (empty). Try again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter an invalid name (empty). Try again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number.\n (index out of bounds probably...)");
        }
	}
}

class ChangeFromMinutePressed extends Form implements ActionListener {
	public ChangeFromMinutePressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        String message = "Choose a subscriber that you want to change\n" +
                "(enter a number of that sub in the given array\n" +
                "      Subcribers:\n";

        for(int i = 0 ; i < subsMinuteName.size(); ++i){
            message += (i+1) + ") ";
            message += subsMinuteName.get(i) + "\n";
            message += "    Phone : " + subsMinutePhone.get(i) + "\n";
            message += "    Balance: " + subsMinuteMoneyLeft.get(i);
            message += "\n\n";
        }

        String strIndexFromInput = JOptionPane.showInputDialog(message);
        int indexFromInput = Integer.parseInt(strIndexFromInput);

        if(!subsMinuteName.isEmpty() && indexFromInput >= 1 && indexFromInput<= subsMinuteName.size()){
            indexFromInput -= 1;
            String strNameFromInput = JOptionPane.showInputDialog("Enter a new name...");

            if(!strNameFromInput.isEmpty()) {
                String previousNameFromInput = subsMinuteName.get(indexFromInput);
                String strPhoneFromInput = JOptionPane.showInputDialog("Enter a new phone number...");

                if(!strPhoneFromInput.isEmpty()) {
                    String previousPhoneFromInput = subsMinutePhone.get(indexFromInput);
                    String strMoneyLeftFromInput = JOptionPane.showInputDialog("Enter a new balance...");

                    if(!strMoneyLeftFromInput.isEmpty()) {
                        String previousMoneyLeftFromInput = subsMinuteMoneyLeft.get(indexFromInput);

                        subsMinuteName.remove(indexFromInput);
                        subsMinuteName.add(indexFromInput, strNameFromInput);
                        subsMinutePhone.remove(indexFromInput);
                        subsMinutePhone.add(indexFromInput, strPhoneFromInput);
                        subsMinuteMoneyLeft.remove(indexFromInput);
                        subsMinuteMoneyLeft.add(indexFromInput, strMoneyLeftFromInput);

                        String finalMessage = "Subscriber`s name was changed from: " +
                                "'" + previousNameFromInput +
                                "' " + " to '" + strNameFromInput + "'\n" + "Subscriber`s phone was changed from: " +
                                "'" + previousPhoneFromInput +
                                "' " + " to '" + strPhoneFromInput + "'\n" + "Subscriber`s balance was changed from: " +
                                "'" + previousMoneyLeftFromInput +
                                "' " + " to '" + strMoneyLeftFromInput + "'\n" + "           Subscriber was successfully changed!";

                        JOptionPane.showMessageDialog(f1, finalMessage);
                        System.out.println("Subscriber from 'Basic' tariff was changed.");

                    } else {
                        JOptionPane.showMessageDialog(f1, "You enter an invalid balance (empty). Try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(f1, "You enter an invalid phone number (empty). Try again.");
                }
            } else {
                JOptionPane.showMessageDialog(f1, "You enter an invalid name (empty). Try again.");
            }
        } else {
            JOptionPane.showMessageDialog(f1, "You enter invalid number.\n (index out of bounds probably...)");
        }
	}
}

class ListOfBasicTariffPressed extends Form implements ActionListener {
	public ListOfBasicTariffPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();

        if(!subsBasicName.isEmpty()) {
            String message = "\tSubcribers:\n";
            for(int i = 0 ; i < subsBasicName.size(); ++i){
                message += (i+1) + ") ";
                message += subsBasicName.get(i) + "\n";
                message += "    Phone : " + subsBasicPhone.get(i) + "\n";
                message += "    Balance: " + subsBasicMoneyLeft.get(i);
                message += "\n";
            }
            JOptionPane.showMessageDialog(f1, message);

            System.out.println("List of subscribers of tarif 'Basic' was showed");
        } else {
            JOptionPane.showMessageDialog(f1, "         Subcribers:\nThere is no subscribers in this tariff for now.");
        }
	}
}

class ListOfSecondTariffPressed extends Form implements ActionListener {
	public ListOfSecondTariffPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();
        if(!subsSecondName.isEmpty()) {
            String message = "\tSubcribers:\n";
            for(int i = 0 ; i < subsSecondName.size(); ++i){
                message += (i+1) + ") ";
                message += subsSecondName.get(i) + "\n";
                message += "    Phone : " + subsSecondPhone.get(i) + "\n";
                message += "    Balance: " + subsSecondMoneyLeft.get(i);
                message += "\n";
            }
            JOptionPane.showMessageDialog(f1, message);

            System.out.println("List of subscribers of tarif 'Second' was showed");
        } else {
            JOptionPane.showMessageDialog(f1, "         Subcribers:\nThere is no subscribers in this tariff for now.");
        }
	}
}

class ListOfMinuteTariffPressed extends Form implements ActionListener {
	public ListOfMinuteTariffPressed() throws MyException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JFrame f1 = new JFrame();
        if(!subsMinuteName.isEmpty()) {
            String message = "\tSubcribers:\n";
            for(int i = 0 ; i < subsMinuteName.size(); ++i){
                message += (i+1) + ") ";
                message += subsMinuteName.get(i) + "\n";
                message += "    Phone : " + subsMinutePhone.get(i) + "\n";
                message += "    Balance: " + subsMinuteMoneyLeft.get(i);
                message += "\n";
            }
            JOptionPane.showMessageDialog(f1, message);

            System.out.println("List of subscribers of tarif 'Minute' was showed");
        } else {
            JOptionPane.showMessageDialog(f1, "         Subcribers:\nThere is no subscribers in this tariff for now.");
        }
	}
}