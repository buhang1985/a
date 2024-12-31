package iih.ci.sdk.orctt.meta;

public class OutHospOrContentParam extends BaseOrContentParam {

	/**
	 * 死亡时间
	 * @return String
	 */
	public String getDt_timeout() {
		return ((String) getAttrVal("Dt_timeout"));
	}
	/**
	 * 死亡时间
	 * @param Dt_timeout
	 */
	public void setDt_timeout(String Dt_timeout) {
		setAttrVal("Dt_timeout", Dt_timeout);
	}
}
