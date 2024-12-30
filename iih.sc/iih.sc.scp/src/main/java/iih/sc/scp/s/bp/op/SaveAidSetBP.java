package iih.sc.scp.s.bp.op;

import iih.sc.comm.ScContextUtils;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import iih.sc.scp.aidset.d.ScPlanAidSetDtlDO;
import iih.sc.scp.aidset.d.ScplanaidsetAggDO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.s.ep.AidSetEP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 保存辅助样本设置BP
 * 
 * @author zhengcm
 * @date 2017-12-12 09:16:48
 *
 */
public class SaveAidSetBP {

	/**
	 * 保存辅助样本设置
	 * 
	 * @author zhengcm
	 * @date 2017-12-12 09:16:38
	 *
	 * @param setDTO
	 * @throws BizException
	 */
	public void exec(ScAidSetDTO setDTO) throws BizException {
		if (null == setDTO) {
			return;
		}
		// 校验当前计划是否停用
		ScPlanDO planDO = new ScplEp().getScPl(setDTO.getId_scpl());
		if (null == planDO) {
			throw new BizException("当前计划不存在，请检查！");
		}
		if (!planDO.getFg_active().booleanValue()) {
			throw new BizException("当前计划已停用，不允许设置样本！");
		}
		AidSetEP setEP = new AidSetEP();
		// 删除已有的样本
		setEP.deleteAggAidSetByPl(setDTO.getId_scpl());
		// 最新样本
		ScplanaidsetAggDO aggDO = new ScplanaidsetAggDO();
		// 设置样本
		ScPlanAidSetDO headDO = new ScPlanAidSetDO();
		headDO.setStatus(DOStatus.NEW);
		headDO.setId_grp(ScContextUtils.getGrpId());
		headDO.setId_org(ScContextUtils.getOrgId());
		headDO.setId_scpl(setDTO.getId_scpl());
		headDO.setId_dayslot(setDTO.getId_dayslot());
		headDO.setD_b(setDTO.getD_b());
		headDO.setD_e(setDTO.getD_e());
		headDO.setVal_min(setDTO.getVal_min());
		headDO.setVal_max(setDTO.getVal_max());
		headDO.setEu_valtp(setDTO.getEu_valtp());
		headDO.setNum_avg_tick(setDTO.getNum());
		headDO.setFg_plself(setDTO.getFg_current());
		// 设置样本明细
		List<ScPlanAidSetDtlDO> bodyList = new ArrayList<ScPlanAidSetDtlDO>();
		FArrayList tickList = setDTO.getTicklist();
		if (null == tickList || tickList.size() <= 0) {
			throw new BizException("辅助样本明细为空，请检查！");
		}
		for (Object obj : tickList) {
			ScAidSetDTO dto = (ScAidSetDTO) obj;
			ScPlanAidSetDtlDO bodyDO = new ScPlanAidSetDtlDO();
			bodyDO.setStatus(DOStatus.NEW);
			bodyDO.setTickno(dto.getTickno());
			bodyDO.setPeriod(dto.getPeriod());
			bodyList.add(bodyDO);
		}
		aggDO.setParentDO(headDO);
		aggDO.setScPlanAidSetDtlDO(bodyList.toArray(new ScPlanAidSetDtlDO[0]));
		// 保存
		setEP.saveAggAidSet(new ScplanaidsetAggDO[] { aggDO });
	}

}
