package iih.ci.ord.i.external.gvchina.meta;

/**
 * 查询患者在眼科本次就诊的有效检查医嘱
 * @author wangqingzhu
 *
 */
public class GvRisOrderRstInfo  extends BaseGvRstInfo{
	
	/**
	 * 申请时间
	 */
	private String appTime;
	
	/**
	 * 部位名称
	 */
	private String posName;
	
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
}
