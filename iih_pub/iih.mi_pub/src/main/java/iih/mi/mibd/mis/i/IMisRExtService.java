package iih.mi.mibd.mis.i;

import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;

/**
* 医保平台_医保系统数据查询服务
*/
public interface IMisRExtService {
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract MisDO[] findAllMisDOsWithFactoryInst() throws BizException;
	
}