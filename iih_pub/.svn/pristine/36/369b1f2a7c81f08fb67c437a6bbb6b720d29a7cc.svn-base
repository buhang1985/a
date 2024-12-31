package iih.mp.dg.params;

import iih.bd.utils.ParamUtils;
import iih.mp.dg.dto.mpdgquesite.d.MpDgQuesiteDTO;
import iih.mp.dg.i.IMpDgQryService;
import iih.mp.dg.params.constdef.MpDgParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品执行域参数工具类
 * 
 * @author hao_wu
 *
 */
public class MpDgParamUtils {

	/**
	 * 获取药房分窗口模式
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Integer getApporWinMode() throws BizException {
		Integer apporWinMode = ParamUtils.GetOrgParamIntegerValue(MpDgParamCodeConst.MPDGOP0005);
		return apporWinMode;
	}

	/**
	 * 获取药房队列过号处理模式
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Integer getDrugQueProcMode() throws BizException {
		Integer drugQueProcMode = ParamUtils.GetOrgParamIntegerValue(MpDgParamCodeConst.MPDGOP0026);
		return drugQueProcMode;
	}

	/**
	 * 获取门诊发药处方有效时间（小时）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Integer getDrugBillNumber() throws BizException {
		Integer drugBillNumber = ParamUtils.GetOrgParamIntegerValue(MpDgParamCodeConst.MPDGOP0034);
		return drugBillNumber;
	}

	/**
	 * 获取门诊窗口摆药模式</br>
	 * 0：人工摆药</br>
	 * 1：摆药机摆药</br>
	 * 当前计算机未注册药房窗口时，返回空
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getOpWinDispDrugMode() throws BizException {

		MpDgQuesiteDTO siteDTO = null;
		try {
			IMpDgQryService iMpDgQryService = ServiceFinder.find(IMpDgQryService.class);
			siteDTO = iMpDgQryService.getCurrentQueSiteInfo();
		} catch (Exception e) {
		}

		if (siteDTO == null) {
			return null;
		}

		String opWinDispDrugTp = ParamUtils.GetInstanceParamStringValue(siteDTO.getId_quesite(),
				MpDgParamCodeConst.MPDGOP0035);
		return opWinDispDrugTp;
	}

	/**
	 * 获取允许非当前窗口发药模式(只对普通窗口有效 )</br>
	 * 1: 提示患者的发药窗口，询问是否继续发药 </br>
	 * 0: 提示患者到指定窗口领药
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getAllowDispOtherWinDrugMode() throws BizException {

		IMpDgQryService iMpDgQryService = ServiceFinder.find(IMpDgQryService.class);
		MpDgQuesiteDTO siteDTO = iMpDgQryService.getCurrentQueSiteInfo();
		if (siteDTO == null) {
			return "1";
		}

		String opWinDispDrugTp = ParamUtils.GetInstanceParamStringValue(siteDTO.getId_quesite(),
				MpDgParamCodeConst.MPDGOP0036);
		return opWinDispDrugTp;
	}

	/**
	 * 用于门诊药房签到时，慢病处方未缴费情况下，提示的缴费地点。 </br>
	 * 例如：兰陵县人民医院为：二楼收费处
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getChronicPayPlace() throws BizException {
		String chronicPayPlace = ParamUtils.GetOrgParamStringValue(MpDgParamCodeConst.MPDGOP0037);
		return chronicPayPlace;
	}

	/**
	 * 调用摆药机熄灯接口时机 </br>
	 * 0 每一个处方发药都调用熄灯接口 </br>
	 * 1 所有处方发药完成调用熄灯接口
	 */
	public static String getDispLightOffMoment() throws BizException {
		String dispLightOffMoment = ParamUtils.GetOrgParamStringValue(MpDgParamCodeConst.MPDGOP0039);
		return dispLightOffMoment;
	}

	/**
	 * 使用新接口 </br>
	 * true 使用新接口 </br>
	 * false 使用旧接口
	 */
	public static FBoolean getUseNewInterface() throws BizException {
		FBoolean useCDMNewInterface = ParamUtils.GetOrgParamFBooleanValue(MpDgParamCodeConst.MPDGOP0099);
		return useCDMNewInterface;
	}
}
