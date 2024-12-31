package iih.en.que.s;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.IEnConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnRuleUtils;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayPmItemDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.s.bp.ArriveBP;
import iih.en.que.s.bp.BatchLoginOpSiteBP;
import iih.en.que.s.bp.BatchLogoutOpSiteBP;
import iih.en.que.s.bp.CallNumOnDisplayBP;
import iih.en.que.s.bp.CancRecptBP;
import iih.en.que.s.bp.CancelCallNumBP;
import iih.en.que.s.bp.CancelSignInBP;
import iih.en.que.s.bp.CancelTriageBP;
import iih.en.que.s.bp.ChangeLevelPriBP;
import iih.en.que.s.bp.LoginOpSiteBP;
import iih.en.que.s.bp.LogoutOpSiteBP;
import iih.en.que.s.bp.OpAutoTriageBP;
import iih.en.que.s.bp.PassNumBP;
import iih.en.que.s.bp.ReceiveBP;
import iih.en.que.s.bp.RegAndAcptBP;
import iih.en.que.s.bp.SelEntToCallNumBP;
import iih.en.que.s.bp.SetEntFirstOrRtnBP;
import iih.en.que.s.bp.SiteOffLineBP;
import iih.en.que.s.bp.TriageToSiteBP;
import iih.en.que.s.bp.op.NoRegTriageBP;
import iih.en.que.s.bp.op.NoRegTriageTakeNoBP;
import iih.en.que.s.bp.op.cmd.benmgr.CancelQueTriageBP;
import iih.en.que.s.bp.op.cmd.benmgr.CreateQueEmpsBP;
import iih.en.que.s.bp.op.cmd.benmgr.OpCallNumHandle;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 就诊队列命令服务
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IEnQueCmdService.class }, binding = Binding.JSONRPC)
public class EnQueCmdServiceImpl implements IEnQueCmdService {

	/**
	 * 分诊到诊
	 * 
	 * @param opReg 患者挂号信息
	 * @param triageInfo 分诊台信息
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void arrive(OpRegDTO opReg, TriageBenInfoDTO triageInfo) throws BizException {
		ArriveBP bp = new ArriveBP();
		bp.exec(opReg, triageInfo);
	}

	/**
	 * 撤销到诊
	 * 
	 * @param entQueId 就诊队列id
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void cancelSignIn(String entQueId) throws BizException {
		CancelSignInBP bp = new CancelSignInBP();
		bp.exec(entQueId);
	}

	/**
	 * 分诊到站点
	 * 
	 * @param triageQueSite 分诊台队列或工作站点DTO
	 * @param entQueId 就诊队列ID
	 * @param isForceTriage 是否是强制分诊
	 * @author liubin
	 */
	@Override
	public void triageToSite(TriageQueSiteDTO triageQueSite, String entQueId, FBoolean isForceTriage, TriageBenInfoDTO triageInfo) throws BizException {
		TriageToSiteBP bp = new TriageToSiteBP();
		bp.exec(triageQueSite, entQueId, FBoolean.FALSE, isForceTriage, triageInfo, null);
	}

	/**
	 * 自动分诊
	 * 
	 * @param benId 分诊台
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void autoTriage(TriageBenInfoDTO triageInfo) throws BizException {
		OpAutoTriageBP bp = new OpAutoTriageBP();
		bp.exec(triageInfo);
	}
	/**
	 * 取消分诊
	 * 
	 * @param entQueId 就诊队列ID
	 * @param manual 自动分诊下设为true
	 * @author liubin
	 */
	@Override
	public void cancelTriage(String entQueId, FBoolean manual) throws BizException {
		CancelTriageBP bp = new CancelTriageBP();
		bp.exec(entQueId, manual);
	}

	/**
	 * 站点叫号
	 * 
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public EnQueueDO callNum(EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException {
		OpCallNumHandle bp = new OpCallNumHandle();
		return bp.callNum(siteInfo, entId, callNum);
	}

	/**
	 * 站点叫下一个
	 * 
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public EnQueueDO callNextNum(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		OpCallNumHandle bp = new OpCallNumHandle();
		return bp.callNextNum(siteInfo);
	}

	/**
	 * 取消叫号
	 * 
	 * @param entQueId 患者就诊队列id
	 * @author liubin
	 */
	@Override
	public void cancelCallNum(String entQueId) throws BizException {
		CancelCallNumBP bp = new CancelCallNumBP();
		bp.exec(entQueId);
	}

	/**
	 * 改变优先级
	 * 
	 * @param entDTO
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void changeLevelPri(TriageEntDTO entDTO) throws BizException {
		ChangeLevelPriBP bp = new ChangeLevelPriBP();
		bp.exec(entDTO);
	}

	/**
	 * 门诊医生登录站点初始化
	 * 
	 * @param siteInfo 医生工作站信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public QueSiteDO loginOpSite(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		LoginOpSiteBP bp = new LoginOpSiteBP();
		return bp.exec(siteInfo);
	}

	/**
	 * 把在线的医生站点设置为离线
	 * 
	 * @param queSiteId
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO siteOffLine(String queSiteId, String codeEnTp) throws BizException {
		SiteOffLineBP bp = new SiteOffLineBP();
		return bp.exec(queSiteId, codeEnTp);
	}

	/**
	 * 医生退出工作站时，修改工作点信息
	 * 
	 * @param queSiteId 医生工作站ID
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void logoutOpSite(String queSiteId, String codeEnTp) throws BizException {
		LogoutOpSiteBP bp = new LogoutOpSiteBP();
		bp.exec(queSiteId, codeEnTp);
	}
	
	/**
	 * 叫号（只上屏，不改状态）
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public EnQueueDO callNumOnDisplay(QueDO que, QueSiteDO queSite, String entId,String enQueId) throws BizException {
		CallNumOnDisplayBP bp = new CallNumOnDisplayBP();
	    return bp.exec(que, queSite, entId,enQueId);
	}
	

	/**
	 * 叫号
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public EnQueueDO acptCallNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException {
		OpCallNumHandle bp = new OpCallNumHandle();
		return bp.acptCallNum(que, queSite, siteInfo, entId, callNum);
	}
	

	/**
	 * 选中患者叫号
	 * 
	 * @param rect 接诊DTO
	 * @param queSite
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnQueueDO selEntToCallNum(ReceptionQueDTO rect, QueDO que, QueSiteDO site, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		SelEntToCallNumBP bp = new SelEntToCallNumBP();
		return bp.exec(rect, que, site, siteInfo);
	}

	/**
	 * 叫下一个
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public EnQueueDO acptCallNextNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		OpCallNumHandle bp = new OpCallNumHandle();
		return bp.acptCallNextNum(que, queSite, siteInfo);
	}

	/**
	 * 过号
	 * 
	 * @param entQueId 就诊队列ID
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void passNum(String entQueId) throws BizException {
		PassNumBP bp = new PassNumBP();
		bp.exec(entQueId);
	}

	/**
	 * 接诊
	 * 
	 * @param entId 就诊ID
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @param dayslotId 接诊原因
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public FBoolean receive(String entId, QueSiteDO queSite, String dayslotId, RegResDTO regRes,String reason) throws BizException {
		ReceiveBP bp = new ReceiveBP();
		return bp.exec(entId, queSite, dayslotId, regRes,reason);
	}

	/**
	 * 挂号接诊
	 * 
	 * @param opRegPat 患者信息
	 * @param queSite 医生出诊站点
	 * @param regRes 挂号资源
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public ReceptionQueDTO regAndAcpt(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs)
			throws BizException {
		RegAndAcptBP bp = new RegAndAcptBP();
		return bp.exec(opRegPat, queSite, regRes, reason,payPmItemDTOs);
	}

	/**
	 * 取消接诊
	 * 
	 * @param empId 医生ID
	 * @param depId 科室ID
	 * @param entId 患者就诊ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public FBoolean cancRecpt(String empId, String depId, String entId) throws BizException {
		CancRecptBP bp = new CancRecptBP();
		return bp.exec(empId, depId, entId);
	}
	/**
	 * 设置患者为初诊或回诊
	 * 
	 * @param entId
	 * @param isFirst
	 * @throws BizException
	 */
	@Override
	public void setEntFirstOrRtn(String entId, FBoolean isFirst)
			throws BizException {
		SetEntFirstOrRtnBP bp = new SetEntFirstOrRtnBP();
		bp.exec(entId, isFirst);
	}
	/**
	 * 未挂号分诊
	 * 
	 * @param opRegPat
	 * @param queSiteInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public String noRegTriage(OpRegPatDTO opRegPat, TriageQueSiteDTO queSiteInfo)
			throws BizException {
		NoRegTriageBP bp = new NoRegTriageBP();
		return bp.exec(opRegPat, queSiteInfo);
	}
	/**
	 * 未挂号分诊模式预约取号
	 * 
	 * @param patId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpRegDTO noRegTriageTakeNo(String patId, String aptId) throws BizException {
		NoRegTriageTakeNoBP bp = new NoRegTriageTakeNoBP();
		return bp.exec(patId, aptId);
	}
	/**
	 * 批量上线
	 * 
	 * @param sites
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO[] batchLoginSite(QueSiteDO[] sites, String queId) throws BizException {
		BatchLoginOpSiteBP bp = new BatchLoginOpSiteBP();
		return bp.exec(sites, queId);
	}
	/**
	 * 批量下线
	 * 
	 * @param sites
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO[] batchLogoutSite(QueSiteDO[] sites) throws BizException {
		BatchLogoutOpSiteBP bp = new BatchLogoutOpSiteBP();
		return bp.exec(sites);
	}
	/**
	 * 自动生成队列出诊医生
	 * 
	 * @param benId
	 * @param date
	 * @throws BizException
	 */
	@Override
	public void createQueEmps(String benId, FDate date) throws BizException {
		CreateQueEmpsBP bp = new CreateQueEmpsBP();
		bp.exec(benId, date);
	}
	/**
	 * 取消队列分诊
	 * 
	 * @param benInfo
	 * @param queId
	 */
	@Override
	public void cancelQueTriage(TriageBenInfoDTO benInfo, String queId) throws BizException {
		CancelQueTriageBP bp = new CancelQueTriageBP();
		bp.exec(benInfo, queId);
	}
	/***
	 * @Description:挂号规则引擎
	 * @param opRegPat
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	@Override
    public ResultDTO validateOpRegRule(String[] code_pkgs,RegRuleDTO regRule) throws BizException{
		EnContextUtils.setCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS, true);
		return new EnRuleUtils().regRule(code_pkgs, regRule);
    }
	
}
