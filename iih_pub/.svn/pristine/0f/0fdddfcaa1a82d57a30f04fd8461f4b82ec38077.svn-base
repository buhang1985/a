package iih.bd.res.usergrpdept.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.res.usergrpdept.d.UserGrpAndDeptDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 用户组和部门关系数据维护服务
*/
public interface IUsergrpdeptRService {
	/**
	*  根据id值查找用户组和部门关系数据
	*/	
	public abstract UserGrpAndDeptDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找用户组和部门关系数据集合
	*/	
	public abstract UserGrpAndDeptDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找用户组和部门关系数据集合--大数据量
	*/	
	public abstract UserGrpAndDeptDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找用户组和部门关系数据集合
	*/	
	public abstract UserGrpAndDeptDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找用户组和部门关系数据集合
	*/	
	public abstract UserGrpAndDeptDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<UserGrpAndDeptDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public UserGrpAndDeptDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}