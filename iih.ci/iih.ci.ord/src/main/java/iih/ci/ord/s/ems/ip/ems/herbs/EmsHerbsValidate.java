package iih.ci.ord.s.ems.ip.ems.herbs;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpDrugsEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;

/**
 * 草药医疗单的校验逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsHerbsValidate extends BaseIpDrugsEmsValidate {
	
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// 定义医疗单错误信息集合
		ciEnContextInfo = ctx;
		ErrorEmsList errorEmsList = new ErrorEmsList();

		boolean isFreqChecked = false;
		boolean isDteffeChecked = false;
		boolean isDteffeinhosChecked = false;
		boolean isDtendChecked = false;
		boolean isDepmpChecked = false;
		FDateTime dt_inhos = OrderUtils.getInHosTime(ctx.getId_en());
		for (Object objModel : objEms) {
			OrderListViewDTO viewDTO = (OrderListViewDTO) objModel;
			if(viewDTO.getStatus()==DOStatus.DELETED)
				continue;
			List<String> errorList = new ArrayList<String>();
			if (CiOrdUtils.isEmpty(viewDTO.getQuan_med()) || viewDTO.getQuan_med().doubleValue() <= 0) {
				errorList.add(String.format("【%s】剂量为空！", viewDTO.getName_srv()));
			}
			// 物品校验剂量单位、血液类校验、Always 医嘱校验
			if (CiOrdUtils.isEmpty(viewDTO.getId_unit_med())
					&& (CiOrdUtils.isTrue(viewDTO.getFg_mm()) || viewDTO.getSd_srvtp().startsWith("14")
							|| IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(viewDTO.getSd_frequnitct()))) {
				errorList.add(String.format("【%s】剂量单位为空！", viewDTO.getName_srv()));
			}
			if (!isFreqChecked && IBdSrvDictCodeConst.SD_TOTALOPENMODE_CYCLE.equals(viewDTO.getSd_totalopenmode())
					&& CiOrdUtils.isEmpty(viewDTO.getId_freq())) {
				errorList.add("频次为空！");
				isFreqChecked = true;
			}
			if (!isDepmpChecked && CiOrdUtils.isEmpty(viewDTO.getId_dep_mp())) {
				errorList.add("执行科室为空！");
				isDepmpChecked = true;
			}
			if (!isDteffeChecked && CiOrdUtils.isEmpty(viewDTO.getDt_effe())) {
				errorList.add("开始时间为空！");
				isDteffeChecked = true;
			} else {
				if (!isDteffeinhosChecked && viewDTO.getDt_effe().before(dt_inhos)) {
					errorList.add("开始时间不能在入科时间之前！");
					isDteffeinhosChecked = true;
				}
			}
			if (!isDtendChecked && !CiOrdUtils.isEmpty(viewDTO.getDt_end()) && viewDTO.getDt_end().before(viewDTO.getDt_effe())) {
				errorList.add("停止时间不能在开始时间之前！");
				isDtendChecked = true;
			}
			if (!CiOrdUtils.validateFreqAndQuanMedu(viewDTO.getId_freq(), viewDTO.getId_unit_med()).booleanValue()) {
				errorList.add(String.format("频次为持续类型时，【%s】单位应为时间类型！", viewDTO.getName_srv(), viewDTO.getDt_effe()));
			}
			if (errorList.size() > 0) {
				errorEmsList.add(new ErrorEmsDTO(viewDTO.getCode_or(), viewDTO.getName_srv(), errorList));
			}
		}
		
		// 分析药品服务基本信息错误
		ErrorEmsDTO errorInfo = analysisErrorOfSrvInfo(objEms);
		if (null != errorInfo) {
			errorEmsList.add(errorInfo);
		}

		// 分析物品库存信息
		errorInfo = analysisErrorOfMmInfo(objEms);
		if (null != errorInfo) {
			errorEmsList.add(errorInfo);
		}

		// 分析用法错误信息
		errorInfo = analysisErrorOfRouteInfo(objEms);
		if (null != errorInfo) {
			errorEmsList.add(errorInfo);
		}

		// 分析执行流向错误信息
		errorInfo = analysisErrorOfWfDeptInfo(objEms);
		if (null != errorInfo) {
			errorEmsList.add(errorInfo);
		}
		
		return errorEmsList;
	}

	/**
	 * 分析服务基本信息错误
	 * @param objEms
	 * @return
	 */
	@Override
	protected ErrorEmsDTO analysisErrorOfSrvInfo(Object[] objEms) {
		StringList errorList = new StringList();
		boolean isBoilChecked = false;
		boolean isOrdersChecked = false;
		boolean isOutpChecked = false;
		for (Object objInfo : objEms) {
			EmsHerbsViewDTO drug = (EmsHerbsViewDTO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;
			if (!isBoilChecked && CiOrdUtils.isEmpty(drug.getId_boil())) {
				errorList.add("采用剂型为空！");
				isBoilChecked = true;
			}
			if (!isOrdersChecked&&(drug.getOrders() == null || drug.getOrders() <= 0)) {
				errorList.add("付数不正确！");
				isOrdersChecked = true;
			}
			
			if (CiOrdUtils.isEmpty(drug.getId_dep_wh()) && null == drug.getSd_nodispense()) {
				errorList.add(String.format("【%s】物资仓库为空！", drug.getName_srv()));
			}
			if (!isOutpChecked && CiOrdUtils.isTrue(drug.getFg_pres_outp()) && CiOrdUtils.isTrue(drug.getFg_long())
					&& CiOrdUtils.isEmpty(drug.getDt_end())) {
				errorList.add("出院带药，停止时间不可为空！");
				isOutpChecked = true;
			}
		}
		if (errorList.size() > 0) {
			EmsHerbsViewDTO drug = (EmsHerbsViewDTO) objEms[0];
			return new ErrorEmsDTO(drug.getCode_or(), drug.getName_mm(), errorList.toString());
		}
		return null;
	}
}
