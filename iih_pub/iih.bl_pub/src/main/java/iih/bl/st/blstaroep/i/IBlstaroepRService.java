package iih.bl.st.blstaroep.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bl.st.blstaroep.d.BlstaroepAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 结算应收_门急体数据维护服务
*/
public interface IBlstaroepRService {
	/**
	*  根据id值查找结算应收_门急体数据
	*/	
	public abstract BlstaroepAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找结算应收_门急体数据集合
	*/	
	public abstract BlstaroepAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找结算应收_门急体数据集合--大数据量
	*/	
	public abstract BlstaroepAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找结算应收_门急体数据集合
	*/	
	public abstract BlstaroepAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找结算应收_门急体数据集合
	*/	
	public abstract BlstaroepAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<BlstaroepAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public BlstaroepAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}