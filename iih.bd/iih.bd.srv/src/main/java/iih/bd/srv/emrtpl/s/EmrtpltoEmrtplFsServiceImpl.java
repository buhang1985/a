package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.EmrtpltoEmrtplFsService;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={EmrtpltoEmrtplFsService.class}, binding=Binding.JSONRPC)
public class EmrtpltoEmrtplFsServiceImpl implements EmrtpltoEmrtplFsService{

	IEmrtplMDOCudService doservice ;
	IMrtplstreamCudService fsservice;
	@Override
	public void save(EmrTplDO[] tpldos, EmrTplStreamDO[] fsdos)
			throws BizException {
		// TODO Auto-generated method stub
		doservice.save(tpldos);
		fsservice.save(fsdos);
	}

	@Override
	public void update(EmrTplDO[] tpldos, EmrTplStreamDO[] fsdos)
			throws BizException {
		doservice= ServiceFinder.find(IEmrtplMDOCudService.class);
		fsservice=ServiceFinder.find(IMrtplstreamCudService.class);
		doservice.update(tpldos);
		fsservice.update(fsdos);
	}

	@Override
	public void delete(EmrTplDO[] tpldos, EmrTplStreamDO[] fsdos)
			throws BizException {
		// TODO Auto-generated method stub
		
	}
}
