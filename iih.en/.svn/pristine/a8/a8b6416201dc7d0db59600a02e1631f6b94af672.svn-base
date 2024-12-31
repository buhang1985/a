package iih.en.que.s.bp.mt;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.s.bp.EnQueBP;
import xap.mw.core.data.BizException;

/**
 * 取消检查
 * @author Administrator
 *
 */
public class CancelInspectBP {
	/**
	 * 取消检查 
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	public void exec(MedTechAppDTO appDTO) throws BizException {
		if(appDTO==null){
			throw new BizException("参数appDTO为null!");
		}		
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(appDTO.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);//到诊
	}
}
