package iih.en.pv.s.bp.ip.qry;

import iih.bl.cg.i.IBlOutQryService;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnLvDepCheckTpEnum;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.s.bp.ip.LvHosCheckBP;
import iih.mp.dg.dto.d.MedDetailsDTO;
import iih.mp.dg.i.IMpDgOutService;
import iih.mp.nr.dto.d.ParamDTO;
import iih.mp.nr.dto.d.PeStaDTO;
import iih.mp.nr.foreign.i.IForeignService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取出院核查明细
 * 
 * @author liubin
 *
 */
public class GetLvHosCheckDetailsBP {
	/**
	 * 规则引擎调用key
	 */
	private static String KEY_ENT_IDS = "idEnts";
	/**
     * 获取出院核查明细
     * 
     * @param lvAppsDto 出院记录
     * @param enLvDepCheckTp 核查类型：EnLvDepCheckTpEnum
     * @return
     */
	public FMap exec(LvHosAppDTO lvAppsDto, String[] enLvDepCheckTps) throws BizException{
		if(lvAppsDto == null || EnValidator.isEmpty(enLvDepCheckTps))
			return null;
		FMap map = new FMap();
		for(String enLvDepCheckTp : enLvDepCheckTps){
			switch (enLvDepCheckTp) {
			case EnLvDepCheckTpEnum.CHECK_OR:
				map.put(enLvDepCheckTp, execOr(lvAppsDto));
				break;
			case EnLvDepCheckTpEnum.CHECK_MP:
				map.put(enLvDepCheckTp, execMp(lvAppsDto));
				break;
			case EnLvDepCheckTpEnum.CHECK_MM:
				map.put(enLvDepCheckTp, execMm(lvAppsDto));
				break;
			case EnLvDepCheckTpEnum.CHECK_MT:
				map.put(enLvDepCheckTp, execMt(lvAppsDto));
				break;
			case EnLvDepCheckTpEnum.CHECK_BL:
				map.put(enLvDepCheckTp, execBl(lvAppsDto));
				break;
			case EnLvDepCheckTpEnum.CHECK_OTHER:
				map.put(enLvDepCheckTp, execOther(lvAppsDto));
				break;
			}
		}
		return map;
	}
	/**
	 * 获取医嘱明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execOr(LvHosAppDTO lvAppsDto) throws BizException {
		ICiOrdQryService serv = ServiceFinder.find(ICiOrdQryService.class);
		PatUnDoOrderdto[] ors = serv.GetPatUnDoOrderdto(LvHosCheckBP.assemlyOrParams(new LvHosAppDTO[]{lvAppsDto})[0]);
		return EnAppUtils.doArray2List(ors);
	}
	/**
	 * 获取执行明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMp(LvHosAppDTO lvAppsDto) throws BizException {
		ParamDTO[] params = LvHosCheckBP.assemlyMpSrvParams();
		if(EnValidator.isEmpty(params))
			return null;
		IForeignService serv = ServiceFinder.find(IForeignService.class);
		PeStaDTO[] results = serv.getOutChkDetail(LvHosCheckBP.assemlyMpParams(new LvHosAppDTO[]{lvAppsDto}, LvHosCheckBP.TECH_MP)[0], params, LvHosCheckBP.getCheckMtTp());
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取药品明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMm(LvHosAppDTO lvAppsDto) throws BizException {
		IMpDgOutService serv = ServiceFinder.find(IMpDgOutService.class);
		MedDetailsDTO[] results = serv.queryMedDetaisForPatiWhenOut(LvHosCheckBP.assemlyLvMmParams(new LvHosAppDTO[]{lvAppsDto})[0]);
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取医技明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMt(LvHosAppDTO lvAppsDto) throws BizException {
		ParamDTO[] params = LvHosCheckBP.assemlyMtSrvParams();
		if(EnValidator.isEmpty(params))
			return null;
		IForeignService serv = ServiceFinder.find(IForeignService.class);
		PeStaDTO[] results = serv.getOutChkDetail(LvHosCheckBP.assemlyMpParams(new LvHosAppDTO[]{lvAppsDto}, LvHosCheckBP.TECH_MT)[0], params, LvHosCheckBP.getCheckMtTp());
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取费用明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execBl(LvHosAppDTO lvAppsDto) throws BizException {
		FArrayList list = new FArrayList();
		//费用划价核查接口
		IBlOutQryService iblService = ServiceFinder.find(IBlOutQryService.class);
		FMap blMaps = iblService.getPatPriceByLast(LvHosCheckBP.assemlyBlCheckParams(new LvHosAppDTO[]{lvAppsDto}), FBoolean.TRUE);
		if(blMaps!=null && blMaps.containsKey(lvAppsDto.getId_ent())){
			List<BlIpOutPatPriDTO> blList = (List<BlIpOutPatPriDTO>) blMaps.get(lvAppsDto.getId_ent());
			if(!EnValidator.isEmpty(blList)){
				for(BlIpOutPatPriDTO bl : blList){
					if(bl.getFg_price()!=null && bl.getFg_price().booleanValue())
						continue;
					list.add(bl);
				}
			}
		}
		return list.size() > 0 ? list : null;
	}
	/**
	 * 获取其他明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execOther(LvHosAppDTO lvAppsDto) throws BizException {
		if(EnValidator.isEmpty(lvAppsDto.getId_ent()))
			return null;
		Map<String, Object> varies = new HashMap<String, Object>();
		varies.put(KEY_ENT_IDS, new String[]{lvAppsDto.getId_ent()});
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_LVHOSCHECK_CODE, varies);
		if(results != null){
			List<LvCheckOtherResultDTO> lvCheckOtherResults = new LinkedList<>();
			for(Entry<String, Object> result : results.entrySet()){
				LvCheckOtherResultDTO[] lvCheckOtherResultRules = (LvCheckOtherResultDTO[])result.getValue();
				if(!EnValidator.isEmpty(lvCheckOtherResultRules))
					lvCheckOtherResults.addAll(Arrays.asList(lvCheckOtherResultRules));
			}
			if(EnValidator.isEmpty(lvCheckOtherResults)) return null;
			LvCheckOtherResultDTO[] lvCheckOtherResultRules = lvCheckOtherResults.toArray(new LvCheckOtherResultDTO[lvCheckOtherResults.size()]);
			return EnAppUtils.doArray2List(lvCheckOtherResultRules);
		}
		return null;
	}
}
