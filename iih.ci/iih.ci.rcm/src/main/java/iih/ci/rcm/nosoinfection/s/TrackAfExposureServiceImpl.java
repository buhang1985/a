package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.nosoinfection.i.ITrackAfExposureService;
import iih.ci.rcm.trackafterexposuredto.d.TrackAfterExposureDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 暴露后追踪记录数据查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {ITrackAfExposureService.class}, binding = Binding.JSONRPC)
public class TrackAfExposureServiceImpl extends PagingServiceImpl<TrackAfterExposureDTO> implements ITrackAfExposureService {

	public PagingRtnData<TrackAfterExposureDTO> getTrackAfExposureList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
        IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT cri.id_ent,\n");
		sql.append("       cri.id_trackafexposure ,\n");
		//sql.append("       cri.fill_in_date   as  investigatetime,\n"); // 调查表时间
		sql.append("       cri.investigatetime as investigatetime , \n");   // 调查时间
		sql.append("       cri.name_pat as name_pat , \n");   // 姓名
		sql.append("       cri.name_sex as name_sex , \n");   // 性别
		sql.append("       cri.workage as workage , \n");   // 工龄
		sql.append("       cri.occurrence_time  , \n");   // 受伤时间
		sql.append("       cri.name_know_pat_info as name_know_pat_info , \n");   // 是否知道病人源情况名称
		sql.append("       cri.pat_instruction as pat_instruction , \n");   // 病人源说明
		sql.append("       cri.name_highrisk_situation as name_highrisk_situation , \n");   // 高危人群
		sql.append("       cri.higrisk_other_instr as higrisk_other_instr , \n");   // 高危其他说明
		sql.append("       cri.name_medication as name_medication , \n");   // HIV药物治疗名称
		sql.append("       cri.hiv_om_instr as hiv_om_instr , \n");   // HIV药物治疗其他说明
		sql.append("       cri.pat_other_instruction as pat_other_instruction , \n");   // 病人其他有关说明
		sql.append("       cri.name_doct_testdept as name_doct_testdept , \n");   // 医务工作者经过哪个部门检查名称
		sql.append("       cri.other_dept_inspection as other_dept_inspection , \n");   // 其他检查部门说明
		sql.append("       cri.name_doct_hepb as name_doct_hepb , \n");   // 暴露发生前医护工作者是否接种过乙肝疫苗名称
		sql.append("       cri.antilevel_af_vaccination as antilevel_af_vaccination , \n");   // 接种后抗体水平
		sql.append("       cri.inspection_date as inspection_date , \n");   // 检验日期
		sql.append("       cri.name_doct_pregnancy as name_doct_pregnancy , \n");   // 医务人员是否在妊娠期名称
		sql.append("       cri.name_doct_phase_pre as name_doct_phase_pre , \n");   // 在妊娠的哪三个月名称
		sql.append("       cri.other_instruction as other_instruction \n");   // 其他说明
		sql.append("       from ci_rcm_trackafexp cri\n");
		sql.append("       where " + sqlwhere + "" );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<TrackAfterExposureDTO> pagingRtnData = super.findByPageInfo(new TrackAfterExposureDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}

}
