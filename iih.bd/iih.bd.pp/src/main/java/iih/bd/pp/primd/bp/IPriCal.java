package iih.bd.pp.primd.bp;

import xap.mw.coreitf.d.FDouble;

/**
 * 计算接口
 * @author yankan
 * @since 2015-08-04
 */
public interface IPriCal {
	/**
	 * 计算价格
	 * @param srvId 服务ID
	 * @return 服务价格
	 */
	FDouble Calculate(String srvId);

}
