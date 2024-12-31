package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class SelEntToCallNumBP {
	/**
	 * 选中患者叫号
	 * 
	 * @param rect
	 * @param queSite
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO exec(ReceptionQueDTO rect, QueDO que, QueSiteDO site, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(rect == null || site == null)
			return null;
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(site.getId_quesite());
		OpCallingNumBP callingNumBP = new OpCallingNumBP();
		if(!IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(rect.getSd_status_acpt())){
		//把正在叫号的患者置为未叫号
			EnQueueDO[] calls = callingNumBP.getCallEnt(que, site, siteInfo);
			if(!EnValidator.isEmpty(calls)){
				CancelCallNumBP bp = new CancelCallNumBP();
				for(EnQueueDO  call : calls)
					bp.exec(call.getId_ent_que());
			}
		}
		EnQueEP eqBp = new EnQueEP();
		EnQueueDO enque = eqBp.getEnQueueById(rect.getId_ent_que());
		if(enque != null){
			if(!enque.getSd_status_acpt().equals(rect.getSd_status_acpt()))
				throw new BizException("叫号失败，该患者就诊状态已经改变，请刷新界面后重试！");
			enque.setStatus(DOStatus.UPDATED);
			enque.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			enque.setId_que_site(site.getId_quesite());
			enque.setId_emp_acpt(site.getId_emp());
			enque.setName_emp_acpt(site.getEmp_name());
			if(enque.getSortno_called() == null || enque.getSortno_called() <= 0){
				int sortnoCalled = callingNumBP.getMaxSortnoCalled(que.getId_que(), site.getId_quesite(), siteInfo);
				enque.setSortno_called(sortnoCalled);
			}
			if(EnParamUtils.isTriageToEmp())
				enque.setId_emp_opreg(site.getId_emp());
			else
				enque.setId_emp_opreg(null);
			EnQueueDO[] enques = eqBp.save(new EnQueueDO[]{ enque });
			//触发叫号事件
			callingNumBP.invoke(que.getId_que(), site.getId_quesite(), enques[0].getCode_entp(), enques[0].getId_ent());
			return enques[0];
		}else
			throw new BizException(IEnMsgConst.ERROR_CALL_WRONG);
	}
}
