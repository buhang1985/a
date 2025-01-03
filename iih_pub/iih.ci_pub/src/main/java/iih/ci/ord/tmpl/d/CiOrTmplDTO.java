package iih.ci.ord.tmpl.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱模板DTO DTO数据 
 * 
 */
public class CiOrTmplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床医嘱模板主键标识
	 * @return String
	 */
	public String getId_ciortmpl() {
		return ((String) getAttrVal("Id_ciortmpl"));
	}	
	/**
	 * 临床医嘱模板主键标识
	 * @param Id_ciortmpl
	 */
	public void setId_ciortmpl(String Id_ciortmpl) {
		setAttrVal("Id_ciortmpl", Id_ciortmpl);
	}
	/**
	 * 医嘱模板项目列表
	 * @return String
	 */
	public FArrayList getOrtmplsrvs() {
		return ((FArrayList) getAttrVal("Ortmplsrvs"));
	}	
	/**
	 * 医嘱模板项目列表
	 * @param Ortmplsrvs
	 */
	public void setOrtmplsrvs(FArrayList Ortmplsrvs) {
		setAttrVal("Ortmplsrvs", Ortmplsrvs);
	}
	/**
	 * 医嘱来源方式类型
	 * @return String
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
	 * 医嘱来源主标识
	 * @return String
	 */
	public String getId_orsrc_main() {
		return ((String) getAttrVal("Id_orsrc_main"));
	}	
	/**
	 * 医嘱来源主标识
	 * @param Id_orsrc_main
	 */
	public void setId_orsrc_main(String Id_orsrc_main) {
		setAttrVal("Id_orsrc_main", Id_orsrc_main);
	}
	/**
	 * 医嘱来源子标识
	 * @return String
	 */
	public String getId_orsrc_sub() {
		return ((String) getAttrVal("Id_orsrc_sub"));
	}	
	/**
	 * 医嘱来源子标识
	 * @param Id_orsrc_sub
	 */
	public void setId_orsrc_sub(String Id_orsrc_sub) {
		setAttrVal("Id_orsrc_sub", Id_orsrc_sub);
	}
	/**
	 * 医嘱来源孙标识
	 * @return String
	 */
	public String getId_orsrc_subsub() {
		return ((String) getAttrVal("Id_orsrc_subsub"));
	}	
	/**
	 * 医嘱来源孙标识
	 * @param Id_orsrc_subsub
	 */
	public void setId_orsrc_subsub(String Id_orsrc_subsub) {
		setAttrVal("Id_orsrc_subsub", Id_orsrc_subsub);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 长期临时类型
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}	
	/**
	 * 长期临时类型
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
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
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}	
	/**
	 * 医嘱次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	
	//desc_or 为嘱托，dec为描述
	/**
	 * 医嘱描述
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 医嘱描述
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	
	/**
	 * 医嘱描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 医嘱描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 套标示
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 套标示
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 关联医嘱Id
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	/**
	 * 关联医嘱Id
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 批量开始时间
	 * @return String
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 批量开始时间
	 * @param Id_or_rel
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}	
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
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
	 * 是否多量开单
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}	
	/**
	 * 是否多量开单
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
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
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
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
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}	
	/**
	 * 在院整领标识
	 * @param Fg_pres_outp
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drugdeliverymethod() {
		return ((String) getAttrVal("Id_drugdeliverymethod"));
	}	
	/**
	 * 领药方式ID
	 * @param Id_drugdeliverymethod
	 */
	public void setId_drugdeliverymethod(String Id_drugdeliverymethod) {
		setAttrVal("Id_drugdeliverymethod", Id_drugdeliverymethod);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}	
	/**
	 * 领药方式编码
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
	/**
	 * 领药方式
	 * @return String
	 */
	public String getName_drugdeliverymethod() {
		return ((String) getAttrVal("Name_drugdeliverymethod"));
	}	
	/**
	 * 领药方式
	 * @param Name_drugdeliverymethod
	 */
	public void setName_drugdeliverymethod(String Name_drugdeliverymethod) {
		setAttrVal("Name_drugdeliverymethod", Name_drugdeliverymethod);
	}
}