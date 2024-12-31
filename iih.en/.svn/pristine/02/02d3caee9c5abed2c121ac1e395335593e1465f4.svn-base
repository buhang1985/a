package iih.en.pv.s.bp.ip;

import iih.nm.nom.nomwkitm.i.INomwkitmDischargeRecallService;
import iih.nm.nom.nomwkitmcollectdto.d.DischargeRecallParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 出院人数统计接口
 * 
 * @author liubin
 *
 */
public class CallBackLvNum4NmBP {
	/**
	 * 出院人数统计接口
	 * 
	 * @param nurId
	 * @param dateTime
	 * @throws BizException
	 */
	public void exec(String nurId, FDateTime dateTime)
			throws BizException {
		DischargeRecallParamDTO recallParamDTO = new DischargeRecallParamDTO();
		recallParamDTO.setId_dep_nur(nurId);
		recallParamDTO.setDt_discharge(dateTime.getBeginDate());
		INomwkitmDischargeRecallService serv = ServiceFinder.find(INomwkitmDischargeRecallService.class);
		serv.callBackProjectFill(recallParamDTO);
	}
}
