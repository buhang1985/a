package iih.bd.srv.ems.i;

import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IEmsprntmplExtService {

	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<EmsPrnTmplDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	*  根据id值查找医疗单打印模板管理数据
	*/	
	public abstract EmsprntmplAggDO findById(String id) throws BizException;
}
