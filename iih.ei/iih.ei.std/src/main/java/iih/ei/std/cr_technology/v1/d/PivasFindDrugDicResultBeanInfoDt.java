package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 药品字典JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindDrugDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "SPID")
	private String spid;
	@XmlElement(name = "SPBH")
	private String spbh;
	@XmlElement(name = "SPMCH")
	private String spmch;
	@XmlElement(name = "ENGLISH_NAME")
	private String english_name;
	@XmlElement(name = "TONGYMCH")
	private String tongymch;
	@XmlElement(name = "PRINTNAME")
	private String printname;
	@XmlElement(name = "SHPGG")
	private String shpgg;
	@XmlElement(name = "DW")
	private String dw;
	@XmlElement(name = "USEJLGG")
	private String usejlgg;
	@XmlElement(name = "USEDW")
	private String usedw;
	@XmlElement(name = "PACKET_DW")
	private String packet_dw;
	@XmlElement(name = "JIXING")
	private String jixing;
	@XmlElement(name = "PYM")
	private String pym;
	@XmlElement(name = "PIZHWH")
	private String pizhwh;
	@XmlElement(name = "SHPCHD")
	private String shpchd;
	@XmlElement(name = "XGDATETIME")
	private String xgdatetime;
	@XmlElement(name = "CLASS_CODE")
	private String class_code;
	@XmlElement(name = "CLASS_NAME")
	private String class_name;
	@XmlElement(name = "SPBH_PASS")
	private String spbh_pass;

	/**
	 * 商品ID
	 * 
	 * @return
	 */
	public String getSpid() {
		return spid;
	}

	/**
	 * 商品ID
	 * 
	 * @param spid
	 */
	public void setSpid(String spid) {
		this.spid = spid;
	}

	/**
	 * 商品编号
	 * 
	 * @return
	 */
	public String getSpbh() {
		return spbh;
	}

	/**
	 * 商品编号
	 * 
	 * @param spbh
	 */
	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	/**
	 * 商品名称
	 * 
	 * @return
	 */
	public String getSpmch() {
		return spmch;
	}

	/**
	 * 商品名称
	 * 
	 * @param spmch
	 */
	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	/**
	 * 英文名称
	 * 
	 * @return
	 */
	public String getEnglish_name() {
		return english_name;
	}

	/**
	 * 英文名称
	 * 
	 * @param english_name
	 */
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}

	/**
	 * 通用名称
	 * 
	 * @return
	 */
	public String getTongymch() {
		return tongymch;
	}

	/**
	 * 通用名称
	 * 
	 * @param tongymch
	 */
	public void setTongymch(String tongymch) {
		this.tongymch = tongymch;
	}
	
	/**
	 * 打印名称
	 * 
	 * @return
	 */
	public String getPrintname() {
		return printname;
	}

	/**
	 * 打印名称
	 * 
	 * @param printname
	 */
	public void setPrintname(String printname) {
		this.printname = printname;
	}

	/**
	 * 商品规格
	 * 
	 * @return
	 */
	public String getShpgg() {
		return shpgg;
	}

	/**
	 * 商品规格
	 * 
	 * @param shpgg
	 */
	public void setShpgg(String shpgg) {
		this.shpgg = shpgg;
	}

	/**
	 * 单位
	 * 
	 * @return
	 */
	public String getDw() {
		return dw;
	}

	/**
	 * 单位
	 * 
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}

	/**
	 * 使用剂量
	 * 
	 * @return
	 */
	public String getUsejlgg() {
		return usejlgg;
	}

	/**
	 * 使用剂量
	 * 
	 * @param usejlgg
	 */
	public void setUsejlgg(String usejlgg) {
		this.usejlgg = usejlgg;
	}

	/**
	 * 使用单位
	 * 
	 * @return
	 */
	public String getUsedw() {
		return usedw;
	}

	/**
	 * 使用单位
	 * 
	 * @param usedw
	 */
	public void setUsedw(String usedw) {
		this.usedw = usedw;
	}

	/**
	 * 大包装单位
	 * 
	 * @return
	 */
	public String getPacket_dw() {
		return packet_dw;
	}

	/**
	 * 大包装单位
	 * 
	 * @param packet_dw
	 */
	public void setPacket_dw(String packet_dw) {
		this.packet_dw = packet_dw;
	}

	/**
	 * 剂型
	 * 
	 * @return
	 */
	public String getJixing() {
		return jixing;
	}

	/**
	 * 剂型
	 * 
	 * @param jixing
	 */
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	/**
	 * 拼音码
	 * 
	 * @return
	 */
	public String getPym() {
		return pym;
	}

	/**
	 * 拼音码
	 * 
	 * @param pym
	 */
	public void setPym(String pym) {
		this.pym = pym;
	}

	/**
	 * 批准文号
	 * 
	 * @return
	 */
	public String getPizhwh() {
		return pizhwh;
	}

	/**
	 * 批准文号
	 * 
	 * @param pizhwh
	 */
	public void setPizhwh(String pizhwh) {
		this.pizhwh = pizhwh;
	}

	/**
	 * 药品产地
	 * 
	 * @return
	 */
	public String getShpchd() {
		return shpchd;
	}

	/**
	 * 药品产地
	 * 
	 * @param shpchd
	 */
	public void setShpchd(String shpchd) {
		this.shpchd = shpchd;
	}

	/**
	 * 修改时间
	 * 
	 * @return
	 */
	public String getXgdatetime() {
		return xgdatetime;
	}

	/**
	 * 修改时间
	 * 
	 * @param xgdatetime
	 */
	public void setXgdatetime(String xgdatetime) {
		this.xgdatetime = xgdatetime;
	}

	/**
	 * 代码
	 * 
	 * @return
	 */
	public String getClass_code() {
		return class_code;
	}

	/**
	 * 代码
	 * 
	 * @param class_code
	 */
	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}

	/**
	 * 类别名称(汉字)
	 * 
	 * @return
	 */
	public String getClass_name() {
		return class_name;
	}

	/**
	 * 类别名称(汉字)
	 * 
	 * @param class_name
	 */
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	/**
	 * 合理用药审查的药品编号
	 * 
	 * @return
	 */
	public String getSpbh_pass() {
		return spbh_pass;
	}

	/**
	 * 合理用药审查的药品编号
	 * 
	 * @param spbh_pass
	 */
	public void setSpbh_pass(String spbh_pass) {
		this.spbh_pass = spbh_pass;
	}

}
