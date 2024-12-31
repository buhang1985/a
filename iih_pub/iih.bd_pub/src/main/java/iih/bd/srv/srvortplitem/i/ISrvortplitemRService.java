package iih.bd.srv.srvortplitem.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.srvortplitem.d.SrvOrTplItemDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗服务_医嘱模板项目数据维护服务
*/
public interface ISrvortplitemRService {
	/**
	*  根据id值查找医疗服务_医嘱模板项目数据
	*/	
	public abstract SrvOrTplItemDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务_医嘱模板项目数据集合
	*/	
	public abstract SrvOrTplItemDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务_医嘱模板项目数据集合--大数据量
	*/	
	public abstract SrvOrTplItemDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务_医嘱模板项目数据集合
	*/	
	public abstract SrvOrTplItemDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务_医嘱模板项目数据集合
	*/	
	public abstract SrvOrTplItemDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvOrTplItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SrvOrTplItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract SrvOrTplItemDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract SrvOrTplItemDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract SrvOrTplItemDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}