package iih.bd.res.bizgrp.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.res.bizgrp.d.BizgrpMasterDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 业务组主表数据维护服务
*/
public interface IBizgrpmasterRService {
	/**
	*  根据id值查找业务组主表数据
	*/	
	public abstract BizgrpMasterDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找业务组主表数据集合
	*/	
	public abstract BizgrpMasterDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找业务组主表数据集合--大数据量
	*/	
	public abstract BizgrpMasterDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找业务组主表数据集合
	*/	
	public abstract BizgrpMasterDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找业务组主表数据集合
	*/	
	public abstract BizgrpMasterDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<BizgrpMasterDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public BizgrpMasterDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}