package iih.bl.cg.blwardrefund.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blwardrefund.d.desc.BlRefundItemDODesc;
import java.math.BigDecimal;

/**
 * 退费单明细项目 DO数据 
 * 
 */
public class BlRefundItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//退费明细主键
	public static final String ID_RFDITM= "Id_rfditm";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//退费申请单
	public static final String ID_RFDAP= "Id_rfdap";
	//撤消操作
	public static final String ID_RFDCANC= "Id_rfdcanc";
	//退费确认单
	public static final String ID_RFDCHK= "Id_rfdchk";
	//退费项目号
	public static final String SORTNO= "Sortno";
	//退费项目类型
	public static final String EU_RFDITMTP= "Eu_rfditmtp";
	//退费数量
	public static final String QUAN= "Quan";
	//退费记账明细
	public static final String ID_CGIP= "Id_cgip";
	//退费医嘱
	public static final String ID_OR= "Id_or";
	//项目描述
	public static final String DES= "Des";
	//退费单项目状态编码
	public static final String SD_SU_RDFITM= "Sd_su_rdfitm";
	//退费单类型编码
	public static final String SD_RFDAPTP= "Sd_rfdaptp";
	//退费单项目状态ID
	public static final String ID_SU_RDFITM= "Id_su_rdfitm";
	//退费单类型ID
	public static final String ID_RFDAPTP= "Id_rfdaptp";
	//活动标志
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 退费申请单
	 * @return String
	 */
	public String getId_rfdap() {
		return ((String) getAttrVal("Id_rfdap"));
	}	
	/**
	 * 退费申请单
	 * @param Id_rfdap
	 */
	public void setId_rfdap(String Id_rfdap) {
		setAttrVal("Id_rfdap", Id_rfdap);
	}
	/**
	 * 撤消操作
	 * @return String
	 */
	public String getId_rfdcanc() {
		return ((String) getAttrVal("Id_rfdcanc"));
	}	
	/**
	 * 撤消操作
	 * @param Id_rfdcanc
	 */
	public void setId_rfdcanc(String Id_rfdcanc) {
		setAttrVal("Id_rfdcanc", Id_rfdcanc);
	}
	/**
	 * 退费确认单
	 * @return String
	 */
	public String getId_rfdchk() {
		return ((String) getAttrVal("Id_rfdchk"));
	}	
	/**
	 * 退费确认单
	 * @param Id_rfdchk
	 */
	public void setId_rfdchk(String Id_rfdchk) {
		setAttrVal("Id_rfdchk", Id_rfdchk);
	}
	/**
	 * 退费项目号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 退费项目号
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
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 退费数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 退费记账明细
	 * @return String
	 */
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}	
	/**
	 * 退费记账明细
	 * @param Id_cgip
	 */
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	/**
	 * 退费医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 退费医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 项目描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 项目描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 退费单项目状态ID
	 * @return String
	 */
	public String getId_su_rdfitm() {
		return ((String) getAttrVal("Id_su_rdfitm"));
	}	
	/**
	 * 退费单项目状态ID
	 * @param Id_su_rdfitm
	 */
	public void setId_su_rdfitm(String Id_su_rdfitm) {
		setAttrVal("Id_su_rdfitm", Id_su_rdfitm);
	}
	/**
	 * 退费单类型ID
	 * @return String
	 */
	public String getId_rfdaptp() {
		return ((String) getAttrVal("Id_rfdaptp"));
	}	
	/**
	 * 退费单类型ID
	 * @param Id_rfdaptp
	 */
	public void setId_rfdaptp(String Id_rfdaptp) {
		setAttrVal("Id_rfdaptp", Id_rfdaptp);
	}
	/**
	 * 活动标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 活动标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_rfditm";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_rfd_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRefundItemDODesc.class);
	}
	
}