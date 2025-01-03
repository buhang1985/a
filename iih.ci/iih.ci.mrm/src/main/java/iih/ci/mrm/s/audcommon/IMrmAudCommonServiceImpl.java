package iih.ci.mrm.s.audcommon;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import iih.bd.srv.operateprocess.i.IOperateprocessRService;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmoperate.d.CiMrmOperateDO;
import iih.ci.mrm.cimrmoperate.i.ICimrmoperateCudService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.audcommon.IMrmAudCommonService;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeRService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces={IMrmAudCommonService.class}, binding=Binding.JSONRPC)
public class IMrmAudCommonServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmAudCommonService{

	@Override
	public FBoolean saveMrmForward(CiMrmQryListDTO[] ciMrmQryListDtos,String sd_bd_mrm_ot,String id_optp,String sd_optp) throws BizException {
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='"+sd_bd_mrm_ot+"'", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			return FBoolean.FALSE;
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		//取操作流程表数据
		IOperateprocessRService opProcessService =ServiceFinder.find(IOperateprocessRService.class);
		OperateProcessDO[] opProcessdoArr=opProcessService.find(" id_bd_mrm_ot_cu='"+opTypeDo.getId_bd_mrm_ot()+"'", "", FBoolean.FALSE);
		if (opProcessdoArr==null||opProcessdoArr.length<=0) {			
			return FBoolean.FALSE;
		}
		OperateProcessDO opProcessDo=opProcessdoArr[0];
		
		if(opProcessDo.getId_bd_mrm_ot_fw()==null){
			return FBoolean.FALSE;
		}
		//判断是否是 结束流程
		OperateTypeDO opNextTpyedo;
		if (opProcessDo.getFg_end().equals(FBoolean.TRUE)||opProcessDo.getId_bd_mrm_ot_fw().equals(opTypeDo.getId_bd_mrm_ot())) {
			opNextTpyedo=opTypeDo;
		}else {
			//取前进流程的操作类型数据
			opNextTpyedo=opTypeService.findById(opProcessDo.getId_bd_mrm_ot_fw());
			if (opNextTpyedo==null) {
				return FBoolean.FALSE;
			}
		}
		
		//保存病案的状态
		ICiamrCudService ciamrService =ServiceFinder.find(ICiamrCudService.class);
		ICiamrRService ciamrFindService=ServiceFinder.find(ICiamrRService.class);		
		List<String> amrIdList =new ArrayList<String>();
		for (CiMrmQryListDTO ciMrmQryListDTO : ciMrmQryListDtos) {
			amrIdList.add(ciMrmQryListDTO.getId_amr());
		}
		if (amrIdList.size()<=0) {
			return FBoolean.FALSE;
		}
		String[] amrfindStr =  amrIdList.toArray(new String[0]);
		AMrDO[] amrDos = ciamrFindService.findByBIds(amrfindStr, FBoolean.FALSE);

		List<AMrDO> amrList =new ArrayList<AMrDO>();
		for (AMrDO aMrDO : amrDos) {
			if (opNextTpyedo!=null && opNextTpyedo.getId_qa_doctor_part_sta()!=null && opNextTpyedo.getSd_qa_doctor_part_sta()!=null && opNextTpyedo.getId_bd_mrm_ot()!=null) {
				aMrDO.setId_qa_doctor_part_sta(opNextTpyedo.getId_qa_doctor_part_sta());
				aMrDO.setSd_qa_doctor_part_sta(opNextTpyedo.getSd_qa_doctor_part_sta());
				aMrDO.setId_bd_mrm_ot(opNextTpyedo.getId_bd_mrm_ot());
				aMrDO.setStatus(DOStatus.UPDATED);
				amrList.add(aMrDO);
			}
		}
		if (amrList.size()<=0) {
			return FBoolean.FALSE;
		}
		ciamrService.save(amrList.toArray(new AMrDO[0]));
		
		//保存操作记录
		List<CiMrmOperateDO> cimMrmOperateDoList =new ArrayList<CiMrmOperateDO>();
		for (AMrDO aMrDo : amrList) {
			CiMrmOperateDO ciMrmOperateDO = new CiMrmOperateDO();
			ciMrmOperateDO.setId_bd_mrm_ot(opNextTpyedo.getId_bd_mrm_ot());
			ciMrmOperateDO.setSd_bd_mrm_ot(opNextTpyedo.getCode());
			ciMrmOperateDO.setId_amr(aMrDo.getId_enhr());
			ciMrmOperateDO.setId_psn_op(Context.get().getStuffId());
			ciMrmOperateDO.setDt_op(new FDateTime());
			ciMrmOperateDO.setId_optp(id_optp);
			ciMrmOperateDO.setSd_optp(sd_optp);
			ciMrmOperateDO.setStatus(DOStatus.NEW);
			
			cimMrmOperateDoList.add(ciMrmOperateDO);
		}
		ICimrmoperateCudService opService =ServiceFinder.find(ICimrmoperateCudService.class);
		opService.save(cimMrmOperateDoList.toArray(new CiMrmOperateDO[0]));
		
		return FBoolean.TRUE;
	}

	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmDTOList(QryRootNodeDTO qryRootNodeDTO, 
			PaginationInfo paginationInfo,String sd_bd_mrm_ot,String mrStatus) throws BizException {	
		//取操作类型表数据
		IOperatetypeRService opTypeService = ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr = opTypeService.find(" code = '"+sd_bd_mrm_ot+"' ", "", FBoolean.FALSE);
		if (opTpyedoArr == null || opTpyedoArr.length <= 0) {			
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		//取操作流程表数据
		IOperateprocessRService opProcessService = ServiceFinder.find(IOperateprocessRService.class);
		OperateProcessDO[] opProcessdoArr=opProcessService.find(" id_bd_mrm_ot_cu = '"+opTypeDo.getId_bd_mrm_ot()+"' ", "", FBoolean.FALSE);
		if (opProcessdoArr == null || opProcessdoArr.length <= 0) {			
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作流程维护】");
		}
		OperateProcessDO opProcessDo = opProcessdoArr[0];
		//定义查询方案解析服务
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		//定义查询语句
		String sqlStr = "";
		String specWhere = "";
		//判断是否是 开始流程
		if (opProcessDo.getFg_start().equals(FBoolean.TRUE)) {
			String sqlwhere = " where ci_amr.code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ";
			String result = CiMrMParamUtils.getMrSignOffStatusParam(Context.get().getOrgId());
			
			if (StringUtils.isEmptyWithTrim(result)) {
				specWhere = getSpecialIdEnt();
				sqlwhere += " and  ci_amr.fg_complete = 'Y' ";
				// 查询不是书写中的，可能完成了 给召回，这个时候可能是书写中
				sqlwhere += " and ci_amr.sd_qa_doctor_part_sta <> '"+ICiMrDictCodeConst.SD_MR_WRITING+"'";				
			} else {		
				sqlwhere += " and ci_amr.id_qa_doctor_part_sta in (";
				if (result.contains(",")) {
					String[] strArr=result.split(",");
				    for (int i = 0; i < strArr.length; i++) {
				    	if (i == strArr.length - 1)
				    		sqlwhere += " '"+strArr[i] + "') ";
				    	else
				    		sqlwhere += " '"+strArr[i]+"', ";
				    }
				} else {
					sqlwhere += " '"+result+"') ";
				}
			}
			// 查询没进行过病案操作的，病案操作的起始就是  签收 ，签收开始有数据	 ；bd_mrm_ot.code = ‘99’流程走到待签收
			sqlwhere += " and (bd_mrm_ot.code = " + ICiMrDictCodeConst.SD_MRM_OP_TYPE_NEEDSIGNOFF + 
					//" or ci_amr.id_enhr not in (select id_amr from ci_mrm_op))";
					" or ci_mrm_op2.id_amr is null )";
	 		if (qryRootNodeDTO != null)
	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		sqlwhere += specWhere;
	 		if (!StringUtil.isEmptyWithTrim(mrStatus))
	 			sqlwhere += " and ci_amr.sd_qa_doctor_part_sta = '07' ";
	 		StringBuilder sql = getNeedSignMrmQrySql(sqlwhere);//操作类型code
	 		sqlStr = sql.toString();
		} else {
			//取后退流程的操作类型数据
			OperateTypeDO opForwardTpyedo=opTypeService.findById(opProcessDo.getId_bd_mrm_ot_bo());
			if (opForwardTpyedo == null)
				throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
			
			String sqlwhere = " where ci_amr.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_IP + 
					"' and ci_amr.id_bd_mrm_ot = '"+opForwardTpyedo.getId_bd_mrm_ot()+"' ";
	 		if (qryRootNodeDTO!=null){
	 			sqlwhere += " AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		}
	 		sqlwhere += specWhere;
	 		if (!StringUtil.isEmptyWithTrim(mrStatus)) {
	 			sqlwhere += " and ci_amr.sd_qa_doctor_part_sta='07'";
	 		}
	 		StringBuilder sql = getMrmQrySql(sqlwhere,opForwardTpyedo.getId_bd_mrm_ot());//操作类型主键
	 		sqlStr = sql.toString();		
		}	
		Logger.info("********** 病案签收查询SQL **********");
		Logger.info(sqlStr);
			
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		FArrayList list = pagingRtnData.getPageData();
		if (list == null || list.size() <= 0)
			return pagingRtnData;
		for (int i = 0; i < list.size(); i++) {
			CiMrmQryListDTO dto = (CiMrmQryListDTO)list.get(i);
			MrPsnDTO[] psnDtos = getPsnDtosByIdEnt(dto.getId_ent());
			
			if (psnDtos != null && psnDtos.length > 0) {
				for (MrPsnDTO psnDto: psnDtos) {
					if (StringUtils.isEmptyWithTrim(dto.getName_zz_doc()) && "主治医师".equals(psnDto.getPsndocname())) {
						dto.setName_zz_doc(psnDto.getName());
					}
					if (StringUtils.isEmptyWithTrim(dto.getName_zy_doc()) && "住院医师".equals(psnDto.getPsndocname())) {
						dto.setName_zy_doc(psnDto.getName());
					}
				}
			}
		}
		return pagingRtnData;
	}
	
	/**
	 * 获取特殊的限制的id_ent;
	 * 郑州要求（现在版本）：只有没有问题的病案可以签收
	 * @return 
	 * @throws BizException 
	 */
	private String getSpecialIdEnt() throws BizException
	{
		String speWhere = "";
		IRevisionnoticeRService ser = ServiceFinder.find(IRevisionnoticeRService.class);
		if (ser != null) {
			String sqlWhere = "sd_status <> '"+ICiMrDictCodeConst.SD_AUDIT+"' "; 
			RevisionNoticeDO[] arrNotice = ser.find(sqlWhere, "", FBoolean.FALSE);
			if (arrNotice != null && arrNotice.length > 0) {
				int count  = 0;
				speWhere =" and (ci_amr.id_ent not in (";
				for (RevisionNoticeDO notice :arrNotice) {
					++count;
					if (count == 900) {
						speWhere += " '" + notice.getId_ent() + "') or ci_amr.id_ent not in (  ";
						count = 0;
					} else {
						speWhere += " '" + notice.getId_ent() + "', ";
					}
				}
				//排除所有审核未通过的id_ent
				speWhere = speWhere.substring(0, speWhere.length() - 2) + ")) ";
			}
		}
		return speWhere;
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
		//sql.append("       ci_amr.code_amr_ip ||\'+\'|| eei.times_ip as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as admissiondate,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name emp_phy_name,\n");
		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       psnop.name name_psn_operate,\n");
		sql.append("       wg.name as  name_wg_phy\n");
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
		sql.append("       AND ci_mrm_op.id_bd_mrm_ot = '"+id_bd_mrm_ot+"' \n");
		sql.append("       LEFT JOIN bd_psndoc psnop\n");
		sql.append("       ON ci_mrm_op.id_psn_op = psnop.id_psndoc\n");
		sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot\n");
		sql.append("       ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n");
		sql.append("       Left join bd_udidoc bu\n");
		sql.append("       On bu.id_udidoc = ci_amr.ID_QA_DOCTOR_PART_STA\n");
		sql.append(" 	   left join bd_wg wg\n");
		sql.append(" 	   on wg.id_wg=ee.id_wg_phy\n");
		sql.append(sqlWhere);
		sql.append(" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false));
		sql.append(" order by ci_amr.sv desc ");
		return sql;
		
	}
	private StringBuilder getNeedSignMrmQrySql(String sqlWhere){
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
		//sql.append("       ci_amr.code_amr_ip ||\'+\'|| eei.times_ip as amrcode_and_times,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_end,\n");
		sql.append("       bd2.name as name_dep_end,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as admissiondate,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name emp_phy_name,\n");
		sql.append("       bd_mrm_ot.name as name_mrm_ot,\n");
		sql.append("       ci_mrm_op.dt_op as dt_operate,\n");
		sql.append("       ci_mrm_op.id_psn_op as id_psn_operate,\n");
		sql.append("       psnop.name name_psn_operate,\n");
		sql.append("       wg.name as  name_wg_phy\n");
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
		sql.append("       AND ci_mrm_op.id_bd_mrm_ot =  ci_amr.id_bd_mrm_ot \n");//待签收使用这个
		sql.append("       LEFT JOIN bd_psndoc psnop\n");
		sql.append("       ON ci_mrm_op.id_psn_op = psnop.id_psndoc\n");
		sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot\n");
		sql.append("       ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n");
		sql.append("       Left join bd_udidoc bu\n");
		sql.append("       On bu.id_udidoc = ci_amr.ID_QA_DOCTOR_PART_STA\n");
		sql.append(" 	   left join bd_wg wg\n");
		sql.append(" 	   on wg.id_wg=ee.id_wg_phy\n");
		sql.append(" 	   left join ci_mrm_op ci_mrm_op2\n");
		sql.append(" 		on ci_mrm_op2.id_amr = ci_amr.id_enhr\n");
		sql.append(sqlWhere);
		sql.append(" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false));
		sql.append(" order by ci_amr.sv desc ");
		return sql;
		
	}
	/**
	 * 无流程的操作保存
	 * @param ciMrmQryListDtos
	 * @param sd_bd_mrm_ot
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean saveMrmNotInProcess(CiMrmQryListDTO[] ciMrmQryListDtos,
			String sd_bd_mrm_ot, String id_optp, String sd_optp)
			throws BizException {
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='"+sd_bd_mrm_ot+"'", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			return FBoolean.FALSE;
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		
		//保存病案的状态
		ICiamrCudService ciamrService =ServiceFinder.find(ICiamrCudService.class);
		ICiamrRService ciamrFindService=ServiceFinder.find(ICiamrRService.class);	
		 
		ICiemrRService ciemrService =ServiceFinder.find(ICiemrRService.class);
		ICiemrCudService ciemrCudService =ServiceFinder.find(ICiemrCudService.class);
		List<CiMrDO> list=new ArrayList<CiMrDO>();
		
		List<String> amrIdList =new ArrayList<String>();
		for (CiMrmQryListDTO ciMrmQryListDTO : ciMrmQryListDtos) {
			amrIdList.add(ciMrmQryListDTO.getId_amr());
			CiMrDO[] ciMrDos = ciemrService.find("id_ent='"+ciMrmQryListDTO.getId_ent()+"'","",FBoolean.FALSE);
			if(ciMrDos!=null && ciMrDos.length>0){
				for(CiMrDO ciMrdo: ciMrDos){
					ciMrdo.setFg_complete(FBoolean.FALSE);
					ciMrdo.setStatus(DOStatus.UPDATED);
					list.add(ciMrdo);
				}
				ciemrCudService.save(list.toArray(new CiMrDO[0]));
			}	
		}
		if (amrIdList.size()<=0) {
			return FBoolean.FALSE;
		}
		String[] amrfindStr =  amrIdList.toArray(new String[0]);
		AMrDO[] amrDos = ciamrFindService.findByBIds(amrfindStr, FBoolean.FALSE);
      
		
		List<AMrDO> amrList =new ArrayList<AMrDO>();
		for (AMrDO aMrDO : amrDos) {
			if (opTypeDo!=null && opTypeDo.getId_qa_doctor_part_sta()!=null && opTypeDo.getSd_qa_doctor_part_sta()!=null && opTypeDo.getId_bd_mrm_ot()!=null) {
				aMrDO.setId_qa_doctor_part_sta(opTypeDo.getId_qa_doctor_part_sta());
				aMrDO.setSd_qa_doctor_part_sta(opTypeDo.getSd_qa_doctor_part_sta());
				aMrDO.setId_bd_mrm_ot(opTypeDo.getId_bd_mrm_ot());
				if(opTypeDo.getCode().equals("05") || opTypeDo.getCode().equals("06")){
					aMrDO.setFg_complete(FBoolean.FALSE);
				}else{
					aMrDO.setFg_complete(FBoolean.TRUE);
				}
				aMrDO.setStatus(DOStatus.UPDATED);
				amrList.add(aMrDO);
			}
		}
		if (amrList.size()<=0) {
			return FBoolean.FALSE;
		}
		ciamrService.save(amrList.toArray(new AMrDO[0]));
		
		//保存操作记录
		List<CiMrmOperateDO> cimMrmOperateDoList =new ArrayList<CiMrmOperateDO>();
		for (AMrDO aMrDo : amrList) {
			CiMrmOperateDO ciMrmOperateDO = new CiMrmOperateDO();
			ciMrmOperateDO.setId_bd_mrm_ot(opTypeDo.getId_bd_mrm_ot());
			ciMrmOperateDO.setSd_bd_mrm_ot(opTypeDo.getCode());
			ciMrmOperateDO.setId_amr(aMrDo.getId_enhr());
			ciMrmOperateDO.setId_psn_op(Context.get().getStuffId());
			ciMrmOperateDO.setDt_op(new FDateTime());
			ciMrmOperateDO.setId_optp(id_optp);
			ciMrmOperateDO.setSd_optp(sd_optp);
			ciMrmOperateDO.setStatus(DOStatus.UPDATED);
			
			cimMrmOperateDoList.add(ciMrmOperateDO);
		}
		ICimrmoperateCudService opService =ServiceFinder.find(ICimrmoperateCudService.class);
		opService.save(cimMrmOperateDoList.toArray(new CiMrmOperateDO[0]));
		
		return FBoolean.TRUE;
	}

	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmDTONotInProcessList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,
			String sd_bd_mrm_ot) throws BizException {
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='"+sd_bd_mrm_ot+"'", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		
		//定义查询方案解析服务
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//定义查询语句
		String sqlStr="";
		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' and  ci_amr.id_bd_mrm_ot='"+opTypeDo.getId_bd_mrm_ot()+"'";
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getMrmQrySql(sqlwhere,opTypeDo.getId_bd_mrm_ot());//操作类型主键
 		sqlStr=sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	

	// 获取医疗组人员
    public MrPsnDTO[] getPsnDtosByIdEnt(String id_ent) throws BizException{
    	DAFacade daf = new DAFacade();
		String strSql ="select b.id_psndoc as id_psn ,b.name,udi.name as psndocname from en_ent_emp emp "
				+" left join bd_psndoc  b on b.id_psndoc = emp.id_emp "
				+" left join bd_udidoc udi "
				+" on udi.id_udidoclist = '@@@@ZZ2000000000004V' and emp.sd_emprole=udi.code "
				+" where emp.id_ent = '"+id_ent+"' order by emp.dt_b desc ";		
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null) return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);
    }
}
