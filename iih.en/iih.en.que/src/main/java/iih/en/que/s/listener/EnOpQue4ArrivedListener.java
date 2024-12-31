package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ScripRulConst;
import iih.en.comm.ep.BdQueBenEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 分诊台签到、取消签到事件
 * @author fanlq
 * @date: 2019年9月5日 下午6:42:56
 */
public class EnOpQue4ArrivedListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType()); 
		//1、验证事件，是否匹配
		if(!this.validate(event)) return;
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpQue4EsDTO eventSourceDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		//3.发送上屏消息
		EnLogUtil.getInstance().logInfo("门诊大屏到诊/取消到诊调用：");
		try{
			EnBrdSiteDO[] enBrdSiteDOs = this.setBrdSiteInfo(eventSourceDTO);
			new SendBrdMsgBP().sendSiteMsg(enBrdSiteDOs);
		}catch(Exception e){
			EnLogUtil.getInstance().logError("门诊大屏到诊/取消到诊上屏出错！"+e + "；出错事件："+event.getEventType());
		}
	}
	/***
	 * @Description:组装上屏数据
	 * @param eventSourceDTO
	 * @param event
	 * @return
	 * @throws BizException 
	 */
	private EnBrdSiteDO[] setBrdSiteInfo(OpQue4EsDTO opQue4EsDTO) throws BizException{
		EnLogUtil enLog = EnLogUtil.getInstance();
		if(EnValidator.isEmpty(opQue4EsDTO.getId_ent())){
			enLog.logInfo("门诊大屏到诊/取消到诊就诊id为空：");
			return null;
		}
		QueBenDO queBenDO = new BdQueBenEP().getQueBenByEntId(opQue4EsDTO.getId_ent());
		if(queBenDO == null){
			enLog.logInfo("门诊大屏到诊/取消到诊获取就诊队列的工作台为空，就诊id为："+opQue4EsDTO.getId_ent());
			return null;
		}
		//到诊患者数组,放到了大屏站点do中
		EnBrdSiteDO[] enBrdSiteDOs = this.getArrivedPatinfos(queBenDO.getId_queben(), opQue4EsDTO.getCode_entp());
		//组装到诊患者数据
		String nosArrived = this.getNosArrived(enBrdSiteDOs);
		//修改并保存大屏站点数据
		EnBrdSiteDO[] enBrdSites = this.getEnBrdSiteDo(queBenDO.getAddr_board(), nosArrived);
		enLog.logInfo("门诊大屏到诊/取消到诊数据组装结果："+enBrdSites);
		return enBrdSites;
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_QUE.equalsIgnoreCase(event.getSourceID())
				|| (!IEnEventConst.EVENT_EN_OP_SIGNIN.equals(event.getEventType())
				&& !IEnEventConst.EVENT_EN_OP_CANC_SIGNIN.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

	/**
	 * 获取到诊患者信息
	 * @param brdSiteDO
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @throws BizException
	 */
	private EnBrdSiteDO[] getArrivedPatinfos(String id_queben, String codeEnTp) throws BizException{
		DaysLotDO dayslot = this.getCurDaysLot(codeEnTp);
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select pat.code as Code_pat,pat.name as Name_curpat ");
		sql.append("from en_ent_que enque " );
		sql.append("inner join en_ent ent on ent.id_ent = enque.id_ent ");
		sql.append("inner join bd_que que on que.id_que = enque.id_que " );
		sql.append("inner join pi_pat pat on pat.id_pat = enque.id_pat " );
		sql.append("where enque.sd_entque_tp = ? " );
		sql.append("and enque.sd_status_acpt = ? " );
		sql.append("and enque.dt_regist = ? " );
		sql.append("and enque.id_dateslot = ? " );
		sql.append("and enque.id_que_site is null ");
		sql.append("and que.id_queben = ? " );
		sql.append("and ent.fg_canc = 'N' ");
		sql.append("order by enque.dt_in ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(new FDate(dayslot.getDef1()));
		param.addParam(dayslot.getId_dayslot());
		param.addParam(id_queben);
		@SuppressWarnings("unchecked")
		List<EnBrdSiteDO> list = (List<EnBrdSiteDO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(EnBrdSiteDO.class));
		return list != null && list.size() > 0 ? list.toArray(new EnBrdSiteDO[0]) : null;
	}
	/***
	 * @Description:获取到诊数据
	 * @param enBrdSiteDOs
	 * @return
	 * @throws BizException 
	 */
	private String getNosArrived(EnBrdSiteDO[] enBrdSiteDOs) throws BizException{
		List<String> nosArrivedList = new ArrayList<String>();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		FMap map = new FMap();
		if(EnValidator.isEmpty(enBrdSiteDOs)){
			return null;
		}
		for(EnBrdSiteDO enbrd : enBrdSiteDOs){
			if(!EnValidator.isEmpty(enbrd.getCode_pat()) && !EnValidator.isEmpty(enbrd.getName_curpat()) && !map.containsKey(enbrd.getCode_pat())){
				map.put(enbrd.getCode_pat(), enbrd.getName_curpat());
				//调用脚本设计器显示患者姓名
				String arrived_name_pat = enbrd.getName_curpat();
				arrived_name_pat = bp.exec(arrived_name_pat,ScripRulConst.BRD_OP_SHOW_NAME,ScripRulConst.ARRIVEDPAT);
				nosArrivedList.add(arrived_name_pat);
			}
		}
		String nosArrived = nosArrivedList.toString();
		if(!EnValidator.isEmpty(nosArrived)){
			nosArrived = nosArrived.replace("[", "").replace("]", "").replace(" ", "");
			if(nosArrived.length() > 2800){
				nosArrived = nosArrived.substring(0, 2800);
			}
		}
		return nosArrived;
	}
	/**
	 * 获取当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot(String codeEnTp) throws BizException{
		String codeScTp = null;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(codeEnTp) || 
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(codeEnTp) || 
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(codeEnTp) ||
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEnTp)) {
			codeScTp = IScDictCodeConst.SD_SCTP_JZ;
		}else{
			codeScTp = IScDictCodeConst.SD_SCTP_OP;
		}
		IScDaysLotService scDayslotServ = ServiceFinder.find(IScDaysLotService.class);
		return scDayslotServ.getNowDaysLotCross(codeScTp, FBoolean.TRUE);
	}
	/**
	 * 修改并保存大屏站点数据
	 * @param addrBoard
	 * @param nosArrived
	 * @return
	 */
	private EnBrdSiteDO[] getEnBrdSiteDo(String addrBoard, String nosArrived){
		if (EnValidator.isEmpty(addrBoard)) {
			return null;
		}
		try {
			EnBrdEP ep = new EnBrdEP();
			EnBrdSiteDO[] enBrdSiteDOs = ep.findByAddr(addrBoard);
			if (enBrdSiteDOs != null && enBrdSiteDOs.length > 0) {
				for (EnBrdSiteDO enBrdSiteDO : enBrdSiteDOs) {
					if (!BrdStatusEnum.DEL.equals(enBrdSiteDO.getEu_status())) {
						enBrdSiteDO.setEu_status(BrdStatusEnum.UPDATE);
					}
					enBrdSiteDO.setStatus(DOStatus.UPDATED);
					enBrdSiteDO.setNos_arrived(nosArrived);
					enBrdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
				}
				return ep.save(enBrdSiteDOs);
			}else{
				EnBrdSiteDO enBrdSiteDO = new EnBrdSiteDO();
				enBrdSiteDO.setStatus(DOStatus.NEW);
				enBrdSiteDO.setId_grp(EnContextUtils.getGrpId());
				enBrdSiteDO.setId_org(EnContextUtils.getOrgId());
				enBrdSiteDO.setAddr_brd(addrBoard);
				enBrdSiteDO.setNos_arrived(nosArrived);
				enBrdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
				enBrdSiteDO.setEu_status(BrdStatusEnum.ADD);
				return ep.save(new EnBrdSiteDO[]{enBrdSiteDO});
			}
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("修改显示屏站点表出错：", e);
		}
		return null;
	}
}
