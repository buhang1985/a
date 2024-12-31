package iih.mp.nr.dto;

import java.util.List;

/**
 * 治理护理项目执行单
 * 患者信息
 * @author hjh
 *
 */
public class PatInfoDataDTO {

	private String name_bed;
	private String code_amr_ip;
	private String name_pat;
	private String name_sex;
	private String id_ent;
	private String name_dep_nur;
	private List<CureListDTO> listDTO;
	public String getName_bed() {
		return name_bed;
	}
	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}
	public String getCode_amr_ip() {
		return code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getName_sex() {
		return name_sex;
	}
	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getName_dep_nur() {
		return name_dep_nur;
	}
	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}
	public List<CureListDTO> getListDTO() {
		return listDTO;
	}
	public void setListDTO(List<CureListDTO> listDTO) {
		this.listDTO = listDTO;
	} 
	
}
