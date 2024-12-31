package iih.en.que.s.bp.mt;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.s.bp.EnQueBP;
import iih.en.que.s.bp.MedTechTriageBP;
import xap.mw.core.data.BizException;

/**
 * 站点叫号
 * @author Administrator
 *
 */
public class CallNumByQueSiteBP {
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	public void exec(String quesiteId) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		MedTechAppDTO[] medTechappDTOArray = mtTriageBP.getMedTechAppBySite(quesiteId,
				new String[] { IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT });
		if (medTechappDTOArray != null && medTechappDTOArray.length > 0) {
			MedTechAppDTO meddto = medTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALL);//叫号
		}	
	}
}
