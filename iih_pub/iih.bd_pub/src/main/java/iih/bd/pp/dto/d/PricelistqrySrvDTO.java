package iih.bd.pp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 历史价表查询用dto DTO数据 
 * 
 */
public class PricelistqrySrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 服务或物品的编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 服务或物品的编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 当前价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 当前价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 服务的单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 服务的单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 单位主键
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位主键
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 服务定价主键
	 * @return String
	 */
	public String getId_prisrv() {
		return ((String) getAttrVal("Id_prisrv"));
	}
	/**
	 * 服务定价主键
	 * @param Id_prisrv
	 */
	public void setId_prisrv(String Id_prisrv) {
		setAttrVal("Id_prisrv", Id_prisrv);
	}
	/**
	 * 服务定价列表中某个定价的价格
	 * @return FDouble
	 */
	public FDouble getPrice_prilist() {
		return ((FDouble) getAttrVal("Price_prilist"));
	}
	/**
	 * 服务定价列表中某个定价的价格
	 * @param Price_prilist
	 */
	public void setPrice_prilist(FDouble Price_prilist) {
		setAttrVal("Price_prilist", Price_prilist);
	}
	/**
	 * 服务定价列表中某个定价开始时间
	 * @return String
	 */
	public String getDt_b() {
		return ((String) getAttrVal("Dt_b"));
	}
	/**
	 * 服务定价列表中某个定价开始时间
	 * @param Dt_b
	 */
	public void setDt_b(String Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 服务定价列表中某个定价结束时间
	 * @return String
	 */
	public String getDt_e() {
		return ((String) getAttrVal("Dt_e"));
	}
	/**
	 * 服务定价列表中某个定价结束时间
	 * @param Dt_e
	 */
	public void setDt_e(String Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 服务定价列表中某个定价启用与否标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 服务定价列表中某个定价启用与否标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}
	/**
	 * 服务分类名称
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
}