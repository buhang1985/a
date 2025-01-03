package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class UnitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 生命体征测量项目id
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 生命体征测量项目id
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 体征项目
	 * @return String
	 */
	public String getId_mrtpl_vs() {
		return ((String) getAttrVal("Id_mrtpl_vs"));
	}
	/**
	 * 体征项目
	 * @param Id_mrtpl_vs
	 */
	public void setId_mrtpl_vs(String Id_mrtpl_vs) {
		setAttrVal("Id_mrtpl_vs", Id_mrtpl_vs);
	}
	/**
	 * 生命体征测量属性
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 生命体征测量属性
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体征项名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}
	/**
	 * 体征项名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 测量项目属性最大值
	 * @return String
	 */
	public String getDevalmax() {
		return ((String) getAttrVal("Devalmax"));
	}
	/**
	 * 测量项目属性最大值
	 * @param Devalmax
	 */
	public void setDevalmax(String Devalmax) {
		setAttrVal("Devalmax", Devalmax);
	}
	/**
	 * 测量项目属性最小值
	 * @return String
	 */
	public String getDevalmin() {
		return ((String) getAttrVal("Devalmin"));
	}
	/**
	 * 测量项目属性最小值
	 * @param Devalmin
	 */
	public void setDevalmin(String Devalmin) {
		setAttrVal("Devalmin", Devalmin);
	}
	/**
	 * 启用部位
	 * @return FBoolean
	 */
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}
	/**
	 * 启用部位
	 * @param Fg_pos
	 */
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	/**
	 * 启用辅助措施
	 * @return FBoolean
	 */
	public FBoolean getFg_aux() {
		return ((FBoolean) getAttrVal("Fg_aux"));
	}
	/**
	 * 启用辅助措施
	 * @param Fg_aux
	 */
	public void setFg_aux(FBoolean Fg_aux) {
		setAttrVal("Fg_aux", Fg_aux);
	}
	/**
	 * 值个数
	 * @return String
	 */
	public String getValcount() {
		return ((String) getAttrVal("Valcount"));
	}
	/**
	 * 值个数
	 * @param Valcount
	 */
	public void setValcount(String Valcount) {
		setAttrVal("Valcount", Valcount);
	}
	/**
	 * 数据源值域编码
	 * @return String
	 */
	public String getValdomaincode() {
		return ((String) getAttrVal("Valdomaincode"));
	}
	/**
	 * 数据源值域编码
	 * @param Valdomaincode
	 */
	public void setValdomaincode(String Valdomaincode) {
		setAttrVal("Valdomaincode", Valdomaincode);
	}
	/**
	 * 部位分类
	 * @return String
	 */
	public String getId_pos_ca() {
		return ((String) getAttrVal("Id_pos_ca"));
	}
	/**
	 * 部位分类
	 * @param Id_pos_ca
	 */
	public void setId_pos_ca(String Id_pos_ca) {
		setAttrVal("Id_pos_ca", Id_pos_ca);
	}
	/**
	 * 默认部位
	 * @return String
	 */
	public String getDefault_pos() {
		return ((String) getAttrVal("Default_pos"));
	}
	/**
	 * 默认部位
	 * @param Default_pos
	 */
	public void setDefault_pos(String Default_pos) {
		setAttrVal("Default_pos", Default_pos);
	}
	/**
	 * 默认部位编码
	 * @return String
	 */
	public String getSd_def_pos() {
		return ((String) getAttrVal("Sd_def_pos"));
	}
	/**
	 * 默认部位编码
	 * @param Sd_def_pos
	 */
	public void setSd_def_pos(String Sd_def_pos) {
		setAttrVal("Sd_def_pos", Sd_def_pos);
	}
	/**
	 * 辅助措施分类
	 * @return String
	 */
	public String getId_aux_ca() {
		return ((String) getAttrVal("Id_aux_ca"));
	}
	/**
	 * 辅助措施分类
	 * @param Id_aux_ca
	 */
	public void setId_aux_ca(String Id_aux_ca) {
		setAttrVal("Id_aux_ca", Id_aux_ca);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getSd_dedatatp() {
		return ((String) getAttrVal("Sd_dedatatp"));
	}
	/**
	 * 数据类型
	 * @param Sd_dedatatp
	 */
	public void setSd_dedatatp(String Sd_dedatatp) {
		setAttrVal("Sd_dedatatp", Sd_dedatatp);
	}
	/**
	 * 生命体征测量单属性ID
	 * @return String
	 */
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}
	/**
	 * 生命体征测量单属性ID
	 * @param Id_mrtplvt
	 */
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 所属组
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}
	/**
	 * 所属组
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 是否默认项
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}
	/**
	 * 是否默认项
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 默认值ID
	 * @return String
	 */
	public String getId_default() {
		return ((String) getAttrVal("Id_default"));
	}
	/**
	 * 默认值ID
	 * @param Id_default
	 */
	public void setId_default(String Id_default) {
		setAttrVal("Id_default", Id_default);
	}
	/**
	 * 默认值
	 * @return String
	 */
	public String getVal_default() {
		return ((String) getAttrVal("Val_default"));
	}
	/**
	 * 默认值
	 * @param Val_default
	 */
	public void setVal_default(String Val_default) {
		setAttrVal("Val_default", Val_default);
	}
	/**
	 * 数据来源
	 * @return String
	 */
	public String getCode_dataorigin() {
		return ((String) getAttrVal("Code_dataorigin"));
	}
	/**
	 * 数据来源
	 * @param Code_dataorigin
	 */
	public void setCode_dataorigin(String Code_dataorigin) {
		setAttrVal("Code_dataorigin", Code_dataorigin);
	}
	/**
	 * 下拉允许编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}
	/**
	 * 下拉允许编辑
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 精度
	 * @return Integer
	 */
	public Integer getPrecision() {
		return ((Integer) getAttrVal("Precision"));
	}
	/**
	 * 精度
	 * @param Precision
	 */
	public void setPrecision(Integer Precision) {
		setAttrVal("Precision", Precision);
	}
	/**
	 * 长度
	 * @return Integer
	 */
	public Integer getLen() {
		return ((Integer) getAttrVal("Len"));
	}
	/**
	 * 长度
	 * @param Len
	 */
	public void setLen(Integer Len) {
		setAttrVal("Len", Len);
	}
}