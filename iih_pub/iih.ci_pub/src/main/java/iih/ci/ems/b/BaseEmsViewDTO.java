package iih.ci.ems.b;

import iih.ci.ord.i.common.EmsDriverInfo;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 所以业务医疗单基类
 * @author wangqingzhu
 *
 */
public class BaseEmsViewDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 医嘱服务IdsrvIdmm
	 * @return IdsrvIdmm
	 */
	public String getIdsrvIdmm() {
		return ((String) getAttrVal("IdsrvIdmm"));
	}
	/**
	 * 医嘱服务IdsrvIdmm
	 * @param IdsrvIdmm
	 */
	public void setIdsrvIdmm(String IdsrvIdmm) {
		setAttrVal("IdsrvIdmm", IdsrvIdmm);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务ca
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务ca
	 * @param Id_srv
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医嘱名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 医嘱类型
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	 * 单选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_radio() {
		return ((FBoolean) getAttrVal("Fg_radio"));
	}
	/**
	 * 单选标识
	 * @param Fg_radio
	 */
	public void setFg_radio(FBoolean Fg_radio) {
		setAttrVal("Fg_radio", Fg_radio);
	}
	
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 剂量单位ID
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 剂量单位ID
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	
	/**
	 * 总量_当前
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}

	/**
	 * 总量_当前
	 * 
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}

	/**
	 * 总量单位ID
	 * 
	 * @return String
	 */
	public String getId_unit_cur() {
		return ((String) getAttrVal("Id_unit_cur"));
	}

	/**
	 * 总量单位ID
	 * 
	 * @param Id_unit_cur
	 */
	public void setId_unit_cur(String Id_unit_cur) {
		setAttrVal("Id_unit_cur", Id_unit_cur);
	}

	/**
	 * 总量单位
	 * 
	 * @return String
	 */
	public String getName_unit_cur() {
		return ((String) getAttrVal("Name_unit_cur"));
	}

	/**
	 * 总量单位
	 * 
	 * @param Name_unit_cur
	 */
	public void setName_unit_cur(String Name_unit_cur) {
		setAttrVal("Name_unit_cur", Name_unit_cur);
	}

	/**
	 * 总金额
	 * 
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}

	/**
	 * 总金额
	 * 
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	
	/**
	 * 取整模式
	 * 
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}

	/**
	 * 取整模式
	 * 
	 * @param Sd_mupkgutp
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}
	
	/**
	 * 加急标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}

	/**
	 * 加急标识
	 * 
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	
	/**
	 * 是否自备药
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}

	/**
	 * 是否自备药
	 * 
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}

	/**
	 * 自费标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}

	/**
	 * 自费标识
	 * 
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	
	/**
	 * 适应症标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}

	/**
	 * 适应症标识
	 * 
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}

	/**
	 * 出院带药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}

	/**
	 * 出院带药标识
	 * 
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	
	/**
	 * 服务皮试标识（需皮试的药品）
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest_srv() {
		return ((FBoolean) getAttrVal("Fg_skintest_srv"));
	}

	public void setFg_skintest_srv(FBoolean Fg_skintest_srv) {
		setAttrVal("Fg_skintest_srv", Fg_skintest_srv);
	}
	
	/**
	 * 折扣价格
	 * 
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}

	/**
	 * 折扣价格
	 * 
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}

	/**
	 * 标准价格
	 * 
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}

	/**
	 * 标准价格
	 * 
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}

	/**
	 * 不摆药类型
	 * 
	 * @return String
	 */
	public String getId_nodispense() {
		return ((String) getAttrVal("Id_nodispense"));
	}

	/**
	 * 不摆药类型
	 * 
	 * @param Sd_nodispense
	 */
	public void setId_nodispense(String Id_nodispense) {
		setAttrVal("Id_nodispense", Id_nodispense);
	}

	/**
	 * 不摆药类型
	 * 
	 * @return String
	 */
	public String getName_nodispense() {
		return ((String) getAttrVal("Name_nodispense"));
	}

	/**
	 * 不摆药类型
	 * 
	 * @param Sd_nodispense
	 */
	public void setName_nodispense(String Name_nodispense) {
		setAttrVal("Name_nodispense", Name_nodispense);
	}

	/**
	 * 不摆药类型
	 * 
	 * @return String
	 */
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}

	/**
	 * 不摆药类型
	 * 
	 * @param Sd_nodispense
	 */
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	
	/**
	 * 外配药
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}
	/**
	 * 外配药
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	
	/**
	 * 抗菌药手术预防用切口等级编码
	 * 
	 * @return String
	 */
	public String getSd_preincitp() {
		return ((String) getAttrVal("Sd_preincitp"));
	}

	/**
	 * 抗菌药手术预防用切口等级编码
	 * 
	 * @param Sd_preincitp
	 */
	public void setSd_preincitp(String Sd_preincitp) {
		setAttrVal("Sd_preincitp", Sd_preincitp);
	}


	/**
	 * 备注
	 * 
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}

	/**
	 * 备注
	 * 
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	
	/**
	 * 物品id
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品code
	 * @return
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 物品code
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 换算系数_医基
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 换算系数_医基
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 换算系数_当前
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}
	/**
	 * 换算系数_当前
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}
	/**
	 * 频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 频次数量
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 频次周期类型SD
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次周期类型SD
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
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
	 * 长临标识是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_long_edit() {
		return ((FBoolean) getAttrVal("Fg_long_edit"));
	}
	/**
	 * 长临标识是否可编辑
	 * @param Fg_long_edit
	 */
	public void setFg_long_edit(FBoolean Fg_long_edit) {
		setAttrVal("Fg_long_edit", Fg_long_edit);
	}
	
	/**
	 * 剂型ID
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂型ID
	 * @param Id_route
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	
	/**
	 * 毒麻类型
	 * 
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}

	/**
	 * 毒麻类型
	 * 
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法ID
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法过滤条件
	 * @return String
	 */
	public String getFilter_route() {
		return ((String) getAttrVal("Filter_route"));
	}
	/**
	 * 用法过滤条件
	 * @param Filter_route
	 */
	public void setFilter_route(String Filter_route) {
		setAttrVal("Filter_route", Filter_route);
	}
	
	/**
	 * 科室计算模式md   SD_ORTMPLTP_ORWFMD
	 * @return String
	 */
	public String getDept_MpMd() {
		return ((String) getAttrVal("Dept_MpMd"));
	}
	/**
	 * 科室计算模式md
	 * @param Dept_MpMd
	 */
	public void setDept_MpMd(String Dept_MpMd) {
		setAttrVal("Dept_MpMd", Dept_MpMd);
	}
	
	/**
	 * 物资仓库ID
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 物资仓库ID
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 物资仓库
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 物资仓库
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 物资仓库过滤条件
	 * @return String
	 */
	public String getFilter_dep_wh() {
		return ((String) getAttrVal("Filter_dep_wh"));
	}
	/**
	 * 物资仓库过滤条件
	 * @param Filter_dep_wh
	 */
	public void setFilter_dep_wh(String Filter_dep_wh) {
		setAttrVal("Filter_dep_wh", Filter_dep_wh);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	
	
	
	/**
	 * 医嘱服务ID
	 * @return Id_orsrv
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱开立方式
	 * @return
	 */
	public Integer getEu_orderPrescribeModule() {
		return ((Integer) getAttrVal("Eu_orderPrescribeModule"));
	}	
	
	/**
	 * 医嘱开立方式
	 * @param Eu_orderPrescribeModule
	 */
	public void setEu_OrderPrescribeModule(Integer Eu_orderPrescribeModule) {
		setAttrVal("Eu_orderPrescribeModule", Eu_orderPrescribeModule);
	}
	
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	
	/**
	 * 开始日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	
	/**
	 * 停止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 停止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 停止医生ID
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}
	/**
	 * 停止医生ID
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停止医生
	 * @return String
	 */
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}
	/**
	 * 停止医生
	 * @param Name_emp_stop
	 */
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}
	/**
	 * 次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	
	/**
	 * 科研标识
	 * @return FBoolean
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}
	/**
	 * 科研标识
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 用法要求ID
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求ID
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}
	/**
	 * 结果
	 * @param Result
	 */
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	
	/**
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 确认标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 确认标识
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 拒绝确认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refusecheck() {
		return ((FBoolean) getAttrVal("Fg_refusecheck"));
	}
	/**
	 * 拒绝确认标志
	 * @param Fg_refusecheck
	 */
	public void setFg_refusecheck(FBoolean Fg_refusecheck) {
		setAttrVal("Fg_refusecheck", Fg_refusecheck);
	}
	/**
	 * 作废标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 作废标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 医嘱不可取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_uncancelable() {
		return ((FBoolean) getAttrVal("Fg_uncancelable"));
	}
	/**
	 * 医嘱不可取消标识
	 * @param Fg_uncancelable
	 */
	public void setFg_uncancelable(FBoolean Fg_uncancelable) {
		setAttrVal("Fg_uncancelable", Fg_uncancelable);
	}
	/**
	 * 作废确认标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}
	/**
	 * 作废确认标识
	 * @param Fg_canc
	 */
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
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
	 * 医嘱状态
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}
	/**
	 * 医嘱状态
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	
	/**
	 * 错误级别
	 * 
	 * @return
	 */
	public String getError_level() {
		return ((String) getAttrVal("Error_level"));
	}
	
	/**
	 * 错误级别
	 * 
	 * @param Error_level
	 */
	public void setError_level(String Error_level) {
		setAttrVal("Error_level", Error_level);
	}

	/**
	 * 错误信息描述
	 * 
	 * @return
	 */
	public String getError_des() {
		return ((String) getAttrVal("Error_des"));
	}

	/**
	 * 错误信息描述
	 * 
	 * @param Error_des
	 */
	public void setError_des(String Error_des) {
		setAttrVal("Error_des", Error_des);
	}

	
//	/**
//	 * 医嘱驱动
//	 * @return String
//	 */
//	public String getJsonDriver() {
//		return ((String) getAttrVal("JsonDriver"));
//	}
//	/**
//	 * 医嘱驱动
//	 * @param JsonDriver
//	 */
//	public void setJsonDriver(String JsonDriver) {
//		setAttrVal("JsonDriver", JsonDriver);
//	}
	/**
	 * 医疗单 驱动
	 * 
	 * @return String
	 */
	public EmsDriverInfo getDriverInfo() {
		return ((EmsDriverInfo) getAttrVal("DriverInfo"));
	}

	/**
	 * 医疗单 驱动
	 * 
	 * @param JsonDriver
	 */
	public void setDriverInfo(EmsDriverInfo DriverInfo) {
		setAttrVal("DriverInfo", DriverInfo);
	}
	
	/**
	 * 时间戳
	 * @return
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间戳
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}
