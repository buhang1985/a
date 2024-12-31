package iih.bd.bc.condition.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.bc.condition.d.ConditionCateDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 条件指标分类数据维护服务
*/
public interface IConditioncateRService {
	/**
	*  根据id值查找条件指标分类数据
	*/	
	public abstract ConditionCateDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找条件指标分类数据集合
	*/	
	public abstract ConditionCateDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找条件指标分类数据集合--大数据量
	*/	
	public abstract ConditionCateDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找条件指标分类数据集合
	*/	
	public abstract ConditionCateDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找条件指标分类数据集合
	*/	
	public abstract ConditionCateDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<ConditionCateDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public ConditionCateDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}