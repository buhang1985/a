package iih.ci.ord.s.ems.ip.assi.cp.drugs;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class CpDrugsValidateBp  extends BaseCpValidate{

	@Override
	protected ErrorEmsList analysisErrorOfSrvInfo(CiEnContextDTO ctx, Object[] objEms) throws BizException {
		// TODO Auto-generated method stub
		ErrorEmsList errolist2= super.analysisErrorOfSrvInfo(ctx, objEms);
		StringList errorList = new StringList();
		for (Object objInfo : objEms) {
			OrdSrvDO drug = (OrdSrvDO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;
			
			if (CiOrdUtils.isEmpty(drug.getId_freq())) {
				errorList.add(String.format("【%s】频次为空！", drug.getName()));
			}
			//校验药品类信息
			if(IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(drug.getSd_srvtp())) {
			if (CiOrdUtils.isEmpty(drug.getId_route())) {
				errorList.add(String.format("【%s】用法为空！", drug.getName()));
			}
			if (CiOrdUtils.isEmpty(drug.getId_dep_wh()) && null == drug.getSd_nodispense()) {
				errorList.add(String.format("【%s】物资仓库为空！", drug.getName()));
			}
			
			}
			if(drug.getFg_pres_outp()!=null&&drug.getFg_pres_outp().booleanValue()) {
				if(drug.getQuan_total_medu()==null||drug.getQuan_total_medu().doubleValue()<=0) {
					errorList.add(String.format("【%s】出院带药总量不能为空！", drug.getName()));
				}
			}
		}
		
		if (errorList.size() > 0) {

			errolist2.add(new ErrorEmsDTO("srv", "srv", errorList.toStringWithNO(1)));
		}

		
		return errolist2;
	}



}
