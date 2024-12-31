package iih.ci.mrqc.cimrrecallentdto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.cimrrecallentdto.d.CiMrRecallEntDTO;
import iih.ci.mrqc.cimrrecallentdto.i.ICiMrRecallEntRService;

import java.util.List;

import xap.mw.core.data.*;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { ICiMrRecallEntRService.class }, binding = Binding.JSONRPC)
public class CiMrRecallEntRServiceImpl extends
		PagingServiceImpl<CiMrRecallEntDTO> implements ICiMrRecallEntRService {

	/**
	 * 通过字符串条件获取数据
	 */
	public CiMrRecallEntDTO[] GetCiMrRecallEntDTOs(String dt_ent,
			String id_deps, String code_ents, String pat_names) throws BizException {
			DAFacade daf = new DAFacade();
			StringBuilder sql = new StringBuilder();
		String sqlStr = sql.toString();
			
			@SuppressWarnings("unchecked")
		List<CiMrRecallEntDTO> qaFltDTOsList = (List<CiMrRecallEntDTO>) daf
				.execQuery(sqlStr, new BeanListHandler(CiMrRecallEntDTO.class));
		if (qaFltDTOsList == null)
					return null;
			return (CiMrRecallEntDTO[]) qaFltDTOsList.toArray(new CiMrRecallEntDTO[qaFltDTOsList.size()]);
	 }

	 /**
	  * 通过查询方案获取数据
	  */
	public PagingRtnData<CiMrRecallEntDTO> GetCiMrRecallEntDTOsFromNode(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		// 当前时间
    			FDateTime fd = new FDateTime();
		// 当前人员id
		String psnId = Context.get().getStuffId();
		String userId = Context.get().getUserId();
    		
    			StringBuilder sqlFixationWhere = new StringBuilder();
    			sqlFixationWhere.append(" and ent.id_ent not in (select recall.id_ent from ci_mr_recall  recall where recall.id_state not in ('");
		sqlFixationWhere.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_PIGEONHOLE);
    			sqlFixationWhere.append("', '");
    			sqlFixationWhere.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_REJECT);
    			sqlFixationWhere.append("') and recall.id_ent is not null) ");
		sqlFixationWhere.append("and op.dt_valid_e is not null and op.dt_valid_e < '");
    			sqlFixationWhere.append(fd.toLocalString());
		sqlFixationWhere.append("' ");
		/*
		 * 查询条件调整：
		 * 	1.查询当前登录人为责任医师的患者信息
		 * 	2.查询的患者的门诊病历中，如果有当前登录用户写过病历，同样可以提召回申请
		 * mantis：0194466: 病历召回申请问题，第二个医生写的病历在门诊病历召回工作站搜不到患者
		 *  - by Vampire 2020.7.2
		 */
		sqlFixationWhere.append(" and (ent.id_emp_phy = '");
    			sqlFixationWhere.append(psnId);
		sqlFixationWhere.append("' or ent.id_ent in (select mr.id_ent from ci_mr mr where mr.id_emp = '");
		sqlFixationWhere.append(userId);
		sqlFixationWhere.append("' and mr.code_entp = '00' and mr.ds = '0')) ");
		sqlFixationWhere.append(" and ent.ds ='0'");

		String sqlwhere = " where 1=1" + sqlFixationWhere.toString();
		// FArrayList arry = service.getQueryFieldValue(qryRootNodeDTO,
		// "pat_name");
		if (qryRootNodeDTO != null) {
    	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
    	 		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.id_ent as id_ent, ");
    	 		sql.append(" ent.code as ent_code, ");
		sql.append(" pat.barcode_chis as barcode_chis, ");
		sql.append(" name_pat pat_name, ");
		sql.append(" case ");
		sql.append(" when ent.sd_sex_pat = '0' then  '未知的性别' ");
		sql.append(" when ent.sd_sex_pat = '1' then '男' ");
		sql.append(" when ent.sd_sex_pat = '2' then '女' ");
		sql.append(" when ent.sd_sex_pat = '9' then '未说明性别' end as pat_sex, ");
		sql.append(" ent.dt_birth_pat as pat_age, ");
		sql.append(" ent.dt_acpt as dt_ent, ");
		sql.append(" bd.name as name_dep_ent, ");
		sql.append(" ent.id_dep_phy as id_dep_ent, ");
		sql.append(" bd.code as code_dep_ent, ");
    	 		sql.append(" case ");
		sql.append(" when op.fg_first = 'Y' then '初诊' ");
		sql.append(" when op.fg_first is null then '复诊' end as FG_First ");
		sql.append(" from en_ent ent left join bd_dep bd on ent.id_dep_phy = bd.id_dep ");
		sql.append(" left join pi_pat pat on ent.id_pat = pat.id_pat ");
		sql.append(" left join en_ent_op op on ent.id_ent = op.id_ent ");
		sql.append(sqlwhere);
		String sqlStr = sql.toString();
    	 		
		PagingRtnData<CiMrRecallEntDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrRecallEntDTO(), paginationInfo, sqlStr, "", null);
    			return pagingRtnData;
     }
}
