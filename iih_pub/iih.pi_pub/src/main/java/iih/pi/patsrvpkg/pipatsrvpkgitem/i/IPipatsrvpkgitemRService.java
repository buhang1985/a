package iih.pi.patsrvpkg.pipatsrvpkgitem.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PipatsrvpkgitemAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 患者服务包服务项目对照数据维护服务
*/
public interface IPipatsrvpkgitemRService {
	/**
	*  根据id值查找患者服务包服务项目对照数据
	*/	
	public abstract PipatsrvpkgitemAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找患者服务包服务项目对照数据集合
	*/	
	public abstract PipatsrvpkgitemAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找患者服务包服务项目对照数据集合--大数据量
	*/	
	public abstract PipatsrvpkgitemAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找患者服务包服务项目对照数据集合
	*/	
	public abstract PipatsrvpkgitemAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找患者服务包服务项目对照数据集合
	*/	
	public abstract PipatsrvpkgitemAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PipatsrvpkgitemAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PipatsrvpkgitemAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract PipatsrvpkgitemAggDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PipatsrvpkgitemAggDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PipatsrvpkgitemAggDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PipatsrvpkgitemAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy) throws BizException;
}