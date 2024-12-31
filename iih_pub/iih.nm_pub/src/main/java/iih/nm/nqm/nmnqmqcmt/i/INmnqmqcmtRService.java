package iih.nm.nqm.nmnqmqcmt.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.nm.nqm.nmnqmqcmt.d.NmnqmqcmtAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 护理管理_质控会议议题数据维护服务
*/
public interface INmnqmqcmtRService {
	/**
	*  根据id值查找护理管理_质控会议议题数据
	*/	
	public abstract NmnqmqcmtAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找护理管理_质控会议议题数据集合
	*/	
	public abstract NmnqmqcmtAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找护理管理_质控会议议题数据集合--大数据量
	*/	
	public abstract NmnqmqcmtAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找护理管理_质控会议议题数据集合
	*/	
	public abstract NmnqmqcmtAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找护理管理_质控会议议题数据集合
	*/	
	public abstract NmnqmqcmtAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<NmnqmqcmtAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public NmnqmqcmtAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract NmnqmqcmtAggDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract NmnqmqcmtAggDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract NmnqmqcmtAggDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmnqmqcmtAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy) throws BizException;
}