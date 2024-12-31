package iih.en.que.s.bp.mt;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.s.bp.EnQueBP;
import xap.mw.core.data.BizException;

/**
 * 检查
 * @author Administrator
 *
 */
public class InspectBP {
	/**
	 * 检查
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	public void exec(MedTechAppDTO appDTO) throws BizException {
		if(appDTO==null){
			throw new BizException("参数appDTO为null!");
		}		
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(appDTO.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CHECKED);//检查
	}
}
