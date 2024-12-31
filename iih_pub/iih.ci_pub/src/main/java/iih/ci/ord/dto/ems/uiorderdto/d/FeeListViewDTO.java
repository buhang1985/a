package iih.ci.ord.dto.ems.uiorderdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用清单列表 DTO数据 
 * 
 */
public class FeeListViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单项目主键标识
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗单项目主键标识
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医疗单
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
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱综合状态
	 * @return String
	 */
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}
	/**
	 * 医嘱综合状态
	 * @param Ord_colligate
	 */
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
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
	 * 费用编码
	 * @return String
	 */
	public String getCode_fee() {
		return ((String) getAttrVal("Code_fee"));
	}
	/**
	 * 费用编码
	 * @param Code_fee
	 */
	public void setCode_fee(String Code_fee) {
		setAttrVal("Code_fee", Code_fee);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getName_hptp() {
		return ((String) getAttrVal("Name_hptp"));
	}
	/**
	 * 医保类型
	 * @param Name_hptp
	 */
	public void setName_hptp(String Name_hptp) {
		setAttrVal("Name_hptp", Name_hptp);
	}
	/**
	 * 零售单位
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 零售单位
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 零售单位名称
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位名称
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_sale() {
		return ((FDouble) getAttrVal("Quan_total_sale"));
	}
	/**
	 * 总量
	 * @param Quan_total_sale
	 */
	public void setQuan_total_sale(FDouble Quan_total_sale) {
		setAttrVal("Quan_total_sale", Quan_total_sale);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}
	/**
	 * 总金额
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 自费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标志
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 医保适应症标志
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 医保适应症标志
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
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
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 费用描述
	 * @return String
	 */
	public String getDes_srv() {
		return ((String) getAttrVal("Des_srv"));
	}
	/**
	 * 费用描述
	 * @param Des_srv
	 */
	public void setDes_srv(String Des_srv) {
		setAttrVal("Des_srv", Des_srv);
	}
	/**
	 * 版本
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}