package air.balloon.tennis.model;

/**
 *
 * @author gen code 
 *
 */
public class Evaluate {
	
    /**  */
    private long id;
    /** 评价 */
    private String evaluate;
    /** 评分 */
    private double score;
    /** 评论分类 */
    private BaseEnum category;


	
    /** get  */
    public long getId(){
    	return this.id;
    }

    /** set  */
    public void setId(long id){
    	this.id = id;
    }
    
    /** get 评价 */
    public String getEvaluate(){
    	return this.evaluate;
    }

    /** set 评价 */
    public void setEvaluate(String evaluate){
    	this.evaluate = evaluate;
    }
    
    /** get 评分 */
    public double getScore(){
    	return this.score;
    }

    /** set 评分 */
    public void setScore(double score){
    	this.score = score;
    }
    
    /** get 评论分类 */
    public BaseEnum getCategory(){
    	return this.category;
    }

    /** set 评论分类 */
    public void setCategory(BaseEnum category){
    	this.category = category;
    }
    


}
