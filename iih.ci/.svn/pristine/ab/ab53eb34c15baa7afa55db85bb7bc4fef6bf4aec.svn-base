package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrqc.cimrrecallentdto.d.CiMrRecallEntDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @author 张静波
 * @date 2018年8月27日 下午2:47:41
 * @des 获取编目列表查询服务(page)
 */
public class MrmCataListQryPageBP extends PagingServiceImpl<MrmCataListDTO> {
	
	/**
	 * 根据查询方案，获取病案编目列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<MrmCataListDTO> getMrmCataListByQry(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//查询条件
		String sqlwhere = " where id_user_catalogue = '"+ Context.get().getUserId()+"' and dt_catalogue is not null and dt_catalogue <>'~'";
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		} 
		//从病案表、病案首页患者表查询数据
		String sqlStr = "select * from ci_amr left join ci_mr_fp_pat on ci_amr.id_ent = ci_mr_fp_pat.id_ent ";
		sqlStr += sqlwhere;
		PagingRtnData<MrmCataListDTO> pagingRtnData = super.findByPageInfo(new MrmCataListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	public PagingRtnData<MrmCataListDTO> getMrmUnCataListByQry(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//查询条件
		String sqlwhere = " where id_user_catalogue = '"+ Context.get().getUserId()+"' and (dt_catalogue is null or dt_catalogue = '~')";
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		} 
		//从病案表、病案首页患者表查询数据
		String sqlStr = "select * from ci_amr left join ci_mr_fp_pat on ci_amr.id_ent = ci_mr_fp_pat.id_ent ";
		sqlStr += sqlwhere;
		PagingRtnData<MrmCataListDTO> pagingRtnData = super.findByPageInfo(new MrmCataListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	/**
	 * 获取编目列表(分页)。后台默认关联ci_mr_fp_pat和ci_amr,使用全名
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<MrmCataListDTO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart) throws BizException
	{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		
		//从病案表、病案首页患者表查询数据
		String sqlStr = "select * from ci_amr left join ci_mr_fp_pat on ci_amr.id_ent = ci_mr_fp_pat.id_ent ";
		sqlStr += wherePart;
		PagingRtnData<MrmCataListDTO> pagingRtnData = super.findByPageInfo(new MrmCataListDTO(), pg, sqlStr, "", null);

		return pagingRtnData;
	}
}
