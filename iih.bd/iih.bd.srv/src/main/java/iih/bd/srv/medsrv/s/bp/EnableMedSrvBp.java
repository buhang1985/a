package iih.bd.srv.medsrv.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.accountsrv.i.IAccountSrvMap;
import iih.bd.pp.accountsrv.i.IAccountsrvExtRService;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.s.rule.bp.CheckUnitMedBp;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.BdMmParamUtils;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.BdSrvParamUtils;
import iih.bd.utils.FileUtils;
import iih.bd.utils.log.BdSrvLogUtils;
import iih.ci.ord.i.external.provide.ICiOrdMmService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用医疗服务业务逻辑
 * 
 * @author hao_wu
 * @author hao_wu 2018-5-22 启用医疗服务调用基础服务，解决门诊医生站缓存不更新的bug
 *
 */
public class EnableMedSrvBp {

	public MedSrvDO[] exec(MedSrvDO[] medSrvArr) throws BizException {
		if (ArrayUtils.isEmpty(medSrvArr)) {
			return null;
		}

		checkData(medSrvArr);
		MedSrvDO[] result = enableMedSrv(medSrvArr);
		return result;
	}

	/**
	 * 启用医疗服务
	 * 
	 * @param medSrvArr
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] enableMedSrv(MedSrvDO[] medSrvArr) throws BizException {
		for (MedSrvDO medSrvDO : medSrvArr) {
			medSrvDO.setFg_active(FBoolean.TRUE);
			medSrvDO.setStatus(DOStatus.UPDATED);
		}
		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		MedSrvDO[] result = medsrvMDOCudService.update(medSrvArr);
		return result;
	}

	/**
	 * 检查数据
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkData(MedSrvDO[] medSrvArr) throws BizException {
		checkDataIntegrity(medSrvArr);
		checkUseBlood(medSrvArr);
		checkSani(medSrvArr);
		checkSrvPrimd(medSrvArr);
		checkCompSrv(medSrvArr);
		checkAcc(medSrvArr);
		checkByCi(medSrvArr);
	}

	/**
	 * 检查组合计价类项目
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkCompSrv(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO[] compSrvs = getCompSrvs(medSrvArr);
		if (ArrayUtils.isEmpty(compSrvs)) {
			return;
		}

		String[] srvIds = DoUtils.getAttrValArr(compSrvs, MedSrvDO.ID_SRV, String.class);

		IPrisrvcompRService prisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		PriSrvCompDO[] compSrvPriDos = prisrvcompRService.findByAttrValStrings(PriSrvCompDO.ID_SRV, srvIds);
		HashMap<String, ArrayList<PriSrvCompDO>> compSrvPriDoMap = new HashMap<>();
		if (ArrayUtils.isNotEmpty(compSrvPriDos)) {
			for (PriSrvCompDO priSrvCompDO : compSrvPriDos) {
				String srvId = priSrvCompDO.getId_srv();
				ArrayList<PriSrvCompDO> compSrvPriDoList = null;
				if (compSrvPriDoMap.containsKey(srvId)) {
					compSrvPriDoList = compSrvPriDoMap.get(srvId);
				}
				if (compSrvPriDoList == null) {
					compSrvPriDoList = new ArrayList<>();
					compSrvPriDoMap.put(srvId, compSrvPriDoList);
				}
				compSrvPriDoList.add(priSrvCompDO);
			}
		}

		for (MedSrvDO compSrv : compSrvs) {
			if (!compSrvPriDoMap.containsKey(compSrv.getId_srv())) {
				String msg = String.format("医疗服务：%s%s定价模式：组合定价模式%s未维护组合定价项目，无法启用。", compSrv.getName(),
						FileUtils.NewLine, FileUtils.NewLine);
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 获取组合计价服务
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private MedSrvDO[] getCompSrvs(MedSrvDO[] medSrvArr) {
		ArrayList<MedSrvDO> compSrvList = new ArrayList<>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(medSrvDO.getSd_primd())) {
				compSrvList.add(medSrvDO);
			}
		}
		return compSrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 检查核算体系
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkAcc(MedSrvDO[] medSrvArr) throws BizException {

		List<MedSrvDO> needCheckMedSrvList = new ArrayList<>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
					|| (IBdPrimdCodeConst.CODE_PRI_SRV.equals(medSrvDO.getSd_primd())
							&& FBoolean.TRUE.equals(medSrvDO.getFg_bl()))) {
				needCheckMedSrvList.add(medSrvDO);
			}
		}
		if (needCheckMedSrvList.size() <= 0) {
			return;
		}

		FBoolean useAccSys = BdPpParamUtils.getUseAccountSystemFlag();
		if (!FBoolean.TRUE.equals(useAccSys)) {
			return;
		}

		String[] accCaIds = getAccCaIds();

		String[] srvIds = DoUtils.getAttrValArr(needCheckMedSrvList.toArray(new MedSrvDO[0]), MedSrvDO.ID_SRV,
				String.class);

		IAccountSrvMap accSrvMap = getAccMap(srvIds);

		ArrayList<MedSrvDO> errSrvList = new ArrayList<>();
		for (MedSrvDO medSrvDO : needCheckMedSrvList) {
			for (String accCaId : accCaIds) {
				if (FBoolean.FALSE.equals(accSrvMap.contains(medSrvDO.getId_srv(), accCaId))) {
					errSrvList.add(medSrvDO);
					break;
				}
			}
		}

		if (errSrvList.size() > 0) {
			String[] srvNames = new String[errSrvList.size()];
			for (int i = 0; i < errSrvList.size(); i++) {
				srvNames[i] = String.format("%s【%s】", errSrvList.get(i).getName(), errSrvList.get(i).getCode());
			}

			String msg = String.format("%s未维护核算体系，不允许启用。", StringUtils.join(srvNames, ","));
			throw new BizException(msg);
		}
	}

	/**
	 * 获取核算体系字典
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private IAccountSrvMap getAccMap(String[] srvIds) throws BizException {
		IAccountsrvExtRService accountsrvExtRService = ServiceFinder.find(IAccountsrvExtRService.class);
		IAccountSrvMap accMap = accountsrvExtRService.getAccMapBySrvIds(srvIds);
		return accMap;
	}

	/**
	 * 获取核算体系分类主键集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getAccCaIds() throws BizException {
		FBoolean shareAccSystem = BdPpParamUtils.getShareAcountSystemFlag();
		if (FBoolean.TRUE.equals(shareAccSystem)) {
			return new String[] { IBdPpDictCodeConst.ID_ACCOUNT_GY };
		}
		return new String[] { IBdPpDictCodeConst.ID_ACCOUNT_MZ, IBdPpDictCodeConst.ID_ACCOUNT_ZY };
	}

	/**
	 * 调用CI进行数据校验<br/>
	 * 只校验诊疗项目
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkByCi(MedSrvDO[] medSrvArr) throws BizException {

		FBoolean validate = BdSrvParamUtils.getIsValidateTreatEnableByCi();
		if (!FBoolean.TRUE.equals(validate)) {
			return;
		}
		List<MedSrvDO> treatSrvDoList = new ArrayList<MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (medSrvDO.getSd_srvtp() != null
					&& !medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				treatSrvDoList.add(medSrvDO);
			}
		}

		if (treatSrvDoList.size() <= 0) {
			return;
		}

		ICiOrdMmService ciOrdMmService = ServiceFinder.find(ICiOrdMmService.class);
		if (ciOrdMmService == null) {
			BdSrvLogUtils.warn("ICiOrdMmService服务获取失败，无法进行临床诊疗项目启用校验。");
			return;
		}
		FMap2 errMsgMap = ciOrdMmService.ChangedSrvValidate(treatSrvDoList.toArray(new MedSrvDO[0]));
		if (errMsgMap == null || errMsgMap.size() <= 0) {
			return;
		}

		List<String> msgList = new ArrayList<String>();
		for (String srvId : errMsgMap.keySet()) {
			msgList.add((String) errMsgMap.get(srvId));
		}
		String msg = StringUtils.join(msgList, ",");
		throw new BizException(msg);
	}

	/**
	 * 检查数据完整性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkDataIntegrity(MedSrvDO[] medSrvArr) throws BizException {

		checkUnitMed(medSrvArr);
		checkMedSrvNullProp(medSrvArr);

		for (MedSrvDO medSrvDO : medSrvArr) {
			checkSrvSet(medSrvDO);
			String sdSrvTp = medSrvDO.getSd_srvtp();
			if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				// 药品
				DrugSrvEnableCheckBp bp = new DrugSrvEnableCheckBp();
				bp.exec(medSrvDO);
			} else if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				// 检查
				RisSrvEnableCheckBp bp = new RisSrvEnableCheckBp();
				bp.exec(medSrvDO);
			} else if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				// 检验
				LisSrvEnableCheckBp bp = new LisSrvEnableCheckBp();
				bp.exec(medSrvDO);
			} else if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
				// 手术
				OpSrvEnableCheckBp bp = new OpSrvEnableCheckBp();
				bp.exec(medSrvDO);
			} else if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_NURSE)) {
				// 护理
				NurseSrvEnableCheckBp bp = new NurseSrvEnableCheckBp();
				bp.exec(medSrvDO);
			} else if (sdSrvTp != null && sdSrvTp.length() >= 2
					&& sdSrvTp.substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT)) {
				// 诊疗
				DiagTreatSrvEnableCheckBp bp = new DiagTreatSrvEnableCheckBp();
				bp.exec(medSrvDO);
			}
		}
	}

	private void checkMedSrvNullProp(MedSrvDO[] medSrvArr) throws BizException {
		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();
		for (MedSrvDO medSrvDO : medSrvArr) {
			checkMedSrvNullProp(medSrvDO, drugMCPropMM);
		}
	}

	/**
	 * 检查默认用量单位
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkUnitMed(MedSrvDO[] medSrvArr) throws BizException {
		CheckUnitMedBp bp = new CheckUnitMedBp();
		bp.exec(medSrvArr);
	}

	/**
	 * 检查服务套
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void checkSrvSet(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)) {
			SrvSetEnableCheckBp bp = new SrvSetEnableCheckBp();
			bp.exec(medSrvDO);
		}
	}

	/**
	 * 检查医疗服务空属性值
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void checkMedSrvNullProp(MedSrvDO medSrvDO, String drugMCPropMM) throws BizException {
		String msg = String.format("%s\"%s\"中",
				((StringUtils.isNotEmpty(medSrvDO.getSd_srvtp())
						&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) ? "药品通用名" : "医疗服务"),
				medSrvDO.getName());
		if (StringUtil.isEmpty(medSrvDO.getId_org())) {
			msg = String.format("%s所属集团为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getId_grp())) {
			msg = String.format("%s所属组织为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getId_srvca())) {
			msg = String.format("%s服务分类为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getId_srvtp())) {
			msg = String.format("%s服务类型为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getSd_srvtp())) {
			msg = String.format("%s服务类型编码为空。", msg);
			throw new BizException(msg);
		} else {
			if (medSrvDO.getSd_srvtp().length() < 4) {
				msg = String.format("%s服务类型选择错误！服务类型编码长度不能小于4位。", msg);
				throw new BizException(msg);
			}
		}
		if (StringUtil.isEmpty(medSrvDO.getSrvca_innercode())) {
			msg = String.format("%s服务分类内编码为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getName())) {
			msg = String.format("%s服务名称为空。", msg);
			throw new BizException(msg);
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM) && StringUtils.isEmpty(medSrvDO.getId_freq())) {
			msg = String.format("%s频次为空。", msg);
			throw new BizException(msg);
		}
		// 不需要校验
		// if (StringUtils.isEmpty(medSrvDO.getSd_frequnitct())) {
		// msg = String.format("%s频次编码为空。", msg);
		// throw new BizException(msg);
		// }
		if (StringUtil.isEmpty(medSrvDO.getId_primd())) {
			msg = String.format("%s定价模式为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDO.getSd_primd())) {
			msg = String.format("%s定价模式编码为空。", msg);
			throw new BizException(msg);
		} else if (medSrvDO.getSd_primd() == IBdPrimdCodeConst.CODE_PRI_SRV) {
			if (medSrvDO.getEu_blmd() == null) {
				msg = String.format("%s划价方式为空。", msg);
				throw new BizException(msg);
			}
		}
		if (medSrvDO.getFg_ctm() == null) {
			msg = String.format("%s自定义服务标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvDO.getFg_or() == null) {
			msg = String.format("%s医嘱可开立标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvDO.getFg_mm() == null) {
			msg = String.format("%s物品标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvDO.getFg_bl() == null) {
			msg = String.format("%s费用标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvDO.getFg_set() == null) {
			msg = String.format("%s服务套标识为空。", msg);
			throw new BizException(msg);
		} else if (medSrvDO.getFg_set().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_setord())) {
				msg = String.format("%s服务套开立方式为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_setord())) {
				msg = String.format("%s服务套开立方式编码为空。", msg);
				throw new BizException(msg);
			}
		}

		if (medSrvDO.getFg_use_op() == null) {
			msg = String.format("%s门诊可使用标识为空。", msg);
			throw new BizException(msg);
		} else if (medSrvDO.getFg_mm().equals(FBoolean.TRUE) && medSrvDO.getFg_use_op().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_mmbind_op())) {
				msg = String.format("%s门诊物品绑定时机为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_mmbind_op())) {
				msg = String.format("%s门诊物品绑定时机编码为空。", msg);
				throw new BizException(msg);
			}
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM) && medSrvDO.getFg_use_ip() == null) {
			throw new BizException("住院可使用标识为空");
		} else if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)
				&& medSrvDO.getFg_mm().equals(FBoolean.TRUE) && medSrvDO.getFg_use_ip().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_mmbind_ip())) {
				msg = String.format("%s住院物品绑定时机为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_mmbind_ip())) {
				msg = String.format("%s住院物品绑定时机编码为空。", msg);
				throw new BizException(msg);
			}
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM) && medSrvDO.getFg_use_er() == null) {
			throw new BizException("急诊可使用标识为空");
		} else if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)
				&& medSrvDO.getFg_mm().equals(FBoolean.TRUE) && medSrvDO.getFg_use_er().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_mmbind_er())) {
				msg = String.format("%s急诊物品绑定时机为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_mmbind_er())) {
				msg = String.format("%s急诊物品绑定时机编码为空。", msg);
				throw new BizException(msg);
			}
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM) && medSrvDO.getFg_use_pe() == null) {
			throw new BizException("体检可使用标识为空");
		} else if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)
				&& medSrvDO.getFg_mm().equals(FBoolean.TRUE) && medSrvDO.getFg_use_pe().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_mmbind_pe())) {
				msg = String.format("%s体检物品绑定时机为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_mmbind_pe())) {
				msg = String.format("%s体检物品绑定时机编码为空。", msg);
				throw new BizException(msg);
			}
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM) && medSrvDO.getFg_use_fm() == null) {
			msg = String.format("%s家庭可使用标识为空。", msg);
			throw new BizException(msg);
		} else if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)
				&& medSrvDO.getFg_mm().equals(FBoolean.TRUE) && medSrvDO.getFg_use_fm().equals(FBoolean.TRUE)) {
			if (StringUtil.isEmpty(medSrvDO.getId_mmbind_fm())) {
				msg = String.format("%s家庭物品绑定时机为空。", msg);
				throw new BizException(msg);
			}
			if (StringUtil.isEmpty(medSrvDO.getSd_mmbind_fm())) {
				msg = String.format("%s家庭物品绑定时机编码为空。", msg);
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 检查费用信息
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkSrvPrimd(MedSrvDO[] medSrvArr) throws BizException {
		String[] idSrvArr = getIdSrvArray(medSrvArr);
		IPriCalService rService = ServiceFinder.find(IPriCalService.class);
		FMap errorData = rService.integrityVerification_BdPriSrv(idSrvArr);
		if (errorData != null && errorData.size() > 0) {
			for (MedSrvDO medSrvDO : medSrvArr) {
				String idSrv = medSrvDO.getId_srv();
				if (errorData.containsKey(idSrv)) {
					String errorMsg = errorData.get(idSrv).toString();
					String msg = String.format("医疗服务\"%s\"%s。", medSrvDO.getName(),
							StringUtil.isEmpty(errorMsg) ? "费用信息维护错误" : errorMsg);
					throw new BizException(msg);
				}
			}
		}
	}

	/**
	 * 检查容器类服务项目</br>
	 * 只允许启用一个
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkSani(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO[] SaniMedSrvArr = getSaniMedSrvArr(medSrvArr);
		if (SaniMedSrvArr == null || SaniMedSrvArr.length <= 0)
			return;
		checkSaniInList(SaniMedSrvArr);
		checkSaniInDb(SaniMedSrvArr);
	}

	/**
	 * 获取容器类型服务列表
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private MedSrvDO[] getSaniMedSrvArr(MedSrvDO[] medSrvArr) {
		ArrayList<MedSrvDO> medSrvList = new ArrayList<MedSrvDO>();
		if (medSrvArr != null) {
			for (MedSrvDO medSrvDO : medSrvArr) {
				String sdSrvTp = medSrvDO.getSd_srvtp();
				if (sdSrvTp != null && sdSrvTp.equals(IBdSrvDictCodeConst.SD_SRVTP_SANI_SC)) {
					medSrvList.add(medSrvDO);
				}
			}
		}
		return medSrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 启用列表内检查容器类服务唯一性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkSaniInList(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO data1 = null;
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (data1 != null) {
				String msg = String.format("只能启用一个容器类型的服务,服务\"%s\"和服务\"%s\"不能同时启用。", data1.getName(),
						medSrvDO.getName());
				throw new BizException(msg);
			}
			data1 = medSrvDO;
		}
	}

	/**
	 * 在数据库内检查容器类服务唯一性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkSaniInDb(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0)
			return;
		String[] idSrvArr = getIdSrvArray(medSrvArr);
		String notInSql = SqlUtils.getNotInSqlByIds(MedSrvDO.ID_SRV, idSrvArr);
		String saniSql = String.format("SD_SRVTP = '%s'", IBdSrvDictCodeConst.SD_SRVTP_SANI_SC);
		String wherePart = String.format("%s AND %s", notInSql, saniSql);
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] result = medsrvMDORService.find(wherePart, "", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			MedSrvDO data1 = result[0];
			String msg = String.format("只能启用一个容器类型的服务,服务\"%s\"已启用。", data1.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 检查用血类服务项目</br>
	 * 只允许启用一个
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkUseBlood(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO[] useBloodMedSrvArr = getUseBloodMedSrvArr(medSrvArr);
		if (useBloodMedSrvArr == null || useBloodMedSrvArr.length <= 0)
			return;
		checkUseBloodInList(useBloodMedSrvArr);
		checkUseBloodInDb(useBloodMedSrvArr);
	}

	/**
	 * 获取用血类医疗服务
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private MedSrvDO[] getUseBloodMedSrvArr(MedSrvDO[] medSrvArr) {
		ArrayList<MedSrvDO> medSrvList = new ArrayList<MedSrvDO>();
		if (medSrvArr != null) {
			for (MedSrvDO medSrvDO : medSrvArr) {
				String sdSrvTp = medSrvDO.getSd_srvtp();
				if (sdSrvTp != null && sdSrvTp.equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
					medSrvList.add(medSrvDO);
				}
			}
		}
		return medSrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 在数据库内检查用血类型服务唯一性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkUseBloodInDb(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0)
			return;
		String[] idSrvArr = getIdSrvArray(medSrvArr);
		String notInSql = SqlUtils.getNotInSqlByIds(MedSrvDO.ID_SRV, idSrvArr);
		String BdModeSql = BdEnvContextUtil.processEnvContext(new MedSrvDO(), true);
		String useBloodSql = String.format("SD_SRVTP = '%s'", IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE);
		String whereStr = String.format("%s AND %s AND %s AND FG_ACTIVE = 'Y'", BdModeSql, notInSql, useBloodSql);
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] result = medsrvMDORService.find(whereStr, "", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			MedSrvDO data1 = result[0];
			String msg = String.format("只能启用一个用血类型的服务,服务\"%s\"已启用。", data1.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取服务id数组
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private String[] getIdSrvArray(MedSrvDO[] medSrvArr) {
		ArrayList<String> idSrvList = new ArrayList<String>();
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return idSrvList.toArray(new String[0]);
		}
		for (MedSrvDO medSrvDO : medSrvArr) {
			String idSrv = medSrvDO.getId_srv();
			idSrvList.add(idSrv);
		}
		return idSrvList.toArray(new String[0]);
	}

	/**
	 * 启用列表内检查用血类型服务唯一性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkUseBloodInList(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO data1 = null;
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (data1 != null) {
				String msg = String.format("只能启用一个用血类型的服务,服务\"%s\"和服务\"%s\"不能同时启用。", data1.getName(),
						medSrvDO.getName());
				throw new BizException(msg);
			}
			data1 = medSrvDO;
		}
	}
}
