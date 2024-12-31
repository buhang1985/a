package iih.ci.ord.i.external.provide.meta.bl;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 药品信息DTO
 * @author Young
 *
 */
public class OrdDrugInfo4BlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 医嘱主键
	 * @return
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 备注
	 * @return
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱频次
	 * @return
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}	
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 医嘱付数
	 * @return
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱用法
	 * @return
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 医嘱用法名称
	 * @return
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 煎法
	 * @return
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法名称
	 * @return
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}	
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 医嘱天数
	 * @return
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 签署医生
	 * @return
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署医生编码
	 * @return
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 签署医生姓名
	 * @return
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 医嘱生效日期
	 * @return
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	
	/**
	 * 服务项目主键
	 * @return
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 序号
	 * @return
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 服务项目
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务项目名称
	 * @return
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 数值_医疗单位
	 * @return
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 医疗单位名称
	 * @return
	 */
	public String getName_medu() {
		return ((String) getAttrVal("Name_medu"));
	}	
	public void setName_medu(String Name_medu) {
		setAttrVal("Name_medu", Name_medu);
	}
	/**
	 * 用法要求(服务级别)
	 * @return
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法药要求名称（服务级别）
	 * @return
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}	
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 煎法要求
	 * @return
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求名称
	 * @return
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}	
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 单价
	 * @return
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 是否自备药
	 * @return
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 库房ID
	 * @return
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 库房编码
	 * @return
	 */
	public String getCode_dep_wh() {
		return ((String) getAttrVal("Code_dep_wh"));
	}	
	public void setCode_dep_wh(String Code_dep_wh) {
		setAttrVal("Code_dep_wh", Code_dep_wh);
	}
	/**
	 * 基数药标识
	 * @return
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 特种病标识
	 * @return
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	/**
	 * 多价格比例ID
	 * @return
	 */
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}	
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	/**
	 * 付数无关标志
	 * @return
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 病种ID
	 * @return
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}	
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	
	/**
	 * 医嘱服务物品主键
	 * @return
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}	
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	/**
	 * 医疗物品
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 总量_当前包装（领量）
	 * @return
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 当前包装单位主键
	 * @return
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	/**
	 * 当前包装单位名称
	 * @return
	 */
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}	
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	/**
	 * 单次数量_分子
	 * @return
	 */
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}	
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次数量_分母
	 * @return
	 */
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}	
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 基本包装单位主键
	 * @return
	 */
	public String getId_pgku_base() {
		return ((String) getAttrVal("Id_pgku_base"));
	}	
	public void setId_pgku_base(String Id_pgku_base) {
		setAttrVal("Id_pgku_base", Id_pgku_base);
	}
	/**
	 * 基本包装单位名称
	 * @return
	 */
	public String getName_pgku_base() {
		return ((String) getAttrVal("Name_pgku_base"));
	}	
	public void setName_pgku_base(String Name_pgku_base) {
		setAttrVal("Name_pgku_base", Name_pgku_base);
	}
	/**
	 * 药品剂型
	 * @return
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 药品剂型编码
	 * @return
	 */
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}	
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	/**
	 * 药品剂型名称
	 * @return
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}	
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
	}
	/**
	 * 领量可用天数（门诊用）
	 * @return
	 */
	public Integer getDays_available() {
		return ((Integer) getAttrVal("Days_available"));
	}	
	public void setDays_available(Integer Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	/**
	 * 医嘱名称
	 * @return
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 服务类型
	 * @return
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务编码
	 * @return
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
}
