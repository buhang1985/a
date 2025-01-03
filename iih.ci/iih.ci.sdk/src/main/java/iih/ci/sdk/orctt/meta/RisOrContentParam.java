package iih.ci.sdk.orctt.meta;

import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.coreitf.d.FBoolean;

public class RisOrContentParam extends BaseOrContentParam {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RisOrContentParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RisOrContentParam(CiOrderDO ciOrderDO,OrdApObsDO ordApObsDO) {
		this.ciOrderDO = ciOrderDO;
		this.ordApObsDO = ordApObsDO;
	}
	public RisOrContentParam(String name_or,String sd_srvtp,String id_or_old,String id_body,FBoolean fg_urgent,FBoolean fg_set) {
		this.setId_or_old(id_or_old);
		this.setName_or(name_or);
		this.setSd_srvtp(sd_srvtp);
		this.setId_body(id_body);
		this.setFg_urgent(fg_urgent);
		this.setFg_set(fg_set);
	}
	private CiOrderDO ciOrderDO;
	private OrdApObsDO ordApObsDO;
	private String name_or;
	
	public String getName_or() {
		return name_or;
	}
	public void setName_or(String name_or) {
		this.name_or = name_or;
	}
	private String Id_body;
	
	public String getId_body() {
		return Id_body;
	}
	public void setId_body(String id_body) {
		Id_body = id_body;
	}
	/**
	 * 复制的id_or
	 */
	private String Id_or_old;
	
	public String getId_or_old() {
		return Id_or_old;
	}
	public void setId_or_old(String id_or_old) {
		Id_or_old = id_or_old;
	}
	/**
	 * 套标志
	 */
	private FBoolean Fg_set;
	
	public FBoolean getFg_set() {
		return Fg_set;
	}
	public void setFg_set(FBoolean fg_set2) {
		Fg_set = fg_set2;
	}
	/**
	 * 部位
	 * @return String
	 */
	public String getStr_body() {
		return ((String) getAttrVal("Str_body"));
	}
	/**
	 * 部位
	 * @param Str_body
	 */
	public void setStr_body(String Str_body) {
		setAttrVal("Str_body", Str_body);
	}
	
	/**
	 * 备注
	 * @return String
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
	public CiOrderDO getCiOrderDO() {
		return ciOrderDO;
	}
	public void setCiOrderDO(CiOrderDO ciOrderDO) {
		this.ciOrderDO = ciOrderDO;
	}
	public OrdApObsDO getOrdApObsDO() {
		return ordApObsDO;
	}
	public void setOrdApObsDO(OrdApObsDO ordApObsDO) {
		this.ordApObsDO = ordApObsDO;
	}
	
}
