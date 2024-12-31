package iih.bd.pp.bdcpnca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdcpnca.d.desc.BdCpncaDODesc;
import java.math.BigDecimal;

/**
 * 优惠券分类 DO数据 
 * 
 */
public class BdCpncaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//优惠券分类主键
	public static final String ID_CPNCA= "Id_cpnca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//优惠券分类的编码
	public static final String CODE= "Code";
	//优惠券分类的名称
	public static final String NAME= "Name";
	//优惠券类型
	public static final String EU_CPNTP= "Eu_cpntp";
	//单码标志
	public static final String FG_EACH= "Fg_each";
	//(单码优惠券)编码
	public static final String CODERULE_CPN= "Coderule_cpn";
	//记名标志
	public static final String FG_OWN= "Fg_own";
	//代金金额
	public static final String AMT= "Amt";
	//折扣比例
	public static final String RATE= "Rate";
	//特价金额
	public static final String PAY_WILL= "Pay_will";
	//发布渠道
	public static final String ID_CPNCHL= "Id_cpnchl";
	//发布渠道编码
	public static final String CODE_CHL= "Code_chl";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记符
	public static final String INSTR= "Instr";
	//启用状态
	public static final String ACTIVE_STATE= "Active_state";
	//优惠券
	public static final String BDCPNARR= "Bdcpnarr";
	//叠加使用标识
	public static final String FG_MTLUSE= "Fg_mtluse";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 优惠券分类主键
	 * @return String
	 */
	public String getId_cpnca() {
		return ((String) getAttrVal("Id_cpnca"));
	}	
	/**
	 * 优惠券分类主键
	 * @param Id_cpnca
	 */
	public void setId_cpnca(String Id_cpnca) {
		setAttrVal("Id_cpnca", Id_cpnca);
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
	 * 优惠券分类的编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 优惠券分类的编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 优惠券分类的名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 优惠券分类的名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 优惠券类型
	 * @return Integer
	 */
	public Integer getEu_cpntp() {
		return ((Integer) getAttrVal("Eu_cpntp"));
	}	
	/**
	 * 优惠券类型
	 * @param Eu_cpntp
	 */
	public void setEu_cpntp(Integer Eu_cpntp) {
		setAttrVal("Eu_cpntp", Eu_cpntp);
	}
	/**
	 * 单码标志
	 * @return FBoolean
	 */
	public FBoolean getFg_each() {
		return ((FBoolean) getAttrVal("Fg_each"));
	}	
	/**
	 * 单码标志
	 * @param Fg_each
	 */
	public void setFg_each(FBoolean Fg_each) {
		setAttrVal("Fg_each", Fg_each);
	}
	/**
	 * (单码优惠券)编码
	 * @return String
	 */
	public String getCoderule_cpn() {
		return ((String) getAttrVal("Coderule_cpn"));
	}	
	/**
	 * (单码优惠券)编码
	 * @param Coderule_cpn
	 */
	public void setCoderule_cpn(String Coderule_cpn) {
		setAttrVal("Coderule_cpn", Coderule_cpn);
	}
	/**
	 * 记名标志
	 * @return FBoolean
	 */
	public FBoolean getFg_own() {
		return ((FBoolean) getAttrVal("Fg_own"));
	}	
	/**
	 * 记名标志
	 * @param Fg_own
	 */
	public void setFg_own(FBoolean Fg_own) {
		setAttrVal("Fg_own", Fg_own);
	}
	/**
	 * 代金金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 代金金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 折扣比例
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	/**
	 * 折扣比例
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 特价金额
	 * @return FDouble
	 */
	public FDouble getPay_will() {
		return ((FDouble) getAttrVal("Pay_will"));
	}	
	/**
	 * 特价金额
	 * @param Pay_will
	 */
	public void setPay_will(FDouble Pay_will) {
		setAttrVal("Pay_will", Pay_will);
	}
	/**
	 * 发布渠道
	 * @return String
	 */
	public String getId_cpnchl() {
		return ((String) getAttrVal("Id_cpnchl"));
	}	
	/**
	 * 发布渠道
	 * @param Id_cpnchl
	 */
	public void setId_cpnchl(String Id_cpnchl) {
		setAttrVal("Id_cpnchl", Id_cpnchl);
	}
	/**
	 * 发布渠道编码
	 * @return String
	 */
	public String getCode_chl() {
		return ((String) getAttrVal("Code_chl"));
	}	
	/**
	 * 发布渠道编码
	 * @param Code_chl
	 */
	public void setCode_chl(String Code_chl) {
		setAttrVal("Code_chl", Code_chl);
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
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记符
	 * @return String
	 */
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	/**
	 * 助记符
	 * @param Instr
	 */
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
	}
	/**
	 * 启用状态
	 * @return Integer
	 */
	public Integer getActive_state() {
		return ((Integer) getAttrVal("Active_state"));
	}	
	/**
	 * 启用状态
	 * @param Active_state
	 */
	public void setActive_state(Integer Active_state) {
		setAttrVal("Active_state", Active_state);
	}
	/**
	 * 优惠券
	 * @return String
	 */
	public String getBdcpnarr() {
		return ((String) getAttrVal("Bdcpnarr"));
	}	
	/**
	 * 优惠券
	 * @param Bdcpnarr
	 */
	public void setBdcpnarr(String Bdcpnarr) {
		setAttrVal("Bdcpnarr", Bdcpnarr);
	}
	/**
	 * 叠加使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mtluse() {
		return ((FBoolean) getAttrVal("Fg_mtluse"));
	}	
	/**
	 * 叠加使用标识
	 * @param Fg_mtluse
	 */
	public void setFg_mtluse(FBoolean Fg_mtluse) {
		setAttrVal("Fg_mtluse", Fg_mtluse);
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
		return "Id_cpnca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_cpnca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdCpncaDODesc.class);
	}
	
}