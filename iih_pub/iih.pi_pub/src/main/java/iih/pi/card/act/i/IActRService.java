package iih.pi.card.act.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.pi.card.act.d.PiCardActDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 就诊卡操作记录数据维护服务
*/
public interface IActRService {
	/**
	*  根据id值查找就诊卡操作记录数据
	*/	
	public abstract PiCardActDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找就诊卡操作记录数据集合
	*/	
	public abstract PiCardActDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找就诊卡操作记录数据集合--大数据量
	*/	
	public abstract PiCardActDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找就诊卡操作记录数据集合
	*/	
	public abstract PiCardActDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找就诊卡操作记录数据集合
	*/	
	public abstract PiCardActDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PiCardActDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PiCardActDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract PiCardActDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract PiCardActDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract PiCardActDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}