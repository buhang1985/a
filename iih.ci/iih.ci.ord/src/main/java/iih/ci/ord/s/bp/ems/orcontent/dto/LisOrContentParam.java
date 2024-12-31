package iih.ci.ord.s.bp.ems.orcontent.dto;

import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检验医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class LisOrContentParam extends BaseOrContentParam{

	private static final long serialVersionUID = 1L;
	public LisOrContentParam(String sd_srvtp,FBoolean fg_urgent,String name_samptp,String note,FArrayList list){
		this.setSd_srvtp(sd_srvtp);
		this.setFg_urgent(fg_urgent);
		this.setName_samptp(name_samptp);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for(int i=0;i<list.size();i++){
			EmsObsLap obslap = (EmsObsLap)list.get(i);
			name_srvs[i] = obslap.getName_srv();
		}
		this.setName_srvs(name_srvs);
	}
	/**
	 * 加急标识
	 * @return
	 */
	public FBoolean getFg_urgent(){
		return ((FBoolean)getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 标本sd
	 * @return
	 */
	public String getSd_samptp(){
		return ((String)getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本sd
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本名称
	 * @return
	 */
	public String getName_samptp(){
		return ((String)getAttrVal("Name_samptp"));
	}
	/**
	 * 标本名称
	 * @param Sd_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
}
