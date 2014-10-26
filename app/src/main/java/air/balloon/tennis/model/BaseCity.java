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

    private String title_pinyin;
    private boolean isHot;



    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean isHot) {
        this.isHot = isHot;
    }

    public String getTitle_pinyin() {
        return title_pinyin;
    }

    public void setTitle_pinyin(String title_pinyin) {
        this.title_pinyin = title_pinyin;
    }

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
    



    public String toString(){
		return "BaseCity{" + 
			",id='" + id + "'" + 
			",cityName='" + cityName + "'" + 
			",cityType='" + cityType + "'" + 
		
		"}";

    }



}
