package iih.bd.pp.hpdidictneusoftah.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.pp.hpdidictneusoftah.d.HpDiDictNeusoftAhDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 付款策略_医保诊断扩展_东软安徽数据维护服务
*/
public interface IHpdidictneusoftahRService {
	/**
	*  根据id值查找付款策略_医保诊断扩展_东软安徽数据
	*/	
	public abstract HpDiDictNeusoftAhDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找付款策略_医保诊断扩展_东软安徽数据集合
	*/	
	public abstract HpDiDictNeusoftAhDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找付款策略_医保诊断扩展_东软安徽数据集合--大数据量
	*/	
	public abstract HpDiDictNeusoftAhDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找付款策略_医保诊断扩展_东软安徽数据集合
	*/	
	public abstract HpDiDictNeusoftAhDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找付款策略_医保诊断扩展_东软安徽数据集合
	*/	
	public abstract HpDiDictNeusoftAhDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<HpDiDictNeusoftAhDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public HpDiDictNeusoftAhDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract HpDiDictNeusoftAhDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract HpDiDictNeusoftAhDO[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract HpDiDictNeusoftAhDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
        /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpDiDictNeusoftAhDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}