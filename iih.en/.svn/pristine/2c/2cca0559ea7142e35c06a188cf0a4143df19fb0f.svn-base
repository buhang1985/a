package iih.en.que.s;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.que.dto.d.EnEmpQueInfoDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.i.IEnQueQryService;
import iih.en.que.s.bp.AcptUtilsBP;
import iih.en.que.s.bp.CheckCrossDeptAcptBP;
import iih.en.que.s.bp.GetAcptEntBP;
import iih.en.que.s.bp.GetCallPatInfoBP;
import iih.en.que.s.bp.GetEnQueStatusBP;
import iih.en.que.s.bp.GetEntListByOperBP;
import iih.en.que.s.bp.GetOpTriQueSiteBP;
import iih.en.que.s.bp.GetPriceBP;
import iih.en.que.s.bp.GetQueBP;
import iih.en.que.s.bp.GetQueSiteByPcBP;
import iih.en.que.s.bp.GetTriageBenInfoBP;
import iih.en.que.s.bp.GetTriageEntBP;
import iih.en.que.s.bp.GetTriageQueSiteInfosBP;
import iih.en.que.s.bp.GetTriageSiteBP;
import iih.en.que.s.bp.GetTriagedWaitBP;
import iih.en.que.s.bp.GetWaitingByBenBP;
import iih.en.que.s.bp.op.qry.CheckListPvOrderAcptFgBP;
import iih.en.que.s.bp.op.qry.CheckPvOrderAcptFgBP;
import iih.en.que.s.bp.op.qry.GetDocAcptListBP;
import iih.en.que.s.bp.op.qry.GetNoRegTriageQueSiteBP;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import iih.en.que.s.bp.op.qry.benmgr.GetQueInfosBP;
import iih.en.que.s.bp.op.qry.benmgr.GetSiteEntStats4BenMgrBP;
import iih.en.que.s.bp.op.qry.benmgr.GetTriageSite4BenMgrBP;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 就诊队列查询服务实现
 * @author yank
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnQueQryService.class}, binding=Binding.JSONRPC)
public class EnQueQryServiceImpl implements IEnQueQryService {

	/*===============================分诊管理==================================*/
	
	/**
	 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
	 * 
	 * @param benId 分诊台ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public TriageBenInfoDTO getTriageBenInfo(String benId, String code_entp) throws BizException {
		GetTriageBenInfoBP bp = new GetTriageBenInfoBP();
		return bp.exec(benId, code_entp);
	}

	/**
	 * 
	 * 根据status状态获取待分诊的患者列表
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param dayslotId
	 * 		时间分诊ID
	 * @param status
	 * 		状态  参照枚举：EntQueStatus
	 * <ul>
	 * <li>[-1] 未到诊状态患者</li>
	 * <li>[0] 到诊状态患者</li>
	 * <li>[1] 分诊状态患者</li>
	 * <li>[2] 通知状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * <li>[4] 全部状态患者（不包括未到诊患者）</li>
	 * <li>[5] 回诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public TriageEntDTO[] getWaitingByBen(TriageBenInfoDTO triageInfo, String dayslotId, int status) throws BizException {
		GetWaitingByBenBP bp = new GetWaitingByBenBP();
		return bp.exec(triageInfo, dayslotId, status,null);
	}
	/**
	 * 根据status状态获取分诊台队列或站点的分诊详情
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param queIds
	 * 		门诊队列ID集合
	 * @param queSiteId
	 * 		医生工作站ID（可以为空）
	 * @param status
	 * 		状态
	 * <ul>
	 * <li>[0] 未分诊状态患者</li>
	 * <li>[1] 候诊状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public TriageEntDTO[] getTriagedWait(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId, int status) throws BizException {
		GetTriagedWaitBP bp = new GetTriagedWaitBP();
		return bp.exec(triageInfo, queIds, queSiteId, status);
	}
	/**
	 * 获取TriageEntDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriageEntDTO getTriageEnt(String entId) throws BizException {
		GetTriageEntBP bp = new GetTriageEntBP();
		return bp.getTriageEntByEntId(entId);
	}
	/**
	 * 得到分诊台的队列和站点信息信息，包括
	 * 队列或站点的分诊数和候诊数
	 * 
	 * @param dayslotId 
	 * 		时间分组ID
	 * @param benId 
	 * 		分诊台ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Deprecated
	@Override
	public TriageQueSiteDTO[] getOpTriQueSite(String dayslotId,String benId) throws BizException {
		GetOpTriQueSiteBP bp = new GetOpTriQueSiteBP();
		return bp.exec(dayslotId, benId);
	}
	/**
	 * 得到分诊台的队列和站点信息信息，
	 * 包括队列或站点的分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @param status
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getTriageSite(TriageBenInfoDTO triageInfo, int status) throws BizException {
		GetTriageSiteBP bp = new GetTriageSiteBP();
		return bp.exec(triageInfo, status);
	}
	/**
	 * 获取就诊队列状态
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getEnQueStatus(String entId) throws BizException {
		GetEnQueStatusBP bp = new GetEnQueStatusBP();
		return bp.exec(entId);
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
		GetTriageQueSiteInfosBP bp = new GetTriageQueSiteInfosBP();
		return bp.exec(dayslotId, benId, depId);
	}

	/*===============================门急诊医生接诊==================================*/
	
	/***
	 * 获取当前叫号患者信息
	 * @author fanlq 
	 * @param que
	 * @param queSiteDO
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO getCallPatInfo(QueDO que, QueSiteDO queSite, FDate date, String dayslotId) throws BizException{
		GetCallPatInfoBP bp = new GetCallPatInfoBP();
		return bp.exec(que,queSite,date,dayslotId);
	}
	
	/**
	 * 根据计算机的HostId，获取工作站点
	 * 
	 * @param hostId 
	 * 		计算机注册时唯一标识符
	 * @return 
	 * 		工作站点DO
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public QueSiteDO getQueSiteByPc(String hostId) throws BizException {
		GetQueSiteByPcBP bp = new GetQueSiteByPcBP();
		return bp.exec(hostId);
	}

	/**
	 * 找到医生出诊队列
	 * 
	 * @param siteInfo 站点信息
	 * @return 
	 * 		出诊队列DO
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public QueDO[] getQue(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		GetQueBP bp = new GetQueBP();
		return bp.exec(siteInfo);
	}
	/**
	 * 是否可刷卡接诊该患者
	 * @param entId 
	 * 		就诊ID
	 * @param site 
	 * 		当前出诊站点
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public ResultDTO checkAcptByCard(String entId, QueSiteDO site, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		AcptUtilsBP bp = new AcptUtilsBP();
		return bp.isAcptable(entId, site, FBoolean.FALSE, FBoolean.FALSE, siteInfo);
	}
	/**
	 * 是否可以跨科接诊
	 * 
	 * @param regDepId 挂号科室
	 * @param acptDepId 接诊科室
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultDTO checkCrossDeptAcpt(String regDepId, String acptDepId)
			throws BizException {
		CheckCrossDeptAcptBP bp = new CheckCrossDeptAcptBP();
		return bp.exec(regDepId, acptDepId);
	}
	/**
	 * 获取队列情况
	 * @param siteInfo 站点信息
	 * @return key: 挂号REG,已诊ACPT,候诊WAIT,待回诊NEEDRTN；value为相应的数量
	 * @throws BizException
	 */
	@Override
	public FMap getSiteEntStats(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		GetSiteEntStats4BenMgrBP bp = new GetSiteEntStats4BenMgrBP();
		return bp.getSiteEntStats(siteInfo);
	}
	/**
	 * 门急诊医生站获取历史就诊列表
	 * 
	 * @param pg 分页信息
	 * @param nodeDTO 查询条件
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<ReceptionQueDTO> getEntListByOper(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException {
		GetEntListByOperBP bp = new GetEntListByOperBP();
		return bp.getEntListByOper(qryNode, pg);
	}
	/**
	 * 获取未挂号分诊队列站点信息
	 * 
	 * @param benInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriageQueSiteDTO[] getNoRegTriageQueSite(TriageBenInfoDTO benInfo) throws BizException {
		GetNoRegTriageQueSiteBP bp = new GetNoRegTriageQueSiteBP();
		return bp.exec(benInfo);
	}
	
	/**
	 * 接诊的时候判定价格
	 * @param opRegPat
	 * @param regRes
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO getPriceForReg(OpRegPatDTO opRegPat, RegResDTO regRes,String endId)throws BizException{
		GetPriceBP bp = new GetPriceBP();
		return bp.exec(opRegPat, regRes, endId);
	}
	
    /**
     * 接诊时判断是否可以顺序接诊（刷卡模式）
     * 
     * @param opReg
     * @param que
     * @param queSiteDO
     * @param dayslotId
     * @return
     * @throws BizException
     */
	@Override
	public ResultDTO checkPvOrderAcptFg(OpRegDTO opReg, QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		CheckPvOrderAcptFgBP bp = new CheckPvOrderAcptFgBP();
		return bp.exec(opReg, que, queSiteDO, siteInfo);
	}
    /**
     * 接诊时判断是否可以顺序接诊(列表模式)
     * 
     * @param entId
     * @param benId
     * @param type
     * @return
     * @throws BizException
     */
	@Override
	public ResultDTO checkListPvOrderAcptFg(String entId, String benId, String type) throws BizException {
		CheckListPvOrderAcptFgBP bp = new CheckListPvOrderAcptFgBP();
		return bp.exec(entId, benId, type);
	}
	
	/**********************************分诊台管理队列************************************/
	/**
     * 获取科室队列信息
     * 
     * @param depId
     * @param quebenId
     * @param date
     * @return
     */
	@Override
	public EnEmpQueInfoDTO[] getQueInfos(String depId, String quebenId, FDate date) throws BizException {
		GetQueInfosBP bp = new GetQueInfosBP();
		return bp.exec(depId, quebenId, date);
	}
	/**
	 * 得到分诊台的队列和站点信息信息，
	 * 包括队列或站点的分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @param status
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getTriageSite4BenMgr(TriageBenInfoDTO triageInfo, int status) throws BizException {
		GetTriageSite4BenMgrBP bp = new GetTriageSite4BenMgrBP();
		return bp.exec(triageInfo, status);
	}
	/**
	 * 找到医生出诊队列(队列管理)
	 * 
	 * @param siteInfo 
	 * 		站点信息
	 * @return 出诊队列DO
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public QueDO[] getQue4QueMgr(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		GetQue4BenMgrBP bp = new GetQue4BenMgrBP();
		return bp.exec(siteInfo);
	}
	
	/**
	 * 获取医生站患者列表
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param siteInfo
	 * @param type 列表类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public ReceptionQueDTO[] getDocAcptList(QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo, String type) throws BizException {
		GetDocAcptListBP bp = new GetDocAcptListBP();
		return bp.exec(que, queSiteDO, siteInfo, type);
	}
	/**
	 * 根据id_ent获取ReceptionQueDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public ReceptionQueDTO getReceptionQueByEntId(String entId)
			throws BizException {
		GetAcptEntBP bp = new GetAcptEntBP();
		List<ReceptionQueDTO> list = bp.getAcptEnt(entId);
		if(EnValidator.isEmpty(list)){
			return null;
		}
		return list.get(0);
	}
	
	/**********************************分诊台管理队列************************************/
}
