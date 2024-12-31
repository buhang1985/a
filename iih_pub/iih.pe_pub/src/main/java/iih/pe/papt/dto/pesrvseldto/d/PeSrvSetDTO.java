package iih.pe.papt.dto.pesrvseldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检套餐 DTO数据 
 * 
 */
public class PeSrvSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检套餐主键标识
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐主键标识
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 套餐编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 套餐编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 套餐名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 套餐名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别限制
	 * @return String
	 */
	public String getSexlimit() {
		return ((String) getAttrVal("Sexlimit"));
	}
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(String Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPri_srvset() {
		return ((FDouble) getAttrVal("Pri_srvset"));
	}
	/**
	 * 基础价格
	 * @param Pri_srvset
	 */
	public void setPri_srvset(FDouble Pri_srvset) {
		setAttrVal("Pri_srvset", Pri_srvset);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
}