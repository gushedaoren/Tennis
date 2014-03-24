package air.balloon.tennis.model;

import java.util.Date;
import java.util.List;

/**
 * Created by oliver on 3/21/14.
 */
public class UserModel {

    private int userId;//id
    private String accountName;//账户名
    private String password;//密码，加密
    private String name;//用户姓名
    private int age;//年龄
    private String address;//地址
    private String birthday;//生日  用时间戳？（简单的使用格式化的日期字符串也可以）
    private int gender;//性别 0代表男士 1代表女士
    // 图片可能需要建一个单独的图片Model，一般不存数据库（小文件一样的）可能考虑放本地文件系统，或者为了扩展，放云磁盘
    // Photo 而且客户端就是一个名称和url，服务端需要更多处理信息
    private int photeid;//头像
    private String phone;//联系电话  可能有多个 用|分割  eg: 18000000|1388888888
    private String email;//邮箱
    private int tennisAge;//球龄
    private int tennisLevel;//水平  1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5
    private int role;//角色 位运算  0代表普通球友  1代表教练
    private int personalInformation;//个人说明
    private Date registrationDate;//注册时间
    private int loginTimes;//登陆次数
    private Date lastLoginDate;//最后登陆时间
    // 这个如果指的是装备的话，应该也是独立的Model
    private String deviceFlag;//设备标识
    private int state;//登陆状态 0 在线 1 不在线 2 黑名单
    private String integral;//积分
    private String accountLevel;//等级
    // 好友印象应该也是一个List<Model>
    private List<EvaluationModel> friendsImpressions;//好友印象
}
