package iih.bd.res.deptb.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.res.deptb.d.DeptBDO;

/**
* 部门B数据维护服务
*/
public interface IDeptbRService {
	/**
	*  根据id值查找部门B数据
	*/	
	public abstract DeptBDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找部门B数据集合
	*/	
	public abstract DeptBDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找部门B数据集合--大数据量
	*/	
	public abstract DeptBDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找部门B数据集合
	*/	
	public abstract DeptBDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找部门B数据集合
	*/	
	public abstract DeptBDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<DeptBDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	//TODO
	public abstract FArrayList findWorkStation() throws BizException;
}