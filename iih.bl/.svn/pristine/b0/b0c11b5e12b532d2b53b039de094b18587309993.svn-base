package iih.bl.cc.ebs.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import iih.bl.cc.ebs.bp.GetBatchIfaceDTOsBP;
import iih.bl.cc.ebs.bp.GetChargeIfaceDTOsBP;
import iih.bl.cc.ebs.d.HisBatchIfaceDTO;
import iih.bl.cc.ebs.d.HisChargeIfaceDTO;
import iih.bl.cc.ebs.i.IBLCcEBSQryService;

@Service(serviceInterfaces = { IBLCcEBSQryService.class }, binding = Binding.JSONRPC)
public class BLCcEBSQryServiceImpl implements IBLCcEBSQryService {


	@Override
	public HisBatchIfaceDTO[] getBatchIfaceDTOs() throws BizException {
		GetBatchIfaceDTOsBP bp = new GetBatchIfaceDTOsBP();
		return bp.exec();
	}

	@Override
	public HisChargeIfaceDTO[] getChargeIfaceDTOs(Integer Iface_batch_id,FDate execDate) throws BizException {
		GetChargeIfaceDTOsBP bp = new GetChargeIfaceDTOsBP();
		return bp.exec(Iface_batch_id,execDate);
	}

}
