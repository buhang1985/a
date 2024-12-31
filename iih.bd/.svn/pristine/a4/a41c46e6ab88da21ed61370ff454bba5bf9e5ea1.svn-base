package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案查询物品分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondBp {

	public PagingRtnData<MeterialDO> exec(QryRootNodeDTO qryRootNodeDTO, String sd_Mmtp, PaginationInfo pg)
			throws BizException {
		FindPagingDataByQCondAndMmCaIdsBp bp = new FindPagingDataByQCondAndMmCaIdsBp();
		return bp.exec(qryRootNodeDTO, null, sd_Mmtp, pg);
	}
}
