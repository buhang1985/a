package iih.bd.pp.prisrvsetmu.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 服务套数量加收数据维护服务
*/
public interface IPrisrvsetmuRService {
	/**
	*  根据id值查找服务套数量加收数据
	*/	
	public abstract PriSrvSetMuDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找服务套数量加收数据集合
	*/	
	public abstract PriSrvSetMuDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找服务套数量加收数据集合--大数据量
	*/	
	public abstract PriSrvSetMuDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找服务套数量加收数据集合
	*/	
	public abstract PriSrvSetMuDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找服务套数量加收数据集合
	*/	
	public abstract PriSrvSetMuDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PriSrvSetMuDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PriSrvSetMuDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}