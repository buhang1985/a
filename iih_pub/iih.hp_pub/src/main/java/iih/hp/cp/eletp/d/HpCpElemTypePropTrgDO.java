package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletp.d.desc.HpCpElemTypePropTrgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素类型属性联动设置 DO数据 
 * 
 */
public class HpCpElemTypePropTrgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//属性联动ID
	public static final String ID_ELETPPPETRG= "Id_eletpppetrg";
	//元素类型id
	public static final String ID_ELETP= "Id_eletp";
	//触发元素属性串
	public static final String TRG_PPE_LST= "Trg_ppe_lst";
	//属性联动服务
	public static final String PPE_TRG_SRV= "Ppe_trg_srv";
	//属性入参对串
	public static final String PPE_INPARA_LST= "Ppe_inpara_lst";
	//属性出参对串
	public static final String PPE_OUTPARA_LST= "Ppe_outpara_lst";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 属性联动ID
	 * @return String
	 */
	public String getId_eletpppetrg() {
		return ((String) getAttrVal("Id_eletpppetrg"));
	}	
	/**
	 * 属性联动ID
	 * @param Id_eletpppetrg
	 */
	public void setId_eletpppetrg(String Id_eletpppetrg) {
		setAttrVal("Id_eletpppetrg", Id_eletpppetrg);
	}
	/**
	 * 元素类型id
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型id
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 触发元素属性串
	 * @return String
	 */
	public String getTrg_ppe_lst() {
		return ((String) getAttrVal("Trg_ppe_lst"));
	}	
	/**
	 * 触发元素属性串
	 * @param Trg_ppe_lst
	 */
	public void setTrg_ppe_lst(String Trg_ppe_lst) {
		setAttrVal("Trg_ppe_lst", Trg_ppe_lst);
	}
	/**
	 * 属性联动服务
	 * @return String
	 */
	public String getPpe_trg_srv() {
		return ((String) getAttrVal("Ppe_trg_srv"));
	}	
	/**
	 * 属性联动服务
	 * @param Ppe_trg_srv
	 */
	public void setPpe_trg_srv(String Ppe_trg_srv) {
		setAttrVal("Ppe_trg_srv", Ppe_trg_srv);
	}
	/**
	 * 属性入参对串
	 * @return String
	 */
	public String getPpe_inpara_lst() {
		return ((String) getAttrVal("Ppe_inpara_lst"));
	}	
	/**
	 * 属性入参对串
	 * @param Ppe_inpara_lst
	 */
	public void setPpe_inpara_lst(String Ppe_inpara_lst) {
		setAttrVal("Ppe_inpara_lst", Ppe_inpara_lst);
	}
	/**
	 * 属性出参对串
	 * @return String
	 */
	public String getPpe_outpara_lst() {
		return ((String) getAttrVal("Ppe_outpara_lst"));
	}	
	/**
	 * 属性出参对串
	 * @param Ppe_outpara_lst
	 */
	public void setPpe_outpara_lst(String Ppe_outpara_lst) {
		setAttrVal("Ppe_outpara_lst", Ppe_outpara_lst);
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
		return "Id_eletpppetrg";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELETP_PPE_TRG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTypePropTrgDODesc.class);
	}
	
}