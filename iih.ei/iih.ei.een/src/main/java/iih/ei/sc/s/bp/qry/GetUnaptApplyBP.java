package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.common.ScParamUtils;
import iih.ei.sc.ws.bean.GetUnaptApplyBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUnaptApplyBP {
	/**
	 * 根据患者编码获取患者未预约的医技申请单
	 * @param code_apt
	 * @return
	 * @throws BizException
	 */
	public GetUnaptApplyBean[] exec(String code_apt) throws BizException {
		return this.getUnaptApply(code_apt);
	}
	/**
	 * 根据患者编码查询患者医技未预约申请单
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	private GetUnaptApplyBean[] getUnaptApply(String code_pat) throws BizException{
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
		.append(" appl.dt_canc, appl.fg_urgent, appl.eu_aptmd, appl.dt_effe_or,appl.id_srv,appl.fg_bl,")
		.append(" bdsrv.fg_needcfm,srv.name as applSrvName")
		.append(" from sc_apt_appl appl")
		.append(" left join pi_pat pat on appl.id_pi=pat.id_pat")
		.append(" left outer join sc_bdsrv bdsrv on appl.id_srv = bdsrv.id_srv")
		.append(" left outer join bd_srv srv on srv.id_srv=appl.id_srv")
		.append(" where pat.code = ? and appl.fg_canc= 'N' and appl.sd_sctp =? and appl.fg_comfirm='N'")
		.append(" and appl.fg_reg_arv='N' and appl.fg_canc_exec = 'N'");
		SqlParam param = new SqlParam();
		param.addParam(code_pat);
		param.addParam(IScDictCodeConst.SD_SCTP_MT);
		List<GetUnaptApplyBean> appList = (List<GetUnaptApplyBean>)new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(GetUnaptApplyBean.class));
		List<GetUnaptApplyBean> result = new ArrayList<GetUnaptApplyBean>();
   	 if(!ListUtil.isEmpty(appList)){
   		 
   		 for (GetUnaptApplyBean mtAppDTO : appList) {
				boolean isCheckFee = ScParamUtils.getScAptMtChkFee(mtAppDTO.getId_dep_mp());
				if(mtAppDTO.getFg_needcfm() == null) mtAppDTO.setFg_needcfm(FBoolean.FALSE.toString());
				if (isCheckFee) {
					if(FBoolean.TRUE.toString().equals(mtAppDTO.getFg_needcfm())){
						result.add(mtAppDTO);
					}else if(!FBoolean.TRUE.toString().equals(mtAppDTO.getFg_needcfm()) && mtAppDTO.getFg_bl()!=null && FBoolean.TRUE.toString().equals(mtAppDTO.getFg_bl())){
						result.add(mtAppDTO);
					}
				}else{
					result.add(mtAppDTO);
				}
				
			}
   		 return (GetUnaptApplyBean[]) result.toArray(new GetUnaptApplyBean[result.size()]);
   	 }
		return null;
	}
}
