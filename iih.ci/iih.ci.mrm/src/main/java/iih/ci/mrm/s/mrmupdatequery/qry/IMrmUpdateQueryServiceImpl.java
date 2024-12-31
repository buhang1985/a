package iih.ci.mrm.s.mrmupdatequery.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmupdatequery.qry.IMrmUpdateQueryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;


@Service(serviceInterfaces={IMrmUpdateQueryService.class}, binding=Binding.JSONRPC)
public class IMrmUpdateQueryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmUpdateQueryService{

	@Override
	public PagingRtnData<CiMrmQryListDTO> GetMrmUpdateDtoList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere="where ci_mrm_op.sd_optp='07'";
		if(qryRootNodeDTO!=null){
			sqlwhere += "and" + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		sqlwhere += " and ci_amr.id_org = '"+Context.get().getOrgId()+"' ";
		StringBuilder sql= getMrmQrySql(sqlwhere,"");
		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	private StringBuilder getMrmQrySql(String sqlWhere,String sd_bd_mrm_ot){
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ci_amr.id_ent id_ent,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,\n");
		sql.append("       bu.name as name_qa_doctor_part_sta,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");

		sql.append("       ci_amr.code_amr_times as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");

		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");

		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");
		sql.append("       psnop.name name_psn_operate,\n");
		sql.append("       ci_mrm_op.updatereason as updatereason\n");
		
		sql.append("       FROM ci_mrm_op ci_mrm_op\n");					//病案操作表
		sql.append("       LEFT JOIN ci_amr ci_amr\n");						//就诊表
		sql.append("       ON ci_mrm_op.id_amr = ci_amr.id_enhr\n");		
		sql.append("       LEFT JOIN en_ent ee\n");							//患者表
		sql.append("       ON ci_amr.id_ent=ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei \n");					//住院表
		sql.append("       ON ci_amr.id_ent= eei.id_ent\n");

		sql.append("       LEFT JOIN bd_dep bd2\n");						//部门表
		sql.append("       ON eei.id_dep_phydisc=bd2.id_dep\n");
		
		sql.append("       LEFT JOIN bd_psndoc psnop\n");					//人员表
		sql.append("       ON ci_mrm_op.id_psn_op=psnop.id_psndoc\n");
		sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot\n");				//操作流程表
		sql.append("       ON ci_amr.id_bd_mrm_ot=bd_mrm_ot.id_bd_mrm_ot\n");
		sql.append("       LEFT JOIN bd_udidoc bu\n");						//自定义档案
		sql.append("       ON bu.id_udidoc=ci_amr.id_qa_doctor_part_sta\n");
		sql.append(sqlWhere);
		return sql;
	}	
}
