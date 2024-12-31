package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.que.dto.d.MedTechAppDTO;
import xap.mw.core.data.BizException;

public class CallNumByQueSiteAndQueBP {
	
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	public void exec(String quesiteId,String id_que,String id_dayslot) throws BizException {
		MedTechAppBySiteAndQueBP mtTriageBP = new MedTechAppBySiteAndQueBP();
		MedTechAppDTO[] medTechappDTOArray = mtTriageBP.exec(quesiteId,
				new String[] { IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT },id_que,id_dayslot);
		if (medTechappDTOArray != null && medTechappDTOArray.length > 0) {
			MedTechAppDTO meddto = medTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALL);//叫号
		}	
	}

}
