package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.RelSrvTacticDODesc;
import java.math.BigDecimal;

/**
 * 关联服务策略 DO数据 
 * 
 */
public class RelSrvTacticDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//关联服务策略主键
	public static final String ID_RELSRVTACTICS= "Id_relsrvtactics";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//关联因素类型
	public static final String ID_RELFACTORTP= "Id_relfactortp";
	//关联因素类型编码
	public static final String SD_RELFACTORTP= "Sd_relfactortp";
	//关联因素值1
	public static final String ID_BIZ= "Id_biz";
	//关联因素值2
	public static final String ID_BIZITM= "Id_bizitm";
	//用量计算策略
	public static final String ID_QUANCALMD= "Id_quancalmd";
	//用量计算策略编码
	public static final String SD_QUANCALMD= "Sd_quancalmd";
	//比例系数
	public static final String FACTOR= "Factor";
	//服务
	public static final String ID_SRV= "Id_srv";
	//数量_医学单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//策略适用范围
	public static final String ID_SRVORRT= "Id_srvorrt";
	//策略适用范围编码
	public static final String SD_SRVORRT= "Sd_srvorrt";
	//科室类型（适用科室时选取匹配科室类型）
	public static final String ID_DEPTP= "Id_deptp";
	//科室类型编码
	public static final String SD_DEPTP= "Sd_deptp";
	//适用科室（对应类型的科室）
	public static final String ID_DEP= "Id_dep";
	//门诊可用标识
	public static final String FG_USE_OP= "Fg_use_op";
	//预住院可用标识
	public static final String FG_USE_PIP= "Fg_use_pip";
	//住院可用标识
	public static final String FG_USE_IP= "Fg_use_ip";
	//急诊流水标志
	public static final String FG_USE_ER= "Fg_use_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//体检可用标识
	public static final String FG_USE_PE= "Fg_use_pe";
	//家床可用标识
	public static final String FG_USE_FM= "Fg_use_fm";
	//舍入规则
	public static final String ID_ROUNDMD= "Id_roundmd";
	//舍入规则编码
	public static final String SD_ROUNDMD= "Sd_roundmd";
	//生效判断类
	public static final String EFFECTIVEDECIDECLASS= "Effectivedecideclass";
	//启用
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//精度
	public static final String PRECISE= "Precise";
	//用量计算外挂函数
	public static final String QUANCALEXTERNALFUNC= "Quancalexternalfunc";
	//外挂函数参数个数
	public static final String CNT_EXTERNFUNPARAM= "Cnt_externfunparam";
	//外挂函数类全路径名
	public static final String FULLCLASSNAME_EXTERNFUN= "Fullclassname_externfun";
	//外挂函数参数值串
	public static final String PARAMV_EXTERNFUN= "Paramv_externfun";
	//用量计算外挂函数主键
	public static final String ID_EXTERNFUN= "Id_externfun";
	//组号
	public static final String GROUPNO= "Groupno";
	//服务关联业务类型
	public static final String ID_RELSRVTRIGGERTP= "Id_relsrvtriggertp";
	//服务关联业务类型编码
	public static final String SD_RELSRVTRIGGERTP= "Sd_relsrvtriggertp";
	//生成项目类型
	public static final String ID_RELSRVBUILDTP= "Id_relsrvbuildtp";
	//生成项目类型编码
	public static final String SD_RELSRVBUILDTP= "Sd_relsrvbuildtp";
	//名称
	public static final String FACTORTPNAME= "Factortpname";
	//服务名称
	public static final String SRVNAME= "Srvname";
	//服务类型编码
	public static final String SRV_SD_SRVTP= "Srv_sd_srvtp";
	//定价模式
	public static final String SRV_ID_PRIMD= "Srv_id_primd";
	//服务套标识
	public static final String SRV_FG_SET= "Srv_fg_set";
	//服务名称
	public static final String SRVITEMNAME= "Srvitemname";
	//名称
	public static final String CALMDNAME= "Calmdname";
	//服务名称
	public static final String RELSRVNAME= "Relsrvname";
	//计量单位名称
	public static final String UNITNAME= "Unitname";
	//策略适用范围名称
	public static final String SRVORRTNAME= "Srvorrtname";
	//名称
	public static final String ROUNDNAME= "Roundname";
	//服务关联业务类型名称
	public static final String NAME_RELSRVTRIGGERTP= "Name_relsrvtriggertp";
	//生成项目类型名称
	public static final String NAME_RELSRVBUILDTP= "Name_relsrvbuildtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 关联服务策略主键
	 * @return String
	 */
	public String getId_relsrvtactics() {
		return ((String) getAttrVal("Id_relsrvtactics"));
	}	
	/**
	 * 关联服务策略主键
	 * @param Id_relsrvtactics
	 */
	public void setId_relsrvtactics(String Id_relsrvtactics) {
		setAttrVal("Id_relsrvtactics", Id_relsrvtactics);
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
	 * 关联因素类型
	 * @return String
	 */
	public String getId_relfactortp() {
		return ((String) getAttrVal("Id_relfactortp"));
	}	
	/**
	 * 关联因素类型
	 * @param Id_relfactortp
	 */
	public void setId_relfactortp(String Id_relfactortp) {
		setAttrVal("Id_relfactortp", Id_relfactortp);
	}
	/**
	 * 关联因素类型编码
	 * @return String
	 */
	public String getSd_relfactortp() {
		return ((String) getAttrVal("Sd_relfactortp"));
	}	
	/**
	 * 关联因素类型编码
	 * @param Sd_relfactortp
	 */
	public void setSd_relfactortp(String Sd_relfactortp) {
		setAttrVal("Sd_relfactortp", Sd_relfactortp);
	}
	/**
	 * 关联因素值1
	 * @return String
	 */
	public String getId_biz() {
		return ((String) getAttrVal("Id_biz"));
	}	
	/**
	 * 关联因素值1
	 * @param Id_biz
	 */
	public void setId_biz(String Id_biz) {
		setAttrVal("Id_biz", Id_biz);
	}
	/**
	 * 关联因素值2
	 * @return String
	 */
	public String getId_bizitm() {
		return ((String) getAttrVal("Id_bizitm"));
	}	
	/**
	 * 关联因素值2
	 * @param Id_bizitm
	 */
	public void setId_bizitm(String Id_bizitm) {
		setAttrVal("Id_bizitm", Id_bizitm);
	}
	/**
	 * 用量计算策略
	 * @return String
	 */
	public String getId_quancalmd() {
		return ((String) getAttrVal("Id_quancalmd"));
	}	
	/**
	 * 用量计算策略
	 * @param Id_quancalmd
	 */
	public void setId_quancalmd(String Id_quancalmd) {
		setAttrVal("Id_quancalmd", Id_quancalmd);
	}
	/**
	 * 用量计算策略编码
	 * @return String
	 */
	public String getSd_quancalmd() {
		return ((String) getAttrVal("Sd_quancalmd"));
	}	
	/**
	 * 用量计算策略编码
	 * @param Sd_quancalmd
	 */
	public void setSd_quancalmd(String Sd_quancalmd) {
		setAttrVal("Sd_quancalmd", Sd_quancalmd);
	}
	/**
	 * 比例系数
	 * @return String
	 */
	public String getFactor() {
		return ((String) getAttrVal("Factor"));
	}	
	/**
	 * 比例系数
	 * @param Factor
	 */
	public void setFactor(String Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 数量_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数量_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 策略适用范围
	 * @return String
	 */
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}	
	/**
	 * 策略适用范围
	 * @param Id_srvorrt
	 */
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	/**
	 * 策略适用范围编码
	 * @return String
	 */
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}	
	/**
	 * 策略适用范围编码
	 * @param Sd_srvorrt
	 */
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	/**
	 * 科室类型（适用科室时选取匹配科室类型）
	 * @return String
	 */
	public String getId_deptp() {
		return ((String) getAttrVal("Id_deptp"));
	}	
	/**
	 * 科室类型（适用科室时选取匹配科室类型）
	 * @param Id_deptp
	 */
	public void setId_deptp(String Id_deptp) {
		setAttrVal("Id_deptp", Id_deptp);
	}
	/**
	 * 科室类型编码
	 * @return String
	 */
	public String getSd_deptp() {
		return ((String) getAttrVal("Sd_deptp"));
	}	
	/**
	 * 科室类型编码
	 * @param Sd_deptp
	 */
	public void setSd_deptp(String Sd_deptp) {
		setAttrVal("Sd_deptp", Sd_deptp);
	}
	/**
	 * 适用科室（对应类型的科室）
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 适用科室（对应类型的科室）
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 门诊可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 门诊可用标识
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 预住院可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 预住院可用标识
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 住院可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 住院可用标识
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
	 * 体检可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 体检可用标识
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 家床可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 家床可用标识
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 舍入规则
	 * @return String
	 */
	public String getId_roundmd() {
		return ((String) getAttrVal("Id_roundmd"));
	}	
	/**
	 * 舍入规则
	 * @param Id_roundmd
	 */
	public void setId_roundmd(String Id_roundmd) {
		setAttrVal("Id_roundmd", Id_roundmd);
	}
	/**
	 * 舍入规则编码
	 * @return String
	 */
	public String getSd_roundmd() {
		return ((String) getAttrVal("Sd_roundmd"));
	}	
	/**
	 * 舍入规则编码
	 * @param Sd_roundmd
	 */
	public void setSd_roundmd(String Sd_roundmd) {
		setAttrVal("Sd_roundmd", Sd_roundmd);
	}
	/**
	 * 生效判断类
	 * @return String
	 */
	public String getEffectivedecideclass() {
		return ((String) getAttrVal("Effectivedecideclass"));
	}	
	/**
	 * 生效判断类
	 * @param Effectivedecideclass
	 */
	public void setEffectivedecideclass(String Effectivedecideclass) {
		setAttrVal("Effectivedecideclass", Effectivedecideclass);
	}
	/**
	 * 启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用
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
	 * 精度
	 * @return Integer
	 */
	public Integer getPrecise() {
		return ((Integer) getAttrVal("Precise"));
	}	
	/**
	 * 精度
	 * @param Precise
	 */
	public void setPrecise(Integer Precise) {
		setAttrVal("Precise", Precise);
	}
	/**
	 * 用量计算外挂函数
	 * @return String
	 */
	public String getQuancalexternalfunc() {
		return ((String) getAttrVal("Quancalexternalfunc"));
	}	
	/**
	 * 用量计算外挂函数
	 * @param Quancalexternalfunc
	 */
	public void setQuancalexternalfunc(String Quancalexternalfunc) {
		setAttrVal("Quancalexternalfunc", Quancalexternalfunc);
	}
	/**
	 * 外挂函数参数个数
	 * @return Integer
	 */
	public Integer getCnt_externfunparam() {
		return ((Integer) getAttrVal("Cnt_externfunparam"));
	}	
	/**
	 * 外挂函数参数个数
	 * @param Cnt_externfunparam
	 */
	public void setCnt_externfunparam(Integer Cnt_externfunparam) {
		setAttrVal("Cnt_externfunparam", Cnt_externfunparam);
	}
	/**
	 * 外挂函数类全路径名
	 * @return String
	 */
	public String getFullclassname_externfun() {
		return ((String) getAttrVal("Fullclassname_externfun"));
	}	
	/**
	 * 外挂函数类全路径名
	 * @param Fullclassname_externfun
	 */
	public void setFullclassname_externfun(String Fullclassname_externfun) {
		setAttrVal("Fullclassname_externfun", Fullclassname_externfun);
	}
	/**
	 * 外挂函数参数值串
	 * @return String
	 */
	public String getParamv_externfun() {
		return ((String) getAttrVal("Paramv_externfun"));
	}	
	/**
	 * 外挂函数参数值串
	 * @param Paramv_externfun
	 */
	public void setParamv_externfun(String Paramv_externfun) {
		setAttrVal("Paramv_externfun", Paramv_externfun);
	}
	/**
	 * 用量计算外挂函数主键
	 * @return String
	 */
	public String getId_externfun() {
		return ((String) getAttrVal("Id_externfun"));
	}	
	/**
	 * 用量计算外挂函数主键
	 * @param Id_externfun
	 */
	public void setId_externfun(String Id_externfun) {
		setAttrVal("Id_externfun", Id_externfun);
	}
	/**
	 * 组号
	 * @return String
	 */
	public String getGroupno() {
		return ((String) getAttrVal("Groupno"));
	}	
	/**
	 * 组号
	 * @param Groupno
	 */
	public void setGroupno(String Groupno) {
		setAttrVal("Groupno", Groupno);
	}
	/**
	 * 服务关联业务类型
	 * @return String
	 */
	public String getId_relsrvtriggertp() {
		return ((String) getAttrVal("Id_relsrvtriggertp"));
	}	
	/**
	 * 服务关联业务类型
	 * @param Id_relsrvtriggertp
	 */
	public void setId_relsrvtriggertp(String Id_relsrvtriggertp) {
		setAttrVal("Id_relsrvtriggertp", Id_relsrvtriggertp);
	}
	/**
	 * 服务关联业务类型编码
	 * @return String
	 */
	public String getSd_relsrvtriggertp() {
		return ((String) getAttrVal("Sd_relsrvtriggertp"));
	}	
	/**
	 * 服务关联业务类型编码
	 * @param Sd_relsrvtriggertp
	 */
	public void setSd_relsrvtriggertp(String Sd_relsrvtriggertp) {
		setAttrVal("Sd_relsrvtriggertp", Sd_relsrvtriggertp);
	}
	/**
	 * 生成项目类型
	 * @return String
	 */
	public String getId_relsrvbuildtp() {
		return ((String) getAttrVal("Id_relsrvbuildtp"));
	}	
	/**
	 * 生成项目类型
	 * @param Id_relsrvbuildtp
	 */
	public void setId_relsrvbuildtp(String Id_relsrvbuildtp) {
		setAttrVal("Id_relsrvbuildtp", Id_relsrvbuildtp);
	}
	/**
	 * 生成项目类型编码
	 * @return String
	 */
	public String getSd_relsrvbuildtp() {
		return ((String) getAttrVal("Sd_relsrvbuildtp"));
	}	
	/**
	 * 生成项目类型编码
	 * @param Sd_relsrvbuildtp
	 */
	public void setSd_relsrvbuildtp(String Sd_relsrvbuildtp) {
		setAttrVal("Sd_relsrvbuildtp", Sd_relsrvbuildtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFactortpname() {
		return ((String) getAttrVal("Factortpname"));
	}	
	/**
	 * 名称
	 * @param Factortpname
	 */
	public void setFactortpname(String Factortpname) {
		setAttrVal("Factortpname", Factortpname);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSrv_sd_srvtp() {
		return ((String) getAttrVal("Srv_sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Srv_sd_srvtp
	 */
	public void setSrv_sd_srvtp(String Srv_sd_srvtp) {
		setAttrVal("Srv_sd_srvtp", Srv_sd_srvtp);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getSrv_id_primd() {
		return ((String) getAttrVal("Srv_id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Srv_id_primd
	 */
	public void setSrv_id_primd(String Srv_id_primd) {
		setAttrVal("Srv_id_primd", Srv_id_primd);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getSrv_fg_set() {
		return ((FBoolean) getAttrVal("Srv_fg_set"));
	}	
	/**
	 * 服务套标识
	 * @param Srv_fg_set
	 */
	public void setSrv_fg_set(FBoolean Srv_fg_set) {
		setAttrVal("Srv_fg_set", Srv_fg_set);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvitemname() {
		return ((String) getAttrVal("Srvitemname"));
	}	
	/**
	 * 服务名称
	 * @param Srvitemname
	 */
	public void setSrvitemname(String Srvitemname) {
		setAttrVal("Srvitemname", Srvitemname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCalmdname() {
		return ((String) getAttrVal("Calmdname"));
	}	
	/**
	 * 名称
	 * @param Calmdname
	 */
	public void setCalmdname(String Calmdname) {
		setAttrVal("Calmdname", Calmdname);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getRelsrvname() {
		return ((String) getAttrVal("Relsrvname"));
	}	
	/**
	 * 服务名称
	 * @param Relsrvname
	 */
	public void setRelsrvname(String Relsrvname) {
		setAttrVal("Relsrvname", Relsrvname);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getUnitname() {
		return ((String) getAttrVal("Unitname"));
	}	
	/**
	 * 计量单位名称
	 * @param Unitname
	 */
	public void setUnitname(String Unitname) {
		setAttrVal("Unitname", Unitname);
	}
	/**
	 * 策略适用范围名称
	 * @return String
	 */
	public String getSrvorrtname() {
		return ((String) getAttrVal("Srvorrtname"));
	}	
	/**
	 * 策略适用范围名称
	 * @param Srvorrtname
	 */
	public void setSrvorrtname(String Srvorrtname) {
		setAttrVal("Srvorrtname", Srvorrtname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRoundname() {
		return ((String) getAttrVal("Roundname"));
	}	
	/**
	 * 名称
	 * @param Roundname
	 */
	public void setRoundname(String Roundname) {
		setAttrVal("Roundname", Roundname);
	}
	/**
	 * 服务关联业务类型名称
	 * @return String
	 */
	public String getName_relsrvtriggertp() {
		return ((String) getAttrVal("Name_relsrvtriggertp"));
	}	
	/**
	 * 服务关联业务类型名称
	 * @param Name_relsrvtriggertp
	 */
	public void setName_relsrvtriggertp(String Name_relsrvtriggertp) {
		setAttrVal("Name_relsrvtriggertp", Name_relsrvtriggertp);
	}
	/**
	 * 生成项目类型名称
	 * @return String
	 */
	public String getName_relsrvbuildtp() {
		return ((String) getAttrVal("Name_relsrvbuildtp"));
	}	
	/**
	 * 生成项目类型名称
	 * @param Name_relsrvbuildtp
	 */
	public void setName_relsrvbuildtp(String Name_relsrvbuildtp) {
		setAttrVal("Name_relsrvbuildtp", Name_relsrvbuildtp);
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
		return "Id_relsrvtactics";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_relsrv_tactics";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RelSrvTacticDODesc.class);
	}
	
}