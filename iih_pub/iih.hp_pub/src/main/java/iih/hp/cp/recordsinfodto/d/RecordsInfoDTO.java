package iih.hp.cp.recordsinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历传输信息对象 DTO数据 
 * 
 */
public class RecordsInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_entx() {
		return ((String) getAttrVal("Id_entx"));
	}
	/**
	 * 就诊号
	 * @param Id_entx
	 */
	public void setId_entx(String Id_entx) {
		setAttrVal("Id_entx", Id_entx);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病历文书类型编码（IIH）
	 * @return String
	 */
	public String getMrtp_code_iih() {
		return ((String) getAttrVal("Mrtp_code_iih"));
	}
	/**
	 * 病历文书类型编码（IIH）
	 * @param Mrtp_code_iih
	 */
	public void setMrtp_code_iih(String Mrtp_code_iih) {
		setAttrVal("Mrtp_code_iih", Mrtp_code_iih);
	}
	/**
	 * 病历文书类型编码（外部对照）
	 * @return String
	 */
	public String getMrtp_code_tgt() {
		return ((String) getAttrVal("Mrtp_code_tgt"));
	}
	/**
	 * 病历文书类型编码（外部对照）
	 * @param Mrtp_code_tgt
	 */
	public void setMrtp_code_tgt(String Mrtp_code_tgt) {
		setAttrVal("Mrtp_code_tgt", Mrtp_code_tgt);
	}
	/**
	 * 时间左区间
	 * @return FDateTime
	 */
	public FDateTime getDt_beginx() {
		return ((FDateTime) getAttrVal("Dt_beginx"));
	}
	/**
	 * 时间左区间
	 * @param Dt_beginx
	 */
	public void setDt_beginx(FDateTime Dt_beginx) {
		setAttrVal("Dt_beginx", Dt_beginx);
	}
	/**
	 * 时间右区间
	 * @return FDateTime
	 */
	public FDateTime getDt_endx() {
		return ((FDateTime) getAttrVal("Dt_endx"));
	}
	/**
	 * 时间右区间
	 * @param Dt_endx
	 */
	public void setDt_endx(FDateTime Dt_endx) {
		setAttrVal("Dt_endx", Dt_endx);
	}
	/**
	 * 病历文书ID
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 病历文书ID
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 病历文书提交时间
	 * @return FDateTime
	 */
	public FDateTime getDt_commit() {
		return ((FDateTime) getAttrVal("Dt_commit"));
	}
	/**
	 * 病历文书提交时间
	 * @param Dt_commit
	 */
	public void setDt_commit(FDateTime Dt_commit) {
		setAttrVal("Dt_commit", Dt_commit);
	}
}