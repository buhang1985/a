package iih.en.itf.bean.output.opapt;

import iih.en.itf.bean.output.WsEnResultInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 挂号划价(医保流程调用)Ws出参
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnResultRegPricing extends WsEnResultInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 结算id
	 */
	@XmlElement(name = "id_stoep")
	private String id_stoep;
	/**
	 * 结算流水号
	 */
	@XmlElement(name = "code_st")
	private String code_st;
	/**
	 * 总金额
	 */
	@XmlElement(name = "amt")
	private float amt;
	/**
	 * 医保登记串
	 */
	@XmlElement(name = "hpregisterinfo")
	private String hpregisterinfo;
	/**
	 * 医保明细上传串
	 */
	@XmlElement(name = "hpdetailuploadinfo")
	private String hpdetailuploadinfo;
	/**
	 * 医保预结算串
	 */
	@XmlElement(name = "hpprestinfo")
	private String hpprestinfo;
	
	public String getId_stoep() {
		return id_stoep;
	}
	
	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}
	
	public String getCode_st() {
		return code_st;
	}
	
	public void setCode_st(String code_st) {
		this.code_st = code_st;
	}
	
	public float getAmt() {
		return amt;
	}
	
	public void setAmt(float amt) {
		this.amt = amt;
	}
	
	public String getHpregisterinfo() {
		return hpregisterinfo;
	}
	
	public void setHpregisterinfo(String hpregisterinfo) {
		this.hpregisterinfo = hpregisterinfo;
	}
	
	public String getHpdetailuploadinfo() {
		return hpdetailuploadinfo;
	}
	
	public void setHpdetailuploadinfo(String hpdetailuploadinfo) {
		this.hpdetailuploadinfo = hpdetailuploadinfo;
	}
	
	public String getHpprestinfo() {
		return hpprestinfo;
	}
	
	public void setHpprestinfo(String hpprestinfo) {
		this.hpprestinfo = hpprestinfo;
	}
}
