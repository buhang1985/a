package iih.en.pv.out.ws.bean;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;

import iih.bd.webservice.BaseWsParam;

/**
 * 住院详细信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlSeeAlso({EntDiBean.class, EntHpBean.class, EntStateBean.class, EntDepTransBean.class, EntBedBean.class, EntContBean.class})
public class IpDetailInfoBean<T> extends BaseWsParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	// 病人编码
	private String PatCode = "";
	
	//就诊编码
	private String Code_ent = "";

	// 住院号
	private String Code_amr_ip = "";

	// 住院次数
	private String Times_ip = "";
	
	//就诊id
	private String Id_ent = "";
	
	//住院详细明细
	private Set<T> Item = null;
	
	//更新时间
	private String Update_time = "";
	
	public String getUpdate_time() {
		return Update_time;
	}

	public void setUpdate_time(String update_time) {
		Update_time = update_time;
	}

	public String getPatCode() {
		return PatCode;
	}

	public void setPatCode(String patCode) {
		PatCode = patCode;
	}

	public String getCode_ent() {
		return Code_ent;
	}

	public void setCode_ent(String code_ent) {
		Code_ent = code_ent;
	}

	public String getCode_amr_ip() {
		return Code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip) {
		Code_amr_ip = code_amr_ip;
	}

	public String getTimes_ip() {
		return Times_ip;
	}

	public void setTimes_ip(String times_ip) {
		Times_ip = times_ip;
	}

	public String getId_ent() {
		return Id_ent;
	}

	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}

	@XmlElementWrapper(name="Items")
	public Set<T> getItem() {
		return Item;
	}

	public void setItem(Set<T> item) {
		Item = item;
	}
	
	
	
	
}
