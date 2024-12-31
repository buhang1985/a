package iih.mi.mibd.di.i;

import iih.mi.mibd.di.d.DiDO;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 病种目录扩展数据查询服务接口
 * 
 * @author dj.zhang
 *
 */
public interface IDiExtRService {
	
	/**
	 * 根据所属医保系统和查询方案查询病种目录分页数据
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
	public abstract PagingRtnData<DiDO> FindPagingByMisAndQCond(MisDO mis, QryRootNodeDTO qryRootNodeDto,
            String orderStr, PaginationInfo pg) throws BizException;
}