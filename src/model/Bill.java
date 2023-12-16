package model;

public class Bill {
          private int id;
          private String name;
          private String MobileNumber;
          private String Email;
          private String date;  
          private String total;
          private String createdby;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobileNumber() {
			return MobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			MobileNumber = mobileNumber;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public String getCreatedby() {
			return createdby;
		}
		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}
}
