package iih.en.pv.s.bp.op;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消就诊BP
 * 
 * @author yank
 */
public class CancEntBP {
	/**
	 * 取消就诊 
	 * 1、就诊信息取消 
	 * 2、就诊队列取消
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void cancEnt(String entId) throws BizException {
		EnValidator.validateParam("entId", entId);

		// 1、就诊信息取消
		this.updatePV(entId);
		// 2、就诊队列取消
		this.updateEntQue(entId);
	}

	/**
	 * 更新PV信息
	 * 
	 * @param pvDO 就诊DO
	 * @param cancEmpId 取消业务员id
	 * @throws BizException
	 */
	private void updatePV(String entId) throws BizException {
		//1、获取就诊信息
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		}
		// 2、更新就诊为退诊
		pvDO.setStatus(DOStatus.UPDATED);
		pvDO.setFg_canc(FBoolean.TRUE); // 退诊标志
		pvDO.setId_emp_canc(EnContextUtils.getPsnId()); // 退诊人员
		pvDO.setDt_canc(EnAppUtils.getServerDateTime()); // 退诊时间
		pvEP.savePv(pvDO);
	}

	/**
	 * 更新就诊队列
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	private void updateEntQue(String entId) throws BizException {
		IEnqueueRService enqueueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO[] enQueueDOs = enqueueRService.find("id_ent = '" + entId + "' and fg_active = 'Y'", null,
				FBoolean.FALSE);
		// 更新队列数据
		if (!EnValidator.isEmpty(enQueueDOs)) {
			EnQueueDO enQueueDO = enQueueDOs[0];			
			enQueueDO.setStatus(DOStatus.UPDATED);
//			enQueueDO.setId_que(null);// 队列id置空
			enQueueDO.setFg_active(FBoolean.FALSE); // 有效标志
			IEnqueueCudService enqueueCudService = ServiceFinder.find(IEnqueueCudService.class);
			enqueueCudService.save(new EnQueueDO[] { enQueueDO });
		}
	}
}
