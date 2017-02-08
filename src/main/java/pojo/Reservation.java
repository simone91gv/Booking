package pojo;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private User user;
	private Resource resource;
	private DateTime beginDate;
	private DateTime endDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public DateTime getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(DateTime beginDate) {
		this.beginDate = beginDate;
	}
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", resource=" + resource + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	
	

}
