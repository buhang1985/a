package iih.en.que.s.bp.mt;

import java.util.ArrayList;
import java.util.List;

import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.EntQueStatus;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
/***
 * 指定站点分诊
 * @author fanlq
 * @date: 2020年3月20日 下午3:57:16
 */
public class TriageToSite4MtBP {

	/***
	 * @Description:指定站点分诊
	 * @param triageQueSiteDTO
	 * @param triageInfo
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] exec(TriageQueSiteDTO triageQueSiteDTO,TriageBenInfoDTO triageInfo) throws BizException{
		EnValidator.validateParam("TriageQueSiteDTO", triageQueSiteDTO);
		EnValidator.validateParam("TriageBenInfoDTO", triageInfo);
		GetTriageQueByBenBP bp = new GetTriageQueByBenBP();
		TriagePatInfoDTO[] triagePatInfoDTOs = bp.exec(triageInfo, triageInfo.getId_dayslot(),EntQueStatus.Arrived);
		if(EnValidator.isEmpty(triagePatInfoDTOs)){
			Logger.info("签到的就诊患者为空");
			return null;
		}
		//分诊到站点
		List<EnQueueDO> triagedQueList = new ArrayList<EnQueueDO>();
		for(TriagePatInfoDTO triagePatInfoDTO : triagePatInfoDTOs){
			MtTriageToSiteBP triageToSiteBP = new MtTriageToSiteBP();
			EnQueueDO enQueueDO = triageToSiteBP.exec(triageQueSiteDTO,triagePatInfoDTO.getId_ent_que());
			if(!EnValidator.isEmpty(enQueueDO)){
				triagedQueList.add(enQueueDO);
			}
		}
		return EnValidator.isEmpty(triagedQueList) ? null:triagedQueList.toArray(new EnQueueDO[]{});
	}
}
