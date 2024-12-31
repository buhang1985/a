package iih.mm.pl.departrequest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.departrequest.d.desc.DepartReqItemDODesc;
import java.math.BigDecimal;

/**
 * 科室请领明细 DO数据 
 * 
 */
public class DepartReqItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//领用申请明细主键
	public static final String ID_DAITM= "Id_daitm";
	//领用申请单
	public static final String ID_DA= "Id_da";
	//序号
	public static final String SORTNO= "Sortno";
	//物品
	public static final String ID_MM= "Id_mm";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//生产厂家
	public static final String ID_SUP= "Id_sup";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//消耗量_实际单位
	public static final String QUAN_USE= "Quan_use";
	//申请数量_实际单位
	public static final String QUAN_DA_ACT= "Quan_da_act";
	//金额_申请
	public static final String AMT_DA= "Amt_da";
	//实发数量
	public static final String QUAN= "Quan";
	//金额_实发
	public static final String AMT= "Amt";
	//描述
	public static final String DES= "Des";
	//物品特性
	public static final String CHARACTER= "Character";
	//医疗服务名称
	public static final String SRV_NAME= "Srv_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 领用申请明细主键
	 * @return String
	 */
	public String getId_daitm() {
		return ((String) getAttrVal("Id_daitm"));
	}	
	/**
	 * 领用申请明细主键
	 * @param Id_daitm
	 */
	public void setId_daitm(String Id_daitm) {
		setAttrVal("Id_daitm", Id_daitm);
	}
	/**
	 * 领用申请单
	 * @return String
	 */
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	/**
	 * 领用申请单
	 * @param Id_da
	 */
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
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
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 实际包装单位
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	/**
	 * 实际包装单位
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 进价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价_实际单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 售价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 售价_实际单位
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 消耗量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_use() {
		return ((FDouble) getAttrVal("Quan_use"));
	}	
	/**
	 * 消耗量_实际单位
	 * @param Quan_use
	 */
	public void setQuan_use(FDouble Quan_use) {
		setAttrVal("Quan_use", Quan_use);
	}
	/**
	 * 申请数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_da_act() {
		return ((FDouble) getAttrVal("Quan_da_act"));
	}	
	/**
	 * 申请数量_实际单位
	 * @param Quan_da_act
	 */
	public void setQuan_da_act(FDouble Quan_da_act) {
		setAttrVal("Quan_da_act", Quan_da_act);
	}
	/**
	 * 金额_申请
	 * @return FDouble
	 */
	public FDouble getAmt_da() {
		return ((FDouble) getAttrVal("Amt_da"));
	}	
	/**
	 * 金额_申请
	 * @param Amt_da
	 */
	public void setAmt_da(FDouble Amt_da) {
		setAttrVal("Amt_da", Amt_da);
	}
	/**
	 * 实发数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 实发数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 金额_实发
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额_实发
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 物品特性
	 * @return String
	 */
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}	
	/**
	 * 物品特性
	 * @param Character
	 */
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 医疗服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 服务项目外键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目外键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
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
		return "Id_daitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_DA_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DepartReqItemDODesc.class);
	}
	
}