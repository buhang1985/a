package iih.mm.gl.generalledger.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.mm.gl.generalledger.d.GeneralLedgerDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 总账数据维护服务
*/
public interface IGeneralledgerRService {
	/**
	*  根据id值查找总账数据
	*/	
	public abstract GeneralLedgerDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找总账数据集合
	*/	
	public abstract GeneralLedgerDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找总账数据集合--大数据量
	*/	
	public abstract GeneralLedgerDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找总账数据集合
	*/	
	public abstract GeneralLedgerDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找总账数据集合
	*/	
	public abstract GeneralLedgerDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<GeneralLedgerDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public GeneralLedgerDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}