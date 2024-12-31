package iih.bd.srv.srvortplcate.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.srvortplcate.d.SrvOrTplCateDO;

/**
* 医疗服务医嘱模板分类数据维护服务
*/
public interface ISrvortplcateRService {
	/**
	*  根据id值查找医疗服务医嘱模板分类数据
	*/	
	public abstract SrvOrTplCateDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板分类数据集合
	*/	
	public abstract SrvOrTplCateDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板分类数据集合--大数据量
	*/	
	public abstract SrvOrTplCateDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务医嘱模板分类数据集合
	*/	
	public abstract SrvOrTplCateDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务医嘱模板分类数据集合
	*/	
	public abstract SrvOrTplCateDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvOrTplCateDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
}