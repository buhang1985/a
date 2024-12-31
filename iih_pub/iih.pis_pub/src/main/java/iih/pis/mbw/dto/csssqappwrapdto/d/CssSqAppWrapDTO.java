package iih.pis.mbw.dto.csssqappwrapdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class CssSqAppWrapDTO {

	// 问卷模板名称
	@RPCField(id = 1)
	private String name;
	// 问卷模板id
	@RPCField(id = 10)
	private String id_moudle;
	// 描述
	@RPCField(id = 2)
	private String des;
	// 发送记录id
	@RPCField(id = 3)
	private String id_sq_rec;
	// 是否填写
	@RPCField(id = 4)
	private boolean isfinish;
	// 题数
	@RPCField(id = 5)
	private int count;
	// 开始时间
	@RPCField(id = 6)
	private String dt_b;
	// 结束时间
	@RPCField(id = 7)
	private String dt_e;
	// 图片
	@RPCField(id = 8)
	private String picture;
	// 题目集合
	@RPCField(id = 9)
	private List<CssSqItmDTO> subjectlist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_moudle() {
		return id_moudle;
	}

	public void setId_moudle(String id_moudle) {
		this.id_moudle = id_moudle;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getId_sq_rec() {
		return id_sq_rec;
	}

	public void setId_sq_rec(String id_sq_rec) {
		this.id_sq_rec = id_sq_rec;
	}

	public boolean getIsfinish() {
		return isfinish;
	}

	public void setIsfinish(boolean isfinish) {
		this.isfinish = isfinish;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDt_b() {
		return dt_b;
	}

	public void setDt_b(String dt_b) {
		this.dt_b = dt_b;
	}

	public String getDt_e() {
		return dt_e;
	}

	public void setDt_e(String dt_e) {
		this.dt_e = dt_e;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<CssSqItmDTO> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<CssSqItmDTO> subjectlist) {
		this.subjectlist = subjectlist;
	}

}
