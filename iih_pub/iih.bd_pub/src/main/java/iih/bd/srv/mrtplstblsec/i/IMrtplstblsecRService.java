package iih.bd.srv.mrtplstblsec.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.mrtplstblsec.d.MrtplstblsecAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医疗记录模板智能表格段落数据维护服务
*/
public interface IMrtplstblsecRService {
	/**
	*  根据id值查找医疗记录模板智能表格段落数据
	*/	
	public abstract MrtplstblsecAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医疗记录模板智能表格段落数据集合
	*/	
	public abstract MrtplstblsecAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医疗记录模板智能表格段落数据集合--大数据量
	*/	
	public abstract MrtplstblsecAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医疗记录模板智能表格段落数据集合
	*/	
	public abstract MrtplstblsecAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医疗记录模板智能表格段落数据集合
	*/	
	public abstract MrtplstblsecAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MrtplstblsecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MrtplstblsecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}