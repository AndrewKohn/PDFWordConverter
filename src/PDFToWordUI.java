import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PDFToWordUI extends JFrame implements ActionListener
{
	private final JPanel panel = new JPanel();
	private final JButton convertToDocxButton = new JButton("Convert to DOCX");
	private final JButton convertToPDFButton = new JButton("Convert to PDF");
	private final JButton openFolderOutputButton = new JButton("Open Output Folder");
	private final JButton openFolderDOCXButton = new JButton("Open DOCX Folder");
	private final JButton openFolderPDFButton = new JButton("Open PDF Folder");


	public PDFToWordUI()
	{
		PDFWordApp convertPDFWord = new PDFWordApp();

		ActionListener convertToDocxButtonPressed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				convertPDFWord.convertPDFToWord();
			}
		};

		ActionListener convertToPDFButtonPressed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				convertPDFWord.convertWordToPDF();
			}
		};

		ActionListener openFolderOutputButtonPressed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Desktop.getDesktop().open(convertPDFWord.getOutputFolder());
				}
				catch(IOException b)
				{
					System.out.println("ERROR encountered while opening OUTPUT Folder...");
					b.printStackTrace();
				}
			}
		};

		ActionListener openFolderDOCXButtonPressed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Desktop.getDesktop().open(convertPDFWord.getDocFolder());
				}
				catch(IOException b)
				{
					System.out.println("ERROR encountered while opening OUTPUT Folder...");
					b.printStackTrace();
				}
			}
		};

		ActionListener openFolderPDFButtonPressed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Desktop.getDesktop().open(convertPDFWord.getPdfFolder());
				}
				catch(IOException b)
				{
					System.out.println("ERROR encountered while opening OUTPUT Folder...");
					b.printStackTrace();
				}
			}
		};

		//JButton Setup
		convertToDocxButton.setBounds(100,200,200,50);
		convertToDocxButton.addActionListener(convertToDocxButtonPressed);
		convertToDocxButton.setVisible(true);
		convertToPDFButton.setBounds(400,200,200,50);
		convertToPDFButton.addActionListener(convertToPDFButtonPressed);
		convertToPDFButton.setVisible(true);
		openFolderOutputButton.setBounds(250,300,200,50);
		openFolderOutputButton.addActionListener(openFolderOutputButtonPressed);
		openFolderOutputButton.setVisible(true);
		openFolderDOCXButton.setBounds(100,100,200,50);
		openFolderDOCXButton.addActionListener(openFolderDOCXButtonPressed);
		openFolderDOCXButton.setVisible(true);
		openFolderPDFButton.setBounds(400,100,200,50);
		openFolderPDFButton.addActionListener(openFolderPDFButtonPressed);
		openFolderPDFButton.setVisible(true);

		//JPanel Setup
		panel.setLayout(null);
		panel.add(convertToDocxButton);
		panel.add(convertToPDFButton);
		panel.add(openFolderOutputButton);
		panel.add(openFolderDOCXButton);
		panel.add(openFolderPDFButton);

		//Frame Setup
		this.add(panel);
		this.setTitle("PDF - Word Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(720,480);
		this.setVisible(true);

		//Default JFrame location to center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
