package iih.bd.srv.usageselfcaitm.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItemDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 用法自定义分类项目数据维护服务
*/
public interface IUsageselfcaitmMDORService {
	/**
	*  根据id值查找用法自定义分类项目数据
	*/	
	public abstract UsageSelfCaItemDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找用法自定义分类项目数据集合
	*/	
	public abstract UsageSelfCaItemDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找用法自定义分类项目数据集合--大数据量
	*/	
	public abstract UsageSelfCaItemDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找用法自定义分类项目数据集合
	*/	
	public abstract UsageSelfCaItemDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找用法自定义分类项目数据集合
	*/	
	public abstract UsageSelfCaItemDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<UsageSelfCaItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public UsageSelfCaItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract UsageSelfCaItemDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract UsageSelfCaItemDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract UsageSelfCaItemDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
}