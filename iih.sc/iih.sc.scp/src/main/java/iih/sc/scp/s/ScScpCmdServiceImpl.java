package iih.sc.scp.s;

import iih.sc.scp.dto.d.MtPLDaysDTO;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.i.IScScpCmdService;
import iih.sc.scp.s.bp.CopyPlanWeekBP;
import iih.sc.scp.s.bp.DelPlanWeekBP;
import iih.sc.scp.s.bp.DelScPlTickOrTicksBp;
import iih.sc.scp.s.bp.DelScplMtWeeksBp;
import iih.sc.scp.s.bp.DelScplanByIdBp;
import iih.sc.scp.s.bp.ReplaceScPlanMtWeekBP;
import iih.sc.scp.s.bp.ReplaceScPlanWeekBP;
import iih.sc.scp.s.bp.SaveMtPlWeekBP;
import iih.sc.scp.s.bp.SaveOralPlanBP;
import iih.sc.scp.s.bp.SavePlanWeekBP;
import iih.sc.scp.s.bp.mt.CopyMtWkPlsBP;
import iih.sc.scp.s.bp.mt.DeleteMtPlBP;
import iih.sc.scp.s.bp.mt.DeleteMtWkPlBP;
import iih.sc.scp.s.bp.mt.DeleteMtWkPlsBP;
import iih.sc.scp.s.bp.op.SaveAidSetBP;
import iih.sc.scp.s.bp.oral.DeleteOralPlanBP;
import iih.sc.scp.s.bp.oral.SaveOralPlBP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 保存或修改一条周计划
 * 
 * @author zhouliming
 */
@Service(serviceInterfaces = { IScScpCmdService.class }, binding = Binding.JSONRPC)
public class ScScpCmdServiceImpl implements IScScpCmdService {
	/**
	 * 保存或修改一条周计划
	 * 
	 * @param weekDO
	 * @param Sd_tickmd
	 * @throws BizException
	 * @throws ParseException
	 */
	@Override
	public void savePlanWeek(ScPlanWeekDO[] weekDO, String Sd_tickmd) throws BizException {
		SavePlanWeekBP bp = new SavePlanWeekBP();
		bp.exec(weekDO, Sd_tickmd);
	}

	/**
	 * 删除一条周计划
	 * 
	 * @param palnweekid
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	@Override
	public void delPlanWeek(String palnweekid, String Sd_tickmd) throws BizException {
		DelPlanWeekBP bp = new DelPlanWeekBP();
		bp.exec(palnweekid, Sd_tickmd);
	}

	/**
	 * 批量调整计划
	 * 
	 * @param coverBool 是否覆盖
	 * @param list 勾选的位置集合
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @throws BizException
	 * @throws ParseException
	 */
	@Override
	public void replaceScPlanWeek(String coverBool, List list, Map map, ScPlanWeekDO weekDO, String Sd_tickmd)
			throws BizException {
		ReplaceScPlanWeekBP bp = new ReplaceScPlanWeekBP();
		bp.exec(coverBool, list, map, weekDO, Sd_tickmd);
	}

	/**
	 * 复制一条周计划
	 * 
	 * @param id_scplweek 被复制的周计划id
	 * @param weekNum 周期数
	 * @param Sd_tickmd 票号模式
	 * @throws BizException
	 */
	@Override
	public void copyPlanWeek(String id_scplweek, String weekNum, String Sd_tickmd) throws BizException {
		CopyPlanWeekBP bp = new CopyPlanWeekBP();
		bp.exec(id_scplweek, weekNum, Sd_tickmd);
	}

	/**
	 * 批量调整医技计划
	 * 
	 * @param coverBool 是否覆盖
	 * @param list 勾选的位置集合
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @throws BizException
	 * @throws ParseException
	 */
	@Override
	public void replaceScPlanMtWeek(String coverBool, List list, ScplweekAggDO[] aggDOs, ScPlanWeekDO weekDO,
			String Sd_tickmd) throws BizException {
		ReplaceScPlanMtWeekBP bp = new ReplaceScPlanMtWeekBP();
		bp.exec(coverBool, list, aggDOs, weekDO, Sd_tickmd);
	}

	/**
	 * 根据周计划id和票号模式删除号位或号段
	 * 
	 * @param id_scplweek_sets 周计划id
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	@Override
	public void delScplWeekTickOrTicks(String id_scplweek_sets, String Sd_tickmd) throws BizException {
		DelScPlTickOrTicksBp bp = new DelScPlTickOrTicksBp();
		bp.exec(id_scplweek_sets, Sd_tickmd);
	}

	/**
	 * 根据排班计划id删除排班计划及相关周计划
	 * 
	 * @param id_scpl 排班计划id
	 * @throws BizException
	 */
	@Override
	public void delScplanById(String id_scpl) throws BizException {
		DelScplanByIdBp bp = new DelScplanByIdBp();
		bp.exec(id_scpl);
	}

	/**
	 * 删除某一周的周计划
	 * 
	 * @param id_scpl 排班计划id
	 * @param Sd_tickmd 票号模式
	 * @param idx_week 周序号
	 * @throws BizException
	 */
	@Override
	public void delScplMtWeeks(String id_scpl, Integer idx_week, String Sd_tickmd) throws BizException {
		DelScplMtWeeksBp bp = new DelScplMtWeeksBp();
		bp.exec(id_scpl, idx_week, Sd_tickmd);
	}

	/**
	 * 保存周计划
	 * 
	 * @param 周计划
	 * @throws BizException
	 */
	@Override
	public MtPlWkDTO saveMtPlWeek(MtPlWkDTO mtPlWkDO) throws BizException {
		SaveMtPlWeekBP saveBp = new SaveMtPlWeekBP();
		return saveBp.exec(mtPlWkDO);
	}

	/**
	 * 删除医技计划
	 * 
	 * @param scpl
	 * @param sv
	 * @throws BizException
	 */
	@Override
	public void deleteMtPl(String scpl, FDateTime sv) throws BizException {
		DeleteMtPlBP delMtBp = new DeleteMtPlBP();
		delMtBp.exec(scpl, sv);
	}

	/**
	 * 删除天计划
	 * 
	 * @param id_scplWeek
	 * @param sv 版本标识
	 * @throws BizException
	 */
	@Override
	public void deleteMtWkPl(String id_scplWeek, FDateTime sv) throws BizException {
		DeleteMtWkPlBP delBP = new DeleteMtWkPlBP();
		delBP.exec(id_scplWeek, sv);
	}

	/**
	 * 删除周计划
	 * 
	 * @param is_scpl 计划id
	 * @param idx_week 周序号
	 * @param sv 版本标识
	 * @throws BizException
	 */
	@Override
	public void deleteMtWkPls(String id_scpl, Integer idx_week, FDateTime sv) throws BizException {
		DeleteMtWkPlsBP delBP = new DeleteMtWkPlsBP();
		delBP.exec(id_scpl, idx_week, sv);
	}

	/**
	 * 复制周计划到指定周的指定天
	 * 
	 * @param id_scpl
	 * @throws BizException
	 */
	@Override
	public void copyMtWkPls(String id_scplWeek, String sd_tickmd, MtPLDaysDTO[] mtPlDaysDTOs, FBoolean isCover)
			throws BizException {
		CopyMtWkPlsBP copyMtPlsBp = new CopyMtWkPlsBP();
		copyMtPlsBp.exec(id_scplWeek, sd_tickmd, mtPlDaysDTOs, isCover);
	}

	/* ===================== 口腔 =========================== */

	/**
	 * 保存口腔科排班计划
	 *
	 * @param planDO 排班计划DO
	 * @param srvValStr 备选服务字符串（逗号隔开）
	 * @param datasMap 周计划、排班号位和排班渠道数据
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void saveOralPlan(ScPlanDO planDO, String srvValStr, Map<String, Map<String, Object>> datasMap)
			throws BizException {
		new SaveOralPlanBP().exec(planDO, srvValStr, datasMap);
	}

	/**
	 * 删除口腔科排班计划
	 *
	 * @param id_scpl 排班计划id
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void deleteOralPlan(String id_scpl) throws BizException {
		new DeleteOralPlanBP().exec(id_scpl);
	}

	@Override
	public OralPlDTO saveOralPl(OralPlDTO oralPlDTO) throws BizException {
		SaveOralPlBP bp = new SaveOralPlBP();
		return bp.exec(oralPlDTO);
	}

	@Override
	public void deleteOralPl(String id_scpl) throws BizException {
		DeleteOralPlanBP bp = new DeleteOralPlanBP();
		bp.exec(id_scpl);
	}

	/**
	 * 保存辅助样本设置
	 * 
	 * @author zhengcm
	 * @date 2017-12-12 09:19:28
	 *
	 * @param setDTO
	 * @throws BizException
	 */
	@Override
	public void saveAidSet(ScAidSetDTO setDTO) throws BizException {
		new SaveAidSetBP().exec(setDTO);
	}
}
