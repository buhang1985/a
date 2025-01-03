package iih.pe.pqn.peqacontentdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqacontentdef.d.desc.PeQakeyDefDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷问题选项库 DO数据 
 * 
 */
public class PeQakeyDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检问卷选项主键标识
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//体检问卷问题库ID
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//英文名称
	public static final String ENAME= "Ename";
	//分值
	public static final String SCORE= "Score";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//排序
	public static final String SORTNO= "Sortno";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//输入类型
	public static final String INPUTTP= "Inputtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检问卷选项主键标识
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 体检问卷选项主键标识
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	/**
	 * 体检问卷问题库ID
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 体检问卷问题库ID
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
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
	 * 英文名称
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文名称
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 分值
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	/**
	 * 分值
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
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
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 输入类型
	 * @return Integer
	 */
	public Integer getInputtp() {
		return ((Integer) getAttrVal("Inputtp"));
	}	
	/**
	 * 输入类型
	 * @param Inputtp
	 */
	public void setInputtp(Integer Inputtp) {
		setAttrVal("Inputtp", Inputtp);
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
		return "Id_peqakeydef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqakeydef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQakeyDefDODesc.class);
	}
	
}