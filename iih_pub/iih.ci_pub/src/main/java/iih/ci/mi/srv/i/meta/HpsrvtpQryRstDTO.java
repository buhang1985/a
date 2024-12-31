package iih.ci.mi.srv.i.meta;

/**
 * 获取医保目录返回结果
 * 
 * @author HUMS
 *
 */
public class HpsrvtpQryRstDTO extends HpsrvtpQryParamDTO {

	private static final long serialVersionUID = 1L;

	public HpsrvtpQryRstDTO() {

	}

	public HpsrvtpQryRstDTO(String id_hp, String id_srv, String id_mm, String id_hpsrvtp, String sd_hpsrvtp,
			String name_hpsrvtp) {
		super(id_srv, id_mm);

		this.setId_hp(id_hp);
		this.setId_hpsrvtp(id_hpsrvtp);
		this.setSd_hpsrvtp(sd_hpsrvtp);
		this.setName_hpsrvtp(name_hpsrvtp);
	}

	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}

	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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

}
