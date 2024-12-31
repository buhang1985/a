package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import iih.bd.webservice.BaseWsParam;

/**
 * Pivas同步药品目录参数Bean
 * 
 * @author hao_wu 2018-6-15
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasSyncMaterialParamBean extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ccode;
	private String serial;
	private String cname;
	private String print_name;
	private String spec;
	private String dos;
	private String dosu;
	private String cap;
	private String pack_unit;
	private String spell;
	private String portno;
	private String capu;

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPrint_name() {
		return print_name;
	}

	public void setPrint_name(String print_name) {
		this.print_name = print_name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDos() {
		return dos;
	}

	public void setDos(String dos) {
		this.dos = dos;
	}

	public String getDosu() {
		return dosu;
	}

	public void setDosu(String dosu) {
		this.dosu = dosu;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getPack_unit() {
		return pack_unit;
	}

	public void setPack_unit(String pack_unit) {
		this.pack_unit = pack_unit;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getPortno() {
		return portno;
	}

	public void setPortno(String portno) {
		this.portno = portno;
	}

	public String getCapu() {
		return capu;
	}

	public void setCapu(String capu) {
		this.capu = capu;
	}
}
