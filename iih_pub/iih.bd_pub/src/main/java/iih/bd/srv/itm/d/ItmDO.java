package iih.bd.srv.itm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.itm.d.desc.ItmDODesc;
import java.math.BigDecimal;

/**
 * 质控项 DO数据 
 * 
 */
public class ItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_QA_ITM= "Id_qa_itm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//序号
	public static final String SORTNO= "Sortno";
	//质控要求
	public static final String REQ= "Req";
	//质控扣分类型
	public static final String ID_QA_DRP_SCR_TP= "Id_qa_drp_scr_tp";
	//质控扣分类型编码
	public static final String SD_QA_DRP_SCR_TP= "Sd_qa_drp_scr_tp";
	//单次扣分值
	public static final String ONCE_DRP_SCR= "Once_drp_scr";
	//累计最大扣分值
	public static final String MAX_DRP_SCR= "Max_drp_scr";
	//自动质控标志
	public static final String FG_AUTO_QA= "Fg_auto_qa";
	//一级分类
	public static final String ID_FST= "Id_fst";
	//二级分类
	public static final String ID_SND= "Id_snd";
	//扣分标准
	public static final String DEDUCT_DES= "Deduct_des";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//必须修复标志
	public static final String FG_REPAIR= "Fg_repair";
	//默认整改标志
	public static final String FG_DFT_RFM= "Fg_dft_rfm";
	//质控类型
	public static final String ID_QA= "Id_qa";
	//质控类型编码
	public static final String SD_QA= "Sd_qa";
	//重度缺陷标志
	public static final String FG_SERIOUS= "Fg_serious";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String QA_DRP_SCR_TP_NAME= "Qa_drp_scr_tp_name";
	//名称
	public static final String FST_NAME= "Fst_name";
	//名称
	public static final String SND_NAME= "Snd_name";
	//质控类型名称
	public static final String QA_NAME= "Qa_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}	
	/**
	 * 主键
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 质控要求
	 * @return String
	 */
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}	
	/**
	 * 质控要求
	 * @param Req
	 */
	public void setReq(String Req) {
		setAttrVal("Req", Req);
	}
	/**
	 * 质控扣分类型
	 * @return String
	 */
	public String getId_qa_drp_scr_tp() {
		return ((String) getAttrVal("Id_qa_drp_scr_tp"));
	}	
	/**
	 * 质控扣分类型
	 * @param Id_qa_drp_scr_tp
	 */
	public void setId_qa_drp_scr_tp(String Id_qa_drp_scr_tp) {
		setAttrVal("Id_qa_drp_scr_tp", Id_qa_drp_scr_tp);
	}
	/**
	 * 质控扣分类型编码
	 * @return String
	 */
	public String getSd_qa_drp_scr_tp() {
		return ((String) getAttrVal("Sd_qa_drp_scr_tp"));
	}	
	/**
	 * 质控扣分类型编码
	 * @param Sd_qa_drp_scr_tp
	 */
	public void setSd_qa_drp_scr_tp(String Sd_qa_drp_scr_tp) {
		setAttrVal("Sd_qa_drp_scr_tp", Sd_qa_drp_scr_tp);
	}
	/**
	 * 单次扣分值
	 * @return FDouble
	 */
	public FDouble getOnce_drp_scr() {
		return ((FDouble) getAttrVal("Once_drp_scr"));
	}	
	/**
	 * 单次扣分值
	 * @param Once_drp_scr
	 */
	public void setOnce_drp_scr(FDouble Once_drp_scr) {
		setAttrVal("Once_drp_scr", Once_drp_scr);
	}
	/**
	 * 累计最大扣分值
	 * @return FDouble
	 */
	public FDouble getMax_drp_scr() {
		return ((FDouble) getAttrVal("Max_drp_scr"));
	}	
	/**
	 * 累计最大扣分值
	 * @param Max_drp_scr
	 */
	public void setMax_drp_scr(FDouble Max_drp_scr) {
		setAttrVal("Max_drp_scr", Max_drp_scr);
	}
	/**
	 * 自动质控标志
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_qa() {
		return ((FBoolean) getAttrVal("Fg_auto_qa"));
	}	
	/**
	 * 自动质控标志
	 * @param Fg_auto_qa
	 */
	public void setFg_auto_qa(FBoolean Fg_auto_qa) {
		setAttrVal("Fg_auto_qa", Fg_auto_qa);
	}
	/**
	 * 一级分类
	 * @return String
	 */
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}	
	/**
	 * 一级分类
	 * @param Id_fst
	 */
	public void setId_fst(String Id_fst) {
		setAttrVal("Id_fst", Id_fst);
	}
	/**
	 * 二级分类
	 * @return String
	 */
	public String getId_snd() {
		return ((String) getAttrVal("Id_snd"));
	}	
	/**
	 * 二级分类
	 * @param Id_snd
	 */
	public void setId_snd(String Id_snd) {
		setAttrVal("Id_snd", Id_snd);
	}
	/**
	 * 扣分标准
	 * @return String
	 */
	public String getDeduct_des() {
		return ((String) getAttrVal("Deduct_des"));
	}	
	/**
	 * 扣分标准
	 * @param Deduct_des
	 */
	public void setDeduct_des(String Deduct_des) {
		setAttrVal("Deduct_des", Deduct_des);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	 * 必须修复标志
	 * @return FBoolean
	 */
	public FBoolean getFg_repair() {
		return ((FBoolean) getAttrVal("Fg_repair"));
	}	
	/**
	 * 必须修复标志
	 * @param Fg_repair
	 */
	public void setFg_repair(FBoolean Fg_repair) {
		setAttrVal("Fg_repair", Fg_repair);
	}
	/**
	 * 默认整改标志
	 * @return FBoolean
	 */
	public FBoolean getFg_dft_rfm() {
		return ((FBoolean) getAttrVal("Fg_dft_rfm"));
	}	
	/**
	 * 默认整改标志
	 * @param Fg_dft_rfm
	 */
	public void setFg_dft_rfm(FBoolean Fg_dft_rfm) {
		setAttrVal("Fg_dft_rfm", Fg_dft_rfm);
	}
	/**
	 * 质控类型
	 * @return String
	 */
	public String getId_qa() {
		return ((String) getAttrVal("Id_qa"));
	}	
	/**
	 * 质控类型
	 * @param Id_qa
	 */
	public void setId_qa(String Id_qa) {
		setAttrVal("Id_qa", Id_qa);
	}
	/**
	 * 质控类型编码
	 * @return String
	 */
	public String getSd_qa() {
		return ((String) getAttrVal("Sd_qa"));
	}	
	/**
	 * 质控类型编码
	 * @param Sd_qa
	 */
	public void setSd_qa(String Sd_qa) {
		setAttrVal("Sd_qa", Sd_qa);
	}
	/**
	 * 重度缺陷标志
	 * @return FBoolean
	 */
	public FBoolean getFg_serious() {
		return ((FBoolean) getAttrVal("Fg_serious"));
	}	
	/**
	 * 重度缺陷标志
	 * @param Fg_serious
	 */
	public void setFg_serious(FBoolean Fg_serious) {
		setAttrVal("Fg_serious", Fg_serious);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getQa_drp_scr_tp_name() {
		return ((String) getAttrVal("Qa_drp_scr_tp_name"));
	}	
	/**
	 * 名称
	 * @param Qa_drp_scr_tp_name
	 */
	public void setQa_drp_scr_tp_name(String Qa_drp_scr_tp_name) {
		setAttrVal("Qa_drp_scr_tp_name", Qa_drp_scr_tp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFst_name() {
		return ((String) getAttrVal("Fst_name"));
	}	
	/**
	 * 名称
	 * @param Fst_name
	 */
	public void setFst_name(String Fst_name) {
		setAttrVal("Fst_name", Fst_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSnd_name() {
		return ((String) getAttrVal("Snd_name"));
	}	
	/**
	 * 名称
	 * @param Snd_name
	 */
	public void setSnd_name(String Snd_name) {
		setAttrVal("Snd_name", Snd_name);
	}
	/**
	 * 质控类型名称
	 * @return String
	 */
	public String getQa_name() {
		return ((String) getAttrVal("Qa_name"));
	}	
	/**
	 * 质控类型名称
	 * @param Qa_name
	 */
	public void setQa_name(String Qa_name) {
		setAttrVal("Qa_name", Qa_name);
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
		return "Id_qa_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ItmDODesc.class);
	}
	
}