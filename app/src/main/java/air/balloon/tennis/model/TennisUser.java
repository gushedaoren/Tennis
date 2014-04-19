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
    /** 性别 0代表男士 1代表女士 */
    private BaseEnum gender;
    /** 头像 */
    private String phote;
    /** 联系电话 */
    private String phone;
    /** 登陆状态 0 在线 1 不在线 2 黑名单 */
    private BaseEnum state;
    /** 积分 */
    private String integral;
    /** 等级 */
    private String accountLevel;


	
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
    
    /** get 性别 0代表男士 1代表女士 */
    public BaseEnum getGender(){
    	return this.gender;
    }

    /** set 性别 0代表男士 1代表女士 */
    public void setGender(BaseEnum gender){
    	this.gender = gender;
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
    
    /** get 登陆状态 0 在线 1 不在线 2 黑名单 */
    public BaseEnum getState(){
    	return this.state;
    }

    /** set 登陆状态 0 在线 1 不在线 2 黑名单 */
    public void setState(BaseEnum state){
    	this.state = state;
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



    


}
