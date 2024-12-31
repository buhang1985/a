package iih.ci.mr.i;

import iih.ci.mr.cimrcontentdto.d.CiMrContentDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 查询病历详细信息服务
 * @author zhang.jb
 *
 */
public interface ICiMrContentQryService   {
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<CiMrContentDTO> findByPageInfo(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

}
