package iih.ci.ord.i.external.obtain.meta.hp;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;

/**
 * 医保校验医嘱服务项目属性
 * 
 * @author HUMS
 *
 */
public class HpVerifyOrdParamDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}

	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}

	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}

	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}

	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}

	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}

	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}

	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}

	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}

	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}

	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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

	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}

	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}

	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}

	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}

	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}

	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}

}
