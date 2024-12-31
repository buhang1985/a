/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.medicaldepqc;

import iih.ci.mrqc.qcresult.d.QcPatResultListDTO;
import iih.ci.mrqc.s.bp.medicaldepqc.sqlbp.MedicalDepMrQcSqlBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 〈扼要描述〉
 * 医务相关分页查询
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MedicalDepPageQryBP extends PagingServiceImpl<QcPatResultListDTO>{
	
	/**
	 * 医务查看扣分项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<QcPatResultListDTO> getMedicalQcItmResultList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = " en_ent.dt_acpt is not null";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		MedicalDepMrQcSqlBP sqlBp=new MedicalDepMrQcSqlBP();
 		String sqlStr=sqlBp.GetMedicalDepMrQcResultSql(sqlwhere);
		PagingRtnData<QcPatResultListDTO> pagingRtnData = super.findByPageInfo(new QcPatResultListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
		
	}
}
