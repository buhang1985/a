package iih.bl.hp.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取医保单方限制集合
 * @author yankan
 * @since 2017-09-04
 *
 */
public class GetHpLimitPsdListBP {
	/**
	 * 获取医保单方限制集合
	 * 
	 * @param hpIds 医保ID集合
	 * @param srvIds 服务ID集合
	 * @return 医保单方限制集合
	 */
	public List<BdHpLimitPsdDO> exec(String[] hpIds, String[] srvIds) throws BizException {
		// 拼写查询条件
		StringBuilder whereBuilder = new StringBuilder("1=1");
		String hpIdwherePart = SqlUtils.getInSqlByIds(BdHpLimitPsdDO.ID_HP, hpIds);
		if (StringUtil.isEmpty(hpIdwherePart)) {
			whereBuilder.append(" AND ").append(hpIdwherePart);
		}
		String srvIdwherePart = SqlUtils.getInSqlByIds(BdHpLimitPsdDO.ID_SRV, srvIds);
		if (StringUtil.isEmpty(srvIdwherePart)) {
			whereBuilder.append(" AND ").append(srvIdwherePart);
		}
		// 查询字段
		String[] fields = new String[] { BdHpLimitPsdDO.ID_HP, BdHpLimitPsdDO.ID_SRV };
		List<BdHpLimitPsdDO> hpLimitPsdList = (List<BdHpLimitPsdDO>) new DAFacade().findByCond(BdHpLimitPsdDO.class,
				whereBuilder.toString(), fields);
		if (ListUtil.isEmpty(hpLimitPsdList)) {
			return null;
		}
		return hpLimitPsdList;
	}
}
