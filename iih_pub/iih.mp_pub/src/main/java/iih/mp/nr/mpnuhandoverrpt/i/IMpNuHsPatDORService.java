package iih.mp.nr.mpnuhandoverrpt.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mp.nr.mpnuhandoverrpt.d.MpNuHsPatDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 护理交接班数据维护服务
*/
public interface IMpNuHsPatDORService {
	/**
	*  根据id值查找护理交接班数据
	*/	
	public abstract MpNuHsPatDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找护理交接班数据集合
	*/	
	public abstract MpNuHsPatDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找护理交接班数据集合--大数据量
	*/	
	public abstract MpNuHsPatDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找护理交接班数据集合
	*/	
	public abstract MpNuHsPatDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找护理交接班数据集合
	*/	
	public abstract MpNuHsPatDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MpNuHsPatDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MpNuHsPatDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
}