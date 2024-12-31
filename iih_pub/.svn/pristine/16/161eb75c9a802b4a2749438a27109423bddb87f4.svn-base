package iih.bd.srv.medsrv.i;

import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
* 医疗服务关联物品数据维护服务
*/

public interface IMedsrvRelMmRService {
	/**
	*  根据id值查找医疗服务关联物品数据
	*/	
	public abstract MedSrvRelMmDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务关联物品数据集合
	*/	
	public abstract MedSrvRelMmDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗服务关联物品数据集合--大数据量
	*/	
	public abstract MedSrvRelMmDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗服务关联物品数据集合
	*/	
	public abstract MedSrvRelMmDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗服务关联物品数据集合
	*/	
	public abstract MedSrvRelMmDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MedSrvRelMmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;


}
