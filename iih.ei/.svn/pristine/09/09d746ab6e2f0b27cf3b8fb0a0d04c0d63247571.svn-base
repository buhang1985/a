package iih.ei.sc.s.bp.oper;

import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.s.bp.qry.IsSelfAptableBP;
import iih.ei.sc.s.bp.qry.IsSelfCancableBP;
import iih.ei.sc.ws.bean.CommonReturnBean;
import iih.ei.sc.ws.bean.IsSelfAptableBean;
import iih.ei.sc.ws.bean.IsSelfCancableBean;
import iih.ei.sc.ws.bean.ReturnScAptNonOrdBean;
import iih.pi.overview.overview.d.PiPatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlCudService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
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
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class ChangeAptBP {
	/**
	 * 医技改约
	 * @param id_aptappl 申请单id
	 * @param id_tick_new 需要改约到的号位id
	 * @param chlType 渠道编码
	 * @param oprcode 操作人编码
	 * @return
	 * @throws BizException 
	 */
	public CommonReturnBean exec(String id_aptappl,String id_tick_new,String chlType,String oprcode) throws BizException{
		CommonReturnBean result = new CommonReturnBean();
		this.changeApt(id_aptappl, id_tick_new, chlType, oprcode);
		return result;
	}
	/**
	 * 医技改约
	 * @param id_aptappl 申请单id
	 * @param id_tick 号位id
	 * @param chlType 渠道编码
	 * @param oprcode 操作人编码
	 * @throws BizException
	 */
	private void changeApt(String id_aptappl,String id_tick_new,String chlType,String oprcode) throws BizException{
		//检验数据有效性
		this.validData(id_aptappl, id_tick_new, chlType, oprcode);
		//获取渠道和渠道期间数据
		SchedulechlAggDO chlAggDO = this.getChl(chlType);
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO applDO = iscaptapplmdorservice.findById(id_aptappl);
		if(applDO == null) throw new BizException("未查询到预约申请单信息！");
		//校验改约规则
		this.validCancRule4Chl(chlType, id_aptappl);
		//校验自助预约规则
		this.validAptRule4Chl(chlType, id_aptappl);
		ScSchTickDO tickDO = ServiceFinder.find(ISctickRService.class).findById(id_tick_new);
		//获取排班科室
		String id_dep = this.getDepScpl(tickDO.getId_sch());
		//判断号位是不是号段模式的排班
		ScSchTicksDO ticksDO = this.getTicksByTickId(tickDO);
		ScSchDO sch = this.getScSch(tickDO.getId_sch());
		IScAptCmdService cmdService = ServiceFinder.find(IScAptCmdService.class); 
		//医技预约
		//ISc4OutThirdCmdService cmdService = ServiceFinder.find(ISc4OutThirdCmdService.class);
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] bdsrvs = iscbdsrvmdorservice.find("id_srv='"+applDO.getId_srv()+"'", null, FBoolean.FALSE);
		MtAppDTO appDTO = new MtAppDTO();
		if(!ArrayUtil.isEmpty(bdsrvs)){
			appDTO.setFg_needcfm(bdsrvs[0].getFg_needcfm());
		}else{
			appDTO.setFg_needcfm(FBoolean.FALSE);
		}
		appDTO.setId_apt(applDO.getId_scapt());//预约记录id
		appDTO.setFg_cancle_apt(FBoolean.TRUE);//改约操作
		appDTO.setId_or(applDO.getId_or());//医嘱id
		appDTO.setId_scca(applDO.getId_scca());//排班分类
		appDTO.setId_dep_mp(applDO.getId_dep_mp());//执行科室
		appDTO.setId_apt_appl(id_aptappl);//申请单id
		appDTO.setDt_effe_or(applDO.getDt_effe_or());//医嘱开立时间
		appDTO.setId_srv(applDO.getId_srv());//服务id
		appDTO.setCode_scchl(chlType);//渠道
		appDTO.setOr_closed_flag(FBoolean.FALSE);
		appDTO.setId_pat(applDO.getId_pi());//患者
		//appDTO.setId_dep_mp(id_dep);//
		appDTO.setFg_bl(applDO.getFg_bl());
		appDTO.setId_enttp(applDO.getId_entp());
		appDTO.setSd_aptmd(EuAptmd.APPL.toString());
		appDTO.setSd_sys_from(IScDictCodeConst.SD_SYS_FROM_IIH);
		appDTO.setFg_mtapp_apt(FBoolean.FALSE);
		appDTO.setId_apt_appl(id_aptappl);
		MtResDTO resDTO = new MtResDTO();
		resDTO.setId_scchl(chlAggDO.getParentDO().getId_scchl());
		resDTO.setId_sch(tickDO.getId_sch());
		resDTO.setId_dep(id_dep);
		if(ticksDO != null){
			resDTO.setId_ticks(ticksDO.getId_ticks());
			resDTO.setId_tick(id_tick_new);
		}else{
			resDTO.setId_ticks(id_tick_new);
		}
		resDTO.setSd_tickmd(sch.getSd_tickmd());
		resDTO.setSc_oper_src(IScDictCodeConst.SC_CHOICE_APT);
		resDTO = cmdService.changeMtApt(resDTO, appDTO);
		
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
			throw new BizException("医技改约失败:未找到科室信息!id_sch="+id_sch);
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
			throw new BizException("医技改约失败:未找到患者信息!patCode="+patCode);
		}
		else if(list.size()>1)
		{
			throw new BizException("医技改约失败:查询到多条患者信息!patCode="+patCode);
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
			throw new BizException("医技改约失败:未找到渠道!chlType="+chlType);
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
	private void validData(String id_aptappl,String id_tick_new,String chlType,String oprCode)throws BizException
	{
		if(StringUtil.isEmpty(id_aptappl))
		{
			throw new BizException("医技改约失败:改约申请单id为空!");
		}
		if(StringUtil.isEmpty(id_tick_new))
		{
			throw new BizException("医技改约失败:改约号位id为空!");
		}
		if(StringUtil.isEmpty(chlType))
		{
			throw new BizException("医技改约失败:改约途径为空!");
		}
		if(StringUtil.isEmpty(oprCode))
		{
			throw new BizException("医技改约失败:改约操作人为空!");
		}
	}
	
	/**
	 * 获取预约排班
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private ScSchDO getScSch(String id_sch) throws BizException{
		IScschMDORService  iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		return iscschmdorservice.findById(id_sch);
	}
	
	/**
	 * 根据渠道校验改约规则
	 * @param chlType
	 * @param id_apt
	 * @throws BizException
	 */
	private void validCancRule4Chl(String chlType,String id_aptappl) throws BizException{
		IsSelfCancableBean[] isCancable = new IsSelfCancableBP().exec(id_aptappl,IScDictCodeConst.SC_CHANGE_APT_OPERATE,chlType);
		FBoolean isCancApt = FBoolean.TRUE;
		if(!ArrayUtil.isEmpty(isCancable)){
			IsSelfCancableBean bean = isCancable[0];
			isCancApt = new FBoolean(bean.getIsCancable());
		}
		if(!isCancApt.booleanValue()){
			throw new BizException("渠道:"+chlType+",不满足改约的取消预约规则");
		}
	}
	
	/**
	 * 根据渠道校验自助预约规则（参考国际改约代码，这里的是国际微信预约规则）
	 * @param chlType
	 * @param id_apt
	 * @throws BizException
	 */
	private void validAptRule4Chl(String chlType,String id_aptappl) throws BizException{
		IsSelfAptableBean[] isAptable = new IsSelfAptableBP().exec(id_aptappl, chlType);
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
}
