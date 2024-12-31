package iih.pi.reg.s.bp;

import iih.pi.reg.dto.d.PiPatBasicInfoDTO;
import iih.pi.reg.s.bp.qry.FindPiPatBasicInfoByPatIdsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取患者基本信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPiPatBasicInfoByPatIdsBp {

	public PiPatBasicInfoDTO[] exec(String[] patIds) throws BizException {
		if (patIds == null || patIds.length <= 0) {
			return null;
		}

		PiPatBasicInfoDTO[] result = findPiPatBasicInfoByPatIds(patIds);
		return result;
	}

	/**
	 * 使用患者主键查询患者基本信息
	 * 
	 * @param patIds
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	private PiPatBasicInfoDTO[] findPiPatBasicInfoByPatIds(String[] patIds) throws BizException {
		FindPiPatBasicInfoByPatIdsQry qry = new FindPiPatBasicInfoByPatIdsQry(patIds);
		PiPatBasicInfoDTO[] result = (PiPatBasicInfoDTO[]) AppFwUtil.getDORstWithDao(qry, PiPatBasicInfoDTO.class);
		return result;
	}
}
