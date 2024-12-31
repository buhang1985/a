package iih.bd.srv.emrtpl.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CopyEmrTplStreamBp {

	public Boolean exec(String oldOrderid,String newOrderid) throws BizException {
		IMrtplstreamRService iMrtplstreamRService= ServiceFinder.find(IMrtplstreamRService.class);
		IMrtplstreamCudService iMrtplstreamCudService= ServiceFinder.find(IMrtplstreamCudService.class);
		EmrTplStreamDO[] emrTplStreamDO = iMrtplstreamRService.find(String.format(" id_mrtpl = '%s'", oldOrderid), "", FBoolean.FALSE);
		if(emrTplStreamDO!=null&&emrTplStreamDO.length>0){
			List<EmrTplStreamDO> emrTplStreamList = new ArrayList<EmrTplStreamDO>();
			for (EmrTplStreamDO emrTplStreamDo : emrTplStreamDO) {
				EmrTplStreamDO emrTpl = emrTplStreamDo;
				emrTpl.setId_mrtplfs(null);
				emrTpl.setId_mrtpl(newOrderid);
				emrTplStreamList.add(emrTpl);
			}
			iMrtplstreamCudService.insert(emrTplStreamList.toArray(new EmrTplStreamDO[emrTplStreamList.size()]));	
		}
		return true;
	}
}
