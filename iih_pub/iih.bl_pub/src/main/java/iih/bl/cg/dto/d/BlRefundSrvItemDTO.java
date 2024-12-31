package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 申请单明细 DTO数据 
 * 
 */
public class BlRefundSrvItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 退费明细主键
	 * @return String
	 */
	public String getId_rfditm() {
		return ((String) getAttrVal("Id_rfditm"));
	}
	/**
	 * 退费明细主键
	 * @param Id_rfditm
	 */
	public void setId_rfditm(String Id_rfditm) {
		setAttrVal("Id_rfditm", Id_rfditm);
	}
	/**
	 * 退费申请单主键
	 * @return String
	 */
	public String getId_rfdap() {
		return ((String) getAttrVal("Id_rfdap"));
	}
	/**
	 * 退费申请单主键
	 * @param Id_rfdap
	 */
	public void setId_rfdap(String Id_rfdap) {
		setAttrVal("Id_rfdap", Id_rfdap);
	}
	/**
	 * 取消申请主键
	 * @return String
	 */
	public String getId_rfdcanc() {
		return ((String) getAttrVal("Id_rfdcanc"));
	}
	/**
	 * 取消申请主键
	 * @param Id_rfdcanc
	 */
	public void setId_rfdcanc(String Id_rfdcanc) {
		setAttrVal("Id_rfdcanc", Id_rfdcanc);
	}
	/**
	 * 审核确认主键
	 * @return String
	 */
	public String getId_rfdchk() {
		return ((String) getAttrVal("Id_rfdchk"));
	}
	/**
	 * 审核确认主键
	 * @param Id_rfdchk
	 */
	public void setId_rfdchk(String Id_rfdchk) {
		setAttrVal("Id_rfdchk", Id_rfdchk);
	}
	/**
	 * 项目序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 项目序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 退费项目类型
	 * @return Integer
	 */
	public Integer getEu_rfditmtp() {
		return ((Integer) getAttrVal("Eu_rfditmtp"));
	}
	/**
	 * 退费项目类型
	 * @param Eu_rfditmtp
	 */
	public void setEu_rfditmtp(Integer Eu_rfditmtp) {
		setAttrVal("Eu_rfditmtp", Eu_rfditmtp);
	}
	/**
	 * 退费项目类型名称
	 * @return String
	 */
	public String getName_rfditmtp() {
		return ((String) getAttrVal("Name_rfditmtp"));
	}
	/**
	 * 退费项目类型名称
	 * @param Name_rfditmtp
	 */
	public void setName_rfditmtp(String Name_rfditmtp) {
		setAttrVal("Name_rfditmtp", Name_rfditmtp);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
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
	 * 记账id
	 * @return String
	 */
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}
	/**
	 * 记账id
	 * @param Id_cgip
	 */
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	/**
	 * 记账编码
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}
	/**
	 * 记账编码
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 项目描述
	 * @return String
	 */
	public String getItm_des() {
		return ((String) getAttrVal("Itm_des"));
	}
	/**
	 * 项目描述
	 * @param Itm_des
	 */
	public void setItm_des(String Itm_des) {
		setAttrVal("Itm_des", Itm_des);
	}
	/**
	 * 退费单项目状态编码
	 * @return String
	 */
	public String getSd_su_rdfitm() {
		return ((String) getAttrVal("Sd_su_rdfitm"));
	}
	/**
	 * 退费单项目状态编码
	 * @param Sd_su_rdfitm
	 */
	public void setSd_su_rdfitm(String Sd_su_rdfitm) {
		setAttrVal("Sd_su_rdfitm", Sd_su_rdfitm);
	}
	/**
	 * 退费单项目状态id
	 * @return String
	 */
	public String getId_su_rdfitm() {
		return ((String) getAttrVal("Id_su_rdfitm"));
	}
	/**
	 * 退费单项目状态id
	 * @param Id_su_rdfitm
	 */
	public void setId_su_rdfitm(String Id_su_rdfitm) {
		setAttrVal("Id_su_rdfitm", Id_su_rdfitm);
	}
	/**
	 * 退费单项目状态名称
	 * @return String
	 */
	public String getName_su_rdfitm() {
		return ((String) getAttrVal("Name_su_rdfitm"));
	}
	/**
	 * 退费单项目状态名称
	 * @param Name_su_rdfitm
	 */
	public void setName_su_rdfitm(String Name_su_rdfitm) {
		setAttrVal("Name_su_rdfitm", Name_su_rdfitm);
	}
	/**
	 * 退费单类型编码
	 * @return String
	 */
	public String getSd_rfdaptp() {
		return ((String) getAttrVal("Sd_rfdaptp"));
	}
	/**
	 * 退费单类型编码
	 * @param Sd_rfdaptp
	 */
	public void setSd_rfdaptp(String Sd_rfdaptp) {
		setAttrVal("Sd_rfdaptp", Sd_rfdaptp);
	}
	/**
	 * 退费单类型id
	 * @return String
	 */
	public String getId_rfdaptp() {
		return ((String) getAttrVal("Id_rfdaptp"));
	}
	/**
	 * 退费单类型id
	 * @param Id_rfdaptp
	 */
	public void setId_rfdaptp(String Id_rfdaptp) {
		setAttrVal("Id_rfdaptp", Id_rfdaptp);
	}
	/**
	 * 退费单类型名称
	 * @return String
	 */
	public String getName_rfdaptp() {
		return ((String) getAttrVal("Name_rfdaptp"));
	}
	/**
	 * 退费单类型名称
	 * @param Name_rfdaptp
	 */
	public void setName_rfdaptp(String Name_rfdaptp) {
		setAttrVal("Name_rfdaptp", Name_rfdaptp);
	}
	/**
	 * 是否通过
	 * @return FBoolean
	 */
	public FBoolean getFg_adopt() {
		return ((FBoolean) getAttrVal("Fg_adopt"));
	}
	/**
	 * 是否通过
	 * @param Fg_adopt
	 */
	public void setFg_adopt(FBoolean Fg_adopt) {
		setAttrVal("Fg_adopt", Fg_adopt);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_ap() {
		return ((String) getAttrVal("Code_ap"));
	}
	/**
	 * 申请单号
	 * @param Code_ap
	 */
	public void setCode_ap(String Code_ap) {
		setAttrVal("Code_ap", Code_ap);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
}