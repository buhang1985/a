package iih.ci.ord.s.ems.utils.meta;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BaseDTO;
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
		List<OrContentDTO> drugList = new ArrayList<>();
		// 加顿，复制 以药品规格为判断条件，过滤掉用法费用拼接
		for (OrContentDTO orContentDTO : drugs) {
			if (StringUtils.isNotEmpty(orContentDTO.getSpec())) {
				drugList.add(orContentDTO);
			}
		}
		drugs = drugList;
		this.setSd_srvtp(sd_srvtp);
		this.setNote(note_or);
		String[] name_srvs = new String[drugs.size()];
		String[] id_mms = new String[drugs.size()];
		FDouble[] quan_meds = new FDouble[drugs.size()];
		String[] name_unit_meds = new String[drugs.size()];
		FDouble[] prices = new FDouble[drugs.size()];
		String[] specs = new String[drugs.size()];
		FDouble[] quan_curs =  new FDouble[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			OrContentDTO drug = drugs.get(i);
			name_srvs[i] = drug.getName_srv();
			id_mms[i] = drug.getId_mm();
			quan_meds[i] = drug.getQuan_med();
			name_unit_meds[i] = drug.getName_unit_med();
			prices[i] = drug.getPrice();
			specs[i] = drug.getSpec();
			quan_curs[i] = drug.getQuan_cur();
		}
		this.setName_srvs(name_srvs);
		this.setId_mms(id_mms);
		this.setQuan_meds(quan_meds);
		this.setName_unit_meds(name_unit_meds);
		this.setPrices(prices);
		this.setSpecs(specs);
		this.setQuan_curs(quan_curs);
	}
	/**
	 * 服务类型
	 * @return
	 */
	private String Sd_srvtp;
	/**
	 * 备注
	 * @return
	 */
	private String Note;
	/**
	 * 药品ID
	 */
	private String[] Id_mms;
	/**
	 * 服务名称
	 * @return
	 */
	private String[] Name_srvs;
	/**
	 * 剂量
	 * @return
	 */
	private FDouble[] Quan_meds;
	/**
	 * 总量
	 * @return
	 */
	private FDouble[] Quan_curs;
	/**
	 * 剂量单位
	 * @return
	 */
	private String[] Name_unit_meds;
	/**
	 * 使用天数
	 * @return
	 */
	private Integer Use_days;
	/**
	 * 规格
	 */
	private String[] Specs;

	/**
	 * 
	 */
	private FDouble[] Prices;
	
	public String[] getId_mms() {
		return Id_mms;
	}
	public void setId_mms(String[] id_mms) {
		Id_mms = id_mms;
	}
	public String getSd_srvtp() {
		return Sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		Sd_srvtp = sd_srvtp;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public String[] getName_srvs() {
		return Name_srvs;
	}
	public void setName_srvs(String[] name_srvs) {
		Name_srvs = name_srvs;
	}
	public FDouble[] getQuan_meds() {
		return Quan_meds;
	}
	public void setQuan_meds(FDouble[] quan_meds) {
		Quan_meds = quan_meds;
	}
	public String[] getName_unit_meds() {
		return Name_unit_meds;
	}
	public void setName_unit_meds(String[] name_unit_meds) {
		Name_unit_meds = name_unit_meds;
	}
	public Integer getUse_days() {
		return Use_days;
	}
	public void setUse_days(Integer use_days) {
		Use_days = use_days;
	}

	public FDouble[] getPrices() {
		return Prices;
	}
	public void setPrices(FDouble[] prices) {
		Prices = prices;
	}
	public String[] getSpecs() {
		return Specs;
	}
	public void setSpecs(String[] specs) {
		Specs = specs;
	}
	public FDouble[] getQuan_curs() {
		return Quan_curs;
	}
	public void setQuan_curs(FDouble[] quan_curs) {
		Quan_curs = quan_curs;
	}
	
}
