package iih.mi.bd.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.ReferralStatusBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindReferralStatussByHisIdsQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS转诊状态主键集合查询转诊状态基础信息字典业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindReferralStatusMapByHisIdsBp {

	public FMap2 exec(String hpId, String[] hisReferrStatusIds) throws BizException {

		ReferralStatusBaseInfoDTO[] refStatuss = findReferralStatussByHisIds(hpId, hisReferrStatusIds);
		FMap2 result = getMap(refStatuss);
		return result;
	}

	/**
	 * 获取字典
	 * 
	 * @param refStatuss
	 * @return
	 */
	private FMap2 getMap(ReferralStatusBaseInfoDTO[] refStatuss) {
		if (refStatuss == null) {
			return null;
		}

		FMap2 map = new FMap2();
		for (ReferralStatusBaseInfoDTO referralStatusBaseInfoDTO : refStatuss) {
			String referrId = referralStatusBaseInfoDTO.getId_referralstatus();
			if (!map.containsKey(referrId)) {
				map.put(referrId, referralStatusBaseInfoDTO);
			}
		}
		return map;
	}

	/**
	 * 根据HIS主键集合查询转诊状态列表
	 * 
	 * @param hpId
	 * @param hisReferrStatusIds
	 * @return
	 * @throws BizException
	 */
	private ReferralStatusBaseInfoDTO[] findReferralStatussByHisIds(String hpId, String[] hisReferrStatusIds)
			throws BizException {
		String wherePart = getWherePart(hpId, hisReferrStatusIds);

		FindReferralStatussByHisIdsQry qry = new FindReferralStatussByHisIdsQry(wherePart);
		ReferralStatusBaseInfoDTO[] result = (ReferralStatusBaseInfoDTO[]) AppFwUtil.getDORstWithDao(qry,
				ReferralStatusBaseInfoDTO.class);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param hpId
	 * @param hisReferrStatusIds
	 * @return
	 */
	private String getWherePart(String hpId, String[] hisReferrStatusIds) {
		StringBuilder wherePartBuilder = new StringBuilder();

		if (StringUtils.isNotEmpty(hpId)) {

		}

		if (hisReferrStatusIds != null && hisReferrStatusIds.length > 0) {

		}
		return wherePartBuilder.toString();
	}

}
