package iih.ci.ord.i.mi.meta;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.coreitf.d.FBoolean;

/**
 * 服务项目默认医保信息
 * 
 * @author HUMS
 *
 */
public class DefaultOrdSrvHpInfoParamDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	// 获取医保目录类型key值，id_srv+id_mm
	public String getKey() {

		return this.getId_srv() + StringUtils.trimToEmpty(this.getId_mm());
	}

	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}

	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}

	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}

	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}

	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}

	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}

	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}

	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}

	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}

	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}

	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}

	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}

	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}

	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}

	public FBoolean getFg_mm() {

		if (StringUtils.isNotEmpty(this.getId_mm())) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
