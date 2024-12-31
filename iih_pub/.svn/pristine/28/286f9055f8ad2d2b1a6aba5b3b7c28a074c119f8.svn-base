package iih.ci.ord.ordprn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordprn.d.desc.OrdPrintDODesc;
import java.math.BigDecimal;

/**
 * 医嘱打印 DO数据 
 * 
 */
public class OrdPrintDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱打印主键标识
	public static final String ID_ORPRN= "Id_orprn";
	//单据名称
	public static final String NAME_ORPRN= "Name_orprn";
	//医嘱单样式ID（自定义档案）
	public static final String ID_ORDSHEET= "Id_ordsheet";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//年龄
	public static final String AGE= "Age";
	//患者性别
	public static final String SEX_PAT= "Sex_pat";
	//就诊
	public static final String ID_EN= "Id_en";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//住院病案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//护理病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//病床
	public static final String ID_BED= "Id_bed";
	//医嘱
	public static final String ID_OR= "Id_or";
	//服务ID
	public static final String ID_SRV= "Id_srv";
	//医嘱序号
	public static final String SORTNO= "Sortno";
	//医嘱类型
	public static final String ID_SRVTP= "Id_srvtp";
	//医嘱类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//医嘱内容
	public static final String CONTENT_OR_PRN= "Content_or_prn";
	//医嘱内容（成组用法频次）
	public static final String CONTENT_OR_PRN_SUB= "Content_or_prn_sub";
	//生效日期
	public static final String DT_EFFE= "Dt_effe";
	//月_生效日期
	public static final String DT_EFFE_M= "Dt_effe_m";
	//日_生效日期
	public static final String DT_EFFE_D= "Dt_effe_d";
	//时间_生效日期
	public static final String DT_EFFE_T= "Dt_effe_t";
	//签署医生
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	//签署科室
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	//核对标识
	public static final String FG_CHK= "Fg_chk";
	//核对执行护士
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//核对病区
	public static final String ID_DEP_CHK= "Id_dep_chk";
	//结束日期
	public static final String DT_END= "Dt_end";
	//月_结束日期
	public static final String DT_END_M= "Dt_end_m";
	//日_结束日期
	public static final String DT_END_D= "Dt_end_d";
	//时间_结束日期
	public static final String DT_END_T= "Dt_end_t";
	//停止医生
	public static final String ID_EMP_STOP= "Id_emp_stop";
	//停止科室
	public static final String ID_DEP_STOP= "Id_dep_stop";
	//停止打印标识
	public static final String FG_STOP_PRN= "Fg_stop_prn";
	//停止核对标识
	public static final String FG_CHK_STOP= "Fg_chk_stop";
	//停止核对护士
	public static final String ID_EMP_CHK_STOP= "Id_emp_chk_stop";
	//停止核对病区
	public static final String ID_DEP_CHK_STOP= "Id_dep_chk_stop";
	//作废医生
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//作废核对护士
	public static final String ID_EMP_CHK_CANC= "Id_emp_chk_canc";
	//作废打印标识
	public static final String FG_CANC_PRN= "Fg_canc_prn";
	//作废核对标识
	public static final String FG_CHK_CANC= "Fg_chk_canc";
	//责任医生
	public static final String LABEL_NAME_EMP_SIGN= "Label_name_emp_sign";
	//责任护士
	public static final String LABEL_NAME_EMP_CHECK= "Label_name_emp_check";
	//责任医生签字
	public static final String STR_EMP_SIGN= "Str_emp_sign";
	//责任护士签字
	public static final String STR_EMP_CHECK= "Str_emp_check";
	//责任医生名称拼接字符串
	public static final String STR_NAME_EMP_SIGN= "Str_name_emp_sign";
	//责任护士名称拼接字符串
	public static final String STR_NAME_EMP_CHECK= "Str_name_emp_check";
	//执行时间
	public static final String DT_MP= "Dt_mp";
	//医嘱确认护士
	public static final String ID_EMP_EXE= "Id_emp_exe";
	//执行人姓名
	public static final String NAME_EMP_EXE= "Name_emp_exe";
	//执行科室
	public static final String ID_DEP_EXE= "Id_dep_exe";
	//执行科室名称
	public static final String NAME_DEP_EXE= "Name_dep_exe";
	//已重整标识
	public static final String FG_REFORMED= "Fg_reformed";
	//重整时间
	public static final String DT_REFORM= "Dt_reform";
	//重整行标识
	public static final String FG_REFORMROW= "Fg_reformrow";
	//打印日期
	public static final String DT_PRN= "Dt_prn";
	//所在页码
	public static final String PAGE_NUM= "Page_num";
	//所在行号
	public static final String ROW_NUM= "Row_num";
	//所占行数
	public static final String ROW_CNT= "Row_cnt";
	//打印部门
	public static final String ID_DEP_PRN= "Id_dep_prn";
	//打印人员
	public static final String ID_EMP_PRN= "Id_emp_prn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//签署医生（电子签名）
	public static final String PIC_EMP_SIGN= "Pic_emp_sign";
	//核对护士（电子签名）
	public static final String PIC_EMP_CHK= "Pic_emp_chk";
	//停止医生（电子签名）
	public static final String PIC_EMP_STOP= "Pic_emp_stop";
	//停止核对护士(电子签名)
	public static final String PIC_EMP_CHK_STOP= "Pic_emp_chk_stop";
	//停止核对时间
	public static final String DT_CHK_STOP= "Dt_chk_stop";
	//皮试标识打印标志
	public static final String FG_SKIN_PRN= "Fg_skin_prn";
	//核对时间
	public static final String DT_CHK= "Dt_chk";
	//医嘱执行护士（电子签名）
	public static final String PIC_EMP_EXE= "Pic_emp_exe";
	//签署时间
	public static final String DT_SIGN= "Dt_sign";
	//横线续打不显示
	public static final String LINE= "Line";
	//医生签字（页尾标题）
	public static final String LABEL_NAME_EMP_SIGN_NEW= "Label_name_emp_sign_new";
	//护士签字（页尾标题）
	public static final String LABEL_NAME_EMP_CHECK_NEW= "Label_name_emp_check_new";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//患者姓名
	public static final String NAME_PAT_EN= "Name_pat_en";
	//就诊编码
	public static final String CODE_PAT_EN= "Code_pat_en";
	//编码
	public static final String CODE_DEP_PHY= "Code_dep_phy";
	//名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//编码
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//床位编码
	public static final String CODE_BED= "Code_bed";
	//床位名称
	public static final String NAME_BED= "Name_bed";
	//人员编码
	public static final String CODE_EMP_SIGN= "Code_emp_sign";
	//姓名
	public static final String NAME_EMP_SIGN= "Name_emp_sign";
	//编码
	public static final String CODE_DEP_SIGN= "Code_dep_sign";
	//名称
	public static final String NAME_DEP_SIGN= "Name_dep_sign";
	//人员编码
	public static final String CODE_EMP_CHK= "Code_emp_chk";
	//姓名
	public static final String NAME_EMP_CHK= "Name_emp_chk";
	//编码
	public static final String CODE_DEP_CHK= "Code_dep_chk";
	//名称
	public static final String NAME_DEP_CHK= "Name_dep_chk";
	//人员编码
	public static final String CODE_EMP_STOP= "Code_emp_stop";
	//姓名
	public static final String NAME_EMP_STOP= "Name_emp_stop";
	//编码
	public static final String CODE_DEP_STOP= "Code_dep_stop";
	//名称
	public static final String NAME_DEP_STOP= "Name_dep_stop";
	//人员编码
	public static final String CODE_EMP_CHK_STOP= "Code_emp_chk_stop";
	//姓名
	public static final String NAME_EMP_CHK_STOP= "Name_emp_chk_stop";
	//编码
	public static final String CODE_DEP_CHK_STOP= "Code_dep_chk_stop";
	//名称
	public static final String NAME_DEP_CHK_STOP= "Name_dep_chk_stop";
	//人员编码
	public static final String CODE_EMP_CANC= "Code_emp_canc";
	//姓名
	public static final String NAME_EMP_CANC= "Name_emp_canc";
	//人员编码
	public static final String CODE_EMP_CHK_CANC= "Code_emp_chk_canc";
	//姓名
	public static final String NAME_EMP_CHK_CANC= "Name_emp_chk_canc";
	//编码
	public static final String CODE_DEP_PRN= "Code_dep_prn";
	//皮试结果
	public static final String CONTENT_OR_PRN_SKINTEST= "Content_or_prn_skintest";
	//名称
	public static final String NAME_DEP_PRN= "Name_dep_prn";
	//人员编码
	public static final String CODE_EMP_PRN= "Code_emp_prn";
	//姓名
	public static final String NAME_EMP_PRN= "Name_emp_prn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱打印主键标识
	 * @return String
	 */
	public String getId_orprn() {
		return ((String) getAttrVal("Id_orprn"));
	}	
	/**
	 * 医嘱打印主键标识
	 * @param Id_orprn
	 */
	public void setId_orprn(String Id_orprn) {
		setAttrVal("Id_orprn", Id_orprn);
	}
	/**
	 * 单据名称
	 * @return String
	 */
	public String getName_orprn() {
		return ((String) getAttrVal("Name_orprn"));
	}	
	/**
	 * 单据名称
	 * @param Name_orprn
	 */
	public void setName_orprn(String Name_orprn) {
		setAttrVal("Name_orprn", Name_orprn);
	}
	/**
	 * 医嘱单样式ID（自定义档案）
	 * @return String
	 */
	public String getId_ordsheet() {
		return ((String) getAttrVal("Id_ordsheet"));
	}	
	/**
	 * 医嘱单样式ID（自定义档案）
	 * @param Id_ordsheet
	 */
	public void setId_ordsheet(String Id_ordsheet) {
		setAttrVal("Id_ordsheet", Id_ordsheet);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
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
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 护理病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病床
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 病床
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医嘱序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 医嘱序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or_prn() {
		return ((String) getAttrVal("Content_or_prn"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or_prn
	 */
	public void setContent_or_prn(String Content_or_prn) {
		setAttrVal("Content_or_prn", Content_or_prn);
	}
	/**
	 * 医嘱内容（成组用法频次）
	 * @return String
	 */
	public String getContent_or_prn_sub() {
		return ((String) getAttrVal("Content_or_prn_sub"));
	}	
	/**
	 * 医嘱内容（成组用法频次）
	 * @param Content_or_prn_sub
	 */
	public void setContent_or_prn_sub(String Content_or_prn_sub) {
		setAttrVal("Content_or_prn_sub", Content_or_prn_sub);
	}
	/**
	 * 皮试标识
	 * @return String
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	
	/**
	 * 皮试标识
	 * @param Fg_set
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 月_生效日期
	 * @return String
	 */
	public String getDt_effe_m() {
		return ((String) getAttrVal("Dt_effe_m"));
	}	
	/**
	 * 月_生效日期
	 * @param Dt_effe_m
	 */
	public void setDt_effe_m(String Dt_effe_m) {
		setAttrVal("Dt_effe_m", Dt_effe_m);
	}
	/**
	 * 日_生效日期
	 * @return String
	 */
	public String getDt_effe_d() {
		return ((String) getAttrVal("Dt_effe_d"));
	}	
	/**
	 * 日_生效日期
	 * @param Dt_effe_d
	 */
	public void setDt_effe_d(String Dt_effe_d) {
		setAttrVal("Dt_effe_d", Dt_effe_d);
	}
	/**
	 * 时间_生效日期
	 * @return String
	 */
	public String getDt_effe_t() {
		return ((String) getAttrVal("Dt_effe_t"));
	}	
	/**
	 * 时间_生效日期
	 * @param Dt_effe_t
	 */
	public void setDt_effe_t(String Dt_effe_t) {
		setAttrVal("Dt_effe_t", Dt_effe_t);
	}
	/**
	 * 签署医生
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	/**
	 * 签署医生
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署科室
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	/**
	 * 签署科室
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}	
	/**
	 * 核对标识
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 核对执行护士
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 核对执行护士
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 核对病区
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	/**
	 * 核对病区
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 月_结束日期
	 * @return String
	 */
	public String getDt_end_m() {
		return ((String) getAttrVal("Dt_end_m"));
	}	
	/**
	 * 月_结束日期
	 * @param Dt_end_m
	 */
	public void setDt_end_m(String Dt_end_m) {
		setAttrVal("Dt_end_m", Dt_end_m);
	}
	/**
	 * 日_结束日期
	 * @return String
	 */
	public String getDt_end_d() {
		return ((String) getAttrVal("Dt_end_d"));
	}	
	/**
	 * 日_结束日期
	 * @param Dt_end_d
	 */
	public void setDt_end_d(String Dt_end_d) {
		setAttrVal("Dt_end_d", Dt_end_d);
	}
	/**
	 * 时间_结束日期
	 * @return String
	 */
	public String getDt_end_t() {
		return ((String) getAttrVal("Dt_end_t"));
	}	
	/**
	 * 时间_结束日期
	 * @param Dt_end_t
	 */
	public void setDt_end_t(String Dt_end_t) {
		setAttrVal("Dt_end_t", Dt_end_t);
	}
	/**
	 * 停止医生
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}	
	/**
	 * 停止医生
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停止科室
	 * @return String
	 */
	public String getId_dep_stop() {
		return ((String) getAttrVal("Id_dep_stop"));
	}	
	/**
	 * 停止科室
	 * @param Id_dep_stop
	 */
	public void setId_dep_stop(String Id_dep_stop) {
		setAttrVal("Id_dep_stop", Id_dep_stop);
	}
	/**
	 * 停止打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_prn() {
		return ((FBoolean) getAttrVal("Fg_stop_prn"));
	}	
	/**
	 * 停止打印标识
	 * @param Fg_stop_prn
	 */
	public void setFg_stop_prn(FBoolean Fg_stop_prn) {
		setAttrVal("Fg_stop_prn", Fg_stop_prn);
	}
	/**
	 * 停止核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_stop() {
		return ((FBoolean) getAttrVal("Fg_chk_stop"));
	}	
	/**
	 * 停止核对标识
	 * @param Fg_chk_stop
	 */
	public void setFg_chk_stop(FBoolean Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	/**
	 * 停止核对护士
	 * @return String
	 */
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}	
	/**
	 * 停止核对护士
	 * @param Id_emp_chk_stop
	 */
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	/**
	 * 停止核对病区
	 * @return String
	 */
	public String getId_dep_chk_stop() {
		return ((String) getAttrVal("Id_dep_chk_stop"));
	}	
	/**
	 * 停止核对病区
	 * @param Id_dep_chk_stop
	 */
	public void setId_dep_chk_stop(String Id_dep_chk_stop) {
		setAttrVal("Id_dep_chk_stop", Id_dep_chk_stop);
	}
	/**
	 * 作废医生
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 作废医生
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 作废核对护士
	 * @return String
	 */
	public String getId_emp_chk_canc() {
		return ((String) getAttrVal("Id_emp_chk_canc"));
	}	
	/**
	 * 作废核对护士
	 * @param Id_emp_chk_canc
	 */
	public void setId_emp_chk_canc(String Id_emp_chk_canc) {
		setAttrVal("Id_emp_chk_canc", Id_emp_chk_canc);
	}
	/**
	 * 作废打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc_prn() {
		return ((FBoolean) getAttrVal("Fg_canc_prn"));
	}	
	/**
	 * 作废打印标识
	 * @param Fg_canc_prn
	 */
	public void setFg_canc_prn(FBoolean Fg_canc_prn) {
		setAttrVal("Fg_canc_prn", Fg_canc_prn);
	}
	/**
	 * 作废核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}	
	/**
	 * 作废核对标识
	 * @param Fg_chk_canc
	 */
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getLabel_name_emp_sign() {
		return ((String) getAttrVal("Label_name_emp_sign"));
	}	
	/**
	 * 责任医生
	 * @param Label_name_emp_sign
	 */
	public void setLabel_name_emp_sign(String Label_name_emp_sign) {
		setAttrVal("Label_name_emp_sign", Label_name_emp_sign);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getLabel_name_emp_check() {
		return ((String) getAttrVal("Label_name_emp_check"));
	}	
	/**
	 * 责任护士
	 * @param Label_name_emp_check
	 */
	public void setLabel_name_emp_check(String Label_name_emp_check) {
		setAttrVal("Label_name_emp_check", Label_name_emp_check);
	}
	/**
	 * 责任医生签字
	 * @return String
	 */
	public String getStr_emp_sign() {
		return ((String) getAttrVal("Str_emp_sign"));
	}	
	/**
	 * 责任医生签字
	 * @param Str_emp_sign
	 */
	public void setStr_emp_sign(String Str_emp_sign) {
		setAttrVal("Str_emp_sign", Str_emp_sign);
	}
	/**
	 * 责任护士签字
	 * @return String
	 */
	public String getStr_emp_check() {
		return ((String) getAttrVal("Str_emp_check"));
	}	
	/**
	 * 责任护士签字
	 * @param Str_emp_check
	 */
	public void setStr_emp_check(String Str_emp_check) {
		setAttrVal("Str_emp_check", Str_emp_check);
	}
	/**
	 * 责任医生名称拼接字符串
	 * @return String
	 */
	public String getStr_name_emp_sign() {
		return ((String) getAttrVal("Str_name_emp_sign"));
	}	
	/**
	 * 责任医生名称拼接字符串
	 * @param Str_name_emp_sign
	 */
	public void setStr_name_emp_sign(String Str_name_emp_sign) {
		setAttrVal("Str_name_emp_sign", Str_name_emp_sign);
	}
	/**
	 * 责任护士名称拼接字符串
	 * @return String
	 */
	public String getStr_name_emp_check() {
		return ((String) getAttrVal("Str_name_emp_check"));
	}	
	/**
	 * 责任护士名称拼接字符串
	 * @param Str_name_emp_check
	 */
	public void setStr_name_emp_check(String Str_name_emp_check) {
		setAttrVal("Str_name_emp_check", Str_name_emp_check);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 医嘱确认护士
	 * @return String
	 */
	public String getId_emp_exe() {
		return ((String) getAttrVal("Id_emp_exe"));
	}	
	/**
	 * 医嘱确认护士
	 * @param Id_emp_exe
	 */
	public void setId_emp_exe(String Id_emp_exe) {
		setAttrVal("Id_emp_exe", Id_emp_exe);
	}
	/**
	 * 执行人姓名
	 * @return String
	 */
	public String getName_emp_exe() {
		return ((String) getAttrVal("Name_emp_exe"));
	}	
	/**
	 * 执行人姓名
	 * @param Name_emp_exe
	 */
	public void setName_emp_exe(String Name_emp_exe) {
		setAttrVal("Name_emp_exe", Name_emp_exe);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_exe() {
		return ((String) getAttrVal("Id_dep_exe"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_exe
	 */
	public void setId_dep_exe(String Id_dep_exe) {
		setAttrVal("Id_dep_exe", Id_dep_exe);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_exe() {
		return ((String) getAttrVal("Name_dep_exe"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_exe
	 */
	public void setName_dep_exe(String Name_dep_exe) {
		setAttrVal("Name_dep_exe", Name_dep_exe);
	}
	/**
	 * 已重整标识
	 * @return FBoolean
	 */
	public FBoolean getFg_reformed() {
		return ((FBoolean) getAttrVal("Fg_reformed"));
	}	
	/**
	 * 已重整标识
	 * @param Fg_reformed
	 */
	public void setFg_reformed(FBoolean Fg_reformed) {
		setAttrVal("Fg_reformed", Fg_reformed);
	}
	/**
	 * 重整时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reform() {
		return ((FDateTime) getAttrVal("Dt_reform"));
	}	
	/**
	 * 重整时间
	 * @param Dt_reform
	 */
	public void setDt_reform(FDateTime Dt_reform) {
		setAttrVal("Dt_reform", Dt_reform);
	}
	/**
	 * 重整行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_reformrow() {
		return ((FBoolean) getAttrVal("Fg_reformrow"));
	}	
	/**
	 * 重整行标识
	 * @param Fg_reformrow
	 */
	public void setFg_reformrow(FBoolean Fg_reformrow) {
		setAttrVal("Fg_reformrow", Fg_reformrow);
	}
	/**
	 * 打印日期
	 * @return FDateTime
	 */
	public FDateTime getDt_prn() {
		return ((FDateTime) getAttrVal("Dt_prn"));
	}	
	/**
	 * 打印日期
	 * @param Dt_prn
	 */
	public void setDt_prn(FDateTime Dt_prn) {
		setAttrVal("Dt_prn", Dt_prn);
	}
	/**
	 * 所在页码
	 * @return Integer
	 */
	public Integer getPage_num() {
		return ((Integer) getAttrVal("Page_num"));
	}	
	/**
	 * 所在页码
	 * @param Page_num
	 */
	public void setPage_num(Integer Page_num) {
		setAttrVal("Page_num", Page_num);
	}
	/**
	 * 所在行号
	 * @return Integer
	 */
	public Integer getRow_num() {
		return ((Integer) getAttrVal("Row_num"));
	}	
	/**
	 * 所在行号
	 * @param Row_num
	 */
	public void setRow_num(Integer Row_num) {
		setAttrVal("Row_num", Row_num);
	}
	/**
	 * 所占行数
	 * @return Integer
	 */
	public Integer getRow_cnt() {
		return ((Integer) getAttrVal("Row_cnt"));
	}	
	/**
	 * 所占行数
	 * @param Row_cnt
	 */
	public void setRow_cnt(Integer Row_cnt) {
		setAttrVal("Row_cnt", Row_cnt);
	}
	/**
	 * 打印部门
	 * @return String
	 */
	public String getId_dep_prn() {
		return ((String) getAttrVal("Id_dep_prn"));
	}	
	/**
	 * 打印部门
	 * @param Id_dep_prn
	 */
	public void setId_dep_prn(String Id_dep_prn) {
		setAttrVal("Id_dep_prn", Id_dep_prn);
	}
	/**
	 * 打印人员
	 * @return String
	 */
	public String getId_emp_prn() {
		return ((String) getAttrVal("Id_emp_prn"));
	}	
	/**
	 * 打印人员
	 * @param Id_emp_prn
	 */
	public void setId_emp_prn(String Id_emp_prn) {
		setAttrVal("Id_emp_prn", Id_emp_prn);
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
	 * 签署医生（电子签名）
	 * @return byte[]
	 */
	public byte[] getPic_emp_sign() {
		return ((byte[]) getAttrVal("Pic_emp_sign"));
	}	
	/**
	 * 签署医生（电子签名）
	 * @param Pic_emp_sign
	 */
	public void setPic_emp_sign(byte[] Pic_emp_sign) {
		setAttrVal("Pic_emp_sign", Pic_emp_sign);
	}
	/**
	 * 核对护士（电子签名）
	 * @return byte[]
	 */
	public byte[] getPic_emp_chk() {
		return ((byte[]) getAttrVal("Pic_emp_chk"));
	}	
	/**
	 * 核对护士（电子签名）
	 * @param Pic_emp_chk
	 */
	public void setPic_emp_chk(byte[] Pic_emp_chk) {
		setAttrVal("Pic_emp_chk", Pic_emp_chk);
	}
	/**
	 * 停止医生（电子签名）
	 * @return byte[]
	 */
	public byte[] getPic_emp_stop() {
		return ((byte[]) getAttrVal("Pic_emp_stop"));
	}	
	/**
	 * 停止医生（电子签名）
	 * @param Pic_emp_stop
	 */
	public void setPic_emp_stop(byte[] Pic_emp_stop) {
		setAttrVal("Pic_emp_stop", Pic_emp_stop);
	}
	/**
	 * 停止核对护士(电子签名)
	 * @return byte[]
	 */
	public byte[] getPic_emp_chk_stop() {
		return ((byte[]) getAttrVal("Pic_emp_chk_stop"));
	}	
	/**
	 * 停止核对护士(电子签名)
	 * @param Pic_emp_chk_stop
	 */
	public void setPic_emp_chk_stop(byte[] Pic_emp_chk_stop) {
		setAttrVal("Pic_emp_chk_stop", Pic_emp_chk_stop);
	}
	/**
	 * 停止核对时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_stop() {
		return ((FDateTime) getAttrVal("Dt_chk_stop"));
	}	
	/**
	 * 停止核对时间
	 * @param Dt_chk_stop
	 */
	public void setDt_chk_stop(FDateTime Dt_chk_stop) {
		setAttrVal("Dt_chk_stop", Dt_chk_stop);
	}
	/**
	 * 皮试标识打印标志
	 * @return FBoolean
	 */
	public FBoolean getFg_skin_prn() {
		return ((FBoolean) getAttrVal("Fg_skin_prn"));
	}	
	/**
	 * 皮试标识打印标志
	 * @param Fg_skin_prn
	 */
	public void setFg_skin_prn(FBoolean Fg_skin_prn) {
		setAttrVal("Fg_skin_prn", Fg_skin_prn);
	}
	/**
	 * 核对时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核对时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 医嘱执行护士（电子签名）
	 * @return byte[]
	 */
	public byte[] getPic_emp_exe() {
		return ((byte[]) getAttrVal("Pic_emp_exe"));
	}	
	/**
	 * 医嘱执行护士（电子签名）
	 * @param Pic_emp_exe
	 */
	public void setPic_emp_exe(byte[] Pic_emp_exe) {
		setAttrVal("Pic_emp_exe", Pic_emp_exe);
	}
	/**
	 * 签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	/**
	 * 签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 皮试结果
	 * @return String
	 */
	public String getContent_or_prn_skintest() {
		return ((String) getAttrVal("Content_or_prn_skintest"));
	}	
	/**
	 * 皮试结果
	 * @param Content_or_prn_skintest
	 */
	public void setContent_or_prn_skintest(String Content_or_prn_skintest) {
		setAttrVal("Content_or_prn_skintest", Content_or_prn_skintest);
	}
	/**
	 * 横线续打不显示
	 * @return String
	 */
	public String getLine() {
		return ((String) getAttrVal("Line"));
	}	
	/**
	 * 横线续打不显示
	 * @param Line
	 */
	public void setLine(String Line) {
		setAttrVal("Line", Line);
	}
	/**
	 * 医生签字（页尾标题）
	 * @return String
	 */
	public String getLabel_name_emp_sign_new() {
		return ((String) getAttrVal("Label_name_emp_sign_new"));
	}	
	/**
	 * 医生签字（页尾标题）
	 * @param Label_name_emp_sign_new
	 */
	public void setLabel_name_emp_sign_new(String Label_name_emp_sign_new) {
		setAttrVal("Label_name_emp_sign_new", Label_name_emp_sign_new);
	}
	/**
	 * 护士签字（页尾标题）
	 * @return String
	 */
	public String getLabel_name_emp_check_new() {
		return ((String) getAttrVal("Label_name_emp_check_new"));
	}	
	/**
	 * 护士签字（页尾标题）
	 * @param Label_name_emp_check_new
	 */
	public void setLabel_name_emp_check_new(String Label_name_emp_check_new) {
		setAttrVal("Label_name_emp_check_new", Label_name_emp_check_new);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat_en() {
		return ((String) getAttrVal("Name_pat_en"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat_en
	 */
	public void setName_pat_en(String Name_pat_en) {
		setAttrVal("Name_pat_en", Name_pat_en);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_pat_en() {
		return ((String) getAttrVal("Code_pat_en"));
	}	
	/**
	 * 就诊编码
	 * @param Code_pat_en
	 */
	public void setCode_pat_en(String Code_pat_en) {
		setAttrVal("Code_pat_en", Code_pat_en);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 编码
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床位编码
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床位编码
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床位名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_sign
	 */
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	/**
	 * 编码
	 * @param Code_dep_sign
	 */
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	/**
	 * 名称
	 * @param Name_dep_sign
	 */
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_chk() {
		return ((String) getAttrVal("Code_emp_chk"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_chk
	 */
	public void setCode_emp_chk(String Code_emp_chk) {
		setAttrVal("Code_emp_chk", Code_emp_chk);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_chk
	 */
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_chk() {
		return ((String) getAttrVal("Code_dep_chk"));
	}	
	/**
	 * 编码
	 * @param Code_dep_chk
	 */
	public void setCode_dep_chk(String Code_dep_chk) {
		setAttrVal("Code_dep_chk", Code_dep_chk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}	
	/**
	 * 名称
	 * @param Name_dep_chk
	 */
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_stop() {
		return ((String) getAttrVal("Code_emp_stop"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_stop
	 */
	public void setCode_emp_stop(String Code_emp_stop) {
		setAttrVal("Code_emp_stop", Code_emp_stop);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_stop
	 */
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_stop() {
		return ((String) getAttrVal("Code_dep_stop"));
	}	
	/**
	 * 编码
	 * @param Code_dep_stop
	 */
	public void setCode_dep_stop(String Code_dep_stop) {
		setAttrVal("Code_dep_stop", Code_dep_stop);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_stop() {
		return ((String) getAttrVal("Name_dep_stop"));
	}	
	/**
	 * 名称
	 * @param Name_dep_stop
	 */
	public void setName_dep_stop(String Name_dep_stop) {
		setAttrVal("Name_dep_stop", Name_dep_stop);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_chk_stop() {
		return ((String) getAttrVal("Code_emp_chk_stop"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_chk_stop
	 */
	public void setCode_emp_chk_stop(String Code_emp_chk_stop) {
		setAttrVal("Code_emp_chk_stop", Code_emp_chk_stop);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_chk_stop() {
		return ((String) getAttrVal("Name_emp_chk_stop"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_chk_stop
	 */
	public void setName_emp_chk_stop(String Name_emp_chk_stop) {
		setAttrVal("Name_emp_chk_stop", Name_emp_chk_stop);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_chk_stop() {
		return ((String) getAttrVal("Code_dep_chk_stop"));
	}	
	/**
	 * 编码
	 * @param Code_dep_chk_stop
	 */
	public void setCode_dep_chk_stop(String Code_dep_chk_stop) {
		setAttrVal("Code_dep_chk_stop", Code_dep_chk_stop);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_chk_stop() {
		return ((String) getAttrVal("Name_dep_chk_stop"));
	}	
	/**
	 * 名称
	 * @param Name_dep_chk_stop
	 */
	public void setName_dep_chk_stop(String Name_dep_chk_stop) {
		setAttrVal("Name_dep_chk_stop", Name_dep_chk_stop);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_canc() {
		return ((String) getAttrVal("Code_emp_canc"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_canc
	 */
	public void setCode_emp_canc(String Code_emp_canc) {
		setAttrVal("Code_emp_canc", Code_emp_canc);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_chk_canc() {
		return ((String) getAttrVal("Code_emp_chk_canc"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_chk_canc
	 */
	public void setCode_emp_chk_canc(String Code_emp_chk_canc) {
		setAttrVal("Code_emp_chk_canc", Code_emp_chk_canc);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_chk_canc() {
		return ((String) getAttrVal("Name_emp_chk_canc"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_chk_canc
	 */
	public void setName_emp_chk_canc(String Name_emp_chk_canc) {
		setAttrVal("Name_emp_chk_canc", Name_emp_chk_canc);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_prn() {
		return ((String) getAttrVal("Code_dep_prn"));
	}	
	/**
	 * 编码
	 * @param Code_dep_prn
	 */
	public void setCode_dep_prn(String Code_dep_prn) {
		setAttrVal("Code_dep_prn", Code_dep_prn);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_prn() {
		return ((String) getAttrVal("Name_dep_prn"));
	}	
	/**
	 * 名称
	 * @param Name_dep_prn
	 */
	public void setName_dep_prn(String Name_dep_prn) {
		setAttrVal("Name_dep_prn", Name_dep_prn);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_prn() {
		return ((String) getAttrVal("Code_emp_prn"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_prn
	 */
	public void setCode_emp_prn(String Code_emp_prn) {
		setAttrVal("Code_emp_prn", Code_emp_prn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_prn() {
		return ((String) getAttrVal("Name_emp_prn"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_prn
	 */
	public void setName_emp_prn(String Name_emp_prn) {
		setAttrVal("Name_emp_prn", Name_emp_prn);
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
		return "Id_orprn";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_prn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdPrintDODesc.class);
	}
	
}