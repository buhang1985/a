package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.sc.comm.IScConst;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.AnalyseResult;
import iih.sc.sch.dto.d.OpSchTplDTO;
import iih.sc.sch.dto.d.PlanGenResult;
import iih.sc.sch.dto.d.SchKey;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量生成排班
 * 
 * 数据量估算： 通常情况：一个午别50个号，一天有2个午别，一个月30天，一个科室20个医生，一个医院50个门诊科室 一个科室20个计划，全院1000个计划
 * 一个计划排一个月的，排班信息：60个，号位信息：3000个 一个科室排一个月的，排班信息：1200个，号位信息：6万个
 * 全科科室排一个月的，排班信息：6万个，号位信息：300万个 同时保存这么大数据也有问题
 * 
 * @author yankan
 * @since 2017-05-25
 *
 */
public class BatchGenOpSchBP {
	// 分批步长
	private Integer step;

	/**
	 * 默认构造函数
	 */
	public BatchGenOpSchBP() {
	}

	/**
	 * 构造函数
	 * 
	 * @param step 分批步长
	 */
	public BatchGenOpSchBP(Integer step) {
		this.step = step;
	}

	/**
	 * 批量生成多计划的排班，按同一套模板
	 * 
	 * @param planIds 排班计划ID
	 * @param schTpls 排班模板
	 * @param fgCover 是否覆盖
	 * @throws BizException
	 */
	public void exec(String[] planIds, OpSchTplDTO[] schTpls, FBoolean fgCover) throws BizException {
		// 参数校验
		ScValidator.validateParam("计划ID", planIds);
		ScValidator.validateParam("排班模板", schTpls);
		
		if (this.step==null || this.step <= 10) {
			this.step = IScConst.SC_SCH_BATCH_GENERATE_STEP;//取默认步长
		}

		int length = planIds.length;
		int current = 0;
		while (current < length) {
			String[] subPlIds = ScCollectionUtils.subArray(planIds, current, this.step);
			if(ArrayUtil.isEmpty(subPlIds)){break;}
			this.batchGenOpSch(subPlIds, schTpls, fgCover);
			current += subPlIds.length;
		}
	}

	/**
	 * 批量生成多计划的排班，按同一套模板
	 * 
	 * @param planIds 排班计划ID
	 * @param tpls 排班模板
	 * @param fgCover 是否覆盖
	 * @throws BizException
	 */
	private void batchGenOpSch(String[] planIds, OpSchTplDTO[] tpls, FBoolean fgCover) throws BizException {
		// 1、分析已有排班,并获取保留排班
		Map<SchKey, ScSchDO> excludeSchMap = this.analyseAndGetExcludeSch(planIds, tpls, fgCover);
		
		// 2、生成排班			
		ScPlanDO[] planDOList = this.getPlanList(planIds);
		if (ArrayUtil.isEmpty(planDOList))
			return;
		PlanGenResult result = new PlanGenResult();	
		GenOpSchBP genOpSchBP = new GenOpSchBP();
		for (ScPlanDO planDO : planDOList) {
			PlanGenResult tempResult = genOpSchBP.exec(planDO, tpls, excludeSchMap);
			result.append(tempResult);
		}
		
		// 3、删除可覆盖排班(如果计划不存在，则不删除)
		if(FBoolean.TRUE.equals(fgCover)){
			DeleteCoverSchBP deleteBP = new DeleteCoverSchBP();
			deleteBP.exec(result.getWillDelSchKeyList());
		}

		// 4、保存生成的排班数据
		SaveOpPlanGenResultBP saveResultBP = new SaveOpPlanGenResultBP();
		saveResultBP.exec(result);
		// 5、更新排班计划最大排班日期d_last_sch
		ServiceFinder.find(IScplanCudService.class).save(planDOList);
	}

	/**
	 * 分析已有排班
	 * @param planIds
	 * @param tpls
	 * @param fgCover
	 * @return
	 * @throws BizException
	 */
	private Map<SchKey, ScSchDO> analyseAndGetExcludeSch(String[] planIds, OpSchTplDTO[] tpls, FBoolean fgCover) throws BizException{
		//1、已有分析排班
		List<FDate> schDateList = this.getSchDateList(tpls);
		AnalyseExistedSchBP analyseBP = new AnalyseExistedSchBP();
		AnalyseResult analyseResult= analyseBP.exec(planIds, schDateList.toArray(new FDate[0]));

		// 2、处理需保留排班
		List<ScSchDO> excludeSchList = new ArrayList<ScSchDO>();
		if (FBoolean.TRUE.equals(fgCover)) {
			// 在这里可以删除排班，需求暂时保留以前排班，无计划的排班也不删除
			// 排除的排班等于不可删除的排班
			excludeSchList = analyseResult.getUsedOrPastSchList();
		} else {
			// 不覆盖排班，排除的排班等于已存在的所有排班
			excludeSchList = analyseResult.getExistedSchList();
		}
		Map<SchKey, ScSchDO> excludeSchMap = new HashMap<SchKey, ScSchDO>();
		for (ScSchDO schDO : excludeSchList) {
			SchKey key = new SchKey(schDO.getId_scpl(), schDO.getD_sch(), schDO.getId_dayslot());
			if(!excludeSchMap.containsKey(key)){
				excludeSchMap.put(key, schDO);
			}
		}
		return excludeSchMap;
	}
	/**
	 * 获取排班日期
	 * 
	 * @param tpls 排班模板
	 * @return
	 * @throws BizException
	 */
	private List<FDate> getSchDateList(OpSchTplDTO[] tpls) throws BizException {
		List<FDate> schDateList = new ArrayList<FDate>();
		for (OpSchTplDTO schTplDTO : tpls) {
			schDateList.add(schTplDTO.getDate());
		}
		return schDateList;
	}

	/**
	 * 获取计划集合
	 * 
	 * @param planIds 计划ID集合
	 * @return 计划DO集合
	 * @throws BizException
	 */
	private ScPlanDO[] getPlanList(String[] planIds) throws BizException {
		IScplanRService planRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO[] planDOList = planRService.findByIds(planIds, FBoolean.TRUE);
		return planDOList;
	}

}
