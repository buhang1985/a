package iih.ci.mrm.s.mrmmail.audlogic;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrm.cimrmsp.d.CiMrmMailDO;
import iih.ci.mrm.cimrmsp.i.ICimrmspCudService;
import iih.ci.mrm.cimrmsp.i.ICimrmspRService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmmail.audlogic.IMrmMailAudLogicService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={IMrmMailAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmMailAudLogicServiceImpl implements IMrmMailAudLogicService {

	public int updateCiMrmMailDO(CiMrmQryListDTO[] ciMrmQryListDtos, String confirmId) throws BizException {
		
		ICimrmspRService rService = ServiceFinder.find(ICimrmspRService.class);
		ICimrmspCudService cudService = ServiceFinder.find(ICimrmspCudService.class);
		
		int bool = 0;// true
		
		for (CiMrmQryListDTO ciMrmQryListDTO : ciMrmQryListDtos) {
			
			// 确认时判断当前数据是否是已邮寄状态，返回结果由前端判断
			String mailState = ciMrmQryListDTO.getId_mrm_mail_sta();
			String afterMailId = ICiMrDictCodeConst.ID_MRM_MA_STATE_EXECUTED;
			
			if(mailState.equals(afterMailId)) {
				return 2;
			}
						
			// 根据当前的病案id查询病案邮寄表
			String id_amr = ciMrmQryListDTO.getId_amr();
			CiMrmMailDO[] ciMrmMailDOs = rService.find(" id_ci_amr = '"+id_amr+"'", "", FBoolean.FALSE);
			
			List<CiMrmMailDO> mailArr = new ArrayList<CiMrmMailDO>();
			
			// 将病案邮寄数据的邮寄状态改为'已邮寄'
			for (CiMrmMailDO ciMrmMailDO : ciMrmMailDOs) {
				ciMrmMailDO.setId_mail_state(ICiMrDictCodeConst.ID_MRM_MA_STATE_EXECUTED);
				ciMrmMailDO.setSd_mail_state(ICiMrDictCodeConst.SD_MRM_MA_STATE_EXECUTED);
				ciMrmMailDO.setDt_confirm(new FDateTime());
				ciMrmMailDO.setId_psn_confirm(confirmId);
				
				mailArr.add(ciMrmMailDO);
			}
			
			CiMrmMailDO[] results = cudService.update(mailArr.toArray(new CiMrmMailDO[0]));
			
			if(results.length <= 0) {
				bool = 1;// false
			}
			
		}
		
		return bool;
		
	}
	
}
