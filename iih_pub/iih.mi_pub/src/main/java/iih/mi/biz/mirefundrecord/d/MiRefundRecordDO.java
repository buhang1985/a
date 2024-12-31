package iih.mi.biz.mirefundrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.mirefundrecord.d.desc.MiRefundRecordDODesc;
import java.math.BigDecimal;

/**
 * 医保退费记录 DO数据 
 * 
 */
public class MiRefundRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//退费id
	public static final String ID_REFUNDRECORD= "Id_refundrecord";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//订单结算关系id
	public static final String ID_ORDERSTRECORD= "Id_orderstrecord";
	//退费项目记账id
	public static final String ID_CGITM= "Id_cgitm";
	//数量
	public static final String QUAN= "Quan";
	//退费数量
	public static final String QUAN_RET= "Quan_ret";
	//重收记账id
	public static final String ID_CGITMNEW= "Id_cgitmnew";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 退费id
	 * @return String
	 */
	public String getId_refundrecord() {
		return ((String) getAttrVal("Id_refundrecord"));
	}	
	/**
	 * 退费id
	 * @param Id_refundrecord
	 */
	public void setId_refundrecord(String Id_refundrecord) {
		setAttrVal("Id_refundrecord", Id_refundrecord);
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
	 * 订单结算关系id
	 * @return String
	 */
	public String getId_orderstrecord() {
		return ((String) getAttrVal("Id_orderstrecord"));
	}	
	/**
	 * 订单结算关系id
	 * @param Id_orderstrecord
	 */
	public void setId_orderstrecord(String Id_orderstrecord) {
		setAttrVal("Id_orderstrecord", Id_orderstrecord);
	}
	/**
	 * 退费项目记账id
	 * @return String
	 */
	public String getId_cgitm() {
		return ((String) getAttrVal("Id_cgitm"));
	}	
	/**
	 * 退费项目记账id
	 * @param Id_cgitm
	 */
	public void setId_cgitm(String Id_cgitm) {
		setAttrVal("Id_cgitm", Id_cgitm);
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
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}	
	/**
	 * 退费数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
	}
	/**
	 * 重收记账id
	 * @return String
	 */
	public String getId_cgitmnew() {
		return ((String) getAttrVal("Id_cgitmnew"));
	}	
	/**
	 * 重收记账id
	 * @param Id_cgitmnew
	 */
	public void setId_cgitmnew(String Id_cgitmnew) {
		setAttrVal("Id_cgitmnew", Id_cgitmnew);
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
		return "Id_refundrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_refund_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiRefundRecordDODesc.class);
	}
	
}