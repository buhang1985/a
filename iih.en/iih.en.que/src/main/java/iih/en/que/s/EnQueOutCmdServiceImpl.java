package iih.en.que.s;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayPmItemDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.i.IEnQueOutCmdService;
import iih.en.que.s.bp.ChangeDrugSiteBP;
import iih.en.que.s.bp.OpAutoTriageBP;
import iih.en.que.s.bp.ReceiveBP;
import iih.en.que.s.bp.RegAndAcptBP;
import iih.en.que.s.bp.calcpri.UpdateEntLevelPriBP;
import iih.en.que.s.bp.op.DrugCallNumBP;
import iih.en.que.s.bp.op.DrugSelectCallNumBP;
import iih.en.que.s.bp.op.RemoveEnQueBP;
import iih.en.que.s.bp.pharm.DispenseByQueBP;
import iih.en.que.s.bp.pharm.JoinPhramQueBP;
import iih.en.que.s.bp.pharm.SetSiteStatusBP;
import iih.en.que.s.event.AllQueEvent;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 药房队列服务
 * @author yankan
 * @since date 2015-11-20
 *
 */
@Service(serviceInterfaces={IEnQueOutCmdService.class}, binding=Binding.JSONRPC)
public class EnQueOutCmdServiceImpl implements IEnQueOutCmdService {	
	/**
	 * 加入配药队列(第三方分窗口)
	 * 
	 * @param entId 就诊id
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @param questatus_new 加入队列中的状态,默认为20-签到， 20-签到 21-配药 22-叫号 23-叫号未到 24-发药
	 * @return 返回队列DO和站点DO
	 * @throws BizException
	 */
	public FMap addDispenseQueWithSite(String entId, String presId, String pharmDepId, String questatus_new,String name_site)
			throws BizException {
		JoinPhramQueBP joinBP = new JoinPhramQueBP();
		return joinBP.addQueDispens(entId, presId, pharmDepId, questatus_new,name_site);
	}
	/**
	 * 加入配药队列
	 * @param entId 就诊id
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @param questatus_new 加入队列中的状态,默认为20-签到， 20-签到   21-配药   22-叫号   23-叫号未到   24-发药
	 * @return 返回队列DO和站点DO,对应的key: enque,quesite
	 * @throws BizException
	 */
	@Override
	public FMap addDispenseQue(String entId,String presId,String pharmDepId,String questatus_new) throws BizException{
		JoinPhramQueBP joinBP = new JoinPhramQueBP();
		return joinBP.addQueDispens(entId, presId, pharmDepId, questatus_new);
	}
	/**
	 * 队列配药发药
	 * @param entId 就诊id
	 * @param presIdList 处方id集合
	 * @param queSiteId 窗口id
	 * @param operTp 操作类型   21-配药   22-叫号   23-叫号未到   24-发药
	 * @throws BizException
	 */
	@Override
	public void queDispense(String entId,FArrayList presIdList,String queSiteId,String operTp) throws BizException{
		DispenseByQueBP dispenseBP = new DispenseByQueBP();
		dispenseBP.exec(entId, presIdList, queSiteId, operTp);
	}
	/**
	 * 设置药房站点状态
	 * @param pcId 计算机id
	 * @param quesiteTp 工作站类型，01-门诊医生站    02-住院医生站    11-医技工作站   20 发药工作点 ，21 配药工作点
	 * @param newStatus 状态   0 离线，1 在线，2 暂停
	 * @param empId 操作员id
	 * @param dtOpr 操作时间
	 * @throws BizException
	 */
	@Override
	public void setPharmSiteStatus(String pcId,String quesiteTp,Integer newStatus,String empId,FDateTime dtOpr) throws BizException{
		SetSiteStatusBP setBP = new SetSiteStatusBP();
		setBP.exec(pcId, quesiteTp, newStatus, empId, dtOpr);
	}
	/**
	 * 更新患者的队列优先级
	 * 
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void updateEntLevelPri(String entId) throws BizException {
		UpdateEntLevelPriBP bp = new UpdateEntLevelPriBP();
		bp.exec(entId);
	}
	
	
	/**
	 * 自动给一个患者分诊
	 * 
	 * @param triageInfo 分诊台
	 * @param entId 日期分组id
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public FMap autoTriagePat(TriageBenInfoDTO triageInfo, String entId) throws BizException {
		OpAutoTriageBP bp = new OpAutoTriageBP();
		return bp.exec2(triageInfo,entId);
	}

	/***
	 * 触发通用队列上下线事件
	 * @param quesiteId 站点id
	 * @param queId 队列id
	 * @param event 事件
	 * @throws BizException
	 */
	@Override
	public void invoke(String quesiteId,String queId,String id_queben,String event) throws BizException{
		AllQueEvent ev = new AllQueEvent();
		ev.exec(quesiteId, queId,null,null,id_queben, event);
	}
	/****
	 * 药房叫号-修改队列状态
	 * @param id_quesit
	 * @param event
	 * @param depParamValue 部门参数值
	 * @throws BizException
	 */
	@Override
	public String drugCallNum(String id_quesite,Integer callNum,Integer depParamValue) throws BizException{
		DrugCallNumBP bp = new DrugCallNumBP();
		return bp.exec(id_quesite,callNum,depParamValue);
	}
	/****
	 * 根据处方id移除药房队列
	 * @param id_quesit
	 * @param event
	 * @throws BizException
	 */
	@Override
	public void removeEnQue(String[] presIds) throws BizException{
		new RemoveEnQueBP().exec(presIds);
	}
	/***
	 * 药房选择叫号
	 * 
	 * @param id_ent
	 * @param id_pat
	 * @throws BizException
	 */
	@Override
	public FBoolean drugSelectCallNum(String id_ent,String Sortno) throws BizException{
		return new DrugSelectCallNumBP().exec(id_ent,Sortno);
	}
	/****
	 * @Description:改变发药窗口
	 * @param ids_ent_que  就诊队列ID
	 * @param id_que_site  站点ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public void changeDrugSite(String spletModel,String id_que_site,String[] presIds) throws BizException {
		new ChangeDrugSiteBP().exec(spletModel,presIds,id_que_site); 
	}
	/**
	 * 挂号接诊
	 * 
	 * @param opRegPat 患者信息
	 * @param queSite 医生出诊站点
	 * @param regRes 挂号资源
	 * @param dt_b  开始有效时间
	 * @return
	 * @throws BizException
	 * @author li.wm
	 */
	@Override
	public ReceptionQueDTO regAndAcpt(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs,FDateTime dt_b)
			throws BizException {
		return new RegAndAcptBP().exec2(opRegPat, queSite, regRes, reason,payPmItemDTOs,dt_b);
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
	 * @author li.wm
	 */
	@Override
	public FBoolean receive(String entId, QueSiteDO queSite, String dayslotId, RegResDTO regRes,String reason) throws BizException{
		return new ReceiveBP().exec(entId, queSite, dayslotId, regRes, reason);
	}
}
