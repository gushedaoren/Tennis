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
    /** 密码 */
    private String password;
    /** 角色 */
    private String roles;
    /** 注册时间 */
    private Date registerDate;
    /** 年龄 */
    private int age;
    /** 地址 */
    private String address;
    /** 生日 用时间戳？（简单的使用格式化的日期字符串也可以） */
    private String birthday;
    /** 性别 0代表男士 1代表女士 */
    private BaseEnum gender;
    /** 头像 */
    private String phote;
    /** 联系电话 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 球龄 */
    private int tennisAge;
    /** 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
    private int tennisLevel;
    /** 个人说明 */
    private int personalInfo;
    /** 登陆次数 */
    private int loginTimes;
    /** 最后登陆时间 */
    private String lastLoginDate;
    /** 设备标识 */
    private String deviceFlag;
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
    
    /** get 密码 */
    public String getPassword(){
    	return this.password;
    }

    /** set 密码 */
    public void setPassword(String password){
    	this.password = password;
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
    public Date getRegisterDate(){
    	return this.registerDate;
    }

    /** set 注册时间 */
    public void setRegisterDate(Date registerDate){
    	this.registerDate = registerDate;
    }
    
    /** get 年龄 */
    public int getAge(){
    	return this.age;
    }

    /** set 年龄 */
    public void setAge(int age){
    	this.age = age;
    }
    
    /** get 地址 */
    public String getAddress(){
    	return this.address;
    }

    /** set 地址 */
    public void setAddress(String address){
    	this.address = address;
    }
    
    /** get 生日 用时间戳？（简单的使用格式化的日期字符串也可以） */
    public String getBirthday(){
    	return this.birthday;
    }

    /** set 生日 用时间戳？（简单的使用格式化的日期字符串也可以） */
    public void setBirthday(String birthday){
    	this.birthday = birthday;
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
    
    /** get 邮箱 */
    public String getEmail(){
    	return this.email;
    }

    /** set 邮箱 */
    public void setEmail(String email){
    	this.email = email;
    }
    
    /** get 球龄 */
    public int getTennisAge(){
    	return this.tennisAge;
    }

    /** set 球龄 */
    public void setTennisAge(int tennisAge){
    	this.tennisAge = tennisAge;
    }
    
    /** get 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
    public int getTennisLevel(){
    	return this.tennisLevel;
    }

    /** set 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
    public void setTennisLevel(int tennisLevel){
    	this.tennisLevel = tennisLevel;
    }
    
    /** get 个人说明 */
    public int getPersonalInfo(){
    	return this.personalInfo;
    }

    /** set 个人说明 */
    public void setPersonalInfo(int personalInfo){
    	this.personalInfo = personalInfo;
    }
    
    /** get 登陆次数 */
    public int getLoginTimes(){
    	return this.loginTimes;
    }

    /** set 登陆次数 */
    public void setLoginTimes(int loginTimes){
    	this.loginTimes = loginTimes;
    }
    
    /** get 最后登陆时间 */
    public String getLastLoginDate(){
    	return this.lastLoginDate;
    }

    /** set 最后登陆时间 */
    public void setLastLoginDate(String lastLoginDate){
    	this.lastLoginDate = lastLoginDate;
    }
    
    /** get 设备标识 */
    public String getDeviceFlag(){
    	return this.deviceFlag;
    }

    /** set 设备标识 */
    public void setDeviceFlag(String deviceFlag){
    	this.deviceFlag = deviceFlag;
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
