package iih.mm.mc.monthacc.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mm.mc.monthacc.d.MonthAccFlagDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 仓库月结标志数据维护服务
*/
public interface IMonthaccflagRService {
	/**
	*  根据id值查找仓库月结标志数据
	*/	
	public abstract MonthAccFlagDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找仓库月结标志数据集合
	*/	
	public abstract MonthAccFlagDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找仓库月结标志数据集合--大数据量
	*/	
	public abstract MonthAccFlagDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找仓库月结标志数据集合
	*/	
	public abstract MonthAccFlagDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找仓库月结标志数据集合
	*/	
	public abstract MonthAccFlagDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MonthAccFlagDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MonthAccFlagDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}