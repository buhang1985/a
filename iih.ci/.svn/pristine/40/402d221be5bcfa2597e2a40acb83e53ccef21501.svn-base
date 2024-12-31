package iih.ci.mrm.s.mrmregisterqry.bp;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class IMrmRegisterListDetailQry extends PagingServiceImpl<CiMrmQryListDTO>{

	/**
	 * 病案补充详细记录
	 * 
	 * **/
	
	PagingRtnData<CiMrmQryListDTO> GetRegisterDetailQryList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型code
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
		
	}
	
	private StringBuilder getMrmQrySql(String sqlWhere,String id_bd_mrm_ot){
		return null;
	}
	
}
