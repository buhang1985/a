package iih.ci.ord.s.ems.ip.assi.cp.pathgy;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.s.ems.base.BaseCpValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import xap.mw.core.data.BizException;

public class CpPathgyValidateBp extends BaseCpValidate{

	@Override
	protected ErrorEmsList analysisErrorOfAppInfo(CiEnContextDTO ctx, Object[] objEms) throws BizException {
		// TODO Auto-generated method stub
		ErrorEmsList error=new ErrorEmsList();
		StringList sb = new StringList();
		if(objEms!=null) {
			for (Object o : objEms) {
				CiorapppathgyAggDO apop=(CiorapppathgyAggDO)o;
				if(apop!=null) {
					if(apop.getParentDO().getId_samptp()==null) {
						sb.add("标本类型为空！");
					}
                    if(apop.getParentDO().getSd_samptp()==null) {
                    	sb.add("标本类型编码为空！");
					}
                    if(apop.getParentDO().getNo_applyform()==null) {
                    	sb.add("申请单号为空！");
					}
				}
			}
			
			if (sb.size() > 0) {

				error.add(new ErrorEmsDTO("pathgy", "pathgy", sb.toStringWithNO(1)));
			}

		}
		
		return error;
	}
	

}
