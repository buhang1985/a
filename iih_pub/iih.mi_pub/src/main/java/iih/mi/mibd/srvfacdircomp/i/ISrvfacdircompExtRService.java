package iih.mi.mibd.srvfacdircomp.i;

import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医保平台_服务设施对照数据维护服务
*/
public interface ISrvfacdircompExtRService {
	/**
	 * 根据分页信息查询对照分页数据集合
	 * @param qryRootNodeDTO
	 * @param mis_id
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SrvfacDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String mis_id, PaginationInfo pg) throws BizException;
}