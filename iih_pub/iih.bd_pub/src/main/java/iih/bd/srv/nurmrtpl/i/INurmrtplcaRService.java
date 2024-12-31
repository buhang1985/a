package iih.bd.srv.nurmrtpl.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 护理记录内容模板分类数据维护服务
*/
public interface INurmrtplcaRService {
	/**
	*  根据id值查找护理记录内容模板分类数据
	*/	
	public abstract NurMrConTplCaDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找护理记录内容模板分类数据集合
	*/	
	public abstract NurMrConTplCaDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找护理记录内容模板分类数据集合--大数据量
	*/	
	public abstract NurMrConTplCaDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找护理记录内容模板分类数据集合
	*/	
	public abstract NurMrConTplCaDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找护理记录内容模板分类数据集合
	*/	
	public abstract NurMrConTplCaDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<NurMrConTplCaDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public NurMrConTplCaDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}