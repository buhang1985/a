package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 频次目录DTO DTO数据 
 * 
 */
public class FreqBaseInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 频次主键
	 * @return String
	 */
	public String getId_mifreq() {
		return ((String) getAttrVal("Id_mifreq"));
	}
	/**
	 * 频次主键
	 * @param Id_mifreq
	 */
	public void setId_mifreq(String Id_mifreq) {
		setAttrVal("Id_mifreq", Id_mifreq);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * HIS频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * HIS频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医保系统
	 * @return String
	 */
	public String getId_mis() {
		return ((String) getAttrVal("Id_mis"));
	}
	/**
	 * 医保系统
	 * @param Id_mis
	 */
	public void setId_mis(String Id_mis) {
		setAttrVal("Id_mis", Id_mis);
	}
}