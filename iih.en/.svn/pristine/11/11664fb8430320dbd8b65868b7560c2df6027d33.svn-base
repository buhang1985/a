package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.pub.listener.IEnOpQue4DisplayListener;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊退号集成平台监听器
 * （退号后更新列表）
 * 
 * @author liubin
 *
 */
public class EnCancOpReg4DisplayListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		Logger.info("接收事件: " + event.getEventType());
		//1、验证事件，是否匹配
		if(!this.validate(event))
			return;
		
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpReg4EsDTO opReg4Es = (OpReg4EsDTO)bizUserObj.getUserObj();
		
		EnQueueDO enQue = this.getEnQue(opReg4Es);
		//3.验证是否需要更新列表
		if(!checkIsNeedDisplay(enQue))
			return;
		
		this.sendDisPlay(enQue);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_REG.equalsIgnoreCase(event.getSourceID())
			|| !IEnEventConst.EVENT_EN_OP_CANC_REG.equals(event.getEventType())){
			//throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
			return false;
		}	
		return true;
	}
	/**
	 * 
	 * @param opReg4Es
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO getEnQue(OpReg4EsDTO opReg4Es) throws BizException{
		if(opReg4Es == null || 
				EnValidator.isEmpty(opReg4Es.getId_ent()))
			return null;
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] enQues = ep.getEnQueueByEntId(opReg4Es.getId_ent());
		if(!EnValidator.isEmpty(enQues))
			return enQues[0];
		return null;
	}
	/**
	 * 验证是否需要更新列表
	 * 
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private boolean checkIsNeedDisplay(EnQueueDO enQue) throws BizException{
		if(EnValidator.isEmpty(enQue))
			return false;
		IScDaysLotService daysLotServ = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO nowDaysLot = daysLotServ.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(nowDaysLot==null)
			return false;
		//判断退的号是不是今天的
		if(!(FDate.getDaysBetween(new FDate(nowDaysLot.getDef1()), enQue.getDt_regist()) == 0))
			return false;
		return nowDaysLot.getId_dayslot().equals(enQue.getId_dateslot());
	}
	/**
	 * 退号后更新列表
	 * 
	 * @param enQue
	 * @throws BizException 
	 */
	private void sendDisPlay(EnQueueDO enQue) throws BizException{
		IEnOpQue4DisplayListener serv = ServiceFinder.find(IEnOpQue4DisplayListener.class);
		OpQue4EsDTO esDTO = new OpQue4EsDTO();
		esDTO.setId_ent(enQue.getId_ent());
		esDTO.setId_que(enQue.getId_que());
		esDTO.setId_que_site(enQue.getId_que_site());
		esDTO.setCode_entp(enQue.getCode_entp());
		serv.sendWfInfo(esDTO, IEnEventConst.EVENT_EN_OP_CANC_REG);
	}
}
