package iih.ci.sdk.orctt.meta;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 用于西成药医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class CommonDrugItemOrContentParam extends CommonDrugOrContentParam{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 物品名称
	 * @return
	 */
	public String getName_mm(){
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm){
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 服务名称
	 * @return
	 */
	public String getName_srv(){
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv){
		setAttrVal("Name_srv", Name_srv);
	}
	
	/**
	 * 零售单位名称
	 * @return
	 */
	public String getName_unit_sale(){
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位名称
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale){
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 服务总量
	 * @return
	 */
	public FDouble getQuan_total_medu(){
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu){
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	/**
	 * 自备标识
	 * @return
	 */
	public FBoolean getFg_self(){
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 自备标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self){
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 自定义标识集合
	 * @return
	 */
	public FBoolean getFg_selfsrv(){
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}
	/**
	 * 自定义标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv){
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	
	/**
	 * 剂量集合
	 * @return
	 */
	public FDouble getQuan_med(){
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量集合
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med){
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 临床标识
	 * @return
	 */
	public FBoolean getFg_or(){
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 临床标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or){
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 总量 当前
	 * @return
	 */
	public FDouble getQuan_cur(){
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量 当前
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur){
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 付数无关标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	/**
	 * 付数无关标志
	 * @param Fg_nothingwithorders
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 用法
	 * @return
	 */
	public String getName_route(){
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法要求
	 * @param Name_unit_sale
	 */
	public void setName_route(String Name_route){
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法
	 * @return
	 */
	public String getName_routedes(){
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_unit_sale
	 */
	public void setName_routedes(String Name_routedes){
		setAttrVal("Name_routedes", Name_routedes);
	}
}
