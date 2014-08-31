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
    private BaseEnum category_BaseEnum_Model;


	
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
    public BaseEnum getCategory_BaseEnum_Model(){
    	return this.category_BaseEnum_Model;
    }

    /** set 评论分类 */
    public void setCategory_BaseEnum_Model(BaseEnum category_BaseEnum_Model){
    	this.category_BaseEnum_Model = category_BaseEnum_Model;
    }
    



    public String toString(){
		return "Evaluate{" + 
			",id='" + id + "'" + 
			",evaluate='" + evaluate + "'" + 
			",score='" + score + "'" + 
			",category_BaseEnum_Model='" + category_BaseEnum_Model + "'" + 
		
		"}";

    }



}
