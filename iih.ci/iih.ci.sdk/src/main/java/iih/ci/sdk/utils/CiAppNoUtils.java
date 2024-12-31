package iih.ci.sdk.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import iih.ci.ord.app.d.desc.CiAppRisSheetDODesc;
import iih.ci.ord.app.d.desc.CiAppTreatExecDODesc;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 单据code生成工具
 * @author wangqingzhu
 *
 */
public class CiAppNoUtils {
	/**
	 * 申请单号
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public static String getApplyNo(String sd_srvtp) throws BizException {
		if (ObjectUtils.isEmpty(sd_srvtp))
			return "";
		BaseDO vo=null;
		// 医疗单类路径
		String classFullName = null;
		if (sd_srvtp.startsWith("02")) {// 检查
			if (sd_srvtp.startsWith("0207")) {// 病理
				classFullName = OrdApPathgyDODesc.CLASS_FULLNAME;
			} else {
				classFullName = OrdApObsDODesc.CLASS_FULLNAME;
			}
		} else if (sd_srvtp.startsWith("03")) {// 检验
			classFullName = OrdApLabDODesc.CLASS_FULLNAME;
			OrdApLabDO lab=new OrdApLabDO();
			lab.setId_dep_app(Context.get().getDeptId());
			vo=lab;
		} else if (sd_srvtp.startsWith("04")) {// 手术
			classFullName = OrdApOpDODesc.CLASS_FULLNAME;
		} else if (sd_srvtp.startsWith("140101")) {// 备血
			classFullName = OrdApBtDODesc.CLASS_FULLNAME;
		} else if (sd_srvtp.startsWith("140102")) {// 用血
			classFullName = OrdAppBtUseDODesc.CLASS_FULLNAME;
		} else if (sd_srvtp.startsWith("0902")) {// 会诊
			classFullName = OrdApConsDODesc.CLASS_FULLNAME;
		}
		// 有效性判断
		if (StringUtils.isNotBlank(classFullName)) {
			
			if(vo!=null) {
				return CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(classFullName,vo);
			}else {
				return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(classFullName);
			}
		}
		return "";
	}

	/**
	 * 生成毒麻处方号
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String generatePoisPresNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew("iih.ci.ord.dto.recipedto.d.RecipeDTO");
		return presNo;
	}

	/**
	 * 生成处方号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generatePresNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiPresDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	/**
	 * 根据就诊id_en 流水号清零，并生成新的处方号
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static String generatePresNo(String id_en) throws BizException {
		CiPresDO ciPresDO = new CiPresDO();
		ciPresDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiPresDO.class.getName(), ciPresDO);

		{
			presNo = presNo.replace(presNo.substring(1, 21), "");
		}
		return presNo;
	}

	/**
	 * 生成检查打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateRisPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppRisSheetDODesc.CLASS_FULLNAME);
		{
			presNo = presNo.replace(presNo.substring(1, 9), "");
		}
		return presNo;
	}

	public static String generateRisPrintNo(String id_en) throws BizException {
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiAppRisSheetDO.class.getName(),
				ciAppRisSheetDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	/**
	 * 生成检验打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateLisPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppLisSheetDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	public static String generateLisPrintNo(String id_en) throws BizException {
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiAppLisSheetDO.class.getName(),
				ciAppLisSheetDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	public static String[] generateLisPrintNo(String id_en, int num) throws BizException {
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(id_en);
		String[] presNo = CiOrdAppUtils.getIBillcodeManager()
				.getBatchBillCodes_RequiresNew(CiAppLisSheetDO.class.getName(), ciAppLisSheetDO, num);

		List<String> slist = new ArrayList<>();
		for (String o : presNo) {
			o = o.replace(o.substring(1, 21), "");
			slist.add(o);
		}

		return slist.toArray(new String[0]);
	}

	/**
	 * 
	 * @param cnt
	 *            生成个数
	 * @param dos
	 *            对象
	 * @param start
	 *            开始位置
	 * @param end
	 *            截止位置
	 * @return
	 * @author li_cheng
	 * @throws BizException
	 */
	public static String[] generateNormNOs(int cnt, BaseDO baseDO, Integer start, Integer end) throws BizException {

		String[] codes = CiOrdAppUtils.getIBillcodeManager().getBatchBillCodes_RequiresNew(baseDO.getClass().getName(),
				baseDO, cnt);
		if (start == null || end == null)
			return codes;

		List<String> lstCodes = new ArrayList<>();
		for (String code : codes) {
			code = code.replace(code.substring(start, end), "");
			lstCodes.add(code);
		}

		return lstCodes.toArray(new String[0]);
	}

	/**
	 * 诊疗收费清单打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateFeePrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiPrnDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	public static String generateFeePrintNo(String id_en) throws BizException {
		CiPrnDO ciPrnDO = new CiPrnDO();
		ciPrnDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiPrnDO.class.getName(), ciPrnDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	/**
	 * 诊疗执行单打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String generateTreatPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppTreatExecDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}
	
	/**
	 * 创建医嘱code编码
	 * @return
	 * @throws BizException
	 */
	public static String generateOrderCode() throws BizException {
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
	}
}
