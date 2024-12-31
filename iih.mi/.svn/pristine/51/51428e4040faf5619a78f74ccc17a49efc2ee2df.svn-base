package iih.mi.mibd.srvfac.s;

import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import iih.mi.mibd.srvfac.i.ISrvfacExtCudService;
import iih.mi.mibd.srvfac.i.ISrvfacExtRService;
import iih.mi.mibd.srvfac.s.bp.FindPagingByMisAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 服务设施扩展服务
 * 
 * @author dj.zhang
 *
 */
public class SrvfacExtCrudServiceImpl implements ISrvfacExtCudService, ISrvfacExtRService {

	/**
	 * 根据所属医保系统和查询方案查询服务设施分页数据
	 * 
	 * @param oppDimen
	 *            所属量纲
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<SrvfacDO> FindPagingByMisAndQCond(MisDO mis, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg) throws BizException {

		FindPagingByMisAndQCondBp bp = new FindPagingByMisAndQCondBp();
		PagingRtnData<SrvfacDO> result = bp.exec(mis, qryRootNodeDto, orderStr, pg);
		return result;
	}

}
