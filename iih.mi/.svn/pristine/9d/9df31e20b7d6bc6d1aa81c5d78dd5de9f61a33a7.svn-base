package iih.mi.bd.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.mi.bd.d.RegionBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindRegionsByCodesSql;

/**
 * @author dj.zhang
 *
 */
public class FindRegionsByCodesBp {
	/**
	 * 执行查询逻辑
	 * @param hpId
	 * @param regionCodes
	 * @return RegionBaseInfoDTO[]
	 * @throws BizException 
	 */
	public RegionBaseInfoDTO[] exec(String hpId, String[] regionCodes) throws BizException {

		//参数检验
		if(StringUtil.isEmptyWithTrim(hpId) || ArrayUtil.isEmpty(regionCodes))
			return null;
		
		FindRegionsByCodesSql qry = new FindRegionsByCodesSql(hpId,regionCodes);
		RegionBaseInfoDTO[] result = (RegionBaseInfoDTO[]) AppFwUtil.getDORstWithDao(qry,
				RegionBaseInfoDTO.class);
		if(ArrayUtil.isEmpty(result))
			return null;
		
		return result;
	}

}
