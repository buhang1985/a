package iih.en.pv.s.task.bp;

import iih.en.comm.util.EnAppUtils;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpCudService;
import iih.en.pv.entagtp.i.IEntagtpRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 清除过期的授权标签
 * @author zhangpp
 *
 */
public class DelExpiredEnAuthBP {

	/**
	 * 执行
	 * @throws BizException
	 */
	public void exec() throws BizException{
		
		//查询过期的标签
		EnTagTpDO[] enTagTpDOs = this.qryEnAuth();
		//删除过期的标签
		this.delEnAuth(enTagTpDOs);
		
	}
	
	/**
	 * 查询
	 * @throws BizException
	 */
	private EnTagTpDO[] qryEnAuth() throws BizException{
		
		IEntagtpRService iCudService = ServiceFinder.find(IEntagtpRService.class);
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		String whereStr = "dt_end < '" + dateTime + "'";
		EnTagTpDO[] enTagTpDOs = iCudService.find(whereStr, null, FBoolean.FALSE);
		return enTagTpDOs;
	} 
	
	/**
	 * 删除
	 * @throws BizException
	 */
	private void delEnAuth(EnTagTpDO[] enTagTpDOs) throws BizException{
		
		if (enTagTpDOs == null) {
			return;
		}
		IEntagtpCudService iRService = ServiceFinder.find(IEntagtpCudService.class);
		iRService.delete(enTagTpDOs);	
	} 
}
