package iih.en.pv.s.bp.ip.qry;

import iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnLvDepCheckTpEnum;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.s.bp.ip.LvHosCheckBP;
import iih.en.pv.s.bp.ip.OutDepCheckBP;
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
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取转科核查明细
 * 
 * @author liubin
 *
 */
public class GetTrausOutCheckDetailsBP {
	
	/**
	 * 规则引擎调用key
	 */
	private static String KEY_ENT_IDS = "idEnts";
	/**
	 * 获取转科核查明细
	 * 
	 * @param transDepPat 转科记录
	 * @param enLvDepCheckTp 核查类型：EnLvDepCheckTpEnum
	 * @return
	 */
	public FMap exec(TransDepPatDTO transDepPat, String[] enLvDepCheckTps) throws BizException{
		if(transDepPat == null || EnValidator.isEmpty(enLvDepCheckTps))
			return null;
		FMap map = new FMap();
		for(String enLvDepCheckTp : enLvDepCheckTps){
			switch (enLvDepCheckTp) {
			case EnLvDepCheckTpEnum.CHECK_OR:
				map.put(enLvDepCheckTp, execOr(transDepPat));
				break;
			case EnLvDepCheckTpEnum.CHECK_MP:
				map.put(enLvDepCheckTp, execMp(transDepPat));
				break;
			case EnLvDepCheckTpEnum.CHECK_MM:
				map.put(enLvDepCheckTp, execMm(transDepPat));
				break;
			case EnLvDepCheckTpEnum.CHECK_MT:
				map.put(enLvDepCheckTp, execMt(transDepPat));
				break;
			case EnLvDepCheckTpEnum.CHECK_OTHER:
				map.put(enLvDepCheckTp, execOther(transDepPat));
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
	private FArrayList execOr(TransDepPatDTO transDepPat) throws BizException {
		ICiOrdQryService serv = ServiceFinder.find(ICiOrdQryService.class);
		PatUnDoOrderdto[] ors = serv.GetPatUnDoOrderdto(OutDepCheckBP.assemlyOrParams(new TransDepPatDTO[]{transDepPat})[0]);
		return EnAppUtils.doArray2List(ors);
	}
	/**
	 * 获取执行明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMp(TransDepPatDTO transDepPat) throws BizException {
		ParamDTO[] params = OutDepCheckBP.assemlyMpSrvParams();
		if(EnValidator.isEmpty(params))
			return null;
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaDTO[] results = mpService.getOutChkDetail(OutDepCheckBP.assemlyMpParams(new TransDepPatDTO[]{transDepPat}, LvHosCheckBP.TECH_MP)[0], params, LvHosCheckBP.getCheckMtTp());
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取药品明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMm(TransDepPatDTO transDepPat) throws BizException {
		IMpDgOutService iipdgservice = ServiceFinder.find(IMpDgOutService.class);
		MedDetailsDTO[] results = iipdgservice.queryMedDetaisForPatiWhenOut(OutDepCheckBP.assemlyLvMmParams(new TransDepPatDTO[]{transDepPat})[0]);
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取医技明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execMt(TransDepPatDTO transDepPat) throws BizException {
		ParamDTO[] params = OutDepCheckBP.assemlyMtSrvParams();
		if(EnValidator.isEmpty(params))
			return null;
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaDTO[] results = mpService.getOutChkDetail(OutDepCheckBP.assemlyMpParams(new TransDepPatDTO[]{transDepPat}, LvHosCheckBP.TECH_MT)[0], params, LvHosCheckBP.getCheckMtTp());
		return EnAppUtils.doArray2List(results);
	}
	/**
	 * 获取其他明细
	 * 
	 * @param lvAppsDto
	 * @return
	 * @throws BizException
	 */
	private FArrayList execOther(TransDepPatDTO transDepPat) throws BizException {
		if(EnValidator.isEmpty(transDepPat.getId_ent())){
			return null;
		}
		Map<String, Object> varies = new HashMap<String, Object>();
		varies.put(KEY_ENT_IDS, new String[]{transDepPat.getId_ent()});
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_TRANDEPCHECK_CODE, varies);
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
