package iih.mp.nr.splitplan.splitresponse.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱服务执行点写入 DTO数据 
 * 
 */
public class MporSrvParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_srv_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_srv_mp_plan"));
	}
	/**
	 * 服务执行时间
	 * @param Dt_srv_mp_plan
	 */
	public void setDt_srv_mp_plan(FDateTime Dt_srv_mp_plan) {
		setAttrVal("Dt_srv_mp_plan", Dt_srv_mp_plan);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}