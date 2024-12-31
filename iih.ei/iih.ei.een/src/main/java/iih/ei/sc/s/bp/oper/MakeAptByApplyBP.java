package iih.ei.sc.s.bp.oper;

import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.s.bp.qry.IsSelfAptableBP;
import iih.ei.sc.ws.bean.CommonReturnBean;
import iih.ei.sc.ws.bean.IsSelfAptableBean;
import iih.ei.sc.ws.bean.ReturnScAptNonOrdBean;
import iih.pi.overview.overview.d.PiPatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.out.i.ISc4OutThirdCmdService;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IAptexchlCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MakeAptByApplyBP {

	/**
	 * 医技选号预约
	 * @param id_aptappl 申请单id
	 * @param id_tick 号位id
	 * @param chlType 渠道编码
	 * @param oprcode 操作人编码
	 * @return
	 * @throws BizException 
	 */
	public CommonReturnBean exec(String id_aptappl,String id_tick,String chlType,String oprcode) throws BizException{
		CommonReturnBean result = new CommonReturnBean();
			this.makeAptByApply(id_aptappl, id_tick, chlType, oprcode);
		return result;
	}
	/**
	 * 选号预约
	 * @param id_aptappl 申请单id
	 * @param id_tick 号位id
	 * @param chlType 渠道编码
	 * @param oprcode 操作人编码
	 * @throws BizException
	 */
	private void makeAptByApply(String id_aptappl,String id_tick,String chlType,String oprcode) throws BizException{
		//检验数据有效性
		this.validData(id_aptappl, id_tick, chlType, oprcode);
		//校验自助预约规则
		this.validAptRule4Chl(chlType, id_aptappl);
		//获取渠道和渠道期间数据
		SchedulechlAggDO chlAggDO = this.getChl(chlType);
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO applDO = iscaptapplmdorservice.findById(id_aptappl);
		ScSchTickDO tickDO = ServiceFinder.find(ISctickRService.class).findById(id_tick);
		//判断号位是不是号段模式的排班
		ScSchTicksDO ticksDO = this.getTicksByTickId(tickDO);
		//获取排班科室
		String id_dep = this.getDepScpl(tickDO.getId_sch());
		
		ScSchDO sch = this.getScSch(tickDO.getId_sch());
		//医技预约
		ISc4OutThirdCmdService cmdService = ServiceFinder.find(ISc4OutThirdCmdService.class);
		MtAppDTO appDTO = new MtAppDTO();
		appDTO.setId_srv(applDO.getId_srv());
		appDTO.setCode_scchl(chlType);
		appDTO.setOr_closed_flag(FBoolean.FALSE);
		appDTO.setId_pat(applDO.getId_pi());
		appDTO.setId_dep_mp(applDO.getId_dep_mp());
		appDTO.setFg_bl(applDO.getFg_bl());
		appDTO.setId_enttp(applDO.getId_entp());
		appDTO.setSd_aptmd(EuAptmd.APPL.toString());
		appDTO.setSd_sys_from(IScDictCodeConst.SD_SYS_FROM_IIH);
		appDTO.setId_or(applDO.getId_or());
		appDTO.setFg_mtapp_apt(FBoolean.FALSE);
		appDTO.setId_apt_appl(applDO.getId_aptappl());
		MtResDTO resDTO = new MtResDTO();
		resDTO.setId_scchl(chlAggDO.getParentDO().getId_scchl());
		resDTO.setId_sch(tickDO.getId_sch());
		resDTO.setId_dep(id_dep);
		if(ticksDO != null){
			resDTO.setId_ticks(ticksDO.getId_ticks());
			resDTO.setId_tick(tickDO.getId_tick());
		}else{
		resDTO.setId_ticks(id_tick);
		}
		resDTO.setSd_tickmd(sch.getSd_tickmd());
		resDTO.setSc_oper_src(IScDictCodeConst.SC_CHOICE_APT);
		FMap result = cmdService.saveMtAptPub(resDTO, appDTO, IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);
		resDTO = (MtResDTO)result.get("result");
		if(FBoolean.FALSE.equals((FBoolean)result.get("isSuc")))
		{
			String note = "";
			if(!ListUtil.isEmpty(resDTO.getDays_excl_must()))//排斥禁止
			{
				for (Object object :resDTO.getDays_excl_must()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			else if(!ListUtil.isEmpty(resDTO.getDays_excl_times()))//次数限制
			{
				for (Object object :resDTO.getDays_excl_times()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			else if(!ListUtil.isEmpty(resDTO.getDays_together_must()))//强制并行
			{
				for (Object object :resDTO.getDays_together_must()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			throw new BizException("医技预约失败:"+note);
		}else{
			String note = "";
			if(!ListUtil.isEmpty(resDTO.getDays_excl_hint()))//排斥提示
			{
				for (Object object :resDTO.getDays_excl_hint()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}else if(!ListUtil.isEmpty(resDTO.getDays_together_hint()))//并行提示
			{
				for (Object object :resDTO.getDays_together_hint()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			if(!StringUtil.isEmpty(note)){
				//如果违反了排斥提示或并行提示则先进行退约
				this.cancMtApt(resDTO.getId_apt(), appDTO);
				//退约后还原申请单的自助预约次数和取消预约次数
				ScAptApplDO newApplDO = iscaptapplmdorservice.findById(id_aptappl);
				newApplDO.setStatus(DOStatus.UPDATED);
				newApplDO.setId_scapt(applDO.getId_scapt());
				newApplDO.setTimes(applDO.getTimes());
				//newApplDO.setTimes_canc_emg(applDO.getTimes_canc_emg());
				//newApplDO.setTimes_canc_fails(applDO.getTimes_canc_fails());
				//newApplDO.setTimes_canc_norm(applDO.getTimes_canc_norm());
				//newApplDO.setTimes_selfapt(applDO.getTimes_selfapt());
				IScaptapplMDOCudService iscaptapplmdocudservice = ServiceFinder.find(IScaptapplMDOCudService.class);
				iscaptapplmdocudservice.save(new ScAptApplDO[]{newApplDO});
				throw new BizException("医技预约失败:"+note);
			}
		}

		//保存预约外部渠道数据
		IAptexchlCudService aptexchlCudService = ServiceFinder.find(IAptexchlCudService.class);
		AptExChlDO chlDO = new AptExChlDO();
		chlDO.setStatus(DOStatus.NEW);
		chlDO.setId_apt(resDTO.getId_apt());
		//chlDO.setCode_pat();
		//chlDO.setName_org_apply(orgNameAppl);
		chlDO.setD_sc(resDTO.getD_sch());
		//chlDO.setCode_dep(res);
		//chlDO.setCode_emp_phy(phyNameAppl);
		chlDO.setFg_tranf(FBoolean.FALSE);
		aptexchlCudService.save(new AptExChlDO[]{chlDO});
	}
	/**
	 * 根据号位判断票号模式号段模式则返回号段对象否则返回null
	 * @param tick
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO getTicksByTickId(ScSchTickDO tick) throws BizException{
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(tick.getId_sch());
		if (schDO == null) {
			throw new BizException("对应排班不存在！");// 排班不存在
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			throw new BizException("排班已经停诊，无法挂号！");// 停诊不能挂号
		}
		// 获取票号模式
		String tickMd = schDO.getSd_tickmd();
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			ScSchTicksDO ticksDO = ServiceFinder.find(IScticksRService.class).findById(tick.getId_ticks());
			return ticksDO;
		}
		return null;
	}
	/**
	 * 获取返回信息
	 * @param id_apt 预约id
	 * @return
	 * @throws DAException 
	 */
	private List<ReturnScAptNonOrdBean> getReturnScAptNonOrd(String id_apt) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select apt.id_apt,");
		sql.append(" sch.d_sch as scDate,");
		sql.append(" tick.t_b as scTime,");
		sql.append(" apt.queno,");
		sql.append(" sch.sugest_exmint as sugestExmint,");
		sql.append(" ben.des as as placeOfVisit");
		sql.append(" from sc_apt apt");
		sql.append(" inner join sc_tick tick on tick.id_tick = apt.id_tick");
		sql.append(" inner join sc_sch sch on sch.id_sch = apt.id_sch");
		sql.append(" left join bd_que que on apt.id_dep_appt = que.id_dep and apt.id_scres = que.id_scres and apt.id_scsrv = que.id_scsrv");
		sql.append(" left join bd_que_ben ben on ben.id_queben = que.id_queben");
		sql.append(" where apt.id_apt = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		List<ReturnScAptNonOrdBean> list =  (List<ReturnScAptNonOrdBean>) new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(ReturnScAptNonOrdBean.class));
		return list;
	}
	
	/**
	 * 获取排班计划科室id
	 * @param id_sch
	 * @return
	 * @throws DAException
	 * @throws BizException
	 */
	private String getDepScpl(String id_sch) throws DAException,BizException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select pl.id_dep from sc_sch sch ");
		sql.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl");
		sql.append(" where sch.id_sch = ? ");
		SqlParam params = new SqlParam();
		params.addParam(id_sch);
		String id_dep = (String) new DAFacade().execQuery(sql.toString(), params, new ColumnHandler());
		if(StringUtil.isEmpty(id_dep))
		{
			throw new BizException("医技预约失败:未找到科室信息!id_sch="+id_sch);
		}
		return id_dep;
	}
	
	/**
	 * 获取患者id
	 * @param patCode
	 * @throws DAException
	 */
	private PiPatDO getPatDO(String patCode) throws BizException
	{
		StringBuilder sql = new StringBuilder();
		sql.append("select id_pat from pi_pat where code = ? ");
		SqlParam params = new SqlParam();
		params.addParam(patCode);
		List<PiPatDO> list = (List<PiPatDO>) new DAFacade().execQuery (sql.toString(), params, new BeanListHandler(PiPatDO.class));
		if(list == null || list.size() == 0)
		{
			throw new BizException("医技预约失败:未找到患者信息!patCode="+patCode);
		}
		else if(list.size()>1)
		{
			throw new BizException("医技预约失败:查询到多条患者信息!patCode="+patCode);
		}
		return list.get(0);
	}

	/**
	 * 获取渠道和渠道期间数据
	 * @param chlType
	 * @return
	 * @throws BizException
	 */
	private SchedulechlAggDO getChl(String chlType) throws BizException
	{
		//String id_org = Context.get().getOrgId();
		String id_org = "0001HY1000000000OH85";
		ISchedulechlRService rService = ServiceFinder.find(ISchedulechlRService.class);
		SchedulechlAggDO[] aggDOs = rService.find(String.format(" code = '%s' ",chlType), "", FBoolean.FALSE);
		if(aggDOs == null ||aggDOs.length == 0)
		{
			throw new BizException("医技预约失败:未找到渠道!chlType="+chlType);
		}
		for (SchedulechlAggDO schedulechlAggDO : aggDOs) {
			if(schedulechlAggDO.getParentDO().getId_org().equals(id_org)){
				return schedulechlAggDO;
			}
		}
		return aggDOs[0];
	}
	
	/**
	 * 校验数据有效性
	 * @param patCode
	 * @param idSrv
	 * @param chlTyoe
	 * @param id_sch
	 * @param fg_bl
	 * @throws BizException
	 */
	private void validData(String id_aptappl,String id_tick,String chlType,String oprCode)throws BizException
	{
		if(StringUtil.isEmpty(id_aptappl))
		{
			throw new BizException("医技预约失败:申请单id为空!");
		}
		if(StringUtil.isEmpty(id_tick))
		{
			throw new BizException("医技预约失败:号位id为空!");
		}
		if(StringUtil.isEmpty(chlType))
		{
			throw new BizException("医技预约失败:预约途径为空!");
		}
		if(StringUtil.isEmpty(oprCode))
		{
			throw new BizException("医技预约失败:预约操作人为空!");
		}
	}
	
	private ScSchDO getScSch(String id_sch) throws BizException{
		IScschMDORService  iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		return iscschmdorservice.findById(id_sch);
	}
	/**
	 * 根据渠道校验自助预约规则
	 * @param chlType
	 * @param id_apt
	 * @throws BizException
	 */
	private void validAptRule4Chl(String chlType,String id_aptappl) throws BizException{
		IsSelfAptableBean[] isAptable = new IsSelfAptableBP().exec(id_aptappl,chlType);
		FBoolean isCanApt = FBoolean.TRUE;
		if(!ArrayUtil.isEmpty(isAptable)){
			IsSelfAptableBean bean = isAptable[0];
			isCanApt = new FBoolean(bean.getIsAptable());
		}
		if(!isCanApt.booleanValue()){
			throw new BizException("渠道:"+chlType+",不满足自助预约规则");
		}
	}
	/**
	 * 取消预约
	 * @param aptDO
	 * @param appDTO
	 * @throws BizException
	 */
	private void cancMtApt(String id_apt,MtAppDTO appDTO) throws BizException{
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO aptDO = aptRService.findById(id_apt);// 获取预约数据
		//取消预约
		IScAptCmdService cmdService = ServiceFinder.find(IScAptCmdService.class);
		MtAppDTO appdto = new MtAppDTO();
		appdto.setId_apt(aptDO.getId_apt());
		appdto.setId_scca(aptDO.getId_scca());
		appdto.setId_dep_mp(appDTO.getId_dep_mp());
		appdto.setId_apt_appl(appDTO.getId_apt_appl());
		appdto.setId_or(appDTO.getId_or());
		appdto.setSd_aptmd(appDTO.getSd_aptmd());
		appdto.setSd_sys_from(appDTO.getSd_sys_from());
		cmdService.cancelMtApt(appdto);
	}
}
