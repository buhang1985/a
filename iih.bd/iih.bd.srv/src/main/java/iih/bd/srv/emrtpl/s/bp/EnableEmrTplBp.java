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
 * 启用医疗记录模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EnableEmrTplBp {

	public EmrTplDO[] exec(EmrTplDO[] emrTplDOs) throws BizException {
		if (emrTplDOs == null || emrTplDOs.length <= 0) {
			return null;
		}
		EmrTplDO[] result = EnableEmrTpl(emrTplDOs);
		return result;
	}

	/**
	 * 启用医疗记录模板
	 * 
	 * @param emrTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] EnableEmrTpl(EmrTplDO[] emrTplDOs) throws BizException {
		CheckContent(emrTplDOs);
		for (EmrTplDO emrTplDO : emrTplDOs) {
			EnableEmrTpl(emrTplDO);
		}
		EmrTplDO[] result = SaveEmrTpl(emrTplDOs);
		return result;
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrTplDOs
	 * @throws BizException
	 */
	private void CheckContent(EmrTplDO[] emrTplDOs) throws BizException {
		CheckContentBeforeEnabelBp bp = new CheckContentBeforeEnabelBp();
		bp.exec(emrTplDOs);
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
	 * 启用医疗记录模板
	 * 
	 * @param emrTplDO
	 */
	private void EnableEmrTpl(EmrTplDO emrTplDO) {
		emrTplDO.setActivestate(ActiveStateEnum.ACTIVE);
		emrTplDO.setDt_active(AppUtils.getServerDateTime());
		emrTplDO.setId_emp_active(Context.get().getUserId());
		emrTplDO.setDt_stop(null);
		emrTplDO.setId_emp_stop(null);
		emrTplDO.setStatus(DOStatus.UPDATED);
	}
}
