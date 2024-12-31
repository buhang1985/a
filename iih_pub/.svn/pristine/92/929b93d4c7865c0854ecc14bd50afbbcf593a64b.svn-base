package iih.ci.ord.i.base;

/**
 * 医嘱医疗单服务参数基类
 * @author wangqingzhu
 *
 */
public class BaseEmsDTO extends BaseCiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseEmsDTO(){
		setDriverInfo(new EmsDriverInfo());
	}
	
	/**
	 * 医疗单驱动信息对象
	 * 
	 * @return EmsDriverInfo
	 */
	public EmsDriverInfo getDriverInfo() {
		return ((EmsDriverInfo) getAttrVal("DriverInfo"));
	}

	/**
	 * 医疗单驱动信息对象
	 * 
	 * @param DriverInfo
	 */
	public void setDriverInfo(EmsDriverInfo DriverInfo) {
		setAttrVal("DriverInfo", DriverInfo);
	}
}
