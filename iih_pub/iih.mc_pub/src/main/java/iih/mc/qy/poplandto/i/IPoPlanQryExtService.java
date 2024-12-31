package iih.mc.qy.poplandto.i;

import iih.mc.pl.mcstockplan.d.McstockplanAggDO;
import iih.mc.qy.poplandto.d.PoPlanDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPoPlanQryExtService {

	/**
	 * 采购计划查询
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PoPlanDTO> findPoPlan(QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException;

}
