package iih.ci.mrm.i.mrmcatalog;

import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
/**
 * @author 张静波
 * @date 2018-08-24 15:14
 * 
 */
public interface IMrmCataListService {
	/**
	 *  获取编目列表。后台默认关联ci_mr_fp_pat和ci_amr,使用全名
	 * @param sqlWhere 约束条件
	 * @return
	 */
    public abstract MrmCataListDTO[] getMrmCataList(String sqlWhere)throws DAException;

   /**
    * 根据查询方案获取编目列表.后台默认当前用户，已编目
    * @param qryRootNodeDTO
    * @param paginationInfo
    * @return
    */
    public abstract PagingRtnData<MrmCataListDTO> getMrmCataListByQry(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException ;

    /**
     * 根据查询方案获取编目列表.后台默认当前用户，未编目
     * @param qryRootNodeDTO
     * @param paginationInfo
     * @return
     */
    public abstract PagingRtnData<MrmCataListDTO> getMrmUnCataListByQry(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException ;
    /**
     * 召回病案编目，同时分配给某人
     * @param id_ent 就诊号
     * @param id_user_catalogue 分配给某人，默认不重新分配
     *  @param id_dep_catalogue 编目科室
     * @return
     */
    public abstract FBoolean reCallMrmCataRecord(String[] id_ent,
			String id_user_catalogue,String id_dep_catalogue)throws BizException;
  
  /**
   * 获取编目列表(分页)。后台默认关联ci_mr_fp_pat和ci_amr,使用全名
   * @param pg
   * @param wherePart
   * @param orderByPart
   * @return
   */
    public abstract PagingRtnData<MrmCataListDTO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)throws BizException;
}
