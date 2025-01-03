package iih.ci.ord.dto.skintest.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

import iih.ci.ord.dto.d.SkinTestParamDTO;

/**
 * 皮试医嘱的签署入参 DTO数据 
 * 
 */
public class SkinTestSignParamDTO extends SkinTestParamDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医生选择的用药模式（继续用药，取消）
	 * @return String
	 */
	public String getEu_doctorinjectmodel() {
		return ((String) getAttrVal("Eu_doctorinjectmodel"));
	}
	/**
	 * 医生选择的用药模式（继续用药，取消）
	 * @param Eu_doctorinjectmodel
	 */
	public void setEu_doctorinjectmodel(String Eu_doctorinjectmodel) {
		setAttrVal("Eu_doctorinjectmodel", Eu_doctorinjectmodel);
	}
	/**
	 * 不皮试原因
	 * @return String
	 */
	public String getSkip_skintest_reason() {
		return ((String) getAttrVal("Skip_skintest_reason"));
	}
	/**
	 * 不皮试原因
	 * @param Skip_skintest_reason
	 */
	public void setSkip_skintest_reason(String Skip_skintest_reason) {
		setAttrVal("Skip_skintest_reason", Skip_skintest_reason);
	}
	/**
	 * 是否需要再判断
	 * @return FBoolean
	 */
	public FBoolean getFg_rejudge() {
		return ((FBoolean) getAttrVal("Fg_rejudge"));
	}
	/**
	 * 是否需要再判断
	 * @param Fg_rejudge
	 */
	public void setFg_rejudge(FBoolean Fg_rejudge) {
		setAttrVal("Fg_rejudge", Fg_rejudge);
	}
	/**
	 * 关联的皮试医嘱
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 关联的皮试医嘱
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 异常情况下用药模式
	 * @return String
	 */
	public String getEu_unusualinjectmodel() {
		return ((String) getAttrVal("Eu_unusualinjectmodel"));
	}
	/**
	 * 异常情况下用药模式
	 * @param Eu_unusualinjectmodel
	 */
	public void setEu_unusualinjectmodel(String Eu_unusualinjectmodel) {
		setAttrVal("Eu_unusualinjectmodel", Eu_unusualinjectmodel);
	}
	/**
	 * 医生是否有权限强制用药
	 * @return FBoolean
	 */
	public FBoolean getFg_haspowertosign() {
		return ((FBoolean) getAttrVal("Fg_haspowertosign"));
	}
	/**
	 * 医生是否有权限强制用药
	 * @param Fg_haspowertosign
	 */
	public void setFg_haspowertosign(FBoolean Fg_haspowertosign) {
		setAttrVal("Fg_haspowertosign", Fg_haspowertosign);
	}
	/**
	 * 皮试结果是否已出
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest_rst() {
		return ((FBoolean) getAttrVal("Fg_skintest_rst"));
	}
	/**
	 * 皮试结果是否已出
	 * @param Fg_skintest_rst
	 */
	public void setFg_skintest_rst(FBoolean Fg_skintest_rst) {
		setAttrVal("Fg_skintest_rst", Fg_skintest_rst);
	}
	/**
	 * 皮试判断结果
	 * @return String
	 */
	public String getEu_skintestjudgerst() {
		return ((String) getAttrVal("Eu_skintestjudgerst"));
	}
	/**
	 * 皮试判断结果
	 * @param Eu_skintestjudgerst
	 */
	public void setEu_skintestjudgerst(String Eu_skintestjudgerst) {
		setAttrVal("Eu_skintestjudgerst", Eu_skintestjudgerst);
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
	 * 警告信息
	 * @return String
	 */
	public String getWarninfo() {
		return ((String) getAttrVal("Warninfo"));
	}
	/**
	 * 警告信息
	 * @param Warninfo
	 */
	public void setWarninfo(String Warninfo) {
		setAttrVal("Warninfo", Warninfo);
	}
	/**
	 * 皮试类型编码
	 * @return
	 */
	public String getSd_skinca(){
		return ((String) getAttrVal("Sd_skinca"));
	}
	/**
	 * 皮试类型编码
	 * @param Sd_skinca
	 */
	public void setSd_skinca(String Sd_skinca){
		setAttrVal("Sd_skinca",Sd_skinca);
	}
	/**
	 * 皮试药品
	 * @return
	 */
	public String getId_mmskin(){
		return ((String) getAttrVal("Id_mmskin"));
	}
	/**
	 * 皮试药品
	 * @param Id_mmskin
	 */
	public void setId_mmskin(String Id_mmskin){
		setAttrVal("Id_mmskin",Id_mmskin);
	}
	/**
	 * 皮试项目
	 * @return
	 */
	public String getId_srvskin(){
		return ((String) getAttrVal("Id_srvskin"));
	}
	/**
	 * 皮试项目
	 * @param Id_mmskin
	 */
	public void setId_srvskin(String Id_srvskin){
		setAttrVal("Id_srvskin",Id_srvskin);
	}
}