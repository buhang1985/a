package iih.ei.std.d.v1.en.getusergroup.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取用户组织出参 DTO数据 
 * 
 */
public class GetUserGroupResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户组织信息
	 * @return String
	 */
	public FArrayList getUsergroupinfo() {
		return ((FArrayList) getAttrVal("Usergroupinfo"));
	}	
	/**
	 * 用户组织信息
	 * @param Usergroupinfo
	 */
	public void setUsergroupinfo(FArrayList Usergroupinfo) {
		setAttrVal("Usergroupinfo", Usergroupinfo);
	}
}