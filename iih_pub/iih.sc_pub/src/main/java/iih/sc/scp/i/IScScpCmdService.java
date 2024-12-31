package iih.sc.scp.i;

import iih.sc.scp.dto.d.MtPLDaysDTO;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 排班计划命令接口
 * 
 * @author zhouliming
 *
 */
public interface IScScpCmdService {
	/**
	 * 保存或修改一条周计划
	 * 
	 * @param weekDO
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void savePlanWeek(ScPlanWeekDO[] weekDO, String Sd_tickmd) throws BizException;

	/**
	 * 复制一条周计划
	 * 
	 * @param id_scplweek
	 * @param weekNum 周期数
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void copyPlanWeek(String id_scplweek, String weekNum, String Sd_tickmd) throws BizException;

	/**
	 * 删除一条周计划
	 * 
	 * @param palnweekid
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void delPlanWeek(String palnweekid, String Sd_tickmd) throws BizException;

	/**
	 * 批量调整计划
	 * 
	 * @param coverBool 是否覆盖
	 * @param list 勾选的位置集合
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @param Sd_tickmd 票号模式编码
	 * @throws BizException
	 */
	public void replaceScPlanWeek(String coverBool, List list, Map map, ScPlanWeekDO weekDO,String Sd_tickmd) 
	throws BizException;

	/**
	 * 批量调整医技排班计划
	 * 
	 * @param coverBool 是否覆盖
	 * @param aggDOs 需要删除的周计划
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @param Sd_tickmd 票号模式编码
	 * @throws BizException
	 */
	public void replaceScPlanMtWeek(String coverBool, List list, ScplweekAggDO[] aggDOs,ScPlanWeekDO weekDO, 
	String Sd_tickmd) throws BizException;

	/**
	 * 根据周计划id和票号模式删除号位或号段
	 * 
	 * @param id_scplweek_sets 周计划id集合
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void delScplWeekTickOrTicks(String id_scplweek_sets, String Sd_tickmd)throws BizException;

	/**
	 * 根据排班计划id删除排班计划及相关周计划
	 * 
	 * @param id_scpl
	 * @throws BizException
	 */
	public void delScplanById(String id_scpl) throws BizException;

	/**
	 * 删除某一周的周计
	 * 
	 * @param id_scpl 排班计划id
	 * @param Sd_tickmd 票号模式
	 * @param idx_week 周序号
	 * @throws BizException
	 */
	public void delScplMtWeeks(String id_scpl, Integer idx_week, String Sd_tickmd)throws BizException;
	/**
	 * 保存周计划
	 * @param 周计划
	 * @throws BizException
	 */
	MtPlWkDTO saveMtPlWeek(MtPlWkDTO mtPlWkDO)throws BizException;

	/**
	 * 删除医技计划
	 * @param scpl
	 * @param sv
	 * @throws BizException
	 */
	 void deleteMtPl(String scpl,FDateTime sv)throws BizException;
	 
	 /**
	  * 删除天计划
	  * @param id_scplWeek 
	  * @throws BizException
	  */
	 void deleteMtWkPl(String id_scplWeek,FDateTime sv) throws BizException;
	 
	 /**
	  * 删除周计划
	  * @param is_scpl  计划id
	  * @param idx_week 周序号
	  * @throws BizException
	  */
	 void deleteMtWkPls(String id_scpl,Integer idx_week ,FDateTime sv)throws BizException;
	 
	 /**
	  * 复制周计划到指定周的指定天
	  * @param id_scpl
	  * @throws BizException
	  */
	 void copyMtWkPls(String id_scplWeek, String sd_tickmd, MtPLDaysDTO[] mtPlDaysDTOs, FBoolean isCover) 
	 throws BizException;
	 
		/* ===================== 口腔 =========================== */
	/**
	 * 保存口腔科排班计划(轻量级)
	 *
	 * @param planDO 排班计划DO
	 * @param srvValStr 备选服务字符串（逗号隔开）
	 * @param datasMap 周计划、排班号位和排班渠道数据
	 * @throws BizException
	 * @author zhengcm
	 */
	public void saveOralPlan(ScPlanDO planDO, String srvValStr,Map<String, Map<String, Object>> datasMap) 
	throws BizException;

	/**
	 * 删除口腔科排班计划(轻量级)
	 *
	 * @param id_scpl 排班计划id
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteOralPlan(String id_scpl) throws BizException;
	/**
	 * 保存口腔排班计划
	 * @param oralPlDTO 口腔排班计划DTO
	 * @throws BizException
	 */
	OralPlDTO saveOralPl(OralPlDTO oralPlDTO) throws BizException;
	
	/**
	 * 删除口腔排班计划
	 * @param id_scpl 排班计划ID
	 * @throws BizException
	 */
	void deleteOralPl(String id_scpl) throws BizException;
	/**
	 * 保存辅助样本设置
	 * 
	 * @author zhengcm
	 * @date 2017-12-12 09:19:28
	 *
	 * @param setDTO
	 * @throws BizException
	 */
	public void saveAidSet(ScAidSetDTO setDTO) throws BizException;
}
