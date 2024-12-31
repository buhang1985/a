package iih.mbh.en.patinfo.d;

/**
 * 患者就诊状况
 * 
 */
public class PatientEnState {

	/** 就诊ID */
	private String id_ent;
	/** 就诊状况名称 */
	private String name;
	/** 就诊状况色值 */
	private String colorvalue;
	/** 就诊状况id */
	private String id_enstate;

	/** getter and setter */

	public String getId_ent() {
		return this.id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColorvalue() {
		return this.colorvalue;
	}

	public void setColorvalue(String colorvalue) {
		this.colorvalue = colorvalue;
	}

	public String getId_enstate() {
		return id_enstate;
	}

	public void setId_enstate(String id_enstate) {
		this.id_enstate = id_enstate;
	}

}