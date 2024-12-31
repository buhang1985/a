package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 药局基本信息JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindPharmacyDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "CKID")
	private String ckid;
	@XmlElement(name = "CKBH")
	private String ckbh;
	@XmlElement(name = "CKNAME")
	private String ckname;
	@XmlElement(name = "CLASS_NO")
	private String class_no;
	@XmlElement(name = "BEACTIVE")
	private String beactive;
	@XmlElement(name = "NOTE")
	private String note;

	/**
	 * 药局ID
	 * 
	 * @return
	 */
	public String getCkid() {
		return ckid;
	}

	/**
	 * 药局ID
	 * 
	 * @param ckid
	 */
	public void setCkid(String ckid) {
		this.ckid = ckid;
	}

	/**
	 * 药局编号
	 * 
	 * @return
	 */
	public String getCkbh() {
		return ckbh;
	}

	/**
	 * 药局编号
	 * 
	 * @param ckbh
	 */
	public void setCkbh(String ckbh) {
		this.ckbh = ckbh;
	}

	/**
	 * 药局名称
	 * 
	 * @return
	 */
	public String getCkname() {
		return ckname;
	}

	/**
	 * 药局名称
	 * 
	 * @param ckname
	 */
	public void setCkname(String ckname) {
		this.ckname = ckname;
	}

	/**
	 * 分类
	 * 
	 * @return
	 */
	public String getClass_no() {
		return class_no;
	}

	/**
	 * 分类
	 * 
	 * @param class_no
	 */
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}

	/**
	 * 是否活动（是）
	 * 
	 * @return
	 */
	public String getBeactive() {
		return beactive;
	}

	/**
	 * 是否活动（是）
	 * 
	 * @param beactive
	 */
	public void setBeactive(String beactive) {
		this.beactive = beactive;
	}

	/**
	 * 备注
	 * 
	 * @return
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
