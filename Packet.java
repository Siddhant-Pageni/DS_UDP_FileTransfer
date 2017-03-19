public class Packet{
    private int id;
    private boolean isAck;
    private boolean isData;
    private byte[] data;
    
    public Packet(){
    }
    
    public void setId(int id){
    	this.id = id;
    }
    public int getId(){
    	return this.id;
    }
    public void setIsAck(boolean isAck){
    	this.isAck = isAck;
    }
    public boolean getIsAck(){
    	return this.isAck;
    }
    public void setIsData(boolean isData){
    	this.isData = isData;
    }
    public boolean getIsData(){
    	return this.isData;
    }
    public void setData(byte[] data) {
    	this.data = data;
    }
    public byte[] getData() {
    	return data;
    }

    
}
