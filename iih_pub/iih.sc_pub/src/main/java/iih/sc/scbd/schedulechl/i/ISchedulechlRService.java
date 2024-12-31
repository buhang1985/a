package iih.sc.scbd.schedulechl.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 排班预约渠道数据维护服务
*/
public interface ISchedulechlRService {
	/**
	*  根据id值查找排班预约渠道数据
	*/	
	public abstract SchedulechlAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找排班预约渠道数据集合
	*/	
	public abstract SchedulechlAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找排班预约渠道数据集合--大数据量
	*/	
	public abstract SchedulechlAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找排班预约渠道数据集合
	*/	
	public abstract SchedulechlAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;

	/**
	*  根据查询方案查找排班预约渠道数据集合
	*/	
	public abstract SchedulechlAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SchedulechlAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;

    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SchedulechlAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract SchedulechlAggDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract SchedulechlAggDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract SchedulechlAggDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SchedulechlAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy) throws BizException;
}