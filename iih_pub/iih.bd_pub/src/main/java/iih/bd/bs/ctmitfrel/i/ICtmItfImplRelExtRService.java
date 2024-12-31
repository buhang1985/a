package iih.bd.bs.ctmitfrel.i;

import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 客开接口与实现类关系扩展服务接口
 * 
 * @author hao_wu 2019-6-14
 *
 */
public interface ICtmItfImplRelExtRService {

	/**
	 * 根据查询方案查询客开接口与实现类关系分页数据
	 * 
	 * @param qryRootNodeDto 查询方案
	 * @param orderPart      排序语句
	 * @param wherePart      条件语句
	 * @param pg             分页信息
	 * @return 分页数据
	 */
	public PagingRtnData<CtmItfRelDO> findRelPagingByQCond(QryRootNodeDTO qryRootNodeDto, String orderPart,
			String wherePart, PaginationInfo pg) throws BizException;
}
