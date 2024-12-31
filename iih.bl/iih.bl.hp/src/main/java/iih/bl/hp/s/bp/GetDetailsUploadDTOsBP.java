package iih.bl.hp.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bl.hp.dto.d.PresDetailsUploadDTO;
import iih.bl.hp.s.bp.qry.GetDetailsUploadDTOsToIpQry;
import iih.bl.hp.s.bp.qry.GetDetailsUploadDTOsToOepQry;

/**
 * 获取门诊/住院 处方明细
 * 
 * @author yang.lu
 * @since 2017-7-21
 *
 */
public class GetDetailsUploadDTOsBP {
	
	public PresDetailsUploadDTO[] exec(String patid, String entid, boolean isIp) throws BizException {
		
		PresDetailsUploadDTO[] retVal = null;
		// 1.任意条件不为空时进行查询
		if (!StringUtil.isEmpty(patid) || !StringUtil.isEmpty(entid)) {
			if (!isIp) {
				// 获取门诊处方明细
				retVal = (PresDetailsUploadDTO[]) AppFwUtil.getDORstWithDao(new GetDetailsUploadDTOsToOepQry(patid, entid), PresDetailsUploadDTO.class);
			} else {
				// 获取住院处方明细
				retVal = (PresDetailsUploadDTO[]) AppFwUtil.getDORstWithDao(new GetDetailsUploadDTOsToIpQry(patid, entid), PresDetailsUploadDTO.class);
			}
		}
		return retVal;
	}
}
