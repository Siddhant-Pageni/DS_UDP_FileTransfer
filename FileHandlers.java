import java.io.*;

public class FileHandlers implements Serializable{
    private String destinationPath;
    private String sourcePath;
    private String fileName;
    private long fileSize;
    private byte[] fileData;
    private String status;
    private byte[] buffer = new byte[52428800];
    private int buffLength = 52428800;
    private FileInputStream fileIn;
    private File tempFile;
    private int readFileSize = 0;
    private boolean isReadComplete = false;
    
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
    public byte[] getBuffer(){
		return buffer;
	}
	public long getReadFileSize(){
		return readFileSize;
	}
	public boolean getIsReadComplete(){
		return isReadComplete;
	}
	
    public boolean fileExist(){
        if(new File(this.sourcePath).isFile()) {
        	return true;
        }
        else{
        	return false;
        }
    }
    public FileHandlers(File temp){
		tempFile = temp;
		try{
			fileIn = new FileInputStream(temp);
		}catch(FileNotFoundException e){
			System.out.println("File not found"+e.getMessage());
		}
	}
    /*public byte[] readFile(){
    	InputStream in = new FileInputStream(f);
    	int readHead;
    	//int readHearder=0;
    	byte buffer[] = new byte[1024];
    	while ((readHead = in.read(buffer)) != -1) {
            //readHeader += read;
         }
    }*/
    public byte[] read(){
		int readL = buffLength;
		try{
			//EOF
			if (fileIn.available() < buffLength) {
				readL = fileIn.available();
				System.out.println("Remaining: " + readL);
			}

			//reads a specified size of bytes from the file being transfered
			this.fileIn.read(buffer,0,readL);
			readFileSize += readL;

			//checks if the file read is complete
			if (readFileSize >= tempFile.length()) {
				isReadComplete = true;
				System.out.println("File of size " + readFileSize + " has been read");
				fileIn.close();
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found"+e.getMessage());
		}catch(IOException e){
			System.out.println("IO: "+e.getMessage());
		}

		//to eleminate the empty buffer at the end
		byte[] tempBuffer = Arrays.copyOf(buffer,readL);
		return tempBuffer;
	}
    /*public static void main(String args[]){
    	FileHandlers ff = new FileHandlers();
    	ff.fileExist();
    }*/
}
