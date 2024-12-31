package iih.en.que.s;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.s.bp.EnQueBP;
import iih.en.que.s.bp.MedTechAppBySiteAndQueBP;
import xap.mw.core.data.BizException;

/**
 * 叫号,叫下一个
 * @author Administrator
 *
 */
public class CallNumNextBP {
	
	/**
	 * 叫号,叫下一个
	 * @param quesiteId
	 * @param id_que
	 * @param id_dayslot
	 * @throws BizException
	 */
	public void exec(String quesiteId, String id_que, String id_dayslot) throws BizException
	{
		MedTechAppBySiteAndQueBP mtTriageBP = new MedTechAppBySiteAndQueBP();
		MedTechAppDTO[] medTechappDTOArray = mtTriageBP.exec(quesiteId,
				new String[] { IEnDictCodeConst.SD_STATUS_ACPT_CALL },id_que,id_dayslot);
		if (medTechappDTOArray != null && medTechappDTOArray.length > 0) {
			MedTechAppDTO meddto = medTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);//过号
		}
		
		MedTechAppDTO[] newMedTechappDTOArray = mtTriageBP.exec(quesiteId,
				new String[] { IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT },id_que,id_dayslot);
		if (newMedTechappDTOArray != null && newMedTechappDTOArray.length > 0) {
			MedTechAppDTO meddto = newMedTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);//叫号
		}
		else
		{
			throw new BizException("站点没有可叫号患者");
		}
	}
}
