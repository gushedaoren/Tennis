package air.balloon.tennis.model;

/**
 *
 * @author gen code 
 *
 */
public class ImageFile {
	
    /**  */
    private long id;
    /** 文件名称 */
    private String fileName;
    /** 文件url */
    private String fileUrl;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 文件名称 */
    public String getFileName(){
    	return this.fileName;
    }

    /** set 文件名称 */
    public void setFileName(String fileName){
    	this.fileName = fileName;
    }
    
    /** get 文件url */
    public String getFileUrl(){
    	return this.fileUrl;
    }

    /** set 文件url */
    public void setFileUrl(String fileUrl){
    	this.fileUrl = fileUrl;
    }
    



    public String toString(){
		return "ImageFile{" + 
			",id='" + id + "'" + 
			",fileName='" + fileName + "'" + 
			",fileUrl='" + fileUrl + "'" + 
		
		"}";

    }



}
