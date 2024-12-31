package iih.mp.ne.transfusiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 *  待输血袋信息 DTO数据 
 * 
 */
public class PreTrsBloodDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 血袋ID
	 * @return String
	 */
	public String getId_rptbttestitm() {
		return ((String) getAttrVal("Id_rptbttestitm"));
	}
	/**
	 * 血袋ID
	 * @param Id_rptbttestitm
	 */
	public void setId_rptbttestitm(String Id_rptbttestitm) {
		setAttrVal("Id_rptbttestitm", Id_rptbttestitm);
	}
	/**
	 * 备血检验结果
	 * @return String
	 */
	public String getId_rptbttest() {
		return ((String) getAttrVal("Id_rptbttest"));
	}
	/**
	 * 备血检验结果
	 * @param Id_rptbttest
	 */
	public void setId_rptbttest(String Id_rptbttest) {
		setAttrVal("Id_rptbttest", Id_rptbttest);
	}
	/**
	 * 用血医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 用血医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 取血标识
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 取血标识
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 血袋条码
	 * @return String
	 */
	public String getBarcode_bb() {
		return ((String) getAttrVal("Barcode_bb"));
	}
	/**
	 * 血袋条码
	 * @param Barcode_bb
	 */
	public void setBarcode_bb(String Barcode_bb) {
		setAttrVal("Barcode_bb", Barcode_bb);
	}
	/**
	 * 血袋名称
	 * @return String
	 */
	public String getName_bt() {
		return ((String) getAttrVal("Name_bt"));
	}
	/**
	 * 血袋名称
	 * @param Name_bt
	 */
	public void setName_bt(String Name_bt) {
		setAttrVal("Name_bt", Name_bt);
	}
	/**
	 * 血型ID
	 * @return String
	 */
	public String getId_abo() {
		return ((String) getAttrVal("Id_abo"));
	}
	/**
	 * 血型ID
	 * @param Id_abo
	 */
	public void setId_abo(String Id_abo) {
		setAttrVal("Id_abo", Id_abo);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_abo() {
		return ((String) getAttrVal("Sd_abo"));
	}
	/**
	 * 血型编码
	 * @param Sd_abo
	 */
	public void setSd_abo(String Sd_abo) {
		setAttrVal("Sd_abo", Sd_abo);
	}
	/**
	 * 血型名称
	 * @return String
	 */
	public String getName_abo() {
		return ((String) getAttrVal("Name_abo"));
	}
	/**
	 * 血型名称
	 * @param Name_abo
	 */
	public void setName_abo(String Name_abo) {
		setAttrVal("Name_abo", Name_abo);
	}
	/**
	 * 血液RhID
	 * @return String
	 */
	public String getId_rh() {
		return ((String) getAttrVal("Id_rh"));
	}
	/**
	 * 血液RhID
	 * @param Id_rh
	 */
	public void setId_rh(String Id_rh) {
		setAttrVal("Id_rh", Id_rh);
	}
	/**
	 * 血液Rh编码
	 * @return String
	 */
	public String getSd_rh() {
		return ((String) getAttrVal("Sd_rh"));
	}
	/**
	 * 血液Rh编码
	 * @param Sd_rh
	 */
	public void setSd_rh(String Sd_rh) {
		setAttrVal("Sd_rh", Sd_rh);
	}
	/**
	 * 血液Rh名称
	 * @return String
	 */
	public String getName_rh() {
		return ((String) getAttrVal("Name_rh"));
	}
	/**
	 * 血液Rh名称
	 * @param Name_rh
	 */
	public void setName_rh(String Name_rh) {
		setAttrVal("Name_rh", Name_rh);
	}
	/**
	 * 规格
	 * @return FDouble
	 */
	public FDouble getNum_bb() {
		return ((FDouble) getAttrVal("Num_bb"));
	}
	/**
	 * 规格
	 * @param Num_bb
	 */
	public void setNum_bb(FDouble Num_bb) {
		setAttrVal("Num_bb", Num_bb);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit_bb() {
		return ((String) getAttrVal("Id_unit_bb"));
	}
	/**
	 * 单位
	 * @param Id_unit_bb
	 */
	public void setId_unit_bb(String Id_unit_bb) {
		setAttrVal("Id_unit_bb", Id_unit_bb);
	}
}