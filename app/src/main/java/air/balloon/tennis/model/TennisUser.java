package air.balloon.tennis.model;

/**
 *
 * @author gen code 
 *
 */
public class TennisUser {
	
    /**  */
    private long id;
    /** 帐户 */
    private String account;
    /** 姓名 */
    private String name;
    /** 角色 */
    private String roles;
    /** 注册时间 */
    private String registerDate;
    /** 地址 */
    private String address;
    /** 头像 */
    private String phote;
    /** 联系电话 */
    private String phone;
    /** 积分 */
    private String integral;
    /** 等级 */
    private String accountLevel;
    /** 登陆状态 0 在线 1 不在线 2 黑名单 */
    private BaseEnum state_BaseEnum_Model;
    /** 性别 0代表男士 1代表女士 */
    private BaseEnum gender_BaseEnum_Model;



    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 帐户 */
    public String getAccount(){
    	return this.account;
    }

    /** set 帐户 */
    public void setAccount(String account){
    	this.account = account;
    }
    
    /** get 姓名 */
    public String getName(){
    	return this.name;
    }

    /** set 姓名 */
    public void setName(String name){
    	this.name = name;
    }
    
    /** get 角色 */
    public String getRoles(){
    	return this.roles;
    }

    /** set 角色 */
    public void setRoles(String roles){
    	this.roles = roles;
    }

    /** get 注册时间 */
    public String getRegisterDate(){
    	return this.registerDate;
    }

    /** set 注册时间 */
    public void setRegisterDate(String registerDate){
    	this.registerDate = registerDate;
    }

    /** get 地址 */
    public String getAddress(){
    	return this.address;
    }

    /** set 地址 */
    public void setAddress(String address){
    	this.address = address;
    }

    /** get 头像 */
    public String getPhote(){
    	return this.phote;
    }

    /** set 头像 */
    public void setPhote(String phote){
    	this.phote = phote;
    }

    /** get 联系电话 */
    public String getPhone(){
    	return this.phone;
    }

    /** set 联系电话 */
    public void setPhone(String phone){
    	this.phone = phone;
    }

    /** get 积分 */
    public String getIntegral(){
    	return this.integral;
    }

    /** set 积分 */
    public void setIntegral(String integral){
    	this.integral = integral;
    }

    /** get 等级 */
    public String getAccountLevel(){
    	return this.accountLevel;
    }

    /** set 等级 */
    public void setAccountLevel(String accountLevel){
    	this.accountLevel = accountLevel;
    }

    /** get 登陆状态 0 在线 1 不在线 2 黑名单 */
    public BaseEnum getState_BaseEnum_Model(){
    	return this.state_BaseEnum_Model;
    }

    /** set 登陆状态 0 在线 1 不在线 2 黑名单 */
    public void setState_BaseEnum_Model(BaseEnum state_BaseEnum_Model){
    	this.state_BaseEnum_Model = state_BaseEnum_Model;
    }

    /** get 性别 0代表男士 1代表女士 */
    public BaseEnum getGender_BaseEnum_Model(){
    	return this.gender_BaseEnum_Model;
    }

    /** set 性别 0代表男士 1代表女士 */
    public void setGender_BaseEnum_Model(BaseEnum gender_BaseEnum_Model){
    	this.gender_BaseEnum_Model = gender_BaseEnum_Model;
    }




    public String toString(){
		return "TennisUser{" +
			",id='" + id + "'" +
			",account='" + account + "'" +
			",name='" + name + "'" +
			",roles='" + roles + "'" +
			",registerDate='" + registerDate + "'" +
			",address='" + address + "'" +
			",phote='" + phote + "'" +
			",phone='" + phone + "'" +
			",integral='" + integral + "'" +
			",accountLevel='" + accountLevel + "'" +
			",state_BaseEnum_Model='" + state_BaseEnum_Model + "'" +
			",gender_BaseEnum_Model='" + gender_BaseEnum_Model + "'" +

		"}";

    }



}
