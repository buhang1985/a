package iih.en.que.s.event.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class TriageFinishCheckedBP {

	public void exec(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		if(!IEnEventConst.EVENT_EN_ALL_DIAGEND.equals(eventType)){
			return;
		}
		if(allQue4EsDTO != null && !EnValidator.isEmpty(allQue4EsDTO.getId_que())){
			IQueRService rService = ServiceFinder.find(IQueRService.class);
			QueDO queDO = rService.findById(allQue4EsDTO.getId_que());
			if(queDO != null && IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(queDO.getSd_mode())){
				
			}
		}
	}
}
