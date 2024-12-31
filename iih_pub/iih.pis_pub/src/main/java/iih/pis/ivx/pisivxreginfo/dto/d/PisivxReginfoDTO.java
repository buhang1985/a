package iih.pis.ivx.pisivxreginfo.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信培训注册信息 DTO数据 
 * 
 */
public class PisivxReginfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 签到标识
	 * @return String
	 */
	public String getId_net_trcrs_sign() {
		return ((String) getAttrVal("Id_net_trcrs_sign"));
	}
	/**
	 * 签到标识
	 * @param Id_net_trcrs_sign
	 */
	public void setId_net_trcrs_sign(String Id_net_trcrs_sign) {
		setAttrVal("Id_net_trcrs_sign", Id_net_trcrs_sign);
	}
	/**
	 * 培训课程
	 * @return String
	 */
	public String getId_net_trainmgr_crs() {
		return ((String) getAttrVal("Id_net_trainmgr_crs"));
	}
	/**
	 * 培训课程
	 * @param Id_net_trainmgr_crs
	 */
	public void setId_net_trainmgr_crs(String Id_net_trainmgr_crs) {
		setAttrVal("Id_net_trainmgr_crs", Id_net_trainmgr_crs);
	}
	/**
	 * 学习课程
	 * @return String
	 */
	public String getId_net_crs() {
		return ((String) getAttrVal("Id_net_crs"));
	}
	/**
	 * 学习课程
	 * @param Id_net_crs
	 */
	public void setId_net_crs(String Id_net_crs) {
		setAttrVal("Id_net_crs", Id_net_crs);
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
	 * 学员微信号
	 * @return String
	 */
	public String getId_wx_std() {
		return ((String) getAttrVal("Id_wx_std"));
	}
	/**
	 * 学员微信号
	 * @param Id_wx_std
	 */
	public void setId_wx_std(String Id_wx_std) {
		setAttrVal("Id_wx_std", Id_wx_std);
	}
	/**
	 * 学员名称
	 * @return String
	 */
	public String getName_std() {
		return ((String) getAttrVal("Name_std"));
	}
	/**
	 * 学员名称
	 * @param Name_std
	 */
	public void setName_std(String Name_std) {
		setAttrVal("Name_std", Name_std);
	}
	/**
	 * 开始地点
	 * @return String
	 */
	public String getPlace_begin() {
		return ((String) getAttrVal("Place_begin"));
	}
	/**
	 * 开始地点
	 * @param Place_begin
	 */
	public void setPlace_begin(String Place_begin) {
		setAttrVal("Place_begin", Place_begin);
	}
	/**
	 * 结束地点
	 * @return String
	 */
	public String getPlace_end() {
		return ((String) getAttrVal("Place_end"));
	}
	/**
	 * 结束地点
	 * @param Place_end
	 */
	public void setPlace_end(String Place_end) {
		setAttrVal("Place_end", Place_end);
	}
}