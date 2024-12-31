package iih.mp.nr.mpwardprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区执行打印查询条件 DTO数据 
 * 
 */
public class WardprintSelectedDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据id
	 * @return String
	 */
	public String getId_or_prn() {
		return ((String) getAttrVal("Id_or_prn"));
	}
	/**
	 * 单据id
	 * @param Id_or_prn
	 */
	public void setId_or_prn(String Id_or_prn) {
		setAttrVal("Id_or_prn", Id_or_prn);
	}
	/**
	 * 单据名称
	 * @return String
	 */
	public String getName_or_prn() {
		return ((String) getAttrVal("Name_or_prn"));
	}
	/**
	 * 单据名称
	 * @param Name_or_prn
	 */
	public void setName_or_prn(String Name_or_prn) {
		setAttrVal("Name_or_prn", Name_or_prn);
	}
	/**
	 * 截止天
	 * @return FDate
	 */
	public FDate getDt_date_end() {
		return ((FDate) getAttrVal("Dt_date_end"));
	}
	/**
	 * 截止天
	 * @param Dt_date_end
	 */
	public void setDt_date_end(FDate Dt_date_end) {
		setAttrVal("Dt_date_end", Dt_date_end);
	}
	/**
	 * 开始天
	 * @return FDate
	 */
	public FDate getDt_date_begin() {
		return ((FDate) getAttrVal("Dt_date_begin"));
	}
	/**
	 * 开始天
	 * @param Dt_date_begin
	 */
	public void setDt_date_begin(FDate Dt_date_begin) {
		setAttrVal("Dt_date_begin", Dt_date_begin);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 单天查询
	 * @return FDate
	 */
	public FDate getDt_date() {
		return ((FDate) getAttrVal("Dt_date"));
	}
	/**
	 * 单天查询
	 * @param Dt_date
	 */
	public void setDt_date(FDate Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 查询结束时间
	 * @return FDateTime
	 */
	public FDateTime getRel_end() {
		return ((FDateTime) getAttrVal("Rel_end"));
	}
	/**
	 * 查询结束时间
	 * @param Rel_end
	 */
	public void setRel_end(FDateTime Rel_end) {
		setAttrVal("Rel_end", Rel_end);
	}
	/**
	 * 查询开始时间
	 * @return FDateTime
	 */
	public FDateTime getRel_begin() {
		return ((FDateTime) getAttrVal("Rel_begin"));
	}
	/**
	 * 查询开始时间
	 * @param Rel_begin
	 */
	public void setRel_begin(FDateTime Rel_begin) {
		setAttrVal("Rel_begin", Rel_begin);
	}
	/**
	 * 长临
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}
	/**
	 * 长临
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 打印状态
	 * @return Integer
	 */
	public Integer getEu_print() {
		return ((Integer) getAttrVal("Eu_print"));
	}
	/**
	 * 打印状态
	 * @param Eu_print
	 */
	public void setEu_print(Integer Eu_print) {
		setAttrVal("Eu_print", Eu_print);
	}
	/**
	 * 毒麻
	 * @return Integer
	 */
	public Integer getEu_pois() {
		return ((Integer) getAttrVal("Eu_pois"));
	}
	/**
	 * 毒麻
	 * @param Eu_pois
	 */
	public void setEu_pois(Integer Eu_pois) {
		setAttrVal("Eu_pois", Eu_pois);
	}
	/**
	 * 出院带药
	 * @return Integer
	 */
	public Integer getEu_outp() {
		return ((Integer) getAttrVal("Eu_outp"));
	}
	/**
	 * 出院带药
	 * @param Eu_outp
	 */
	public void setEu_outp(Integer Eu_outp) {
		setAttrVal("Eu_outp", Eu_outp);
	}
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法ID
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_routes() {
		return ((String) getAttrVal("Name_routes"));
	}
	/**
	 * 用法名称
	 * @param Name_routes
	 */
	public void setName_routes(String Name_routes) {
		setAttrVal("Name_routes", Name_routes);
	}
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samtp() {
		return ((String) getAttrVal("Id_samtp"));
	}
	/**
	 * 标本类型ID
	 * @param Id_samtp
	 */
	public void setId_samtp(String Id_samtp) {
		setAttrVal("Id_samtp", Id_samtp);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samtp() {
		return ((String) getAttrVal("Name_samtp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samtp
	 */
	public void setName_samtp(String Name_samtp) {
		setAttrVal("Name_samtp", Name_samtp);
	}
	/**
	 * 日次多张卡
	 * @return FBoolean
	 */
	public FBoolean getFg_unfold() {
		return ((FBoolean) getAttrVal("Fg_unfold"));
	}
	/**
	 * 日次多张卡
	 * @param Fg_unfold
	 */
	public void setFg_unfold(FBoolean Fg_unfold) {
		setAttrVal("Fg_unfold", Fg_unfold);
	}
	/**
	 * 特殊频次
	 * @return FBoolean
	 */
	public FBoolean getFg_fre() {
		return ((FBoolean) getAttrVal("Fg_fre"));
	}
	/**
	 * 特殊频次
	 * @param Fg_fre
	 */
	public void setFg_fre(FBoolean Fg_fre) {
		setAttrVal("Fg_fre", Fg_fre);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freqs() {
		return ((String) getAttrVal("Id_freqs"));
	}
	/**
	 * 频次
	 * @param Id_freqs
	 */
	public void setId_freqs(String Id_freqs) {
		setAttrVal("Id_freqs", Id_freqs);
	}
	/**
	 * 仓库ID
	 * @return String
	 */
	public String getId_whs() {
		return ((String) getAttrVal("Id_whs"));
	}
	/**
	 * 仓库ID
	 * @param Id_whs
	 */
	public void setId_whs(String Id_whs) {
		setAttrVal("Id_whs", Id_whs);
	}
	/**
	 * 仓库名称串
	 * @return String
	 */
	public String getName_whs() {
		return ((String) getAttrVal("Name_whs"));
	}
	/**
	 * 仓库名称串
	 * @param Name_whs
	 */
	public void setName_whs(String Name_whs) {
		setAttrVal("Name_whs", Name_whs);
	}
	/**
	 * 仓库科室ID串
	 * @return String
	 */
	public String getId_dep_whs() {
		return ((String) getAttrVal("Id_dep_whs"));
	}
	/**
	 * 仓库科室ID串
	 * @param Id_dep_whs
	 */
	public void setId_dep_whs(String Id_dep_whs) {
		setAttrVal("Id_dep_whs", Id_dep_whs);
	}
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srvs() {
		return ((String) getAttrVal("Name_srvs"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srvs
	 */
	public void setName_srvs(String Name_srvs) {
		setAttrVal("Name_srvs", Name_srvs);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_exec() {
		return ((Integer) getAttrVal("Eu_exec"));
	}
	/**
	 * 执行状态
	 * @param Eu_exec
	 */
	public void setEu_exec(Integer Eu_exec) {
		setAttrVal("Eu_exec", Eu_exec);
	}
}