package iih.ci.ord.dws.ip.order.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱列表查询条件DTO DTO数据 
 * 
 */
public class OrderListFilterViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 长临标识
	 * @return String
	 */
	public String getStr_long() {
		return ((String) getAttrVal("Str_long"));
	}
	/**
	 * 长临标识
	 * @param Str_long
	 */
	public void setStr_long(String Str_long) {
		setAttrVal("Str_long", Str_long);
	}
	/**
	 * 医嘱状态编码扩展
	 * @return String
	 */
	public String getSd_su_or_ext() {
		return ((String) getAttrVal("Sd_su_or_ext"));
	}
	/**
	 * 医嘱状态编码扩展
	 * @param Sd_su_or_ext
	 */
	public void setSd_su_or_ext(String Sd_su_or_ext) {
		setAttrVal("Sd_su_or_ext", Sd_su_or_ext);
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
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医嘱来源功能sd
	 * @return String
	 */
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}
	/**
	 * 医嘱来源功能sd
	 * @param Sd_orsrcfun
	 */
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
	/**
	 * 医嘱查询分类名称
	 * @return String
	 */
	public String getName_ordquerytp() {
		return ((String) getAttrVal("Name_ordquerytp"));
	}
	/**
	 * 医嘱查询分类名称
	 * @param Name_ordquerytp
	 */
	public void setName_ordquerytp(String Name_ordquerytp) {
		setAttrVal("Name_ordquerytp", Name_ordquerytp);
	}
	/**
	 * 医嘱查询分类id
	 * @return String
	 */
	public String getId_ordquerytp() {
		return ((String) getAttrVal("Id_ordquerytp"));
	}
	/**
	 * 医嘱查询分类id
	 * @param Id_ordquerytp
	 */
	public void setId_ordquerytp(String Id_ordquerytp) {
		setAttrVal("Id_ordquerytp", Id_ordquerytp);
	}
	/**
	 * 服务类型串
	 * @return String
	 */
	public String getStr_sd_srvtps() {
		return ((String) getAttrVal("Str_sd_srvtps"));
	}
	/**
	 * 服务类型串
	 * @param Str_sd_srvtps
	 */
	public void setStr_sd_srvtps(String Str_sd_srvtps) {
		setAttrVal("Str_sd_srvtps", Str_sd_srvtps);
	}
	/**
	 * 用法串
	 * @return String
	 */
	public String getStr_id_routes() {
		return ((String) getAttrVal("Str_id_routes"));
	}
	/**
	 * 用法串
	 * @param Str_id_routes
	 */
	public void setStr_id_routes(String Str_id_routes) {
		setAttrVal("Str_id_routes", Str_id_routes);
	}
}