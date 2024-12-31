package iih.bd.res.workstation.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.res.workstation.d.WorkStationParamDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 计算机工作站参数数据维护服务
*/
public interface IWorkstationparamRService {
	/**
	*  根据id值查找计算机工作站参数数据
	*/	
	public abstract WorkStationParamDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找计算机工作站参数数据集合
	*/	
	public abstract WorkStationParamDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找计算机工作站参数数据集合--大数据量
	*/	
	public abstract WorkStationParamDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找计算机工作站参数数据集合
	*/	
	public abstract WorkStationParamDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找计算机工作站参数数据集合
	*/	
	public abstract WorkStationParamDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<WorkStationParamDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public WorkStationParamDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}