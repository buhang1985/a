package iih.bl.cg.s.bp.ip;

import iih.bl.cg.dto.ipcg4en.d.BlCgIp4EnDTO;
import iih.bl.cg.s.bp.ip.qry.GetIpCgDataByEntIdQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
 * 根据就诊主键查询住院记账数据
 * @author ly 2019/01/15
 *
 */
public class GetIpCgDataByEntIdBP {
	
	/**
	 * 根据就诊主键查询住院记账数据
	 * @param entId 就诊id
	 * @return 记账数据
	 * @throws BizException
	 */
	public BlCgIp4EnDTO[] exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId))
			return null;
		
		GetIpCgDataByEntIdQry qry = new GetIpCgDataByEntIdQry(entId);
		BlCgIp4EnDTO[] rlt = (BlCgIp4EnDTO[])AppFwUtil.getDORstWithDao(qry, BlCgIp4EnDTO.class);
		
		return rlt;
		
	}
}
