package iih.pe.pqn.peevalkinematics.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.pe.pqn.peevalkinematics.d.PeEvalKineFreqDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.mw.core.data.SqlParamDTO;

/**
* 健康评估-运动评估定义数据维护服务
*/
public interface IPeEvalKineFreqDORService {
	/**
	*  根据id值查找健康评估-运动评估定义数据
	*/	
	public abstract PeEvalKineFreqDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找健康评估-运动评估定义数据集合
	*/	
	public abstract PeEvalKineFreqDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找健康评估-运动评估定义数据集合--大数据量
	*/	
	public abstract PeEvalKineFreqDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找健康评估-运动评估定义数据集合
	*/	
	public abstract PeEvalKineFreqDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
    /**
	*  根据condition条件查找健康评估-运动评估定义数据集合
	*/
	public abstract PeEvalKineFreqDO[] find2(String whereStr,SqlParamDTO sqlParamDTO,String orderStr,FBoolean isLazy) throws BizException;
	/**
	*  根据查询方案查找健康评估-运动评估定义数据集合
	*/	
	public abstract PeEvalKineFreqDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PeEvalKineFreqDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	public abstract PagingRtnData<PeEvalKineFreqDO> findByPageInfo2(PaginationInfo pg, String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PeEvalKineFreqDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract PeEvalKineFreqDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PeEvalKineFreqDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract PeEvalKineFreqDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PeEvalKineFreqDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}