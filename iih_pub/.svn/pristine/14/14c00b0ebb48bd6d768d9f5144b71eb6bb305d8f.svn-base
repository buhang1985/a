package iih.bd.srv.enregpkg.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.enregpkg.d.SrvEnRegPkgDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗服务就诊登记包数据维护服务
*/
public interface IEnregpkgRService {
	/**
	*  根据id值查找医疗服务就诊登记包数据
	*/	
	public abstract SrvEnRegPkgDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务就诊登记包数据集合
	*/	
	public abstract SrvEnRegPkgDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务就诊登记包数据集合--大数据量
	*/	
	public abstract SrvEnRegPkgDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务就诊登记包数据集合
	*/	
	public abstract SrvEnRegPkgDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务就诊登记包数据集合
	*/	
	public abstract SrvEnRegPkgDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SrvEnRegPkgDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SrvEnRegPkgDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}