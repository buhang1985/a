package iih.ems.einv.embl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.embl.d.desc.EmsBlDODesc;
import java.math.BigDecimal;

/**
 * 设备库存信息 DO数据 
 * 
 */
public class EmsBlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//设备库存主键
	public static final String ID_EMBL= "Id_embl";
	//入库单号
	public static final String ID_IN= "Id_in";
	//入库细目
	public static final String ID_INITM= "Id_initm";
	//仓库
	public static final String ID_WH= "Id_wh";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//生产厂商
	public static final String ID_FAC= "Id_fac";
	//使用科室
	public static final String ID_DEPT= "Id_dept";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//内部码
	public static final String INNERCODE= "Innercode";
	//出厂编号
	public static final String BARCODE= "Barcode";
	//生产日期
	public static final String DT_FAC= "Dt_fac";
	//数量
	public static final String NUM= "Num";
	//单价
	public static final String BUY_PRICE= "Buy_price";
	//总价
	public static final String COST= "Cost";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//产地
	public static final String PRODUCING_AREA= "Producing_area";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//使用年限
	public static final String USEFULLIFE= "Usefullife";
	//备注
	public static final String DES= "Des";
	//首次入库时间
	public static final String DT_FIN= "Dt_fin";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//批次
	public static final String BATCH= "Batch";
	//最后修改源
	public static final String MODIFSOURCE= "Modifsource";
	//最后修改源ID
	public static final String MODIFID= "Modifid";
	//出库单号
	public static final String ID_OUT= "Id_out";
	//出库单细目
	public static final String ID_OUT_ITM= "Id_out_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 设备库存主键
	 * @return String
	 */
	public String getId_embl() {
		return ((String) getAttrVal("Id_embl"));
	}	
	/**
	 * 设备库存主键
	 * @param Id_embl
	 */
	public void setId_embl(String Id_embl) {
		setAttrVal("Id_embl", Id_embl);
	}
	/**
	 * 入库单号
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单号
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 入库细目
	 * @return String
	 */
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	/**
	 * 入库细目
	 * @param Id_initm
	 */
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getId_fac() {
		return ((String) getAttrVal("Id_fac"));
	}	
	/**
	 * 生产厂商
	 * @param Id_fac
	 */
	public void setId_fac(String Id_fac) {
		setAttrVal("Id_fac", Id_fac);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 使用科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备基本信息
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基本信息
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 内部码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 内部码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 出厂编号
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 出厂编号
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 生产日期
	 * @return FDate
	 */
	public FDate getDt_fac() {
		return ((FDate) getAttrVal("Dt_fac"));
	}	
	/**
	 * 生产日期
	 * @param Dt_fac
	 */
	public void setDt_fac(FDate Dt_fac) {
		setAttrVal("Dt_fac", Dt_fac);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getNum() {
		return ((Integer) getAttrVal("Num"));
	}	
	/**
	 * 数量
	 * @param Num
	 */
	public void setNum(Integer Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getBuy_price() {
		return ((FDouble) getAttrVal("Buy_price"));
	}	
	/**
	 * 单价
	 * @param Buy_price
	 */
	public void setBuy_price(FDouble Buy_price) {
		setAttrVal("Buy_price", Buy_price);
	}
	/**
	 * 总价
	 * @return FDouble
	 */
	public FDouble getCost() {
		return ((FDouble) getAttrVal("Cost"));
	}	
	/**
	 * 总价
	 * @param Cost
	 */
	public void setCost(FDouble Cost) {
		setAttrVal("Cost", Cost);
	}
	/**
	 * 已折旧月份
	 * @return Integer
	 */
	public Integer getLess_month() {
		return ((Integer) getAttrVal("Less_month"));
	}	
	/**
	 * 已折旧月份
	 * @param Less_month
	 */
	public void setLess_month(Integer Less_month) {
		setAttrVal("Less_month", Less_month);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getProducing_area() {
		return ((String) getAttrVal("Producing_area"));
	}	
	/**
	 * 产地
	 * @param Producing_area
	 */
	public void setProducing_area(String Producing_area) {
		setAttrVal("Producing_area", Producing_area);
	}
	/**
	 * 品牌名称
	 * @return String
	 */
	public String getBrand_name() {
		return ((String) getAttrVal("Brand_name"));
	}	
	/**
	 * 品牌名称
	 * @param Brand_name
	 */
	public void setBrand_name(String Brand_name) {
		setAttrVal("Brand_name", Brand_name);
	}
	/**
	 * 是否固定资产
	 * @return FBoolean
	 */
	public FBoolean getFg_fixed() {
		return ((FBoolean) getAttrVal("Fg_fixed"));
	}	
	/**
	 * 是否固定资产
	 * @param Fg_fixed
	 */
	public void setFg_fixed(FBoolean Fg_fixed) {
		setAttrVal("Fg_fixed", Fg_fixed);
	}
	/**
	 * 使用年限
	 * @return Integer
	 */
	public Integer getUsefullife() {
		return ((Integer) getAttrVal("Usefullife"));
	}	
	/**
	 * 使用年限
	 * @param Usefullife
	 */
	public void setUsefullife(Integer Usefullife) {
		setAttrVal("Usefullife", Usefullife);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 首次入库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_fin() {
		return ((FDateTime) getAttrVal("Dt_fin"));
	}	
	/**
	 * 首次入库时间
	 * @param Dt_fin
	 */
	public void setDt_fin(FDateTime Dt_fin) {
		setAttrVal("Dt_fin", Dt_fin);
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
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 最后修改源
	 * @return String
	 */
	public String getModifsource() {
		return ((String) getAttrVal("Modifsource"));
	}	
	/**
	 * 最后修改源
	 * @param Modifsource
	 */
	public void setModifsource(String Modifsource) {
		setAttrVal("Modifsource", Modifsource);
	}
	/**
	 * 最后修改源ID
	 * @return String
	 */
	public String getModifid() {
		return ((String) getAttrVal("Modifid"));
	}	
	/**
	 * 最后修改源ID
	 * @param Modifid
	 */
	public void setModifid(String Modifid) {
		setAttrVal("Modifid", Modifid);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单号
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 出库单细目
	 * @return String
	 */
	public String getId_out_itm() {
		return ((String) getAttrVal("Id_out_itm"));
	}	
	/**
	 * 出库单细目
	 * @param Id_out_itm
	 */
	public void setId_out_itm(String Id_out_itm) {
		setAttrVal("Id_out_itm", Id_out_itm);
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
		return "Id_embl";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_bl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsBlDODesc.class);
	}
	
}