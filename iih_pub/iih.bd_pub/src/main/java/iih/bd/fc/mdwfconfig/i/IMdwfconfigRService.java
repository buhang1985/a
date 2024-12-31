package iih.bd.fc.mdwfconfig.i;

import java.util.List;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.fc.mdwfconfig.d.MdWfCaDO;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.d.MdwfconfigAggDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 组件数据维护服务
*/
public interface IMdwfconfigRService {
	/**
	*  根据id值查找组件数据
	*/	
	public abstract MdwfconfigAggDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合
	*/	
	public abstract MdwfconfigAggDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合--大数据量
	*/	
	public abstract MdwfconfigAggDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找组件数据集合
	*/	
	public abstract MdwfconfigAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找组件数据集合
	*/	
	public abstract MdwfconfigAggDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<MdwfconfigAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy) throws BizException;
	
	/**
    //查找医嘱流向分类  
    
     * @param cond
     * @param orderBy
     * @return
     * @throws DAException
     */
    public MdWfCaDO[] getMdWfCa(String cond, String orderBy) throws DAException;
    
    /**
    //医嘱流向
     * 
     * @param cond
     * @param orderBy
     * @return
     * @throws DAException
     */
    
    public MdWfDO[] getMdWf(String cond, String orderBy) throws DAException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public MdwfconfigAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}