package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方类型DTO DTO数据 
 * 
 */
public class PresTpBaseInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方类型主键
	 * @return String
	 */
	public String getId_miprestp() {
		return ((String) getAttrVal("Id_miprestp"));
	}
	/**
	 * 处方类型主键
	 * @param Id_miprestp
	 */
	public void setId_miprestp(String Id_miprestp) {
		setAttrVal("Id_miprestp", Id_miprestp);
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
	 * HIS处方类型
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}
	/**
	 * HIS处方类型
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * HIS处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * HIS处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
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