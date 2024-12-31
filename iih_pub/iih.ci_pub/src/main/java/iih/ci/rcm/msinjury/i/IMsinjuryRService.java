package iih.ci.rcm.msinjury.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.rcm.msinjury.d.MsInjuryDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗锐器伤登记表数据维护服务
*/
public interface IMsinjuryRService {
	/**
	*  根据id值查找医疗锐器伤登记表数据
	*/	
	public abstract MsInjuryDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗锐器伤登记表数据集合
	*/	
	public abstract MsInjuryDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗锐器伤登记表数据集合--大数据量
	*/	
	public abstract MsInjuryDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗锐器伤登记表数据集合
	*/	
	public abstract MsInjuryDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗锐器伤登记表数据集合
	*/	
	public abstract MsInjuryDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MsInjuryDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MsInjuryDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract MsInjuryDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract MsInjuryDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract MsInjuryDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
        /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<MsInjuryDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}