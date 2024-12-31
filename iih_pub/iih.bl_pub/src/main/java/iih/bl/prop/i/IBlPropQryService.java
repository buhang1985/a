package iih.bl.prop.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

/**
 * 分摊查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlPropQryService {

	/**
	 * 根据门诊结算id获取医保结算分摊数据
	 * 
	 * @author liwq
	 *
	 */
	public FMap2 getOepHpPropAggDo(String id_stoep) throws BizException;
	
	
	public String getOepHpPropArIdHp(String id_stoep) throws BizException;
	
	/** 通过结算主键查询医保分摊服务
	 * @param strIdStIp 结算主键
	 * @return
	 * @throws BizException
	 */
	public FMap2 getIpHpPropAggDo(String strIdStIp) throws BizException;
}
