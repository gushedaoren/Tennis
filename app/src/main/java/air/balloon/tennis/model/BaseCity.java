package air.balloon.tennis.model;

/**
 *
 * @author gen code 
 *
 */
public class BaseCity {
	
    /**  */
    private long id;
    /** 城市名称 */
    private String cityName;
    /** 城市类型 */
    private String cityType;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 城市名称 */
    public String getCityName(){
    	return this.cityName;
    }

    /** set 城市名称 */
    public void setCityName(String cityName){
    	this.cityName = cityName;
    }
    
    /** get 城市类型 */
    public String getCityType(){
    	return this.cityType;
    }

    /** set 城市类型 */
    public void setCityType(String cityType){
    	this.cityType = cityType;
    }
    


}