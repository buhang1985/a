package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmSignDODesc;
import java.math.BigDecimal;

/**
 * 体检体征定义 DO数据 
 * 
 */
public class PeSrvitmSignDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检体征定义主键标识
	public static final String ID_PESRVITMSIGN= "Id_pesrvitmsign";
	//体检体征定义父ID
	public static final String ID_PESRVITMSIGN_PAR= "Id_pesrvitmsign_par";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体征编码
	public static final String CODE= "Code";
	//体征父编码
	public static final String CODE_PARENT= "Code_parent";
	//体征名称
	public static final String NAME= "Name";
	//控件类型
	public static final String COMPTP= "Comptp";
	//层级
	public static final String NODELEVEL= "Nodelevel";
	//序号
	public static final String SORTNO= "Sortno";
	//计量单位
	public static final String UNIT= "Unit";
	//叶子标识
	public static final String FG_LEAF= "Fg_leaf";
	//折叠标识
	public static final String FG_FOLD= "Fg_fold";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//是否复制
	public static final String FG_COPY= "Fg_copy";
	//报告-打印标识
	public static final String FG_RP_PRINT= "Fg_rp_print";
	//打印名称
	public static final String NAME_RPT= "Name_rpt";
	//体征编码
	public static final String CODE_PAR= "Code_par";
	//体征名称
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检体征定义主键标识
	 * @return String
	 */
	public String getId_pesrvitmsign() {
		return ((String) getAttrVal("Id_pesrvitmsign"));
	}	
	/**
	 * 体检体征定义主键标识
	 * @param Id_pesrvitmsign
	 */
	public void setId_pesrvitmsign(String Id_pesrvitmsign) {
		setAttrVal("Id_pesrvitmsign", Id_pesrvitmsign);
	}
	/**
	 * 体检体征定义父ID
	 * @return String
	 */
	public String getId_pesrvitmsign_par() {
		return ((String) getAttrVal("Id_pesrvitmsign_par"));
	}	
	/**
	 * 体检体征定义父ID
	 * @param Id_pesrvitmsign_par
	 */
	public void setId_pesrvitmsign_par(String Id_pesrvitmsign_par) {
		setAttrVal("Id_pesrvitmsign_par", Id_pesrvitmsign_par);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 体征编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 体征编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 体征父编码
	 * @return String
	 */
	public String getCode_parent() {
		return ((String) getAttrVal("Code_parent"));
	}	
	/**
	 * 体征父编码
	 * @param Code_parent
	 */
	public void setCode_parent(String Code_parent) {
		setAttrVal("Code_parent", Code_parent);
	}
	/**
	 * 体征名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 体征名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 控件类型
	 * @return Integer
	 */
	public Integer getComptp() {
		return ((Integer) getAttrVal("Comptp"));
	}	
	/**
	 * 控件类型
	 * @param Comptp
	 */
	public void setComptp(Integer Comptp) {
		setAttrVal("Comptp", Comptp);
	}
	/**
	 * 层级
	 * @return Integer
	 */
	public Integer getNodelevel() {
		return ((Integer) getAttrVal("Nodelevel"));
	}	
	/**
	 * 层级
	 * @param Nodelevel
	 */
	public void setNodelevel(Integer Nodelevel) {
		setAttrVal("Nodelevel", Nodelevel);
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
	 * 计量单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 计量单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 叶子标识
	 * @return FBoolean
	 */
	public FBoolean getFg_leaf() {
		return ((FBoolean) getAttrVal("Fg_leaf"));
	}	
	/**
	 * 叶子标识
	 * @param Fg_leaf
	 */
	public void setFg_leaf(FBoolean Fg_leaf) {
		setAttrVal("Fg_leaf", Fg_leaf);
	}
	/**
	 * 折叠标识
	 * @return FBoolean
	 */
	public FBoolean getFg_fold() {
		return ((FBoolean) getAttrVal("Fg_fold"));
	}	
	/**
	 * 折叠标识
	 * @param Fg_fold
	 */
	public void setFg_fold(FBoolean Fg_fold) {
		setAttrVal("Fg_fold", Fg_fold);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 是否复制
	 * @return FBoolean
	 */
	public FBoolean getFg_copy() {
		return ((FBoolean) getAttrVal("Fg_copy"));
	}	
	/**
	 * 是否复制
	 * @param Fg_copy
	 */
	public void setFg_copy(FBoolean Fg_copy) {
		setAttrVal("Fg_copy", Fg_copy);
	}
	/**
	 * 报告-打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rp_print() {
		return ((FBoolean) getAttrVal("Fg_rp_print"));
	}	
	/**
	 * 报告-打印标识
	 * @param Fg_rp_print
	 */
	public void setFg_rp_print(FBoolean Fg_rp_print) {
		setAttrVal("Fg_rp_print", Fg_rp_print);
	}
	/**
	 * 打印名称
	 * @return String
	 */
	public String getName_rpt() {
		return ((String) getAttrVal("Name_rpt"));
	}	
	/**
	 * 打印名称
	 * @param Name_rpt
	 */
	public void setName_rpt(String Name_rpt) {
		setAttrVal("Name_rpt", Name_rpt);
	}
	/**
	 * 体征编码
	 * @return String
	 */
	public String getCode_par() {
		return ((String) getAttrVal("Code_par"));
	}	
	/**
	 * 体征编码
	 * @param Code_par
	 */
	public void setCode_par(String Code_par) {
		setAttrVal("Code_par", Code_par);
	}
	/**
	 * 体征名称
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 体征名称
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_pesrvitmsign";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitmsign";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmSignDODesc.class);
	}
	
}