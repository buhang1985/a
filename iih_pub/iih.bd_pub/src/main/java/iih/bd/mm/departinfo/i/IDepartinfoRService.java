package iih.bd.mm.departinfo.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.mm.departinfo.d.DepartInfoDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗物品_与科室关系数据维护服务
*/
public interface IDepartinfoRService {
	/**
	*  根据id值查找医疗物品_与科室关系数据
	*/	
	public abstract DepartInfoDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗物品_与科室关系数据集合
	*/	
	public abstract DepartInfoDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗物品_与科室关系数据集合--大数据量
	*/	
	public abstract DepartInfoDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗物品_与科室关系数据集合
	*/	
	public abstract DepartInfoDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗物品_与科室关系数据集合
	*/	
	public abstract DepartInfoDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<DepartInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public DepartInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract DepartInfoDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract DepartInfoDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract DepartInfoDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}