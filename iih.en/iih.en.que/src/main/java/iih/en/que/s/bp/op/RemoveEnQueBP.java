package iih.en.que.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnSqlUtils;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;

public class RemoveEnQueBP {
	/***
	 * 移除药房队列
	 * @param id_pres
	 * @throws BizException
	 */
	public void exec(String[] presIds) throws BizException{
		EnQueEP ep = new EnQueEP();
		String whereSql = EnSqlUtils.getInSqlByIds("id_pres",presIds);
		EnQueueDO[] enQueueDOs = ep.getEnQueueByWhereStr(whereSql+" and sd_entque_tp = '"+IBdFcDictCodeConst.SD_QUETP_PHARMACY+"'",null);
	    if(enQueueDOs != null && enQueueDOs.length > 0){
	    	ep.delete(enQueueDOs);
	    }
	}
}
