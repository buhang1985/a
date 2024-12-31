package iih.ei.std.s.v1.bp.sc;

import java.util.List;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.sc.mtaptnonord.d.MtAptNonOrdDTO;
import iih.ei.std.d.v1.sc.mtaptnonord.d.MtAptNonOrdParamDTO;
import iih.ei.std.d.v1.sc.mtaptnonord.d.MtAptNonOrdResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.pi.overview.overview.d.PiPatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.out.i.ISc4OutThirdCmdService;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlCudService;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MakeAptNonOrdBP extends IIHServiceBaseBP<MtAptNonOrdParamDTO,MtAptNonOrdResultDTO>{
	
	private static String id_entp_op = "@@@@AA10000000004O80";
	
	@Override
	protected void checkParam(MtAptNonOrdParamDTO param) throws BizException {
		//检验数据有效性
		validData(param);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected MtAptNonOrdResultDTO process(MtAptNonOrdParamDTO param) throws BizException {
		MtAptNonOrdResultDTO resultDTO = new MtAptNonOrdResultDTO();
		try {
			resultDTO = getResult(param);
		} catch (Exception e) {
			MtAptNonOrdDTO ordDTO = new MtAptNonOrdDTO();
			ordDTO.setReg_msg(e.getMessage());
			FArrayList fArrayList = new FArrayList();
			fArrayList.add(ordDTO);
			resultDTO.setMtaptnonorddto(fArrayList);
		}
		return resultDTO;
	}

	/**
	 * 医技预约(无申请单)
	 * @param patCode 患者编码
	 * @param idSrv 诊疗项目id
	 * @param chlTyoe 渠道
	 * @param id_sch 排班id
	 * @param orgNameAppl 申请结构名称
	 * @param depNameAppl 申请科室名称
	 * @param phyNameAppl 申请医生名称
	 * @param fg_bl 已收费标志
	 * @param oprCode 操作员
	 */
	@SuppressWarnings("unchecked")
	public MtAptNonOrdResultDTO getResult(MtAptNonOrdParamDTO param)throws BizException
	{
		String patCode = param.getCode_pat();
		String idSrv = param.getId_srv();
		String chlType = param.getChl_type();
		String id_sch = param.getId_sch();
		String orgNameAppl = param.getName_org_appl();
		String depNameAppl = param.getName_dep_appl();
		String phyNameAppl = param.getName_phy_appl();
		FBoolean fg_bl = param.getFg_bl();
		String oprCode = param.getCode_opr();
		
		//获取渠道和渠道期间数据
		SchedulechlAggDO chlAggDO = this.getChl(chlType);
		
		//获取患者信息
		PiPatDO patDO = this.getPatDO(patCode);
		
		//获取排班科室
		String id_dep = this.getDepScpl(id_sch);
		
		ScSchDO sch = this.getScSch(id_sch);
		//医技预约
		ISc4OutThirdCmdService cmdService = ServiceFinder.find(ISc4OutThirdCmdService.class);
		MtAppDTO appDTO = new MtAppDTO();
		appDTO.setId_srv(idSrv);
		appDTO.setCode_scchl(chlType);
		appDTO.setOr_closed_flag(FBoolean.FALSE);
		appDTO.setId_pat(patDO.getId_pat());
		appDTO.setId_dep_mp(id_dep);
		appDTO.setFg_bl("Y".equals(fg_bl)?FBoolean.TRUE:FBoolean.FALSE);
		appDTO.setId_enttp(id_entp_op);
		MtResDTO resDTO = new MtResDTO();
		resDTO.setId_scchl(chlAggDO.getParentDO().getId_scchl());
		resDTO.setId_sch(id_sch);
		resDTO.setId_dep(id_dep);
		resDTO.setSd_tickmd(sch.getSd_tickmd());
		resDTO.setSc_oper_src(IScDictCodeConst.SC_QUICK_APT);
		FMap result = cmdService.saveMtAptPub(resDTO, appDTO, IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);
		resDTO = (MtResDTO)result.get("result");
		if(FBoolean.FALSE.equals((FBoolean)result.get("isSuc")))
		{
			String note = "";
			if(ListUtil.isEmpty(resDTO.getDays_excl_must()))//排斥禁止
			{
				for (Object object :resDTO.getDays_excl_must()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			else if(ListUtil.isEmpty(resDTO.getDays_excl_times()))//次数限制
			{
				for (Object object :resDTO.getDays_excl_times()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			else if(ListUtil.isEmpty(resDTO.getDays_together_must()))//强制并行
			{
				for (Object object :resDTO.getDays_together_must()) {
					Map<String, String> exclMap = (Map<String, String>) object;
					note += exclMap.get("msg");
				}
			}
			throw new BizException("医技预约失败:"+note);
		}
		
		//保存预约外部渠道数据
		IAptexchlCudService aptexchlCudService = ServiceFinder.find(IAptexchlCudService.class);
		AptExChlDO chlDO = new AptExChlDO();
		chlDO.setStatus(DOStatus.NEW);
		chlDO.setId_apt(resDTO.getId_apt());
		chlDO.setCode_pat(patCode);
		chlDO.setName_org_apply(orgNameAppl);
		chlDO.setD_sc(resDTO.getD_sch());
		chlDO.setCode_dep(depNameAppl);
		chlDO.setCode_emp_phy(phyNameAppl);
		chlDO.setFg_tranf(FBoolean.FALSE);
		aptexchlCudService.save(new AptExChlDO[]{chlDO});
		List<MtAptNonOrdDTO> list = this.getReturnScAptNonOrd(resDTO.getId_apt());
		if(!ListUtil.isEmpty(list))
		{
			MtAptNonOrdResultDTO resultDTO = new MtAptNonOrdResultDTO();
			FArrayList fArrayList = new FArrayList();
			fArrayList.add(list.get(0));
			resultDTO.setMtaptnonorddto(fArrayList);
		}
		throw new BizException("医技预约成功:没有查询到返回信息!");
	}
	
	/**
	 * 获取返回信息
	 * @param id_apt 预约id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private List<MtAptNonOrdDTO> getReturnScAptNonOrd(String id_apt) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select apt.id_apt,");
		sql.append(" sch.d_sch as date_sc,");
		sql.append(" tick.t_b as time_sc,");
		sql.append(" apt.queno,");
		sql.append(" sch.sugest_exmint as sugest_exmint,");
		sql.append(" ben.des as as visit_place");
		sql.append(" from sc_apt apt");
		sql.append(" inner join sc_tick tick on tick.id_tick = apt.id_tick");
		sql.append(" inner join sc_sch sch on sch.id_sch = apt.id_sch");
		sql.append(" left join bd_que que on apt.id_dep_appt = que.id_dep and apt.id_scres = que.id_scres and apt.id_scsrv = que.id_scsrv");
		sql.append(" left join bd_que_ben ben on ben.id_queben = que.id_queben");
		sql.append(" where apt.id_apt = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		List<MtAptNonOrdDTO> list =  (List<MtAptNonOrdDTO>) new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(MtAptNonOrdDTO.class));
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
	@SuppressWarnings("unchecked")
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
		SchedulechlAggDO[] aggDOs = rService.find(StringUtil.isEmpty(chlType) ? "" : String.format(" code = '%s' ",chlType), "", FBoolean.FALSE);
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
	private void validData(MtAptNonOrdParamDTO param)throws BizException
	{
		String patCode = param.getCode_pat();
		String idSrv = param.getId_srv();
		String chlType = param.getChl_type();
		String id_sch = param.getId_sch();
		FBoolean fg_bl = param.getFg_bl();
		
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("医技预约失败:患者编码为空!");
		}
		if(StringUtil.isEmpty(idSrv))
		{
			throw new BizException("医技预约失败:诊疗项目id为空!");
		}
		if(StringUtil.isEmpty(id_sch))
		{
			throw new BizException("医技预约失败:排班id为空!");
		}
		if(fg_bl != null)
		{
			throw new BizException("医技预约失败:收费标识为空!");
		}
		if(!(FBoolean.TRUE.equals(fg_bl)|| !FBoolean.FALSE.equals(fg_bl)))
		{
			throw new BizException("医技预约失败:收费标识错误!");
		}
		patCode = patCode.replaceAll(".*([';]+|(--)+).*", "");
		idSrv = idSrv.replaceAll(".*([';]+|(--)+).*", "");
		chlType = chlType.replaceAll(".*([';]+|(--)+).*", "");
		id_sch = id_sch.replaceAll(".*([';]+|(--)+).*", "");
		if(StringUtil.isEmpty(patCode.trim()))
		{
			throw new BizException("医技预约失败:患者编码是非法字符!");
		}
		if(StringUtil.isEmpty(idSrv.trim()))
		{
			throw new BizException("医技预约失败:诊疗项目id是非法字符!");
		}
		if(StringUtil.isEmpty(chlType.trim()))
		{
			throw new BizException("医技预约失败:预约途径是非法字符!");
		}
		if(StringUtil.isEmpty(id_sch.trim()))
		{
			throw new BizException("医技预约失败:排班id是非法字符!");
		}
	}
	
	private ScSchDO getScSch(String id_sch) throws BizException{
		IScschMDORService  iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		return iscschmdorservice.findById(id_sch);
	}

	
}
