package air.balloon.tennis.model;

/**
 * Created by oliver on 3/21/14.
 */
public class EventModel {



  private  int id;//活动ID
    private  String title;//标题
    private  String descrition;//内容描述
    // 应该是发起者的LIST<userID>

    private int ownerid;//发起者(应该只有一个发起者）

    // same as up
    private   List<Integer> participants; //参与者
    private  String phone;//电话ids
    private  double totolPrice;//费用

    private  String require;//对手水平要求
    //评论模型List<>
    private  List<EvaluationModel> evaluations;//评论
    private  Date commitTime;//发起时间
    private  Date eventTime;//活动时间
    //应该是场地id，经纬度应该是在场地里面的 （活动应该也有，可以查找附近人发布的活动，我们在发布活动的时候定位地址）
    private  int courtid;//地点
    private double longitude;//经度
    private double latitude;//纬度
    private String remark;//备注

    // 分类是什么意思
    private int categoryid;//分类（活动分类，如排球、网球、先把分类考虑进去）


    // 谁来审批？是审批什么，我个人理解是发布活动的权限(反正就是几个状态值，不考虑也没关系）
    private  int statues;//状态：2审核中，1未完成，0已完成 （这个是用来显示的，如某些已完成的活动就不在app中显示出来，或者垃圾信息）

    //没有理解权重的意思
    private  int weight;//权重（影响排序，可以竞价排名什么的，如VIP客户的信息可以拍到前面）

    // 收藏应该是个中间表，对应活动和人员
    private  boolean collect;//收藏
}
