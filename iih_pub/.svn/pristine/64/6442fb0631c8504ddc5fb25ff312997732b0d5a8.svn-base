package iih.bd.srv.freqdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.freqdef.d.desc.FreqDefDODesc;
import java.math.BigDecimal;

/**
 * 医嘱频次定义 DO数据 
 * 
 */
public class FreqDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱频次主键标识
	public static final String ID_FREQ= "Id_freq";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//频次编码
	public static final String CODE= "Code";
	//频次名称
	public static final String NAME= "Name";
	//显示编码
	public static final String CODE_DISP= "Code_disp";
	//频次描述
	public static final String DES= "Des";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//频次周期类型
	public static final String ID_FREQUNITCT= "Id_frequnitct";
	//频次周期数
	public static final String FREQUNITCT= "Frequnitct";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//备用医嘱标识
	public static final String FG_PRNOR= "Fg_prnor";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//长临标识是否可修改
	public static final String FG_LONG_EDIT= "Fg_long_edit";
	//系统标识
	public static final String FLAG_SYS= "Flag_sys";
	//可使用标识_门诊
	public static final String FG_USE_OP= "Fg_use_op";
	//可使用标识_预住院
	public static final String FG_USE_PIP= "Fg_use_pip";
	//可使用标识_住院
	public static final String FG_USE_IP= "Fg_use_ip";
	//急诊流水标志
	public static final String FG_USE_ER= "Fg_use_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//可使用标识_体检
	public static final String FG_USE_PE= "Fg_use_pe";
	//可使用标识_家庭
	public static final String FG_USE_FM= "Fg_use_fm";
	//是否间隔频次
	public static final String FG_INTERVAL= "Fg_interval";
	//序号
	public static final String SORTNO= "Sortno";
	//编码
	public static final String FRE_CODE= "Fre_code";
	//名称
	public static final String FRE_NAME= "Fre_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱频次主键标识
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次主键标识
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 频次编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 频次编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 频次名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 显示编码
	 * @return String
	 */
	public String getCode_disp() {
		return ((String) getAttrVal("Code_disp"));
	}	
	/**
	 * 显示编码
	 * @param Code_disp
	 */
	public void setCode_disp(String Code_disp) {
		setAttrVal("Code_disp", Code_disp);
	}
	/**
	 * 频次描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 频次描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnitct() {
		return ((String) getAttrVal("Id_frequnitct"));
	}	
	/**
	 * 频次周期类型
	 * @param Id_frequnitct
	 */
	public void setId_frequnitct(String Id_frequnitct) {
		setAttrVal("Id_frequnitct", Id_frequnitct);
	}
	/**
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	/**
	 * 频次周期数
	 * @param Frequnitct
	 */
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prnor() {
		return ((FBoolean) getAttrVal("Fg_prnor"));
	}	
	/**
	 * 备用医嘱标识
	 * @param Fg_prnor
	 */
	public void setFg_prnor(FBoolean Fg_prnor) {
		setAttrVal("Fg_prnor", Fg_prnor);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 长临标识是否可修改
	 * @return FBoolean
	 */
	public FBoolean getFg_long_edit() {
		return ((FBoolean) getAttrVal("Fg_long_edit"));
	}	
	/**
	 * 长临标识是否可修改
	 * @param Fg_long_edit
	 */
	public void setFg_long_edit(FBoolean Fg_long_edit) {
		setAttrVal("Fg_long_edit", Fg_long_edit);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFlag_sys() {
		return ((FBoolean) getAttrVal("Flag_sys"));
	}	
	/**
	 * 系统标识
	 * @param Flag_sys
	 */
	public void setFlag_sys(FBoolean Flag_sys) {
		setAttrVal("Flag_sys", Flag_sys);
	}
	/**
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 可使用标识_门诊
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 可使用标识_住院
	 * @param Fg_use_ip
	 */
	public void setFg_use_ip(FBoolean Fg_use_ip) {
		setAttrVal("Fg_use_ip", Fg_use_ip);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er() {
		return ((FBoolean) getAttrVal("Fg_use_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_use_er
	 */
	public void setFg_use_er(FBoolean Fg_use_er) {
		setAttrVal("Fg_use_er", Fg_use_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 可使用标识_体检
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 可使用标识_家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 可使用标识_家庭
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 是否间隔频次
	 * @return FBoolean
	 */
	public FBoolean getFg_interval() {
		return ((FBoolean) getAttrVal("Fg_interval"));
	}	
	/**
	 * 是否间隔频次
	 * @param Fg_interval
	 */
	public void setFg_interval(FBoolean Fg_interval) {
		setAttrVal("Fg_interval", Fg_interval);
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
	 * 编码
	 * @return String
	 */
	public String getFre_code() {
		return ((String) getAttrVal("Fre_code"));
	}	
	/**
	 * 编码
	 * @param Fre_code
	 */
	public void setFre_code(String Fre_code) {
		setAttrVal("Fre_code", Fre_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFre_name() {
		return ((String) getAttrVal("Fre_name"));
	}	
	/**
	 * 名称
	 * @param Fre_name
	 */
	public void setFre_name(String Fre_name) {
		setAttrVal("Fre_name", Fre_name);
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
		return "Id_freq";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_freq";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FreqDefDODesc.class);
	}
	
}