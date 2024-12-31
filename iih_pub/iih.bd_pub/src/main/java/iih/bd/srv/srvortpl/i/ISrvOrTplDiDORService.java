package iih.bd.srv.srvortpl.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.srvortpl.d.SrvOrTplDiDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗服务医嘱模板数据维护服务
*/
public interface ISrvOrTplDiDORService {
	/**
	*  根据id值查找医疗服务医嘱模板数据
	*/	
	public abstract SrvOrTplDiDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvOrTplDiDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务医嘱模板数据集合--大数据量
	*/	
	public abstract SrvOrTplDiDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvOrTplDiDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务医嘱模板数据集合
	*/	
	public abstract SrvOrTplDiDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvOrTplDiDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SrvOrTplDiDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract SrvOrTplDiDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract SrvOrTplDiDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract SrvOrTplDiDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
}