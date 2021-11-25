import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PDFWordConverter implements ActionListener
{
	static final JPanel panel = new JPanel();
	static final JButton convertToDocxButton = new JButton("Convert to DOCX");
	static final JButton convertToPDFButton = new JButton("Convert to PDF");
	static final JButton openFolderOutputButton = new JButton("Open Output Folder");
	static final JButton openFolderDOCXButton = new JButton("Open DOCX Folder");
	static final JButton openFolderPDFButton = new JButton("Open PDF Folder");
	static final JFrame frame = new JFrame();


	public static void main(String[] args)
	{
		PDFWordApp convertPDFWord = new PDFWordApp();

		ActionListener convertToDocxButtonPressed = e ->
		{
			try
			{
				convertPDFWord.convertPDFToWord();
			} catch (Exception exception)
			{
				exception.printStackTrace();
			}
		};

		ActionListener convertToPDFButtonPressed = e ->
		{
			try
			{
				convertPDFWord.convertWordToPDF();
			} catch (Exception err)
			{
				err.printStackTrace();
			}
		};

		ActionListener openFolderOutputButtonPressed = e ->
		{
			try
			{
				Desktop.getDesktop().open(convertPDFWord.getOutputFolder());
			} catch (IOException b)
			{
				System.out.println("ERROR encountered while opening OUTPUT Folder...");
				b.printStackTrace();
			}
		};

		ActionListener openFolderDOCXButtonPressed = e ->
		{
			try
			{
				Desktop.getDesktop().open(convertPDFWord.getDocFolder());
			} catch (IOException b)
			{
				System.out.println("ERROR encountered while opening OUTPUT Folder...");
				b.printStackTrace();
			}
		};

		ActionListener openFolderPDFButtonPressed = e ->
		{
			try
			{
				Desktop.getDesktop().open(convertPDFWord.getPdfFolder());
			} catch (IOException b)
			{
				System.out.println("ERROR encountered while opening OUTPUT Folder...");
				b.printStackTrace();
			}
		};

		//JButton Setup
		convertToDocxButton.setBounds(400, 200, 200, 50);
		convertToDocxButton.addActionListener(convertToDocxButtonPressed);
		convertToDocxButton.setVisible(true);
		convertToPDFButton.setBounds(100, 200, 200, 50);
		convertToPDFButton.addActionListener(convertToPDFButtonPressed);
		convertToPDFButton.setVisible(true);
		openFolderOutputButton.setBounds(250, 300, 200, 50);
		openFolderOutputButton.addActionListener(openFolderOutputButtonPressed);
		openFolderOutputButton.setVisible(true);
		openFolderDOCXButton.setBounds(100, 100, 200, 50);
		openFolderDOCXButton.addActionListener(openFolderDOCXButtonPressed);
		openFolderDOCXButton.setVisible(true);
		openFolderPDFButton.setBounds(400, 100, 200, 50);
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
		frame.add(panel);
		frame.setTitle("PDF - Word Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(720, 480);
		frame.setVisible(true);

		//Default JFrame location to center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
