package iih.ei.sc.s.bp.qry;

import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.GetAptApplyBean;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetAptApplyBP {
	/**
	 * 根据患者编码获取患者未预约的医技申请单
	 * @param code_apt
	 * @return
	 * @throws BizException
	 */
	public GetAptApplyBean[] exec(String code_apt) throws BizException {
		return this.getAptApply(code_apt);
	}
	/**
	 * 根据患者编码查询患者医技未预约申请单
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	private GetAptApplyBean[] getAptApply(String code_pat) throws BizException{
		FDateTime now = this.getServerDateTime();
		FDateTime date_param = new FDateTime(now.getBeginDate(), new FTime("00:00:00"));
		StringBuffer sql = new StringBuffer();
		sql.append(" select")
		.append(" appl.id_aptappl, appl.id_org, appl.sd_sctp, appl.id_scca,")
		.append(" appl.code, appl.name, appl.applyno, appl.des,")
		.append(" appl.id_pi, appl.piname, appl.sd_sex, appl.d_pi,")
		.append(" appl.pimobile, appl.code_entp, appl.id_ent, appl.id_or,")
		.append(" appl.content_or, appl.priority, appl.d_b, appl.d_e,")
		.append(" appl.id_dayslot as id_dateslot,")
		.append(" appl.id_scsrv, appl.id_scres, appl.id_dep_appl,")
		.append(" appl.id_emp_appl, appl.id_dep_mp, appl.dt_appl,")
		.append(" appl.fg_comfirm as fg_confirm,")
		.append(" appl.id_scapt, appl.fg_canc, appl.id_emp_canc,")
		.append(" appl.dt_canc, appl.fg_urgent, appl.eu_aptmd, appl.dt_effe_or,")
		.append(" appl.id_srv")
		.append(" from sc_apt_appl appl")
		.append(" left join pi_pat pat on appl.id_pi=pat.id_pat")
		.append(" where pat.code = ? and appl.fg_canc= 'N' and appl.sd_sctp =? and appl.dt_effe_or >= ?");
		SqlParam param = new SqlParam();
		param.addParam(code_pat);
		param.addParam(IScDictCodeConst.SD_SCTP_MT);
		param.addParam(date_param);
		List<GetAptApplyBean> result = (List<GetAptApplyBean>)new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(GetAptApplyBean.class));
		return result.toArray(new GetAptApplyBean[0]);
	}
	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	private FDateTime getServerDateTime() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return ts.getUFDateTime();
	}
}
