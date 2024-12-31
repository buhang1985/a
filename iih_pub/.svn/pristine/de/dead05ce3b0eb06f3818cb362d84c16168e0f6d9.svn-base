package iih.nm.net.examtrapl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examtrapl.d.desc.ExamtraplfileDoDesc;
import java.math.BigDecimal;

/**
 * 培训计划课程附件 DO数据 
 * 
 */
public class ExamtraplfileDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EXAM_TRAPL_FILE= "Id_exam_trapl_file";
	public static final String NAME= "Name";
	public static final String ID_UP_PSN= "Id_up_psn";
	public static final String DT_UP= "Dt_up";
	public static final String PATH_FILE= "Path_file";
	public static final String ID_EXAM_TRAPL= "Id_exam_trapl";
	public static final String NAME_UP_PSN= "Name_up_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_exam_trapl_file() {
		return ((String) getAttrVal("Id_exam_trapl_file"));
	}	
	public void setId_exam_trapl_file(String Id_exam_trapl_file) {
		setAttrVal("Id_exam_trapl_file", Id_exam_trapl_file);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_up_psn() {
		return ((String) getAttrVal("Id_up_psn"));
	}	
	public void setId_up_psn(String Id_up_psn) {
		setAttrVal("Id_up_psn", Id_up_psn);
	}
	public FDateTime getDt_up() {
		return ((FDateTime) getAttrVal("Dt_up"));
	}	
	public void setDt_up(FDateTime Dt_up) {
		setAttrVal("Dt_up", Dt_up);
	}
	public String getPath_file() {
		return ((String) getAttrVal("Path_file"));
	}	
	public void setPath_file(String Path_file) {
		setAttrVal("Path_file", Path_file);
	}
	public String getId_exam_trapl() {
		return ((String) getAttrVal("Id_exam_trapl"));
	}	
	public void setId_exam_trapl(String Id_exam_trapl) {
		setAttrVal("Id_exam_trapl", Id_exam_trapl);
	}
	public String getName_up_psn() {
		return ((String) getAttrVal("Name_up_psn"));
	}	
	public void setName_up_psn(String Name_up_psn) {
		setAttrVal("Name_up_psn", Name_up_psn);
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
		return "Id_exam_trapl_file";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_exam_trapl_file";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamtraplfileDoDesc.class);
	}
	
}