package iih.en.pv.s.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.d.desc.EntStateDODesc;
import iih.en.pv.enclin.i.IEntstateCudService;
import iih.en.pv.enclin.i.IEntstateRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 重置新入院标志BP
 * @jizhenbo
 *
 */
public class ResetNewInHosFlagBP {
	/**
	 * 重置新入院标志BP
	 * @throws BizException
	 */
	public void exec() throws BizException{
		EntStateDO[] entStateDOs = this.getEntStatus(IBdFcDictCodeConst.SD_ENSTATE_ADMINSSIONTODAY);
		this.deleteEntStatus(entStateDOs);
	}
	
	/**
	 * 查找状态do
	 * @param entId
	 * @param sd_enstatetp
	 * @return
	 * @throws BizException
	 */
	private EntStateDO[] getEntStatus(String sd_enstatetp) throws BizException
	{
		IEntstateRService entStateRService = ServiceFinder.find(IEntstateRService.class);
		EntStateDO[] entStates = entStateRService.find(EntStateDODesc.TABLE_ALIAS_NAME+".sd_enstatetp = '"+sd_enstatetp +"' and dt_occ <= '"+EnAppUtils.getServerDateTime().subSeconds(86400)+"'", "", FBoolean.FALSE);		
		if(EnValidator.isEmpty(entStates)){
			return null;
		}	
		return entStates;
	}
	/**
	 * 删除过期标识
	 * @param entStateDOs
	 * @throws BizException
	 */
	private void deleteEntStatus(EntStateDO[] entStateDOs) throws BizException
	{
		if(EnValidator.isEmpty(entStateDOs))
			return;
		IEntstateCudService entStateCudService = ServiceFinder.find(IEntstateCudService.class);
		entStateCudService.delete(entStateDOs);
	}
	
}
