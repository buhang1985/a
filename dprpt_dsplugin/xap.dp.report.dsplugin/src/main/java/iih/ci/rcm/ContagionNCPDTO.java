package iih.ci.rcm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContagionNCPDTO {
	
	private String severity;//临床严重程度
	private String outdate;// 出院或者解除隔离日期
	private String imported;//是否输入病例
	private String region;//入境前居住或旅行的国家或地区

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(outdate);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.outdate = str;
		} else {
			this.outdate = outdate;
		}
	}

    public String getImported() {
		return imported;
	}

	public void setImported(String imported) {
		this.imported = imported;
	}

    public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
}
