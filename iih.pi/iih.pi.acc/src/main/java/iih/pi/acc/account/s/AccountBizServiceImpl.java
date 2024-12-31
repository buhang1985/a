package iih.pi.acc.account.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import iih.pi.acc.account.d.AccountAggDO;
import iih.pi.acc.account.d.PiPatAccActDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountBizService;
import iih.pi.acc.account.i.IAccountCudService;
import iih.pi.acc.account.i.IAccountRService;

@Service(serviceInterfaces={IAccountBizService.class}, binding=Binding.JSONRPC)
public class AccountBizServiceImpl implements IAccountBizService {
	@Override
	public AccountAggDO lockAccount(PiPatAccDO accDo,
			PiPatAccActDO accActDo_cred) {
		AccountAggDO accAggDo = new AccountAggDO();
		DAFacade da = new DAFacade();
		try {
			String pk_cred = da.insertDO(accActDo_cred);
			accActDo_cred.setId_patacc(pk_cred);
			
			da.updateDO(accDo);
			
		} catch (DAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PiPatAccActDO[] dos=new PiPatAccActDO[1];
		dos[0]=accActDo_cred;
		accAggDo.setPiPatAccActDO(dos);
		accAggDo.setParentDO(accDo);
		
		return accAggDo;
	}

}
