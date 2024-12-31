package iih.bd.srv.medsrv.validate;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSaniDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSaniDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;
import iih.bd.srv.s.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.FMap;
import xap.mw.core.data.binary.BinaryBuilder;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/// <summary>
/// <para>描    述 :  服务的基础数据检查工具 			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  BDSrvValidateTool					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  qzwang         				</para> 
/// <para>修 改 人 :  qzwang         				</para> 
/// <para>创建时间 :  10/20/2016 11:08:56 AM             </para>
/// <para>更新时间 :  10/20/2016 11:08:56 AM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
/// </summary>
public class BDSrvValidateTool {

	public String CheckValidate(MedSrvDO[] srvAggList, List<BDErrorInfo> errorList) throws BizException {
		if (srvAggList == null || srvAggList.length == 0) {
			return null;
		}

		errorList.clear();

		List<MedSrvDO> srvList = new ArrayList<MedSrvDO>();

		List<String> idsrvs = new ArrayList<String>();
		for (MedSrvDO srv : srvAggList) {
			idsrvs.add(srv.getId_srv());
			srvList.add(srv);
		}
		// 启用唯一性
		Map<String, String> errorMap = CheckSrvActiveOnly(srvAggList, 0);
		// 校验费用 -> Map
		FMap primdMap = CheckSrvPrimdOnlyInfo(idsrvs);

		for (MedSrvDO srv : srvAggList) {

			GetMedSrvValidate(srv.getSd_srvtp()).CheckValidate(srv, errorList);
		}
		// 合并 errorList <- Map
		if (null != primdMap) {
			for (BDErrorInfo info : errorList) {
				if (primdMap != null && primdMap.containsKey(info.getId_item())) {
					info.getDescList().add(primdMap.get(info.getId_item()).toString());
					primdMap.remove(info.getId_item());
				}
			}
			if (primdMap != null && primdMap.size() != 0) {
				for (MedSrvDO srv : srvList) {
					if (primdMap.containsKey(srv.getId_srv())) {
						BDErrorInfo info = new BDErrorInfo(srv.getId_srv(), srv.getName());
						info.getDescList().add(primdMap.get(srv.getId_srv()).toString());
					}
				}
			}
		}
		if (null != errorMap) {
			for (BDErrorInfo info : errorList) {
				if (errorMap != null && errorMap.containsKey(info.getId_item())) {
					info.getDescList().add(errorMap.get(info.getId_item()).toString());
					errorMap.remove(info.getId_item());
				}
			}
			if (errorMap != null && errorMap.size() != 0) {
				for (MedSrvDO srv : srvList) {
					if (errorMap.containsKey(srv.getId_srv())) {
						BDErrorInfo info = new BDErrorInfo(srv.getId_srv(), srv.getName());
						info.getDescList().add(errorMap.get(srv.getId_srv()).toString());
					}
				}
			}
		}
//*/
		return Save(srvAggList, errorList);
	}

	/**
	 * 前台服务调用启用
	 * 
	 * @param srvList
	 * @param errorList
	 * @return
	 * @throws BizException
	 */
	public String CheckValidate2(MedSrvDO[] srvList, List<BDErrorInfo> errorList) throws BizException {
		if (srvList == null || srvList.length == 0) {
			return null;
		}
//		IMedsrvRService rService = ServiceFinder.find(IMedsrvRService.class);
		List<String> idsrvs = new ArrayList<String>();
		for (MedSrvDO srvdo : srvList) {
			idsrvs.add(srvdo.getId_srv());
		}
//		MedsrvAggDO[] aggDos = rService.findByIds(idsrvs.toArray(new String[0]), FBoolean.FALSE);
		// 用血启用唯一性
		Map<String, String> errorMap = CheckSrvActiveOnly(srvList, 1);
		// 校验费用 -> Map
		FMap primdMap = CheckSrvPrimdOnlyInfo(idsrvs);
		// 校验服务基础信息 -> errorList

		for (MedSrvDO srv : srvList) {
			GetMedSrvValidate(srv.getSd_srvtp()).CheckValidate(srv, errorList);
		}
		// 合并 errorList <- Map
		if (null != primdMap) {
			for (BDErrorInfo info : errorList) {
				if (primdMap != null && primdMap.containsKey(info.getId_item())) {
					info.getDescList().add(primdMap.get(info.getId_item()).toString());
					primdMap.remove(info.getId_item());
				}
			}
			if (primdMap != null && primdMap.size() != 0) {
				for (MedSrvDO srv : srvList) {
					if (primdMap.containsKey(srv.getId_srv())) {
						BDErrorInfo info = new BDErrorInfo(srv.getId_srv(), srv.getName());
						info.getDescList().add(primdMap.get(srv.getId_srv()).toString());
					}
				}
			}
		}
		if (null != errorMap) {
			for (BDErrorInfo info : errorList) {
				if (errorMap != null && errorMap.containsKey(info.getId_item())) {
					info.getDescList().add(errorMap.get(info.getId_item()).toString());
					errorMap.remove(info.getId_item());
				}
			}
			if (errorMap != null && errorMap.size() != 0) {
				for (MedSrvDO srv : srvList) {
					if (errorMap.containsKey(srv.getId_srv())) {
						BDErrorInfo info = new BDErrorInfo(srv.getId_srv(), srv.getName());
						info.getDescList().add(errorMap.get(srv.getId_srv()).toString());
					}
				}
			}
		}

		return Save(srvList, errorList);
	}

	/**
	 * 校验用血类型的服务只可以启用一个(前台启用服务)
	 * 
	 * @param srvlist
	 * @param e
	 * @throws BizException
	 */
	// private Map<String, String> CheckSrvBloodOnlyInfo2(MedSrvDO[] srvlist) throws
	// BizException {
	// List<MedSrvDO> bloodsrvlist = new ArrayList<MedSrvDO>();
	// for (MedSrvDO srvdo : srvlist) {
	// if (srvdo.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
	// bloodsrvlist.add(srvdo);
	// }
	// }
	// if (bloodsrvlist.size() == 0)
	// return null;
	// Map<String, String> bloodMsgMap = new HashMap<String, String>();
	// IMedsrvMDORService rService = ServiceFinder.find(IMedsrvMDORService.class);
	// MedSrvDO[] allbooldsrvs = rService.find(
	// " a0.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE + "' and
	// a0.fg_active='Y'", null,
	// FBoolean.FALSE);
	// if (allbooldsrvs.length == 0) {
	// if (bloodsrvlist.size() > 1) {
	// for (MedSrvDO srvdo : bloodsrvlist) {
	// bloodMsgMap.put(srvdo.getId_srv(), "只能启用一个用血类型的服务");
	// }
	// }
	// } else {
	// for (MedSrvDO srvdo : bloodsrvlist) {
	// bloodMsgMap.put(srvdo.getId_srv(), "只能启用一个用血类型的服务");
	// }
	// }
	// return bloodMsgMap;
	// }
	/**
	 * 同类型服务只能启用一个
	 * 
	 * @param srvlist
	 * @param e
	 * @throws BizException
	 */
	private Map<String, String> CheckSrvActiveOnly(MedSrvDO[] srvlist, int sno) throws BizException {
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		// 用血类型
		List<MedSrvDO> bloodsrvlist = new ArrayList<MedSrvDO>();
		// 容器类型
		List<MedSrvDO> contsrvlist = new ArrayList<MedSrvDO>();
		for (MedSrvDO srvdo : srvlist) {
			switch (srvdo.getSd_srvtp()) {
			case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE:// 用血
				bloodsrvlist.add(srvdo);
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_SANI_SC:// 容器
				contsrvlist.add(srvdo);
				break;
			default:
				break;
			}
		}
		if (bloodsrvlist.size() != 0) {
			if (sno == 0) {
				CheckbloodSrvOnlyInfo(bloodsrvlist, errorMsgMap);
			} else {
				CheckbloodSrvOnlyInfo2(bloodsrvlist, errorMsgMap);

			}
		}
		if (contsrvlist.size() != 0) {
			if (sno == 0) {
				CheckContSrvOnlyInfo(contsrvlist, errorMsgMap);
			} else {
				CheckContSrvOnlyInfo2(contsrvlist, errorMsgMap);

			}
		}
		return errorMsgMap;
	}

	/**
	 * 用血类型服务启用一个校验 任务调用
	 * 
	 * @param srvlist
	 * @param e
	 * @return
	 * @throws BizException
	 */
	private void CheckbloodSrvOnlyInfo(List<MedSrvDO> srvactives, Map<String, String> errorMsgMap) throws BizException {

		if (srvactives.size() == 0)
			return;
		if (srvactives.size() > 1) {
			for (MedSrvDO srvdo : srvactives) {
				if (srvdo.getSd_srvtp() == IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE) {
					errorMsgMap.put(srvdo.getId_srv(), "只能启用一个用血类型的服务");
				}
			}
		}
	}

	/**
	 * 容器服务启用一个校验 任务调用
	 * 
	 * @param srvlist
	 * @param e
	 * @throws BizException
	 */
	private void CheckContSrvOnlyInfo(List<MedSrvDO> srvactives, Map<String, String> errorMsgMap) throws BizException {
		if (srvactives.size() == 0)
			return;
		Map<String, List<String>> contMap = new HashMap<String, List<String>>();
		Map<String, MedSrvDO> tmpKeyList = new HashMap<String, MedSrvDO>();
		for (MedSrvDO srv : srvactives) {
			MedSrvSaniDO[] szMedSrvSaniDO = ServiceFinder.find(IMedSrvSaniDORService.class)
					.find(String.format(" id_srv = '%s'", srv.getId_srv()), "", FBoolean.FALSE);
			if (szMedSrvSaniDO == null || szMedSrvSaniDO.length == 0)
				continue;
			if (contMap.containsKey(szMedSrvSaniDO[0].getSd_sanitp())) {
				contMap.get(szMedSrvSaniDO[0].getSd_sanitp()).add(srv.getId_srv());
			} else {
				List<String> srvidlist = new ArrayList<String>();
				srvidlist.add(srv.getId_srv());
				contMap.put(szMedSrvSaniDO[0].getSd_sanitp(), srvidlist);
			}
			//
			tmpKeyList.put(szMedSrvSaniDO[0].getSd_sanitp(), srv);
		}
		for (String srv : tmpKeyList.keySet()) {
			if (contMap.get(srv).size() != 0) {
				errorMsgMap.put(tmpKeyList.get(srv).getId_srv(), "只能启用一个耗材分类相同的容器类型服务");
			}
		}

	}

	/**
	 * 用血服务启用一个校验 前台调用
	 * 
	 * @param srvlist
	 * @param e
	 * @throws BizException
	 */
	private void CheckbloodSrvOnlyInfo2(List<MedSrvDO> srvactives, Map<String, String> errorMsgMap)
			throws BizException {
		if (srvactives.size() == 0)
			return;
		IMedsrvMDORService rService = ServiceFinder.find(IMedsrvMDORService.class);
		String wherestr = " a0.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE + "' and  a0.fg_active='Y'";
		MedSrvDO[] allsrvs = rService.find(wherestr, null, FBoolean.FALSE);
		if (allsrvs.length == 0) {
			if (srvactives.size() > 1) {
				for (MedSrvDO srvdo : srvactives) {
					errorMsgMap.put(srvdo.getId_srv(), "只能启用一个用血类型的服务");
				}
			}
		} else {
			for (MedSrvDO srvdo : srvactives) {
				errorMsgMap.put(srvdo.getId_srv(), "只能启用一个用血类型的服务");
			}
		}

	}

	/**
	 * 容器服务启用一个校验 前台调用
	 * 
	 * @param srvlist
	 * @param e
	 * @throws BizException
	 */
	private void CheckContSrvOnlyInfo2(List<MedSrvDO> srvactives, Map<String, String> errorMsgMap) throws BizException {
		if (srvactives.size() == 0)
			return;
		IMedsrvRService rService = ServiceFinder.find(IMedsrvRService.class);
		String wherestr = " a0.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_SANI_SC + "' and  a0.fg_active='Y'";
		MedsrvAggDO[] allsrvs = rService.find(wherestr, null, FBoolean.FALSE);
		Map<String, List<String>> contMap = new HashMap<String, List<String>>();
		Map<String, MedSrvSaniDO> tmpKeyList = new HashMap<String, MedSrvSaniDO>();
		for (MedsrvAggDO agg : allsrvs) {
			MedSrvSaniDO[] szMedSrvSaniDO = ServiceFinder.find(IMedSrvSaniDORService.class)
					.find(String.format(" id_srv = '%s'", agg.getParentDO().getId_srv()), "", FBoolean.FALSE);
			if (contMap.containsKey(szMedSrvSaniDO[0].getSd_sanitp())) {
				contMap.get(szMedSrvSaniDO[0].getSd_sanitp()).add(agg.getParentDO().getId_srv());
			} else {
				List<String> srvidlist = new ArrayList<String>();
				srvidlist.add(agg.getParentDO().getId_srv());
				contMap.put(szMedSrvSaniDO[0].getSd_sanitp(), srvidlist);
			}
			tmpKeyList.put(agg.getParentDO().getId_srv(), szMedSrvSaniDO[0]);
		}
		for (String srvid : tmpKeyList.keySet()) {
			if (contMap.get(tmpKeyList.get(srvid).getSd_sanitp()).size() != 0) {
				errorMsgMap.put(srvid, "只能启用一个耗材分类相同的容器类型服务");
			}
		}

	}

	/**
	 * 获得费用不完整信息
	 * 
	 * @param srvlist
	 * @param e
	 * @return
	 * @throws BizException
	 */
	private FMap CheckSrvPrimdOnlyInfo(List<String> idsrvs) throws BizException {
		IPriCalService rService = ServiceFinder.find(IPriCalService.class);
		FMap srvmap = rService.integrityVerification_BdPriSrv(idsrvs.toArray(new String[0]));
		if (srvmap.size() == 0)
			return null;
		return srvmap;
	}

	/**
	 * 获取医疗服务校验规则
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	IMedSrvValidate GetMedSrvValidate(String sd_srvtp) {
		IMedSrvValidate validate = null;
		switch (sd_srvtp.substring(0, 2)) {
		case IBdSrvDictCodeConst.SD_SRVTP_DRUG: // "01"; // 药品
		{
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG: // "0101"; // 西药
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_KF: // "010101"; //
			// 口服类药品
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_WY: // "010102"; //
			// 外用药
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX: // "010103"; //
			// 注射类药品
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY: // "010104"; //
			// 溶媒
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY: // "010105"; //
			// 皮试液
			// case IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_OTHER: // "010199"; //
			// 其它
			// case IBdSrvDictCodeConst.SD_SRVTP_CYDRUG: // "0102"; // 成药
			// case IBdSrvDictCodeConst.SD_SRVTP_CYDRUG_CHINA: // "010201"; //
			// 中成药
			// case IBdSrvDictCodeConst.SD_SRVTP_CYDRUG_MENG: // "010202"; //
			// 蒙成药
			// case IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG: // "0103"; // 草药
			// case IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG_CHINA: // "010301"; //
			// 中药材
			// case IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG_MENG: // "010302"; //
			// 蒙药材
		}
			validate = new BDDrugSrvValidate();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_RIS: // "02"; // 检查
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_TOUSHI: // "0201"; // 透视
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_XRAY: // "0202"; // X线
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_CT: // "0203"; // CT
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_HECI: // "0204"; // 核磁
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_DAOGUAN: // "0205"; // 导管介入
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_BCHAO: // "0206"; // B超
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI: // "0207"; // 病理
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_DIANSHENGLI: // "0208"; // 电生理
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_NEIJING: // "0209"; // 内镜
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_FUNCCHECK: // "0210"; //
			// // 功能性检查（如肺活量检查）
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_NUCLEAR_A: // "0211"; // 核医学
			// case IBdSrvDictCodeConst.SD_SRVTP_RIS_OTHER: // "0299"; // 其它1
			if (sd_srvtp.length() >= 4 && sd_srvtp.substring(2, 4).equals("07")) {
				validate = new BDPathologySrvValidate();
			} else {
				validate = new BDRisSrvValidate();
			}
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_LIS: // "03"; // 检验
			// case IBdSrvDictCodeConst.SD_SRVTP_LIS_NORMAL: // "0301"; // 常规检验
			// case IBdSrvDictCodeConst.SD_SRVTP_LIS_SHENGHUA: // "0302"; // 生化检验
			// case IBdSrvDictCodeConst.SD_SRVTP_LIS_MIANYI: // "0303"; // 免疫检验
			// case IBdSrvDictCodeConst.SD_SRVTP_LIS_MICROGERM: // "0304"; // 微生物检验
			//
			// // case IBdSrvDictCodeConst.SD_SRVTP_LIS_SKINMINGANTEST : // "0305";
			// // //临检检查--->皮肤敏感性试验
			// case IBdSrvDictCodeConst.SD_SRVTP_LIS_OTHER: // "0399"; // 其它2
			validate = new BDLisSrvValidate();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_OP: // "04"; // 手术
			// case IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI: // "0401"; // 台次手术
			// case IBdSrvDictCodeConst.SD_SRVTP_OP_BESIDEDEB: // "0402"; // 床边手术
			validate = new BDOpsSrvValidate();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_TREAT: // "05"; // 治疗
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_NORMAL: // "0501"; // 普通治疗
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_FANGLIAO: // "0502"; // 放疗
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG: // "0503"; // 吸氧
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_WUHUA: // "0504"; // 雾化吸入
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT: // "0505"; // 膳食(包括肠内外营养)
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST: // "0506"; //
			// // 治疗--->皮肤敏感性试验
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_RESCUE: // "0507"; // 抢救
			// case IBdSrvDictCodeConst.SD_SRVTP_TREAT_TOUXI: // "0508"; // 透析
			validate = new BDTreatSrvValidate();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_NURSE: // "06"; // 护理
			// case IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED: // "0601"; // 护理等级
			// case IBdSrvDictCodeConst.SD_SRVTP_NURSE_TREATNS: // "0602"; // 治疗性护理
			// case IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS: // "0603"; // 生命体征
			if (sd_srvtp.length() >= 4 && sd_srvtp.substring(2, 4).equals("03")) {
				validate = new BDVitalSignsSrvValidate();

			} else {
				validate = new BDNurseSrvValidate();
			}
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_SANI: // "07"; // 卫材
			// case IBdSrvDictCodeConst.SD_SRVTP_SANI_A: // "0701"; // 卫生材料
			// case IBdSrvDictCodeConst.SD_SRVTP_SANI_SC: // "0702"; // 标本容器
			// case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST: // "08"; // 嘱托
			// case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A: // "0801"; // 嘱托1
			// case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_PROEDU: // "0802"; // 宣教
			// case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_ILLSTATE: // "0803"; // 病情
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT: // "09"; // 诊疗
			// case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP: // "0901"; // 门急诊诊疗
			// case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP: // "090101"; // 专家
			// case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM: // "090102"; // 普通
			// case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG: // "090103"; // 急诊
			// case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS: // "0902"; //
			if (sd_srvtp.length() >= 4 && sd_srvtp.substring(2, 4).equals("02")) {
				validate = new BDConsSrvValidate();
				break;
			}
			// 会诊与跨科
		case IBdSrvDictCodeConst.SD_SRVTP_HEALTH: // "10"; // 健康
			// case IBdSrvDictCodeConst.SD_SRVTP_HEALTH_BASIC: // "1001"; // 基本公共卫生服务
			// case IBdSrvDictCodeConst.SD_SRVTP_HEALTH_MAN: // "1002"; // 公共卫生管理
		case IBdSrvDictCodeConst.SD_SRVTP_SRVPKG: // "11"; // 诊疗方案服务包
			// case IBdSrvDictCodeConst.SD_SRVTP_SRVPKG_PHYEXAM: // "1101"; // 体检包
			// case IBdSrvDictCodeConst.SD_SRVTP_SRVPKG_OTHER: // "1199"; // 其它3
		case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN: // "12"; // 患者管理类
			// case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT: // "1201"; // 转科
			// case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS: // "1202"; // 出院
			// case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH: // "1203"; // 宣布临床死亡
			// case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT: // "1204"; // 跨科
			// case IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD: // "1205"; // 转病区
		case IBdSrvDictCodeConst.SD_SRVTP_FIXFEE: // "13"; // 固定费用类
			// case IBdSrvDictCodeConst.SD_SRVTP_FIXFEE_IP: // "1301"; // 住院固定收费
		case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD: // "14"; // 血液制品
			// case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_A: // "1401"; // 血液制品1
			// case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE: // "140101"; // 备血
			// case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE: // "140102"; // 用血
			// case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_REPL: // "1402"; // 血液代用品
		case IBdSrvDictCodeConst.SD_SRVTP_OTHER: // "99"; // 其他

		default:
			validate = new BDBaseSrvValidate();

		}

		return validate;
	}

	/**
	 * 错误信息保存为报告
	 * 
	 * @param errorList
	 * @return
	 */
	private String Save(MedSrvDO[] srvAggList, List<BDErrorInfo> errorList) throws BizException {

		long index = 1;
		StringBuilder sb = new StringBuilder(
				errorList.size() > 0
						? String.format("摘要：时间：%s, 本次共扫描基础数据 %d条、错误数据 %d条，详细信息如下:\n",
								CiOrdAppUtils.getServerDateTime().toLocalString(), srvAggList.length, errorList.size())
						: "");
		for (BDErrorInfo info : errorList) {
			sb.append(index++).append("---------------------------------").append(BDErrorInfo.NextLineString)
					.append(info.toReportString(""));

		}
		if (errorList.size() > 0) {
			sb.append("\n============================\n结束");
		} else {
			sb.append("恭喜您，基于固定规则数据检验合格，没有发现问题！");
		}

		// xap.mw.basic.storage.StorageService ss =
		// ServiceFinder.find(xap.mw.basic.storage.StorageService.class);
//		try {
////			String platformGroup = ClientGlobal.fastDfsConfig.getPlatformGroup();
//			byte[] szData = sb.toString().getBytes("UTF-8");
//			// group1/M01/00/03/wKggD1gcesyEHw1IAAAAACd_gfM1265379
//			ss.write("M00/00/01/wKhJEFjPjCWEM_2LAAAAAO15o1A0027192", new BinaryImpl(null, szData.length, new ByteArrayInputStream(szData)));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Logger.error("写入文件失败 !",e);
//
//		}

		final String str = sb.toString();
		try {
			xap.mw.basic.storage.StorageService ss = ServiceFinder.find(xap.mw.basic.storage.StorageService.class);
//			String platformGroup = ClientGlobal.fastDfsConfig.getPlatformGroup();
//			System.out.print(platformGroup);
			byte[] szData = str.getBytes("UTF-8");
			FBinary bin = BinaryBuilder.builder().withSize(szData.length).withBody(new ByteArrayInputStream(szData))
					.build();
			String rstPath = ss.write("M00/00/01/wKhJD1k3hWuEdFQMAAAAAE-tP7s5815157", bin);
//			System.out.print(str1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

//	/**
//	 * 校验用血类型的服务只可以启用一个
//	 * 
//	 * @param srvlist
//	 * @param e
//	 * @throws BizException
//	 */
//	private void CheckSrvBloodOnlyInfo(MedSrvDO[] srvlist, List<BDErrorInfo> e) throws BizException {
//		List<MedSrvDO> bloodsrvlist = new ArrayList<MedSrvDO>();
//		for (MedSrvDO srvdo : srvlist) {
//			if (srvdo.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
//				bloodsrvlist.add(srvdo);
//			}
//		}
//		if (bloodsrvlist.size() == 0)
//			return;
//		IMedsrvMDORService rService = ServiceFinder.find(IMedsrvMDORService.class);
//		MedSrvDO[] allbooldsrvs = rService.find(
//				" a0.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE + "' and  a0.fg_active='Y'", null,
//				FBoolean.FALSE);
//		if (allbooldsrvs.length == 0) {
//			if (bloodsrvlist.size() > 1) {
//				for (MedSrvDO srvdo : bloodsrvlist) {
//					BDErrorInfo info = new BDErrorInfo(srvdo.getId_srv(), srvdo.getName());
//					info.getDescList().add("只能启用一个用血类型的服务");
//					e.add(info);
//				}
//			}
//		} else {
//			for (MedSrvDO srvdo : bloodsrvlist) {
//				BDErrorInfo info = new BDErrorInfo(srvdo.getId_srv(), srvdo.getName());
//				info.getDescList().add("只能启用一个用血类型的服务");
//				e.add(info);
//			}
//		}
//	}

//	/**
//	 * 获得费用不完整信息
//	 * 
//	 * @param srvlist
//	 * @param e
//	 * @return
//	 * @throws BizException
//	 */
//	private FMap CheckSrvPrimdOnlyInfo(List<String> idsrvs, List<BDErrorInfo> e) throws BizException {
//		IPriCalService rService = ServiceFinder.find(IPriCalService.class);
//		FMap srvmap = rService.integrityVerification_BdPriSrv(idsrvs.toArray(new String[0]));
//		if (srvmap.size() == 0)
//			return null;
//		return srvmap;
//	}

	public MedvalidateAggDO[] saveAgg(List<BDErrorInfo> errorList) {
		List<MedvalidateAggDO> aggList = new ArrayList<MedvalidateAggDO>();
		for (BDErrorInfo info : errorList) {
			aggList.add(dataFromBDErrorInfo(info));
		}
		return aggList.toArray(new MedvalidateAggDO[aggList.size()]);
	}

	private MedvalidateAggDO dataFromBDErrorInfo(BDErrorInfo info) {
		BDErrorInfoDO d = new BDErrorInfoDO();

		d.setId_item(info.getId_item());
		d.setName_item(info.getName_item());
		d.setError_info(info.toErrorString());
		List<BDErrorInfoItemDO> childItems = new ArrayList<BDErrorInfoItemDO>();
		for (BDErrorInfo i : info.getSubItems()) {
			BDErrorInfoItemDO item = new BDErrorInfoItemDO();
			item.setId_item(i.getId_item());
			item.setName_item(i.getName_item());
			item.setError_info(i.toErrorString());
			childItems.add(item);
		}

		MedvalidateAggDO agg = new MedvalidateAggDO();
		agg.setParent(d);
		if (childItems != null && childItems.size() > 0) {
			agg.setChildrenDO(childItems.toArray(new BDErrorInfoItemDO[childItems.size()]));
		}
		return agg;
	}
}
