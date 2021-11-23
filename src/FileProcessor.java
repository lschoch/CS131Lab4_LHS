import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		if (stringLength < 5) {
			stringLength = 5;
		}
		setStringLength(stringLength);
		setFileName(fileName);
			
	}// end empty-argument constructor
	
	public String getFileName() {
		return fileName;
	}// end getFileName

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStringLength() {
		return stringLength;
	}// end get StringLength

	public void setStringLength(int stringLength) {
		if (stringLength < 5) {
			stringLength = 5;
		}
		this.stringLength = stringLength;
	}

	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile() {
		StringTooLongException stlException = new StringTooLongException("String is too long!");
		String line = "";
		
		try {
			File file = new File(fileName);
			input = new Scanner(file);
		}
		catch(IOException io) {
			System.out.println(io.getMessage());
			return;
		}
		
		while (input.hasNextLine()) {	
			try {
				line = input.nextLine();
				if (line.length() > stringLength) {
					throw stlException;
				}
				System.out.println(line);
			}
			catch(StringTooLongException stl) {
				System.out.println(stl.getMessage());
			}
		}
		input.close();
	}//end processFile
	
}//end class
