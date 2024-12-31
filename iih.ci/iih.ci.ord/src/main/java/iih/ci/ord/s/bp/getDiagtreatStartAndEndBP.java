package iih.ci.ord.s.bp;

import iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class getDiagtreatStartAndEndBP {
	
	public DiagTreatViewRntDataDTO exec(OrSrvSplitParamDTO orparams)throws BizException{
		if(orparams==null)throw new BizException("传入的参数为空");
		if(orparams.getId_ens()==null)throw new BizException("传入的就诊号为空");
		DiagTreatViewRntDataDTO rnt=new DiagTreatViewRntDataDTO();
		IEnOutQryService enservice=ServiceFinder.find(IEnOutQryService.class);
		IpBasicDTO ip=enservice.getIpBasicInfo(orparams.getId_ens());
		rnt.setDt_start(ip.getDt_acpt());
		FDateTime	e1=CiOrdAppUtils.getServerDateTime();
		String dstr=e1.getYear()+"-"+e1.getMonth()+"-"+e1.getDay()+" "+23+":"+59+":"+59;
		FDateTime end=new FDateTime(dstr);
		rnt.setDt_end(end);
		return rnt;
	}

}
