package iih.mp.dg.ipshetp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.ipshetp.d.desc.IpSheetTypeDODesc;
import java.math.BigDecimal;

/**
 * 住院药单类型维护 DO数据 
 * 
 */
public class IpSheetTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//药单主键ID
	public static final String ID_DGSHETP= "Id_dgshetp";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//药单类型
	public static final String EU_SHETP= "Eu_shetp";
	//药单编码
	public static final String CODE= "Code";
	//药单名称
	public static final String NAME= "Name";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记符
	public static final String INSTR= "Instr";
	//摆药药房
	public static final String ID_DEP_MP= "Id_dep_mp";
	//是否包含节假日
	public static final String FG_HOL= "Fg_hol";
	//医嘱类型
	public static final String EU_OR_TP= "Eu_or_tp";
	//摆药天数
	public static final String DG_DAYS= "Dg_days";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//截止时间
	public static final String DT_END= "Dt_end";
	//对应病区
	public static final String ID_DEP_NURS= "Id_dep_nurs";
	//对应规则
	public static final String ID_DG_RUL= "Id_dg_rul";
	//对应规则编码
	public static final String CODE_DG_RUL= "Code_dg_rul";
	//描述
	public static final String DES= "Des";
	//分单标志
	public static final String FG_SPLIT= "Fg_split";
	//是否摆药机摆药
	public static final String FG_AUTODISP= "Fg_autodisp";
	//智能柜药品标识
	public static final String EN_CABINET= "En_cabinet";
	//是否自动生成摆药单
	public static final String FG_AUTOGENERATE= "Fg_autogenerate";
	//自动生成摆药单时间
	public static final String DT_STR= "Dt_str";
	//后审核标识
	public static final String FG_AFTERREV= "Fg_afterrev";
	//出院带药标识
	public static final String FG_OUTP= "Fg_outp";
	//先记费标识
	public static final String FG_PREBL= "Fg_prebl";
	//毒麻标识
	public static final String FG_POIS= "Fg_pois";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//处方分单标识
	public static final String FG_SPLITPRES= "Fg_splitpres";
	//是否直接摆药
	public static final String FG_DIRECT= "Fg_direct";
	//出院不检查
	public static final String FG_OUTNOIS= "Fg_outnois";
	//出院未刷单校验
	public static final String FG_CHKUNBRUSH= "Fg_chkunbrush";
	//出院未退药校验
	public static final String FG_CHKUNRETURN= "Fg_chkunreturn";
	//医技药单标识
	public static final String FG_OT= "Fg_ot";
	//是否成组发药
	public static final String FG_GROUP= "Fg_group";
	//摆药周期模式
	public static final String EN_DRUGCYCLE= "En_drugcycle";
	//上周期摆药模式
	public static final String EN_DAYFIRDRUG= "En_dayfirdrug";
	//pivas标识
	public static final String FG_PIVAS= "Fg_pivas";
	//退药医嘱标识
	public static final String FG_OR_BACK= "Fg_or_back";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//患者维度拆分标识
	public static final String FG_ENT_SPLIT= "Fg_ent_split";
	//代替药单
	public static final String ID_SHETP_REPL= "Id_shetp_repl";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//药房名称
	public static final String NAME_DEP= "Name_dep";
	//病区名称
	public static final String NAME_NUR= "Name_nur";
	//规则操作名称
	public static final String NAME_RULE= "Name_rule";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//药单编码
	public static final String REPL_CODE= "Repl_code";
	//药单名称
	public static final String REPL_NAME= "Repl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 药单主键ID
	 * @return String
	 */
	public String getId_dgshetp() {
		return ((String) getAttrVal("Id_dgshetp"));
	}	
	/**
	 * 药单主键ID
	 * @param Id_dgshetp
	 */
	public void setId_dgshetp(String Id_dgshetp) {
		setAttrVal("Id_dgshetp", Id_dgshetp);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 药单类型
	 * @return Integer
	 */
	public Integer getEu_shetp() {
		return ((Integer) getAttrVal("Eu_shetp"));
	}	
	/**
	 * 药单类型
	 * @param Eu_shetp
	 */
	public void setEu_shetp(Integer Eu_shetp) {
		setAttrVal("Eu_shetp", Eu_shetp);
	}
	/**
	 * 药单编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 药单编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 药单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 药单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 摆药药房
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 摆药药房
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 是否包含节假日
	 * @return FBoolean
	 */
	public FBoolean getFg_hol() {
		return ((FBoolean) getAttrVal("Fg_hol"));
	}	
	/**
	 * 是否包含节假日
	 * @param Fg_hol
	 */
	public void setFg_hol(FBoolean Fg_hol) {
		setAttrVal("Fg_hol", Fg_hol);
	}
	/**
	 * 医嘱类型
	 * @return Integer
	 */
	public Integer getEu_or_tp() {
		return ((Integer) getAttrVal("Eu_or_tp"));
	}	
	/**
	 * 医嘱类型
	 * @param Eu_or_tp
	 */
	public void setEu_or_tp(Integer Eu_or_tp) {
		setAttrVal("Eu_or_tp", Eu_or_tp);
	}
	/**
	 * 摆药天数
	 * @return Integer
	 */
	public Integer getDg_days() {
		return ((Integer) getAttrVal("Dg_days"));
	}	
	/**
	 * 摆药天数
	 * @param Dg_days
	 */
	public void setDg_days(Integer Dg_days) {
		setAttrVal("Dg_days", Dg_days);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getDt_begin() {
		return ((FTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return FTime
	 */
	public FTime getDt_end() {
		return ((FTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 对应病区
	 * @return String
	 */
	public String getId_dep_nurs() {
		return ((String) getAttrVal("Id_dep_nurs"));
	}	
	/**
	 * 对应病区
	 * @param Id_dep_nurs
	 */
	public void setId_dep_nurs(String Id_dep_nurs) {
		setAttrVal("Id_dep_nurs", Id_dep_nurs);
	}
	/**
	 * 对应规则
	 * @return String
	 */
	public String getId_dg_rul() {
		return ((String) getAttrVal("Id_dg_rul"));
	}	
	/**
	 * 对应规则
	 * @param Id_dg_rul
	 */
	public void setId_dg_rul(String Id_dg_rul) {
		setAttrVal("Id_dg_rul", Id_dg_rul);
	}
	/**
	 * 对应规则编码
	 * @return String
	 */
	public String getCode_dg_rul() {
		return ((String) getAttrVal("Code_dg_rul"));
	}	
	/**
	 * 对应规则编码
	 * @param Code_dg_rul
	 */
	public void setCode_dg_rul(String Code_dg_rul) {
		setAttrVal("Code_dg_rul", Code_dg_rul);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 分单标志
	 * @return FBoolean
	 */
	public FBoolean getFg_split() {
		return ((FBoolean) getAttrVal("Fg_split"));
	}	
	/**
	 * 分单标志
	 * @param Fg_split
	 */
	public void setFg_split(FBoolean Fg_split) {
		setAttrVal("Fg_split", Fg_split);
	}
	/**
	 * 是否摆药机摆药
	 * @return FBoolean
	 */
	public FBoolean getFg_autodisp() {
		return ((FBoolean) getAttrVal("Fg_autodisp"));
	}	
	/**
	 * 是否摆药机摆药
	 * @param Fg_autodisp
	 */
	public void setFg_autodisp(FBoolean Fg_autodisp) {
		setAttrVal("Fg_autodisp", Fg_autodisp);
	}
	/**
	 * 智能柜药品标识
	 * @return Integer
	 */
	public Integer getEn_cabinet() {
		return ((Integer) getAttrVal("En_cabinet"));
	}	
	/**
	 * 智能柜药品标识
	 * @param En_cabinet
	 */
	public void setEn_cabinet(Integer En_cabinet) {
		setAttrVal("En_cabinet", En_cabinet);
	}
	/**
	 * 是否自动生成摆药单
	 * @return FBoolean
	 */
	public FBoolean getFg_autogenerate() {
		return ((FBoolean) getAttrVal("Fg_autogenerate"));
	}	
	/**
	 * 是否自动生成摆药单
	 * @param Fg_autogenerate
	 */
	public void setFg_autogenerate(FBoolean Fg_autogenerate) {
		setAttrVal("Fg_autogenerate", Fg_autogenerate);
	}
	/**
	 * 自动生成摆药单时间
	 * @return FTime
	 */
	public FTime getDt_str() {
		return ((FTime) getAttrVal("Dt_str"));
	}	
	/**
	 * 自动生成摆药单时间
	 * @param Dt_str
	 */
	public void setDt_str(FTime Dt_str) {
		setAttrVal("Dt_str", Dt_str);
	}
	/**
	 * 后审核标识
	 * @return FBoolean
	 */
	public FBoolean getFg_afterrev() {
		return ((FBoolean) getAttrVal("Fg_afterrev"));
	}	
	/**
	 * 后审核标识
	 * @param Fg_afterrev
	 */
	public void setFg_afterrev(FBoolean Fg_afterrev) {
		setAttrVal("Fg_afterrev", Fg_afterrev);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_outp() {
		return ((FBoolean) getAttrVal("Fg_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_outp
	 */
	public void setFg_outp(FBoolean Fg_outp) {
		setAttrVal("Fg_outp", Fg_outp);
	}
	/**
	 * 先记费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prebl() {
		return ((FBoolean) getAttrVal("Fg_prebl"));
	}	
	/**
	 * 先记费标识
	 * @param Fg_prebl
	 */
	public void setFg_prebl(FBoolean Fg_prebl) {
		setAttrVal("Fg_prebl", Fg_prebl);
	}
	/**
	 * 毒麻标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}	
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 处方分单标识
	 * @return FBoolean
	 */
	public FBoolean getFg_splitpres() {
		return ((FBoolean) getAttrVal("Fg_splitpres"));
	}	
	/**
	 * 处方分单标识
	 * @param Fg_splitpres
	 */
	public void setFg_splitpres(FBoolean Fg_splitpres) {
		setAttrVal("Fg_splitpres", Fg_splitpres);
	}
	/**
	 * 是否直接摆药
	 * @return FBoolean
	 */
	public FBoolean getFg_direct() {
		return ((FBoolean) getAttrVal("Fg_direct"));
	}	
	/**
	 * 是否直接摆药
	 * @param Fg_direct
	 */
	public void setFg_direct(FBoolean Fg_direct) {
		setAttrVal("Fg_direct", Fg_direct);
	}
	/**
	 * 出院不检查
	 * @return FBoolean
	 */
	public FBoolean getFg_outnois() {
		return ((FBoolean) getAttrVal("Fg_outnois"));
	}	
	/**
	 * 出院不检查
	 * @param Fg_outnois
	 */
	public void setFg_outnois(FBoolean Fg_outnois) {
		setAttrVal("Fg_outnois", Fg_outnois);
	}
	/**
	 * 出院未刷单校验
	 * @return FBoolean
	 */
	public FBoolean getFg_chkunbrush() {
		return ((FBoolean) getAttrVal("Fg_chkunbrush"));
	}	
	/**
	 * 出院未刷单校验
	 * @param Fg_chkunbrush
	 */
	public void setFg_chkunbrush(FBoolean Fg_chkunbrush) {
		setAttrVal("Fg_chkunbrush", Fg_chkunbrush);
	}
	/**
	 * 出院未退药校验
	 * @return FBoolean
	 */
	public FBoolean getFg_chkunreturn() {
		return ((FBoolean) getAttrVal("Fg_chkunreturn"));
	}	
	/**
	 * 出院未退药校验
	 * @param Fg_chkunreturn
	 */
	public void setFg_chkunreturn(FBoolean Fg_chkunreturn) {
		setAttrVal("Fg_chkunreturn", Fg_chkunreturn);
	}
	/**
	 * 医技药单标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ot() {
		return ((FBoolean) getAttrVal("Fg_ot"));
	}	
	/**
	 * 医技药单标识
	 * @param Fg_ot
	 */
	public void setFg_ot(FBoolean Fg_ot) {
		setAttrVal("Fg_ot", Fg_ot);
	}
	/**
	 * 是否成组发药
	 * @return FBoolean
	 */
	public FBoolean getFg_group() {
		return ((FBoolean) getAttrVal("Fg_group"));
	}	
	/**
	 * 是否成组发药
	 * @param Fg_group
	 */
	public void setFg_group(FBoolean Fg_group) {
		setAttrVal("Fg_group", Fg_group);
	}
	/**
	 * 摆药周期模式
	 * @return Integer
	 */
	public Integer getEn_drugcycle() {
		return ((Integer) getAttrVal("En_drugcycle"));
	}	
	/**
	 * 摆药周期模式
	 * @param En_drugcycle
	 */
	public void setEn_drugcycle(Integer En_drugcycle) {
		setAttrVal("En_drugcycle", En_drugcycle);
	}
	/**
	 * 上周期摆药模式
	 * @return Integer
	 */
	public Integer getEn_dayfirdrug() {
		return ((Integer) getAttrVal("En_dayfirdrug"));
	}	
	/**
	 * 上周期摆药模式
	 * @param En_dayfirdrug
	 */
	public void setEn_dayfirdrug(Integer En_dayfirdrug) {
		setAttrVal("En_dayfirdrug", En_dayfirdrug);
	}
	/**
	 * pivas标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pivas() {
		return ((FBoolean) getAttrVal("Fg_pivas"));
	}	
	/**
	 * pivas标识
	 * @param Fg_pivas
	 */
	public void setFg_pivas(FBoolean Fg_pivas) {
		setAttrVal("Fg_pivas", Fg_pivas);
	}
	/**
	 * 退药医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_back() {
		return ((FBoolean) getAttrVal("Fg_or_back"));
	}	
	/**
	 * 退药医嘱标识
	 * @param Fg_or_back
	 */
	public void setFg_or_back(FBoolean Fg_or_back) {
		setAttrVal("Fg_or_back", Fg_or_back);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 患者维度拆分标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ent_split() {
		return ((FBoolean) getAttrVal("Fg_ent_split"));
	}	
	/**
	 * 患者维度拆分标识
	 * @param Fg_ent_split
	 */
	public void setFg_ent_split(FBoolean Fg_ent_split) {
		setAttrVal("Fg_ent_split", Fg_ent_split);
	}
	/**
	 * 代替药单
	 * @return String
	 */
	public String getId_shetp_repl() {
		return ((String) getAttrVal("Id_shetp_repl"));
	}	
	/**
	 * 代替药单
	 * @param Id_shetp_repl
	 */
	public void setId_shetp_repl(String Id_shetp_repl) {
		setAttrVal("Id_shetp_repl", Id_shetp_repl);
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
	 * 药房名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 药房名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 病区名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 规则操作名称
	 * @return String
	 */
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	/**
	 * 规则操作名称
	 * @param Name_rule
	 */
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 药单编码
	 * @return String
	 */
	public String getRepl_code() {
		return ((String) getAttrVal("Repl_code"));
	}	
	/**
	 * 药单编码
	 * @param Repl_code
	 */
	public void setRepl_code(String Repl_code) {
		setAttrVal("Repl_code", Repl_code);
	}
	/**
	 * 药单名称
	 * @return String
	 */
	public String getRepl_name() {
		return ((String) getAttrVal("Repl_name"));
	}	
	/**
	 * 药单名称
	 * @param Repl_name
	 */
	public void setRepl_name(String Repl_name) {
		setAttrVal("Repl_name", Repl_name);
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
		return "Id_dgshetp";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_shetp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IpSheetTypeDODesc.class);
	}
	
}