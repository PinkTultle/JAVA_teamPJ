package JDBC;

public class ReportDTO {

	private String postid;
	private int reportnum;
	private int itemnumber;
	private String itemname;
	private String category;
	private String status;
	private String reportdetail;
	private String Answer;

	public String getPostID() {
		return postid;
	}

	public void setPostID(String s) {
		this.postid = s;
	}

	public int getReportNum() {
		return reportnum;
	}

	public void setReportNum(int n) {
		reportnum = n;
	}

	public int getItemNumber() {
		return itemnumber;
	}

	public void setItemNumber(int n) {
		itemnumber = n;
	}

	public String getItemName() {
		return itemname;
	}

	public void setItemName(String s) {
		itemname = s;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String s) {
		category = s;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String s) {
		status = s;
	}

	public String getReportDetail() {
		return reportdetail;
	}

	public void setReportDetail(String s) {
		reportdetail = s;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		this.Answer = answer;
	}

}
