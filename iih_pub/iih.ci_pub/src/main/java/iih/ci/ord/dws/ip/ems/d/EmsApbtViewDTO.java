package iih.ci.ord.dws.ip.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;

import java.math.BigDecimal;

/**
 * 备血医疗单 DTO数据 
 * 
 */
public class EmsApbtViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请血型
	 * @return String
	 */
	public String getId_bloodtype_ap() {
		return ((String) getAttrVal("Id_bloodtype_ap"));
	}
	/**
	 * 申请血型
	 * @param Id_bloodtype_ap
	 */
	public void setId_bloodtype_ap(String Id_bloodtype_ap) {
		setAttrVal("Id_bloodtype_ap", Id_bloodtype_ap);
	}
	/**
	 * 申请血型编码
	 * @return String
	 */
	public String getSd_bloodtype_ap() {
		return ((String) getAttrVal("Sd_bloodtype_ap"));
	}
	/**
	 * 申请血型编码
	 * @param Sd_bloodtype_ap
	 */
	public void setSd_bloodtype_ap(String Sd_bloodtype_ap) {
		setAttrVal("Sd_bloodtype_ap", Sd_bloodtype_ap);
	}
	/**
	 * 申请血型名称
	 * @return String
	 */
	public String getName_bloodtype_ap() {
		return ((String) getAttrVal("Name_bloodtype_ap"));
	}
	/**
	 * 申请血型名称
	 * @param Name_bloodtype_ap
	 */
	public void setName_bloodtype_ap(String Name_bloodtype_ap) {
		setAttrVal("Name_bloodtype_ap", Name_bloodtype_ap);
	}
	/**
	 * 申请Rh(D)
	 * @return String
	 */
	public String getId_rhd_ap() {
		return ((String) getAttrVal("Id_rhd_ap"));
	}
	/**
	 * 申请Rh(D)
	 * @param Id_rhd_ap
	 */
	public void setId_rhd_ap(String Id_rhd_ap) {
		setAttrVal("Id_rhd_ap", Id_rhd_ap);
	}
	/**
	 * 申请Rh(D)编码
	 * @return String
	 */
	public String getSd_rhd_ap() {
		return ((String) getAttrVal("Sd_rhd_ap"));
	}
	/**
	 * 申请Rh(D)编码
	 * @param Sd_rhd_ap
	 */
	public void setSd_rhd_ap(String Sd_rhd_ap) {
		setAttrVal("Sd_rhd_ap", Sd_rhd_ap);
	}
	/**
	 * 申请Rh(D)名称
	 * @return String
	 */
	public String getName_rhd_ap() {
		return ((String) getAttrVal("Name_rhd_ap"));
	}
	/**
	 * 申请Rh(D)名称
	 * @param Name_rhd_ap
	 */
	public void setName_rhd_ap(String Name_rhd_ap) {
		setAttrVal("Name_rhd_ap", Name_rhd_ap);
	}
	/**
	 * 可申请血量
	 * @return String
	 */
	public String getQuan_blood() {
		return ((String) getAttrVal("Quan_blood"));
	}
	/**
	 * 可申请血量
	 * @param Quan_blood
	 */
	public void setQuan_blood(String Quan_blood) {
		setAttrVal("Quan_blood", Quan_blood);
	}
	/**
	 * 血液可申请血量
	 * @return String
	 */
	public String getId_blodquan() {
		return ((String) getAttrVal("Id_blodquan"));
	}
	/**
	 * 血液可申请血量
	 * @param Id_blodquan
	 */
	public void setId_blodquan(String Id_blodquan) {
		setAttrVal("Id_blodquan", Id_blodquan);
	}
//	/**
//	 * 备血用量单位ID
//	 * @return String
//	 */
//	public String getId_unit_med() {
//		return ((String) getAttrVal("Id_unit_med"));
//	}
//	/**
//	 * 备血用量单位ID
//	 * @param Id_unit_med
//	 */
//	public void setId_unit_med(String Id_unit_med) {
//		setAttrVal("Id_unit_med", Id_unit_med);
//	}
//	/**
//	 * 备血用量单位
//	 * @return String
//	 */
//	public String getName_unit_med() {
//		return ((String) getAttrVal("Name_unit_med"));
//	}
//	/**
//	 * 备血用量单位
//	 * @param Name_unit_med
//	 */
//	public void setName_unit_med(String Name_unit_med) {
//		setAttrVal("Name_unit_med", Name_unit_med);
//	}
	/**
	 * 输血需求状态ID
	 * @return String
	 */
	public String getId_demandsu_bt() {
		return ((String) getAttrVal("Id_demandsu_bt"));
	}
	/**
	 * 输血需求状态ID
	 * @param Id_demandsu_bt
	 */
	public void setId_demandsu_bt(String Id_demandsu_bt) {
		setAttrVal("Id_demandsu_bt", Id_demandsu_bt);
	}
	/**
	 * 输血需求状态SD
	 * @return String
	 */
	public String getSd_demandsu_bt() {
		return ((String) getAttrVal("Sd_demandsu_bt"));
	}
	/**
	 * 输血需求状态SD
	 * @param Sd_demandsu_bt
	 */
	public void setSd_demandsu_bt(String Sd_demandsu_bt) {
		setAttrVal("Sd_demandsu_bt", Sd_demandsu_bt);
	}
	/**
	 * 输血需求状态
	 * @return String
	 */
	public String getName_demandsu_bt() {
		return ((String) getAttrVal("Name_demandsu_bt"));
	}
	/**
	 * 输血需求状态
	 * @param Name_demandsu_bt
	 */
	public void setName_demandsu_bt(String Name_demandsu_bt) {
		setAttrVal("Name_demandsu_bt", Name_demandsu_bt);
	}
	/**
	 * 计划用血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bt_pl() {
		return ((FDateTime) getAttrVal("Dt_bt_pl"));
	}
	/**
	 * 计划用血时间
	 * @param Dt_bt_pl
	 */
	public void setDt_bt_pl(FDateTime Dt_bt_pl) {
		setAttrVal("Dt_bt_pl", Dt_bt_pl);
	}
	/**
	 * 用血目的ID
	 * @return String
	 */
	public String getId_pps_bt() {
		return ((String) getAttrVal("Id_pps_bt"));
	}
	/**
	 * 用血目的ID
	 * @param Id_pps_bt
	 */
	public void setId_pps_bt(String Id_pps_bt) {
		setAttrVal("Id_pps_bt", Id_pps_bt);
	}
	/**
	 * 用血目的SD
	 * @return String
	 */
	public String getSd_pps_bt() {
		return ((String) getAttrVal("Sd_pps_bt"));
	}
	/**
	 * 用血目的SD
	 * @param Sd_pps_bt
	 */
	public void setSd_pps_bt(String Sd_pps_bt) {
		setAttrVal("Sd_pps_bt", Sd_pps_bt);
	}
	/**
	 * 用血目的
	 * @return String
	 */
	public String getName_pps_bt() {
		return ((String) getAttrVal("Name_pps_bt"));
	}
	/**
	 * 用血目的
	 * @param Name_pps_bt
	 */
	public void setName_pps_bt(String Name_pps_bt) {
		setAttrVal("Name_pps_bt", Name_pps_bt);
	}
	/**
	 * 预定输血方式ID
	 * @return String
	 */
	public String getId_mode_bt() {
		return ((String) getAttrVal("Id_mode_bt"));
	}
	/**
	 * 预定输血方式ID
	 * @param Id_mode_bt
	 */
	public void setId_mode_bt(String Id_mode_bt) {
		setAttrVal("Id_mode_bt", Id_mode_bt);
	}
	/**
	 * 预定输血方式SD
	 * @return String
	 */
	public String getSd_mode_bt() {
		return ((String) getAttrVal("Sd_mode_bt"));
	}
	/**
	 * 预定输血方式SD
	 * @param Sd_mode_bt
	 */
	public void setSd_mode_bt(String Sd_mode_bt) {
		setAttrVal("Sd_mode_bt", Sd_mode_bt);
	}
	/**
	 * 预定输血方式
	 * @return String
	 */
	public String getName_mode_bt() {
		return ((String) getAttrVal("Name_mode_bt"));
	}
	/**
	 * 预定输血方式
	 * @param Name_mode_bt
	 */
	public void setName_mode_bt(String Name_mode_bt) {
		setAttrVal("Name_mode_bt", Name_mode_bt);
	}
	/**
	 * 产
	 * @return Integer
	 */
	public Integer getParturition_cnt() {
		return ((Integer) getAttrVal("Parturition_cnt"));
	}
	/**
	 * 产
	 * @param Parturition_cnt
	 */
	public void setParturition_cnt(Integer Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	/**
	 * 孕
	 * @return Integer
	 */
	public Integer getPregnant_num() {
		return ((Integer) getAttrVal("Pregnant_num"));
	}
	/**
	 * 孕
	 * @param Pregnant_num
	 */
	public void setPregnant_num(Integer Pregnant_num) {
		setAttrVal("Pregnant_num", Pregnant_num);
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 输血史ID
	 * @return String
	 */
	public String getId_his_bt() {
		return ((String) getAttrVal("Id_his_bt"));
	}
	/**
	 * 输血史ID
	 * @param Id_his_bt
	 */
	public void setId_his_bt(String Id_his_bt) {
		setAttrVal("Id_his_bt", Id_his_bt);
	}
	/**
	 * 输血史
	 * @return String
	 */
	public String getName_his_bt() {
		return ((String) getAttrVal("Name_his_bt"));
	}
	/**
	 * 输血史
	 * @param Name_his_bt
	 */
	public void setName_his_bt(String Name_his_bt) {
		setAttrVal("Name_his_bt", Name_his_bt);
	}
	/**
	 * 输血史SD
	 * @return String
	 */
	public String getSd_his_bt() {
		return ((String) getAttrVal("Sd_his_bt"));
	}
	/**
	 * 输血史SD
	 * @param Sd_his_bt
	 */
	public void setSd_his_bt(String Sd_his_bt) {
		setAttrVal("Sd_his_bt", Sd_his_bt);
	}
	/**
	 * 临床诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 临床诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断子项ID
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断子项ID
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getName_diitm() {
		return ((String) getAttrVal("Name_diitm"));
	}
	/**
	 * 临床诊断
	 * @param Name_diitm
	 */
	public void setName_diitm(String Name_diitm) {
		setAttrVal("Name_diitm", Name_diitm);
	}
	/**
	 * 临床诊断过滤条件
	 * @return String
	 */
	public String getFilter_diitm() {
		return ((String) getAttrVal("Filter_diitm"));
	}
	/**
	 * 临床诊断过滤条件
	 * @param Filter_diitm
	 */
	public void setFilter_diitm(String Filter_diitm) {
		setAttrVal("Filter_diitm", Filter_diitm);
	}
	/**
	 * 献血史
	 * @return FBoolean
	 */
	public FBoolean getFg_db() {
		return ((FBoolean) getAttrVal("Fg_db"));
	}
	/**
	 * 献血史
	 * @param Fg_db
	 */
	public void setFg_db(FBoolean Fg_db) {
		setAttrVal("Fg_db", Fg_db);
	}
	/**
	 * 献血证号
	 * @return String
	 */
	public String getNo_db() {
		return ((String) getAttrVal("No_db"));
	}
	/**
	 * 献血证号
	 * @param No_db
	 */
	public void setNo_db(String No_db) {
		setAttrVal("No_db", No_db);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 输血前检查说明id
	 * @return String
	 */
	public String getId_labitmexplain() {
		return ((String) getAttrVal("Id_labitmexplain"));
	}
	/**
	 * 输血前检查说明id
	 * @param Id_labitmexplain
	 */
	public void setId_labitmexplain(String Id_labitmexplain) {
		setAttrVal("Id_labitmexplain", Id_labitmexplain);
	}
	/**
	 * 输血前检查说明
	 * @return String
	 */
	public String getName_labitmexplain() {
		return ((String) getAttrVal("Name_labitmexplain"));
	}
	/**
	 * 输血前检查说明
	 * @param Name_labitmexplain
	 */
	public void setName_labitmexplain(String Name_labitmexplain) {
		setAttrVal("Name_labitmexplain", Name_labitmexplain);
	}
	/**
	 * 输血前检测项目说明
	 * @return String
	 */
	public String getSd_labitmexplain() {
		return ((String) getAttrVal("Sd_labitmexplain"));
	}
	/**
	 * 输血前检测项目说明
	 * @param Sd_labitmexplain
	 */
	public void setSd_labitmexplain(String Sd_labitmexplain) {
		setAttrVal("Sd_labitmexplain", Sd_labitmexplain);
	}
	/**
	 * 动态指标
	 * @return FArrayList
	 */
	public FArrayList getBtviewitemlist() {
		return ((FArrayList) getAttrVal("Btviewitemlist"));
	}
	/**
	 * 动态指标
	 * @param Btviewitemlist
	 */
	public void setBtviewitemlist(FArrayList Btviewitemlist) {
		setAttrVal("Btviewitemlist", Btviewitemlist);
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
	 * 选中标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 选中标识
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 剩余血量
	 * @return String
	 */
	public String getNum_margin_bu() {
		return ((String) getAttrVal("Num_margin_bu"));
	}
	/**
	 * 剩余血量
	 * @param Num_margin_bu
	 */
	public void setNum_margin_bu(String Num_margin_bu) {
		setAttrVal("Num_margin_bu", Num_margin_bu);
	}
	/**
	 * 备血申请单主键
	 * @return String
	 */
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}
	/**
	 * 备血申请单主键
	 * @param Id_apbt
	 */
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
	}
}