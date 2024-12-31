package iih.sfda.aer.sfdaaerevnpipe.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevnpipe.d.desc.SfdaAerEvNpipeDODesc;
import java.math.BigDecimal;

/**
 * 导管事件 DO数据 
 * 
 */
public class SfdaAerEvNpipeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护理事件主键
	public static final String ID_AER_EV_NPIPE= "Id_aer_ev_npipe";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//导管事件错误id
	public static final String ID_PIPE_ERRTP= "Id_pipe_errtp";
	//导管事件错误类型
	public static final String SD_PIPE_ERRTP= "Sd_pipe_errtp";
	//其他导管事件错误类型
	public static final String PIPE_ERRTP_OTH= "Pipe_errtp_oth";
	//导管id
	public static final String ID_PIPE_TP= "Id_pipe_tp";
	//导管种类
	public static final String SD_PIPE_TP= "Sd_pipe_tp";
	//其他导管种类
	public static final String PIPE_TP_OTH= "Pipe_tp_oth";
	//事件发生于何项活动id
	public static final String ID_OCUR_ATIVY= "Id_ocur_ativy";
	//事件发生于何项活动过程
	public static final String SD_OCUR_ATIVY= "Sd_ocur_ativy";
	//事件发生于其他活动
	public static final String OCUR_ATIVY_OTH= "Ocur_ativy_oth";
	//固定导管使用的材料id
	public static final String ID_PIPE_MTR= "Id_pipe_mtr";
	//固定导管使用的材料
	public static final String SD_PIPE_MTR= "Sd_pipe_mtr";
	//固定导管使用的其他材料
	public static final String PIPE_MTR_OTH= "Pipe_mtr_oth";
	//是否重新插/置管
	public static final String EU_REPT_INST= "Eu_rept_inst";
	//意识障碍的程度id
	public static final String ID_UNAWAR= "Id_unawar";
	//意识障碍的程度
	public static final String SD_UNAWAR= "Sd_unawar";
	//最近一星期病人自拔导管次数（包含所有导管类型）
	public static final String COUNT_PULL_PIPE= "Count_pull_pipe";
	//平日有无陪伴者
	public static final String EU_ANY_CPY= "Eu_any_cpy";
	//事件发生陪伴者是否在场
	public static final String EU_CPY_HERE= "Eu_cpy_here";
	//事件发生时在场陪伴者
	public static final String CPY_HERE_OTH= "Cpy_here_oth";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//扩展字段4
	public static final String EXT4= "Ext4";
	//扩展字段5
	public static final String EXT5= "Ext5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//导管事件错误类型
	public static final String NAME_PIPE_ERRTP= "Name_pipe_errtp";
	//导管种类
	public static final String NAME_PIPE_TP= "Name_pipe_tp";
	//事件发生于何项活动
	public static final String NAME_OCUR_ATIVY= "Name_ocur_ativy";
	//固定导管使用的材料
	public static final String NAME_PIPE_MTR= "Name_pipe_mtr";
	//意识障碍的程度
	public static final String NAME_UNAWAR= "Name_unawar";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护理事件主键
	 * @return String
	 */
	public String getId_aer_ev_npipe() {
		return ((String) getAttrVal("Id_aer_ev_npipe"));
	}	
	/**
	 * 护理事件主键
	 * @param Id_aer_ev_npipe
	 */
	public void setId_aer_ev_npipe(String Id_aer_ev_npipe) {
		setAttrVal("Id_aer_ev_npipe", Id_aer_ev_npipe);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 导管事件错误id
	 * @return String
	 */
	public String getId_pipe_errtp() {
		return ((String) getAttrVal("Id_pipe_errtp"));
	}	
	/**
	 * 导管事件错误id
	 * @param Id_pipe_errtp
	 */
	public void setId_pipe_errtp(String Id_pipe_errtp) {
		setAttrVal("Id_pipe_errtp", Id_pipe_errtp);
	}
	/**
	 * 导管事件错误类型
	 * @return String
	 */
	public String getSd_pipe_errtp() {
		return ((String) getAttrVal("Sd_pipe_errtp"));
	}	
	/**
	 * 导管事件错误类型
	 * @param Sd_pipe_errtp
	 */
	public void setSd_pipe_errtp(String Sd_pipe_errtp) {
		setAttrVal("Sd_pipe_errtp", Sd_pipe_errtp);
	}
	/**
	 * 其他导管事件错误类型
	 * @return String
	 */
	public String getPipe_errtp_oth() {
		return ((String) getAttrVal("Pipe_errtp_oth"));
	}	
	/**
	 * 其他导管事件错误类型
	 * @param Pipe_errtp_oth
	 */
	public void setPipe_errtp_oth(String Pipe_errtp_oth) {
		setAttrVal("Pipe_errtp_oth", Pipe_errtp_oth);
	}
	/**
	 * 导管id
	 * @return String
	 */
	public String getId_pipe_tp() {
		return ((String) getAttrVal("Id_pipe_tp"));
	}	
	/**
	 * 导管id
	 * @param Id_pipe_tp
	 */
	public void setId_pipe_tp(String Id_pipe_tp) {
		setAttrVal("Id_pipe_tp", Id_pipe_tp);
	}
	/**
	 * 导管种类
	 * @return String
	 */
	public String getSd_pipe_tp() {
		return ((String) getAttrVal("Sd_pipe_tp"));
	}	
	/**
	 * 导管种类
	 * @param Sd_pipe_tp
	 */
	public void setSd_pipe_tp(String Sd_pipe_tp) {
		setAttrVal("Sd_pipe_tp", Sd_pipe_tp);
	}
	/**
	 * 其他导管种类
	 * @return String
	 */
	public String getPipe_tp_oth() {
		return ((String) getAttrVal("Pipe_tp_oth"));
	}	
	/**
	 * 其他导管种类
	 * @param Pipe_tp_oth
	 */
	public void setPipe_tp_oth(String Pipe_tp_oth) {
		setAttrVal("Pipe_tp_oth", Pipe_tp_oth);
	}
	/**
	 * 事件发生于何项活动id
	 * @return String
	 */
	public String getId_ocur_ativy() {
		return ((String) getAttrVal("Id_ocur_ativy"));
	}	
	/**
	 * 事件发生于何项活动id
	 * @param Id_ocur_ativy
	 */
	public void setId_ocur_ativy(String Id_ocur_ativy) {
		setAttrVal("Id_ocur_ativy", Id_ocur_ativy);
	}
	/**
	 * 事件发生于何项活动过程
	 * @return String
	 */
	public String getSd_ocur_ativy() {
		return ((String) getAttrVal("Sd_ocur_ativy"));
	}	
	/**
	 * 事件发生于何项活动过程
	 * @param Sd_ocur_ativy
	 */
	public void setSd_ocur_ativy(String Sd_ocur_ativy) {
		setAttrVal("Sd_ocur_ativy", Sd_ocur_ativy);
	}
	/**
	 * 事件发生于其他活动
	 * @return String
	 */
	public String getOcur_ativy_oth() {
		return ((String) getAttrVal("Ocur_ativy_oth"));
	}	
	/**
	 * 事件发生于其他活动
	 * @param Ocur_ativy_oth
	 */
	public void setOcur_ativy_oth(String Ocur_ativy_oth) {
		setAttrVal("Ocur_ativy_oth", Ocur_ativy_oth);
	}
	/**
	 * 固定导管使用的材料id
	 * @return String
	 */
	public String getId_pipe_mtr() {
		return ((String) getAttrVal("Id_pipe_mtr"));
	}	
	/**
	 * 固定导管使用的材料id
	 * @param Id_pipe_mtr
	 */
	public void setId_pipe_mtr(String Id_pipe_mtr) {
		setAttrVal("Id_pipe_mtr", Id_pipe_mtr);
	}
	/**
	 * 固定导管使用的材料
	 * @return String
	 */
	public String getSd_pipe_mtr() {
		return ((String) getAttrVal("Sd_pipe_mtr"));
	}	
	/**
	 * 固定导管使用的材料
	 * @param Sd_pipe_mtr
	 */
	public void setSd_pipe_mtr(String Sd_pipe_mtr) {
		setAttrVal("Sd_pipe_mtr", Sd_pipe_mtr);
	}
	/**
	 * 固定导管使用的其他材料
	 * @return String
	 */
	public String getPipe_mtr_oth() {
		return ((String) getAttrVal("Pipe_mtr_oth"));
	}	
	/**
	 * 固定导管使用的其他材料
	 * @param Pipe_mtr_oth
	 */
	public void setPipe_mtr_oth(String Pipe_mtr_oth) {
		setAttrVal("Pipe_mtr_oth", Pipe_mtr_oth);
	}
	/**
	 * 是否重新插/置管
	 * @return Integer
	 */
	public Integer getEu_rept_inst() {
		return ((Integer) getAttrVal("Eu_rept_inst"));
	}	
	/**
	 * 是否重新插/置管
	 * @param Eu_rept_inst
	 */
	public void setEu_rept_inst(Integer Eu_rept_inst) {
		setAttrVal("Eu_rept_inst", Eu_rept_inst);
	}
	/**
	 * 意识障碍的程度id
	 * @return String
	 */
	public String getId_unawar() {
		return ((String) getAttrVal("Id_unawar"));
	}	
	/**
	 * 意识障碍的程度id
	 * @param Id_unawar
	 */
	public void setId_unawar(String Id_unawar) {
		setAttrVal("Id_unawar", Id_unawar);
	}
	/**
	 * 意识障碍的程度
	 * @return String
	 */
	public String getSd_unawar() {
		return ((String) getAttrVal("Sd_unawar"));
	}	
	/**
	 * 意识障碍的程度
	 * @param Sd_unawar
	 */
	public void setSd_unawar(String Sd_unawar) {
		setAttrVal("Sd_unawar", Sd_unawar);
	}
	/**
	 * 最近一星期病人自拔导管次数（包含所有导管类型）
	 * @return Integer
	 */
	public Integer getCount_pull_pipe() {
		return ((Integer) getAttrVal("Count_pull_pipe"));
	}	
	/**
	 * 最近一星期病人自拔导管次数（包含所有导管类型）
	 * @param Count_pull_pipe
	 */
	public void setCount_pull_pipe(Integer Count_pull_pipe) {
		setAttrVal("Count_pull_pipe", Count_pull_pipe);
	}
	/**
	 * 平日有无陪伴者
	 * @return Integer
	 */
	public Integer getEu_any_cpy() {
		return ((Integer) getAttrVal("Eu_any_cpy"));
	}	
	/**
	 * 平日有无陪伴者
	 * @param Eu_any_cpy
	 */
	public void setEu_any_cpy(Integer Eu_any_cpy) {
		setAttrVal("Eu_any_cpy", Eu_any_cpy);
	}
	/**
	 * 事件发生陪伴者是否在场
	 * @return Integer
	 */
	public Integer getEu_cpy_here() {
		return ((Integer) getAttrVal("Eu_cpy_here"));
	}	
	/**
	 * 事件发生陪伴者是否在场
	 * @param Eu_cpy_here
	 */
	public void setEu_cpy_here(Integer Eu_cpy_here) {
		setAttrVal("Eu_cpy_here", Eu_cpy_here);
	}
	/**
	 * 事件发生时在场陪伴者
	 * @return String
	 */
	public String getCpy_here_oth() {
		return ((String) getAttrVal("Cpy_here_oth"));
	}	
	/**
	 * 事件发生时在场陪伴者
	 * @param Cpy_here_oth
	 */
	public void setCpy_here_oth(String Cpy_here_oth) {
		setAttrVal("Cpy_here_oth", Cpy_here_oth);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getExt4() {
		return ((String) getAttrVal("Ext4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ext4
	 */
	public void setExt4(String Ext4) {
		setAttrVal("Ext4", Ext4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getExt5() {
		return ((String) getAttrVal("Ext5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ext5
	 */
	public void setExt5(String Ext5) {
		setAttrVal("Ext5", Ext5);
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 导管事件错误类型
	 * @return String
	 */
	public String getName_pipe_errtp() {
		return ((String) getAttrVal("Name_pipe_errtp"));
	}	
	/**
	 * 导管事件错误类型
	 * @param Name_pipe_errtp
	 */
	public void setName_pipe_errtp(String Name_pipe_errtp) {
		setAttrVal("Name_pipe_errtp", Name_pipe_errtp);
	}
	/**
	 * 导管种类
	 * @return String
	 */
	public String getName_pipe_tp() {
		return ((String) getAttrVal("Name_pipe_tp"));
	}	
	/**
	 * 导管种类
	 * @param Name_pipe_tp
	 */
	public void setName_pipe_tp(String Name_pipe_tp) {
		setAttrVal("Name_pipe_tp", Name_pipe_tp);
	}
	/**
	 * 事件发生于何项活动
	 * @return String
	 */
	public String getName_ocur_ativy() {
		return ((String) getAttrVal("Name_ocur_ativy"));
	}	
	/**
	 * 事件发生于何项活动
	 * @param Name_ocur_ativy
	 */
	public void setName_ocur_ativy(String Name_ocur_ativy) {
		setAttrVal("Name_ocur_ativy", Name_ocur_ativy);
	}
	/**
	 * 固定导管使用的材料
	 * @return String
	 */
	public String getName_pipe_mtr() {
		return ((String) getAttrVal("Name_pipe_mtr"));
	}	
	/**
	 * 固定导管使用的材料
	 * @param Name_pipe_mtr
	 */
	public void setName_pipe_mtr(String Name_pipe_mtr) {
		setAttrVal("Name_pipe_mtr", Name_pipe_mtr);
	}
	/**
	 * 意识障碍的程度
	 * @return String
	 */
	public String getName_unawar() {
		return ((String) getAttrVal("Name_unawar"));
	}	
	/**
	 * 意识障碍的程度
	 * @param Name_unawar
	 */
	public void setName_unawar(String Name_unawar) {
		setAttrVal("Name_unawar", Name_unawar);
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
		return "Id_aer_ev_npipe";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_NPIPE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvNpipeDODesc.class);
	}
	
}