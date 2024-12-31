package iih.bl.cg.bp.self;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.param.IBdPpParamValueConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import iih.bd.utils.BdPpParamUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.i.IBlCgQryService;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 拼接医保需要的xml
 * 
 * @author LIM
 *
 */

public class GetOrderXmlBp {
	/**
	 * 获取医保分解XML
	 * 
	 * @param dtos
	 * @param code
	 * @param operatorCode
	 * @param entpCode
	 * @param personXml
	 * @return
	 * @throws BizException
	 */
	public String Divide(BlCgOepAggDTO cgaggDto, String code, String operatorCode, String entpCode, String personXml) throws BizException {
		// 1.通过医保患者XML 获取医保患者类型
		String personType = GetPersonType(personXml);

		// 3.获取支付明细数据
		List<BlCgItmOepDO> dtos = new ArrayList<BlCgItmOepDO>();
		if (cgaggDto != null) {
			GetInBlCgItmOepDOBp bp = new GetInBlCgItmOepDOBp();
			dtos = bp.exec(cgaggDto);
		}
		return exec(dtos, code, operatorCode, entpCode, personType);
	}

	/**
	 * 封装参数提高复用率
	 * 
	 * @param dtos
	 * @param code
	 * @param operatorCode
	 * @param entpCode
	 * @param personType
	 * @return
	 * @throws BizException
	 */
	public String exec(List<BlCgItmOepDO> dtos, String code, String operatorCode, String entpCode, String personType) throws BizException {
		// 1.判断当前流水号如果为null则使用当前时间转为字符串格式提交到医保
		if (code == null) {
			code = DateTimeUtils.toStringFDateTimeFormat(AppUtils.getServerDateTime());
		}
		// 2.获取相关医嘱信息
		OrSrvGuideDTO[] orsrv = null;

		List<String> lstIdOrsrv = new ArrayList<String>();
		for (BlCgItmOepDO itm : dtos) {
			if (!StringUtil.isEmpty(itm.getId_orsrv())) {
				lstIdOrsrv.add(itm.getId_orsrv());
			}
		}
		if (lstIdOrsrv.size() != 0) {
			IBLCiOrderToBlCgService ser = ServiceFinder.find(IBLCiOrderToBlCgService.class);
			orsrv = ser.getOrSrvGuideDTO(lstIdOrsrv.toArray(new String[lstIdOrsrv.size()]));
		}

		// 拼装 XML
		StringBuilder sIn = new StringBuilder();

		sIn.append("<?xml version=\"1.0\" encoding=\"utf-16\" standalone=\"yes\"?>");
		sIn.append("<root version=\"2.003\" sender=\"BDYLXXJS00002.100168\">");
		// 医院编码,这里的版本号一定要格式正确，否则会报错
		sIn.append("<input>");
		// 赋值tradeinfo节点数据
		sIn.append(GetXmlHeadString(entpCode, code, operatorCode));

		// 赋值recipearray节点数据
		sIn.append(GetXmlRecipesString(personType, dtos, orsrv));

		// 赋值feeitemaray节点数据
		sIn.append(GetXmlFeeitemsString(entpCode, personType, dtos, orsrv));

		sIn.append("</input>");
		sIn.append("</root>");
		return sIn.toString();
	}

	/**
	 * 赋值feeitemaray节点数据
	 * 
	 * @param entpCode
	 * @param personType
	 * @param dtos
	 * @param orsrv
	 * @return
	 * @throws BizException
	 */
	private String GetXmlFeeitemsString(String entpCode, String personType, List<BlCgItmOepDO> dtos, OrSrvGuideDTO[] orsrv) throws BizException {
		StringBuilder retVal = new StringBuilder();
		retVal.append("<feeitemarray>");
		// 明细项目序号
		int itemno = 1;
		for (BlCgItmOepDO s : dtos) {
			String hisItemName = "";
			FDouble fee;
			// 获取当前记账数据的医嘱信息
			OrSrvGuideDTO orSrvGuideDTO = new OrSrvGuideDTO();
			if (orsrv != null)
				for (OrSrvGuideDTO orarvdto : orsrv) {
					if (orarvdto.getId_orsrv() == s.getId_orsrv()) {
						orSrvGuideDTO = orarvdto;
						break;
					}
				}
			FilterFeeItem(entpCode, personType, s, orSrvGuideDTO);
			SetPayRatioDo(s);
			if (s.getSd_srvtp().startsWith("0103")) {
				// his项目名称
				hisItemName = "中药饮片及药材";
			} else {
				if (IBdPpParamValueConst.MI_DRUGNAMETYP_MMNAME.equals(BdPpParamUtils.GetMiDrugNameType())) {// 物品名
					hisItemName = s.getFg_mm() == FBoolean.TRUE ? s.getName_mm() : s.getName_srv();
				} else if (IBdPpParamValueConst.MI_DRUGNAMETYP_SRVNAME.equals(BdPpParamUtils.GetMiDrugNameType())) {// 通用名
					hisItemName = s.getName_srv();
				} else if (IBdPpParamValueConst.MI_DRUGNAMETYP_MINAME.equals(BdPpParamUtils.GetMiDrugNameType())) {// 医保名

					if (s.getFg_mm() == FBoolean.TRUE) {
						// 获取医保名称
						String hiName = getHinameByIdmm(s.getId_mm());
						if (!StringUtil.isEmpty(hiName)) {
							hisItemName = hiName;
						} else {
							hisItemName = s.getName_mm();
						}

					} else {
						hisItemName = s.getName_srv();
					}
				}

			}
			// 项目总金额
			fee = s.getPrice_ratio().multiply(s.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
			FDouble countQan = s.getQuan().setScale(0, BigDecimal.ROUND_HALF_UP);
			FDouble price = s.getPrice_ratio().setScale(-4, BigDecimal.ROUND_HALF_UP);
			if ((countQan.doubleValue() - s.getQuan().doubleValue()) != 0) {
				countQan = new FDouble(1);
				price = s.getQuan().multiply(price).setScale(-4, BigDecimal.ROUND_HALF_UP);
			}

			retVal.append(" <feeitem itemno=\"" + itemno + "\"");
			retVal.append(" recipeno=\"" + s.getId_pres() + "\"");
			retVal.append("  hiscode=\"" + (s.getFg_mm() == FBoolean.TRUE ? s.getCode_mm() : s.getCode_srv()) + "\"");
			retVal.append(" itemname=\"" + hisItemName + "\"");
			retVal.append(" itemtype=\"" + (getValue(s.getSd_srvtp()).indexOf("01") == 0 ? 0 : 1) + "\"");
			retVal.append(" unitprice=\"" + price + "\" ");
			retVal.append(" count=\"" + countQan.setScale(2, BigDecimal.ROUND_FLOOR) + "\" ");
			retVal.append(" fee=\"" + fee + "\" ");
			retVal.append(" dose=\"" + getValue(orSrvGuideDTO.getDosecode_hp()) + "\" ");
			retVal.append(" specification=\"" + getValue(s.getSd_srvtp().startsWith("0103") == true ? s.getName_mm() : s.getSpec()) + "\" ");
			retVal.append(" unit=\"" + getValue(orSrvGuideDTO.getName_medu()) + "\" ");
			retVal.append(" howtouse=\"" + getValue(orSrvGuideDTO.getFreqcode_hp()) + "\" ");
			retVal.append(" dosage=\"" + getValue(orSrvGuideDTO.getDosage()) + "\" ");
			retVal.append(" packaging=\"" + getValue(getPgkuName(s.getPgku_cur())) + "\" ");
			retVal.append(" minpackage=\"" + getValue(getPgkuName(s.getPgku_base())) + "\" ");
			retVal.append(" conversion=\"" + (orSrvGuideDTO.getFactor() == null ? "0.00" : orSrvGuideDTO.getFactor().setScale(-2, BigDecimal.ROUND_HALF_UP)) + "\"");
			retVal.append(" days=\"" + (orSrvGuideDTO.getDays() == null ? 1 : orSrvGuideDTO.getDays()) + "\" ");
			retVal.append(" babyflag=\"0\"");
			retVal.append(" drugapprovalnumber =\"" + getValue(s.getApprno()) + "\"/>");
			itemno++;
		}
		retVal.append("</feeitemarray>");
		return retVal.toString();
	}

	/**
	 * 赋值recipearray节点数据 处方信息
	 * 
	 * @param personType
	 *            患者类型
	 * @param dtos
	 *            记账明细
	 * @param orsrv
	 *            医嘱服务信息
	 * @return
	 * @throws BizException
	 */
	private String GetXmlRecipesString(String personType, List<BlCgItmOepDO> dtos, OrSrvGuideDTO[] orsrv) throws BizException {
		StringBuilder retVal = new StringBuilder();
		retVal.append("<recipearray>");
		// 诊断序号
		int i = 1;
		// 判断是否全包内
		boolean isAllIn = isAllInInsure(personType);
		// 获取处方信息
		RecipeDTO[] recipeDTOArry = getRecipeDTOsByDtos(dtos, orsrv);

		// 拼装处方字符串
		for (RecipeDTO pp : recipeDTOArry) {
			String[] diNames = { "" };
			String[] diCodes = { "" };

			if (!StringUtil.isEmpty(pp.getDidef_name())) {
				diNames = pp.getDidef_name().split("\\&");
			}
			if (!StringUtil.isEmpty(pp.getDidef_code())) {
				diCodes = pp.getDidef_code().split("\\&");
			}
			for (int j = 0; j < diNames.length; j++) {
				retVal.append("<recipe>");
				retVal.append("  <diagnoseno name=\"诊断序号\">" + (i++) + "</diagnoseno>");
				retVal.append("  <recipeno name=\"处方序号\">" + pp.getId_pres() + "</recipeno>");
				retVal.append("  <recipedate name=\"处方日期时间\">" + DateTimeUtils.toStringFDateTimeFormat(pp.getDt_entry()) + "</recipedate>");
				retVal.append("  <diagnosename name=\"诊断名称\">" + diNames[j] + "</diagnosename>");
				retVal.append("  <diagnosecode name=\"诊断编码\">" + diCodes[j] + "</diagnosecode>");
				String nr = pp.getMr_content();
				// 拼XML 做解析
				if (nr != null) {
					nr = nr.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");
				}
				retVal.append("  <medicalrecord name=\"病历信息\">" + getValue(nr) + "</medicalrecord>");

				retVal.append("  <sectioncode name=\"就诊科别代码\">" + pp.getDepcode_hp() + "</sectioncode>");
				retVal.append("  <sectionname name=\"就诊科别名称\">" + pp.getDepname_hp() + "</sectionname>");
				retVal.append("  <hissectionname name=\"his就诊科别名称\">" + pp.getId_dep_name() + "</hissectionname>");
				retVal.append("  <drid name=\"医师编号\">" + pp.getId_emp_or() + "</drid>");
				retVal.append("  <drname name=\"医师姓名\">" + pp.getId_emp_name() + "</drname>");
				retVal.append("  <recipetype name=\"处方类别（1：医保内处方 2：医保外处方）\">" + (isAllIn ? "1" : (pp.getRecipetype() != null && pp.getRecipetype().booleanValue() ? "1" : "2")) + "</recipetype>");
				retVal.append("  <drlevel name=\"医师职称\"></drlevel>");

				retVal.append("  <helpmedicineflag name=\"代开药标识\">" + (pp.getHelpmedicineflag() != null && pp.getHelpmedicineflag().booleanValue() ? pp.getHelpmedicineflag() : 0) + "</helpmedicineflag>");
				retVal.append("  <remark name=\"备注\">" + getValue(pp.getRemark()) + "</remark>");
				retVal.append("  <registertradeno name=\"挂号交易流水号\">" + getValue(pp.getRegistertradeno()) + "</registertradeno>");
				retVal.append("  <billstype name=\"单据类型（1-挂号；2-西药或中成药处方；4-中草药处方；5-检验治疗；）\">" + pp.getBillstype() + "</billstype>");
				retVal.append("</recipe>");
			}

		}
		retVal.append("</recipearray>");
		return retVal.toString();
	}

	/**
	 * 获取tradeinfo节点XML数据
	 * 
	 * @param entpCode
	 *            就诊类型
	 * @param code
	 *            单据编号
	 * @param operatorCode
	 *            操作人员编号
	 * @return
	 */
	private String GetXmlHeadString(String entpCode, String code, String operatorCode) {
		StringBuilder retVal = new StringBuilder();
		retVal.append("      <tradeinfo>");
		retVal.append("          <curetype name=\"就诊类型，11门诊，19急诊，17门诊挂号，18急诊挂号\">" + entpCode + "</curetype>");
		retVal.append("          <illtype name=\"就诊方式 0普通 其他未启用\">0</illtype>");
		retVal.append("          <feeno name=\"收费单据号\">" + code + "</feeno>");
		retVal.append("          <operator name=\"oper\">" + operatorCode + "</operator >");
		retVal.append("      </tradeinfo>");
		return retVal.toString();
	}

	/**
	 * 获取字符信息
	 * 
	 * @param str
	 * @return
	 */
	private String getValue(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 是否是全包内患者
	 * 
	 * @return
	 * @throws BizException
	 */
	private boolean isAllInInsure(String personType) throws BizException {
//		注释当前代码  ， 已修改到 适应症校验中 2018年1月22日11:07:31 yang.lu
//		IBdHpPatcaDORService service = ServiceFinder.find(IBdHpPatcaDORService.class);
//		BdHpPatcaDO[] pactcaArray = service.find("Fg_allinhp='Y' and Code_hppatca='" + personType + "'", "", FBoolean.FALSE);
//		if (pactcaArray != null && pactcaArray.length == 1) {
//			return true;
//		}
		return false;
	}

	/**
	 * 单位名称 获取一次多次调用
	 */
	HashMap<String, String> pgkuMap;

	/**
	 * 就诊次数
	 */
	HashMap<String, Integer> timeOpMap;

	/**
	 * 获取单位名称
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getPgkuName(String pgkuId) throws DAException {
		if (StringUtil.isEmpty(pgkuId))
			return "";
		if (pgkuMap == null) {
			String[] fields = { "Id_measdoc", "Name" };
			DAFacade dAFacade = new DAFacade();
			pgkuMap = new HashMap<>();
			List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
			for (MeasDocDO mdoDo : measDocDOList) {
				pgkuMap.put(mdoDo.getId_measdoc(), mdoDo.getName());
			}
		}
		if (pgkuMap.containsKey(pgkuId)) {
			return pgkuMap.get(pgkuId);
		}
		return "";
	}

	/**
	 * 过滤挂号医嘱服务
	 * 
	 * @param cureType
	 * @param personType
	 *            医保卡类型
	 * @param itm
	 * @param orSrvGuideDTO
	 *            医嘱
	 */
	private void FilterFeeItem(String cureType, String personType, BlCgItmOepDO itm, OrSrvGuideDTO orSrvGuideDTO) {
		if (cureType != "17" && cureType != "18")
			return;
		
		String[] inPtps = { "102", "103", "113", "121", "122", "123", "124", "125", "126", "133", "134", "135", "136", "137", "138", "143", "144", "145", "146", "28", "29", "30", "31", "32", "33", "35", "36", "37", "38", "39", "43", "44", "45", "46", "51", "57" };
		if (Arrays.asList(inPtps).contains(personType)) {
			boolean isSet = false;
			switch (itm.getCode_srv()) {
			case "816627":
				itm.setCode_srv("w0101020021");
				itm.setName_srv("医事服务费【三级医院】【普通门诊】【离休及医照人员】");
				isSet = true;
				break;
			case "816628":
				itm.setCode_srv("w0101020015");
				itm.setName_srv("医事服务费【三级医院】【副主任医师】【离休及医照人员】");
				isSet = true;
				break;
			case "816631":
				itm.setCode_srv("w0101020022");
				itm.setName_srv("医事服务费【三级医院】【急诊】【离休及医照人员】");
				isSet = true;
				break;
			case "816629":
				itm.setCode_srv("w0101020016");
				itm.setName_srv("医事服务费【三级医院】【主任医师】【离休及医照人员】");
				isSet = true;
				break;
			case "816630":
				itm.setCode_srv("w0101020017");
				itm.setName_srv("医事服务费【三级医院】【知名专家】【离休及医照人员】");
				isSet = true;
				break;
			case "821671":
				itm.setCode_srv("821685");
				itm.setName_srv("医事服务费(普通门诊)1(离休及医照人员)");
				isSet = true;
				break;
			case "821180":
				itm.setCode_srv("821680");
				itm.setName_srv("医事服务费(知名专家)1(离休及医照人员)");
				isSet = true;
				break;
			case "821181":
				itm.setCode_srv("821681");
				itm.setName_srv("医事服务费(知名专家)2(离休及医照人员)");
				isSet = true;
				break;
			case "821182":
				itm.setCode_srv("821682");
				itm.setName_srv("医事服务费(知名专家)3(离休及医照人员)");
				isSet = true;
				break;
			case "821185":
				itm.setCode_srv("821683");
				itm.setName_srv("医事服务费(知名专家)4(离休及医照人员)");
				isSet = true;
				break;
			case "821186":
				itm.setCode_srv("821684");
				itm.setName_srv("医事服务费(知名专家)5(离休及医照人员)");
				isSet = true;
				break;
			case "821278":
				itm.setCode_srv("821670");
				itm.setName_srv("医事服务费(离休及医照人员)");
				isSet = true;
				break;
			default:
				break;
			}
			if (isSet) {
				itm.setFg_mm(FBoolean.FALSE);
				itm.setSpec("人次");
				if (orSrvGuideDTO != null) {
					orSrvGuideDTO.setDosage("");
					orSrvGuideDTO.setName_medu("人次");
				}
			}
		}
	}

	/**
	 * 多支付比例集合
	 */
	SrvMPayRatioDO[] srvPay = null;

	/**
	 * 设置多支付比例
	 * 
	 * @param itm
	 * @throws BizException
	 */
	private void SetPayRatioDo(BlCgItmOepDO itm) throws BizException {
		if (ArrayUtil.isEmpty(srvPay)) {
			IBdHpQryService service = ServiceFinder.find(IBdHpQryService.class);
			srvPay = service.getAllSrvMutiPayRatio();
		}
		if (ArrayUtil.isEmpty(srvPay))
			return;
		for (SrvMPayRatioDO srvpayDo : srvPay) {
			if (srvpayDo.getId_srv().equals(itm.getId_srv()) && srvpayDo.getId_hp().equals(itm.getId_hp()) && srvpayDo.getId_mm().equals(itm.getId_mm()) && srvpayDo.getId_hpmpayratiodf().equals(itm.getId_hpsrvmpayratio())) {
				itm.setCode_mm(srvpayDo.getCode());
				itm.setCode_srv(srvpayDo.getCode());
			}
		}
	}

	/**
	 * 获取患者卡类型
	 * 
	 * @param personXml
	 * @return
	 * @throws BizException
	 */
	private String GetPersonType(String personXml) throws BizException {
		CardPersonInfoDTO presonInfo = new GetCardPersonByXmlBP().exec(personXml);
		if (presonInfo != null)
			return presonInfo.getPersontype();
		return "";
	}

	/**
	 * 组装处方数据
	 * 
	 * @param dtos
	 * @param orsrv
	 * @return
	 * @throws BizException
	 */
	private RecipeDTO[] getRecipeDTOsByDtos(List<BlCgItmOepDO> dtos, OrSrvGuideDTO[] orsrv) throws BizException {
		List<String> entList = new ArrayList<String>();
		for (BlCgItmOepDO cgitem : dtos) {
			entList.add(cgitem.getId_ent());
		}
		IBlCgQryService cgQryService = ServiceFinder.find(IBlCgQryService.class);
		RecipeDTO[] recips = cgQryService.getOpCgRecipeList(entList.toArray(new String[entList.size()]));

		HashMap<String, RecipeDTO> recMap = new HashMap<String, RecipeDTO>();

		if (!ArrayUtil.isEmpty(recips)) {
			// 处方保内或保外判断
			HashMap<String, Boolean> prenoTp = new HashMap<String, Boolean>();

			// 设置处方保内/外标识
			for (BlCgItmOepDO dto : dtos) {
				// 循环明细项目，拼装处方号 判断处方map中时候有包含此处方 保内外数据 如果没有 进行组装
				int timeOp = getTimesById_ent(dto.getId_ent());
				String presno = timeOp + dto.getCode_apply();
				if (!prenoTp.containsKey(presno)) {
					// 默认当前处方是保外处方
					boolean setVal = false;
					// 根据处方编号循环获取处方如果有意向数据为保内数据 认为当前处方为保内处方
					for (BlCgItmOepDO selDto : dtos) {
						if (presno.equals(timeOp + selDto.getCode_apply())) {
							// 获取此次记账的医嘱信息
							OrSrvGuideDTO orSrvGuideDTO = null;
							if (orsrv != null)
								for (OrSrvGuideDTO orarvdto : orsrv) {
									if (orarvdto.getId_orsrv() == selDto.getId_orsrv()) {
										orSrvGuideDTO = orarvdto;
										break;
									}
								}
							// 如果医嘱信息中自费标识为False 认为此处方应为保内处方
							if (orSrvGuideDTO != null && FBoolean.FALSE.equals(orSrvGuideDTO.getFg_selfpay())) {
								setVal = true;
								break;
							}
						}
					}
					prenoTp.put(presno, setVal);
				}
			}

			// 循环就诊编号获取对应就诊处方信息
			for (String entid : entList) {
				// 循环明细 获取处方编号
				for (BlCgItmOepDO dto : dtos) {
					int timeOp = getTimesById_ent(dto.getId_ent());
					// 当前处方编号为 就诊次数+分处方编码
					String presno = timeOp + getValue(dto.getCode_apply());
					dto.setId_pres(presno);
					// 判断map中是否包含此类处方 如果没有 创建此处方
					if (!recMap.containsKey(presno)) {
						for (RecipeDTO recitm : recips) {
							// 判断是当前就诊并且交易流水号不为空的时候
							if (entid.equals(recitm.getId_en()) && !StringUtil.isEmpty(recitm.getRegistertradeno())) {
								RecipeDTO recDto = new RecipeDTO();
								recDto = (RecipeDTO) recitm.clone();
								recDto.setId_pres(presno);
								// 设置处方开立时间
								recDto.setDt_entry(dto.getDt_or());
								// 设置是否保内
								// 就诊挂号数据默认为保内
								if (FeeOriginEnum.ENCOUNTER_FEE.equals(dto.getEu_srctp())) {
									recDto.setRecipetype(FBoolean.TRUE);
								} else {
									recDto.setRecipetype(new FBoolean(prenoTp.get(presno)));
								}
								// 如果开单医生不同 需要修改为当前医嘱开单医生
								if (!StringUtil.isEmpty(recDto.getId_emp_or()) && !"~".equals(recDto.getId_emp_or()) && !recDto.getId_emp_or().equals(dto.getId_emp_or())) {
									PsnDocDO doc = getPsnDocDO(dto.getId_emp_or());
									if (doc != null) {
										recDto.setId_emp_or(doc.getCode());
										recDto.setId_emp_name(doc.getName());
									}
								}
								// 设置处方类型 单据类型 1-挂号；2-西药或中成药处方；4-中草药处方；5-检验治疗；
								recDto.setBillstype("5");
								if (dto.getSd_srvtp().indexOf("0103") == 0) {
									recDto.setBillstype("4");
								} else if ("01".equals(dto.getCode_applytp())) {
									recDto.setBillstype("2");
								} else if (1 == dto.getEu_srctp()) {
									recDto.setBillstype("1");
								}
								recMap.put(presno, recDto);
							}
						}
					}
				}
			}

		} else {
			RecipeDTO recipeDTO = new RecipeDTO();
			recipeDTO.setId_pres(dtos.get(0).getId_pres());
			recipeDTO.setDt_entry(AppUtils.getServerDateTime());
			recipeDTO.setDidef_code("");
			recipeDTO.setDidef_name("");
			recipeDTO.setId_en("");
			// 获取医保科室编码 与名称---TODO需要修改
			recipeDTO.setDepcode_hp(dtos.get(0).getDepor_code());
			recipeDTO.setDepname_hp(dtos.get(0).getDepor_name());
			recipeDTO.setId_dep_name(dtos.get(0).getDepor_name());
			recipeDTO.setId_emp_or(dtos.get(0).getEmpor_code());
			recipeDTO.setId_emp_name(dtos.get(0).getEmpor_name());
			recipeDTO.setRecipetype(FBoolean.TRUE);
			recipeDTO.setHelpmedicineflag(FBoolean.FALSE);
			recipeDTO.setRegistertradeno("");
			recipeDTO.setBillstype("1");
			return new RecipeDTO[] { recipeDTO };
		}

		List<RecipeDTO> retList = new ArrayList<RecipeDTO>();
		for (Map.Entry<String, RecipeDTO> entry : recMap.entrySet()) {
			retList.add(entry.getValue());
		}

		return retList.toArray(new RecipeDTO[retList.size()]);
	}

	/**
	 * 获取就诊次数
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private int getTimesById_ent(String id_ent) throws BizException {
		if (timeOpMap != null && timeOpMap.containsKey(id_ent)) {
			return timeOpMap.get(id_ent);
		}
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		OpBasicDTO dto = service.getOpBasicInfo(id_ent);
		if (dto != null) {
			if (timeOpMap == null)
				timeOpMap = new HashMap<String, Integer>();
			timeOpMap.put(id_ent, dto.getTimes_op());
			return timeOpMap.get(id_ent);
		}
		return 0;
	}

	/**
	 * 获取就诊次数
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String getHinameByIdmm(String idMm) throws BizException {

		IMeterialMDORService service = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO mDo = service.findById(idMm);
		if (mDo != null) {
			return mDo.getHiname();
		}
		return null;
	}

	/**
	 * 获取医生信息
	 * 
	 * @param idPd
	 * @return
	 * @throws BizException
	 */
	private PsnDocDO getPsnDocDO(String code) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PHY.DRID CODE,DOC.NAME FROM BD_PSNDOC DOC INNER JOIN BD_EMP_PHY PHY ON PHY.ID_PSNDOC=DOC.ID_PSNDOC where DOC.ID_PSNDOC= ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(code);
		@SuppressWarnings("unchecked")
		List<PsnDocDO> list = (List<PsnDocDO>) new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(PsnDocDO.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}
}
