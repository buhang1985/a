package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专用患者基本信息查询服务条件DTO DTO数据 
 * 
 */
public class PiPatBS520CondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 身份证
	 * @return String
	 */
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}
	/**
	 * 身份证
	 * @param Social_no
	 */
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getBirthday() {
		return ((String) getAttrVal("Birthday"));
	}
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(String Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 当前患者编码
	 * @return String
	 */
	public String getId_pat_now() {
		return ((String) getAttrVal("Id_pat_now"));
	}
	/**
	 * 当前患者编码
	 * @param Id_pat_now
	 */
	public void setId_pat_now(String Id_pat_now) {
		setAttrVal("Id_pat_now", Id_pat_now);
	}
}