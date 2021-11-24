/**
 * Class to test for proper processing of bad file names by the FileProcessor
 * class.
 * 
 * @author lschoch
 * @version 1.0 CS-131-ON Lab4
 */
public class BadFileName {
	/**
	 * Main method. Instantiates a file processor object and invokes the processFile
	 * method.
	 * 
	 * @param args this method does not use command line arguments
	 */
	public static void main(String[] args){
    
		FileProcessor fp = new FileProcessor("String1.txt",10);
		fp.processFile();
		
	}// end main
  
}// end class