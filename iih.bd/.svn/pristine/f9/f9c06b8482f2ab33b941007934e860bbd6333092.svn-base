package iih.bd.pp.accountsrv.s.model;

import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.i.IAccountSrvMap;
import iih.bd.pp.accountsrv.i.IAccountsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 核算科目与收费项目字典
 * 
 * @author hao_wu 2020-2-14
 *
 */
public class AccountSrvMap implements IAccountSrvMap {

	private HashMap<String, AccountSrvDO> _accMap;

	public AccountSrvMap(String[] srvIds) throws BizException {
		this._accMap = new HashMap<>();
		loadData(srvIds);
	}

	private void loadData(String[] srvIds) throws BizException {
		IAccountsrvRService accountsrvRService = ServiceFinder.find(IAccountsrvRService.class);
		AccountSrvDO[] accountSrvDos = accountsrvRService.findByAttrValStrings(AccountSrvDO.ID_SRV, srvIds);
		if (ArrayUtils.isEmpty(accountSrvDos)) {
			return;
		}

		for (AccountSrvDO accountSrvDO : accountSrvDos) {
			String key = this.getKey(accountSrvDO.getId_srv(), accountSrvDO.getId_account());
			this._accMap.put(key, accountSrvDO);
		}
	}

	@Override
	public AccountSrvDO get(String srvId, String accCaId) {
		String key = this.getKey(srvId, accCaId);
		if (this._accMap.containsKey(key)) {
			return this._accMap.get(key);
		}
		return null;
	}

	@Override
	public FBoolean contains(String srvId, String accCaId) {
		String key = this.getKey(srvId, accCaId);
		boolean contains = this._accMap.containsKey(key);
		return new FBoolean(contains);
	}

	/**
	 * 获取Key
	 * 
	 * @param srvId
	 * @param srvId
	 * @return
	 */
	private String getKey(String srvId, String accCaId) {
		return String.format("%s_%s", accCaId, srvId);
	}

}
