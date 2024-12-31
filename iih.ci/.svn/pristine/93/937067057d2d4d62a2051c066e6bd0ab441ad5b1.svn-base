package iih.ci.ord.s.ems.ip.ems.opr;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.ext.CheckOpRstDTO;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.OrderSysParamUtils;
import iih.ci.ord.s.ems.meta.SysParamInfo;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 手术医疗单校验逻辑
 * @author Young
 *
 */
public class EmsOprValidate extends BaseIpEmsValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) 
			throws BizException  {
		ErrorEmsList errorList = super.viewModelValidate(objEms, ctx);
		for (Object obj : objEms) {
			List<String> errors = new ArrayList<String>();
			OrderListViewDTO viewDTO=(OrderListViewDTO)obj;
			FDateTime dt_plan=viewDTO.getDt_effe();
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsOprViewDTO emsOpsViewDTO = (EmsOprViewDTO) obj;
				dt_plan=emsOpsViewDTO.getDt_plan();
				if(emsOpsViewDTO.getDt_plan()==null){
					errors.add(String.format("【%s】计划手术时间为空！", emsOpsViewDTO.getName_srv()));
				}
			}
			if(CiOrdUtils.isEmpty(viewDTO.getId_extend())){
				errors.add(String.format("【%s】麻醉方式为空！", viewDTO.getName_srv()));
			}
			if(!CiOrdUtils.isTrue(viewDTO.getFg_urgent())){
				SysParamInfo dateparam=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdSugDateLimitTime();
				FDateTime dt = CiOrdAppUtils.getServerDateTime();
				//当选中的开始时间 < 当天日期 + 2 + 00:00:00 时，显示提示信息【每日14点以后不允许下当日及次日24点之前手术（紧急以及急诊手术除外）】
				if(!CiOrdUtils.isEmpty(dateparam.getOrgParam()) && dt.after(new FDateTime(dt.getDate().toString() +" "+ dateparam.getOrgParam()))){
					if(dt_plan.before(new FDateTime(dt.addSeconds(2*24*3600).getDate().toString()+" "+"00:00:00"))){
						errors.add(String.format("【%s】每日14点以后不允许下当日及次日24点之前手术（紧急以及急诊手术除外）！", viewDTO.getName_srv()));
					}
				}
				//当手术为择期手术时，若选中的开始时间为工作节假日时，显示提醒信息【手术时间不允许为节假日时段内，还请重新选择】
				try{
					if(!OrderUtils.isWordDay(dt_plan.getDate(), SysParamUtils.getSysParam().getSYS_PARAM_IpOrdSugWorkCalendarId().getOrgParam())){
						errors.add(String.format("【%s】手术时间不允许为节假日时段内，还请重新选择 ！", viewDTO.getName_srv()));
					}
				}
				catch(BizException ex){
					errors.add(String.format(ex.getMessage(), viewDTO.getName_srv()));
				}
			}
			//2018-8-14  胡亮要求去掉校验，等待后续确认是否开启校验
//			List<CheckOpRstDTO> rstlist=OrderUtils.getReturnMsg(ctx.getId_en(),viewDTO.getSd_srvtp());
//			if(!CiOrdUtils.isEmpty(rstlist) && rstlist.size()>0){
//				for(CheckOpRstDTO rstDTO:rstlist){
//					if(!CiOrdUtils.isEmpty(viewDTO.getEu_anseca()) && viewDTO.getEu_anseca()==0 && rstDTO.getEu_anesca()==0 && !rstDTO.getId_or().equals(viewDTO.getId_or()) 
//							&& dt_plan.getDate().isSameDate(rstDTO.getDt_plan().getDate())){
//						errors.add(String.format("【%s】当天不可开立两条全麻手术！", viewDTO.getName_srv()));
//					}
//					if(viewDTO.getId_srv().equals(rstDTO.getId_srv()) && !rstDTO.getId_or().equals(viewDTO.getId_or())){
//						errors.add(String.format("【%s】本次就诊该手术申请已存在！", viewDTO.getName_srv()));//住院不要
//					}
//				}
//			}
			if (errors.size() > 0){
				errorList.add(new ErrorEmsDTO(((OrderListViewDTO)objEms[0]).getCode_or(),((OrderListViewDTO)objEms[0]).getName_srv(), errors));
			}
		}
		
		return errorList;
	}
}
