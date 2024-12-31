package iih.pe.pbd.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.qry.d.QryDO;
import iih.pe.pbd.qrycond.d.QrycondAggDO;

public interface IPbdMaintainService {

	
	/**
	 * 自助查询方案整体保存lh
	 * 
	 * @param qryDO
	 * @param qrycondAggDOs
	 * @return
	 * @throws BizException
	 */
	public abstract QryDO saveQryPlan(QryDO qryDO, QrycondAggDO[] qrycondAggDOs) throws BizException;
	
	/**
	 * 自助查询方案删除lh
	 * 
	 * @param id_qry
	 * @return
	 * @throws BizException
	 */
	public abstract void deleteQryPlan(String id_qry) throws BizException;
}
