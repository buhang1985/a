package iih.bl.inc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发票领用信息dto DTO数据 
 * 
 */
public class BlIncissOepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 票据领用主键id
	 * @return String
	 */
	public String getId_inciss() {
		return ((String) getAttrVal("Id_inciss"));
	}
	/**
	 * 票据领用主键id
	 * @param Id_inciss
	 */
	public void setId_inciss(String Id_inciss) {
		setAttrVal("Id_inciss", Id_inciss);
	}
	/**
	 * 票据类型
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}
	/**
	 * 票据类型
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 当前票据包
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}
	/**
	 * 当前票据包
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 票据领用人
	 * @return String
	 */
	public String getId_emp_iss() {
		return ((String) getAttrVal("Id_emp_iss"));
	}
	/**
	 * 票据领用人
	 * @param Id_emp_iss
	 */
	public void setId_emp_iss(String Id_emp_iss) {
		setAttrVal("Id_emp_iss", Id_emp_iss);
	}
	/**
	 * 领用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_iss() {
		return ((FDateTime) getAttrVal("Dt_iss"));
	}
	/**
	 * 领用时间
	 * @param Dt_iss
	 */
	public void setDt_iss(FDateTime Dt_iss) {
		setAttrVal("Dt_iss", Dt_iss);
	}
	/**
	 * 票据起始号
	 * @return String
	 */
	public String getNum_b() {
		return ((String) getAttrVal("Num_b"));
	}
	/**
	 * 票据起始号
	 * @param Num_b
	 */
	public void setNum_b(String Num_b) {
		setAttrVal("Num_b", Num_b);
	}
	/**
	 * 票据结束号
	 * @return String
	 */
	public String getNum_e() {
		return ((String) getAttrVal("Num_e"));
	}
	/**
	 * 票据结束号
	 * @param Num_e
	 */
	public void setNum_e(String Num_e) {
		setAttrVal("Num_e", Num_e);
	}
	/**
	 * 票据领用张数
	 * @return Integer
	 */
	public Integer getInccn() {
		return ((Integer) getAttrVal("Inccn"));
	}
	/**
	 * 票据领用张数
	 * @param Inccn
	 */
	public void setInccn(Integer Inccn) {
		setAttrVal("Inccn", Inccn);
	}
	/**
	 * 可使用张数
	 * @return Integer
	 */
	public Integer getInccn_use() {
		return ((Integer) getAttrVal("Inccn_use"));
	}
	/**
	 * 可使用张数
	 * @param Inccn_use
	 */
	public void setInccn_use(Integer Inccn_use) {
		setAttrVal("Inccn_use", Inccn_use);
	}
	/**
	 * 下次使用票据号
	 * @return String
	 */
	public String getIncno_cur() {
		return ((String) getAttrVal("Incno_cur"));
	}
	/**
	 * 下次使用票据号
	 * @param Incno_cur
	 */
	public void setIncno_cur(String Incno_cur) {
		setAttrVal("Incno_cur", Incno_cur);
	}
	/**
	 * 当前使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_curuse() {
		return ((FBoolean) getAttrVal("Fg_curuse"));
	}
	/**
	 * 当前使用标识
	 * @param Fg_curuse
	 */
	public void setFg_curuse(FBoolean Fg_curuse) {
		setAttrVal("Fg_curuse", Fg_curuse);
	}
	/**
	 * 可使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 可使用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 已转移的总张数
	 * @return Integer
	 */
	public Integer getInccn_trans() {
		return ((Integer) getAttrVal("Inccn_trans"));
	}
	/**
	 * 已转移的总张数
	 * @param Inccn_trans
	 */
	public void setInccn_trans(Integer Inccn_trans) {
		setAttrVal("Inccn_trans", Inccn_trans);
	}
	/**
	 * 已作废的总张数
	 * @return Integer
	 */
	public Integer getInccn_canc() {
		return ((Integer) getAttrVal("Inccn_canc"));
	}
	/**
	 * 已作废的总张数
	 * @param Inccn_canc
	 */
	public void setInccn_canc(Integer Inccn_canc) {
		setAttrVal("Inccn_canc", Inccn_canc);
	}
	/**
	 * 已退回的总张数
	 * @return Integer
	 */
	public Integer getInccn_ret() {
		return ((Integer) getAttrVal("Inccn_ret"));
	}
	/**
	 * 已退回的总张数
	 * @param Inccn_ret
	 */
	public void setInccn_ret(Integer Inccn_ret) {
		setAttrVal("Inccn_ret", Inccn_ret);
	}
	/**
	 * 已核销总张数
	 * @return Integer
	 */
	public Integer getInccn_wf() {
		return ((Integer) getAttrVal("Inccn_wf"));
	}
	/**
	 * 已核销总张数
	 * @param Inccn_wf
	 */
	public void setInccn_wf(Integer Inccn_wf) {
		setAttrVal("Inccn_wf", Inccn_wf);
	}
}