package iih.mkr.std.deset.i;

import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.desetca.d.DeSetCaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 数据集扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IDesetMDOExtRService {
	/**
	 * 使用查询方案和数据集分类查询数据集分页数据
	 * 
	 * @param qryRootNodeDto
	 * @param deSetCaDo
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DeDataSetDO> FindPagingDataByQCondAndDeSetCa(QryRootNodeDTO qryRootNodeDto,
			DeSetCaDO deSetCaDo, PaginationInfo pg) throws BizException;
}
