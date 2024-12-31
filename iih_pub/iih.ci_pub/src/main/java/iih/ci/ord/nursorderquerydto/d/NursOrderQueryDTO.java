package iih.ci.ord.nursorderquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护嘱查询dto DTO数据 
 * 
 */
public class NursOrderQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 床号id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床号id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 就诊病区
	 * @param id_dep_nur
	 */
	public void setId_dep_nur(String id_dep_nur){
		setAttrVal("Id_dep_nur", id_dep_nur);
	}
	/**
	 * 
	 * @return
	 */
	public String getId_dep_nur(){
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 长临过滤条件
	 * @param str_long
	 */
	public void setStr_long(String str_long){
		setAttrVal("Str_long", str_long);
	}
	/**
	 * 长临过滤条件
	 * @return string
	 */
	public String getStr_long(){
		return ((String) getAttrVal("Str_long"));
	}
	/**
	 * 有效医嘱过滤条件
	 * @param str_active
	 */
	public void setStr_active(String str_active){
		setAttrVal("Str_active", str_active);
	}
	/**
	 * 有效医嘱过滤条件
	 * @return string
	 */
	public String getStr_active(){
		return ((String) getAttrVal("Str_active"));
	}
	/**
	 * 医嘱列表查询和护士医嘱列表查询分类:0:医嘱，1：护嘱
	 * @param QueryModel
	 */
	public void setQueryModel(String QueryModel){
		setAttrVal("QueryModel", QueryModel);
	}
	/**
	 * 医嘱列表查询和护士医嘱列表查询分类
	 * @return string
	 */
	public String getQueryModel(){
		return ((String) getAttrVal("QueryModel"));
	}
}