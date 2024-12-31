package iih.bl.cg.s.bp.ip.ipoutpatprice;

import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetPriceBedFeeQry;
import iih.en.pv.enres.d.EnBedDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 检索床位费(只统计主床)是否划价
 * @author LIM
 *
 */
public class GetPriceBedFeeBP {
	public EnBedDO[] exec(String id_ent) throws BizException{
		EnBedDO[] enBedDOArr = (EnBedDO[]) AppFwUtil.getDORstWithDao(new GetPriceBedFeeQry(id_ent), EnBedDO.class);
		return enBedDOArr;
	}
}
