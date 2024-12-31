/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.outqc;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class OutMrQcPageInfoQryBP extends PagingServiceImpl<CiMrQcRandomRecordDO> {
	
	public PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordDoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		IMrqcrandomcheckMDORService qryService=ServiceFinder.find(IMrqcrandomcheckMDORService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" and (is_outdep_qc='Y' and (");
 		sb.append(" (Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"' and Sd_random_status='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI+"')");
 		sb.append(" or (Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_DEP+"' and Sd_random_status='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YITIJIAO+"')");
 		sb.append(" ))");
 		sb.append(" or ((is_outdep_qc='N' or is_outdep_qc is null) and ");
 		sb.append(" (Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_DEP+"' and Sd_random_status='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YITIJIAO+"')");
 		sb.append(" )");
 		sb.append(" and id_by_dep='"+Context.get().getDeptId()+"'");
 		PagingRtnData<CiMrQcRandomRecordDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), " sd_type_random asc,sv desc,ID_RANDOM_RECORD");
 		
		return pagingRtnData;
 	}
	/**
	 * 门诊科室质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		IMrqcrandomcheckMDORService qryService=ServiceFinder.find(IMrqcrandomcheckMDORService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" and ((Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"' and Sd_random_status<>'"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI+"') or Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_DEP+"' )");
		sb.append(" and id_by_dep='"+Context.get().getDeptId()+"'");
 		PagingRtnData<CiMrQcRandomRecordDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), " sd_type_random asc,sv desc,ID_RANDOM_RECORD");
 		
		return pagingRtnData;
 	}
	/**
	 * 门诊部已抽查查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordDoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		IMrqcrandomcheckMDORService qryService=ServiceFinder.find(IMrqcrandomcheckMDORService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" and Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"'");
 		sb.append(" and ((is_outdep_qc='Y' and Sd_random_status='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YITIJIAO+"') ");
 		sb.append(" or  ((is_outdep_qc='N' or is_outdep_qc is null) and Sd_random_status='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI+"'))");
 		PagingRtnData<CiMrQcRandomRecordDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), " sd_type_random asc,sv desc,ID_RANDOM_RECORD");
 		
		return pagingRtnData;
 	}
	/**
	 * 门诊部质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		IMrqcrandomcheckMDORService qryService=ServiceFinder.find(IMrqcrandomcheckMDORService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" and Sd_type_random='"+ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD+"'");
 		PagingRtnData<CiMrQcRandomRecordDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), " sd_type_random asc,sv desc,ID_RANDOM_RECORD");

		return pagingRtnData;
 	}
}
