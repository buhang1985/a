package iih.bd.mm.mmrelskinsrv.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.mm.mmrelskinsrv.d.MmRelSkinTestSrvDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 物品关联的皮试服务数据维护服务
*/
public interface IMmrelskinsrvRService {
	/**
	*  根据id值查找物品关联的皮试服务数据
	*/	
	public abstract MmRelSkinTestSrvDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找物品关联的皮试服务数据集合
	*/	
	public abstract MmRelSkinTestSrvDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找物品关联的皮试服务数据集合--大数据量
	*/	
	public abstract MmRelSkinTestSrvDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找物品关联的皮试服务数据集合
	*/	
	public abstract MmRelSkinTestSrvDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找物品关联的皮试服务数据集合
	*/	
	public abstract MmRelSkinTestSrvDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MmRelSkinTestSrvDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MmRelSkinTestSrvDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}