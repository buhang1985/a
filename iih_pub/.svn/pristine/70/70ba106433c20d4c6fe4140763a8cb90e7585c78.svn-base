package iih.ci.ord.i.external.obtain;

import iih.bd.srv.freqdef.d.FreqDefDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 调用基础数据相关接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdBdRService {

	/**
	 * 根据服务类型、剂型关联用法
	 * @param sd_srvtp
	 * @param id_srvs
	 * @param isControl
	 * @return
	 * @throws BizException
	 */
	public abstract String getIdroutes8Dosage(String sd_srvtp, String[] id_srvs, FBoolean isControl) 
			throws BizException;
	/**
	 * 根据用法关联剂型判断服务是否可成组
	 * @param id_srv
	 * @param id_route
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean checkSrvEnable8Dosage(String id_srv, String id_route) throws BizException;
	/**
	 * 获取频次信息
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public FreqDefDO getFreqDefDO(String id_freq) throws BizException;
}
