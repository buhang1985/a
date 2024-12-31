package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保系统DTO DTO数据 
 * 
 */
public class MisBaseInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保系统主键
	 * @return String
	 */
	public String getId_mis() {
		return ((String) getAttrVal("Id_mis"));
	}
	/**
	 * 医保系统主键
	 * @param Id_mis
	 */
	public void setId_mis(String Id_mis) {
		setAttrVal("Id_mis", Id_mis);
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
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 可用预交金标志
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}
	/**
	 * 可用预交金标志
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 持卡结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cardst() {
		return ((FBoolean) getAttrVal("Fg_cardst"));
	}
	/**
	 * 持卡结算标志
	 * @param Fg_cardst
	 */
	public void setFg_cardst(FBoolean Fg_cardst) {
		setAttrVal("Fg_cardst", Fg_cardst);
	}
	/**
	 * 医保记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 医保记账标志
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 医保机构编码
	 * @return String
	 */
	public String getMiorg_code() {
		return ((String) getAttrVal("Miorg_code"));
	}
	/**
	 * 医保机构编码
	 * @param Miorg_code
	 */
	public void setMiorg_code(String Miorg_code) {
		setAttrVal("Miorg_code", Miorg_code);
	}
	/**
	 * 医保机构名称
	 * @return String
	 */
	public String getMiorg_name() {
		return ((String) getAttrVal("Miorg_name"));
	}
	/**
	 * 医保机构名称
	 * @param Miorg_name
	 */
	public void setMiorg_name(String Miorg_name) {
		setAttrVal("Miorg_name", Miorg_name);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * CS工厂
	 * @return String
	 */
	public String getFactory_cs() {
		return ((String) getAttrVal("Factory_cs"));
	}
	/**
	 * CS工厂
	 * @param Factory_cs
	 */
	public void setFactory_cs(String Factory_cs) {
		setAttrVal("Factory_cs", Factory_cs);
	}
	/**
	 * JAVA工厂
	 * @return String
	 */
	public String getFactory_java() {
		return ((String) getAttrVal("Factory_java"));
	}
	/**
	 * JAVA工厂
	 * @param Factory_java
	 */
	public void setFactory_java(String Factory_java) {
		setAttrVal("Factory_java", Factory_java);
	}
}