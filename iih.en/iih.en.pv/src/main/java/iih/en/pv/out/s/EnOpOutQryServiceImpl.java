package iih.en.pv.out.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.bp.BatchGetBalanceBP;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.DeptPsndocDTO;
import iih.en.pv.dto.d.EnDiQrySchmDTO;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.dto.d.EnHisQryCondDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.dto.d.GuidePsnInfo;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.OpTotalInfoDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.s.bp.CheckEntIsHpCardstBP;
import iih.en.pv.s.bp.CheckIsHpCmClBP;
import iih.en.pv.s.bp.CheckIsHpcgBP;
import iih.en.pv.s.bp.EntDiQryBP;
import iih.en.pv.s.bp.GetEnPsnBP;
import iih.en.pv.s.bp.GetEnStatusBP;
import iih.en.pv.s.bp.GetEntHisDiBySchmBP;
import iih.en.pv.s.bp.GetEntInfo4MrBP;
import iih.en.pv.s.bp.GetEntInfoList4MrBP;
import iih.en.pv.s.bp.GetEntPriPatBP;
import iih.en.pv.s.bp.GetGuidePsnBaseBP;
import iih.en.pv.s.bp.GetHisEntDiListBP;
import iih.en.pv.s.bp.GetHosGuideDeptBaseBP;
import iih.en.pv.s.bp.ip.BatchGetBalanceContainBabyBP;
import iih.en.pv.s.bp.ip.CheckHasSettledBP;
import iih.en.pv.s.bp.ip.CheckHasSettledMultiBP;
import iih.en.pv.s.bp.ip.GetBalanceBP;
import iih.en.pv.s.bp.ip.GetDepListByDepLineBP;
import iih.en.pv.s.bp.ip.GetEnIpAccsByDepBP;
import iih.en.pv.s.bp.ip.GetEntInfoForMrBP;
import iih.en.pv.s.bp.ip.GetEntPatTpBP;
import iih.en.pv.s.bp.ip.GetIpBasicInfoBP;
import iih.en.pv.s.bp.ip.GetIpBasicInfosBP;
import iih.en.pv.s.bp.ip.GetIpDetailInfoBP;
import iih.en.pv.s.bp.ip.GetIpTotalInfoBP;
import iih.en.pv.s.bp.ip.GetIpTransOutDateBP;
import iih.en.pv.s.bp.ip.GetIpUnstlPriPatListBP;
import iih.en.pv.s.bp.ip.GetMedPsnBP;
import iih.en.pv.s.bp.ip.GetPeCmpyBalanceBP;
import iih.en.pv.s.bp.ip.qry.GetHpPatChareaCodeBP;
import iih.en.pv.s.bp.ip.qry.GetIpHpRegistBP;
import iih.en.pv.s.bp.ip.qry.GetMomEntInfoBP;
import iih.en.pv.s.bp.op.BatchChkIsGcVipBP;
import iih.en.pv.s.bp.op.BatchGetGcVipTpBP;
import iih.en.pv.s.bp.op.CheckIsGcVipBP;
import iih.en.pv.s.bp.op.CheckIsHpCardEntBP;
import iih.en.pv.s.bp.op.CheckRegMvelBP;
import iih.en.pv.s.bp.op.GetEntInfo4BannerBP;
import iih.en.pv.s.bp.op.GetGcVipTpBP;
import iih.en.pv.s.bp.op.GetOpBasicInfoBP;
import iih.en.pv.s.bp.op.GetOpBasicInfoByPatIdBP;
import iih.en.pv.s.bp.op.GetOpDignosedBP;
import iih.en.pv.s.bp.op.GetOpSdStatusBP;
import iih.en.pv.s.bp.op.GetOpTotalInfoBP;
import iih.en.pv.s.bp.op.GetRegInfoListBP;
import iih.en.pv.s.bp.op.GetSrvtpforCIBP;
import iih.en.pv.s.bp.op.LoadResPri4AptBP;
import iih.en.pv.s.bp.op.ws.GetPatOpAptListBP;
import iih.en.pv.s.bp.op.ws.GetSchListBP;
import iih.en.pv.s.bp.op.ws.GetWaitQueBP;
import iih.en.pv.s.listener.bp.GetOpReg4IpBP;
import iih.en.pv.s.rule.SupplyTicketRuleBP;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.IEnQueOutQryService;
import iih.en.que.i.IEnQueQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 就诊对外查询服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IEnOutQryService.class }, binding = Binding.JSONRPC)
public class EnOpOutQryServiceImpl implements IEnOutQryService {
	/**
	 * 获取banner信息
	 * 
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	@Override
	public Ent4BannerDTO[] getEntInfo4Banner(String sqlStr, String whereStr, String svName) throws BizException {
		GetEntInfo4BannerBP getBP = new GetEntInfo4BannerBP();
		return getBP.exec(sqlStr, whereStr, svName, null, null);
	}
	
	/**
	 * 获取banner信息
	 * (多了入参：输入的搜索值)
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	@Override
	public Ent4BannerDTO[] getEntInfo4Banner3(String sqlStr, String whereStr, String svName, String inputValue) throws BizException {
		GetEntInfo4BannerBP getBP = new GetEntInfo4BannerBP();
		return getBP.exec(sqlStr, whereStr, svName, null, inputValue);
	}
	
	/**
	 * 获取banner信息(参数绑定)
	 * 
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	@Override
	public Ent4BannerDTO[] getEntInfo4Banner2(String sqlStr, String whereStr, String svName, SqlParamDTO sqlParamDto) throws BizException {
		GetEntInfo4BannerBP getBP = new GetEntInfo4BannerBP();
		return getBP.exec(sqlStr, whereStr, svName, sqlParamDto, null);
	}
	/**
	 * 获取就诊账户
	 * 
	 * @param entId 就诊id
	 * @return
	 */
	@Override
	public EnAccountDO getEnAcc(String entId) throws BizException {
		EnAccEP accEP = new EnAccEP();
		return accEP.getAccByEntId(entId);
	}

	/**
	 * 获取就诊账户信息 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entId 就诊id
	 * @return DTO包含：患者预交金总金额、患者信用度总额、未结算费用总额、患者可用费用余额
	 * @throws BizException
	 */
	@Override
	public BalanceDTO getBalanceDTO(String entId) throws BizException {
		GetBalanceBP getBlBP = new GetBalanceBP();
		return getBlBP.exec(entId);
	}

	/**
	 * 获取就诊账户信息(批处理) 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entIds
	 * @return 就诊账户数组
	 * @throws BizException
	 */
	@Override
	public BalanceDTO[] getBalanceDTOs(String[] entIds) throws BizException {
		BatchGetBalanceBP getBlListBP = new BatchGetBalanceBP();
		return getBlListBP.exec(entIds);
	}

	/**
	 * 获取就诊账户信息(批处理) 信用额度=患者信用分类的信用额度+就诊账户的信用额度 含婴儿处理，婴儿使用母亲账户
	 * 
	 * @author ly 2017/09/11
	 * @param entIds
	 * @return 就诊账户数组
	 * @throws BizException
	 */
	@Override
	public BalanceDTO[] getBalanceDTOsContainBaby(String[] entIds) throws BizException {
		BatchGetBalanceContainBabyBP bp = new BatchGetBalanceContainBabyBP();
		return bp.exec(entIds);
	}

	/**
	 * 获取住院基本信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpBasicDTO getIpBasicInfo(String entId) throws BizException {
		GetIpBasicInfoBP getBP = new GetIpBasicInfoBP();
		return getBP.exec(entId);
	}
	
	/**
     * 获取住院基本信息
     * 
     * @param entIds 就诊id
     * @return
     * @throws BizException
     */
    @Override
    public IpBasicDTO[] getIpBasicInfos(String idpecmpy) throws BizException {
        GetIpBasicInfosBP bp = new GetIpBasicInfosBP();
        return bp.exec(idpecmpy);
    }

	/**
	 * 获取住院详细信息
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpDetailDTO getIpDetailInfo(String entId) throws BizException {
		GetIpDetailInfoBP getBP = new GetIpDetailInfoBP();
		return getBP.exec(entId);
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntForMedRecDTO getEntInfo4firstPage(String entId) throws BizException {
		GetEntInfoForMrBP getBP = new GetEntInfoForMrBP();
		return getBP.exec(entId);
	}

	/**
	 * 根据就诊id查找医护人员
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedPsnDTO getMedPsn4Mr(String entId) throws BizException {
		GetMedPsnBP getPsnBP = new GetMedPsnBP();
		return getPsnBP.getMedPsn(entId);
	}

	/**
	 * 获取人员信息
	 * 
	 * @param entId 就诊id
	 * @param empRole 人员角色
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnPsnDO getEnPsn(String entId, String empRole) throws BizException {
		GetEnPsnBP getEnPsnBP = new GetEnPsnBP();
		return getEnPsnBP.exec(entId, empRole);
	}

	/**
	 * 加载资源价格信息--为预约
	 * 
	 * @param entId 就诊id
	 * @param resDTO 挂号资源
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO loadResPri4Apt(String entId, RegResDTO resDTO) throws BizException {
		LoadResPri4AptBP loadBP = new LoadResPri4AptBP();
		return loadBP.exec(entId, resDTO);
	}

	/**
	 * 获取患者价格分类
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getPriPatId(String entId) throws BizException {
		GetEntPriPatBP getPriPatBP = new GetEntPriPatBP();
		return getPriPatBP.exec(entId);
	}

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getEntHisDiDTO(String patId) throws BizException {
		EntDiQryBP entQryBP = new EntDiQryBP();
		return entQryBP.getEntHisDiDTO(patId);
	}

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode 患者编码
	 * @param onlyDiagEnd 只包含诊毕标志
	 * @param withDetail 是否包含明细
	 * @param exclEntIds 排除的就诊ID，可为空
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getHisEntDiList(String patCode, FBoolean onlyDiagEnd, FBoolean withDetail, String[] exclEntIds)
			throws BizException {
		GetHisEntDiListBP getBP = new GetHisEntDiListBP();
		return getBP.exec(patCode, onlyDiagEnd, withDetail, exclEntIds);
	}
	/**
	 * 获取历史就诊数据
	 * 
	 * @param cond 查询条件
	 * @param exclEntIds 排除的就诊ID，可为空
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getHistEntListByCond(EnHisQryCondDTO cond,
			String[] exclEntIds) throws BizException {
		GetHisEntDiListBP getBP = new GetHisEntDiListBP();
		return getBP.exec(cond, exclEntIds);
	}

	/**
	 * 获取住院未结算的价格分类集合
	 * 
	 * @return 价格分类ID集合
	 * @throws BizException
	 */
	@Override
	public List<String> getIpUnstlPriPatList() throws BizException {
		GetIpUnstlPriPatListBP getPriPatBP = new GetIpUnstlPriPatListBP();
		return getPriPatBP.exec();
	}

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode 患者编码
	 * @param qrySchms 查询DTO数组
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getEntHisDiBySchm(String patCode, EnDiQrySchmDTO[] qrySchms) throws BizException {
		GetEntHisDiBySchmBP getBySchmBP = new GetEntHisDiBySchmBP();
		return getBySchmBP.exec(patCode, qrySchms);
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiVisitDO getEnInfo(String entId) throws BizException {
		PvEP pvEP = new PvEP();
		return pvEP.getPvById(entId);
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊id集合
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiVisitDO[] getEnInfoList(String[] entIds) throws BizException {
		PvEP pvEP = new PvEP();
		return pvEP.getPvByIds(entIds);
	}

	/**
	 * 获取门诊基本信息
	 * 
	 * @param entId 就诊ID
	 * @return 门诊基本信息DTO
	 * 
	 * @author liubin
	 * @throws BizException
	 */
	@Override
	public OpBasicDTO getOpBasicInfo(String entId) throws BizException {
		GetOpBasicInfoBP bp = new GetOpBasicInfoBP();
		return bp.getInfo(entId);
	}

	/**
	 * 获取门诊基本信息
	 * 
	 * @param code_ent 就诊编码
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	@Override
	public OpBasicDTO getOpBasicInfoByEntCode(String code_ent) throws BizException {
		if (EnValidator.isEmpty(code_ent)) {
			Logger.error(this + ":code_ent为空！");
			return null;
		}
		IPativisitRService entQryService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entDOs = entQryService.find(String.format("code = '%s'", code_ent), null, FBoolean.FALSE);
		if (EnValidator.isEmpty(entDOs)) {
			return null;
		}
		GetOpBasicInfoBP bp = new GetOpBasicInfoBP();
		return bp.getInfo(entDOs[0].getId_ent());
	}

	/**
	 * 获取病历就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnEmrDTO getEntInfo4Mr(String entId) throws BizException {
		GetEntInfo4MrBP bp = new GetEntInfo4MrBP();
		return bp.exec(entId);
	}

	/**
	 * 获取病人就诊信息
	 * 
	 * @param id_pat
	 * @param code_entp
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnEmrDTO[] getEntInfoList4Mr(String patId, String codeEntp, String entId) throws BizException {
		GetEntInfoList4MrBP bp = new GetEntInfoList4MrBP();
		return bp.exec(patId, codeEntp, entId);
	}

	/**
	 * 获取就诊患者所属类别
	 * 
	 * @param entId 就诊id
	 * @param depId 科室id
	 * @param empId 医生id
	 * @return 返回枚举值EntPatListTp
	 * @throws BizException
	 */
	@Override
	public String getEntPatTp(String entId, String depId, String empId) throws BizException {
		GetEntPatTpBP getBP = new GetEntPatTpBP();
		return getBP.exec(entId, depId, empId);
	}

	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param depId 科室或病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getDepListByDepl(String depId, String deplrole) throws BizException {
		GetDepListByDepLineBP getBP = new GetDepListByDepLineBP();
		return getBP.exec(depId, deplrole);
	}

	/**
	 * 获取诊毕患者列表
	 * 
	 * @param pageInfo 分页信息
	 * @param deptId 科室ID
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OpBasicDTO> getOpDignosed(PaginationInfo pageInfo, String deptId, FDate beginDate,
			FDate endDate) throws BizException {
		GetOpDignosedBP getDignosedBP = new GetOpDignosedBP();
		return getDignosedBP.exec(pageInfo, deptId, beginDate, endDate);
	}

	/**
	 * 获取集成平台挂号DTO
	 * 
	 */
	@Override
	public Reg4IpDTO getReg4Ip(OpReg4EsDTO reg4EsDTO) throws BizException {
		GetOpReg4IpBP bp = new GetOpReg4IpBP();
		return bp.createReg4IpDTO(reg4EsDTO);
	}

	/**
	 * 挂号规则验证，是否可以挂号
	 * 
	 * @author liubin
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultDTO isPermitRegByMvel(RegRuleDTO regRuleDto) throws BizException {
		CheckRegMvelBP checkBP = new CheckRegMvelBP();
		return checkBP.exec(regRuleDto);
	}

	/**
	 * 获取就诊状态
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public String getEnStatus(String entId) throws BizException {
		GetEnStatusBP getBP = new GetEnStatusBP();
		return getBP.exec(entId);
	}

	/**
	 * 判定就诊是否已经结算
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public FBoolean hasSettled(String entId) throws BizException {
		CheckHasSettledBP checkBP = new CheckHasSettledBP();
		return checkBP.exec(entId);
	}
	
	/**
	 * 判定就诊是否已经结算(批量)
	 * 
	 * @param entIds 就诊ID数组
	 * @return 判断结果map
	 * @throws BizException
	 * @author ly 2018/02/25
	 */
	@Override
	public FMap hasSettledMulti(String[] entIds) throws BizException{
		CheckHasSettledMultiBP bp = new CheckHasSettledMultiBP();
		return bp.exec(entIds);
	}

	/**
	 * 是否绿色通道VIP
	 * 
	 * @param entId 就诊ID
	 * @return true或 false
	 * @throws BizException
	 * @author zcm
	 */
	@Override
	public FBoolean isGcVip(String entId) throws BizException {
		CheckIsGcVipBP checkBP = new CheckIsGcVipBP();
		return checkBP.exec(entId);
	}

	/**
	 * 批量判定是否绿色通道VIP
	 * 
	 * @param entIds 就诊ID集合
	 * @return map，key:就诊ID, value: true或 false
	 * @throws BizException
	 * @author zcm
	 */
	@Override
	public FMap batchChkIsGcVip(String[] entIds) throws BizException {
		BatchChkIsGcVipBP batchChkBP = new BatchChkIsGcVipBP();
		return batchChkBP.exec(entIds);
	}

	/**
	 * 获取就诊的VIP类型
	 * 
	 * @param entId 就诊ID
	 * @return String 0-非gcVip，1-价格分类VIP； 2-号别VIP； 3-价格与号别同时为VIP；4 -患者标签VIP
	 * @throws BizException
	 * @author zcm
	 */
	@Override
	public String getGcVipTp(String entId) throws BizException {
		GetGcVipTpBP getVipTpBP = new GetGcVipTpBP();
		return getVipTpBP.exec(entId);
	}

	/**
	 * 批量获取就诊的VIP类型
	 * 
	 * @param entIds 就诊ID集合
	 * @return map: key(就诊ID)，value(字符串类型，0-非gcVip，1-价格分类VIP； 2-号别VIP；
	 *         3-价格与号别同时为VIP；4 -患者标签VIP)
	 * @throws BizException
	 * @author zcm
	 */
	@Override
	public FMap batchGetGcVipTp(String[] entIds) throws BizException {
		BatchGetGcVipTpBP batchGetBP = new BatchGetGcVipTpBP();
		return batchGetBP.exec(entIds);
	}

	/**
	 * 判断就诊是否为高端商保
	 * 
	 * @param entId 就诊ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FBoolean isHpcg(String entId) throws BizException {
		CheckIsHpcgBP checkBP = new CheckIsHpcgBP();
		return checkBP.exec(entId);
	}

	/**
	 * 判断医保是否为高端商保
	 * 
	 * @param hpId 医保计划ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FBoolean isHpCmCl(String hpId) throws BizException {
		CheckIsHpCmClBP checkBP = new CheckIsHpCmClBP();
		return checkBP.exec(hpId);
	}

	/**
	 * 获取新生儿信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public NewbornDO getNewbornDO(String entId) throws BizException {
		GetMomEntInfoBP bp = new GetMomEntInfoBP();
		return bp.getNewbornDO(entId);
	}

	/**
	 * 通过母亲就诊id获取婴儿信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public NewbornDO[] getNewbornsByMomEntId(String entId) throws BizException {
		NbEP ep = new NbEP();
		return ep.getNbListByMomEnt(entId);
	}

	/**
	 * 通过科室id或病区id获取就诊账户
	 * 
	 * @param depId 科室id或病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnAccountDO[] getEnIpAccsByDepId(String depId) throws BizException {
		GetEnIpAccsByDepBP bp = new GetEnIpAccsByDepBP();
		return bp.exec(depId);
	}

	/**
	 * 获取门诊工作量
	 * 
	 * @param depId 科室id
	 * @param beginDate 开始时间
	 * @param enDate 结束时间
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	@Override
	public OpTotalInfoDTO[] getOpTotalInfo(String depId, FDate beginDate, FDate endDate) throws BizException {
		GetOpTotalInfoBP bp = new GetOpTotalInfoBP();
		OpTotalInfoDTO[] opInfoDTOs = bp.exec(depId, beginDate, endDate);
		return opInfoDTOs;
	}

	/**
	 * 获取住院工作量
	 * 
	 * @param depId 科室id
	 * @param beginDate 开始时间
	 * @param enDate 结束时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpTotalInfoDTO[] getIpTotalInfo(String sdDepTp, String depId, FDate beginDate, FDate endDate)
			throws BizException {
		GetIpTotalInfoBP bp = new GetIpTotalInfoBP();
		IpTotalInfoDTO[] ipInfoDTOs = bp.exec(sdDepTp, depId, beginDate, endDate);
		return ipInfoDTOs;
	}

	/**
	 * 根据就诊编码获取挂号信息 提供给费用
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO getRegInfoByEntId(String entId) throws BizException {
		GetRegInfoListBP regInfoBP = new GetRegInfoListBP();
		return regInfoBP.exec(entId);
	}

	/**
	 * 检查就诊是否持卡社保
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:22:37
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isHpCardst(String id_ent) throws BizException {
		return new CheckEntIsHpCardstBP().exec(id_ent);
	}

	/**
	 * 获取默认的患者医保分类
	 * 
	 * @return
	 */
	@Override
	public String getDefaultHpCard() {
		return EnParamUtils.getHpDefPatcaId();
	}

	/**
	 * 根据就诊id判断此次就诊是否是持卡
	 * 
	 * @author fanlq
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isHpCardEnt(String entId) throws BizException {
		CheckIsHpCardEntBP bp = new CheckIsHpCardEntBP();
		return bp.exec(entId);
	}

	/**
	 * 住院患者转出科室时间
	 * 
	 * @param id_ent 就诊id
	 * @param id_dep 科室id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDateTime getIPTransOutDate(String id_ent, String id_dep) throws BizException {
		GetIpTransOutDateBP bp = new GetIpTransOutDateBP();
		FDateTime dtEnd = bp.exec(id_ent, id_dep);
		return dtEnd;
	}

	/**
	 * 获取补号类型
	 * 
	 * @param entId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getSupplyTicketType(String entId, String aptId) throws BizException {
		SupplyTicketRuleBP rule = new SupplyTicketRuleBP();
		return rule.exec(entId, aptId);
	}

	/**
	 * 获取医保患者参合地编码
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getHpPatChareaCode(String entId) throws BizException {
		GetHpPatChareaCodeBP bp = new GetHpPatChareaCodeBP();
		return bp.exec(entId);
	}

	/**
	 * 获取患者住院登记医保信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpHpRegistDTO getIpHpRegist(String entId) throws BizException {
		GetIpHpRegistBP bp = new GetIpHpRegistBP();
		return bp.exec(entId);
	}
	/**
	 * 为ci提供判定是否是特需(国际专用)
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public FBoolean  GetSrvtpforCI(String entId) throws BizException{
		GetSrvtpforCIBP bp = new GetSrvtpforCIBP();
		return bp.exec(entId);
	}
	/**
	 * 获取排班信息
	 * 
	 * @param deptCode
	 *            科室编码
	 * @param resName
	 *            资源名称(模糊匹配)
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19

	@Override
	public SchInfoDTO[] getSchList(String deptCode, String resName,
			String beginDate, String endDate, String srvType, String chlType)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpPatAptDTO[] getPatOpAptList(String patCode, String beginDate,
			String endDate) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchInfoDTO[] getSchList(String deptCode, String resName, String beginDate, String endDate, String srvType,
			String chlType) throws BizException {
		GetSchListBP bp = new GetSchListBP();
		return bp.exec(deptCode, resName, beginDate, endDate, srvType, chlType);
	}
	/**
	 * 获取患者预约记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpPatAptDTO[] getPatOpAptList(String patCode, String beginDate, String endDate) throws BizException {
		GetPatOpAptListBP bp = new GetPatOpAptListBP();
		return bp.exec(patCode, beginDate, endDate);
	}
	/**
	 * 获取候诊队列
	 * 
	 * @param patCode
	 *            患者编码
	 * @param opTimes
	 *            就诊次数
	 * @param deptCode
	 *            科室编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpWaitQueDTO[] getWaitQue(String patCode, Integer opTimes, String deptCode) throws BizException {
		GetWaitQueBP bp = new GetWaitQueBP();
		return bp.exec(patCode, deptCode, opTimes,false);
	}

	/**
     * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
     * 
     * @param benId
     *            分诊台ID
     * @param code_entp
     *            就诊类型
     * @return
     * @throws BizException
     * @author liubin
     */
    @Override
    public TriageBenInfoDTO getTriageBenInfo(String benId, String code_entp) throws BizException {
        IEnQueQryService service = ServiceFinder.find(IEnQueQryService.class);
        return service.getTriageBenInfo(benId, code_entp);
    }

    /**
     * 得到分诊台的队列和站点信息信息，包括 队列或站点的分诊数和候诊数
     * 
     * @param dayslotId
     *            时间分组ID
     * @param benId
     *            分诊台ID
     * @return
     * @throws BizException
     * @author liubin
     */
    @Override
    public TriageQueSiteDTO[] getOpTriQueSite(String dayslotId, String benId) throws BizException {
        IEnQueQryService service = ServiceFinder.find(IEnQueQryService.class);
        return service.getOpTriQueSite(dayslotId, benId);
    }

    /**
     * 
     * 根据status状态获取待分诊的患者列表
     * 
     * @param benId
     *            分诊台ID
     * @param dayslotId
     *            时间分诊ID
     * @param status
     *            状态 参照枚举：EntQueStatus
     *            <ul>
     *            <li>[-1] 未到诊状态患者</li>
     *            <li>[0] 到诊状态患者</li>
     *            <li>[1] 分诊状态患者</li>
     *            <li>[2] 通知状态患者</li>
     *            <li>[3] 就诊状态患者</li>
     *            <li>[4] 全部状态患者（不包括未到诊患者）</li>
     *            <li>[5] 回诊状态患者</li>
     *            </ul>
     * @return
     * @throws BizException
     * @author liubin
     */
    @Override
    public TriageEntDTO[] getWaitingByBen(String benId, String dayslotId, int status) throws BizException {
        IEnQueQryService service = ServiceFinder.find(IEnQueQryService.class);
        TriageBenInfoDTO benInfo = service.getTriageBenInfo(benId, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
        return service.getWaitingByBen(benInfo, dayslotId, status);
    }

    /**
     * 得到分诊台的队列和站点信息信息，
     * 包括队列或站点的分诊数和候诊数
     * 
     * @param benId 分诊台ID
     * @param date 日期
     * @param dayslotId 日期分组Id
     * @param depId 科室ID
     * @param status
     * @return
     * @throws BizException
     */
    @Override
    public FMap getTriageSite(String benId, String dayslotId, String depId, int status) throws BizException {
        IEnQueQryService service = ServiceFinder.find(IEnQueQryService.class);
        TriageBenInfoDTO benInfo = service.getTriageBenInfo(benId, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
        return service.getTriageSite(benInfo, status);
    }
    /**
	 * 得到科室分诊台在线站点信息
	 * 
	 * @param dayslotId 时间分组ID
	 * @param benId 分诊台ID
	 * @param depId 科室id
	 * 
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public TriageQueSiteDTO[] getTriageQueSiteInfos(String dayslotId, String benId, String depId) throws BizException {
		IEnQueQryService service = ServiceFinder.find(IEnQueQryService.class);
        return service.getTriageQueSiteInfos( dayslotId , benId , depId);
	}
		
	/**
	 * 查询窗口队列
	 * @param queSiteId 窗口id
	 * @param statusList 查询的状态列表，21-配药   22-叫号   23-叫号未到   24-发药
	 * @param qryDate 查询日期
	 * @return 就诊队列集合
	 * @throws BizException
	 */
	@Override
	public EnQueueDO[] getEntQueList(String queSiteId,FArrayList statusList,FDate qryDate) throws BizException{
		IEnQueOutQryService service = ServiceFinder.find(IEnQueOutQryService.class);
		return service.getEntQueList(queSiteId, statusList, qryDate);
	}

	 /**
	  * 获取就诊状态
	  * @param entId
	  * @return
	  * @throws BizException
	  */
	@Override
	public String getOpSdStatus(String entId) throws BizException {
		GetOpSdStatusBP bp = new GetOpSdStatusBP();
		return bp.exec(entId);
	}

	/**
	 * 获取团检账户金额
	 * @param peCmpyId 团检记录id
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/04
	 */
	public BalanceDTO getPeCmpyBalance(String peCmpyId) throws BizException{
		GetPeCmpyBalanceBP bp = new GetPeCmpyBalanceBP();
		return bp.exec(peCmpyId);
	}

	/**
	 * 获取门诊基本信息
	 * 
	 * @param patCode
	 *            就诊患者编码
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	public OpBasicDTO[] getOpBasicInfoByPatId(String patCode, String beginDate,String endDate) throws BizException{
		GetOpBasicInfoByPatIdBP bp = new GetOpBasicInfoByPatIdBP();
		return bp.getInfo(patCode, beginDate, endDate);
	}
	/***
	 * 患者导医系统--获取就诊科室、人员信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptPsndocDTO[] getHosGuideDeptBase(String pyCode) throws BizException{
		GetHosGuideDeptBaseBP bp = new GetHosGuideDeptBaseBP();
		return bp.exec(pyCode);
	}
	/***
	 * 患者导医系统--获取人员信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public GuidePsnInfo[] getGuidePsnBase(String id_dep) throws BizException{
		GetGuidePsnBaseBP bp = new GetGuidePsnBaseBP();
		return bp.exec(id_dep);
	}
}
