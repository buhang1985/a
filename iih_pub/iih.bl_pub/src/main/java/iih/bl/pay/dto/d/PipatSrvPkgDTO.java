package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * pipatsrvpkgdto DTO数据 
 * 
 */
public class PipatSrvPkgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务包主键
	 * @return String
	 */
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}
	/**
	 * 服务包主键
	 * @param Id_srvpkg
	 */
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	/**
	 * 费用包主键
	 * @return String
	 */
	public String getId_pripkg() {
		return ((String) getAttrVal("Id_pripkg"));
	}
	/**
	 * 费用包主键
	 * @param Id_pripkg
	 */
	public void setId_pripkg(String Id_pripkg) {
		setAttrVal("Id_pripkg", Id_pripkg);
	}
	/**
	 * 服务包名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务包名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务包编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 服务包编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 是否已经付款
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}
	/**
	 * 是否已经付款
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 标志位
	 * @return Integer
	 */
	public Integer getMark() {
		return ((Integer) getAttrVal("Mark"));
	}
	/**
	 * 标志位
	 * @param Mark
	 */
	public void setMark(Integer Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者住院号
	 * @return String
	 */
	public String getCode_ent_in() {
		return ((String) getAttrVal("Code_ent_in"));
	}
	/**
	 * 患者住院号
	 * @param Code_ent_in
	 */
	public void setCode_ent_in(String Code_ent_in) {
		setAttrVal("Code_ent_in", Code_ent_in);
	}
	/**
	 * 收款员姓名
	 * @return String
	 */
	public String getName_empinc() {
		return ((String) getAttrVal("Name_empinc"));
	}
	/**
	 * 收款员姓名
	 * @param Name_empinc
	 */
	public void setName_empinc(String Name_empinc) {
		setAttrVal("Name_empinc", Name_empinc);
	}
	/**
	 * 打印收据时间
	 * @return FDateTime
	 */
	public FDateTime getDt_print() {
		return ((FDateTime) getAttrVal("Dt_print"));
	}
	/**
	 * 打印收据时间
	 * @param Dt_print
	 */
	public void setDt_print(FDateTime Dt_print) {
		setAttrVal("Dt_print", Dt_print);
	}
	/**
	 * 收据号
	 * @return String
	 */
	public String getReceiptno() {
		return ((String) getAttrVal("Receiptno"));
	}
	/**
	 * 收据号
	 * @param Receiptno
	 */
	public void setReceiptno(String Receiptno) {
		setAttrVal("Receiptno", Receiptno);
	}
	/**
	 * 打印收据正文
	 * @return String
	 */
	public String getDetail() {
		return ((String) getAttrVal("Detail"));
	}
	/**
	 * 打印收据正文
	 * @param Detail
	 */
	public void setDetail(String Detail) {
		setAttrVal("Detail", Detail);
	}
}