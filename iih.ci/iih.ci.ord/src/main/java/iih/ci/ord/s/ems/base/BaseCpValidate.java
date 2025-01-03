package iih.ci.ord.s.ems.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class BaseCpValidate  implements IEmsValidate{
	
	

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param ctx
	 * @param ords  医嘱
	 * @param srvs  服务
	 * @param mm    物品
	 * @param app   申请单
	 * @return
	 * @throws BizException 
	 */
	public ErrorEmsList afterSaveValidate( CiEnContextDTO ctx,Object[] ords,Object[] srvs,Object[] mms,Object[] app) throws BizException {
		
		
		ErrorEmsList error = this.getSrvMmValidate(ctx, srvs, mms);
		if(error.size() >0){
			return error;
		}
		ErrorEmsList error1=this.analysisErrorOfSrvInfo(ctx, srvs);
		ErrorEmsList error2=this.analysisErrorOfOrdInfo(ctx, ords);		
		error.addAll(error1);
		error.addAll(error2);
		ErrorEmsList error3=this.analysisErrorOfAppInfo(ctx, app);	
		error.addAll(error3);
		
		return error;
	}
	
	protected ErrorEmsList analysisErrorOfSrvInfo( CiEnContextDTO ctx,Object[] objEms) throws BizException { 
		ErrorEmsList error=new ErrorEmsList();
		StringList errorList = new StringList();
		FBoolean isZeroPri=FBoolean.TRUE;
		try {
			isZeroPri=ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),"BLCG0040"); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (Object objInfo : objEms) {
			OrdSrvDO drug = (OrdSrvDO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;
			if(drug.getPri()==null||drug.getPri().doubleValue()<=0) {
				if(drug.getFg_bl()!=null&&drug.getFg_bl().booleanValue()) {
					if(drug.getEu_blmd()!=null&&drug.getEu_blmd()==1) {
						//手动划价模式，价格不允许为0；
						errorList.add(String.format("【%s】的划价方式为手工划价，价格不能为0！", drug.getName()));
						continue;
					}
					if(isZeroPri==null||!isZeroPri.booleanValue()) {
						errorList.add(String.format("【%s】价格不能为0！", drug.getName()));
					}
				}
			}
			
			
			if (CiOrdUtils.isEmpty(drug.getQuan_medu()) || drug.getQuan_medu().doubleValue() <= 0) {
				errorList.add(String.format("【%s】剂量为空！", drug.getName()));
			}
			// 物品校验剂量单位、血液类校验、Always 医嘱校验
			if (CiOrdUtils.isEmpty(drug.getId_medu())
					&& (CiOrdUtils.isTrue(drug.getFg_mm()) || drug.getSd_srvtp().startsWith("14")
							|| IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(drug.getSd_frequnitct()))) {
				errorList.add(String.format("【%s】剂量单位为空！", drug.getName()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_dep_mp())) {
				errorList.add(String.format("【%s】执行科室为空！", drug.getName()));
			}
			if (drug.getFg_bl()!=null&&drug.getFg_bl().booleanValue()&&CiOrdUtils.isEmpty(drug.getEu_blmd())) {
				errorList.add(String.format("【%s】划价方式为空！", drug.getName()));
			}
			
		}
		// 定义医疗单错误信息对象
		if (errorList.size() > 0) {

			error.add(new ErrorEmsDTO("srv", "srv", errorList.toStringWithNO(1)));
		}

		return error;
	}
	
	protected ErrorEmsList analysisErrorOfOrdInfo( CiEnContextDTO ctx,Object[] objEms) throws BizException {
		
		ErrorEmsList error=new ErrorEmsList();
		StringList errorList = new StringList();
		FDateTime dt_inhos = OrderUtils.getInHosTime(ctx.getId_en());
		for (Object objInfo : objEms) {
			CiOrderDO drug = (CiOrderDO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;		

			if (IBdSrvDictCodeConst.SD_TOTALOPENMODE_CYCLE.equals(drug.getSd_totalopenmode())
					&& CiOrdUtils.isEmpty(drug.getId_freq())) {
				errorList.add(String.format("【%s】频次为空！", drug.getName_or()));
			}
			if (CiOrdUtils.isEmpty(drug.getDt_effe())) {
				errorList.add(String.format("【%s】开始时间为空！", drug.getName_or()));
			} else {
				if (drug.getDt_effe().before(dt_inhos)) {
					errorList.add(String.format("【%s】开始时间不能在入科时间[%s]之前！", drug.getName_or(), dt_inhos));
				}
			}
			if (!CiOrdUtils.isEmpty(drug.getDt_end()) && drug.getDt_end().before(drug.getDt_effe())) {
				errorList.add(String.format("【%s】停止时间不能在开始时间[%s]之前！", drug.getName_or(), drug.getDt_effe()));
			}
			if (!CiOrdUtils.validateFreqAndQuanMedu(drug.getId_freq(), drug.getId_unit_med()).booleanValue()) {
				errorList.add(String.format("【%s】频次为持续类型时，单位应为时间类型！", drug.getName_or(), drug.getDt_effe()));
			}
			if(FBoolean.TRUE.equals(drug.getFg_pres_outp())&&CiOrdUtils.isEmpty(drug.getDays_or())) {
				errorList.add(String.format("【%s】出院带药使用天数为空！", drug.getName_or()));
			}		
		}
		// 定义医疗单错误信息对象
		if (errorList.size() > 0) {

			error.add(new ErrorEmsDTO("ord", "ord", errorList.toStringWithNO(1)));
		}

		return error;
	}
	/**
	 * 校验申请单信息
	 * @param ctx
	 * @param objEms
	 * @return
	 * @throws BizException
	 */
	protected ErrorEmsList analysisErrorOfAppInfo( CiEnContextDTO ctx,Object[] objEms) throws BizException { 
		ErrorEmsList error=new ErrorEmsList();
		return error;
	}
	
	protected ErrorEmsList getSrvMmValidate(CiEnContextDTO ctx,Object[] srvs,Object[] mms) throws BizException{
		
		List<OrdSrvChangedInfoDTO> srvMmInfo = new ArrayList<OrdSrvChangedInfoDTO>();
		
		Map<String,Object> mmMap = new HashMap<String,Object>();
		if(mms != null && mms.length >0){
			for(Object obj : mms){
				if(obj == null){
					continue;
				}
				OrdSrvMmDO mm = (OrdSrvMmDO)obj;
				mmMap.put(mm.getId_srv(), mm);
			}
		}
		
		for(Object obj : srvs){
			
			OrdSrvDO ordSrv = (OrdSrvDO)obj;
			
			OrdSrvChangedInfoDTO info = new OrdSrvChangedInfoDTO();
			info.setId_srv(ordSrv.getId_srv());
			if(mmMap.containsKey(ordSrv.getId_srv())){
				OrdSrvMmDO ordSrvMm = (OrdSrvMmDO)mmMap.get(ordSrv.getId_srv());
				info.setId_mm(ordSrvMm.getId_mm());
			}
			
			srvMmInfo.add(info);
		}
		
		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
		Map<String, String> errorMap = bp.exec(IBdFcDictCodeConst.SD_CODE_ENTP_IP, srvMmInfo);
		
		ErrorEmsList error = new ErrorEmsList();
		StringList errorList = new StringList();
		
		if (errorMap != null && errorMap.size() > 0) {
			for(String key : errorMap.keySet()){
				errorList.add(errorMap.get(key));
			}
		}
		if (errorList.size() > 0) {
		error.add(new ErrorEmsDTO("mm", "mm", errorList.toStringWithNO(1)));
		}
		return error;
	}
}
