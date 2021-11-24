import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Class to print text files that have one string per line. Catches and 
 * handles FileNotFoundException and StringTooLongException.
 * 
 * @author lschoch
 * @version 1.0 CS-131-ON Lab4
 */
public class FileProcessor {
	
	private String fileName; // The name of the file to be processed.
	private int stringLength; // The maximum length allowed for the single 
			// string on each line of the file.
	private ArrayList<String> stringList; // An ArrayList object (array)
	private Scanner input; // Scanner object for reading the file line by line.
	
	/**
	 * Constructor to create a FileProcessor object specifying file name and 
	 * maximum allowed length of the single string on each line.
	 * 
	 * @param fileName the name of the file to be processed
	 * @param stringLength the maximum length allowed for each string
	 */
	public FileProcessor(String fileName, int stringLength) {
		// Minimum string length is 5
		if (stringLength < 5) {
			stringLength = 5;
		}
		setStringLength(stringLength);
		setFileName(fileName);
			
	}// end constructor
	
	/**
	 * Method to read and print each line of the file specified by fileName,
	 * includes catching and handling FileNotFoundException and 
	 * StringTooLongException. 
	 */
	public void processFile() {
		// Instantiate a StringTooLongException
		StringTooLongException stlException = new StringTooLongException("String is too long!");
		String line = "";
		
		// Check for file not found, can't proceed without a file to read.
		try {
			File file = new File(fileName);
			input = new Scanner(file);
		}
		catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}
		
		// Step through the file line by line
		while (input.hasNextLine()) {	
			try {
				line = input.nextLine();
				// Check line length, throw exception if greater than 
				// stringLength, otherwise print line. 
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
	
	/**
	 * Method to get value of the fileName parameter.
	 * 
	 * @return the current value of fileName
	 */
	public String getFileName() {
		return fileName;
		
	}// end getFileName
	
	/**
	 * Method to set a new value for the fileName parameter.
	 * 
	 * @param fileName the new value for fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}// end setFileName
	
	/**
	 * Method to get the value of the stringLength parameter.
	 * 
	 * @return the current value of stringLength
	 */
	public int getStringLength() {
		return stringLength;
		
	}// end get StringLength
	
	/**
	 * Method to set a new value for the stringLength parameter.
	 * 
	 * @param stringLength the new value for stringLength
	 */
	public void setStringLength(int stringLength) {
		// Minimum string length is 5
		if (stringLength < 5) {
			stringLength = 5;
		}
		this.stringLength = stringLength;
		
	}// end setStringLength
	
	/**
	 * Method to get the current size of stringList.
	 * 
	 * @return the current size of stringList
	 */
	public int getArrayListSize() {
		return stringList.size();
		
	}//end getArrayListSize
	
	/**
	 * Method to print the values of all instance variables.
	 * 
	 * @return a formatted string containing the values of all instance
	 * variables
	 */
	@Override
	public String toString() {
		return "FileProcessor [fileName=" + fileName + ", stringLength=" + stringLength + ", stringList=" + stringList
				+ ", input=" + input + "]";
	}// end toString
	
}//end class
