package iih.bl.cg.ipfeetail;

import java.util.List;

public class DayIpFeeDetailDTO {
	
	public String date;//日期
	public String name_pat;//患者名称
	public String code_amr_ip;//住院病历号
	public List<DayIpCgInfoDTO> cgList;//费用列表
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getCode_amr_ip() {
		return code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	public List<DayIpCgInfoDTO> getCgList() {
		return cgList;
	}
	public void setCgList(List<DayIpCgInfoDTO> cgList) {
		this.cgList = cgList;
	}
}
