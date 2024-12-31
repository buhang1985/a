package iih.ci.preop.imp.dto;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.tsip.d.CiTsOrDO;
import xap.mw.core.data.BaseDTO;

public class TsOrIpOrAggDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id_or;
	private String id_tsor;
	private CiTsOrDO tsOrDO;
	private CiOrderDO ciOrderDO;
	
	public CiOrderDO getCiOrderDO() {
		return ciOrderDO;
	}
	public void setCiOrderDO(CiOrderDO ciOrderDO) {
		this.ciOrderDO = ciOrderDO;
	}
	public CiTsOrDO getTsOrDO() {
		return tsOrDO;
	}
	public void setTsOrDO(CiTsOrDO tsOrDO) {
		this.tsOrDO = tsOrDO;
	}
	public String getId_or() {
		return id_or;
	}
	public void setId_or(String id_or) {
		this.id_or = id_or;
	}
	public String getId_tsor() {
		return id_tsor;
	}
	public void setId_tsor(String id_tsor) {
		this.id_tsor = id_tsor;
	}
	
}