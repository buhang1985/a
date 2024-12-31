package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 使用物品分类Id查询物品分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByMmCaIdsBp {

	public PagingRtnData<MeterialDO> exec(String[] mmCaIds, String sd_Mmtp, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondAndMmCaIdsBp bp = new FindPagingDataByQCondAndMmCaIdsBp();
		return bp.exec(null, mmCaIds, sd_Mmtp, pg);
	}

}
