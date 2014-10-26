package air.balloon.tennis.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 *
 * @author gen code 
 *
 */
public class Court implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
	
    /**  */
    private long id;
    /** 场地名称 */
    private String title;
    /** 场地地址 */
    private String address;
    /** 联系电话 */
    private String phone;

    private String court_level;


    /** 场地情况 */
    private String description;
    /** 场地片数 */
    private String court_number;
    /** 权重 */
    private String weights;

    public String getCourt_level() {
        return court_level;
    }

    public void setCourt_level(String court_level) {
        this.court_level = court_level;
    }

    private String price;

    /** 省市id */
    private BaseCity province_model;

    /** 城市id */
    private BaseCity city_model;
    /** 区县id */
    private BaseCity district_model;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 场地名称 */
    public String getTitle(){
    	return this.title;
    }

    /** set 场地名称 */
    public void setTitle(String title){
    	this.title = title;
    }
    
    /** get 场地地址 */
    public String getAddress(){
    	return this.address;
    }

    /** set 场地地址 */
    public void setAddress(String address){
    	this.address = address;
    }
    
    /** get 联系电话 */
    public String getPhone(){
    	return this.phone;
    }

    /** set 联系电话 */
    public void setPhone(String phone){
    	this.phone = phone;
    }
    


    

    
    /** get 权重 */
    public String getWeights(){
    	return this.weights;
    }

    /** set 权重 */
    public void setWeights(String weights){
    	this.weights = weights;
    }
    



    public BaseCity getProvince_model() {
        return province_model;
    }

    public void setProvince_model(BaseCity province_model) {
        this.province_model = province_model;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourt_number() {
        return court_number;
    }

    public void setCourt_number(String court_number) {
        this.court_number = court_number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BaseCity getCity_model() {
        return city_model;
    }

    public void setCity_model(BaseCity city_model) {
        this.city_model = city_model;
    }

    public BaseCity getDistrict_model() {
        return district_model;
    }

    public void setDistrict_model(BaseCity district_model) {
        this.district_model = district_model;
    }

    @Override
    public String toString() {
        return "Court{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", court_level='" + court_level + '\'' +

                ", description='" + description + '\'' +
                ", court_number='" + court_number + '\'' +
                ", weights='" + weights + '\'' +
                ", price='" + price + '\'' +
                ", province_model=" + province_model +
                ", city_model=" + city_model +
                ", district_model=" + district_model +
                '}';
    }


}
