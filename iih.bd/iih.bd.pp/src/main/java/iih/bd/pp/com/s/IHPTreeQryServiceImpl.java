package iih.bd.pp.com.s;

import iih.bd.pp.com.d.TreeDTO;
import iih.bd.pp.com.i.IHPTreeQryService;
import iih.bd.pp.hp.bp.GetHPTreeQryBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IHPTreeQryService.class }, binding = Binding.JSONRPC)
public class IHPTreeQryServiceImpl implements IHPTreeQryService {

	@Override
	public TreeDTO[] getHpTreeList() throws BizException {
		// TODO Auto-generated method stub
		GetHPTreeQryBp bp=new GetHPTreeQryBp();
		return bp.getTreeDTOList();
	}

	@Override
	public Boolean deleteTreeDTO(TreeDTO treeDTO) throws BizException {
		// TODO Auto-generated method stub
		GetHPTreeQryBp bp=new GetHPTreeQryBp();
		if(treeDTO==null)
		{
			return false;
		}
		return bp.deleteTreeDTO(treeDTO);
	}
}
