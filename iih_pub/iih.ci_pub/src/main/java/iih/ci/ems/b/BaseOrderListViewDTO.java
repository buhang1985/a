package iih.ci.ems.b;

import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * @author wangqingzhu
 *
 * @date 2019年8月14日下午6:17:23
 *
 * @classpath iih.ci.ord.dws.basis.BaseOrderListViewDTO
 *
 * 写明类文件描述
 * 
 */
public class BaseOrderListViewDTO extends BaseEmsViewDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ANTI_DRUG_LEVEL_NONE = "0"; // 非抗菌药
	public static final String ANTI_DRUG_LEVEL_1 = "1"; // 非抗菌药
	public static final String ANTI_DRUG_LEVEL_2 = "2"; // 非抗菌药
	public static final String ANTI_DRUG_LEVEL_3 = "3"; // 非抗菌药
	public static final String ANTI_DRUG_LEVEL_4 = "4"; // 非抗菌药
	public static final String ANTI_DRUG_LEVEL_OTHER = "99"; // 非抗菌药
	
	/**
	 * 医嘱来源方式类型
	 * @return
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源方式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	
	/**
	 * 服务来源
	 * @return
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}	
	
	/**
	 * 服务来源
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	
	/**
	 * 是否多次执行
	 * @return
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}
	/**
	 * 是否多次执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	
	/**
	 * 是否多剂量
	 * @return
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}
	/**
	 * 是否多剂量
	 * @param Ismulexec
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/**
	 * 总量开单方式
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}
	/**
	 * 总量开单方式
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * 
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	
	/**
	 * 科研用药ID
	 * @return
	 */
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	/**
	 * 科研用药ID
	 * @param Id_researchproject
	 */
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
	/**
	 * 科研用药编码
	 * @return
	 */
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}	
	/**
	 * 科研用药编码
	 * @param Code_researchproject
	 */
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	/**
	 * 科研用药名称
	 * @return
	 */
	public String getName_researchproject() {
		return ((String) getAttrVal("Name_researchproject"));
	}	
	/**
	 * 科研用药名称
	 * @param Name_researchproject
	 */
	public void setName_researchproject(String Name_researchproject) {
		setAttrVal("Name_researchproject", Name_researchproject);
	}
	/**
	 * 科研用药密码
	 * @return
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}	
	/**
	 * 科研用药密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 医嘱类型Id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱类型Id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	
	/**
	 * 对应关联医嘱id_or
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 对应关联医嘱id_or
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 关联类型编码
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}
	/**
	 * 关联类型编码
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}	
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	
	/**
	 * 可使用标识-当前就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_use() {
		return ((FBoolean) getAttrVal("Fg_use"));
	}
	/**
	 * 可使用标识-当前就诊类型
	 * @param Fg_use
	 */
	public void setFg_use(FBoolean Fg_use) {
		setAttrVal("Fg_use", Fg_use);
	}
	
	
	/**
	 * 皮试服务id
	 * @return String
	 */
	public String getId_srvskin() {
		return ((String) getAttrVal("Id_srvskin"));
	}
	/**
	 * 皮试服务id
	 * @param Id_srvskin
	 */
	public void setId_srvskin(String Id_srvskin) {
		setAttrVal("Id_srvskin", Id_srvskin);
	}
	
	/**
	 * 扩展信息集合
	 * @return
	 */
	public FArrayList getExtInfoList(){
		return (FArrayList)getAttrVal("ExtInfoList"); 
	}
	/**
	 * 扩展信息集合
	 * @param EmsExtInfoList
	 */
	public void setExtInfoList(FArrayList ExtInfoList ){
		setAttrVal("ExtInfoList", ExtInfoList);  
	}
	/**
	 * 记账状态
	 * @return
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}           
	/**
	 * 记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 医嘱执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 医嘱执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 医保判断
	 * @return
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}
	/**
	 * 医保判断
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	/**
	 * ci_order 医保自费标识true 医保，false 自费
	 * @return FBoolean
	 */
	public FBoolean getFg_orhp() {
		return ((FBoolean) getAttrVal("Fg_orhp"));
	}
	/**
	 * ci_order 医保自费标识true 医保，false 自费
	 * @param Fg_or
	 */
	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}
	/**
	 * 临床路径判断
	 * @return
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}
	/**
	 * 临床路径判断
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 检查检验结果
	 * @return
	 */
	public String getSd_orrsttp() {
		return ((String) getAttrVal("Sd_orrsttp"));
	}
	/**
	 * 检查检验结果
	 * @param Sd_orrsttp
	 */
	public void setSd_orrsttp(String Sd_orrsttp) {
		setAttrVal("Sd_orrsttp", Sd_orrsttp);
	}
	/**
	 * ci_or_srv 临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * ci_or_srv 临床标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 服务套项目单选限制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_setradio() {
		return ((FBoolean) getAttrVal("Fg_setradio"));
	}
	/**
	 * 服务套项目单选限制标识
	 * @param Fg_setradio
	 */
	public void setFg_setradio(FBoolean Fg_setradio) {
		setAttrVal("Fg_setradio", Fg_setradio);
	}
	/**
	 * ci_or_srv 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * ci_or_srv 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 停止标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 停止标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 就诊类型编码
	 * @return
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
	 * 药师审核状态
	 * @return Integer
	 */
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}
	/**
	 * 药师审核状态
	 * @param Eu_verify_pharm
	 */
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	

	
	
	/**
	 * 定价模式
	 * @return
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	
	/**
	 * 服务总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	
	/**
	 * 医疗单ID
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}
	/**
	 * 医疗单ID
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
	}
	/**
	 * 是否短流程
	 * @return String
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}
	/**
	 * 是否短流程
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	
	/**
	 * 剂量单位集合
	 * @return String
	 */
	public FArrayList getDoseUnitList() {
		return ((FArrayList) getAttrVal("DoseUnitList"));
	}
	/**
	 * 剂量单位集合
	 * @param DoseUnitList
	 */
	public void setDoseUnitList(FArrayList DoseUnitList) {
		setAttrVal("DoseUnitList", DoseUnitList);
	}
	/**
	 * 付数无关标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	/**
	 * 付数无关标志
	 * @param Fg_nothingwithorders
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	
	/**
	 * 总量单位集合
	 * @return String
	 */
	public FArrayList getTotalUnitList() {
		return ((FArrayList) getAttrVal("TotalUnitList"));
	}
	/**
	 * 总量单位集合
	 * @param TotalUnitList
	 */
	public void setTotalUnitList(FArrayList TotalUnitList) {
		setAttrVal("TotalUnitList", TotalUnitList);
	}
	
	/**
	 * 医学基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 医学基本换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 当前基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}
	/**
	 * 当前基本换算系数
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}
	/**
	 * 基本包装单位
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}
	/**
	 *基本包装单位名称
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}
	/**
	 * 基本包装单位名称
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}
	
	/**
	 * 用户当前选择剂量单位
	 * @return
	 */
	public FDouble getQuan_medu_cur() {
		return ((FDouble) getAttrVal("Quan_medu_cur"));
	}	
	/**
	 * 用户当前选择剂量单位
	 * @param Quan_medu_cur
	 */
	public void setQuan_medu_cur(FDouble Quan_medu_cur) {
		setAttrVal("Quan_medu_cur", Quan_medu_cur);
	}
	/**
	 * 用户当前选择剂量单位
	 * @return
	 */
	public String getId_medu_cur() {
		return ((String) getAttrVal("Id_medu_cur"));
	}	
	/**
	 * 用户当前选择剂量单位
	 * @param Id_medu_cur
	 */
	public void setId_medu_cur(String Id_medu_cur) {
		setAttrVal("Id_medu_cur", Id_medu_cur);
	}
	/**
	 * 用户当前选择剂量单位
	 * @return
	 */
	public String getName_medu_cur() {
		return ((String) getAttrVal("Name_medu_cur"));
	}	
	/**
	 * 用户当前选择剂量单位
	 * @param Id_medu_cur
	 */
	public void setName_medu_cur(String Name_medu_cur) {
		setAttrVal("Name_medu_cur", Name_medu_cur);
	}
	/**
	 * 用户当前选择剂量单位
	 * @return
	 */
	public FDouble getFactor_cur() {
		return ((FDouble) getAttrVal("Factor_cur"));
	}
	
	/**
	 * 
	 * @param Factor_cur
	 */
	public void setFactor_cur(FDouble Factor_cur) {
		setAttrVal("Factor_cur", Factor_cur);
	}
	/***
	 * 医嘱排序号
	 * @return
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/***
	 * 医嘱排序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/***
	 * 医嘱服务排序号
	 * @param Sortno_srv
	 */
	public void setSortno_srv(Integer Sortno_srv) {
		setAttrVal("Sortno_srv", Sortno_srv);
	}
	/***
	 * 医嘱服务排序号
	 * @return
	 */
	public Integer getSortno_srv() {
		return ((Integer) getAttrVal("Sortno_srv"));
	}	
	
	/**
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 麻醉分类(手术)
	 * @return Integer
	 */
	public Integer getEu_anseca() {
		return ((Integer) getAttrVal("Eu_anseca"));
	}
	/**
	 * 麻醉分类(手术)
	 * @param Eu_anseca
	 */
	public void setEu_anseca(Integer Eu_anseca) {
		setAttrVal("Eu_anseca", Eu_anseca);
	}
	/**
	 * 手术期限编码
	 * @return String
	 */
	public String getSd_datelimittype() {
		return ((String) getAttrVal("Sd_datelimittype"));
	}
	/**
	 * 手术期限编码
	 * @param Sd_datelimittype
	 */
	public void setSd_datelimittype(String Sd_datelimittype) {
		setAttrVal("Sd_datelimittype", Sd_datelimittype);
	}
	
	/**
	 * 加急可使用标识
	 * @return
	 */
	public FBoolean getFg_urgent_edit() {
		return ((FBoolean) getAttrVal("Fg_urgent_edit"));
	}
	/**
	 * 加急可使用标识
	 * @param Fg_urgent_edit
	 */
	public void setFg_urgent_edit(FBoolean Fg_urgent_edit) {
		setAttrVal("Fg_urgent_edit", Fg_urgent_edit);
	}
	
	/**
	 * 医嘱描述描述
	 * @return
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 医嘱描述描述
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}

	/**
	 * 第二次配液标志
	 * @return FBoolean
	 */
	public FBoolean getFg_secadmt() {
		return ((FBoolean) getAttrVal("Fg_secadmt"));
	}
	/**
	 * 第二次配液标志
	 * @param Fg_secadmt
	 */
	public void setFg_secadmt(FBoolean Fg_secadmt) {
		setAttrVal("Fg_secadmt", Fg_secadmt);
	}
	

	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes_srv() {
		return ((String) getAttrVal("Name_routedes_srv"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes_srv
	 */
	public void setName_routedes_srv(String Name_routedes_srv) {
		setAttrVal("Name_routedes_srv", Name_routedes_srv);
	}
	/**
	 * 用法要求ID
	 * @return String
	 */
	public String getId_routedes_srv() {
		return ((String) getAttrVal("Id_routedes_srv"));
	}
	/**
	 * 用法要求ID
	 * @param Id_routedes_srv
	 */
	public void setId_routedes_srv(String Id_routedes_srv) {
		setAttrVal("Id_routedes_srv", Id_routedes_srv);
	}
	
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
	}
	
	/**
	 * 抗菌药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_anti() {
		return ((FBoolean) getAttrVal("Fg_anti"));
	}
	/**
	 * 抗菌药标识
	 * @param Fg_anti
	 */
	public void setFg_anti(FBoolean Fg_anti) {
		setAttrVal("Fg_anti", Fg_anti);
	}
	
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
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
	 * 开单科室ID
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室ID
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}

	/**
	 * 频次显示名称
	 * @return String
	 */
	public String getCode_disp_freq() {
		return ((String) getAttrVal("Code_disp_freq"));
	}
	/**
	 * 频次显示名称
	 * @param Code_disp_freq
	 */
	public void setCode_disp_freq(String Code_disp_freq) {
		setAttrVal("Code_disp_freq", Code_disp_freq);
	}

	/**
	 * 拒绝确认类型
	 * @return
	 */
	public String getEu_refusechecktp() {
		return ((String) getAttrVal("Eu_refusechecktp"));
	}	
	/**
	 * 拒绝确认类型
	 * @param Eu_refusechecktp
	 */
	public void setEu_refusechecktp(String Eu_refusechecktp) {
		setAttrVal("Eu_refusechecktp", Eu_refusechecktp);
	}
	
	/**
	 * 是否需要特殊级抗菌药审批
	 * @return FBoolean
	 */
	public FBoolean getFg_spec_anti_approve() {
		return ((FBoolean) getAttrVal("Fg_spec_anti_approve"));
	}
	/**
	 * 是否需要特殊级抗菌药审批
	 * @param fg_spec_anti_approve
	 */
	public void setFg_spec_anti_approve(FBoolean fg_spec_anti_approve) {
		setAttrVal("Fg_spec_anti_approve", fg_spec_anti_approve);
	}
	/**
	 * 套内项目服务id
	 * @return String
	 */
	public String getFilter_set_item() {
		return ((String) getAttrVal("Filter_set_item"));
	}
	/**
	 * 套内项目服务id
	 * @param Filter_set_item
	 */
	public void setFilter_set_item(String Filter_set_item) {
		setAttrVal("Filter_set_item", Filter_set_item);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}
	/**
	 * 物品分类
	 * @param Id_mmtp
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	
	/**
	 * 最大用药天数
	 * @return
	 */
	public Integer getMax_days() {
		return ((Integer) getAttrVal("Max_days"));
	}	
	
	/**
	 * 最大用药天数
	 * @param Max_days
	 */
	public void setMax_days(Integer Max_days) {
		setAttrVal("Max_days", Max_days);
	}
	
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 是否已补临时医嘱标识
	 * @return
	 */
	public FBoolean getFg_supplementtemp() {
		return ((FBoolean) getAttrVal("Fg_supplementtemp"));
	}	
	/**
	 * 是否已补临时医嘱标识
	 * @param Fg_supplementtemp
	 */
	public void setFg_supplementtemp(FBoolean Fg_supplementtemp) {
		setAttrVal("Fg_supplementtemp", Fg_supplementtemp);
	}
	/**
	 * 是否已计算费用项目
	 * @return
	 */
	public FBoolean getFg_prisrvhandled() {
		return ((FBoolean) getAttrVal("Fg_prisrvhandled"));
	}	
	/**
	 * 是否已计算费用项目
	 * @param Fg_prisrvhandled
	 */
	public void setFg_prisrvhandled(FBoolean Fg_prisrvhandled) {
		setAttrVal("Fg_prisrvhandled", Fg_prisrvhandled);
	}
	/**
	 * 所属来源服务ID
	 * @return Id_srv_src
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 所属来源服务ID
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 费用项是否可编辑
	 * @return
	 */
	public FBoolean getFg_feeinfoedit() {
		return ((FBoolean) getAttrVal("Fg_feeinfoedit"));
	}
	/**
	 * 费用项是否可编辑
	 * @param Fg_feeinfoedit
	 */
	public void setFg_feeinfoedit(FBoolean Fg_feeinfoedit) {
		setAttrVal("Fg_feeinfoedit", Fg_feeinfoedit);
	}
	/**
	 * 费用信息集合
	 * @return
	 */
	public FArrayList getFeeInfoList(){
		return (FArrayList)getAttrVal("FeeInfoList"); 
	}
	/**
	 * 费用信息集合
	 * @param FeeInfoList
	 */
	public void setFeeInfoList(FArrayList FeeInfoList ){
		setAttrVal("FeeInfoList", FeeInfoList);  
	}
	/**
	 * 副本信息
	 * @return
	 */
	public OrderListViewDTO getOrderListCopyInfo() {
		return ((OrderListViewDTO) getAttrVal("OrderListCopyInfo"));
	}	
	/**
	 * 副本信息
	 * @param orderListCopyInfo
	 */
	public void setOrderListCopyInfo(BaseOrderListViewDTO orderListCopyInfo) {
		setAttrVal("OrderListCopyInfo", orderListCopyInfo);
	}
	/**
	 * 医保
	 * @return String
	 */
	public String getIshpsrvorca() {
		return ((String) getAttrVal("Ishpsrvorca"));
	}
	/**
	 * 医保
	 * @param Ishpsrvorca
	 */
	public void setIshpsrvorca(String Ishpsrvorca) {
		setAttrVal("Ishpsrvorca", Ishpsrvorca);
	}
	/**
	 * 自付比例
	 * @return String
	 */
	public String getRatio_self() {
		return ((String) getAttrVal("Ratio_self"));
	}
	/**
	 * 自付比例
	 * @param Ratio_self
	 */
	public void setRatio_self(String Ratio_self) {
		setAttrVal("Ratio_self", Ratio_self);
	}
	/**
	 * 自付金额
	 * @return String
	 */
	public String getAmt_self() {
		return ((String) getAttrVal("Amt_self"));
	}
	/**
	 * 自付金额
	 * @param Amt_slef
	 */
	public void setAmt_self(String Amt_self) {
		setAttrVal("Amt_self", Amt_self);
	}
	
	/**
	 * 开立医生ID
	 * 
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}

	/**
	 * 开立医生ID
	 * 
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	
	/**
	 * 开立治疗方案医生ID
	 * 
	 * @return String
	 */
	public String getId_emp_scheme() {
		return ((String) getAttrVal("Id_emp_scheme"));
	}

	/**
	 * 开立开立治疗方案医生ID
	 * 
	 * @param Id_emp_or
	 */
	public void setId_emp_scheme(String Id_emp_scheme) {
		setAttrVal("Id_emp_scheme", Id_emp_scheme);
	}

	/**
	 * 开立医生
	 * 
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}

	/**
	 * 开立医生
	 * 
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}

	/**
	 * 医嘱状态编码(扩展)
	 * 
	 * @return String
	 */
	public String getSd_su_or_ext() {
		return ((String) getAttrVal("Sd_su_or_ext"));
	}

	/**
	 * 医嘱状态编码(扩展)
	 * 
	 * @param Sd_su_or_ext
	 */
	public void setSd_su_or_ext(String Sd_su_or_ext) {
		setAttrVal("Sd_su_or_ext", Sd_su_or_ext);
	}

	/**
	 * 医嘱皮试标识（皮试医嘱）
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest_ord() {
		return ((FBoolean) getAttrVal("Fg_skintest_ord"));
	}

	/**
	 * 医嘱皮试标识（皮试医嘱）
	 * 
	 * @param Fg_skintest_ord
	 */
	public void setFg_skintest_ord(FBoolean Fg_skintest_ord) {
		setAttrVal("Fg_skintest_ord", Fg_skintest_ord);
	}
	
	/**
	 * 是否计划内
	 * 
	 * @param Fg_plan
	 */
	public void setFg_plan(FBoolean Fg_plan) {
		setAttrVal("Fg_plan", Fg_plan);
	}

	/**
	 * 是否计划内
	 * 
	 * @param Fg_plan
	 */
	public FBoolean getFg_plan() {
		return ((FBoolean) getAttrVal("Fg_plan"));
	}

	/**
	 * 非计划原因
	 * 
	 * @param Unplannedcause_sug
	 */
	public void setUnplannedcause_sug(String Unplannedcause_sug) {
		setAttrVal("Unplannedcause_sug", Unplannedcause_sug);
	}

	/**
	 * 非计划原因
	 * 
	 * @param Unplannedcause_sug
	 */
	public String getUnplannedcause_sug() {
		return ((String) getAttrVal("Unplannedcause_sug"));
	}
	
	

	/**
	 * 领药方式
	 * 
	 * @return String
	 */
	public String getId_drugdeliverymethod() {
		return ((String) getAttrVal("Id_drugdeliverymethod"));
	}

	/**
	 * 领药方式
	 * 
	 * @param Id_drugdeliverymethod
	 */
	public void setId_drugdeliverymethod(String Id_drugdeliverymethod) {
		setAttrVal("Id_drugdeliverymethod", Id_drugdeliverymethod);
	}

	/**
	 * 领药方式
	 * 
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}

	/**
	 * 领药方式
	 * 
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}

	/**
	 * 领药方式
	 * 
	 * @return String
	 */
	public String getName_drugdeliverymethod() {
		return ((String) getAttrVal("Name_drugdeliverymethod"));
	}

	/**
	 * 领药方式
	 * 
	 * @param Name_drugdeliverymethod
	 */
	public void setName_drugdeliverymethod(String Name_drugdeliverymethod) {
		setAttrVal("Name_drugdeliverymethod", Name_drugdeliverymethod);
	}

	/**
	 * 在院整领
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}

	/**
	 * 在院整领
	 * 
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}

	/**
	 * 医嘱列表显示金额
	 * 
	 * @return FDouble
	 */
	public FDouble getTotalprice() {
		return ((FDouble) getAttrVal("Totalprice"));
	}

	/**
	 * 医嘱列表显示金额
	 * 
	 * @param Totalprice
	 */
	public void setTotalprice(FDouble Totalprice) {
		setAttrVal("Totalprice", Totalprice);
	}
	
	/**
	 * 抗菌药级别
	 * @return String
	 */
	public String getSd_anti_lv() {
		return ((String) getAttrVal("Sd_anti_lv"));
	}	
	/**
	 * 抗菌药级别
	 * @param Sd_anti_lv
	 */
	public void setSd_anti_lv(String Sd_anti_lv) {
		setAttrVal("Sd_anti_lv", Sd_anti_lv);
	}
}
