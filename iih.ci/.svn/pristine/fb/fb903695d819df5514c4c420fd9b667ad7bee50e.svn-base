package iih.ci.ord.s.ems.ip.ems.treat;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dws.ip.ems.d.EmsTreatViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

public class EmsTreatValidate extends BaseIpEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException {
		ErrorEmsList errorEmsList = super.viewModelValidate(objEms, ctx);
		for (Object objItem : objEms){
			if(objItem instanceof EmsTreatViewDTO){
				EmsTreatViewDTO emsTreatDto = (EmsTreatViewDTO)objItem;
				List<String> errorlist=new ArrayList<String>();
				if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){
					if(!Context.get().getDeptId().equals(emsTreatDto.getId_dep_mp())){
						errorlist.add(String.format("【%s】执行科室必须是本科室！", emsTreatDto.getName_srv()));
					}
				}
				if(errorlist.size() > 0){
					errorEmsList.add(new ErrorEmsDTO(emsTreatDto.getCode_or(), emsTreatDto.getName_srv(), errorlist));
				}
				
//				List<String> errorlist=new ArrayList<String>();
//				if(emsTreatDto.getQuan_med()==null || emsTreatDto.getQuan_med().toDouble()<=0){
//					errorlist.add(String.format("【%s】剂量必须大于0！", emsTreatDto.getName_srv()));
//				}
//				if(errorlist.size() > 0){
//					errorEmsList.add(new ErrorEmsDTO(ctx,(BaseDTO)objItem,errorlist));
//				}
			}
		}
		return errorEmsList;
	}
}
