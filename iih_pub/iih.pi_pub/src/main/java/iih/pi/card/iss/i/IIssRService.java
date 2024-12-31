package iih.pi.card.iss.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.pi.card.iss.d.PiCardIssDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 就诊卡发放数据维护服务
*/
public interface IIssRService {
	/**
	*  根据id值查找就诊卡发放数据
	*/	
	public abstract PiCardIssDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找就诊卡发放数据集合
	*/	
	public abstract PiCardIssDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找就诊卡发放数据集合--大数据量
	*/	
	public abstract PiCardIssDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找就诊卡发放数据集合
	*/	
	public abstract PiCardIssDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找就诊卡发放数据集合
	*/	
	public abstract PiCardIssDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PiCardIssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public PiCardIssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract PiCardIssDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract PiCardIssDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract PiCardIssDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}