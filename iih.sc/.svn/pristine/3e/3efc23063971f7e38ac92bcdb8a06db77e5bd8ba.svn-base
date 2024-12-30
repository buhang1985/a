package iih.sc.scp.s.task.bp;

import iih.bd.base.utils.SqlUtils;
import iih.sc.apt.dto.d.MtApt4SmsDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSmsMsgUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.IScSmsConst;
import iih.sc.pub.ResultBean;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技预约提前一天短信通知BP
 * @author yzh
 * @date 2018年10月31日 14:30:24
 * @throws BizException
 */
public class MtAptNoticeTimerBP {

	/**
	 * 医技预约提前一天短信通知BP
	 * @author yzh
	 * @date 2018年10月31日 14:30:24
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		String id_dep_mp = (String) map.get("id_dep");
		this.mainTaskProcess(id_dep_mp);
	}
	/**
	 * 主业务处理
	 * @param releaseSchs
	 * @param releaseRuleItmMap
	 * @exception Bizexception
	 */
	@SuppressWarnings("unchecked")
	private void mainTaskProcess(String id_dep_mp)throws BizException{
		// 获取需要发送短信的记录
		MtApt4SmsDTO[] recs = this.getMtAptRecs(id_dep_mp);
		//2、调用发送短信服务
		IScAptOutCmdService icservice=ServiceFinder.find(IScAptOutCmdService.class);
		for (MtApt4SmsDTO rec : recs) {
			if(ScValidator.isEmptyIgnoreBlank(rec.getMobile())){
				continue;
			}
			ResultBean result = null;
			try{
				String msg = ScSmsMsgUtils.generateMsg(IScSmsConst.SC_MT_APT_SMS_NOTICE, rec);
				result = icservice.sendSmsMsg(rec.getMobile(), IScSmsConst.EN_OP_APT_CFM_MSG_TEMPLATE,msg);
				//保存短信发送结果
				//bp.saveSendedMsgData(!StringUtil.isEmpty(opApt4SmsDTO.getId_ent())  ? opApt4SmsDTO.getId_ent():opApt4SmsDTO.getId_apt(),IScSmsConst.EN_OP_APT_CFM_MSG_TEMPLATE, result);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查询需要发送短信的记录
	 * @param id_dep_mp
	 * @return
	 * @throws DAException 
	 */
	private MtApt4SmsDTO[] getMtAptRecs(String id_dep_mp) throws DAException{
		String cond = "";
		if (!StringUtil.isEmpty(id_dep_mp)) {
			cond = SqlUtils.getInSqlByIdsSplit(id_dep_mp);
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" select apt.dt_b as D_apt, dep.name as Name_dep, pat.mob as Mobile")
		.append(" from sc_apt apt")
		.append(" inner join sc_apt_mt mt on apt.id_apt = mt.id_apt")
		.append(" inner join bd_dep dep on mt.id_dep_mp = dep.id_dep")
		.append(" inner join pi_pat pat on apt.id_pat = pat.id_pat")
		.append(" where apt.dt_b >= ? and apt.dt_b < ?")
		.append(" and mt.id_dep_mp ").append(cond)
		.append(" and apt.sd_status in (1, 2)");
		FDate now = ScAppUtils.getServerDate().asBegin();
		FDateTime beginDate = new FDateTime(now.getDateAfter(1), new FTime("00:00:00")) ;
		FDateTime endDate = new FDateTime(now.getDateAfter(1), new FTime("23:59:59")) ;
		SqlParam param = new SqlParam();
		param.addParam(beginDate);
		param.addParam(endDate);
		List<MtApt4SmsDTO> list = (List<MtApt4SmsDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MtApt4SmsDTO.class));
		return list.toArray(new MtApt4SmsDTO[0]);
	}
}
