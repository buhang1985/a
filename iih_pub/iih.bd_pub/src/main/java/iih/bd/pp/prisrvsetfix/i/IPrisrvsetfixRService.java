package iih.bd.pp.prisrvsetfix.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 服务套成员数量定价数据维护服务
*/
public interface IPrisrvsetfixRService {
	/**
	*  根据id值查找服务套成员数量定价数据
	*/	
	public abstract PriSrvSetFixDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找服务套成员数量定价数据集合
	*/	
	public abstract PriSrvSetFixDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找服务套成员数量定价数据集合--大数据量
	*/	
	public abstract PriSrvSetFixDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找服务套成员数量定价数据集合
	*/	
	public abstract PriSrvSetFixDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找服务套成员数量定价数据集合
	*/	
	public abstract PriSrvSetFixDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PriSrvSetFixDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PriSrvSetFixDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}