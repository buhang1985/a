package iih.pe.pbd.i;

import iih.pe.pbd.qry.d.QryDO;
import iih.pe.pbd.qrycond.d.QrycondAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
public interface IPbdQueryService {
	
	/**
	 * 获取查询序号的最大值lh
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract QryDO[] getMaxCodeQryDO()throws BizException;
	
	/**
	 * 自定义查询QrycondAggDO的服务lh
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public abstract QrycondAggDO[] findQrycondAggDOByIdQry(String whereStr,String orderStr, FBoolean isLazy) throws BizException;
}
