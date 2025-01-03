package iih.en.que.s.event.bp;

import org.springframework.transaction.TransactionStatus;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BrdCallEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.BrdtpEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrddoMDORService;
import iih.en.que.board.i.IEnbrdsitedoCudService;
import iih.en.que.board.i.IEnbrdsitedoRService;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.listener.bp.WrapAllQueMsgInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

public class WrapObj2AllQue4EnBrdBP {

	/***
	 * 保存大屏站点信息
	 * 
	 * @author fanlq
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO[] setBrdSiteInfo(final AllQue4EsDTO allQue4EsDTO,final String eventType) throws BizException {
		
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<EnBrdSiteDO[]>() {
			@Override
			public EnBrdSiteDO[] doInTransaction(TransactionStatus arg0) {
				try {
					EnLogUtil logUtil =EnLogUtil.getInstance();
					if(EnValidator.isEmpty(allQue4EsDTO)){
						return null;
					}
					// 3.获取发送的大屏站点DO数据
					EnBrdSiteDO brdSiteDO = getEnBrdSiteInfo(allQue4EsDTO,eventType);
					logUtil.logInfo("站点消息： EnBrdSiteDO" + brdSiteDO);
					FDate today = EnAppUtils.getServerDate();
					boolean lock = PKLock.getInstance().addDynamicLock(brdSiteDO.getCode() + today.toStdtString(), 5 * 1000);
					// 2.保存大屏站点DO到数据库中
					EnBrdSiteDO[] rtns = new EnBrdEP().save(new EnBrdSiteDO[] { brdSiteDO });
					return  rtns;
				} catch (BizException e) {
					EnLogUtil.getInstance().logInfo("站点消息： EnBrdSiteDO" + e);
					return null;
				}
			}
		});
	}

	/***
	 * @Description:
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException 
	 */
	public EnBrdSiteDO[] save(AllQue4EsDTO allQue4EsDTO,EnBrdSiteDO brdSiteDO) throws BizException{
		if(StringUtils.isNullOrEmpty(allQue4EsDTO.getAddr_board_ben())){
			return null;
		}
		EnBrdEP ep = new EnBrdEP();
		EnBrdSiteDO[] enBrdSiteDOs = ep.findByAddr(allQue4EsDTO.getAddr_board_ben());
		if(enBrdSiteDOs != null && enBrdSiteDOs.length > 0){
			for(EnBrdSiteDO brdsite :enBrdSiteDOs){
				if(brdsite.getId_brdsite().equals(brdSiteDO.getId_brdsite()))
					continue;
				brdsite.setEu_status(BrdStatusEnum.UPDATE);
				brdsite.setDt_lastmdf(EnAppUtils.getServerDateTime());
				brdsite.setNos_arrived(allQue4EsDTO.getArriedquenos());
				brdsite.setStatus(DOStatus.UPDATED);
			}
			ep.save(enBrdSiteDOs);
			return enBrdSiteDOs;
		}
		ep.save(new EnBrdSiteDO[]{brdSiteDO});
		return null;
	}
	
	/**
	 * 保存叫号信息
	 * 
	 * @author fanlq 2017年12月29日
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdCallDO[] setBrdCallInfo(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException {
		if (allQue4EsDTO == null)
			return null;
		// 1.获取发送的叫号DO数据
		EnBrdCallDO brdCallDO = this.getBrdCallInfo(allQue4EsDTO,eventType);
		// 2.保存大屏叫号DO到数据库中
		EnBrdCallDO[] rtns = new BrdCallEP().save(new EnBrdCallDO[] { brdCallDO });	
		return rtns;
	}

	
	/***
	 * 获取发送的大屏站点DO数据
	 * 
	 * @author fanlq 2018年1月5日
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param enBrdDO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdSiteDO getEnBrdSiteInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {	
		//大屏上是否已显示医生站站点
		EnBrdSiteDO brdSiteDO = this.getBrdSiteDO(allQue4EsDTO.getCode_quesite());
		brdSiteDO.setAddr_brd(allQue4EsDTO.getAddr_board_ben());// 分诊台屏幕地址
		brdSiteDO.setCode(allQue4EsDTO.getCode_quesite()); //站点编码
		brdSiteDO.setName_dept(allQue4EsDTO.getName_dep());// 科室名称
		brdSiteDO.setName_dr(allQue4EsDTO.getName_doc());// 资源名称
		brdSiteDO.setNos_wait(allQue4EsDTO.getWaitquenos());// 候诊号
		//brdSiteDO.setName_curpat(allQue4EsDTO.getName_pat());// 当前患者姓名
		brdSiteDO.setName_clinic(allQue4EsDTO.getCode_room()); // 诊室
		brdSiteDO.setId_grp(EnContextUtils.getGrpId());
		brdSiteDO.setId_org(EnContextUtils.getOrgId());
		brdSiteDO.setCode_pat(allQue4EsDTO.getCode_pat());
		//brdSiteDO.setNo_curpat(allQue4EsDTO.getTickno() == null ? "0" : allQue4EsDTO.getTickno());// 就诊号
		brdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
		//大屏信息
		EnBrdDO enBrdDO = new EnBrdEP().findEnBrdDOByAddr(allQue4EsDTO.getAddr_board_ben());
		brdSiteDO.setId_pc(enBrdDO != null ? enBrdDO.getId_pc() : null);
		//若存在叫号患者，将当前患者设置未叫号患者，若不存在叫号患者，将正在检查的患者设为当前患者
		EnQueueDO[] enquedos = this.getCallingEnt(allQue4EsDTO);
		if(enquedos != null && enquedos.length > 0){
			allQue4EsDTO.setName_pat(enquedos[0].getName_pat());
			allQue4EsDTO.setTickno(enquedos[0].getSortno().toString() );
		}else{
			//EnQueueDO[] willCallings = this.getWillCallingEnt(allQue4EsDTO);
			EnQueueDO[] checkings = this.getCheckingEnt(allQue4EsDTO);
			if(checkings != null && checkings.length > 0){
				allQue4EsDTO.setName_pat(checkings[0].getName_pat());
				allQue4EsDTO.setTickno(checkings[0].getSortno().toString() );
			}else{
				allQue4EsDTO.setName_pat("");
				allQue4EsDTO.setTickno("");
			}
		}
		//当前就诊号
		String name_curpat = allQue4EsDTO.getName_pat() == null ? "" : allQue4EsDTO.getName_pat();
		if (allQue4EsDTO.getTickno() != null) {
			brdSiteDO.setNo_curpat(name_curpat);// 就诊号
		}
		//下一个
		if(!EnValidator.isEmpty(allQue4EsDTO.getWaitquenos()) && allQue4EsDTO.getWaitquenos().length() >0){
			String name_nextpat = null;
			FArrayList list = new FArrayList();
			list = allQue4EsDTO.getWait_list();
			FArrayList nextPatList = new FArrayList();
			if(list != null && list.size() > 0){
				for(Object obj : list){
					AllQue4EsDTO allQueDTO = (AllQue4EsDTO)obj;
					name_nextpat = allQueDTO.getName_pat();
					if(allQueDTO.getTickno() != null){
						nextPatList.add(name_nextpat);
					}else{
						brdSiteDO.setNos_wait("");
					}
				}
			}
			if(nextPatList != null && nextPatList.size() > 0){
				String nextPatStr = nextPatList.toString().replace("[", "");
				nextPatStr = nextPatStr.replace("]", "");
				nextPatStr = nextPatStr.replace(", ", "、");
				if(nextPatStr.length() > 2800){
					nextPatStr = nextPatStr.substring(0, 2800);
				}else{
					brdSiteDO.setNos_wait(nextPatStr);// 下一个
				}
			}
		}
		if (brdSiteDO.getStatus() == DOStatus.NEW)
			brdSiteDO.setEu_status(BrdStatusEnum.ADD);
		else {
			Integer brdType = this.getBrdType(allQue4EsDTO);
			if(brdType != null && BrdtpEnum.DRUGBRD.equals(brdType)){
				if (IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE.equals(eventType) || IEnEventConst.EVENT_EN_ALL_PASSNUM.equals(eventType)
						|| IEnEventConst.EVENT_EN_ALL_DIAGEND.equals(eventType))
					brdSiteDO.setEu_status(BrdStatusEnum.DEL);
			}else{
				if (IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE.equals(eventType)){
					brdSiteDO.setEu_status(BrdStatusEnum.DEL);
					brdSiteDO.setNo_curpat("");
					brdSiteDO.setName_curpat("");
					brdSiteDO.setNos_wait("");
				}else{
					brdSiteDO.setEu_status(BrdStatusEnum.UPDATE);
					EnQueueDO[] enquedos1 = this.getCallingEnt(allQue4EsDTO);
					if(enquedos1 == null || enquedos1.length <= 0){
						brdSiteDO.setNo_curpat("");
						brdSiteDO.setName_curpat("");
					}
					EnQueueDO[] willCalling = getWillCallingEnt(allQue4EsDTO);
					if(willCalling == null || willCalling.length <= 0){
						brdSiteDO.setNos_wait("");
					}
				}
			}
		}
		WrapAllQueMsgInfoBP bp = new WrapAllQueMsgInfoBP();
		bp.wrap(allQue4EsDTO);
		brdSiteDO.setNos_arrived(allQue4EsDTO.getArriedquenos());
		return brdSiteDO;
	}

	/**
	 * 获取发送的叫号DO数据
	 * @author fanlq 2018年1月5日
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdCallDO getBrdCallInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		EnBrdCallDO callDO = new EnBrdCallDO();
		callDO.setAddr_brd(allQue4EsDTO.getAddr_board_ben());// 分诊台屏幕地址
		callDO.setCode_site(allQue4EsDTO.getCode_quesite());//站点编码
		callDO.setName_dept(allQue4EsDTO.getName_dep());// 科室名称
		if(!EnValidator.isEmpty(allQue4EsDTO.getTickno())){
			callDO.setTick_no(Integer.valueOf(allQue4EsDTO.getTickno()));// 票号
		}
		callDO.setName_pat(allQue4EsDTO.getName_pat());// 患者姓名
		callDO.setName_call_pat(allQue4EsDTO.getName_pat());
		callDO.setRes_name(allQue4EsDTO.getName_doc());// 资源名称
		Integer age = 0;
		callDO.setAge(age);
		if (allQue4EsDTO.getD_birthday() != null && EnAppUtils.getServerDate() != null) {
			age = EnAppUtils.getServerDate().getYear() - allQue4EsDTO.getD_birthday().getYear();
			if (age >= 0) {
				callDO.setAge(age);// 年龄
			}
		}
		callDO.setName_sex(allQue4EsDTO.getName_sex() == null ? "未知" : allQue4EsDTO.getName_sex() );// 性别
		callDO.setDt_call(EnAppUtils.getServerDateTime());
		callDO.setDt_insert(EnAppUtils.getServerDateTime());
		callDO.setId_grp(EnContextUtils.getGrpId());
		callDO.setId_org(EnContextUtils.getOrgId());
		callDO.setCode_pat(allQue4EsDTO.getCode_pat());
		if (IEnEventConst.EVENT_EN_ALL_CALLNUM.equals(eventType)) {
			callDO.setStatus(DOStatus.NEW);
		}
		return callDO;
	}
	
	/***
	 * 大屏上是否已显示站点，是则更新或删除，否则新增
	 * 
	 * @author fanlq 
	 * @param brdSiteDO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO getBrdSiteDO(String siteCode) throws BizException {
		EnBrdSiteDO[] rtns = ServiceFinder.find(IEnbrdsitedoRService.class).findByAttrValString(EnBrdSiteDO.CODE,siteCode);
		if (rtns != null && rtns.length == 1) {
			rtns[0].setStatus(DOStatus.UPDATED);
			return rtns[0];
		}else if(rtns != null && rtns.length > 1){
			this.delete(rtns);
		}
		EnBrdSiteDO rtn = new EnBrdSiteDO();
		rtn.setStatus(DOStatus.NEW);
		return rtn;
	}
	
	private Object delete(final EnBrdSiteDO[] rtns ){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<EnBrdSiteDO>() {
			@Override
			public EnBrdSiteDO doInTransaction(TransactionStatus arg0) {
				try {
					IEnbrdsitedoCudService service = ServiceFinder.find(IEnbrdsitedoCudService.class);
					for(EnBrdSiteDO rtn : rtns){
						rtn.setStatus(DOStatus.DELETED);
					}
					service.save(rtns);
				} catch (BizException e) {
					return null;
				}
				return null;
			}
		});
	}
	
	/***
	 * 
	 * 获取大屏站点类型
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	private Integer getBrdType(AllQue4EsDTO allQue4EsDTO) throws BizException{
		if(allQue4EsDTO != null && EnValidator.isEmpty(allQue4EsDTO.getAddr_board_ben())){
			return null;
		}
		IEnbrddoMDORService service = ServiceFinder.find(IEnbrddoMDORService.class);
		EnBrdDO[] enBrdDOs = service.find("addr = '"+allQue4EsDTO.getAddr_board_ben()+"'",null, FBoolean.FALSE);
		if(enBrdDOs != null && enBrdDOs.length > 0){
			EnBrdDO enBrdDO = enBrdDOs[0];
			return enBrdDO.getEu_brdtpc();
		}
		return null;
	}

	/**
	 * 获取正在处置的患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getCheckingEnt(AllQue4EsDTO allQue4EsDTO) throws BizException{
		FDate date = EnAppUtils.getServerDate();
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_regist >= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_CHECKED,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
	
	/**
	 * 获取要叫号患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getCallingEnt(AllQue4EsDTO allQue4EsDTO) throws BizException{
		FDate date = EnAppUtils.getServerDate();
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_regist >= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
	/**
	 * 获取要等候患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getWillCallingEnt(AllQue4EsDTO allQue4EsDTO) throws BizException{
		FDate date = EnAppUtils.getServerDate();
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_regist >= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, allQue4EsDTO.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
}
