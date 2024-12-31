package iih.bl.cg.bp.ip;

import iih.bl.cg.bp.ip.qry.GetIpStListQry;
import iih.bl.cg.dto.d.BlIpStDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取住院结算信息
 * 
 * @author
 *
 */
public class GetIpStListBP {
	/**
	 * 获取住院结算信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return 住院结算信息集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlIpStDTO[] exec(String entId) throws BizException {
		// 校验医嘱Id
		if (StringUtil.isEmpty(entId)) {
			return null;
		}

		BlIpStDTO[] BlIpStDTOs = (BlIpStDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpStListQry(entId), BlIpStDTO.class);

		return BlIpStDTOs;
	}
}
