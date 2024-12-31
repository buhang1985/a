package iih.sc.scp.i;

import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scp.aidset.d.ScplanaidsetAggDO;
import iih.sc.scp.dto.d.MtPlWkBriefDTO;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.dto.d.MtSchPlTreeDTO;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.dto.d.OralPlTickDTO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 排班计划查询服务接口
 * 
 * @author zhouliming
 *
 */
public interface IScScpQryService {
	/**
	 * 医技排班计划树模型列表
	 * 
	 * @return List
	 * @throws BizException
	 */
	public List getScPlMtTreeBp() throws BizException;

	/**
	 * 根据计划id求计划下面的周数
	 * 
	 * @param id_scpl 计划id
	 * @return Integer[] 周计划下面的周arrays
	 * @throws BizException
	 */
	public Integer[] getIdxWeekByPlan(String id_scpl) throws BizException;

	/**
	 * 根据条件查询周计划
	 * 
	 * @param id_scpl 计划id
	 * @param weekNo 星期数
	 * @param idx_week 周数
	 * @param id_dayslot 午别
	 * @param currentWeekScplId 当前选中的周计划排除
	 * @throws BizException
	 */
	public ScplweekAggDO[] GetScPlWeekDO(String id_scpl, String weekNo, Integer idx_week,
			String id_dayslot,String currentWeekScplId) throws BizException;

	/**
	 * 获取除主服务之外服务项目
	 * 
	 * @param id_scplweek 周计划id
	 * @param id_scsrv 排班计划服务id
	 * @return
	 * @throws BizException
	 */
	public List<String> getPlTickSrvNameList(String id_scplweek, String id_scsrv)throws BizException;
	/**
	 * 获取医技排班计划树
	 * @param depId 科室id
	 * @param sctp 排班类型
	 * @return
	 * @throws BizException
	 */
    MtSchPlTreeDTO[] getMtSchPlTree(String depId, String sctp) throws BizException;
	
    /**
     * 按照规则引擎设置计划名称
     * @param srvId
     * @param resId
     * @return
     * @throws BizException
     */
    String getScPlName(String depId,String srvId,String resId) throws BizException;
    
	/**
	 * 根据计划id查询周计划
	 * 
	 * @param scplId 计划ID
	 * @param tickmd 号位模式
	 * @return
	 * @throws BizException
	 */
	 MtPlWkBriefDTO[] getMtPlWkBriefList(String scplId, String tickmd) throws BizException;
	
	/**
	 * 查找周计划的详细信息
	 * @param plScWeekId 周计划id
	 * @return
	 * @throws BizException
	 */
	 MtPlWkDTO getMtPlWeek(String plScWeekId) throws BizException;
	
	/* =====================口腔=========================== */
	/**
	 * 根据排班计划id获取口腔科排班计划备选服务
	 *
	 * @param id_scpl 排班计划id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlOptSrvDO[] getOralPlanOptSrv(String id_scpl) throws BizException;

	/**
	 * 根据口腔科排班计划获取口腔科排班周计划和备选服务
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班周计划数据和备选服务的数据Map
	 * @throws BizException
	 * @author zhengcm
	 */
	public Map<String, Map<String, Object>> getOralPlanWeekDatas(String id_scpl) throws BizException;
	
	/**
	 * 获取口腔排班计划
	 * @param plId 排班计划ID
	 * @return
	 * @throws BizException
	 */
	OralPlDTO getOralPl(String plId) throws BizException;
	/**
	 * 获取口腔周计划
	 * 
	 * @param scplId
	 * @param deptParamId
	 * @return
	 * @throws BizException
	 */
	OralPlTickDTO[] getOralPlTick(String scplId, String deptParamId) throws BizException;
	/**
	 * 排班是否被使用
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	 boolean validateIsPlUsed(String plId) throws BizException;
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
	public ScAidSetDTO[] analysisEntEmpRec(String id_scpl, FDate d_b, FDate d_e, String id_dayslot, int minVal,
			int maxVal, FBoolean fg_plself) throws BizException;

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
	public ScplanaidsetAggDO getAggAidSetByPl(String id_scpl) throws BizException;

}
