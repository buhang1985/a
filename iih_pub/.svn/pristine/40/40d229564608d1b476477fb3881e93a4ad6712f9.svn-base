package iih.bd.srv.usageselfca.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.usageselfca.d.UsageSlefCateDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 组件数据维护服务
*/
public interface IUsageselfcaRService {
	/**
	*  根据id值查找组件数据
	*/	
	public abstract UsageSlefCateDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合
	*/	
	public abstract UsageSlefCateDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合--大数据量
	*/	
	public abstract UsageSlefCateDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找组件数据集合
	*/	
	public abstract UsageSlefCateDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找组件数据集合
	*/	
	public abstract UsageSlefCateDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<UsageSlefCateDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public UsageSlefCateDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract UsageSlefCateDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract UsageSlefCateDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract UsageSlefCateDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}