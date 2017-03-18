import java.io.*;

public class FileHandlers implements Serializable{
    private String destinationPath;
    private String sourcePath;
    private String fileName;
    private long fileSize;
    private byte[] fileData;
    private String status;

    public FileHandlers(){
    }
    
    public String getDestinationPath(){
    	return destinationPath;
    }
    public String setDestinationPath(String dPath){
    	destinationPath = dPath;
    }
    public String getSourcePath(){
    	return sourcePath;
    }
    public String setSourcePath(String sPath){
    	sourcePath = sPath;
    }
    public String getFileName(){
    	return fileName;
    }
    public String setFileName(String fName){
    	fileName = fName;
    }
    public long getFileSize(){
    	return fileSize;
    }
    public String setFileSize(long fSize){
    	fileSize = fSize;
    }
    public String getStatus(){
    	return status;
    }
    public String setStatus(String s){
    	status = s;
    }
    public byte[] getFileData() {
    	return fileData;
    }
    public void setFileData(byte[] fData) {
    	fileData = fData;
    }
    
    public boolean fileExist(){
        if(new File(this.sourcePath).isFile()) {
        	return true;
        }
        else{
        	return false;
        }
    }
    /*public void readFile(){
    	InputStream in = new FileInputStream(f);
    	int readHead;
    	//int readHearder=0;
    	byte buffer[] = new byte[1024];
    	while ((readHead = in.read(buffer)) != -1) {
            //readHeader += read;
         }
    }*/
    /*public static void main(String args[]){
    	FileHandler ff = new FileHandler();
    	ff.fileExist();
    }*/
}
