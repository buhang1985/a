package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvPriceDODesc;
import java.math.BigDecimal;

/**
 * 服务折扣参考价 DO数据 
 * 
 */
public class MedSrvPriceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务折扣参考价主键
	public static final String ID_SRVPRICE= "Id_srvprice";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//物品id
	public static final String ID_MM= "Id_mm";
	//价格分类
	public static final String ID_PRIPAT= "Id_pripat";
	//价格分类编码
	public static final String CODE_PRIPAT= "Code_pripat";
	//标准价格
	public static final String PRICE_STD= "Price_std";
	//价格系数
	public static final String RATIO= "Ratio";
	//折扣价格
	public static final String PRICE_RATIO= "Price_ratio";
	//价格描述
	public static final String DES_PRI= "Des_pri";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务折扣参考价主键
	 * @return String
	 */
	public String getId_srvprice() {
		return ((String) getAttrVal("Id_srvprice"));
	}	
	/**
	 * 服务折扣参考价主键
	 * @param Id_srvprice
	 */
	public void setId_srvprice(String Id_srvprice) {
		setAttrVal("Id_srvprice", Id_srvprice);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类编码
	 * @return String
	 */
	public String getCode_pripat() {
		return ((String) getAttrVal("Code_pripat"));
	}	
	/**
	 * 价格分类编码
	 * @param Code_pripat
	 */
	public void setCode_pripat(String Code_pripat) {
		setAttrVal("Code_pripat", Code_pripat);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}	
	/**
	 * 标准价格
	 * @param Price_std
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getRatio() {
		return ((FDouble) getAttrVal("Ratio"));
	}	
	/**
	 * 价格系数
	 * @param Ratio
	 */
	public void setRatio(FDouble Ratio) {
		setAttrVal("Ratio", Ratio);
	}
	/**
	 * 折扣价格
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}	
	/**
	 * 折扣价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 价格描述
	 * @return String
	 */
	public String getDes_pri() {
		return ((String) getAttrVal("Des_pri"));
	}	
	/**
	 * 价格描述
	 * @param Des_pri
	 */
	public void setDes_pri(String Des_pri) {
		setAttrVal("Des_pri", Des_pri);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_srvprice";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_price";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvPriceDODesc.class);
	}
	
}