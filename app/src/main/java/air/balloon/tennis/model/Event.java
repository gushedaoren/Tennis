package air.balloon.tennis.model;

import java.util.List;

/**
 *
 * @author gen code 
 *
 */
public class Event {
	
    /**  */
    private long id;
    /** 标题 */
    private String title;
    /** 内容描述 */
    private String descrition;
    /** 电话 */
    private String phone;
    /** 费用 */
    private double totolPrice;
    /** 对手水平要求 */
    private String require;
    /** 发起时间 */
    private String commitTime;
    /** 活动时间 */
    private String eventTime;
    /** 地点 */
    private String address;
    /** 经度 */
    private double longitude;
    /** 纬度 */
    private double latitude;
    /** 备注 */
    private String remark;
    /** 权重 */
    private int weight;
    /** 分类 */
    private BaseEnum category_BaseEnum_Model;
    /** 状态：2审核中，1未完成，0已完成 */
    private BaseEnum statues_BaseEnum_Model;
    /** 收藏 */
    private List<TennisUser> startUsers_TennisUser_List;
    /**  // 发起者 */
    private List<TennisUser> owners_TennisUser_List;
    /**  // 参与者 */
    private List<TennisUser> participant_TennisUser_List;
    /** 评论 */
    private List<Evaluate> comments_Evaluate_List;
    /** 场地 */
    private List<Court> courts_Court_List;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 标题 */
    public String getTitle(){
    	return this.title;
    }

    /** set 标题 */
    public void setTitle(String title){
    	this.title = title;
    }
    
    /** get 内容描述 */
    public String getDescrition(){
    	return this.descrition;
    }

    /** set 内容描述 */
    public void setDescrition(String descrition){
    	this.descrition = descrition;
    }
    
    /** get 电话 */
    public String getPhone(){
    	return this.phone;
    }

    /** set 电话 */
    public void setPhone(String phone){
    	this.phone = phone;
    }
    
    /** get 费用 */
    public double getTotolPrice(){
    	return this.totolPrice;
    }

    /** set 费用 */
    public void setTotolPrice(double totolPrice){
    	this.totolPrice = totolPrice;
    }
    
    /** get 对手水平要求 */
    public String getRequire(){
    	return this.require;
    }

    /** set 对手水平要求 */
    public void setRequire(String require){
    	this.require = require;
    }
    
    /** get 发起时间 */
    public String getCommitTime(){
    	return this.commitTime;
    }

    /** set 发起时间 */
    public void setCommitTime(String commitTime){
    	this.commitTime = commitTime;
    }
    
    /** get 活动时间 */
    public String getEventTime(){
    	return this.eventTime;
    }

    /** set 活动时间 */
    public void setEventTime(String eventTime){
    	this.eventTime = eventTime;
    }
    
    /** get 地点 */
    public String getAddress(){
    	return this.address;
    }

    /** set 地点 */
    public void setAddress(String address){
    	this.address = address;
    }
    
    /** get 经度 */
    public double getLongitude(){
    	return this.longitude;
    }

    /** set 经度 */
    public void setLongitude(double longitude){
    	this.longitude = longitude;
    }
    
    /** get 纬度 */
    public double getLatitude(){
    	return this.latitude;
    }

    /** set 纬度 */
    public void setLatitude(double latitude){
    	this.latitude = latitude;
    }
    
    /** get 备注 */
    public String getRemark(){
    	return this.remark;
    }

    /** set 备注 */
    public void setRemark(String remark){
    	this.remark = remark;
    }
    
    /** get 权重 */
    public int getWeight(){
    	return this.weight;
    }

    /** set 权重 */
    public void setWeight(int weight){
    	this.weight = weight;
    }
    
    /** get 分类 */
    public BaseEnum getCategory_BaseEnum_Model(){
    	return this.category_BaseEnum_Model;
    }

    /** set 分类 */
    public void setCategory_BaseEnum_Model(BaseEnum category_BaseEnum_Model){
    	this.category_BaseEnum_Model = category_BaseEnum_Model;
    }
    
    /** get 状态：2审核中，1未完成，0已完成 */
    public BaseEnum getStatues_BaseEnum_Model(){
    	return this.statues_BaseEnum_Model;
    }

    /** set 状态：2审核中，1未完成，0已完成 */
    public void setStatues_BaseEnum_Model(BaseEnum statues_BaseEnum_Model){
    	this.statues_BaseEnum_Model = statues_BaseEnum_Model;
    }
    
    /** get 收藏 */
    public List<TennisUser> getStartUsers_TennisUser_List(){
    	return this.startUsers_TennisUser_List;
    }

    /** set 收藏 */
    public void setStartUsers_TennisUser_List(List<TennisUser> startUsers_TennisUser_List){
    	this.startUsers_TennisUser_List = startUsers_TennisUser_List;
    }
    
    /** get  // 发起者 */
    public List<TennisUser> getOwners_TennisUser_List(){
    	return this.owners_TennisUser_List;
    }

    /** set  // 发起者 */
    public void setOwners_TennisUser_List(List<TennisUser> owners_TennisUser_List){
    	this.owners_TennisUser_List = owners_TennisUser_List;
    }
    
    /** get  // 参与者 */
    public List<TennisUser> getParticipant_TennisUser_List(){
    	return this.participant_TennisUser_List;
    }

    /** set  // 参与者 */
    public void setParticipant_TennisUser_List(List<TennisUser> participant_TennisUser_List){
    	this.participant_TennisUser_List = participant_TennisUser_List;
    }
    
    /** get 评论 */
    public List<Evaluate> getComments_Evaluate_List(){
    	return this.comments_Evaluate_List;
    }

    /** set 评论 */
    public void setComments_Evaluate_List(List<Evaluate> comments_Evaluate_List){
    	this.comments_Evaluate_List = comments_Evaluate_List;
    }
    
    /** get 场地 */
    public List<Court> getCourts_Court_List(){
    	return this.courts_Court_List;
    }

    /** set 场地 */
    public void setCourts_Court_List(List<Court> courts_Court_List){
    	this.courts_Court_List = courts_Court_List;
    }
    



    public String toString(){
		return "Event{" + 
			",id='" + id + "'" + 
			",title='" + title + "'" + 
			",descrition='" + descrition + "'" + 
			",phone='" + phone + "'" + 
			",totolPrice='" + totolPrice + "'" + 
			",require='" + require + "'" + 
			",commitTime='" + commitTime + "'" + 
			",eventTime='" + eventTime + "'" + 
			",address='" + address + "'" + 
			",longitude='" + longitude + "'" + 
			",latitude='" + latitude + "'" + 
			",remark='" + remark + "'" + 
			",weight='" + weight + "'" + 
			",category_BaseEnum_Model='" + category_BaseEnum_Model + "'" + 
			",statues_BaseEnum_Model='" + statues_BaseEnum_Model + "'" + 
			",startUsers_TennisUser_List='" + startUsers_TennisUser_List.toString() + "'" + 
			",owners_TennisUser_List='" + owners_TennisUser_List.toString() + "'" + 
			",participant_TennisUser_List='" + participant_TennisUser_List.toString() + "'" + 
			",comments_Evaluate_List='" + comments_Evaluate_List.toString() + "'" + 
			",courts_Court_List='" + courts_Court_List.toString() + "'" + 
		
		"}";

    }



}
