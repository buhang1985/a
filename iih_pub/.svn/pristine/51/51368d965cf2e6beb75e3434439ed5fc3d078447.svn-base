package iih.bd.srv.medusage.i;

import iih.bd.srv.medusage.d.MedUsageDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 用法扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IMedusageExtRService {

	/**
	 * 使用服务类型和查询方案查询用法分页数据
	 * 
	 * @param srvTp
	 *            服务类型
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return
	 */
	public abstract PagingRtnData<MedUsageDO> FindPagingByQcondAndSrvTp(UdidocDO srvTp, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;
}
