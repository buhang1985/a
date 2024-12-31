package iih.mi.bd.s.bp;

import iih.mi.bd.d.EnTpBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindEnTpBaseInfoByHisEnTpIdsQry;
import iih.bd.base.utils.FMapUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS就诊类型主键集合查询医保就诊类型字典业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindEnTpMapByHisIdsBp {

	public FMap2 exec(String hpId, String[] hisEnTpIds) throws BizException {
		EnTpBaseInfoDTO[] enTpBaseInfoDTOs = findHpEnTpBaseInfosByHisIds(hpId, hisEnTpIds);
		FMap2 result = FMapUtils.getFMap2("Id_entp", enTpBaseInfoDTOs);
		return result;
	}

	/**
	 * 根据HIS就诊类型主键集合查询医保就诊类型基础信息列表
	 * 
	 * @param hpId
	 * 
	 * @param hisEnTpIds
	 * @return
	 * @throws BizException
	 */
	private EnTpBaseInfoDTO[] findHpEnTpBaseInfosByHisIds(String hpId, String[] hisEnTpIds) throws BizException {
		FindEnTpBaseInfoByHisEnTpIdsQry qry = new FindEnTpBaseInfoByHisEnTpIdsQry(hpId, hisEnTpIds);
		EnTpBaseInfoDTO[] result = (EnTpBaseInfoDTO[]) AppFwUtil.getDORstWithDao(qry, EnTpBaseInfoDTO.class);
		return result;
	}
}
