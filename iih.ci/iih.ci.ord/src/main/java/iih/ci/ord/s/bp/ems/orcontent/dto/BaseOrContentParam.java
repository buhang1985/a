package iih.ci.ord.s.bp.ems.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.s.ems.orcontent.meta.OrContentDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 医嘱内容拼接的参数类
 * @author zwq
 *
 */
public class BaseOrContentParam extends BaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BaseOrContentParam(){}
	public BaseOrContentParam(String sd_srvtp,String note_or,List<OrContentDTO> drugs){
		this.setSd_srvtp(sd_srvtp);
		this.setNote(note_or);
		String[] name_srvs = new String[drugs.size()];
		FDouble[] quan_meds = new FDouble[drugs.size()];
		String[] name_unit_meds = new String[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			OrContentDTO drug = drugs.get(i);
			name_srvs[i] = drug.getName_srv();
			quan_meds[i] = drug.getQuan_med();
			name_unit_meds[i] = drug.getName_unit_med();
		}
		this.setName_srvs(name_srvs);
		this.setQuan_meds(quan_meds);
		this.setName_unit_meds(name_unit_meds);
	}
	public BaseOrContentParam(String sd_srvtp,String note_or,FArrayList drugs,Object param){
		this.setSd_srvtp(sd_srvtp);
		this.setNote(note_or);
		String[] name_srvs = new String[drugs.size()];
		FDouble[] quan_meds = new FDouble[drugs.size()];
		String[] name_unit_meds = new String[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			EmsOrDrug drug = (EmsOrDrug)drugs.get(i);
			name_srvs[i] = drug.getName_srv();
			quan_meds[i] = drug.getQuan_med();
			name_unit_meds[i] = drug.getName_unit_med();
		}
		this.setName_srvs(name_srvs);
		this.setQuan_meds(quan_meds);
		this.setName_unit_meds(name_unit_meds);
	}
	
	public Integer getUse_days() {
		return ((Integer) getAttrVal("Use_days"));
	}
	public void setUse_days(Integer Use_days) {
		setAttrVal("Use_days", Use_days);
	}
	/**
	 * 服务类型
	 * @return
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 备注
	 * @return
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 服务名称
	 * @return
	 */
	public String[] getName_srvs(){
		return ((String[])getAttrVal("Name_srvs"));
	}
	/**
	 * 服务名称
	 * @param Name_srvs
	 */
	public void setName_srvs(String[] Name_srvs) {
		setAttrVal("Name_srvs", Name_srvs);
	}
	/**
	 * 剂量
	 * @return
	 */
	public FDouble[] getQuan_meds(){
		return ((FDouble[])getAttrVal("Quan_meds"));
	}
	/**
	 * 剂量
	 * @param Quan_meds
	 */
	public void setQuan_meds(FDouble[] Quan_meds) {
		setAttrVal("Quan_meds", Quan_meds);
	}
	/**
	 * 剂量单位
	 * @return
	 */
	public String[] getName_unit_meds(){
		return ((String[])getAttrVal("Name_unit_meds"));
	}
	/**
	 * 剂量单位
	 * @param Name_unit_meds
	 */
	public void setName_unit_meds(String[] Name_unit_meds) {
		setAttrVal("Name_unit_meds", Name_unit_meds);
	}
}
