package iih.mi.mibd.srvfac.i;

import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 服务设施扩展数据查询服务接口
 * 
 * @author dj.zhang
 *
 */
public interface ISrvfacExtRService {
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
	public abstract PagingRtnData<SrvfacDO> FindPagingByMisAndQCond(MisDO mis, QryRootNodeDTO qryRootNodeDto,
            String orderStr, PaginationInfo pg) throws BizException;
}