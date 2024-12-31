package iih.ci.sdk.ems.meta;

/**
 * 医疗单保存执行器结果类
 * @author wangqingzhu
 *
 */
public class EmsSaveExecutorRstInfo {
	private boolean success;
	private EmsRstInfoList rstInfoList;
	private OrderPackageInfoList opiList;
	
	public EmsSaveExecutorRstInfo(boolean isSuccess, EmsRstInfoList rstInfoList, OrderPackageInfoList opiList){
		this.success = isSuccess;
		this.rstInfoList = rstInfoList;
		this.opiList = opiList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean isSuccess) {
		this.success = isSuccess;
	}

	public EmsRstInfoList getRstInfoList() {
		return rstInfoList;
	}

	public void setRstInfoList(EmsRstInfoList rstInfoList) {
		this.rstInfoList = rstInfoList;
	}

	public OrderPackageInfoList getOpiList() {
		return opiList;
	}

	public void setOpiList(OrderPackageInfoList opiList) {
		this.opiList = opiList;
	}
}
