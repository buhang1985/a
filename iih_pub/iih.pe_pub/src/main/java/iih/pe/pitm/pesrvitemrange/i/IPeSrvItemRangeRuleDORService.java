package iih.pe.pitm.pesrvitemrange.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.pe.pitm.pesrvitemrange.d.PeSrvItemRangeRuleDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.mw.core.data.SqlParamDTO;

/**
* 体检结果范围定义数据维护服务
*/
public interface IPeSrvItemRangeRuleDORService {
	/**
	*  根据id值查找体检结果范围定义数据
	*/	
	public abstract PeSrvItemRangeRuleDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找体检结果范围定义数据集合
	*/	
	public abstract PeSrvItemRangeRuleDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找体检结果范围定义数据集合--大数据量
	*/	
	public abstract PeSrvItemRangeRuleDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找体检结果范围定义数据集合
	*/	
	public abstract PeSrvItemRangeRuleDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
    /**
	*  根据condition条件查找体检结果范围定义数据集合
	*/
	public abstract PeSrvItemRangeRuleDO[] find2(String whereStr,SqlParamDTO sqlParamDTO,String orderStr,FBoolean isLazy) throws BizException;
	/**
	*  根据查询方案查找体检结果范围定义数据集合
	*/	
	public abstract PeSrvItemRangeRuleDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PeSrvItemRangeRuleDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	public abstract PagingRtnData<PeSrvItemRangeRuleDO> findByPageInfo2(PaginationInfo pg, String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PeSrvItemRangeRuleDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract PeSrvItemRangeRuleDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PeSrvItemRangeRuleDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PeSrvItemRangeRuleDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PeSrvItemRangeRuleDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}