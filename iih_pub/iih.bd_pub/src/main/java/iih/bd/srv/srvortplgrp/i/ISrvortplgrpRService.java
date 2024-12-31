package iih.bd.srv.srvortplgrp.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.srvortplgrp.d.SrvortplgrpAggDO;

/**
* 医疗服务_医嘱开立模板分组数据维护服务
*/
public interface ISrvortplgrpRService {
	/**
	*  根据id值查找医疗服务_医嘱开立模板分组数据
	*/	
	public abstract SrvortplgrpAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务_医嘱开立模板分组数据集合
	*/	
	public abstract SrvortplgrpAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务_医嘱开立模板分组数据集合--大数据量
	*/	
	public abstract SrvortplgrpAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务_医嘱开立模板分组数据集合
	*/	
	public abstract SrvortplgrpAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务_医嘱开立模板分组数据集合
	*/	
	public abstract SrvortplgrpAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvortplgrpAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
}