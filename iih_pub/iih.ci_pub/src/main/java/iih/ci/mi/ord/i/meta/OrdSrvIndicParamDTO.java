package iih.ci.mi.ord.i.meta;

import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FBoolean;

public class OrdSrvIndicParamDTO extends OrdSrvMiBaseDTO{

	private static final long serialVersionUID = 1L;

	public String getKey(){
		
		return this.getId_srv() + StringUtils.trimToEmpty(this.getId_mm());
	}

	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 *医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	
	/**
	 * 医保目录ID
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录ID
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	
	/**
	 * 医保目录SD
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录SD
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	
	/**
	 * 医保目录名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保目录名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	
	/**
	 * 是否为费用项目
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 是否为费用项目
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	
	/**
	 * 是否自备药
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 是否自备药
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	
	/**
	 * 是否需要进行医保校验
	 * @return
	 */
	public FBoolean getFg_indicverify() {
		if(FBoolean.TRUE.equals(this.getFg_self()) || FBoolean.TRUE.equals(this.getFg_selfsrv()) ||!FBoolean.TRUE.equals(this.getFg_bl()) ){
			return FBoolean.FALSE;
		};
		return FBoolean.TRUE;
	} 
	
	
	
}
