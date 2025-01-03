package iih.bl.cg.blcgoeptf.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 门诊记账转移记录数据维护服务
*/
public interface IBlcgoeptfRService {
	/**
	*  根据id值查找门诊记账转移记录数据
	*/	
	public abstract BlCgItmOepTfRcdDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找门诊记账转移记录数据集合
	*/	
	public abstract BlCgItmOepTfRcdDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找门诊记账转移记录数据集合--大数据量
	*/	
	public abstract BlCgItmOepTfRcdDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找门诊记账转移记录数据集合
	*/	
	public abstract BlCgItmOepTfRcdDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找门诊记账转移记录数据集合
	*/	
	public abstract BlCgItmOepTfRcdDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<BlCgItmOepTfRcdDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepTfRcdDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgItmOepTfRcdDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgItmOepTfRcdDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgItmOepTfRcdDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
    /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlCgItmOepTfRcdDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
	/**
	 * 查询门诊转入住院的总金额
	 * @author zhang.hw
	 * @date 2020年4月9日
	 * @param ident
	 * @return
	 * @throws BizException
	 */
	public BlCgIpDO[] queryIpStAmt(String ident) throws BizException;
	
	/**
	 * 门诊退费时查询可退费用
	 * @author zhang.hw
	 * @date 2020年4月29日
	 * @param idoepcgitms
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepTfRcdDO[] findoeptfrcdInfo(String[] idoepcgitms) throws BizException;
}