package iih.nm.nca.nmncatmpl.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.nm.nca.nmncatmpl.d.NmNcaTpmlDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 满意度问卷模板数据维护服务
*/
public interface INmncatmplMDORService {
	/**
	*  根据id值查找满意度问卷模板数据
	*/	
	public abstract NmNcaTpmlDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找满意度问卷模板数据集合
	*/	
	public abstract NmNcaTpmlDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找满意度问卷模板数据集合--大数据量
	*/	
	public abstract NmNcaTpmlDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找满意度问卷模板数据集合
	*/	
	public abstract NmNcaTpmlDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
		
	/**
	*  根据查询方案查找满意度问卷模板数据集合
	*/	
	public abstract NmNcaTpmlDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<NmNcaTpmlDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public NmNcaTpmlDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract NmNcaTpmlDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract NmNcaTpmlDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract NmNcaTpmlDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmNcaTpmlDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}