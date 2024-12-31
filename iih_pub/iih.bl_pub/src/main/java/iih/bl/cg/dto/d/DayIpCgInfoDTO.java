package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院日清单 DTO数据 
 * 
 */
public class DayIpCgInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getEntid() {
		return ((String) getAttrVal("Entid"));
	}
	/**
	 * 就诊id
	 * @param Entid
	 */
	public void setEntid(String Entid) {
		setAttrVal("Entid", Entid);
	}
	/**
	 * 账单项
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 账单项
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 账单编码
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}
	/**
	 * 账单编码
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 比例单价
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 比例单价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 标准单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 标准单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 物品包装单位
	 * @return String
	 */
	public String getPgku_unit() {
		return ((String) getAttrVal("Pgku_unit"));
	}
	/**
	 * 物品包装单位
	 * @param Pgku_unit
	 */
	public void setPgku_unit(String Pgku_unit) {
		setAttrVal("Pgku_unit", Pgku_unit);
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
	 * 比例金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 比例金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 标志金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标志金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 婴儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return String
	 */
	public String getNo_bb() {
		return ((String) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(String No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 医保收费等级
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保收费等级
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 记账时间
	 * @return String
	 */
	public String getDt_cg() {
		return ((String) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(String Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getSrvid() {
		return ((String) getAttrVal("Srvid"));
	}
	/**
	 * 服务id
	 * @param Srvid
	 */
	public void setSrvid(String Srvid) {
		setAttrVal("Srvid", Srvid);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_srvunit() {
		return ((String) getAttrVal("Name_srvunit"));
	}
	/**
	 * 单位名称
	 * @param Name_srvunit
	 */
	public void setName_srvunit(String Name_srvunit) {
		setAttrVal("Name_srvunit", Name_srvunit);
	}
	/**
	 * 单位id
	 * @return String
	 */
	public String getSrvunitid() {
		return ((String) getAttrVal("Srvunitid"));
	}
	/**
	 * 单位id
	 * @param Srvunitid
	 */
	public void setSrvunitid(String Srvunitid) {
		setAttrVal("Srvunitid", Srvunitid);
	}
	/**
	 * 婴儿显示名称
	 * @return String
	 */
	public String getFg_bb_name() {
		return ((String) getAttrVal("Fg_bb_name"));
	}
	/**
	 * 婴儿显示名称
	 * @param Fg_bb_name
	 */
	public void setFg_bb_name(String Fg_bb_name) {
		setAttrVal("Fg_bb_name", Fg_bb_name);
	}
}