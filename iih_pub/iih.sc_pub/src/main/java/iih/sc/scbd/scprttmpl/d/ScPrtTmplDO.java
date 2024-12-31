package iih.sc.scbd.scprttmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scprttmpl.d.desc.ScPrtTmplDODesc;
import java.math.BigDecimal;

/**
 * 预约打印模板 DO数据
 *
 */
public class ScPrtTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预约打印模板id
	public static final String ID_PRTTMPL= "Id_prttmpl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//模板路径
	public static final String PATH= "Path";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String INSTR= "Instr";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//预约打印类型
	public static final String SD_RPTTP= "Sd_rpttp";
	//预约打印类型id
	public static final String ID_RPTTP= "Id_rpttp";
	//预约须知
	public static final String DESC_TEXT= "Desc_text";
	//预约打印类型名称
	public static final String NAME_RPTTP= "Name_rpttp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";

	/**
	 * 预约打印模板id
	 * @return String
	 */
	public String getId_prttmpl() {
		return ((String) getAttrVal("Id_prttmpl"));
	}
	/**
	 * 预约打印模板id
	 * @param Id_prttmpl
	 */
	public void setId_prttmpl(String Id_prttmpl) {
		setAttrVal("Id_prttmpl", Id_prttmpl);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 模板路径
	 * @return String
	 */
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}
	/**
	 * 模板路径
	 * @param Path
	 */
	public void setPath(String Path) {
		setAttrVal("Path", Path);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
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
	 * 助记码
	 * @return String
	 */
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}
	/**
	 * 助记码
	 * @param Instr
	 */
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
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
	 * 预约打印类型
	 * @return String
	 */
	public String getSd_rpttp() {
		return ((String) getAttrVal("Sd_rpttp"));
	}
	/**
	 * 预约打印类型
	 * @param Sd_rpttp
	 */
	public void setSd_rpttp(String Sd_rpttp) {
		setAttrVal("Sd_rpttp", Sd_rpttp);
	}
	/**
	 * 预约打印类型id
	 * @return String
	 */
	public String getId_rpttp() {
		return ((String) getAttrVal("Id_rpttp"));
	}
	/**
	 * 预约打印类型id
	 * @param Id_rpttp
	 */
	public void setId_rpttp(String Id_rpttp) {
		setAttrVal("Id_rpttp", Id_rpttp);
	}
	/**
	 * 预约须知
	 * @return String
	 */
	public String getDesc_text() {
		return ((String) getAttrVal("Desc_text"));
	}
	/**
	 * 预约须知
	 * @param Desc_text
	 */
	public void setDesc_text(String Desc_text) {
		setAttrVal("Desc_text", Desc_text);
	}
	/**
	 * 预约打印类型名称
	 * @return String
	 */
	public String getName_rpttp() {
		return ((String) getAttrVal("Name_rpttp"));
	}
	/**
	 * 预约打印类型名称
	 * @param Name_rpttp
	 */
	public void setName_rpttp(String Name_rpttp) {
		setAttrVal("Name_rpttp", Name_rpttp);
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
		return "Id_prttmpl";
	}

	@Override
	public String getTableName() {
		return "SC_PRT_TMPL";
	}

	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPrtTmplDODesc.class);
	}

}
