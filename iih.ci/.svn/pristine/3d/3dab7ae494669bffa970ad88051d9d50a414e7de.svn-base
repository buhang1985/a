package iih.ci.sdk.orctt.meta;

import java.util.List;

import xap.mw.coreitf.d.FDateTime;

public class OprOrContentParam extends BaseOrContentParam {

	public OprOrContentParam(){
		
	}
	public OprOrContentParam(String sd_srvtp,FDateTime dt_begin,String name_routedes,String note,List<OrContentDTO> list){
		this.setSd_srvtp(sd_srvtp);
		this.setDt_begin(dt_begin);
		this.setName_routedes(name_routedes);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for(int i=0;i<list.size();i++){
			OrContentDTO opr = list.get(i);
			name_srvs[i] = opr.getName_srv();
		}
		this.setName_srvs(name_srvs);
	}
	/**
	 * 开始日期
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}

	/**
	 * 开始日期
	 * 
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 附加术名称拼接
	 * 
	 * @return String
	 */
	public String getName_opex() {
		return ((String) getAttrVal("Name_opex"));
	}

	/**
	 * 附加术名称拼接
	 * 
	 * @param Name_opex
	 */
	public void setName_opex(String Name_opex) {
		setAttrVal("Name_opex", Name_opex);
	}
	/**
	 * 麻醉方式	
	 * @return
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	/**
	 * 麻醉方式
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
}
