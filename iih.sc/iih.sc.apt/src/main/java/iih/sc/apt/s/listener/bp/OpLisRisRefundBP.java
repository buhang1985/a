package iih.sc.apt.s.listener.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class OpLisRisRefundBP {

	public void exec(OpRefund4IpEsDTO[] refundsIpEs)throws BizException{
		List<String> idorList = this.getIdOrs(refundsIpEs);
		String cond = ScSqlUtils.getInSqlByIds("appl.id_or", idorList);
		if(!ListUtil.isEmpty(idorList)){
			// 获取已经预约的记录
			MtAppDTO[] scAptRec = this.getAllScAptRec(cond);
			// 取消收费标识
			this.updScAptApplFgBl(cond);
			// 退约
			this.cancleMtApt(scAptRec);
			// 队列设置无效
			this.updEnEntQueFgActive(ScSqlUtils.getInSqlByIds("id_ord", idorList));
		}
	}
	/**
	 * 根据id_or 更新预约申请单fg_bl标识
	 * @param cond
	 * @throws DAException 
	 */
	private void updScAptApplFgBl(String cond) throws DAException{
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_apt_appl appl set fg_bl ='N' ,fg_canc='Y' where ")
		.append(cond);
		dafacade.execUpdate(sql.toString());
	}
	/**
	 * 获得医嘱id_or，以，隔开
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private List<String> getIdOrs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		List<String> idorList = new ArrayList<String>();
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idorList.add(es.getId_or());
		}
		return idorList;
	}
	/**
	 * 获取预约未确认的预约记录
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 * @throws DAException
	 */
	private MtAppDTO[] getAllScAptRec(String cond) throws DAException{
		String sql = this.getSql(cond);
		DAFacade dafacade = new DAFacade();
		List<MtAppDTO> result = (List<MtAppDTO>) dafacade.execQuery(sql, new BeanListHandler(MtAppDTO.class));
		return result.toArray(new MtAppDTO[0]);
	}
	/**
	 * 预约未确认sql
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 */
	private String getSql(String cond){
		StringBuffer qry = new StringBuffer();
		qry.append(" select appl.sd_aptmd,appl.id_pi as id_pat,appl.id_ent,appl.id_or,appl.id_aptappl as id_apt_appl,appl.dt_effe_or,appl.id_dep_mp,apt.dt_b as dt_appt,apt.id_apt ")
		.append(" from sc_apt_appl appl")
		.append(" inner join sc_apt_mt mt on mt.id_aptappl=appl.id_aptappl")
		.append(" inner join sc_apt apt on mt.id_apt=apt.id_apt and apt.fg_canc='N'")
		.append(" where  appl.sd_sctp = '03' and appl.fg_canc='N'")
		.append(" and ").append(cond);
		return qry.toString();
	}
	
	/**
	 * 医技退约
	 * @author yzh
	 * @param scAptRec
	 */
	private void cancleMtApt(MtAppDTO[] scAptRec){
		IScAptCmdService iscaptcmdservice = ServiceFinder.find(IScAptCmdService.class);
		if(!ArrayUtil.isEmpty(scAptRec)){
			for (MtAppDTO mtAppDTO : scAptRec) {
				if(mtAppDTO.getDt_effe_or() == null){
					continue;
				}
				try {
					//退费引起的退约 自动确认标识默认为true —— 预约已确认则先取消确认再退约
					mtAppDTO.setFg_auto_cfm(FBoolean.TRUE);
					iscaptcmdservice.cancelMtApt(mtAppDTO);
				} catch (Exception e) {
					ScLogUtil.getInstance().logError("时间:"+ScAppUtils.getServerDateTime()+"医嘱id_or:"+mtAppDTO.getId_or()+"退约失败,原因:"+e.getMessage());
				}
			}
		}
	}
	
	/**
	 * 根据id_or 更新就诊队列fg_active标识
	 * @param cond
	 * @throws DAException 
	 */
	private void updEnEntQueFgActive(String cond) throws DAException{
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update en_ent_que set fg_active ='N' where ")
		.append(cond);
		dafacade.execUpdate(sql.toString());
	}
}
