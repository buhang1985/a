package iih.bl.cg.bp.ip;

import iih.bl.cg.bp.ip.qry.GetIpInccaItmListQry;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取住院账单项集合
 * @author 
 *
 */
public class GetIpInccaItmListBP {
	/**
	 * 获取住院账单项集合
	 * @param entId 就诊id
	 * @param inccaItmCode 账单项编码
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlInccaItmDTO[] exec(String entId,String inccaItmCode) throws BizException{
		
		BlInccaItmDTO[] BlInccaItmDTOs = (BlInccaItmDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpInccaItmListQry(entId,inccaItmCode), BlInccaItmDTO.class);
		return BlInccaItmDTOs;
	}
}
