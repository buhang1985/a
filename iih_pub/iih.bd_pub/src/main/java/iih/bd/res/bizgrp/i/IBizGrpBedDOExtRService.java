package iih.bd.res.bizgrp.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.dept.d.DeptDO;
import iih.bd.res.bizgrp.d.BizGrpBedDO;

/**
 * 业务组床位扩展服务
 * 
 * @author guoyang
 *
 */
public interface IBizGrpBedDOExtRService {

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	public abstract PagingRtnData<BizGrpBedDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException;
	
	/**
	 * 根据业务线，查询病区的科室集合
	 * 业务线暂时没有，临时放在这里，后续迁移
	 * @param depId 科室或病区id
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getDepListByDepl(String depId,String deplrole) throws BizException;
}