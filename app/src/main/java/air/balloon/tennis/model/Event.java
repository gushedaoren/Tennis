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

    private String phone;



    private String address;

    private String level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descrition='" + descrition + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                '}';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
