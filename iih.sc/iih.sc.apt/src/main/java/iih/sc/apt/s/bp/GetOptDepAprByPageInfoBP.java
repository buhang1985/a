package iih.sc.apt.s.bp;

import iih.sc.apt.opt.d.OptAptApplDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.util.AgeCalcUtil;

public class GetOptDepAprByPageInfoBP {

	/**
	 * 科室手术审批 列表查询
	 * @author yhl
	 * @param qryDTO
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<OptAptApplDTO> exec(OptAptApplDTO qryDTO, PaginationInfo pg) throws BizException{
		ScValidator.validateParam(null,"dt_apt","手术日期",qryDTO.getDt_apt());
		ScValidator.validateParam(null,"id_dep","当前部门", qryDTO.getId_dep());
		
		PagingServiceImpl<OptAptApplDTO> pageQryService = new PagingServiceImpl<OptAptApplDTO>();
		SqlParam param = new SqlParam();
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" opt.sortno_depphy, ");
		sql.append(" pat.name as name_pat,");
		sql.append(" appl.name as content_or,");
		sql.append(" depappl.name as name_dep_appl,");
		sql.append(" psnappl.name as name_emp_appl,");
		sql.append(" pat.dt_birth,");
		sql.append(" pat.id_sex,");
		sql.append(" docsex.name as name_sex,");
		sql.append(" ip.code_amr_ip as code_ip,");
		sql.append(" pat.code as code_pat,");
		sql.append(" depnur.id_dep as id_dep_nur,");
		sql.append(" depnur.name as name_dep_nur,");
		sql.append(" ip.name_bed,");
		sql.append(" res.name as name_res,");
		sql.append(" opt.id_emp_confirm_phy as id_emp_cfm,");
		sql.append(" psncfm.name as name_emp_cfm,");
		sql.append(" opt.dt_confirm_phy as dt_cfm,");
		sql.append(" opt.id_aptapplopt,");
		sql.append(" opt.fg_confirm_phy,");
		sql.append(" appl.fg_comfirm as fg_apt,");
		sql.append(" appl.id_or");
		sql.append(" from sc_apt_appl appl");
		sql.append(" inner join pi_pat pat on appl.id_pi = pat.id_pat");
		sql.append(" left join sc_apt_appl_opt opt on appl.id_aptappl = opt.id_aptappl");
		sql.append(" left join bd_dep depappl on appl.id_dep_appl = depappl.id_dep");
		sql.append(" left join bd_psndoc psnappl on appl.id_emp_appl = psnappl.id_psndoc");
		sql.append(" left join en_ent ent on appl.id_ent = ent.id_ent");
		sql.append(" left join en_ent_ip ip on appl.id_ent = ip.id_ent");
		sql.append(" left join bd_udidoc docsex on pat.id_sex  = docsex.id_udidoc");
		sql.append(" left join bd_dep depnur on ent.id_dep_nur = depnur.id_dep");
		sql.append(" left join sc_res res on appl.id_scres = res.id_scres");
		sql.append(" left join bd_psndoc psncfm on opt.id_emp_confirm_phy = psncfm.id_psndoc");
		sql.append(" where appl.ds = '0' and appl.fg_canc = 'N' and appl.sd_sctp = '04' and opt.fg_need_confirm = 'Y'");
		sql.append(" and appl.d_b = ?");
		sql.append(" and appl.id_dep_appl  = ?");
		param.addParam(qryDTO.getDt_apt());
		param.addParam(qryDTO.getId_dep());
		sql.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "appl"));
		PagingRtnData<OptAptApplDTO> datas = pageQryService.findByPageInfo(new OptAptApplDTO(), pg, sql.toString(),
				" appl.dt_appl", param);

		FArrayList pageData = datas.getPageData();
		if(pageData != null && pageData.size() >0 ){
			for (Object object : pageData) {
				OptAptApplDTO applDTO = (OptAptApplDTO)object;
				applDTO.setAge(AgeCalcUtil.getAge(applDTO.getDt_birth()));
				if(applDTO.getFg_apt().booleanValue()){
					applDTO.setName_status("已预约");
				}
				if(!applDTO.getFg_apt().booleanValue() && applDTO.getFg_confirm_phy()!= null && applDTO.getFg_confirm_phy().booleanValue()){
					applDTO.setName_status("已确认");
				}
				if(!applDTO.getFg_apt().booleanValue() && (applDTO.getFg_confirm_phy() == null || !applDTO.getFg_confirm_phy().booleanValue())){
					applDTO.setName_status("未确认");
				}
			}
			datas.setPageData(pageData);
		}
		return datas;
	}
}
