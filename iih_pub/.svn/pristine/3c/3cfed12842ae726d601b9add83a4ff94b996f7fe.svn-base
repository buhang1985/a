package iih.mm.st.stockinvinrel.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mm.st.stockinvinrel.d.StockInvInRelDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 发票入库单关系数据维护服务
*/
public interface IStockinvinrelRService {
	/**
	*  根据id值查找发票入库单关系数据
	*/	
	public abstract StockInvInRelDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找发票入库单关系数据集合
	*/	
	public abstract StockInvInRelDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找发票入库单关系数据集合--大数据量
	*/	
	public abstract StockInvInRelDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找发票入库单关系数据集合
	*/	
	public abstract StockInvInRelDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找发票入库单关系数据集合
	*/	
	public abstract StockInvInRelDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<StockInvInRelDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public StockInvInRelDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract StockInvInRelDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract StockInvInRelDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract StockInvInRelDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}