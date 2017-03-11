import java.io.*;

public class FileHandler{
    String fileName;
    File f;
    public FileHandler(){
        fileName="xyz.mp4";
        f = new File(fileName);
    }
    public boolean fileExist(){
        
        if(f.exists() && !f.isDirectory()) {
        	return true;
        }
        else
        	return false;
    }
    /*public static void main(String args[]){
    	FileHandler ff = new FileHandler();
    	ff.readFile();
    }*/
}
