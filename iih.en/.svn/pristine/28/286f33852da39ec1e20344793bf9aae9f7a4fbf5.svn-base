package iih.en.pv.s.bp.ip.ws;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.bp.ip.ws.bean.ScAptByPatParamBean;
import iih.en.pv.s.bp.ip.ws.bean.ScAptByPatResult;
import iih.en.pv.s.bp.ip.ws.bean.ScAptByPatResultBean;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 获取入院许可证
 * @author zhangpp
 *
 */
public class GetScAptByPatBP {

	/**
	 * 获取入院许可证
	 * @param param
	 * @return
	 */
	public String exec(String param)  {
		ScAptByPatResultBean resultBean = new ScAptByPatResultBean();
        try {
            final ScAptByPatParamBean params = WsXmlUtils.deSerializeBaseDO(param, ScAptByPatParamBean.class);
            //校验入参
    		this.checkParam(params);
    		//获取住院病人信息
    		ScAptByPatResult[] results = this.getInpatientInfo(params);
            resultBean.setData(results);
        } catch (BizException e) {
            BaseWsResult resultBeanErr = new BaseWsResult();
            resultBeanErr.setException(e);
            return WsXmlUtils.serialize(resultBeanErr);
        }
        return WsXmlUtils.serialize(resultBean);
    }
    
	/**
	 * 校验入参
	 * @param param
	 * @throws BizException
	 */
	private void checkParam(ScAptByPatParamBean params) throws BizException {
		if (EnValidator.isEmpty(params.getPatCode())) {
			throw new BizException("患者编码不允许为空");
		}
	}
	
	/**
	 * 获取住院病人信息
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private ScAptByPatResult[] getInpatientInfo(ScAptByPatParamBean params) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sb.append(" select ");
		sb.append(" aptip.id_aptip as id_aptip, ");
		sb.append(" ent.id_ent as id_ent, ");
		sb.append(" ip.id_inpatient as id_entip, ");
		sb.append(" pat.id_pat as id_pat, ");
		sb.append(" pat.name as name_pat, ");
		sb.append(" pat.sd_sex as sd_sex_pat, ");
		sb.append(" pat.dt_birth as dt_birth_pat, ");
		sb.append(" aptip.id_hp as id_hp, ");
		sb.append(" aptip.code_hp as code_hp, ");
		sb.append(" aptip.id_dep_op as id_dep_op, ");
		sb.append(" enbddep.code as code_dep_op, ");
		sb.append(" aptip.name_dep_op as name_dep_op, ");
		sb.append(" aptip.id_emp_phy_op as id_emp_phy_op, ");
		sb.append(" psn1.code as code_emp_phy_op, ");
		sb.append(" aptip.name_emp_phy_op as name_emp_phy_op, ");
		sb.append(" aptip.id_didef_op as id_didef_op, ");
		sb.append(" cidiitm.id_didef_code as code_didef_op, ");
		sb.append(" aptip.name_didef_op as name_didef_op, ");
		sb.append(" aptip.supplement_di as supplement_di, ");
		sb.append(" aptip.sd_level_dise as sd_level_dise, ");
		sb.append(" patca.id_patca as id_patca, ");
		sb.append(" patca.code as code_patca, ");
		sb.append(" dep1.code as code_dep_phy_ip, ");
		sb.append(" dep2.code as code_dep_nur_ip, ");
		sb.append(" aptip.fg_plan as fg_plan, ");
		sb.append(" aptip.sd_bedtype as sd_bedtype, ");
		sb.append(" aptip.dt_admit_plan as dt_admit_plan, ");
		sb.append(" aptip.amt_deposit as amt_deposit, ");
		sb.append(" aptip.note as note, ");
		sb.append(" aptip.fg_emgstay as fg_emgstay, ");
		sb.append(" aptip.id_bed as id_bed, ");
		sb.append(" aptip.dt_valid as dt_valid, ");
		sb.append(" aptip.level_pri as level_pri, ");
		sb.append(" aptip.level_pri_rsn as level_pri_rsn, ");
		sb.append(" aptip.dt_insert as dt_insert, ");
		sb.append(" aptip.id_emp_appt as id_emp_appt, ");
		sb.append(" psn2.code as code_emp_appt, ");
		sb.append(" aptip.dt_appt as dt_appt, ");
		sb.append(" '' as note_appt, ");
		sb.append(" aptip.id_emp_cfm as id_emp_cfm, ");
		sb.append(" aptip.dt_cfm as dt_cfm, ");
		sb.append(" aptip.rsn_refuse as rsn_refuse, ");
		sb.append(" aptip.id_emp_notice as id_emp_notice, ");
		sb.append(" aptip.name_emp_notice as name_emp_notice, ");
		sb.append(" aptip.da_notice as dt_notice, ");
		sb.append(" aptip.fg_manual as fg_manual, ");
		sb.append(" aptip.sd_status as sd_status, ");
		sb.append(" aptip.fg_vip as fg_vip, ");
		sb.append(" aptip.sd_referalsrc as sd_referalsrc, ");
		sb.append(" aptip.name_cont_phy as name_cont_phy, ");
		sb.append(" aptip.tel_cont_phy as tel_cont_phy, ");
		sb.append(" aptip.note_apt as note_apt, ");
		sb.append(" aptip.sd_walkwith as sd_walkwith, ");
		sb.append(" aptip.id_patcont as id_patcont, ");
		sb.append(" ent.sv as update_time, ");//更新时间
		sb.append(" 'N' as fg_preip ");
		sb.append(" from ");
		sb.append(" sc_apt_ip aptip ");
		sb.append(" inner join en_ent ent on aptip.id_ent = ent.id_ent ");
		sb.append(" inner join pi_pat pat on ent.id_pat = pat.id_pat ");
		sb.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		sb.append(" and aptip.dt_valid >= '' and aptip.fg_emgstay = 'N' ");
		sb.append(" left join pi_pat_ca patca on patca.id_patca = aptip.id_patca ");
		sb.append(" left join bd_dep dep1 on dep1.id_dep = aptip.id_dep_phy_ip ");
		sb.append(" left join bd_dep dep2 on dep2.id_dep = aptip.id_dep_nur_ip ");
		sb.append(" left join bd_psndoc psn1 on psn1.id_psndoc = aptip.id_emp_phy_op ");
		sb.append(" left join bd_psndoc psn2 on psn2.id_psndoc = aptip.id_emp_appt ");
		sb.append(" left join bd_dep enbddep on enbddep.id_dep = aptip.id_dep_op ");
		sb.append(" left join en_ent_di endi on endi.id_ent = ent.id_ent ");
		sb.append(" left join ci_di_itm cidiitm on cidiitm.id_diitm = endi.id_diitm ");
		sb.append(" where ");
		sb.append(" aptip.fg_canc = 'N' and aptip.dt_valid >= ? ");
		sb.append(" and aptip.fg_emgstay = 'N' ");
		sqlParam.addParam(EnAppUtils.getServerDateTime());
		//判断是否为合并患者，如果是获取所有的申请单
		IPatiMDORService iService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = iService.findByAttrValString("Id_person", params.getPatCode());
		if (patDOs == null || patDOs.length <= 0) {
			sb.append(" and pat.code = ? ");
			//住院患者唯一ID
			sqlParam.addParam(params.getPatCode());
		}else{
			List<String> codeList = new ArrayList<String>();
			for (PatDO patDO : patDOs) {
				if (codeList.contains(patDO.getCode())) {
					continue;
				}
				codeList.add(patDO.getCode());
			}
			String strParam = EnSqlUtils.getInSqlByIds("pat.code", codeList);
			if (strParam != null) {
				sb.append(" and " + strParam + " ");
			}
		}

		List<ScAptByPatResult> list = (List<ScAptByPatResult>) new DAFacade().execQuery(sb.toString(), sqlParam, new BeanListHandler(ScAptByPatResult.class));
		
		return list.toArray(new ScAptByPatResult[0]);
	} 
}
