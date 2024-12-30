package iih.sc.apt.s.bp.opt;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 手术排班资源已预约
 * 
 * @author zhengcm
 * @date 2018-02-26 15:26:20
 *
 */
public class GetOptResAptedBP {

	/**
	 * 手术排班资源已预约
	 * 
	 * @author zhengcm
	 *
	 * @param id_sch 排班
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] exec(String id_sch) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_sch", id_sch);
		// 查询数据
		List<MtAppDTO> appDTOList = this.queryDatas(id_sch);
		if (ListUtil.isEmpty(appDTOList)) {
			return null;
		}
		
		// 设置就诊数据和计算患者年龄
		this.calcPatAge(appDTOList);

		return appDTOList.toArray(new MtAppDTO[0]);
	}

	/**
	 * 计算患者年龄
	 *
	 * @param mtAppDTOList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void calcPatAge(List<MtAppDTO> mtAppDTOList) throws BizException {
		if (ListUtil.isEmpty(mtAppDTOList)) {
			return;
		}
		for (MtAppDTO mtDTO : mtAppDTOList) {
			if (mtDTO.getDt_birth_pat() != null) {
				mtDTO.setAge(AgeCalcUtil.getAge(mtDTO.getDt_birth_pat()));
			}
		}
	}
	
	/**
	 * 查询数据
	 *
	 * @param schId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtAppDTO> queryDatas(String schId) throws BizException {
		// 查询Sql语句
		StringBuilder sb = this.getSql();
		// 查询数据
		SqlParam params = new SqlParam();
		params.addParam(schId);
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(MtAppDTO.class));
		return appDTOList;
	}

	/**
	 * 查询Sql语句
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct ");
		sb.append(" ip.name_bed as  name_bed,");
		sb.append(" apt.queno as queno,");
		sb.append(" ent.id_entp id_entp,");
		sb.append(" ent.id_ent as id_ent,");
		sb.append(" pat.id_pat as id_pat,");
		sb.append(" pat.name as name_pat,");
		sb.append(" apt.sd_status as apt_status,");
		sb.append(" pat.dt_birth as dt_birth_pat,");
		sb.append(" pat.id_sex, ");
		sb.append(" sex.name as name_sex,");
		sb.append(" appl.fg_urgent, ");
		sb.append(" appl.id_dep_appl as id_dep_apply,");
		sb.append(" dep.name as name_dep_apply, ");
		sb.append(" psn.name as name_emp_apply, ");
		sb.append(" appl.id_or as id_or, ");
		sb.append(" appl.content_or  as content_or ,");
		sb.append(" appl.name  as name_or ,");
		sb.append(" apt.id_apt as id_apt,");
		sb.append(" apt.dt_b as dt_plan,");
		sb.append(" apt.id_sch,");
		sb.append(" appl.dt_effe_or,");
		sb.append(" pat.code_amr_ip as Inpatient_no,");
		sb.append(" surgical.name as name_surgical_site,");
		sb.append(" appl.id_aptappl as id_apt_appl,");
		sb.append(" appl.eu_aptmd as sd_aptmd,");
		sb.append(" anestp.name name_anestp,");
		sb.append(" decode(substr(appl.code_entp, '0', '2'),'00','门诊','01','急诊','10','住院','02','体检','20','家庭病床') as name_enttp");
		sb.append(" from ");
		sb.append(" sc_apt apt ");
		sb.append(" inner join sc_apt_opt opt on opt.id_apt = apt.id_apt  ");
		sb.append(" inner join pi_pat pat on pat.id_pat = apt.id_pat  ");
		sb.append(" inner join sc_apt_appl appl on appl.id_scapt = opt.id_apt  ");
		sb.append(" left join sc_apt_appl_opt applopt on applopt.id_aptappl = appl.id_aptappl ");
		sb.append(" left join en_ent ent on appl.id_ent = ent.id_ent  ");
		sb.append(" left join en_ent_ip ip on ip.id_ent = appl.id_ent");
		sb.append(" left join bd_dep dep on dep.id_dep = appl.id_dep_appl  ");
		sb.append(" left join bd_psndoc psn on psn.id_psndoc = appl.id_emp_appl  ");
		sb.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex  ");
		sb.append(" left join bd_udidoc surgical on surgical.id_udidoc = appl.id_surgical_site ");
		sb.append(" left join bd_udidoc anestp on anestp.id_udidoc = applopt.id_anestp ");
		sb.append(" where ");
		sb.append(" apt.fg_canc = 'N' ");
		sb.append(" and apt.id_sch = ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		sb.append(" order by apt.queno");
		return sb;
	}

}
