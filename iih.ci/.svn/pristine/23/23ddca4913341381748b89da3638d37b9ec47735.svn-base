package iih.ci.mrm.s.mrmprint.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmprint.qry.IMrmPrintQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IMrmPrintQryService.class}, binding=Binding.JSONRPC)
public class IMrmPrintQryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmPrintQryService{

	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmPrintDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String sd_bd_mrm_ot)
			throws BizException {
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='"+sd_bd_mrm_ot+"'", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			return null;
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where ( ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'  and  ci_amr.SD_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.SD_MR_HASTOFILE+"' ";
		if (sd_bd_mrm_ot!=null) {
			sqlwhere+=" and bd_mrm_ot.code='"+sd_bd_mrm_ot+"'";
		}
		if (opTypeDo.getId_bd_mrm_ot()!=null) {
			sqlwhere+=" and ci_mrm_op.id_bd_mrm_ot='"+opTypeDo.getId_bd_mrm_ot()+"'";
		}
 		
 		sqlwhere += " or ci_mrm_sp.id_mail_state = '"+ICiMrDictCodeConst.ID_MRM_MA_STATE_UNEXECUTED+"'" ;
 		sqlwhere += " and ci_amr.id_org = '"+Context.get().getOrgId()+"')";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,sd_bd_mrm_ot);//操作类型code
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	/**
	 * 获取sql语句   传入 操作类型的code这是个维护好的值
	 * @return
	 */
	private StringBuilder getMrmQrySql(String sqlWhere,String sd_bd_mrm_ot){
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ci_amr.id_ent id_ent,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,\n");
		sql.append("       bu.name as name_qa_doctor_part_sta,\n");
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
		sql.append("       ci_amr.code_amr_times as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name emp_phy_name,\n");
		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");
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
		sql.append("       AND ci_mrm_op.sd_bd_mrm_ot = '"+sd_bd_mrm_ot+"' \n");
		sql.append("       LEFT JOIN bd_psndoc psnop\n");
		sql.append("       ON ci_mrm_op.id_psn_op = psnop.id_psndoc\n");
		sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot\n");
		sql.append("       ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n");
		sql.append("       Left join bd_udidoc bu\n");
		sql.append("       On bu.id_udidoc = ci_amr.ID_QA_DOCTOR_PART_STA\n");
		sql.append(" Left join ci_mrm_sp ci_mrm_sp ");
		sql.append(" On ci_amr.id_enhr = ci_mrm_sp.id_ci_amr ");
		sql.append(sqlWhere);
		return sql;
		
	}
}
