package iih.nm.nhr.nmnurtrn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurtrn.d.desc.NmNurTrnDODesc;
import java.math.BigDecimal;

/**
 * 人员培训 DO数据 
 * 
 */
public class NmNurTrnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_TRN= "Id_nur_trn";
	public static final String ID_NUR= "Id_nur";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String CONTENT_TRAIN= "Content_train";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_TRAINER= "Name_trainer";
	public static final String ADDR_TRAIN= "Addr_train";
	public static final String ID_TRAINTP= "Id_traintp";
	public static final String SD_TRAINTP= "Sd_traintp";
	public static final String ID_TRAIN_WAY= "Id_train_way";
	public static final String SD_TRAIN_WAY= "Sd_train_way";
	public static final String ID_TRAIN_CHNNEL= "Id_train_chnnel";
	public static final String SD_TRAIN_CHNNEL= "Sd_train_chnnel";
	public static final String ID_TITLE= "Id_title";
	public static final String SD_TITLE= "Sd_title";
	public static final String ID_DUTY= "Id_duty";
	public static final String SD_DUTY= "Sd_duty";
	public static final String ID_TRAIN_RESULT= "Id_train_result";
	public static final String SD_TRAIN_RESULT= "Sd_train_result";
	public static final String SCORCE= "Scorce";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_TRAINTP= "Name_traintp";
	public static final String NAME_WAY= "Name_way";
	public static final String NAME_CHNNEL= "Name_chnnel";
	public static final String NAME_TITLE= "Name_title";
	public static final String NAME_DUTY= "Name_duty";
	public static final String NAME_RESULT= "Name_result";
	public static final String NAME_REG= "Name_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_trn() {
		return ((String) getAttrVal("Id_nur_trn"));
	}	
	public void setId_nur_trn(String Id_nur_trn) {
		setAttrVal("Id_nur_trn", Id_nur_trn);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getContent_train() {
		return ((String) getAttrVal("Content_train"));
	}	
	public void setContent_train(String Content_train) {
		setAttrVal("Content_train", Content_train);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_trainer() {
		return ((String) getAttrVal("Name_trainer"));
	}	
	public void setName_trainer(String Name_trainer) {
		setAttrVal("Name_trainer", Name_trainer);
	}
	public String getAddr_train() {
		return ((String) getAttrVal("Addr_train"));
	}	
	public void setAddr_train(String Addr_train) {
		setAttrVal("Addr_train", Addr_train);
	}
	public String getId_traintp() {
		return ((String) getAttrVal("Id_traintp"));
	}	
	public void setId_traintp(String Id_traintp) {
		setAttrVal("Id_traintp", Id_traintp);
	}
	public String getSd_traintp() {
		return ((String) getAttrVal("Sd_traintp"));
	}	
	public void setSd_traintp(String Sd_traintp) {
		setAttrVal("Sd_traintp", Sd_traintp);
	}
	public String getId_train_way() {
		return ((String) getAttrVal("Id_train_way"));
	}	
	public void setId_train_way(String Id_train_way) {
		setAttrVal("Id_train_way", Id_train_way);
	}
	public String getSd_train_way() {
		return ((String) getAttrVal("Sd_train_way"));
	}	
	public void setSd_train_way(String Sd_train_way) {
		setAttrVal("Sd_train_way", Sd_train_way);
	}
	public String getId_train_chnnel() {
		return ((String) getAttrVal("Id_train_chnnel"));
	}	
	public void setId_train_chnnel(String Id_train_chnnel) {
		setAttrVal("Id_train_chnnel", Id_train_chnnel);
	}
	public String getSd_train_chnnel() {
		return ((String) getAttrVal("Sd_train_chnnel"));
	}	
	public void setSd_train_chnnel(String Sd_train_chnnel) {
		setAttrVal("Sd_train_chnnel", Sd_train_chnnel);
	}
	public String getId_title() {
		return ((String) getAttrVal("Id_title"));
	}	
	public void setId_title(String Id_title) {
		setAttrVal("Id_title", Id_title);
	}
	public String getSd_title() {
		return ((String) getAttrVal("Sd_title"));
	}	
	public void setSd_title(String Sd_title) {
		setAttrVal("Sd_title", Sd_title);
	}
	public String getId_duty() {
		return ((String) getAttrVal("Id_duty"));
	}	
	public void setId_duty(String Id_duty) {
		setAttrVal("Id_duty", Id_duty);
	}
	public String getSd_duty() {
		return ((String) getAttrVal("Sd_duty"));
	}	
	public void setSd_duty(String Sd_duty) {
		setAttrVal("Sd_duty", Sd_duty);
	}
	public String getId_train_result() {
		return ((String) getAttrVal("Id_train_result"));
	}	
	public void setId_train_result(String Id_train_result) {
		setAttrVal("Id_train_result", Id_train_result);
	}
	public String getSd_train_result() {
		return ((String) getAttrVal("Sd_train_result"));
	}	
	public void setSd_train_result(String Sd_train_result) {
		setAttrVal("Sd_train_result", Sd_train_result);
	}
	public Integer getScorce() {
		return ((Integer) getAttrVal("Scorce"));
	}	
	public void setScorce(Integer Scorce) {
		setAttrVal("Scorce", Scorce);
	}
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_traintp() {
		return ((String) getAttrVal("Name_traintp"));
	}	
	public void setName_traintp(String Name_traintp) {
		setAttrVal("Name_traintp", Name_traintp);
	}
	public String getName_way() {
		return ((String) getAttrVal("Name_way"));
	}	
	public void setName_way(String Name_way) {
		setAttrVal("Name_way", Name_way);
	}
	public String getName_chnnel() {
		return ((String) getAttrVal("Name_chnnel"));
	}	
	public void setName_chnnel(String Name_chnnel) {
		setAttrVal("Name_chnnel", Name_chnnel);
	}
	public String getName_title() {
		return ((String) getAttrVal("Name_title"));
	}	
	public void setName_title(String Name_title) {
		setAttrVal("Name_title", Name_title);
	}
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
	}
	public String getName_result() {
		return ((String) getAttrVal("Name_result"));
	}	
	public void setName_result(String Name_result) {
		setAttrVal("Name_result", Name_result);
	}
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
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
		return "Id_nur_trn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_TRN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurTrnDODesc.class);
	}
	
}