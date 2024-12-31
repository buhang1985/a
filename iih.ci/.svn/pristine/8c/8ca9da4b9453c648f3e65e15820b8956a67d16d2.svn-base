package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class IMrmcatalogerQryBP extends PagingServiceImpl<MrmCatalogerDTO>{
	
	/**
	 * 查询科室编目人
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException 
	 **/
	public PagingRtnData<MrmCatalogerDTO> getMrmCatalogerCrudQuery(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//查询条件
		String sqlwhere = " where c.id_user_catalogue != '~' ";
		if(qryRootNodeDTO != null){
			sqlwhere += " and" + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		
		//从ci_amr里获取编目人信息
		String sqlStr = "select c.id_user_catalogue,c.id_dep_catalogue,s.name name_user_catalogue,s.code code_user_catalogue from ci_amr c left join sys_user s on c.id_user_catalogue = s.id_user  ";
		sqlStr += sqlwhere;
		PagingRtnData<MrmCatalogerDTO> pagingRtnData = super.findByPageInfo(new MrmCatalogerDTO(), paginationInfo, sqlStr, "", null);
			
		return pagingRtnData;
	}

}
