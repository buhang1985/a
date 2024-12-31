package iih.bd.srv.srvortpl.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.srvortpl.d.SrvortplAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗服务医嘱模板数据维护服务
*/
public interface ISrvortplRService {
	/**
	*  根据id值查找医疗服务医嘱模板数据
	*/	
	public abstract SrvortplAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvortplAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板数据集合--大数据量
	*/	
	public abstract SrvortplAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvortplAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvortplAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvortplAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SrvortplAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract SrvortplAggDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract SrvortplAggDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract SrvortplAggDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}