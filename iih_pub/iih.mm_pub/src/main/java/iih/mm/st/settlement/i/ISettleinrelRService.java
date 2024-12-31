package iih.mm.st.settlement.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mm.st.settlement.d.SettlementInRelDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 结算回冲关系数据维护服务
*/
public interface ISettleinrelRService {
	/**
	*  根据id值查找结算回冲关系数据
	*/	
	public abstract SettlementInRelDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找结算回冲关系数据集合
	*/	
	public abstract SettlementInRelDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找结算回冲关系数据集合--大数据量
	*/	
	public abstract SettlementInRelDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找结算回冲关系数据集合
	*/	
	public abstract SettlementInRelDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找结算回冲关系数据集合
	*/	
	public abstract SettlementInRelDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<SettlementInRelDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public SettlementInRelDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract SettlementInRelDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract SettlementInRelDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract SettlementInRelDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}