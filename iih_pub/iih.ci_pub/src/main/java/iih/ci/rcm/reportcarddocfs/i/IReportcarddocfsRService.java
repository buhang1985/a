package iih.ci.rcm.reportcarddocfs.i;

import java.io.IOException;

import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 报卡文书流表数据维护服务
*/
public interface IReportcarddocfsRService {
	/**
	*  根据id值查找报卡文书流表数据
	*/	
	public abstract ReportCardDocFsDo findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找报卡文书流表数据集合
	*/	
	public abstract ReportCardDocFsDo[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找报卡文书流表数据集合--大数据量
	*/	
	public abstract ReportCardDocFsDo[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找报卡文书流表数据集合
	*/	
	public abstract ReportCardDocFsDo[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找报卡文书流表数据集合
	*/	
	public abstract ReportCardDocFsDo[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<ReportCardDocFsDo> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public ReportCardDocFsDo[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract ReportCardDocFsDo[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ReportCardDocFsDo[] findByAttrValStrings(String attr, String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ReportCardDocFsDo[] findByAttrValList(String attr, FArrayList values) throws BizException;
    
     /**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ReportCardDocFsDo> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;

}