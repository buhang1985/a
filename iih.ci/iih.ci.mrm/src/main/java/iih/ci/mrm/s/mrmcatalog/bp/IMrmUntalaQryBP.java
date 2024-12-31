package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class IMrmUntalaQryBP extends PagingServiceImpl<MrmCataListDTO>{
	
	/**
	 * 查询已签收  待分配的患者
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 * 
	 * and B. id_dep_out in ’左侧选中科室’ 
	 * */
	
	public PagingRtnData<MrmCataListDTO> getMrmUntalalogQry(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		IMrmCataSaveBp SaveBp = new IMrmCataSaveBp();
		
		String sqlwhere = " where b.id_ent != '~' and (a.id_user_catalogue != '~' ) ";
		if(qryRootNodeDTO != null){
			sqlwhere += " and " + service.getQueryStringWithoutDesc(qryRootNodeDTO); 
		}
		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型code
 		String sqlStr=sql.toString();
 		PagingRtnData<MrmCataListDTO> pagingRtnData = super.findByPageInfo(new MrmCataListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
		
	}
	
	private StringBuilder getMrmQrySql(String sqlWhere,String id_bd_mrm_ot){
		StringBuilder sql = new StringBuilder();
		sql.append("select a.id_user_catalogue , a.dt_catalogue , b.code_amr_ip ,b.id_ent, b.name_pat , b.dt_end , b.name_dep_phydisc from ci_amr a left join ci_mr_fp_pat b on a.id_ent = b.id_ent");
		sql.append(sqlWhere);
		
		return sql;
	}

}
