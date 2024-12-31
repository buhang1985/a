package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分诊查询DTO DTO数据 
 * 
 */
public class TriagePatQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 站点id
	 * @return String
	 */
	public String getId_site() {
		return ((String) getAttrVal("Id_site"));
	}
	/**
	 * 站点id
	 * @param Id_site
	 */
	public void setId_site(String Id_site) {
		setAttrVal("Id_site", Id_site);
	}
	/**
	 * 站点sd
	 * @return String
	 */
	public String getSd_site() {
		return ((String) getAttrVal("Sd_site"));
	}
	/**
	 * 站点sd
	 * @param Sd_site
	 */
	public void setSd_site(String Sd_site) {
		setAttrVal("Sd_site", Sd_site);
	}
	/**
	 * 站点名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 站点名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 当前工作点
	 * @return String
	 */
	public String getCurrt_site() {
		return ((String) getAttrVal("Currt_site"));
	}
	/**
	 * 当前工作点
	 * @param Currt_site
	 */
	public void setCurrt_site(String Currt_site) {
		setAttrVal("Currt_site", Currt_site);
	}
	/**
	 * 站点状态
	 * @return String
	 */
	public String getName_status_site() {
		return ((String) getAttrVal("Name_status_site"));
	}
	/**
	 * 站点状态
	 * @param Name_status_site
	 */
	public void setName_status_site(String Name_status_site) {
		setAttrVal("Name_status_site", Name_status_site);
	}
	/**
	 * 站点状态sd
	 * @return String
	 */
	public String getSd_status_site() {
		return ((String) getAttrVal("Sd_status_site"));
	}
	/**
	 * 站点状态sd
	 * @param Sd_status_site
	 */
	public void setSd_status_site(String Sd_status_site) {
		setAttrVal("Sd_status_site", Sd_status_site);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别sd
	 * @return String
	 */
	public String getSd_dayslot() {
		return ((String) getAttrVal("Sd_dayslot"));
	}
	/**
	 * 午别sd
	 * @param Sd_dayslot
	 */
	public void setSd_dayslot(String Sd_dayslot) {
		setAttrVal("Sd_dayslot", Sd_dayslot);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 是否分诊
	 * @return FBoolean
	 */
	public FBoolean getFg_triage() {
		return ((FBoolean) getAttrVal("Fg_triage"));
	}
	/**
	 * 是否分诊
	 * @param Fg_triage
	 */
	public void setFg_triage(FBoolean Fg_triage) {
		setAttrVal("Fg_triage", Fg_triage);
	}
	/**
	 * 是否通知
	 * @return FBoolean
	 */
	public FBoolean getFg_called() {
		return ((FBoolean) getAttrVal("Fg_called"));
	}
	/**
	 * 是否通知
	 * @param Fg_called
	 */
	public void setFg_called(FBoolean Fg_called) {
		setAttrVal("Fg_called", Fg_called);
	}
	/**
	 * 是否处置
	 * @return FBoolean
	 */
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}
	/**
	 * 是否处置
	 * @param Fg_check
	 */
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	/**
	 * 是否处置完成
	 * @return FBoolean
	 */
	public FBoolean getFg_checked() {
		return ((FBoolean) getAttrVal("Fg_checked"));
	}
	/**
	 * 是否处置完成
	 * @param Fg_checked
	 */
	public void setFg_checked(FBoolean Fg_checked) {
		setAttrVal("Fg_checked", Fg_checked);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_ben() {
		return ((String) getAttrVal("Id_ben"));
	}
	/**
	 * 分诊台id
	 * @param Id_ben
	 */
	public void setId_ben(String Id_ben) {
		setAttrVal("Id_ben", Id_ben);
	}
	/**
	 * 分诊台名称
	 * @return String
	 */
	public String getName_ben() {
		return ((String) getAttrVal("Name_ben"));
	}
	/**
	 * 分诊台名称
	 * @param Name_ben
	 */
	public void setName_ben(String Name_ben) {
		setAttrVal("Name_ben", Name_ben);
	}
}