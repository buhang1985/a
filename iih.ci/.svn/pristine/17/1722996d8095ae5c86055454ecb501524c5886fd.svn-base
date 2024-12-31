package iih.ci.mrqc.mrcompletestatusdto.s;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.mrcompletestatusdto.d.MrCompleteStatusDTO;
import iih.ci.mrqc.mrcompletestatusdto.i.IMrCompleteStatusService;
import iih.ci.mrqc.mrcompletestatusdto.s.bp.MrCompleteQryBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={IMrCompleteStatusService.class}, binding=Binding.JSONRPC)
public class IMrCompleteStatusServiceImpl extends PagingServiceImpl<MrCompleteStatusDTO> implements IMrCompleteStatusService {
	
	@Override
	@SuppressWarnings("unchecked")
	public PagingRtnData<MrCompleteStatusDTO> getMrCompleteStatusDTOResult(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo, String paramClient) throws BizException {
		//改由数据库中病历和待书写关联查询
		MrCompleteQryBp bp = new MrCompleteQryBp();
		return bp.getMrCompleteStatusDTOResultByDb(qryRootNodeDTO, paginationInfo, paramClient);
		/*
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		PagingRtnData<MrCompleteStatusDTO> paging = new PagingRtnData<MrCompleteStatusDTO>();
		String querySchema = "";
		// 获取查询方案的sql条件
 		if (qryRootNodeDTO != null) {
 			querySchema = service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		List<MrCompleteStatusDTO> taskDataList = getMrCompleteStatusDTOList(querySchema);
 		
 		if (taskDataList == null || taskDataList.size() <= 0) {
 			paging.setPageData(new FArrayList());
 			return paging;
 		}
 		List<String> idEnts = new ArrayList<String>();
 		// 获取病历任务查询结果中所有id_ent
 		for (int i = 0; i < taskDataList.size(); i++) {
 			String id_ent = taskDataList.get(i).getId_ent();
 			
 			if (idEnts == null || idEnts.size() <= 0)
 				idEnts.add(id_ent);
 			// 筛选id_ent
 			int num = 1;
 			for (String idEnt : idEnts) {
 				if (num > 1) 
 					break;
				if (id_ent == idEnt) 
					num++;
			}
 			if (num == 1)
 				idEnts.add(id_ent);
		}
 		// 根据所有的id_ent查询病历信息
 		CiMrDO[] ciMrDOs = getCiMrDOList(idEnts.toArray(new String[]{}));
 		
 		if (ciMrDOs == null || ciMrDOs.length <= 0) {
 			paging.setPageData(new FArrayList());
 			return paging;
 		}
 		
 		for (int i = 0; i < taskDataList.size(); i++) {
 			for (int j = 0; j < ciMrDOs.length; j++) {
				// 通过id_ent和id_mrtp匹配病历与病历任务，并补充病历创建和签署时间
 				if (ciMrDOs[j].getId_ent().equals(taskDataList.get(i).getId_ent()) && ciMrDOs[j].getId_mrtp().equals(taskDataList.get(i).getId_mrtp())) {
 					taskDataList.get(i).setDt_creat(ciMrDOs[j].getCreatedtime() == null ? "" : ciMrDOs[j].getCreatedtime().toLocalString());
 					taskDataList.get(i).setDt_submit(ciMrDOs[j].getDate_submit() == null ? "" : ciMrDOs[j].getDate_submit().toLocalString());
 					
 					taskDataList.get(i).setId_mr(ciMrDOs[j].getId_mr());
 				}
			}
 			if ((taskDataList.get(i).getDt_creat() == null || "".equals(taskDataList.get(i).getDt_creat())) && (taskDataList.get(i).getId_mr() == null || "".equals(taskDataList.get(i).getId_mr()))) {
 				taskDataList.get(i).setDt_creat("未创建");
 			}
 			if (taskDataList.get(i).getDt_submit() == null || "".equals(taskDataList.get(i).getDt_submit())) {
 				taskDataList.get(i).setDt_submit("未签署");
 			}
 			// 判断病历是否超时及超时时间
 			if ("未创建".equals(taskDataList.get(i).getDt_creat())) {
 				if (new FDateTime().getMillis() <= taskDataList.get(i).getDt_finish().getMillis()) {
 					taskDataList.get(i).setOvertime("未超时");
 				} else {
 					taskDataList.get(i).setOvertime(((int)((new FDateTime().getMillis() - taskDataList.get(i).getDt_finish().getMillis())/(60*60*1000))) + "小时");
 				}
 			} else {
 				if (new FDateTime(taskDataList.get(i).getDt_creat()).getMillis() <= taskDataList.get(i).getDt_finish().getMillis()) {
 					taskDataList.get(i).setOvertime("未超时");
 				} else {
 					taskDataList.get(i).setOvertime(((int)((new FDateTime(taskDataList.get(i).getDt_creat()).getMillis() - taskDataList.get(i).getDt_finish().getMillis())/(60*60*1000))) + "小时");
 				}
 			}
 		}
 		// 当点选单选祖的时候进行数据过滤
 		taskDataList = MrCompleteStatusDTOfilter(taskDataList, paramClient);
 		// 设置总页数
 		paginationInfo.setPageCount((int)Math.ceil(Double.valueOf(taskDataList.size())/Double.valueOf(paginationInfo.getPageSize())));
 		paging.setPagingInfo(paginationInfo);
 		// 计算循环参数
 		FArrayList flist = new FArrayList();
 		int index = paginationInfo.getPageIndex() * paginationInfo.getPageSize();
 		int count = index + paginationInfo.getPageSize();
 		// 如果是最后一页...
 		if (paginationInfo.getPageIndex() == paginationInfo.getPageCount() - 1) {
 			if (taskDataList.size()%paginationInfo.getPageSize() != 0)
 				count = index + (taskDataList.size()%paginationInfo.getPageSize());
 		}
 		// 如果总数小于size...
 		if (taskDataList.size() < paginationInfo.getPageSize())
 			count = taskDataList.size();
 		// 取当前页数据
 		for (int i = index; i < count; i++) {
 			flist.add(taskDataList.get(i));
		}
 		
 		paging.setPageData(flist);
		return paging;
		*/
	}
	
	private StringBuilder getQuerySQL(String sqlWhere) {
		StringBuilder sb = new StringBuilder();
	sb.append(" select en.id_ent   	   as id_ent, ");
		sb.append(" pat.id_pat         as id_pat, ");
		sb.append(" pat.code           as sd_pat, ");
		sb.append(" pat.name           as name_pat, ");
		sb.append(" ip.id_dep_phyadm   as id_dep_phyadm, ");
		sb.append(" dep.code           as sd_dep_phyadm, ");
		sb.append(" dep.name           as name_dep_phyadm, ");
		sb.append(" en.id_emp_phy      as id_doc, ");
		sb.append(" en.dt_acpt         as dt_acpt, ");
		sb.append(" en.dt_end          as dt_end, ");
		sb.append(" psn.code           as sd_doc, ");
		sb.append(" psn.name           as name_doc, ");
		sb.append(" ip.code_amr_ip     as code_amr_ip, ");
		sb.append(" ip.name_bed        as name_bed, ");
		sb.append(" task.id_mrtask     as id_mrtask, ");
		sb.append(" task.id_mrtask_sta as id_mrtask_sta, ");
		sb.append(" bu1.code           as sd_mrtask_sta, ");
		sb.append(" bu1.name           as name_mrtask_sta, ");
		sb.append(" task.dt_begin      as dt_start, ");
		sb.append(" task.dt_end        as dt_finish, ");
		sb.append(" task.id_mrtp       as id_mrtp, ");
		sb.append(" mrtp.code          as sd_mrtp, ");
		sb.append(" mrtp.name          as name_mrtp, ");
		sb.append(" ip.times_ip        as times_inhos, ");
		sb.append(" task.id_mrcactm    as id_mrcactm, ");
		sb.append(" ctm.code 	       as sd_mrcactm, ");
		sb.append(" ctm.name 		   as name_mrcactm ");
		sb.append(" from ci_qa_mrtask task ");
		sb.append(" inner join en_ent en on task.id_ent = en.id_ent ");
		sb.append(" inner join en_ent_ip ip on task.id_ent = ip.id_ent ");
		sb.append(" inner join pi_pat pat on pat.id_pat = task.id_pat ");
		sb.append(" inner join bd_udidoc bu1 on task.id_mrtask_sta = bu1.id_udidoc ");
		sb.append(" inner join bd_dep dep on ip.id_dep_phyadm = dep.id_dep ");
		sb.append(" inner join bd_psndoc psn on en.id_emp_phy = psn.id_psndoc ");
		sb.append(" inner join bd_mrtp mrtp on task.id_mrtp = mrtp.id_mrtp ");
		sb.append(" inner join bd_mrca_ctm ctm on task.id_mrcactm = ctm.id_mrcactm ");
		sb.append(" where 1=1 ");
		sb.append(sqlWhere);
		
		return sb;
	}

	@Override
	public CiMrDO[] getCiMrDOList(String[] idEnts) throws BizException {
		ICiemrRService service = ServiceFinder.find(ICiemrRService.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" id_ent in (");
		
		for (int i = 0; i < idEnts.length; i++) {
			sb.append("'");
			sb.append(idEnts[i]);
			
			if (i < (idEnts.length - 1))
				sb.append("', ");
			else
				sb.append("'");
		}
		sb.append(") ");
		
		return service.find(sb.toString(), "", FBoolean.FALSE);
	}
	
	/**
	 * 查询病历任务（完成情况）数据
	 * @param querySchema
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	private List<MrCompleteStatusDTO> getMrCompleteStatusDTOList(String querySchema) throws BizException {
		StringBuilder sqlWhere = new StringBuilder();
		if (querySchema != null && !"".equals(querySchema)) {
			sqlWhere.append(" and ");
			sqlWhere.append(querySchema);
		}
 		sqlWhere.append(" order by pat.id_pat, task.id_mrtask ");
 		StringBuilder sql = getQuerySQL(sqlWhere.toString());
 		String sqlStr = sql.toString();
 		
 		DAFacade da = new DAFacade();
 		@SuppressWarnings("unchecked")
		List<MrCompleteStatusDTO> taskDataList = 
				(List<MrCompleteStatusDTO>)da.execQuery(sqlStr, new BeanListHandler(MrCompleteStatusDTO.class));
		
		return taskDataList;
	}
	
	/**
	 * 根据单选组的选择情况，筛选数据
	 * @param taskDataList
	 * @param paramClient
	 * @return
	 */
	private List<MrCompleteStatusDTO> MrCompleteStatusDTOfilter(List<MrCompleteStatusDTO> taskDataList, String paramClient) {
		List<MrCompleteStatusDTO> resultList = new ArrayList<MrCompleteStatusDTO>();
		// 按照单选组所选，筛选数据并添加序号
		if (paramClient != null && !"".equals(paramClient)) {
            if ("overUncomp".equals(paramClient)) {
            	int num = 1;
            	for (int i = 0; i < taskDataList.size(); i++) {
                    if (!"未超时".equals(taskDataList.get(i).getOvertime()) && "未签署".equals(taskDataList.get(i).getDt_submit())) {
                    	taskDataList.get(i).setSortno(num);
                    	resultList.add(taskDataList.get(i));
                    	num++;
                    }
                }
            }
            if ("overComp".equals(paramClient)) {
            	int num = 1;
            	for (int i = 0; i < taskDataList.size(); i++) {
                    if (!"未超时".equals(taskDataList.get(i).getOvertime()) && !"未签署".equals(taskDataList.get(i).getDt_submit())) {
                    	taskDataList.get(i).setSortno(num);
                    	resultList.add(taskDataList.get(i));
                    	num++;
                    }
                }
            }
            if ("comp".equals(paramClient)) {
            	int num = 1;
            	for (int i = 0; i < taskDataList.size(); i++) {
                    if ("未超时".equals(taskDataList.get(i).getOvertime()) && !"未签署".equals(taskDataList.get(i).getDt_submit())) {
                    	taskDataList.get(i).setSortno(num);
                    	resultList.add(taskDataList.get(i));
                    	num++;
                    }
                }
            }
            if ("unWrite".equals(paramClient)) {
            	int num = 1;
            	for (int i = 0; i < taskDataList.size(); i++) {
                    if ("未创建".equals(taskDataList.get(i).getDt_creat())) {
                    	taskDataList.get(i).setSortno(num);
                    	resultList.add(taskDataList.get(i));
                    	num++;
                    }
                }
            }
 		}
		// 如果未筛选，则整体添加序号
		if (resultList == null || resultList.size() <= 0) {
			int num = 1;
			for (MrCompleteStatusDTO mrCompleteStatusDTO : taskDataList) {
				mrCompleteStatusDTO.setSortno(num);
				num++;
			}
			return taskDataList;
		} else {
			return resultList;
		}
	}
	
}
