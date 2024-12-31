package iih.ei.std.d.v1.bd.sync.prisrvdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 价表项目DTO DTO数据 
 * 
 */
public class PriceSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 服务分类编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}	
	/**
	 * 计量单位编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 门诊账单项编码
	 * @return String
	 */
	public String getCode_inc_op() {
		return ((String) getAttrVal("Code_inc_op"));
	}	
	/**
	 * 门诊账单项编码
	 * @param Code_inc_op
	 */
	public void setCode_inc_op(String Code_inc_op) {
		setAttrVal("Code_inc_op", Code_inc_op);
	}
	/**
	 * 住院账单项编码
	 * @return String
	 */
	public String getCode_inc_ip() {
		return ((String) getAttrVal("Code_inc_ip"));
	}	
	/**
	 * 住院账单项编码
	 * @param Code_inc_ip
	 */
	public void setCode_inc_ip(String Code_inc_ip) {
		setAttrVal("Code_inc_ip", Code_inc_ip);
	}
	/**
	 * 收费分类编码
	 * @return String
	 */
	public String getSd_pritp() {
		return ((String) getAttrVal("Sd_pritp"));
	}	
	/**
	 * 收费分类编码
	 * @param Sd_pritp
	 */
	public void setSd_pritp(String Sd_pritp) {
		setAttrVal("Sd_pritp", Sd_pritp);
	}
	/**
	 * 门诊核算体系编码
	 * @return String
	 */
	public String getCode_acc_op() {
		return ((String) getAttrVal("Code_acc_op"));
	}	
	/**
	 * 门诊核算体系编码
	 * @param Code_acc_op
	 */
	public void setCode_acc_op(String Code_acc_op) {
		setAttrVal("Code_acc_op", Code_acc_op);
	}
	/**
	 * 住院核算体系编码
	 * @return String
	 */
	public String getCode_acc_ip() {
		return ((String) getAttrVal("Code_acc_ip"));
	}	
	/**
	 * 住院核算体系编码
	 * @param Code_acc_ip
	 */
	public void setCode_acc_ip(String Code_acc_ip) {
		setAttrVal("Code_acc_ip", Code_acc_ip);
	}
	/**
	 * 共用核算体系编码
	 * @return String
	 */
	public String getCode_acc_share() {
		return ((String) getAttrVal("Code_acc_share"));
	}	
	/**
	 * 共用核算体系编码
	 * @param Code_acc_share
	 */
	public void setCode_acc_share(String Code_acc_share) {
		setAttrVal("Code_acc_share", Code_acc_share);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
}