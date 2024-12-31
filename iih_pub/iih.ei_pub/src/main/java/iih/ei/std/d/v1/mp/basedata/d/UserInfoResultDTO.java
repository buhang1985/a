package iih.ei.std.d.v1.mp.basedata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用户基础数据出参 DTO数据 
 * 
 */
public class UserInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户基础数据
	 * @return String
	 */
	public FArrayList getUserinfo() {
		return ((FArrayList) getAttrVal("Userinfo"));
	}	
	/**
	 * 用户基础数据
	 * @param Userinfo
	 */
	public void setUserinfo(FArrayList Userinfo) {
		setAttrVal("Userinfo", Userinfo);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}