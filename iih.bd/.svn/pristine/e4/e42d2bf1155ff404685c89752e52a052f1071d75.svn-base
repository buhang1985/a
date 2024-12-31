package iih.bd.srv.emrtpl.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;

/**
 * 停用医疗记录模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DisableEmrTplBp {

	public EmrTplDO[] exec(EmrTplDO[] emrTplDOs) throws BizException {
		if (emrTplDOs == null || emrTplDOs.length <= 0) {
			return null;
		}
		EmrTplDO[] result = DisableEmrTpl(emrTplDOs);
		return result;
	}

	/**
	 * 停用医疗记录模板
	 * 
	 * @param emrTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] DisableEmrTpl(EmrTplDO[] emrTplDOs) throws BizException {
		for (EmrTplDO emrTplDO : emrTplDOs) {
			DisableEmrTpl(emrTplDO);
		}
		EmrTplDO[] result = SaveEmrTpl(emrTplDOs);
		return result;
	}

	/**
	 * 保存医疗记录模板
	 * 
	 * @param emrTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] SaveEmrTpl(EmrTplDO[] emrTplDOs) throws BizException {
		IEmrtplMDOCudService emrtplMDOCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMDOCudService.save(emrTplDOs);
		return result;
	}

	/**
	 * 停用医疗记录模板
	 * 
	 * @param emrTplDO
	 */
	private void DisableEmrTpl(EmrTplDO emrTplDO) {
		emrTplDO.setActivestate(ActiveStateEnum.STOP);
		emrTplDO.setDt_active(null);
		emrTplDO.setId_emp_active(null);
		emrTplDO.setDt_stop(AppUtils.getServerDateTime());
		emrTplDO.setId_emp_stop(Context.get().getUserId());
		emrTplDO.setStatus(DOStatus.UPDATED);
	}
}
