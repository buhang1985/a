package iih.sc.apt.s.listener.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.out.i.ISc4CiCmdService;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;

public class OpLisRisRefundNewBP {
	private static String COMMA_STR = ",";
	private static String types = "02,03,04";
	public void exec(Hashtable<String, List<OpRefund4IpEsDTO>> hashtable)throws BizException{
		List<OpRefund4IpEsDTO> refundsIpEs = this.fireSelfDefineMessage(types, hashtable);
		if(ScAppUtils.isEmpty(refundsIpEs)) return;
		List<String> idorList = this.getIdOrs(refundsIpEs);
//		String cond = ScSqlUtils.getInSqlByIds("appl.id_or", idorList);
		if(!ListUtil.isEmpty(idorList)){
//			// 取消收费标识,并返回需退约的申请单Id
//			String idApts = this.updScAptFgBl(cond);
//			if(StringUtils.isEmpty(idApts)){
//				return;
//			}
//			// 获取已经预约的记录
//			MtAppDTO[] scAptRec = this.getAllScAptRec(idApts);
//			// 退约
//			this.cancleMtApt(scAptRec);
			// 门诊退费，调用撤销申请单接口
			ISc4CiCmdService isc4cicmdservice = ServiceFinder.find(ISc4CiCmdService.class);
			for (String id_or : idorList) {
				isc4cicmdservice.cancScAptAppl(id_or, Context.get().getUserId(), ScAppUtils.getServerDateTime(), ICiDictCodeConst.SD_SU_CANCEL);
			}
			// 队列设置无效
			this.updEnEntQueFgActive(ScSqlUtils.getInSqlByIds("id_ord", idorList));
		}
	}
	
	/**
	 * 更新收费标识
	 * @param cond
	 * @throws BizException 
	 */
	private String updScAptFgBl(String cond) throws BizException {
		// 更新申请单明细表收费标识
		this.updateAptItmFgBl(cond);
		// 更新申请单表收费标识
		return this.updScAptApplFgBl(cond);
	}
	
	/**
	 * 更新申请单明细表收费标识
	 * @param cond
	 * @throws DAException 
	 */
	private void updateAptItmFgBl(String cond) throws DAException {
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_apt_appl_itm appl set fg_bl ='N' where  ")
		.append(cond);
		dafacade.execUpdate(sql.toString());
	}

	/**
	 * 根据id_or 更新预约申请单fg_bl标识
	 * @param cond
	 * @throws DAException 
	 */
//	private void updScAptApplFgBl(String cond) throws DAException{
//		DAFacade dafacade = new DAFacade();
//		StringBuffer sql = new StringBuffer();
//		sql.append("update sc_apt_appl appl set fg_bl ='N' ,fg_canc='Y' where  ")
//		.append(cond);
//		dafacade.execUpdate(sql.toString());
//	}
	
	/**
	 * 根据id_or 更新预约申请单fg_bl标识
	 * @param cond
	 * @throws DAException 
	 */
	private String updScAptApplFgBl(String cond) throws BizException{
		// 获取预约申请单id
		HashSet<String> idAppls = this.getIdAptAppl(cond);
		if(idAppls == null){
			return null;
		}
		// 获取需重置收费标识的申请单id
		List<String> usedId = new ArrayList<String>();
		for (String idAppl : idAppls) {
			Boolean fg_bl = getScAptApplFgBl(idAppl);
			if(!fg_bl){
				usedId.add(idAppl);
			}
		}
		if(ListUtil.isEmpty(usedId)){
			return null;
		}
		// 更改申请单fg_bl标识
		String inSql = ScSqlUtils.getInSqlByIds("appl.id_aptappl", usedId);
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_apt_appl appl set fg_bl ='N' ,fg_canc='Y' where  ")
		.append(inSql);
		dafacade.execUpdate(sql.toString());
		return inSql;
	}
	
	/**
	 * 根据医嘱列表fg_bl判断申请单fg_bl标识（医嘱fg_bl全为true则申请单fg_bl为true）
	 *
	 * @param List<String>
	 * @throws BizException
	 * @author yu.b
	 */
	private Boolean getScAptApplFgBl(String idAppl) throws BizException{
		IScAptApplItmDORService service = ServiceFinder.find(IScAptApplItmDORService.class);
		ScAptApplItmDO[] dos = service.findByAttrValString("Id_aptappl", idAppl);
		Boolean fg_bl = true;
		if (dos != null) {
			for(ScAptApplItmDO scAptApplItmDO : dos){
				fg_bl = fg_bl && scAptApplItmDO.getFg_bl().booleanValue();
			}
			return fg_bl;
		} 
		return false;
	}
	
	/**
	 * 获取预约申请单id
	 * @param cond
	 * @return
	 * @throws DAException 
	 */
	private HashSet getIdAptAppl(String cond) throws DAException {
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("select id_aptappl from sc_apt_appl_itm appl where ")
		.append(cond);
		@SuppressWarnings("unchecked")
		List<String> appls = (List<String>) dafacade.execQuery(sql.toString(), new ColumnListHandler("id_aptappl"));
		if(ListUtil.isEmpty(appls)){
			return null;
		}
		return new HashSet<String>(appls);
	}
	
	/**
	 * 获得医嘱id_or，以，隔开
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private List<String> getIdOrs(List<OpRefund4IpEsDTO> refund4IpEsDTOs) {
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
		.append(" left join sc_apt apt on appl.id_scapt=apt.id_apt and apt.fg_canc='N'")
		.append(" left join sc_apt_mt mt on mt.id_aptappl=appl.id_aptappl")
		.append(" where  appl.sd_sctp in ('03','04') and appl.fg_canc='N'")
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
	
	/**
	 * 发送自定义消息(退费) 只适用单个或者多个类型合并
	 * @param types
	 * @param hashtable
	 * @param sourceId
	 * @param eventType
	 * @throws BizException
	 */
	private List<OpRefund4IpEsDTO> fireSelfDefineMessage(String types,Hashtable<String, List<OpRefund4IpEsDTO>> hashtable) throws BizException{
		if(ScAppUtils.isEmpty(types)||ScAppUtils.isEmpty(hashtable)) {
			return null;
		}
		List<OpRefund4IpEsDTO> allDtos=new ArrayList<OpRefund4IpEsDTO>();
		String[] typesArr=types.split(COMMA_STR);
		for(String type:typesArr) {
			List<OpRefund4IpEsDTO> everyDtos=hashtable.get(type);
			if(!ScAppUtils.isEmpty(everyDtos)) {
				allDtos.addAll(everyDtos);
			}
		}
		if(ScAppUtils.isEmpty(allDtos)){
			return null;
		}
		return allDtos;
	}
}
