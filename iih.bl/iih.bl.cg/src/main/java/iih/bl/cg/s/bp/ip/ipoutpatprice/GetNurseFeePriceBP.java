package iih.bl.cg.s.bp.ip.ipoutpatprice;

import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetNurseFeePriceQry;
import iih.en.pv.enres.d.EnBedDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 检索护理费是否划价数据
 * @author LIM
 *
 */
public class GetNurseFeePriceBP {
	public EnBedDO[] exec(String id_ent) throws BizException{
		EnBedDO[] enBedDOArr = (EnBedDO[]) AppFwUtil.getDORstWithDao(new GetNurseFeePriceQry(id_ent), EnBedDO.class);
		return enBedDOArr;
	}
}
