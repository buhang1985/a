package iih.ci.mrm.s.mrmresend;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cmis.i.ICMISSendService;
import iih.ci.mrm.dto.cimrmresendpatdto.d.CiMrmResendPATDTO;
import iih.ci.mrm.i.mrmresend.IMrmResendPatListRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrmResendPatListRService.class }, binding = Binding.JSONRPC)
public class IMrmResendPatListRServiceImpl extends PagingServiceImpl<CiMrmResendPATDTO>
		implements IMrmResendPatListRService {
	/**
	 * 病案重发节点-患者信息查询
	 */
	public PagingRtnData<CiMrmResendPATDTO> getCiMrmResendPATDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);

		StringBuilder sqlWhere = new StringBuilder();
		sqlWhere.append(" where dep.sd_depttp = '01' and amr.code_entp = '");// 临床科室
		sqlWhere.append(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 住院类型
		sqlWhere.append("' ");
		sqlWhere.append(" and amr.ds = '0' ");
		sqlWhere.append(" and ip.fg_newborn = 'N' ");// 过滤新生儿

		if (qryRootNodeDTO != null) {
			sqlWhere.append(" and ");
			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
		}
		// sqlWhere.append(" order by case when ci_mrm_sp.sv is null then 0 else 1 end desc ");
		// 调用sql方法
		StringBuilder sql = getQuerySQL(sqlWhere.toString());
		String sqlStr = sql.toString();

		PagingRtnData<CiMrmResendPATDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrmResendPATDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}

	private StringBuilder getQuerySQL(String sqlWhere) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ent.id_ent as id_ent, ");
		sb.append(" ent.id_pat as id_pat, ");
		sb.append(" pat.code as sd_pat, ");
		sb.append(" pat.name as name_pat, ");
		sb.append(" ent.id_org as id_org, ");
		sb.append(" amr.code_amr_ip as code_amr_ip, ");
		sb.append(" pat.dt_birth as dt_birth, ");
		sb.append(" ent.dt_acpt as dt_acpt, ");
		sb.append(" ent.dt_end as dt_end, ");
		sb.append(" pat.id_sex as id_sex, ");
		sb.append(" bu_sex.code as sd_sex, ");
		sb.append(" bu_sex.name as name_sex, ");
		sb.append(" ip.id_dep_phyadm as id_dep_phyadm, ");
		sb.append(" dep_in.code as sd_dep_phyadm, ");
		sb.append(" dep_in.name as name_dep_phyadm, ");
		sb.append(" ip.id_dep_phydisc as id_dep_phydisc, ");
		sb.append(" dep_out.code as sd_dep_phydisc, ");
		sb.append(" dep_out.name as name_dep_phydisc, ");
		sb.append(" ip.times_ip as times_inhos, ");
		sb.append(" case when amr.fg_complete = 'Y' then '是' else '否' end as fg_complete, ");
		sb.append(" cp.id_cimrfppat as id_cimrfppat ");
		sb.append(" from en_ent ent ");
		sb.append(" left join bd_dep dep on ent.id_dep_phy = dep.id_dep ");
		sb.append(" left join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sb.append(" left join ci_amr amr on ent.id_ent = amr.id_ent ");
		sb.append(" left join pi_pat pat on ent.id_pat = pat.id_pat ");
		sb.append(" left join bd_udidoc bu_sex on pat.id_sex = bu_sex.id_udidoc ");
		sb.append(" left join bd_dep dep_in on ip.id_dep_phyadm = dep_in.id_dep ");
		sb.append(" left join bd_dep dep_out on ip.id_dep_phydisc = dep_out.id_dep ");
		sb.append(" left join ci_mr_fp_pat cp on ent.id_ent = cp.id_ent ");
		sb.append(sqlWhere);

		return sb;
	}

	/**
	 * 推送病案信息
	 */
	public boolean sendMrmInfo(CiMrmResendPATDTO[] ciMrmResendPATDTOs) throws BizException {
		ICiamrRService ciamrRService = ServiceFinder.find(ICiamrRService.class);// 病案
		ICiamrCudService ciamrCudService = ServiceFinder.find(ICiamrCudService.class);// 病案
		ICMISSendService cmisService = ServiceFinder.find(ICMISSendService.class);
		
		if (ciMrmResendPATDTOs == null || ciMrmResendPATDTOs.length <= 0) {
			return false;
		}
		// 拼接id_ent，并查询病案信息
		String opIds = "(id_ent in ( '";
		int count = 0;
		for (CiMrmResendPATDTO ciMrmResendPATDTO : ciMrmResendPATDTOs) {
			count += 1;
			if (count == 900) {
				opIds += ciMrmResendPATDTO.getId_ent() + "') or id_ent in ( '";
				count = 0;
			} else
				opIds += ciMrmResendPATDTO.getId_ent() + "' ,'";
		}
		opIds = opIds.substring(0, opIds.length() - 2) + "))";
		AMrDO[] amrDOs = ciamrRService.find(opIds, null, FBoolean.FALSE);
		
		if (amrDOs == null || amrDOs.length <= 0) {
			return false;
		}
		// 推送数据
		boolean result = false;
		for (AMrDO amr : amrDOs) {
			String sendResult = "false";
			
			try {
				sendResult = cmisService.sendCMISMsg(amr.getId_ent());
			} catch (Exception e) {
				return false;
			}
			// 如果第三方保存上数据，才置为完成
			if (sendResult.contains("true")) 
			{
				amr.setFg_complete(FBoolean.TRUE);
				amr.setStatus(DOStatus.UPDATED);
				// 未修改完成状态的数据无需保存
				AMrDO[] amrDO = ciamrCudService.save(new AMrDO[]{ amr });
				
				if (amrDO != null && amrDO.length > 0) {
					result =  true;
				} else {
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * 推送门诊住院工作量
	 */
	public boolean sendWorkload(CiMrmResendPATDTO ciMrmResendPATDTO) throws BizException {
		ICMISSendService cmisService = ServiceFinder.find(ICMISSendService.class);
		
		if (ciMrmResendPATDTO == null) {
			return false;
		}
		List<FDate> dateList = new ArrayList<FDate>();
		FDate date_start = ciMrmResendPATDTO.getDate_start();
		FDate date_end = ciMrmResendPATDTO.getDate_end();
		
		if (date_start.getMillis() == date_end.getMillis()) {
			String result = cmisService.sendWorkload(date_start, date_start);
			String[] strs = result.split("/");
			
			if ("true".equals(strs[0]) && "true".equals(strs[1])) {
				return true;
			} else {
				return false;
			}
		} else if (date_start.getMillis() > date_end.getMillis()) {
			return false;
		} else {
			dateList.add(date_start);
			// 计算日期区间内的天数
			long dayMillis = 24*60*60*1000;
			int days = (int)((date_end.getMillis() - date_start.getMillis())/dayMillis);
			
			for (int i = 1; i <= days; i++) {
				FDate newDate = new FDate(date_start.getMillis() + (dayMillis * i));
				dateList.add(newDate);
			}
			// 推送工作量
			for (FDate fDate : dateList) {
				String result = cmisService.sendWorkload(fDate, fDate);
				
				String[] strs = result.split("/");
				
				if ("true".equals(strs[0]) && "true".equals(strs[1])) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
