package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 高压氧申请单项目 DTO数据 
 * 
 */
public class EmsHocItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 高压氧申请主键
	 * @return String
	 */
	public String getId_aphoc() {
		return ((String) getAttrVal("Id_aphoc"));
	}
	/**
	 * 高压氧申请主键
	 * @param Id_aphoc
	 */
	public void setId_aphoc(String Id_aphoc) {
		setAttrVal("Id_aphoc", Id_aphoc);
	}
	/**
	 * 高压氧申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 高压氧申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 症状和体征
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}
	/**
	 * 症状和体征
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getSd_su_hoc() {
		return ((String) getAttrVal("Sd_su_hoc"));
	}
	/**
	 * 申请状态
	 * @param Sd_su_hoc
	 */
	public void setSd_su_hoc(String Sd_su_hoc) {
		setAttrVal("Sd_su_hoc", Sd_su_hoc);
	}
	/**
	 * 当前诊断主键
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 当前诊断主键
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 临床诊断主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 当前诊断明细编码拼接
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}
	/**
	 * 当前诊断明细编码拼接
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	/**
	 * 当前诊断明细名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}
	/**
	 * 当前诊断明细名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 当前诊断明细主键拼接
	 * @return String
	 */
	public String getStr_iditem_di() {
		return ((String) getAttrVal("Str_iditem_di"));
	}
	/**
	 * 当前诊断明细主键拼接
	 * @param Str_iditem_di
	 */
	public void setStr_iditem_di(String Str_iditem_di) {
		setAttrVal("Str_iditem_di", Str_iditem_di);
	}
	/**
	 * 临床诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 临床诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 临床诊断编码
	 * @return String
	 */
	public String getCode_didef() {
		return ((String) getAttrVal("Code_didef"));
	}
	/**
	 * 临床诊断编码
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef) {
		setAttrVal("Code_didef", Code_didef);
	}
	/**
	 * 吸氧方式主键
	 * @return String
	 */
	public String getId_way_oxinh() {
		return ((String) getAttrVal("Id_way_oxinh"));
	}
	/**
	 * 吸氧方式主键
	 * @param Id_way_oxinh
	 */
	public void setId_way_oxinh(String Id_way_oxinh) {
		setAttrVal("Id_way_oxinh", Id_way_oxinh);
	}
	/**
	 * 吸氧方式编码
	 * @return String
	 */
	public String getCode_way_oxinh() {
		return ((String) getAttrVal("Code_way_oxinh"));
	}
	/**
	 * 吸氧方式编码
	 * @param Code_way_oxinh
	 */
	public void setCode_way_oxinh(String Code_way_oxinh) {
		setAttrVal("Code_way_oxinh", Code_way_oxinh);
	}
	/**
	 * 吸氧方式名称
	 * @return String
	 */
	public String getName_way_oxinh() {
		return ((String) getAttrVal("Name_way_oxinh"));
	}
	/**
	 * 吸氧方式名称
	 * @param Name_way_oxinh
	 */
	public void setName_way_oxinh(String Name_way_oxinh) {
		setAttrVal("Name_way_oxinh", Name_way_oxinh);
	}
	/**
	 * 体位主键
	 * @return String
	 */
	public String getId_cbnseat_pos() {
		return ((String) getAttrVal("Id_cbnseat_pos"));
	}
	/**
	 * 体位主键
	 * @param Id_cbnseat_pos
	 */
	public void setId_cbnseat_pos(String Id_cbnseat_pos) {
		setAttrVal("Id_cbnseat_pos", Id_cbnseat_pos);
	}
	/**
	 * 体位编码
	 * @return String
	 */
	public String getCode_cbnseat_pos() {
		return ((String) getAttrVal("Code_cbnseat_pos"));
	}
	/**
	 * 体位编码
	 * @param Code_cbnseat_pos
	 */
	public void setCode_cbnseat_pos(String Code_cbnseat_pos) {
		setAttrVal("Code_cbnseat_pos", Code_cbnseat_pos);
	}
	/**
	 * 体位名称
	 * @return String
	 */
	public String getName_cbnseat_pos() {
		return ((String) getAttrVal("Name_cbnseat_pos"));
	}
	/**
	 * 体位名称
	 * @param Name_cbnseat_pos
	 */
	public void setName_cbnseat_pos(String Name_cbnseat_pos) {
		setAttrVal("Name_cbnseat_pos", Name_cbnseat_pos);
	}
	/**
	 * 治疗方案主键
	 * @return String
	 */
	public String getId_hoc_sln() {
		return ((String) getAttrVal("Id_hoc_sln"));
	}
	/**
	 * 治疗方案主键
	 * @param Id_hoc_sln
	 */
	public void setId_hoc_sln(String Id_hoc_sln) {
		setAttrVal("Id_hoc_sln", Id_hoc_sln);
	}
	/**
	 * 治疗方案名称
	 * @return String
	 */
	public String getName_hoc_sln() {
		return ((String) getAttrVal("Name_hoc_sln"));
	}
	/**
	 * 治疗方案名称
	 * @param Name_hoc_sln
	 */
	public void setName_hoc_sln(String Name_hoc_sln) {
		setAttrVal("Name_hoc_sln", Name_hoc_sln);
	}
	/**
	 * 治疗压力
	 * @return FDouble
	 */
	public FDouble getNum_press() {
		return ((FDouble) getAttrVal("Num_press"));
	}
	/**
	 * 治疗压力
	 * @param Num_press
	 */
	public void setNum_press(FDouble Num_press) {
		setAttrVal("Num_press", Num_press);
	}
	/**
	 * 加压时间
	 * @return Integer
	 */
	public Integer getMits_press() {
		return ((Integer) getAttrVal("Mits_press"));
	}
	/**
	 * 加压时间
	 * @param Mits_press
	 */
	public void setMits_press(Integer Mits_press) {
		setAttrVal("Mits_press", Mits_press);
	}
	/**
	 * 吸氧分钟
	 * @return Integer
	 */
	public Integer getMint_oxinh() {
		return ((Integer) getAttrVal("Mint_oxinh"));
	}
	/**
	 * 吸氧分钟
	 * @param Mint_oxinh
	 */
	public void setMint_oxinh(Integer Mint_oxinh) {
		setAttrVal("Mint_oxinh", Mint_oxinh);
	}
	/**
	 * 吸氧次数
	 * @return Integer
	 */
	public Integer getTimes_oxinh() {
		return ((Integer) getAttrVal("Times_oxinh"));
	}
	/**
	 * 吸氧次数
	 * @param Times_oxinh
	 */
	public void setTimes_oxinh(Integer Times_oxinh) {
		setAttrVal("Times_oxinh", Times_oxinh);
	}
	/**
	 * 休息分钟
	 * @return Integer
	 */
	public Integer getMint_rest() {
		return ((Integer) getAttrVal("Mint_rest"));
	}
	/**
	 * 休息分钟
	 * @param Mint_rest
	 */
	public void setMint_rest(Integer Mint_rest) {
		setAttrVal("Mint_rest", Mint_rest);
	}
	/**
	 * 休息次数
	 * @return Integer
	 */
	public Integer getTimes_rest() {
		return ((Integer) getAttrVal("Times_rest"));
	}
	/**
	 * 休息次数
	 * @param Times_rest
	 */
	public void setTimes_rest(Integer Times_rest) {
		setAttrVal("Times_rest", Times_rest);
	}
	/**
	 * 减压分钟
	 * @return Integer
	 */
	public Integer getMint_dpress() {
		return ((Integer) getAttrVal("Mint_dpress"));
	}
	/**
	 * 减压分钟
	 * @param Mint_dpress
	 */
	public void setMint_dpress(Integer Mint_dpress) {
		setAttrVal("Mint_dpress", Mint_dpress);
	}
	/**
	 * 总时间
	 * @return String
	 */
	public String getTotal_time() {
		return ((String) getAttrVal("Total_time"));
	}
	/**
	 * 总时间
	 * @param Total_time
	 */
	public void setTotal_time(String Total_time) {
		setAttrVal("Total_time", Total_time);
	}
	/**
	 * 方案描述
	 * @return String
	 */
	public String getNote_hoc_sln() {
		return ((String) getAttrVal("Note_hoc_sln"));
	}
	/**
	 * 方案描述
	 * @param Note_hoc_sln
	 */
	public void setNote_hoc_sln(String Note_hoc_sln) {
		setAttrVal("Note_hoc_sln", Note_hoc_sln);
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
	 * 剂量单位Id
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 剂量单位Id
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 剂量单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 执行科室Id
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}
	/**
	 * 执行科室Id
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}
	/**
	 * 执行科室名称
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}
	/**
	 * 长临标志
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标志
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 频次主键
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次主键
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
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
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 是否多剂量
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}
	/**
	 * 是否多剂量
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/**
	 * 是否多次执行
	 * @return FBoolean
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
	 * 频次周期类型
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次周期类型
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 执行科室集合
	 * @return String
	 */
	public String getStr_mp_dep_ids() {
		return ((String) getAttrVal("Str_mp_dep_ids"));
	}
	/**
	 * 执行科室集合
	 * @param Str_mp_dep_ids
	 */
	public void setStr_mp_dep_ids(String Str_mp_dep_ids) {
		setAttrVal("Str_mp_dep_ids", Str_mp_dep_ids);
	}
	/**
	 * 获取药品表单上的药品列表
	 * @return
	 */
	public FArrayList getEmsOrDrugListEx() {
		return (FArrayList) getAttrVal("EmsOrDrugListEx");

	}
	/**
	 * 设置药品表单上的药品列表
	 * @param emsOrDrugList
	 */
	public void setEmsOrDrugListEx(FArrayList EmsOrDrugListEx) {

		setAttrVal("EmsOrDrugListEx", EmsOrDrugListEx);
	}
	/**
	 * 高压氧治疗方案项目列表
	 * @return
	 */
	public FArrayList getEmsHocSlnList() {
		return (FArrayList) getAttrVal("EmsHocSlnList");

	}
	/**
	 * 高压氧治疗方案项目列表
	 * @param EmsHocSlnList
	 */
	public void setEmsHocSlnList(FArrayList EmsHocSlnList) {

		setAttrVal("EmsHocSlnList", EmsHocSlnList);
	}
}