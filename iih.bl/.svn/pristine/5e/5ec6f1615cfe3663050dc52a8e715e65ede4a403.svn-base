package iih.bl.cg.s.cglogic.pkgbp;

import iih.bd.base.utils.MapUtils;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.s.cglogic.op.BlOpKeepAccountBP;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊预付费记账
 * @author ly 2018/11/29
 *
 */
public class ChareForOpPrepayOrBP {

	/**
	 * 门诊预付费记账
	 * 单患者医嘱记账封装
	 * @param patId 患者id
	 * @param ordIds 医嘱id数组
	 * @param srcFunc 费用产生功能点描述
	 * @return 记账明细
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlcgoepAggDO exec(String patId, String[] ordIds, String srcFunc) throws BizException{
	
		this.validate(patId, ordIds);
		
		//准备数据
		//医嘱服务数据
		List<OrdSrvDO> ordSrvList = BlCgDataUtil.getCiOrsrvDataForBl(ordIds);
		if(ListUtil.isEmpty(ordSrvList)){
			throw new BizException("门诊预付费记账:无可记账数据");
		}
		
		List<String> orsrvIdList = new ArrayList<String>();
		for (OrdSrvDO orsrvDO : ordSrvList) {
			if(FBoolean.TRUE.equals(orsrvDO.getFg_mm())){
				orsrvIdList.add(orsrvDO.getId_orsrv());
			}
		}
		
		Map<String, OrdSrvMmDO> orsrvmmMap = new HashMap<String, OrdSrvMmDO>();
		if(orsrvIdList.size() > 0){
			List<OrdSrvMmDO> orsrvmmList = BlCgDataUtil.getCiOrsrvmmData(orsrvIdList.toArray(new String[0]));
			orsrvmmMap = (Map<String, OrdSrvMmDO>)MapUtils.convertListToMap(orsrvmmList, OrdSrvMmDO.ID_ORSRV);
		}
		
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_CI_OR_SRV, ordSrvList);
		
		//记账
		BlOpKeepAccountBP bp = new BlOpKeepAccountBP();
		
		BlCgOpAccountSetDTO accSet = new BlCgOpAccountSetDTO();
		accSet.setSrcfunc_des(srcFunc);
		accSet.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		accSet.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);
		accSet.setFg_reserve(FBoolean.TRUE);
		
		List<BlCgAccountDTO> accList = new ArrayList<BlCgAccountDTO>();
		for (OrdSrvDO ordSrvDO : ordSrvList) {
			
			BlCgAccountDTO accDto = new BlCgAccountDTO();
			accDto.setId_ent(ordSrvDO.getId_en());
			accDto.setId_pat(patId);
			accDto.setId_srv(ordSrvDO.getId_srv());
			accDto.setId_or(ordSrvDO.getId_or());
			accDto.setId_orsrv(ordSrvDO.getId_orsrv());
			accDto.setFg_mm(ordSrvDO.getFg_mm());
			
			if(FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
				
				OrdSrvMmDO orsrvmmDO = orsrvmmMap.get(ordSrvDO.getId_orsrv());
				if(orsrvmmDO != null){
					accDto.setId_mm(orsrvmmDO.getId_mm());
					accDto.setId_pkgu_cur(orsrvmmDO.getId_pgku_cur());
				}
			}
			
			accDto.setId_unit_srv(ordSrvDO.getId_medu());
			accDto.setQuan(ordSrvDO.getQuan_total_medu());
			accDto.setId_dep_mp(ordSrvDO.getId_dep_mp());
			accDto.setId_dep_wh(ordSrvDO.getId_dep_wh());
			accDto.setEu_direct(BookRtnDirectEnum.CHARGE);
			
			accList.add(accDto);
		}
		
		BlCgAccountRltDTO rltDto = bp.exec(accList.toArray(new BlCgAccountDTO[0]), accSet);
		FArrayList arrList = rltDto.getCglist();
		BlcgoepAggDO aggDO = (BlcgoepAggDO)arrList.get(0);
		return aggDO;
	}
	
	/**
	 * 校验
	 * @param patId
	 * @param ordIds
	 * @throws BizException
	 */
	private void validate(String patId, String[] ordIds) throws BizException{
		
		if (StringUtil.isEmpty(patId)) {
			throw new BizException("门诊预付费记账:患者id为空");
		}
		
		if (ArrayUtil.isEmpty(ordIds)) {
			throw new BizException("门诊预付费记账:医嘱id为空");
		}
	}
}
