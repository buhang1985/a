package iih.ci.mrm.s.mrmsignoff.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import iih.bd.srv.operateprocess.i.IOperateprocessRService;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmsignoff.qry.IMrmSignoffService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IMrmSignoffService.class}, binding=Binding.JSONRPC)
public class IMrmSignoffServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmSignoffService{

	/**
	*  病案代签收查询
	*/
	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmNeedSignOffDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'  and  ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMWRITE+"'";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型主键
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}

	/**
	*  病案已签收查询
	*/
	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmHasSignOffDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' ";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型主键
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}

	/**
	*  病案已扫描查询
	*/
	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmHasScanningDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'  and  ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMSIGNOFF+"'";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型主键
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	
	

	/**
	 * 获取sql语句   传入 操作类型的code这是个维护好的值
	 * @return
	 */
	private StringBuilder getMrmQrySql(String sqlWhere,String id_bd_mrm_ot){
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ci_amr.id_ent id_ent,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       eei.times_ip as inpatient_times,\n");
		sql.append("       ci_amr.code_amr_ip ||\'+\'|| eei.times_ip as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name emp_phy_name,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       psnop.name name_psn_operate\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ci_amr.id_ent = eei.id_ent\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN bd_psndoc psn\n");
		sql.append("       ON ee.id_emp_phy = psn.id_psndoc\n");
		sql.append("       LEFT JOIN ci_mrm_op ci_mrm_op\n");
		sql.append("       ON ci_amr.id_enhr = ci_mrm_op.id_amr\n");
		sql.append("       AND ci_mrm_op.id_bd_mrm_ot = '"+id_bd_mrm_ot+"'");
		sql.append("       LEFT JOIN bd_psndoc psnop\n");
		sql.append("       ON ci_mrm_op.id_psn_op = psnop.id_psndoc\n");
		sql.append(sqlWhere);
		return sql;
		
	}
	
}
