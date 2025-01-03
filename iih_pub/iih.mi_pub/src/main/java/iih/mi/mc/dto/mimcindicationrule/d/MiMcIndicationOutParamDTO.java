package iih.mi.mc.dto.mimcindicationrule.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保适应症校验出参 DTO数据 
 * 
 */
public class MiMcIndicationOutParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 判断结果
	 * @return FBoolean
	 */
	public FBoolean getFg_checkflag() {
		return ((FBoolean) getAttrVal("Fg_checkflag"));
	}
	/**
	 * 判断结果
	 * @param Fg_checkflag
	 */
	public void setFg_checkflag(FBoolean Fg_checkflag) {
		setAttrVal("Fg_checkflag", Fg_checkflag);
	}
	/**
	 * 服务判断结果
	 * @return String
	 */
	public String getEu_orsrvhp() {
		return ((String) getAttrVal("Eu_orsrvhp"));
	}
	/**
	 * 服务判断结果
	 * @param Eu_orsrvhp
	 */
	public void setEu_orsrvhp(String Eu_orsrvhp) {
		setAttrVal("Eu_orsrvhp", Eu_orsrvhp);
	}
	/**
	 * 医保目录类型id
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型id
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 判断方式
	 * @return String
	 */
	public String getCode_hpindicjudged() {
		return ((String) getAttrVal("Code_hpindicjudged"));
	}
	/**
	 * 判断方式
	 * @param Code_hpindicjudged
	 */
	public void setCode_hpindicjudged(String Code_hpindicjudged) {
		setAttrVal("Code_hpindicjudged", Code_hpindicjudged);
	}
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}
	/**
	 * 医保限制条件
	 * @param Des_hplimit
	 */
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	/**
	 * his限制条件
	 * @return String
	 */
	public String getDes_hislimit() {
		return ((String) getAttrVal("Des_hislimit"));
	}
	/**
	 * his限制条件
	 * @param Des_hislimit
	 */
	public void setDes_hislimit(String Des_hislimit) {
		setAttrVal("Des_hislimit", Des_hislimit);
	}
	/**
	 * 限制条件
	 * @return String
	 */
	public String getDes_limit() {
		return ((String) getAttrVal("Des_limit"));
	}
	/**
	 * 限制条件
	 * @param Des_limit
	 */
	public void setDes_limit(String Des_limit) {
		setAttrVal("Des_limit", Des_limit);
	}
	/**
	 * 多支付比例集合
	 * @return FArrayList
	 */
	public FArrayList getMutipayratiolist() {
		return ((FArrayList) getAttrVal("Mutipayratiolist"));
	}
	/**
	 * 多支付比例集合
	 * @param Mutipayratiolist
	 */
	public void setMutipayratiolist(FArrayList Mutipayratiolist) {
		setAttrVal("Mutipayratiolist", Mutipayratiolist);
	}
	/**
	 * 设置医保限定诊断集合
	 * @return FArrayList
	 */
	public FArrayList getHpsrvctrdilist() {
		return ((FArrayList) getAttrVal("Hpsrvctrdilist"));
	}
	/**
	 * 设置医保限定诊断集合
	 * @param Hpsrvctrdilist
	 */
	public void setHpsrvctrdilist(FArrayList Hpsrvctrdilist) {
		setAttrVal("Hpsrvctrdilist", Hpsrvctrdilist);
	}
	/**
	 * 设置医保限定病种集合
	 * @return FArrayList
	 */
	public FArrayList getHpsrvctrdslist() {
		return ((FArrayList) getAttrVal("Hpsrvctrdslist"));
	}
	/**
	 * 设置医保限定病种集合
	 * @param Hpsrvctrdslist
	 */
	public void setHpsrvctrdslist(FArrayList Hpsrvctrdslist) {
		setAttrVal("Hpsrvctrdslist", Hpsrvctrdslist);
	}
	/**
	 * 是否医保
	 * @return FBoolean
	 */
	public FBoolean getFg_srv_hp() {
		return ((FBoolean) getAttrVal("Fg_srv_hp"));
	}
	/**
	 * 是否医保
	 * @param Fg_srv_hp
	 */
	public void setFg_srv_hp(FBoolean Fg_srv_hp) {
		setAttrVal("Fg_srv_hp", Fg_srv_hp);
	}
	/**
	 * 是否自费
	 * @return FBoolean
	 */
	public FBoolean getFg_srv_self() {
		return ((FBoolean) getAttrVal("Fg_srv_self"));
	}
	/**
	 * 是否自费
	 * @param Fg_srv_self
	 */
	public void setFg_srv_self(FBoolean Fg_srv_self) {
		setAttrVal("Fg_srv_self", Fg_srv_self);
	}
	/**
	 * 是否允许修改
	 * @return FBoolean
	 */
	public FBoolean getFg_allowdedit() {
		return ((FBoolean) getAttrVal("Fg_allowdedit"));
	}
	/**
	 * 是否允许修改
	 * @param Fg_allowdedit
	 */
	public void setFg_allowdedit(FBoolean Fg_allowdedit) {
		setAttrVal("Fg_allowdedit", Fg_allowdedit);
	}
}