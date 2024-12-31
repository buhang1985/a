package iih.mp.ne.dto.sampsrvdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本费用服务 DTO数据 
 * 
 */
public class SampSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本费用id
	 * @return String
	 */
	public String getId_labsamp_srv() {
		return ((String) getAttrVal("Id_labsamp_srv"));
	}
	/**
	 * 标本费用id
	 * @param Id_labsamp_srv
	 */
	public void setId_labsamp_srv(String Id_labsamp_srv) {
		setAttrVal("Id_labsamp_srv", Id_labsamp_srv);
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
	 * 标本id
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}
	/**
	 * 标本id
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 计量单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 价格
	 * @return String
	 */
	public String getPrice_ratio() {
		return ((String) getAttrVal("Price_ratio"));
	}
	/**
	 * 价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(String Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
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
	 * 记账状态
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 服务启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active_bl() {
		return ((FBoolean) getAttrVal("Fg_active_bl"));
	}
	/**
	 * 服务启用状态
	 * @param Fg_active_bl
	 */
	public void setFg_active_bl(FBoolean Fg_active_bl) {
		setAttrVal("Fg_active_bl", Fg_active_bl);
	}
}