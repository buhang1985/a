package iih.bl.st.s.bp;

import iih.bl.cg.d.BlcgipRelief;
import iih.bl.st.s.bp.ip.qry.GetCgIpReliefInfoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询患者记账未结算数据
 * Title: GetCgIpReliefInfoBP.java
 * @author zhang.hw
 * @date 2019年5月14日  
 * @version 1.0
 */
public class GetCgIpReliefInfoBP {
	public BlcgipRelief[] exec(String stId) throws BizException {

		BlcgipRelief[] cgipReliefArr = (BlcgipRelief[]) AppFwUtil.getDORstWithDao(new GetCgIpReliefInfoQry(stId),
				BlcgipRelief.class);

		return cgipReliefArr;
	}
}
