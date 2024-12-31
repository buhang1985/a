package iih.ci.ord.s.bp.ems.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.s.ems.orcontent.meta.OrContentDTO;
import xap.mw.core.data.FArrayList;

/**
 * 用于西成药医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class DrugOrContentParam extends BaseOrContentParam{

	private static final long serialVersionUID = 1L;
	
	public DrugOrContentParam(String sd_srvtp,String name_freq,Integer use_days,String name_route,String note_or,List<OrContentDTO> drugs){
		super( sd_srvtp, note_or, drugs);
		boolean[] fg_selfs = new boolean[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			OrContentDTO drug = drugs.get(i);
			fg_selfs[i] = drug.isFg_self();
		}
		this.setName_freq(name_freq);
		this.setName_route(name_route);
		this.setFg_selfs(fg_selfs);
		this.setUse_days(use_days);
	}
	
	public DrugOrContentParam(String sd_srvtp,String name_freq,String name_route,String note_or,FArrayList drugs){
		super( sd_srvtp, note_or, drugs);
		boolean[] fg_selfs = new boolean[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			EmsOrDrug drug = (EmsOrDrug)drugs.get(i);
			fg_selfs[i] = drug.getFg_self()==null?false:drug.getFg_self().booleanValue();
		}
		this.setName_freq(name_freq);
		this.setName_route(name_route);
		this.setFg_selfs(fg_selfs);
	}
	/**
	 * 用法
	 * @return
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 频次
	 * @return
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 自备药标识
	 * @return
	 */
	public boolean[] getFg_selfs(){
		return ((boolean[])getAttrVal("Fg_selfs"));
	}
	/**
	 * 自备药标识
	 * @param Fg_selfs
	 */
	public void setFg_selfs(boolean[] Fg_selfs) {
		setAttrVal("Fg_selfs", Fg_selfs);
	}
}
