package iih.sc.scp.s;

import iih.sc.scp.aidset.d.ScplanaidsetAggDO;
import iih.sc.scp.dto.d.MtPlWkBriefDTO;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.dto.d.MtSchPlTreeDTO;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.dto.d.OralPlTickDTO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.i.IScScpQryService;
import iih.sc.scp.s.bp.GetIdxWeekByPlanBp;
import iih.sc.scp.s.bp.GetOralPlanOptSrvBP;
import iih.sc.scp.s.bp.GetOralPlanWeekBP;
import iih.sc.scp.s.bp.GetPlTickSrvNameListBp;
import iih.sc.scp.s.bp.GetScPlMtTreeBp;
import iih.sc.scp.s.bp.GetScPlNameBP;
import iih.sc.scp.s.bp.GetScPlWeekDOBp;
import iih.sc.scp.s.bp.mt.GetMtPlWeekBP;
import iih.sc.scp.s.bp.mt.GetMtPlWkBriefBP;
import iih.sc.scp.s.bp.mt.GetMtSchPlTreeBP;
import iih.sc.scp.s.bp.op.AnalysisEntEmpRecBP;
import iih.sc.scp.s.bp.oral.GetOralPlBP;
import iih.sc.scp.s.bp.oral.GetOralPlWeekBP;
import iih.sc.scp.s.ep.AidSetEP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 排班计划查询服务
 * 
 * @author zhouliming
 * @author liubin
 */
@Service(serviceInterfaces = { IScScpQryService.class }, binding = Binding.JSONRPC)
public class ScScpQryServiceImpl implements IScScpQryService {

	/**
	 * 医技排班计划树模型列表
	 * 
	 * @return List
	 * @throws BizException
	 * @author zhouliming
	 */
	@Override
	public List getScPlMtTreeBp() throws BizException {
		GetScPlMtTreeBp bp = new GetScPlMtTreeBp();
		return bp.exec();
	}

	/**
	 * 根据计划id求计划下面的周数
	 * 
	 * @param id_scpl 计划id
	 * @return Integer[] 周计划下面的周arrays
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public Integer[] getIdxWeekByPlan(String id_scpl) throws BizException {
		GetIdxWeekByPlanBp byPlanBp = new GetIdxWeekByPlanBp();
		return byPlanBp.exec(id_scpl);
	}

	/**
	 * 根据条件查询周计划
	 * 
	 * @param id_scpl 计划id
	 * @param weekNo 星期数
	 * @param idx_week 周数
	 * @param id_dayslot 午别
	 * @throws BizException
	 */
	@Override
	public ScplweekAggDO[] GetScPlWeekDO(String id_scpl, String weekNo, Integer idx_week, String id_dayslot,
			String currentWeekScplId) throws BizException {
		GetScPlWeekDOBp bp = new GetScPlWeekDOBp();
		return bp.exec(id_scpl, weekNo, idx_week, id_dayslot, currentWeekScplId);
	}

	/**
	 * 获取除主服务之外服务项目
	 * 
	 * @param id_scplweek 周计划id
	 * @param id_scsrv 排班计划服务id
	 * @return
	 * @throws BizException
	 */
	@Override
	public List<String> getPlTickSrvNameList(String id_scplweek, String id_scsrv) throws BizException {
		GetPlTickSrvNameListBp bp = new GetPlTickSrvNameListBp();
		return bp.exec(id_scplweek, id_scsrv);
	}

	/**
	 * 获取医技排班计划树
	 * 
	 * @param depId 科室id
	 * @param sctp 排班类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtSchPlTreeDTO[] getMtSchPlTree(String depId, String sctp) throws BizException {
		GetMtSchPlTreeBP getbp = new GetMtSchPlTreeBP();
		return getbp.exec(depId, sctp);
	}

	/**
	 * 按照规则引擎设置计划名称
	 * 
	 * @param srvId
	 * @param resId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getScPlName(String depId, String srvId, String resId) throws BizException {
		GetScPlNameBP getscPlNameBP = new GetScPlNameBP();
		return getscPlNameBP.exec(depId, srvId, resId);
	}

	/**
	 * 根据计划id查询周计划
	 * 
	 * @param scplId 计划ID
	 * @param tickmd 号位模式
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtPlWkBriefDTO[] getMtPlWkBriefList(String scplId, String tickmd) throws BizException {
		GetMtPlWkBriefBP getMtPlWkDTOBP = new GetMtPlWkBriefBP();
		return getMtPlWkDTOBP.exec(scplId, tickmd);
	}

	/**
	 * 查找周计划的详细信息
	 * 
	 * @param plScWeekId 周计划id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtPlWkDTO getMtPlWeek(String plScWeekId) throws BizException {
		GetMtPlWeekBP getMtPlWeekBP = new GetMtPlWeekBP();
		return getMtPlWeekBP.exec(plScWeekId);
	}

	/* =====================口腔=========================== */

	/**
	 * 根据口腔科排班计划获取口腔科排班周计划和备选服务
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班周计划数据和备选服务的数据Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public Map<String, Map<String, Object>> getOralPlanWeekDatas(String id_scpl) throws BizException {
		return new GetOralPlanWeekBP().exec(id_scpl);
	}

	/**
	 * 根据排班计划id获取口腔科排班计划备选服务
	 *
	 * @param id_scpl 排班计划id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScPlOptSrvDO[] getOralPlanOptSrv(String id_scpl) throws BizException {
		return new GetOralPlanOptSrvBP().exec(id_scpl);
	}

	/**
	 * 获取口腔排班计划
	 * 
	 * @param plId 排班计划ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public OralPlDTO getOralPl(String plId) throws BizException {
		GetOralPlBP bp = new GetOralPlBP();
		return bp.exec(plId);
	}

	/**
	 * 获取口腔周计划
	 * 
	 * @param scplId
	 * @param deptParamId
	 * @return
	 * @throws BizException
	 */
	@Override
	public OralPlTickDTO[] getOralPlTick(String scplId, String deptParamId) throws BizException {
		GetOralPlWeekBP bp = new GetOralPlWeekBP();
		return bp.getOralPlTick(scplId, deptParamId);
	}
	/**
	 * 排班是否被使用
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	public boolean validateIsPlUsed(String plId) throws BizException{
		ScplEp schEP = new ScplEp();
		return schEP.isPlUsed(plId);
	}

	/**
	 * 分析计划医生接诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-08 19:00:04
	 *
	 * @param id_scpl
	 * @param d_b
	 * @param d_e
	 * @param id_dayslot
	 * @param minVal
	 * @param maxVal
	 * @param fg_plself
	 * @return
	 */
	@Override
	public ScAidSetDTO[] analysisEntEmpRec(String id_scpl, FDate d_b, FDate d_e, String id_dayslot, int minVal,
			int maxVal, FBoolean fg_plself) throws BizException {
		return new AnalysisEntEmpRecBP().exec(id_scpl, d_b, d_e, id_dayslot, minVal, maxVal, fg_plself);
	}

	/**
	 * 根据计划ID查询样本设置主DO
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 16:19:53
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScplanaidsetAggDO getAggAidSetByPl(String id_scpl) throws BizException {
		return new AidSetEP().getAggAidSetByPl(id_scpl);
	}
}
