package iih.ci.mrm.healthsystem.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 对照数据维护服务
*/
public interface IValueContrastDetailDORService {
	/**
	*  根据id值查找对照数据
	*/	
	public abstract ValueContrastDetailDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找对照数据集合
	*/	
	public abstract ValueContrastDetailDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找对照数据集合--大数据量
	*/	
	public abstract ValueContrastDetailDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找对照数据集合
	*/	
	public abstract ValueContrastDetailDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	/**
	*  根据查询方案查找对照数据集合
	*/	
	public abstract ValueContrastDetailDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<ValueContrastDetailDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public ValueContrastDetailDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract ValueContrastDetailDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ValueContrastDetailDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ValueContrastDetailDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ValueContrastDetailDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
	/**
	 * (自定义)根据查询模板条件、分页信息查询分页数据集合；
	 * 与自动服务相比会自动计算序号
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ValueContrastDetailDO> findByQCondAndPageInfoCustom(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	/**
	*  (自定义)根据分页信息及查询与分组条件获得分页数据
	*  与自动服务相比会自动计算序号
	*/
	public abstract PagingRtnData<ValueContrastDetailDO> findByPageInfoCustom(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
}