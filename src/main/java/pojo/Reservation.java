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
	
	private boolean active;
	private DateTime returnDate;
	
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public DateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(DateTime returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", resource=" + resource + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", active=" + active + ", returnDate=" + returnDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (active != other.active)
			return false;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
