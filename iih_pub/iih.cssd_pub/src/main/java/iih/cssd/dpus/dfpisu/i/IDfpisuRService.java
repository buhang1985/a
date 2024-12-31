package iih.cssd.dpus.dfpisu.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.cssd.dpus.dfpisu.d.DfpSendDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.mw.core.data.SqlParamDTO;

/**
* 消毒包发放数据维护服务
*/
public interface IDfpisuRService {
	/**
	*  根据id值查找消毒包发放数据
	*/	
	public abstract DfpSendDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找消毒包发放数据集合
	*/	
	public abstract DfpSendDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找消毒包发放数据集合--大数据量
	*/	
	public abstract DfpSendDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找消毒包发放数据集合
	*/	
	public abstract DfpSendDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据condition条件查找消毒包发放数据集合
	*/
	public abstract DfpSendDO[] find2(String whereStr,SqlParamDTO sqlParamDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找消毒包发放数据集合
	*/	
	public abstract DfpSendDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<DfpSendDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	public abstract PagingRtnData<DfpSendDO> findByPageInfo2(PaginationInfo pg, String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public DfpSendDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract DfpSendDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract DfpSendDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract DfpSendDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
        /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DfpSendDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}