package iih.bd.pp.baseprisrv.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 价格服务数据维护服务
*/
public interface IBaseprisrvMDORService {
	/**
	*  根据id值查找价格服务数据
	*/	
	public abstract PriSrvDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找价格服务数据集合
	*/	
	public abstract PriSrvDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找价格服务数据集合--大数据量
	*/	
	public abstract PriSrvDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找价格服务数据集合
	*/	
	public abstract PriSrvDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
		
	/**
	 * 根据条件和参数集查询数据集合
	 * @param whereStr
	 * @param sqlParamDTO
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract PriSrvDO[] find2(String whereStr, SqlParamDTO sqlParamDTO, String orderStr, FBoolean isLazy) throws BizException; 
	
	/**
	*  根据查询方案查找价格服务数据集合
	*/	
	public abstract PriSrvDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PriSrvDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PriSrvDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract PriSrvDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PriSrvDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PriSrvDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PriSrvDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}