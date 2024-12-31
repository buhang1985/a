package iih.ci.ord.dto.ems.uiemsdto.b;

import com.sun.org.apache.xpath.internal.FoundIndex;

import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class BaseDrugsItemViewDTO extends BaseHpInfoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务分类
	 * @return String
	 */
	public String getPkId() {
		return ((String) getAttrVal("PkId"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setPkId(String PkId) {
		setAttrVal("PkId", PkId);
	}
	
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	
	/** 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	
	/**
	 * 单价 - 标准价
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 单价- 标准价
	 * @param Price
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}

	/**
	 * 单价 - 折扣系数
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 单价- 折扣系数
	 * @param Price
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}

	/**
	 * 门诊物品开立绑定方式
	 * @p
	 */
	public String getSd_mmbind() {
		return ((String) getAttrVal("Sd_mmbind"));
	}
	/**
	 * 门诊物品开立绑定方式
	 * @param Sd_mmbind
	 */
	public void setSd_mmbind(String Sd_mmbind) {
		setAttrVal("Sd_mmbind", Sd_mmbind);
	}
	
	/**
	 * 基本包装单位ID
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}
	/**
	 * 基本包装单位ID
	 * @param Id_unit_sale
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}
	/**
	 * 基本包装单位
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}
	
	/**
	 * 计量单位集合
	 * @return
	 */
	public FArrayList getSingleMedUnitList()
	{
		return (FArrayList)getAttrVal("SingleMedUnitList"); 

	}
	/**
	 * 计量单位集合
	 * @param BdHpIndicationDTO
	 */
	public void setSingleMedUnitList(FArrayList SingleMedUnitList )
	{

		setAttrVal("SingleMedUnitList", SingleMedUnitList);  
	}
	/**
	 * 显示计量单位
	 * @param Name_unit_med_virtual
	 */
	public void setName_unit_med_virtual(String Name_unit_med_virtual){
		setAttrVal("Name_unit_med_virtual", Name_unit_med_virtual);
	}
	public String getName_unit_med_virtual(){
		return (String)getAttrVal("Name_unit_med_virtual");
	}
	/**
	 * 显示计量单位id
	 * @param Id_unit_med_virtual
	 */
	public void setId_unit_med_virtual(String Id_unit_med_virtual){
		setAttrVal("Id_unit_med_virtual", Id_unit_med_virtual);
	}
	public String getId_unit_med_virtual(){
		return (String)getAttrVal("Id_unit_med_virtual");
	}
	/**
	 * 显示计量
	 * @param Quan_med_virtual
	 */
	public void setQuan_med_virtual(FDouble Quan_med_virtual){
		setAttrVal("Quan_med_virtual", Quan_med_virtual);
	}
	public FDouble getQuan_med_virtual(){
		return (FDouble)getAttrVal("Quan_med_virtual");
	}
	/**
	 * 临床标识
	 * @param Fg_or
	 */
	public void  setFg_or(FBoolean Fg_or){
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 临床标识
	 * @return
	 */
	public FBoolean getFg_or(){
		return (FBoolean)getAttrVal("Fg_or");
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void  setFg_mm(FBoolean Fg_mm){
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 物品标识
	 * @return
	 */
	public FBoolean getFg_mm(){
		return (FBoolean)getAttrVal("Fg_mm");
	}
	/**
	 * 皮试医嘱处理方式
	 * @param Skintestmethod
	 */
	public void  setSkintestmethod(String Skintestmethod){
		setAttrVal("Skintestmethod", Skintestmethod);
	}
	/**
	 * 皮试医嘱处理方式
	 * @return
	 */
	public String getSkintestmethod(){
		return (String)getAttrVal("Skintestmethod");
	}
	/**
	 * 关联服务
	 * @param Id_or_rel
	 */
	public void  setId_or_rel(String Id_or_rel){
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 关联服务
	 * @return
	 */
	public String getId_or_rel(){
		return (String)getAttrVal("Id_or_rel");
	}
	
}
