package iih.bl.hp.rule;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.bp.GetHpLimitPsdListBP;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.en.pv.entplan.d.EntHpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 单方校验规则 单方是指一个中草药处方中只有一味药材，防止医生单独开立比较昂贵的药材
 * 
 * @author yankan
 * @since 2017-09-04
 *
 */
public class CheckSinglePresRule {
	/**
	 * 单方校验
	 * 
	 * @param checkDTO
	 *            需校验DTO
	 * @return 校验结果DTO
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO checkDTO) throws BizException {
		// 设置返回默认值
		CiHpCheckResultDTO checkResult = new CiHpCheckResultDTO();
		checkResult.setCheckflag(FBoolean.TRUE);// 默认通过校验

		// 验证待保存医嘱
		FArrayList2 savingOrList = checkDTO.getSavecidto();
		if (savingOrList == null || savingOrList.size() < 0) {
			return checkResult;
		}

		// 1、获取就诊医保ID集合
		List<String> hpIdList = this.getEnHpIdList(checkDTO);
		if (ListUtil.isEmpty(hpIdList)) {
			return checkResult;// 医保计划为空，默认通过
		}

		// 2、获取草药ID集合
		List<String> srvIdList = this.getSinglePresSrvIdList(savingOrList);
		if (ListUtil.isEmpty(srvIdList)) {
			return checkResult;// 单方服务为空，则为通过
		}

		// 3、获取医保单方限制集合
		GetHpLimitPsdListBP getPsdListBP = new GetHpLimitPsdListBP();
		List<BdHpLimitPsdDO> hpLimitList = getPsdListBP.exec(hpIdList.toArray(new String[0]), srvIdList.toArray(new String[0]));

		// 4、获取医保单方限制的服务集合
		List<String> hpLimitSrvIdList = this.getLimitSrvIdList(hpLimitList);

		// 5、校验单方限制
		checkResult = this.checkPsd(savingOrList, hpLimitSrvIdList);
		return checkResult;
	}

	/**
	 * 获取就诊医保计划ID集合
	 * 
	 * @param ciHpCheckDTO
	 *            校验DTO
	 * @return
	 */
	private List<String> getEnHpIdList(CiHpCheckDTO ciHpCheckDTO) {
		FArrayList2 enHpDOLst = ciHpCheckDTO.getEnthpdo();
		if (enHpDOLst == null || enHpDOLst.size() <= 0) {
			return null;
		}
		List<String> hpIdList = new ArrayList<String>();
		for (Object enHpObj : enHpDOLst) {
			EntHpDO enhpdo = (EntHpDO) enHpObj;
			if (enhpdo != null && !hpIdList.contains(enhpdo.getId_hp())) {
				hpIdList.add(enhpdo.getId_hp());
			}
		}
		return hpIdList;
	}

	/**
	 * 获取单方的服务ID集合
	 * 
	 * @param hpQryOrderDoLst
	 * @return
	 */
	private List<String> getSinglePresSrvIdList(FArrayList2 hpQryOrderDoLst) {
		List<String> srvIdList = new ArrayList<String>();
		for (Object item : hpQryOrderDoLst) {
			HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) item;
			if (hpQryCiorderDTO == null)
				continue;
			// 医嘱服务明细列表,只处理单方
			if (this.isSinglePresOrd(hpQryCiorderDTO.getOrdsrvs())) {
				OrdSrvDO ordSrvDo = (OrdSrvDO) hpQryCiorderDTO.getOrdsrvs().get(0);
				srvIdList.add(ordSrvDo.getId_srv());
			}
		}
		return srvIdList;
	}

	/**
	 * 获取医保单方限制服务集合
	 * 
	 * @param hpLimitPsnList
	 *            医保单方限制集合
	 * @return 限制服务ID集合
	 */
	private List<String> getLimitSrvIdList(List<BdHpLimitPsdDO> hpLimitPsnList) {
		if (ListUtil.isEmpty(hpLimitPsnList)) {
			return null;
		}
		List<String> limitSrvIdList = new ArrayList<String>();
		for (BdHpLimitPsdDO hplimit : hpLimitPsnList) {
			if (hplimit == null || StringUtil.isEmpty(hplimit.getId_srv())) {
				continue;
			}
			if (!limitSrvIdList.contains(hplimit.getId_srv())) {
				limitSrvIdList.add(hplimit.getId_srv());
			}
		}
		return limitSrvIdList;
	}

	/**
	 * 单方校验
	 * 
	 * @param savingOrList
	 *            待保存医嘱集合
	 * @param hpLimitSrvIdList
	 *            医保单方限制服务集合
	 * @return
	 */
	private CiHpCheckResultDTO checkPsd(FArrayList2 savingOrList, List<String> hpLimitSrvIdList) throws BizException {
		CiHpCheckResultDTO checkResult = new CiHpCheckResultDTO();
		checkResult.setCheckflag(FBoolean.TRUE);// 默认通过校验
		if (ListUtil.isEmpty(hpLimitSrvIdList)) {
			return checkResult;
		}

		for (Object item : savingOrList) {
			HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) item;
			if (hpQryCiorderDTO == null) {
				continue;
			}
			if (this.isSinglePresOrd(hpQryCiorderDTO.getOrdsrvs())) {
				OrdSrvDO ordSrvDo = (OrdSrvDO) hpQryCiorderDTO.getOrdsrvs().get(0);
				if (hpLimitSrvIdList.contains(ordSrvDo.getId_srv())) {
					checkResult.setCheckflag(FBoolean.FALSE);// 校验不通过
					// FMap2 failSrvMap = checkResult.getFailidorsrvmap();
					// if(failSrvMap==null){
					// failSrvMap = new FMap2();
					// checkResult.setFailidorsrvmap(failSrvMap);
					// }
					// failSrvMap.put(ordSrvDo.getId_srv(),
					// BlMsgUtils.getHpPsdErrorMsg(ordSrvDo.getName()));
					FArrayList failSrvlist = checkResult.getErroritm_list();
					if (failSrvlist == null) {
						failSrvlist = new FArrayList();
						checkResult.setErroritm_list(failSrvlist);
					}
					SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
					ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
					itmChkRstDTO = setErrorInfoBP.exec(hpQryCiorderDTO.getCiorderdo(), ordSrvDo, BlMsgUtils.getHpPsdErrorMsg(ordSrvDo.getName(), BlMsgUtils.getOrderMmList(ordSrvDo.getId_orsrv(), ordSrvDo.getId_srv(), hpQryCiorderDTO.getOrdsrvmms())), CiHpCheckFailResultEnum.SINGLEIDSRV);
					if (itmChkRstDTO != null) {
						failSrvlist.add(itmChkRstDTO);
					}
				}
			}
		}
		return checkResult;
	}

	/**
	 * 是否为单方医嘱 医嘱服务有且仅有一个，且为草药
	 * 
	 * @param ordsrvList
	 * @return
	 */
	private boolean isSinglePresOrd(FArrayList2 ordsrvList) {
		if (ordsrvList != null && ordsrvList.size() == 1) {
			OrdSrvDO ordSrv = (OrdSrvDO) ordsrvList.get(0);
			return ordSrv != null && ordSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
		}
		return false;
	}
}
