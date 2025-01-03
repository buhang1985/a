package iih.en.que.s.event.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ScripRulConst;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.BrdCallEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrdsitedoCudService;
import iih.en.que.board.i.IEnbrdsitedoRService;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

public class WrapObj2OpQue4EnBrdBP {

	/***
	 * 保存大屏站点信息
	 * 
	 * @author fanlq 2017年12月27日
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO[] setBrdSiteInfo(final OpQue4EsDTO opQue4EsDTO, final String eventType) throws BizException {

		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<EnBrdSiteDO[]>() {
			@Override
			public EnBrdSiteDO[] doInTransaction(TransactionStatus arg0) {
				try {
					EnLogUtil logUtil =EnLogUtil.getInstance();
					// 1.获取组装的数据源DTO
					OpQue4DispDTO disDTO = getDisDTO(opQue4EsDTO, eventType);
					logUtil.logInfo("站点消息： OpQue4DispDTO" + disDTO);
					if (disDTO == null)
						return null;
					if(EnValidator.isEmpty(disDTO.getAddr_board_ben())){
						return null;
					}
					// 3.获取发送的大屏站点DO数据
					EnBrdSiteDO brdSiteDO = getEnBrdSiteInfo(opQue4EsDTO, disDTO,eventType);
					logUtil.logInfo("站点消息： EnBrdSiteDO" + brdSiteDO);
					FDate today = EnAppUtils.getServerDate();
					boolean lock = PKLock.getInstance().addDynamicLock(brdSiteDO.getCode() + today.toStdtString(), 5 * 1000);
					return  new EnBrdEP().save(new EnBrdSiteDO[] { brdSiteDO });
				} catch (BizException e) {
					EnLogUtil.getInstance().logInfo("站点消息： EnBrdSiteDO" + e);
					return null;
				}
			}
		});
	}

	/**
	 * 保存叫号信息
	 * 
	 * @author fanlq 2017年12月29日
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdCallDO[] setBrdCallInfo(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException {
		EnLogUtil logUtil =EnLogUtil.getInstance();
		// 1.获取组装的数据源DTO
		OpQue4DispDTO disDTO = this.getDisDTO(opQue4EsDTO, eventType);
		logUtil.logInfo("叫号消息： OpQue4DispDTO" + disDTO);
		if (disDTO == null)
			return null;
		if(EnValidator.isEmpty(disDTO.getAddr_board_ben())){
			return null;
		}
		FDate curDtae = EnAppUtils.getServerDate();
		// 2.获取发送的叫号DO数据
		EnBrdCallDO brdCallDO = this.getBrdCallInfo(opQue4EsDTO, disDTO,eventType,curDtae);
		logUtil.logInfo("叫号消息： EnBrdCallDO" + brdCallDO);
		// 3.保存大屏叫号DO到数据库中
		EnBrdCallDO[] rtns = new BrdCallEP().save(new EnBrdCallDO[] { brdCallDO });
		logUtil.logInfo("叫号消息：保存数据库 EnBrdCallDO" + rtns);
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
	private EnBrdSiteDO getEnBrdSiteInfo(OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO,String eventType) throws BizException {
	    String siteCode = getSiteCode(opQue4EsDTO);
		//大屏上是否已显示医生站站点
		EnBrdSiteDO brdSiteDO = this.getBrdSiteDO(siteCode);
		brdSiteDO.setAddr_brd(disDTO.getAddr_board_ben());// 分诊台屏幕地址
		brdSiteDO.setCode(siteCode); //站点编码
		brdSiteDO.setName_site(disDTO.getName_room());
		brdSiteDO.setName_dept(disDTO.getName_dep());// 科室名称
		brdSiteDO.setName_dr(disDTO.getName_doc());// 资源名称
		brdSiteDO.setNos_wait(disDTO.getWait_quenos());// 候诊号
		brdSiteDO.setName_curpat(disDTO.getName_pat());// 当前患者姓名
		brdSiteDO.setNo_curpat(null);//就诊号
		brdSiteDO.setName_clinic(disDTO.getCode_room()); // 诊室
		brdSiteDO.setId_grp(EnContextUtils.getGrpId());
		brdSiteDO.setId_org(EnContextUtils.getOrgId());
		//大屏信息
		EnBrdDO enBrdDO = new EnBrdEP().findEnBrdDOByAddr(disDTO.getAddr_board_ben());
		brdSiteDO.setId_pc(enBrdDO != null ? enBrdDO.getId_pc() : null);
		//获取参数ENPC1061大屏叫号患者信息显示模板,并分割成对象数组
		String[] brdParam = this.getBrdPatInfoParam(EnParamUtils.KEY_BRD_CALL_PATINFO, enBrdDO.getId_pc()); 
		//当前就诊患者
		String noCurpat = getNocurpat(disDTO, brdParam);
		brdSiteDO.setNo_curpat(noCurpat);
		//候诊患者
		String waitNos = getWaitNos(disDTO, brdParam);
		brdSiteDO.setNos_wait(waitNos);
		
		brdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
		//设置到诊患者信息，fanlq-2019-07-13
		brdSiteDO.setNos_arrived(null);
		this.setArrivedPatinfos(brdSiteDO,opQue4EsDTO,disDTO);
		//设置二次分诊屏站点信息,fanlq-2019-04-16
		this.setSecSiteInfo(brdSiteDO,opQue4EsDTO,disDTO);
		//退号处理-1-站点不在线;
		if(IEnEventConst.EVENT_EN_OP_CANC_REG.equals(eventType) && !PauseEnum.ONLINE.equals(disDTO.getSite_status())){
			brdSiteDO.setEu_status(BrdStatusEnum.DEL);
			return brdSiteDO;
		}
		if (brdSiteDO.getStatus() == DOStatus.NEW)
			brdSiteDO.setEu_status(BrdStatusEnum.ADD);
		else {
			if (IEnEventConst.EVENT_EN_OP_DOC_OFFLINE.equals(eventType))
				brdSiteDO.setEu_status(BrdStatusEnum.DEL);
			else
				brdSiteDO.setEu_status(BrdStatusEnum.UPDATE);
		}
		return brdSiteDO;
	}
	
	/**
	 * 设置当前就诊患者
	 * @param disDTO
	 * @return
	 * @throws BizException
	 */
	private String getNocurpat(OpQue4DispDTO disDTO, String[] brdParam) throws BizException {
		String noCurpat = "";
		for (String str : brdParam) {
			if ("姓名".equals(str)) {
				if (!EnValidator.isEmpty(disDTO.getCur_name_pat()) && disDTO.getCur_name_pat().length() > 0) {
					String cur_name_pat = disDTO.getCur_name_pat();
					// 调用脚本设计器显示患者姓名
					cur_name_pat = new GetBrdNameRulScripBP().exec(cur_name_pat, ScripRulConst.BRD_OP_SHOW_NAME,
							ScripRulConst.CURPAT);
					noCurpat += "" + cur_name_pat + "";
				}
			}
			if ("序号".equals(str)) {
				if (disDTO.getCur_acpt_sortno() != null) {
					String sortno = disDTO.getCur_acpt_sortno().toString();
					noCurpat += "[" + sortno + "]";
				}
			}
			if ("号类".equals(str)) {
				if (IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(disDTO.getCur_sd_srvtp())
						|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(disDTO.getCur_sd_srvtp())) {
					noCurpat += "[专]";
				} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG.equals(disDTO.getCur_sd_srvtp())){
					noCurpat += "[急]";
				} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM.equals(disDTO.getCur_sd_srvtp())){
					noCurpat += "[普]";
				}else{
					noCurpat += "";
				}
			}
			if ("门急诊服务简称".equals(str)) {
				if (!StringUtil.isEmpty(disDTO.getShortname_srv())) {
					String shortnameSrv = disDTO.getShortname_srv();
					noCurpat += "[" + shortnameSrv + "]";
				}
			}
		}
		return noCurpat;
	} 
	
	/**
	 * 设置候诊患者信息
	 * @param disDTO
	 * @param brdParam
	 * @return
	 * @throws BizException
	 */
	private String getWaitNos(OpQue4DispDTO disDTO, String[] brdParam) throws BizException {
		String waitPatNos = "";
		if(EnValidator.isEmpty(disDTO.getWait_quenos())){
			return waitPatNos;
		}
		String tickno = disDTO.getWait_quenos().substring(0,1);
		FArrayList list = disDTO.getWait_list();
		if (EnCollectionUtils.isEmpty(list)) {
			return waitPatNos;
		}
		Map<String,String> sdSrvtpMap = new HashMap<String,String>(); //号别类型
		Map<String,String> shortNameSrvMap = new HashMap<String,String>(); //号别简称
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", (BaseDO[]) list.toArray(new EnQueueDO[0]));
		getMapByEntIds(entIds, sdSrvtpMap, shortNameSrvMap);
		for(Object obj : list){
			EnQueueDO queDO = (EnQueueDO)obj;
			if(EnValidator.isEmpty(queDO) || EnValidator.isEmpty(tickno)) {
				break;
			}
			if (!EnValidator.isEmpty(waitPatNos)) {
				waitPatNos += "、";
			}
			for (String str : brdParam) {
				if ("姓名".equals(str)) {
					if (!EnValidator.isEmpty(queDO.getName_pat())) {
						String wait_name_pat = queDO.getName_pat();
						// 调用脚本设计器显示患者姓名
						wait_name_pat = new GetBrdNameRulScripBP().exec(wait_name_pat, ScripRulConst.BRD_OP_SHOW_NAME,
								ScripRulConst.WAITPAT);
						waitPatNos += "" + wait_name_pat + "";
					}
				}
				if ("序号".equals(str)) {
					if (queDO.getTicketno() != null) {
						waitPatNos += "[" + queDO.getTicketno() + "]";
					}
				}
				if ("号类".equals(str)) {
					// 如果sdSrvtpMap不为null，拼接号别类型
					if (sdSrvtpMap != null && sdSrvtpMap.containsKey(queDO.getId_ent())) {
						if (IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(sdSrvtpMap.get(queDO.getId_ent()))
							|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(sdSrvtpMap.get(queDO.getId_ent()))) {
							waitPatNos += "[专]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							waitPatNos += "[急]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							waitPatNos += "[普]";
						}else{
							waitPatNos += "";
						}
					}
				}
				if ("门急诊服务简称".equals(str)) {
					// 如果shortNameSrvMap不为null，拼接号别简称
					if (!EnValidator.isEmpty(shortNameSrvMap) && shortNameSrvMap.containsKey(queDO.getId_ent()) 
							&& !EnValidator.isEmpty(shortNameSrvMap.get(queDO.getId_ent()))) {
						waitPatNos += "[" + shortNameSrvMap.get(queDO.getId_ent()) + "]";
					}
				}
			}
		}
		return waitPatNos;
	}
	
	/**
	 * 获取PC参数,并分割成对象数组
	 * @param id_pc
	 * @return
	 */
	private String[] getBrdPatInfoParam(String paramKey, String id_pc) throws BizException {
		if (StringUtil.isEmpty(id_pc)) {
			throw new BizException("获取实体参数ENPC1061或者ENPC1062时，入参id_pc为空！");
		}
		String model = null;
		if (EnParamUtils.KEY_BRD_CALL_PATINFO.equals(paramKey)) {
			model = EnParamUtils.getPcCallInfoModel(id_pc);
		}
		if (EnParamUtils.KEY_BRD_PASS_PATINFO.equals(paramKey)) {
			model = EnParamUtils.getPcPassInfoModel(id_pc);
		}
		if (model == null) {
			throw new BizException("未获取到实体参数ENPC1061或者ENPC1062的值！");
		}
		String[] models = model.substring(1).substring(0, model.length()-2).split("><");
		return models;
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
	private EnBrdCallDO getBrdCallInfo(OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO,String eventType,FDate curDate) throws BizException{
		String siteCode = getSiteCode(opQue4EsDTO);
		EnBrdCallDO callDO = new EnBrdCallDO();
		callDO.setAddr_brd(disDTO.getAddr_board_ben());// 分诊台屏幕地址
		callDO.setCode_site(siteCode);//站点编码
		callDO.setName_dept(disDTO.getName_dep());// 科室名称
		callDO.setTick_no(disDTO.getTickno());// 票号
		String call_name_pat = disDTO.getName_pat();
		//调用脚本设计器显示患者姓名
		call_name_pat = new GetBrdNameRulScripBP().exec(call_name_pat,ScripRulConst.BRD_OP_SHOW_NAME,ScripRulConst.CALLPAT);
		callDO.setName_pat(call_name_pat);// 患者姓名
		callDO.setCode_pat(disDTO.getCode_pat());
		callDO.setName_call_pat(disDTO.getName_pat());
		callDO.setRes_name(disDTO.getName_doc());// 资源名称
		if (disDTO.getDt_birth_pat() != null && curDate != null) {
			Integer age = curDate.getYear() - disDTO.getDt_birth_pat().getYear();
			if (age >= 0) {
				callDO.setAge(age);// 年龄
			}
		}
		callDO.setName_sex(this.getNameSex(opQue4EsDTO.getId_pat()));// 性别
		callDO.setName_srvtp(this.getNameSrvTp(opQue4EsDTO.getId_ent()));// 号别
		callDO.setDt_call(EnAppUtils.getServerDateTime());
		callDO.setDt_insert(EnAppUtils.getServerDateTime());
		callDO.setId_grp(EnContextUtils.getGrpId());
		callDO.setId_org(EnContextUtils.getOrgId());
		//大屏信息
		EnBrdDO enBrdDO = new EnBrdEP().findEnBrdDOByAddr(disDTO.getAddr_board_ben());
		callDO.setId_pc(enBrdDO != null ? enBrdDO.getId_pc() : null);
		this.setSecSiteCallInfo(callDO,opQue4EsDTO);//设置二次屏，fanlq-2019-07-17
		if (IEnEventConst.EVENT_EN_OP_CALLNUM.equals(eventType)) {
			callDO.setStatus(DOStatus.NEW);
		}
		return callDO;
	}
	
	/***
	 * 获取门诊队列屏幕显示DTO
	 * 
	 * @author fanlq 2017年12月29日
	 * @param opQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private OpQue4DispDTO getDisDTO(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException {
		WrapObj2OpQue4DispBP disBP = new WrapObj2OpQue4DispBP();
		OpQue4DispDTO dispDTO = disBP.wrap(opQue4EsDTO, eventType);
		return dispDTO;
	}

	/**
	 * 获取站点编码
	 * @author fanlq 2018年1月12日
	 * @param siteName
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	private String getSiteCode(OpQue4EsDTO opQue4EsDTO)throws BizException{
		String code_site = "";
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO site = ep.getSiteById(opQue4EsDTO.getId_que_site());
		if (site == null)
			return null;
		code_site = site.getCode();
		return code_site;
	}
	
	/***
	 * 大屏上是否已显示站点，是则更新或删除，否则新增
	 * 
	 * @author fanlq 2018年1月2日
	 * @param brdSiteDO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO getBrdSiteDO(String siteCode) throws BizException {
		EnBrdSiteDO[] rtns = ServiceFinder.find(IEnbrdsitedoRService.class).findByAttrValString(EnBrdSiteDO.CODE,siteCode);
		//站点若大于1条则全部删除重建
		if(rtns != null && rtns.length >1){
			this.delete(rtns);
		}else if (rtns != null && rtns.length == 1) {
			rtns[0].setStatus(DOStatus.UPDATED);
			return rtns[0];
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
	/**
	 * 获取患者性别
	 * 
	 * @author fanlq 2018年1月3日
	 * @return
	 * @throws BizException
	 */
	private String getNameSex(String patId) throws BizException {
		if (patId == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT UD.NAME AS NAME ");
		sb.append("FROM PI_PAT PAT ");
		sb.append("LEFT JOIN BD_UDIDOC UD ON UD.ID_UDIDOC = PAT.ID_SEX ");
		sb.append("WHERE PAT.ID_PAT = ? ");
		param.addParam(patId);
		String sex_name = "";
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Object> datas = (Map<String, Object>) new DAFacade().execQuery(sb.toString(), param, new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			sex_name = (String) FTypeManager.convert2FType(FType.String, datas.get("name"));
		}
		return sex_name;
	}

	/***
	 * 获取患者挂号服务的号别名称
	 * 
	 * @author fanlq 2018年1月3日
	 * @return
	 * @throws BizException
	 */
	private String getNameSrvTp(String entId) throws BizException {
		if (entId == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT UD.NAME AS NAME ");
		sb.append("FROM EN_ENT_OP OP ");
		sb.append("LEFT JOIN BD_UDIDOC UD ON UD.ID_UDIDOC = OP.ID_SVRTP ");
		sb.append("WHERE OP.ID_ENT = ? ");
		param.addParam(entId);
		String srvtp_name = "";
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Object> datas = (Map<String, Object>) new DAFacade().execQuery(sb.toString(), param, new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			srvtp_name = (String) FTypeManager.convert2FType(FType.String, datas.get("name"));
		}
		return srvtp_name;
	}
	
	/***
	 * 设置二次分诊特殊需要的信息
	 * @param brdSiteDO
	 * @param opQue4EsDTO
	 * @throws BizException
	 */
	private void setSecSiteInfo(EnBrdSiteDO brdSiteDO, OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO)
			throws BizException {
		// 设置二次屏pc
		QueSiteDO queSiteDO = new BdSiteEP().getSiteById(opQue4EsDTO.getId_que_site());
		if (EnValidator.isEmpty(queSiteDO) || EnValidator.isEmpty(queSiteDO.getId_pc_brd())) {
			return;
		}
		brdSiteDO.setId_pc_broad2(queSiteDO.getId_pc_brd());
		// 设置过号患者信息
		String calledNos = getCalledNos(opQue4EsDTO, disDTO, queSiteDO.getId_pc_brd());
		brdSiteDO.setPat_called(calledNos);
		// 设置医生照片
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO psndoc = service.findById(disDTO.getId_doc());
		if (psndoc != null) {
			brdSiteDO.setPhoto(psndoc.getPhotoToString());
			// 设置医生职称
			brdSiteDO.setName_worktp(psndoc.getEmptitle_name());
		}
		// 设置二次屏等候患者
		String brd2WaitNos = getBrd2WaitNos(opQue4EsDTO, disDTO, queSiteDO.getId_pc_brd());
		brdSiteDO.setWait_broad2(brd2WaitNos);
		
		// 设置医生特长
		IScheduleresRService resService = ServiceFinder.find(IScheduleresRService.class);
		String whereStr = " id_emp = '" + disDTO.getId_doc() + "' or (id_dep = '" + disDTO.getId_dep()
				+ "' and sd_screstp = '00') ";
		// 按照人员排序，先选人员数据，在选科室数据
		String orderStr = " id_emp asc ";
		ScheduleResDO[] scheduleResDOs = resService.find(whereStr, orderStr, FBoolean.FALSE);
		if (scheduleResDOs != null && scheduleResDOs.length > 0) {
			brdSiteDO.setDes_res(scheduleResDOs[0].getDes());
			if (EnValidator.isEmpty(brdSiteDO.getDes_res()) && scheduleResDOs.length > 1) {
				brdSiteDO.setDes_res(scheduleResDOs[1].getDes());
			}
		} else {
			brdSiteDO.setDes_res("");
		}
	}
	
	/**
	 * 设置二次屏过号患者信息
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param id_pc_brd2
	 * @return
	 */
	private String getCalledNos(OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO, String id_pc_brd2) throws BizException {
		String calledNos = "";
		//获取参数ENPC1062大屏过号患者信息显示模板,并分割成对象数组
		String[] brdParam = this.getBrdPatInfoParam(EnParamUtils.KEY_BRD_PASS_PATINFO, id_pc_brd2);
		//获取过号患者队列
		EnQueueDO[] ques = new EnQueEP().getEnQueueByWhereStr("id_que = '" + opQue4EsDTO.getId_que()
				+ "' and sd_entque_tp = '" + IBdFcDictCodeConst.SD_QUETP_EMP + "' and sd_status_acpt = '"
				+ IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME + "' and dt_regist = '" + disDTO.getDt_regist()
				+ "' and id_dateslot = '" + disDTO.getId_dayslot() + "' ", "sortno desc ");
		if (EnValidator.isEmpty(ques)) {
			return calledNos;
		}
		Map<String,String> sdSrvtpMap = new HashMap<String,String>(); //号别类型
		Map<String,String> shortNameSrvMap = new HashMap<String,String>(); //号别简称
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", ques);
		getMapByEntIds(entIds, sdSrvtpMap, shortNameSrvMap);
		for(EnQueueDO queDO : ques){
			if(EnValidator.isEmpty(queDO)) {
				break;
			}
			if (!EnValidator.isEmpty(calledNos)) {
				calledNos += "、";
			}
			for (String str : brdParam) {
				if ("姓名".equals(str)) {
					if (!EnValidator.isEmpty(queDO.getName_pat())) {
						String called_name_pat = queDO.getName_pat();
						// 调用脚本设计器显示患者姓名
						called_name_pat = new GetBrdNameRulScripBP().exec(called_name_pat, ScripRulConst.BRD_OP_SHOW_NAME,
								ScripRulConst.CALLEDPAT);
						calledNos += "" + called_name_pat + "";
					}
				}
				if ("序号".equals(str)) {
					if (queDO.getTicketno() != null) {
						calledNos += "[" + queDO.getTicketno() + "]";
					}
				}
				if ("号类".equals(str)) {
					// 如果sdSrvtpMap不为null，拼接号别类型
					if (sdSrvtpMap != null && sdSrvtpMap.containsKey(queDO.getId_ent())) {
						if (IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(sdSrvtpMap.get(queDO.getId_ent()))
							|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(sdSrvtpMap.get(queDO.getId_ent()))) {
							calledNos += "[专]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							calledNos += "[急]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							calledNos += "[普]";
						}else{
							calledNos += "";
						}
					}
				}
				if ("门急诊服务简称".equals(str)) {
					// 如果shortNameSrvMap不为null，拼接号别简称
					if (!EnValidator.isEmpty(shortNameSrvMap) && shortNameSrvMap.containsKey(queDO.getId_ent()) 
							&& !EnValidator.isEmpty(shortNameSrvMap.get(queDO.getId_ent()))) {
						calledNos += "[" + shortNameSrvMap.get(queDO.getId_ent()) + "]";
					}
				}
			}
		}
		return calledNos;
	}
	
	/**
	 * 设置二次屏等候患者
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param id_pc_brd2
	 * @return
	 * @throws BizException
	 */
	private String getBrd2WaitNos(OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO, String id_pc_brd2) throws BizException {
		String waitPatNos = "";
		//获取参数ENPC1061大屏叫号患者信息显示模板,并分割成对象数组
		String[] brdParam = this.getBrdPatInfoParam(EnParamUtils.KEY_BRD_CALL_PATINFO, id_pc_brd2);
		if(EnValidator.isEmpty(disDTO.getWait_quenos())){
			return waitPatNos;
		}
		FArrayList list = disDTO.getWait_list();
		if (EnCollectionUtils.isEmpty(list)) {
			return waitPatNos;
		}
		Map<String,String> sdSrvtpMap = new HashMap<String,String>(); //号别类型
		Map<String,String> shortNameSrvMap = new HashMap<String,String>(); //号别简称
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", (BaseDO[]) list.toArray(new EnQueueDO[0]));
		getMapByEntIds(entIds, sdSrvtpMap, shortNameSrvMap);
		for(Object obj : list){
			EnQueueDO queDO = (EnQueueDO)obj;
			if(EnValidator.isEmpty(queDO)) {
				break;
			}
			if (!EnValidator.isEmpty(waitPatNos)) {
				waitPatNos += "、";
			}
			for (String str : brdParam) {
				if ("姓名".equals(str)) {
					if (!EnValidator.isEmpty(queDO.getName_pat())) {
						String wait_name_pat = queDO.getName_pat();
						// 调用脚本设计器显示患者姓名
						wait_name_pat = new GetBrdNameRulScripBP().exec(wait_name_pat, ScripRulConst.BRD_OP_SHOW_NAME,
								ScripRulConst.WAITPAT);
						waitPatNos += "" + wait_name_pat + "";
					}
				}
				if ("序号".equals(str)) {
					if (queDO.getTicketno() != null) {
						waitPatNos += "[" + queDO.getTicketno() + "]";
					}
				}
				if ("号类".equals(str)) {
					// 如果sdSrvtpMap不为null，拼接号别类型
					if (sdSrvtpMap != null && sdSrvtpMap.containsKey(queDO.getId_ent())) {
						if (IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(sdSrvtpMap.get(queDO.getId_ent()))
							|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(sdSrvtpMap.get(queDO.getId_ent()))) {
							waitPatNos += "[专]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							waitPatNos += "[急]";
						} else if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM.equals(sdSrvtpMap.get(queDO.getId_ent()))){
							waitPatNos += "[普]";
						}else{
							waitPatNos += "";
						}
					}
				}
				if ("门急诊服务简称".equals(str)) {
					// 如果shortNameSrvMap不为null，拼接号别简称
					if (!EnValidator.isEmpty(shortNameSrvMap) && shortNameSrvMap.containsKey(queDO.getId_ent()) 
							&& !EnValidator.isEmpty(shortNameSrvMap.get(queDO.getId_ent()))) {
						waitPatNos += "[" + shortNameSrvMap.get(queDO.getId_ent()) + "]";
					}
				}
			}
		}
		return waitPatNos;
	} 
	
	/***
	 * 设置二次分诊特殊需要的信息
	 * @param brdSiteDO
	 * @param opQue4EsDTO
	 * @throws BizException
	 */
	private void setSecSiteCallInfo(EnBrdCallDO callDO,OpQue4EsDTO opQue4EsDTO) throws BizException{
		//设置二次屏pc
		BdSiteEP siteEp = new BdSiteEP();
		QueSiteDO queSiteDO = siteEp.getSiteById(opQue4EsDTO.getId_que_site());
		if(queSiteDO == null || EnValidator.isEmpty(queSiteDO.getId_pc_brd()))
			return;
		callDO.setId_pc_board2(queSiteDO.getId_pc_brd());
	}
	
	/**
	 * 获取到诊患者信息，fanlq-2019-07-15
	 * @param brdSiteDO
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @throws BizException
	 */
	private void setArrivedPatinfos(EnBrdSiteDO brdSiteDO,OpQue4EsDTO opQue4EsDTO, OpQue4DispDTO disDTO) throws BizException{
		if(brdSiteDO == null || EnValidator.isEmpty(brdSiteDO.getAddr_brd())) return;
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select pat.code as Code_pat,pat.name as Name_curpat,ben.addr_board,ent.dt_insert from en_ent_que que ");
		sql.append("inner join en_ent ent on ent.id_ent = que.id_ent " );
		sql.append("inner join en_ent_op op on op.id_ent = ent.id_ent " );
		sql.append("inner join sc_sch sch on sch.id_sch = op.id_sch " );
		sql.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat " );
		sql.append("inner join bd_que_ben ben on ben.id_queben = pl.id_queben " );
		sql.append("where 1=1 " );
		sql.append("and que.sd_status_acpt = ? " );
		sql.append("and que.sd_entque_tp = ? " );
		sql.append("and ent.fg_canc = ? " );
		sql.append("and ben.addr_board = ? " );
		sql.append("and que.dt_regist = ? ");
		sql.append("and que.id_que_site is null ");
		sql.append("and que.id_dateslot = ? ");
		sql.append("order by que.dt_in ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.FALSE);
		param.addParam(brdSiteDO.getAddr_brd());
		param.addParam(disDTO.getDt_regist());
		param.addParam(disDTO.getId_dayslot());
		@SuppressWarnings("unchecked")
		List<EnBrdSiteDO> list = (List<EnBrdSiteDO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(EnBrdSiteDO.class));
		List<String> nosArrivedList = new ArrayList<String>();
		FMap map = new FMap();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		if(list != null && list.size() > 0){
			for(EnBrdSiteDO enbrd : list){
				if(!EnValidator.isEmpty(enbrd.getCode_pat()) && !EnValidator.isEmpty(enbrd.getName_curpat()) && !map.containsKey(enbrd.getCode_pat())){
					map.put(enbrd.getCode_pat(), enbrd.getName_curpat());
					//调用脚本设计器显示患者姓名
					String arrived_name_pat = enbrd.getName_curpat();
					arrived_name_pat = bp.exec(arrived_name_pat,ScripRulConst.BRD_OP_SHOW_NAME,ScripRulConst.ARRIVEDPAT);
					nosArrivedList.add(arrived_name_pat);
				}
			}
		}
		if(nosArrivedList != null && nosArrivedList.size() > 0){
			String nosArrived = nosArrivedList.toString();
			if(!EnValidator.isEmpty(nosArrived)){
				nosArrived = nosArrived.replace("[", "").replace("]", "").replace(" ", "");
				if(nosArrived.length() > 2800){
					nosArrived = nosArrived.substring(0, 2800);
				}
				brdSiteDO.setNos_arrived(nosArrived);
			}
		}
	}

	/**
	 * 通过就诊id获取号别集合
	 * @param entIds
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void getMapByEntIds(String[] entIds,Map<String,String> sdSrvtpMap, 
			Map<String,String> shortNameSrvMap) throws BizException{
		if (EnValidator.isEmpty(entIds) || EnValidator.isEmpty(entIds[0])) {
			return;
		}
		StringBuilder sb  = new StringBuilder();
		sb.append("SELECT EN.ID_ENT, ");
		sb.append("OP.SD_SVRTP AS CUR_SD_SRVTP, ");
		sb.append("OP.ID_SCSRV, ");
		sb.append("SCSRV.CODE AS CODE_SCSRV, ");
		sb.append("SCSRV.NAME AS NAME_SRV, ");
		sb.append("SCSRV.SHORTNAME AS SHORTNAME_SRV ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
		sb.append("WHERE ");
		sb.append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
	    List<OpQue4DispDTO> list = (List<OpQue4DispDTO>) new DAFacade().execQuery(sb.toString(), null, new BeanListHandler(OpQue4DispDTO.class)); 
		if (EnValidator.isEmpty(list)) {
			return;
		}
		for (OpQue4DispDTO disDTO : list) {
			//号别类型
			if (!sdSrvtpMap.containsKey(disDTO.getId_ent())) {
				sdSrvtpMap.put(disDTO.getId_ent(), disDTO.getCur_sd_srvtp());
			}
			//号别简称
			if (!shortNameSrvMap.containsKey(disDTO.getId_ent())) {
				shortNameSrvMap.put(disDTO.getId_ent(), disDTO.getShortname_srv());
			}
		}
	}
}
