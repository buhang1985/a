package iih.bd.pp.samppricnstdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 儿童采集费用对照 DTO数据 
 * 
 */
public class SampPricnstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验标本费用
	 * @return String
	 */
	public String getId_chld_cnst() {
		return ((String) getAttrVal("Id_chld_cnst"));
	}
	/**
	 * 检验标本费用
	 * @param Id_chld_cnst
	 */
	public void setId_chld_cnst(String Id_chld_cnst) {
		setAttrVal("Id_chld_cnst", Id_chld_cnst);
	}
	/**
	 * 费用类型
	 * @return Integer
	 */
	public Integer getSamppri_eu_pritp() {
		return ((Integer) getAttrVal("Samppri_eu_pritp"));
	}
	/**
	 * 费用类型
	 * @param Samppri_eu_pritp
	 */
	public void setSamppri_eu_pritp(Integer Samppri_eu_pritp) {
		setAttrVal("Samppri_eu_pritp", Samppri_eu_pritp);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getSamppri_id_srv() {
		return ((String) getAttrVal("Samppri_id_srv"));
	}
	/**
	 * 服务ID
	 * @param Samppri_id_srv
	 */
	public void setSamppri_id_srv(String Samppri_id_srv) {
		setAttrVal("Samppri_id_srv", Samppri_id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSamppri_ser_name() {
		return ((String) getAttrVal("Samppri_ser_name"));
	}
	/**
	 * 服务名称
	 * @param Samppri_ser_name
	 */
	public void setSamppri_ser_name(String Samppri_ser_name) {
		setAttrVal("Samppri_ser_name", Samppri_ser_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSamppri_code() {
		return ((String) getAttrVal("Samppri_code"));
	}
	/**
	 * 服务编码
	 * @param Samppri_code
	 */
	public void setSamppri_code(String Samppri_code) {
		setAttrVal("Samppri_code", Samppri_code);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getSamppri_unit() {
		return ((String) getAttrVal("Samppri_unit"));
	}
	/**
	 * 单位
	 * @param Samppri_unit
	 */
	public void setSamppri_unit(String Samppri_unit) {
		setAttrVal("Samppri_unit", Samppri_unit);
	}
	/**
	 * 参考价
	 * @return FDouble
	 */
	public FDouble getSamppri_pri_std() {
		return ((FDouble) getAttrVal("Samppri_pri_std"));
	}
	/**
	 * 参考价
	 * @param Samppri_pri_std
	 */
	public void setSamppri_pri_std(FDouble Samppri_pri_std) {
		setAttrVal("Samppri_pri_std", Samppri_pri_std);
	}
	/**
	 * 对照服务
	 * @return String
	 */
	public String getContrast_id_srv() {
		return ((String) getAttrVal("Contrast_id_srv"));
	}
	/**
	 * 对照服务
	 * @param Contrast_id_srv
	 */
	public void setContrast_id_srv(String Contrast_id_srv) {
		setAttrVal("Contrast_id_srv", Contrast_id_srv);
	}
	/**
	 * 对照服务名称
	 * @return String
	 */
	public String getContrast_srv_name() {
		return ((String) getAttrVal("Contrast_srv_name"));
	}
	/**
	 * 对照服务名称
	 * @param Contrast_srv_name
	 */
	public void setContrast_srv_name(String Contrast_srv_name) {
		setAttrVal("Contrast_srv_name", Contrast_srv_name);
	}
	/**
	 * 对照服务编码
	 * @return String
	 */
	public String getContrast_code() {
		return ((String) getAttrVal("Contrast_code"));
	}
	/**
	 * 对照服务编码
	 * @param Contrast_code
	 */
	public void setContrast_code(String Contrast_code) {
		setAttrVal("Contrast_code", Contrast_code);
	}
	/**
	 * 对照单位
	 * @return String
	 */
	public String getContrast_unit() {
		return ((String) getAttrVal("Contrast_unit"));
	}
	/**
	 * 对照单位
	 * @param Contrast_unit
	 */
	public void setContrast_unit(String Contrast_unit) {
		setAttrVal("Contrast_unit", Contrast_unit);
	}
	/**
	 * 对照参考价
	 * @return FDouble
	 */
	public FDouble getContrast_pri_std() {
		return ((FDouble) getAttrVal("Contrast_pri_std"));
	}
	/**
	 * 对照参考价
	 * @param Contrast_pri_std
	 */
	public void setContrast_pri_std(FDouble Contrast_pri_std) {
		setAttrVal("Contrast_pri_std", Contrast_pri_std);
	}
}