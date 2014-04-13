package air.balloon.tennis.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gen code 
 *
 */
public class Event {
	
    /**  */
    private long id;
    /**  */
    private String title;
    /** 内容描述 */
    private String descrition;
    /**  // 发起者 */
    private List<TennisUser> owner;
    /**  // 参与者 */
    private List<TennisUser> participantList;
    /** 电话 */
    private String phone;
    /** 费用 */
    private double totolPrice;
    /** 对手水平要求 */
    private String require;
    /** 评论 */
    private List<Evaluate> evaluateList;
    /** 发起时间 */
    private Date commitTime;
    /** 活动时间 */
    private long eventTime;
    /** 地点 */
    private String address;
    /** 场地 */
    private List<Court> courtList;
    /** 经度 */
    private double longitude;
    /** 纬度 */
    private double latitude;
    /** 备注 */
    private String remark;
    /** 分类 */
    private BaseEnum category;
    /** 状态：2审核中，1未完成，0已完成 */
    private BaseEnum statues;
    /** 权重 */
    private int weight;
    /** 收藏 */
    private List<TennisUser> startUsersList;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get  */
    public String getTitle(){
    	return this.title;
    }

    /** set  */
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
    
    /** get  // 发起者 */
    public List<TennisUser> getOwner(){
    	return this.owner;
    }

    /** set  // 发起者 */
    public void setOwner(List<TennisUser> owner){
    	this.owner = owner;
    }
    
    /** get  // 参与者 */
    public List<TennisUser> getParticipantList(){
    	return this.participantList;
    }

    /** set  // 参与者 */
    public void setParticipantList(List<TennisUser> participantList){
    	this.participantList = participantList;
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
    
    /** get 评论 */
    public List<Evaluate> getEvaluateList(){
    	return this.evaluateList;
    }

    /** set 评论 */
    public void setEvaluateList(List<Evaluate> evaluateList){
    	this.evaluateList = evaluateList;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
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
    
    /** get 场地 */
    public List<Court> getCourtList(){
    	return this.courtList;
    }

    /** set 场地 */
    public void setCourtList(List<Court> courtList){
    	this.courtList = courtList;
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
    
    /** get 分类 */
    public BaseEnum getCategory(){
    	return this.category;
    }

    /** set 分类 */
    public void setCategory(BaseEnum category){
    	this.category = category;
    }
    
    /** get 状态：2审核中，1未完成，0已完成 */
    public BaseEnum getStatues(){
    	return this.statues;
    }

    /** set 状态：2审核中，1未完成，0已完成 */
    public void setStatues(BaseEnum statues){
    	this.statues = statues;
    }
    
    /** get 权重 */
    public int getWeight(){
    	return this.weight;
    }

    /** set 权重 */
    public void setWeight(int weight){
    	this.weight = weight;
    }
    
    /** get 收藏 */
    public List<TennisUser> getStartUsersList(){
    	return this.startUsersList;
    }

    /** set 收藏 */
    public void setStartUsersList(List<TennisUser> startUsersList){
    	this.startUsersList = startUsersList;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descrition='" + descrition + '\'' +
                ", owner=" + owner +
                ", participantList=" + participantList +
                ", phone='" + phone + '\'' +
                ", totolPrice=" + totolPrice +
                ", require='" + require + '\'' +
                ", evaluateList=" + evaluateList +
                ", commitTime=" + commitTime +
                ", eventTime=" + eventTime +
                ", address='" + address + '\'' +
                ", courtList=" + courtList +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", remark='" + remark + '\'' +
                ", category=" + category +
                ", statues=" + statues +
                ", weight=" + weight +
                ", startUsersList=" + startUsersList +
                '}';
    }
}
