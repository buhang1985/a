package iih.ci.mrm.s.mrmmisoperation.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmmisoperation.qry.IMrmMisoperationQryService;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
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

@Service(serviceInterfaces={IMrmMisoperationQryService.class},binding=Binding.JSONRPC)

public class IMrmMisoperationQryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmMisoperationQryService{

	/**
	   *
	   *病案列表
	   *
	**/
	@Override
	public PagingRtnData<CiMrmQryListDTO> GetMrmPediatricsDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) 
			throws BizException{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='"+ICiMrDictCodeConst.SD_MRM_OP_TYPE_STORAGE+"'", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			return null;
		}
		iih.bd.srv.operatetype.d.OperateTypeDO opTypeDo=opTpyedoArr[0];
		String sqlwhere = "where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' and ci_amr.fg_complete = 'Y' ";
		//sqlwhere += " and ci_amr.id_bd_mrm_ot in ('1001Z8100000002C4FD3','1001Z8100000002C4FD4','1001Z8100000002C4FD5')";
		sqlwhere += " and ci_amr.id_bd_mrm_ot <> '"+ opTypeDo.getId_bd_mrm_ot() +"'";
		sqlwhere += " and ci_amr.id_org = '"+Context.get().getOrgId()+"'";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,"");//操作类型code
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
		sql.append("       SELECT ci_amr.id_ent id_ent,\n");				//就诊
		sql.append("       ci_amr.id_enhr as id_amr,\n");					//病案主键标识
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,\n");//医生病案状态
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,\n");//医生病案状态编码
		sql.append("       bu.name as name_qa_doctor_part_sta,\n");//病案状态名称
		sql.append("       ee.name_pat as name_pat,\n");          //患者姓名
		sql.append("       ee.id_pat as id_pat,\n");				//患者基本信息表
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");		
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");	//病案号
		sql.append("       eei.times_ip as inpatient_times,\n");	//住院次数
		sql.append("       ci_amr.code_amr_times as amrcode_and_times,\n");  //  病案号+住院次数
		sql.append("       ee.code_entp as code_entp,\n");			//就诊类型编码
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");	//出院科室
		sql.append("       bd2.name as name_dep_end,\n");			//人员名称
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");		//当前就诊科室
		sql.append("       bd.name dep_phy_name,\n");				//部门名称
		sql.append("       ee.dt_acpt as dt_acpt,\n");				//当前就诊时间
		sql.append("       ee.dt_end as dt_end,\n");				//诊毕时间
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");		//当前主管医生
		sql.append("       psn.name emp_phy_name,\n");				//部门人员姓名
		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");   //操作流程主键名称
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");//操作人员表主键
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");//操作时间
		sql.append(" 	   ci_amr.id_bd_mrm_ot, ");
		sql.append(" 	   ci_mrm_op.updatereason, ");
		sql.append(" 	   ci_mrm_op.id_ci_mrm_op as id_ci_mrm_op, ");
		sql.append("       psnop.name name_psn_operate ");       //部门名称
		sql.append("       FROM ci_amr ci_amr\n");					//就诊病案
		sql.append("       LEFT JOIN en_ent ee\n");					//患者就诊表
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");		
		sql.append("       LEFT JOIN en_ent_ip eei\n");				//住院信息表
		sql.append("       ON ci_amr.id_ent = eei.id_ent\n");
		sql.append("       LEFT JOIN bd_dep bd\n");					//部门表
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");		
		sql.append("       LEFT JOIN bd_dep bd2\n");				//部门表
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN bd_psndoc psn\n");				//人员基本信息表
		sql.append("       ON ee.id_emp_phy = psn.id_psndoc\n");
		sql.append("       inner JOIN (select *from ci_mrm_op where id_ci_mrm_op in (select max(id_ci_mrm_op) from ci_mrm_op group by id_amr ) ) ci_mrm_op\n");		//病案操作表
		sql.append("       ON ci_amr.id_enhr = ci_mrm_op.id_amr and ci_amr.id_bd_mrm_ot = ci_mrm_op.id_bd_mrm_ot \n");
		//sql.append("       AND ci_mrm_op.sd_bd_mrm_ot = '"+sd_bd_mrm_ot+"' \n");
		sql.append("       LEFT JOIN bd_psndoc psnop\n");			//人员基本信息表
		sql.append("       ON ci_mrm_op.id_psn_op = psnop.id_psndoc\n");
		sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot\n");		//操作流程表
		sql.append("       ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n");
		sql.append("       Left join bd_udidoc bu\n");				//
		sql.append("       On bu.id_udidoc = ci_amr.ID_QA_DOCTOR_PART_STA\n");
		sql.append(sqlWhere);
		return sql;
	}

	/**
	 * 修改列表
	 * id_bd_mrm_ot
	 * CiMrmOperateDO
	 **/

	@Override
	public PagingRtnData<CiMrmQryListDTO> GetMrmUpdateDOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where ci_mrm_op.sd_optp != '~' ";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySqll(sqlwhere,"");//操作类型主键
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	/**
	 * 获取sql语句
	 **/
	private StringBuilder getMrmQrySqll(String sqlWhere,String sd_bd_mrm_ot){
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ci_amr.id_ent id_ent,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,\n");
		sql.append("       bu.name as name_qa_doctor_part_sta,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		//sql.append("       eei.times_ip as inpatient_times,\n");
		sql.append("       ci_amr.code_amr_times as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");
		//sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		//sql.append("       bd.name dep_phy_name,\n");
		//sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		//sql.append("       psn.name emp_phy_name,\n");
		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");
		sql.append("       psnop.name name_psn_operate,\n");
		sql.append(" 	   ci_mrm_op.id_ci_mrm_op as id_ci_mrm_op, ");
		sql.append("       ci_mrm_op.updatereason as updatereason\n");
		sql.append("       FROM ci_mrm_op ci_mrm_op\n");					//病案操作表
		sql.append("       LEFT JOIN ci_amr ci_amr\n");						//就诊表
		sql.append("       ON ci_mrm_op.id_amr = ci_amr.id_enhr\n");		
		sql.append("       LEFT JOIN en_ent ee\n");							//患者表
		sql.append("       ON ci_amr.id_ent=ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei \n");					//住院表
		sql.append("       ON ci_amr.id_ent= eei.id_ent\n");
		
		//sql.append("       LEFT JOIN bd_dep bd\n");							//部门表
		//sql.append("       ON ee.id_dep_phy=bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");						//部门表
		sql.append("       ON eei.id_dep_phydisc=bd2.id_dep\n");
		//sql.append("       LEFT JOIN bd_psndoc psn\n");						//人员表
		//sql.append("       ON ee.id_emp_phy=psn.id_psndoc\n");
		
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
