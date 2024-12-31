package iih.bd.res.bizgrp.s;

import iih.bd.res.bizgrp.d.BizGrpBedDO;
import iih.bd.res.bizgrp.i.IBizGrpBedDOExtRService;
import iih.bd.res.bizgrp.s.bp.GetBedBp;
import iih.bd.res.bizgrp.s.bp.GetDepListByDepLineBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 业务组床位扩展服务实现
 * 
 * @author guoyang
 *
 */

public class BizGrpBedDOExtRServiceImpl implements IBizGrpBedDOExtRService {

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	@Override
	public PagingRtnData<BizGrpBedDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		GetBedBp bp = new GetBedBp();
		return bp.exec(pg, wherePart, orderByPart);
	}

	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param depId
	 *            科室或病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getDepListByDepl(String depId, String deplrole) throws BizException {
		GetDepListByDepLineBP getBP = new GetDepListByDepLineBP();
		return getBP.exec(depId, deplrole);
	}
}
