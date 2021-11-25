import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;

import java.io.File;

public class PDFWordApp
{

	private File pdfFolder;
	private File docFolder;
	private File outputFolder;


	public PDFWordApp()
	{
		createFileFolders();
	}


	public void createFileFolders()
	{
		String desktopPath;
		File desktopFolder;

		desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "PDF to Word";
		desktopFolder = new File(desktopPath);
		pdfFolder = new File(desktopPath + File.separator + "INPUT pdf files");
		docFolder = new File(desktopPath + File.separator + "INPUT docx files");
		outputFolder = new File(desktopPath + File.separator + "OUTPUT Converted files");

		System.out.println("FOLDERS");
		if(desktopFolder.exists())
		{
			System.out.println("Desktop folder exists.");
		}else{
			System.out.println("Desktop folder does not exist.  Creating PDF to Word Folder...");
			desktopFolder.mkdir();
		}

		if(pdfFolder.exists())
		{
			System.out.println("PDF folder exists.");
		}else{
			System.out.println("PDF folder does not exist.  Creating PDF Folder...");
			pdfFolder.mkdir();
		}

		if(docFolder.exists())
		{
			System.out.println("DOCX folder exists.");
		}else{
			System.out.println("DOCX folder does not exist.  Creating DOCX Folder...");
			docFolder.mkdir();
		}

		if(outputFolder.exists())
		{
			System.out.println("OUTPUT folder exists.");
		}else{
			System.out.println("OUTPUT folder does not exist.  Creating OUTPUT Folder...");
			outputFolder.mkdir();
		}
		System.out.println("--------------------");
	}

	public void convertPDFToWord()
	{
		File[] fileName = pdfFolder.listFiles();

		System.out.println("PDF -> DOCX FILES");
		assert fileName != null;
		for(File file : fileName){
			System.out.println("Transcribing: " + file.getName());

			String convertedFile = outputFolder.getPath() + File.separator + file.getName().replace(".pdf", ".docx");
			Converter converter = new Converter(file.getPath());
			WordProcessingConvertOptions options = new WordProcessingConvertOptions();
			converter.convert(convertedFile, options);

			System.out.println(file.getName().replace(".pdf", ".docx") + " created successfully within " + outputFolder.getPath());
		}
		System.out.println("--------------------");
	}

	public void convertWordToPDF()
	{
		File[] fileName = docFolder.listFiles();

		System.out.println("DOCX -> PDF FILES");
		assert fileName != null;
		for(File file : fileName){
			System.out.println("Transcribing: " + file.getName());

			String convertedFile = outputFolder.getPath() + File.separator + file.getName().replace(".docx", ".pdf");
			Converter converter = new Converter(file.getPath());
			PdfConvertOptions options = new PdfConvertOptions();
			converter.convert(convertedFile, options);

			System.out.println(file.getName().replace(".docx", ".pdf") + " created successfully within " + outputFolder.getPath());
		}
		System.out.println("--------------------");
	}

	public File getOutputFolder()
	{
		return outputFolder;
	}

	public File getPdfFolder()
	{
		return pdfFolder;
	}

	public File getDocFolder()
	{
		return docFolder;
	}
}
