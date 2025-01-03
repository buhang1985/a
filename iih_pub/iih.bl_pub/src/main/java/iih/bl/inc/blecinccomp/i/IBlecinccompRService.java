package iih.bl.inc.blecinccomp.i;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blecinccomp.dto.d.BlecIncCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 电子票据对照数据维护服务
*/
public interface IBlecinccompRService {
	/**
	*  根据id值查找电子票据对照数据
	*/	
	public abstract BlEcIncCompDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找电子票据对照数据集合
	*/	
	public abstract BlEcIncCompDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找电子票据对照数据集合--大数据量
	*/	
	public abstract BlEcIncCompDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找电子票据对照数据集合
	*/	
	public abstract BlEcIncCompDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据condition条件查找电子票据对照数据集合
	*/
	public abstract BlEcIncCompDO[] find2(String whereStr,SqlParamDTO sqlParamDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找电子票据对照数据集合
	*/	
	public abstract BlEcIncCompDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<BlEcIncCompDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	public abstract PagingRtnData<BlEcIncCompDO> findByPageInfo2(PaginationInfo pg, String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public BlEcIncCompDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract BlEcIncCompDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract BlEcIncCompDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract BlEcIncCompDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
        /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlEcIncCompDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
	/***
	 * 查询电子发票对应的账单项信息
	 * @author zhang.hw
	 * @date 2020年2月12日
	 * @param id_udidoc
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlecIncCompDTO> FindIncCompDataList(String id_udidoc, PaginationInfo pg) throws BizException;
	
}