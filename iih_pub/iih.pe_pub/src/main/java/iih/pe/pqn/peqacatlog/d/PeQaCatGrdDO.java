package iih.pe.pqn.peqacatlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqacatlog.d.desc.PeQaCatGrdDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷评分等级 DO数据 
 * 
 */
public class PeQaCatGrdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检问卷评分等级主键标识
	public static final String ID_PEQACATGRD= "Id_peqacatgrd";
	//体检问卷问题分组ID
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//编码
	public static final String CODE= "Code";
	//评价
	public static final String NAME= "Name";
	//类别标签
	public static final String CLASSLABEL= "Classlabel";
	//起始分值
	public static final String SCORE_BEGIN= "Score_begin";
	//结束分值
	public static final String SCORE_END= "Score_end";
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
	 * 体检问卷评分等级主键标识
	 * @return String
	 */
	public String getId_peqacatgrd() {
		return ((String) getAttrVal("Id_peqacatgrd"));
	}	
	/**
	 * 体检问卷评分等级主键标识
	 * @param Id_peqacatgrd
	 */
	public void setId_peqacatgrd(String Id_peqacatgrd) {
		setAttrVal("Id_peqacatgrd", Id_peqacatgrd);
	}
	/**
	 * 体检问卷问题分组ID
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 体检问卷问题分组ID
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
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
	 * 评价
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 评价
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 类别标签
	 * @return String
	 */
	public String getClasslabel() {
		return ((String) getAttrVal("Classlabel"));
	}	
	/**
	 * 类别标签
	 * @param Classlabel
	 */
	public void setClasslabel(String Classlabel) {
		setAttrVal("Classlabel", Classlabel);
	}
	/**
	 * 起始分值
	 * @return Integer
	 */
	public Integer getScore_begin() {
		return ((Integer) getAttrVal("Score_begin"));
	}	
	/**
	 * 起始分值
	 * @param Score_begin
	 */
	public void setScore_begin(Integer Score_begin) {
		setAttrVal("Score_begin", Score_begin);
	}
	/**
	 * 结束分值
	 * @return Integer
	 */
	public Integer getScore_end() {
		return ((Integer) getAttrVal("Score_end"));
	}	
	/**
	 * 结束分值
	 * @param Score_end
	 */
	public void setScore_end(Integer Score_end) {
		setAttrVal("Score_end", Score_end);
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
		return "Id_peqacatgrd";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqacatgrd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQaCatGrdDODesc.class);
	}
	
}