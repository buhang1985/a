package iih.en.pv.s.bp.ip;

import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.common.CheckFlag;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.inpatient.d.OutDepChkInfo;
import iih.en.pv.inpatient.d.TransDepCheckStatus;
import iih.en.pv.s.bp.ip.qry.GetLvCheckOtherResultsBP;
import iih.mp.dg.i.IMpDgOutService;
import iih.mp.nr.dto.d.EnServiceParamDTO;
import iih.mp.nr.dto.d.ParamDTO;
import iih.mp.nr.dto.d.PeStaCountDTO;
import iih.mp.nr.foreign.i.IForeignService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 出科核查BP,
 * 转科
 * @author yankan,liubin
 */
public class OutDepCheckBP {
	
	public OutDepCheckBP(){
	}

	
	/**
	 * 检查出科
	 * @param appDTO 出科申请DTO
	 * @throws BizException 
	 */
	public void exec(TransDepPatDTO[] appDTOs) throws BizException{
		if(EnValidator.isEmpty(appDTOs))
			return;
		String checkDepCfg = EnParamUtils.getTransDepCheckCfg();
		if(EnValidator.isEmpty(checkDepCfg) || checkDepCfg.length() != 4)
			throw new BizException("转科检查参数(ENIP0020)配置错误！");
		String checkWardCfg = EnParamUtils.getTransWardCheckCfg();
		if(EnValidator.isEmpty(checkWardCfg) || checkWardCfg.length() != 4)
			throw new BizException("转病区检查参数(ENIP0021)配置错误！");
		//不需要核查的科室或病区
		String nurIds = EnParamUtils.GetTranNoCheckIds();
		String allCfg = getTranCfg(checkDepCfg, checkWardCfg);
	    				
		ArrayList <TransDepPatDTO> depList = new ArrayList<TransDepPatDTO>();//转科list
		ArrayList<TransDepPatDTO> nurList = new ArrayList<TransDepPatDTO>();//转病区list
		ArrayList<TransDepPatDTO> allList = new ArrayList<TransDepPatDTO>();//转科又转病区list
		ArrayList<TransDepPatDTO> noCheckList = new ArrayList<TransDepPatDTO>();//不需检查List
		
		for (TransDepPatDTO transDTO : appDTOs) {
			boolean isTransDep = isTransDep(transDTO);
			boolean isTransNur = isTransNur(transDTO);
			if(isTransDep){
				if(isTransNur)
					if(isContainsDep(nurIds, transDTO.getId_dep_phy()) && isContainsDep(nurIds, transDTO.getId_dep_nur()))
						noCheckList.add(transDTO);//不用校验
					else
						allList.add(transDTO);//转科转病区
				else{
					if(isContainsDep(nurIds, transDTO.getId_dep_phy()))
						noCheckList.add(transDTO);//不用校验
					else
						depList.add(transDTO);//转科不转病区
				}
			}else{
				if(isTransNur){
					if(isContainsDep(nurIds, transDTO.getId_dep_nur()))
						noCheckList.add(transDTO);//不用校验
					else
						nurList.add(transDTO);//转病区不转科
				}
				else
					noCheckList.add(transDTO);//不用校验
			}
		}
		
		//检查
		if(!EnValidator.isEmpty(depList)){
			this.checkInfo(depList, checkDepCfg);		
		}
		if(!EnValidator.isEmpty(nurList)){
			this.checkInfo(nurList, checkWardCfg);	
		}
		if(!EnValidator.isEmpty(allList)){
			this.checkInfo(allList, allCfg);		
		}
		if(!EnValidator.isEmpty(noCheckList)){
			for (TransDepPatDTO appDTO : noCheckList) {
				appDTO.setStatus_or(TransDepCheckStatus.Success);
				appDTO.setStatus_med(TransDepCheckStatus.Success);
				appDTO.setStatus_tech(TransDepCheckStatus.Success);
				appDTO.setStatus_mp(TransDepCheckStatus.Success);
			}		
		}
	}
	/**
	 * 检查DTO
	 * @param appDTOArray
	 * @param chkInfo
	 * @throws BizException 
	 */
	private void checkInfo(List<TransDepPatDTO> transDepList , String chkInfo) throws BizException {
		OutDepChkInfo chkDepInfo = OutDepChkInfo.loadFromCfg(chkInfo, OutDepChkInfo.FLAG_CFG_LENTH_TRANS);
		this.checkAppDTOs(transDepList.toArray(new TransDepPatDTO[0]), chkDepInfo);
	}
	/**
	 * 检查出院申请
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void checkAppDTOs(TransDepPatDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		//医嘱
		this.checkOr(appDTOs, chkInfo);
		// 非医技
		this.checkMp(appDTOs, chkInfo);
		// 药品
		this.checkMm(appDTOs, chkInfo);
		// 医技
		this.checkMt(appDTOs, chkInfo);
		//其他
		long i = System.currentTimeMillis();
		this.checkOther(appDTOs);
		EnLogUtil.getInstance().logInfo("其他调用时间" + (System.currentTimeMillis() - i));
	}

	/**
	 * 检查未停止医嘱
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private void checkOr(TransDepPatDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_or())) {
			for (TransDepPatDTO appDTO : appDTOs) {
				appDTO.setStatus_or(TransDepCheckStatus.Success);
			}
			return;
		}
		ICiOrdQryService iciService = ServiceFinder.find(ICiOrdQryService.class);
		Map map = iciService.GetPatUnDoOrderdtoNums(assemlyOrParams(appDTOs));
		for (TransDepPatDTO appDTO : appDTOs) {
			Integer num = null;
			if(map != null && map.containsKey(appDTO.getId_ent())){
				Object obj = map.get(appDTO.getId_ent());
				if(obj != null)
					num = (Integer)obj;
			}
			appDTO.setStatus_or(this.setStatus(chkInfo.getFg_or(), num));
		}
	}

	/**
	 * 检查药品
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private void checkMm(TransDepPatDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mm())) {
			for (TransDepPatDTO appDTO : appDTOs) {
				appDTO.setStatus_med(TransDepCheckStatus.Success);
			}
			return;
		}
		IMpDgOutService iipdgservice = ServiceFinder.find(IMpDgOutService.class);
		FMap map = iipdgservice.queryMedTotalNumForPatisWhenOut(assemlyLvMmParams(appDTOs));
		for (TransDepPatDTO appDTO : appDTOs) {
			Integer num = null;
			if(map != null && map.containsKey(appDTO.getId_ent())){
				Object obj = map.get(appDTO.getId_ent());
				if(obj != null)
					num = ((FDouble)obj).intValue();
			}
			appDTO.setStatus_med(this.setStatus(chkInfo.getFg_mm(), num));
		}
	}

	/**
	 * 检查医技
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 */
	private void checkMt(TransDepPatDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		//获取医技应该核查的类型
		ParamDTO[] params = assemlyMtSrvParams();
		//参数配置不核查或核查执行项目类型为空则不核查
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mt()) || EnValidator.isEmpty(params)) {
			for (TransDepPatDTO appDTO : appDTOs) {
				appDTO.setStatus_tech(TransDepCheckStatus.Success);
			}
			return;
		} 
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaCountDTO[] pestas = mpService.getOutChkCount(assemlyMpParams(appDTOs, LvHosCheckBP.TECH_MT), params, LvHosCheckBP.getCheckMtTp());
		Map<String, PeStaCountDTO> map = EnFMapUtils.getMap("Id_ent", pestas);
		for (TransDepPatDTO appDTO : appDTOs) {
			Integer num = null;
			if(map!=null && map.containsKey(appDTO.getId_ent())){
				PeStaCountDTO pesta = map.get(appDTO.getId_ent());
				if(pesta != null)
					num = pesta.getTech_num();
			}
			appDTO.setStatus_tech(this.setStatus(chkInfo.getFg_mt(), num));
		}
	}

	/**
	 * 检查执行(非医技)
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private void checkMp(TransDepPatDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		//获取执行应该核查的类型
		ParamDTO[] params = assemlyMpSrvParams();
		//参数配置不核查或核查执行项目类型为空则不核查
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mp()) || EnValidator.isEmpty(params)) {
			for (TransDepPatDTO appDTO : appDTOs) {
				appDTO.setStatus_mp(TransDepCheckStatus.Success);
			}
			return;
		} 
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaCountDTO[] pestas = mpService.getOutChkCount(assemlyMpParams(appDTOs, LvHosCheckBP.TECH_MP), params, LvHosCheckBP.getCheckMtTp());
		Map<String, PeStaCountDTO> map = EnFMapUtils.getMap("Id_ent", pestas);
		for (TransDepPatDTO appDTO : appDTOs) {
			Integer num = null;
			if(map!=null && map.containsKey(appDTO.getId_ent())){
				PeStaCountDTO pesta = map.get(appDTO.getId_ent());
				if(pesta != null)
					num = pesta.getOther_num();
			}
			appDTO.setStatus_mp(this.setStatus(chkInfo.getFg_mp(), num));
		}
	}
	/**
	 * 设置状态的返回值
	 * @param checkFlag
	 * @param num
	 * @return
	 */
	private Integer setStatus(Integer checkFlag, Integer num) {
		if (num != null && num > 0) {
			if (checkFlag == CheckFlag.Warn) {
				return TransDepCheckStatus.Warning;
			} else if (checkFlag == CheckFlag.Forced) {
				return TransDepCheckStatus.Error;
			}
		}
		return TransDepCheckStatus.Success;
	}

	/**
	 * 获取转科又转病区参数
	 * 
	 * @param checkDepCfg
	 * @param checkWardCfg
	 * @return
	 */
	private String getTranCfg(String checkDepCfg, String checkWardCfg){
		char[] depCharArray = checkDepCfg.toCharArray();
		char[] wardCharArray = checkWardCfg.toCharArray();
		String allCfg = "";
	    for(int i = 0;i<4;i++){
	    	if(depCharArray[i] >wardCharArray[i]){
	    		allCfg += depCharArray[i];
	    	}else{
	    		allCfg += wardCharArray[i];
	    	}
	    }
	    return allCfg;
	}
	/**
	 * 是否是转科
	 * 
	 * @param transDTO
	 * @return
	 */
	private boolean isTransDep(TransDepPatDTO transDTO){
		if(EnValidator.isEmpty(transDTO.getOld_dep_phy()))
			return !EnValidator.isEmpty(transDTO.getId_dep_phy());
		return !transDTO.getOld_dep_phy().equals(transDTO.getId_dep_phy());
	}
	/**
	 * 是否是转病区
	 * 
	 * @param transDTO
	 * @return
	 */
	private boolean isTransNur(TransDepPatDTO transDTO){
		if(EnValidator.isEmpty(transDTO.getOld_dep_nur()))
			return !EnValidator.isEmpty(transDTO.getId_dep_nur());
		return !transDTO.getOld_dep_nur().equals(transDTO.getId_dep_nur());
	}
	/**
	 * 组装检查未停止医嘱参数(单独列出，医嘱参数修改时)
	 * 
	 * @param appDTOs
	 * @return
	 */
	public static String[] assemlyOrParams(TransDepPatDTO[] appDTOs){
		return EnAppUtils.getKeyPropArrayFromDO("Id_ent", appDTOs);
	}
	/**
	 * 组装检查药品参数
	 * 
	 * @param appDTOs
	 * @return
	 */
	public static String[] assemlyLvMmParams(TransDepPatDTO[] appDTOs){
		return EnAppUtils.getKeyPropArrayFromDO("Id_ent", appDTOs);
	}
	/**
	 * 获取出院检查的医技服务类型
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static ParamDTO[] assemlyMtSrvParams() throws BizException{
		// 类型
		String tpFlag = EnParamUtils.getTransDepCheckTechSrvTps();
		// 类型设置为空，则不检查
		if (EnValidator.isEmpty(tpFlag))
			return null;
		ChkParamParser paramParser = new ChkParamParser();
		return paramParser.parse(tpFlag);
	}
	/**
	 * 创建医技和非医技参数
	 * 
	 * @param entIds
	 * @param fg_tech
	 * @return
	 * @throws BizException
	 */
	public static EnServiceParamDTO[] assemlyMpParams(TransDepPatDTO[] appDTOs, String fg_tech) {
		List<EnServiceParamDTO> params = new ArrayList<EnServiceParamDTO>();
		for (TransDepPatDTO appDTO : appDTOs) {
			EnServiceParamDTO param = new EnServiceParamDTO();
			param.setId_ent(appDTO.getId_ent());
			if(appDTO.getDt_entry()!=null)
			param.setDt_bg(appDTO.getDt_entry().toString());
			param.setDt_end("2099-12-31 23:59:59");
			param.setFg_tech(fg_tech);
			params.add(param);
		}
		return params.toArray(new EnServiceParamDTO[0]);
	}
	/**
	 * 获取出院检查的执行服务类型
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static ParamDTO[] assemlyMpSrvParams() throws BizException{
		// 类型
		String tpFlag = EnParamUtils.getTransDepCheckNonTechSrvTps();
		// 类型设置为空，则不检查
		if (EnValidator.isEmpty(tpFlag))
			return null;
		ChkParamParser paramParser = new ChkParamParser();
		return paramParser.parse(tpFlag);
	}
	/**
	 * 是否包含科室
	 * 
	 * @param depIds
	 * @param depId
	 * @return
	 */
	private boolean isContainsDep(String depIds, String depId){
		if(EnValidator.isEmpty(depIds) || EnValidator.isEmpty(depId))
			return false;
		return depIds.contains(depId);
	}
	/**
	 * 检查其他
	 * 
	 * @param appDTOs
	 * @throws BizException
	 */
	private void checkOther(TransDepPatDTO[] appDTOs) throws BizException {
		if(EnValidator.isEmpty(appDTOs))
			return;
		Set<String> entIdSet = new HashSet<>();
		for(TransDepPatDTO appDTO : appDTOs){
			appDTO.setStatus_other(TransDepCheckStatus.Success);
			entIdSet.add(appDTO.getId_ent());
		}
		GetLvCheckOtherResultsBP checkOtherResultsBP = new GetLvCheckOtherResultsBP();
		LvCheckOtherResultDTO[] lvCheckOtherResults = checkOtherResultsBP.trancheck(entIdSet.toArray(new String[entIdSet.size()]),appDTOs);
		if(EnValidator.isEmpty(appDTOs))
			return;
		Map<String, Integer> map = checkOtherResultsBP.essemlyMap(lvCheckOtherResults);
		for(TransDepPatDTO appDTO : appDTOs){
			if(map.containsKey(appDTO.getId_ent()))
				appDTO.setStatus_other(map.get(appDTO.getId_ent()));
		}
	}
}
