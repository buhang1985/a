package iih.ci.ord.s.ems.ip.assi.cp.opr;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.base.BaseCpValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import xap.mw.core.data.BizException;

public class CpOprValidateBp   extends BaseCpValidate{
	@Override
	protected ErrorEmsList analysisErrorOfAppInfo(CiEnContextDTO ctx, Object[] objEms) throws BizException {
		// TODO Auto-generated method stub
		ErrorEmsList error=new ErrorEmsList();
		StringList sb = new StringList();
		if(objEms!=null) {
			for (Object o : objEms) {
				CiorappsurgeryAggDO apop=(CiorappsurgeryAggDO)o;
				if(apop!=null) {
					if(apop.getParentDO().getDt_plan()==null) {
						sb.add("计划手术时间为空！");
					}
                    if(apop.getParentDO().getId_surgical_site()==null) {
                    	sb.add("手术部位为空！");
					}
                    if(apop.getParentDO().getSd_surgical_site()==null) {
                    	sb.add("手术部位编码为空！");
					}
                    if(apop.getParentDO().getId_emp_operate()==null) {
                    	sb.add("主刀医生为空！");
					}
                    if(apop.getParentDO().getId_incitp()==null) {
                    	sb.add("切口等级为空！");
					}
                    if(apop.getParentDO().getSd_incitp()==null) {
                    	sb.add("切口等级编码为空！");
					}
                    if(apop.getParentDO().getId_di()==null) {
                    	sb.add("临床诊断为空！");
					}
                    if(apop.getParentDO().getNo_applyform()==null) {
                    	sb.add("申请单号为空！");
					}
                    if(apop.getParentDO().getId_anestp()==null) {
                    	sb.add("麻醉方式为空！");
					}
                    if(apop.getParentDO().getSd_anestp()==null) {
                    	sb.add("麻醉方式编码为空！");
					}
				}
			}
			
			if (sb.size() > 0) {

				error.add(new ErrorEmsDTO("opr", "opr", sb.toStringWithNO(1)));
			}

		}
		
		return error;
	}

}
