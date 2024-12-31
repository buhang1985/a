package iih.en.pv.s.bp.ippre;

import iih.bl.cg.i.IBlOutQryService;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.bl.st.dto.d.BlIpOutPatPriQryDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.common.CheckFlag;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;
import iih.en.pv.inpatient.d.OutDepChkInfo;
import iih.en.pv.inpatient.d.TransDepCheckStatus;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.s.bp.ip.ChkParamParser;
import iih.en.pv.s.bp.ip.qry.GetLvCheckOtherResultsBP;
import iih.mp.dg.i.IMpDgOutService;
import iih.mp.nr.dto.d.EnServiceParamDTO;
import iih.mp.nr.dto.d.EnumChkMode;
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
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 出院检查BP
 */
public class IppreLvHosCheckBP {
	//执行(医技)
	public static final String TECH_MT = "1";
	//执行(非医技)
	public static final String TECH_MP = "0";

	/**
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	public EnIppreInfoDTO[] exec(EnIppreInfoDTO[] appDTOs) throws BizException {
		if(EnValidator.isEmpty(appDTOs))
			return appDTOs;
		//加载配置信息
		OutDepChkInfo chkInfo = OutDepChkInfo.loadFromCfg(EnParamUtils.getIppreCancHosCheckCfg(), OutDepChkInfo.FLAG_CFG_LENTH_LEAVE);
		//医嘱校验
		long i = System.currentTimeMillis();
		this.checkOr(appDTOs, chkInfo);
		EnLogUtil.getInstance().logInfo("出院核查：医嘱调用时间" + (System.currentTimeMillis() - i));
		//执行校验
		i = System.currentTimeMillis();
		this.checkMp(appDTOs, chkInfo);
		EnLogUtil.getInstance().logInfo("出院核查：执行调用时间" + (System.currentTimeMillis() - i));
		//医技校验
		i = System.currentTimeMillis();
		this.checkMt(appDTOs, chkInfo);
		EnLogUtil.getInstance().logInfo("出院核查：医技调用时间" + (System.currentTimeMillis() - i));
		//药品核查
		i = System.currentTimeMillis();
		this.checkMm(appDTOs, chkInfo);
		EnLogUtil.getInstance().logInfo("出院核查：药品调用时间" + (System.currentTimeMillis() - i));
		//费用核查
		i = System.currentTimeMillis();
		this.checkBl(appDTOs, chkInfo);
		EnLogUtil.getInstance().logInfo("出院核查：费用调用时间" + (System.currentTimeMillis() - i));
		//其他
		i = System.currentTimeMillis();
		this.checkOther(appDTOs);
		EnLogUtil.getInstance().logInfo("其他调用时间" + (System.currentTimeMillis() - i));
		return appDTOs;
	}
	/**
	 * 检查未停止医嘱
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private void checkOr(EnIppreInfoDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		// 返回状态
		if (EnValidator.isEmpty(appDTOs))
			return;
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_or())) {
			for (EnIppreInfoDTO appDTO : appDTOs) {
				appDTO.setStatus_or(TransDepCheckStatus.Success);
			}
			return;
		}
		ICiOrdQryService iciService = ServiceFinder.find(ICiOrdQryService.class);
		Map map = iciService.GetPatUnDoOrderdtoNums(assemlyOrParams(appDTOs));
		for (EnIppreInfoDTO appDTO : appDTOs) {
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
	private void checkMm(EnIppreInfoDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mm())) {
			for (EnIppreInfoDTO appDTO : appDTOs) {
				appDTO.setStatus_med(TransDepCheckStatus.Success);
			}
			return;
		}
		IMpDgOutService iipdgservice = ServiceFinder.find(IMpDgOutService.class);
		FMap map = iipdgservice.queryMedTotalNumForPatisWhenOut(assemlyLvMmParams(appDTOs));
		for (EnIppreInfoDTO appDTO : appDTOs) {
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
	private void checkMt(EnIppreInfoDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		//获取医技应该核查的类型
		ParamDTO[] params = assemlyMtSrvParams();
		//参数配置不核查或核查执行项目类型为空则不核查
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mt()) || EnValidator.isEmpty(params)) {
			for (EnIppreInfoDTO appDTO : appDTOs) {
				appDTO.setStatus_tech(TransDepCheckStatus.Success);
			}
			return;
		} 
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaCountDTO[] pestas = mpService.getOutChkCount(assemlyMpParams(appDTOs, TECH_MT), params, getCheckMtTp());
		Map<String, PeStaCountDTO> map = EnFMapUtils.getMap("Id_ent", pestas);
		for (EnIppreInfoDTO appDTO : appDTOs) {
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
	 * 检查执行
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private void checkMp(EnIppreInfoDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		//获取执行应该核查的类型
		ParamDTO[] params = assemlyMpSrvParams();
		//参数配置不核查或核查执行项目类型为空则不核查
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_mp()) || EnValidator.isEmpty(params)) {
			for (EnIppreInfoDTO appDTO : appDTOs) {
				appDTO.setStatus_mp(TransDepCheckStatus.Success);
			}
			return;
		} 
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		PeStaCountDTO[] pestas = mpService.getOutChkCount(assemlyMpParams(appDTOs, TECH_MP), params, getCheckMtTp());
		Map<String, PeStaCountDTO> map = EnFMapUtils.getMap("Id_ent", pestas);
		for (EnIppreInfoDTO appDTO : appDTOs) {
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
	 * 检查费用
	 * 
	 * @param appDTOs
	 * @throws BizException
	 */
	private void checkBl(EnIppreInfoDTO[] appDTOs, OutDepChkInfo chkInfo) throws BizException {
		if (EnValidator.isEmpty(appDTOs))
			return;
		if (CheckFlag.NoCheck.equals(chkInfo.getFg_bl())) {
			for (EnIppreInfoDTO appDTO : appDTOs) {
				appDTO.setStatus_bl(TransDepCheckStatus.Success);
			}
			return;
		}
		BlIpOutPatPriQryDTO[] params = assemlyBlCheckParams(appDTOs);
		FMap blMaps = null;
		if(!EnValidator.isEmpty(params)){
			IBlOutQryService iblService = ServiceFinder.find(IBlOutQryService.class);
			blMaps = iblService.getPatPriceByLast(params, FBoolean.TRUE);
		}
		for (EnIppreInfoDTO appDTO : appDTOs) {
			if(blMaps != null){
				@SuppressWarnings("unchecked")
				List<BlIpOutPatPriDTO> blList = (List<BlIpOutPatPriDTO>) blMaps.get(appDTO.getId_ent());
				if (!EnValidator.isEmpty(blList)){
					for (BlIpOutPatPriDTO checkBl : blList) {
						if (checkBl.getFg_price() != null && !checkBl.getFg_price().booleanValue()) {
							appDTO.setStatus_bl(this.setBlStatus(chkInfo.getFg_bl(),FBoolean.FALSE));
							break;
						} else {
							appDTO.setStatus_bl(this.setBlStatus(chkInfo.getFg_bl(),FBoolean.TRUE));
						}
					}
					continue;
				}
			}
			appDTO.setStatus_bl(this.setBlStatus(chkInfo.getFg_bl(),FBoolean.TRUE));
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
			if (CheckFlag.Warn.equals(checkFlag)) {
				return TransDepCheckStatus.Warning;
			} else if (CheckFlag.Forced.equals(checkFlag)) {
				return TransDepCheckStatus.Error;
			}
		}
		return TransDepCheckStatus.Success;
	}
	
	/**
	 * 设置费用状态的返回值
	 * 
	 * @param checkFlag
	 * @param flag
	 * @return
	 */
	private Integer setBlStatus(Integer checkFlag, FBoolean flag) {
		if (!flag.booleanValue()) {
			if (checkFlag == CheckFlag.Warn) {
				return TransDepCheckStatus.Warning;
			} else if (checkFlag == CheckFlag.Forced) {
				return TransDepCheckStatus.Error;
			}
		}
		return TransDepCheckStatus.Success;
	}
	
	/**
	 * 组装检查未停止医嘱参数(单独列出，医嘱参数修改时)
	 * 
	 * @param appDTOs
	 * @return
	 */
	public static String[] assemlyOrParams(EnIppreInfoDTO[] appDTOs){
		return EnAppUtils.getKeyPropArrayFromDO("Id_ent", appDTOs);
	}
	/**
	 * 组装检查药品参数
	 * 
	 * @param appDTOs
	 * @return
	 */
	public static String[] assemlyLvMmParams(EnIppreInfoDTO[] appDTOs){
		return EnAppUtils.getKeyPropArrayFromDO("Id_ent", appDTOs);
	}
	/**
	 * 组装检查费用参数
	 * 
	 * @param appDTOs
	 * @return
	 */
	public static BlIpOutPatPriQryDTO[] assemlyBlCheckParams(EnIppreInfoDTO[] appDTOs){
		Map<String, EnIppreInfoDTO> map = EnFMapUtils.getMap("Id_ent", appDTOs);
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		//组装费用核查接口入参
		List<BlIpOutPatPriQryDTO> params = new ArrayList<BlIpOutPatPriQryDTO>();
		for (EnIppreInfoDTO appDTO : appDTOs) {
			BlIpOutPatPriQryDTO qryDTO = new BlIpOutPatPriQryDTO();
			/*boolean flag = true;
			if(FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
				qryDTO.setId_ent(appDTO.getId_ent());
				qryDTO.setDt_end(appDTO.getDt_disc_ip());
			}else{*/
				/*if (flag) {
					qryDTO.setId_ent(appDTO.getId_ent());
					if(appDTO.getDt_outor() == null)
						qryDTO.setDt_end(dateTime);
					else
						qryDTO.setDt_end(appDTO.getDt_outor());
				}*/
				qryDTO.setDt_end(dateTime);
				qryDTO.setId_ent(appDTO.getId_ent());
				params.add(qryDTO);
			}
			//不是待出院的患者，没有出院时间，取当前时间
			/*if(qryDTO.getDt_end() == null){
				qryDTO.setDt_end(dateTime);
			}*/
			
		//}
		return params.toArray(new BlIpOutPatPriQryDTO[0]);
	}
	/**
	 * 获取出院检查的执行服务类型
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static ParamDTO[] assemlyMpSrvParams() throws BizException{
		// 类型
		String tpFlag = EnParamUtils.getLvHosCheckNonTechSrvTps();
		// 类型设置为空，则不检查
		if (EnValidator.isEmpty(tpFlag))
			return null;
		ChkParamParser paramParser = new ChkParamParser();
		return paramParser.parse(tpFlag);
	}
	/**
	 * 获取出院检查的医技服务类型
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static ParamDTO[] assemlyMtSrvParams() throws BizException{
		// 类型
		String tpFlag = EnParamUtils.getLvHosCheckTechSrvTps();
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
	public static EnServiceParamDTO[] assemlyMpParams(EnIppreInfoDTO[] appDTOs, String fg_tech) {
		List<EnServiceParamDTO> params = new ArrayList<EnServiceParamDTO>();
		for (EnIppreInfoDTO appDTO : appDTOs) {
			EnServiceParamDTO param = new EnServiceParamDTO();
			param.setId_ent(appDTO.getId_ent());
			param.setDt_bg(appDTO.getDt_entry().toString());
			param.setDt_end("2099-12-31 23:59:59");
			param.setFg_tech(fg_tech);
			params.add(param);
		}
		return params.toArray(new EnServiceParamDTO[0]);
	}
	/**
	 * 出院、转科核查医技项目,执行项目的核查方式 0-按执行核查 1-按费用核查 2-按闭环中是否可出科核查(暂未使用）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static int getCheckMtTp() throws BizException{
		Integer param = EnParamUtils.GetCheckMtTp();
		if(param != null){
			if(param == 0)
				return EnumChkMode.PERFORM;
			if(param == 1)
				return EnumChkMode.CHARGE;
		}
		throw new BizException("医技项目的核查方式(ENIP0034)配置错误！");
	}
	/**
	 * 检查其他
	 * 
	 * @param appDTOs
	 * @throws BizException
	 */
	private void checkOther(EnIppreInfoDTO[] appDTOs) throws BizException {
		if(EnValidator.isEmpty(appDTOs))
			return;
		Set<String> entIdSet = new HashSet<>();
		for(EnIppreInfoDTO appDTO : appDTOs){
			appDTO.setStatus_other(TransDepCheckStatus.Success);
			entIdSet.add(appDTO.getId_ent());
		}
		GetLvCheckOtherResultsBP checkOtherResultsBP = new GetLvCheckOtherResultsBP();
		LvCheckOtherResultDTO[] lvCheckOtherResults = checkOtherResultsBP.exec(entIdSet.toArray(new String[entIdSet.size()]));
		if(EnValidator.isEmpty(appDTOs))
			return;
		Map<String, Integer> map = checkOtherResultsBP.essemlyMap(lvCheckOtherResults);
		for(EnIppreInfoDTO appDTO : appDTOs){
			if(map.containsKey(appDTO.getId_ent()))
				appDTO.setStatus_other(map.get(appDTO.getId_ent()));
		}
	}
}
