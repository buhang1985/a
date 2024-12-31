package iih.bd.pp.accountsrv.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.i.IAccountSrvMap;
import iih.bd.pp.accountsrv.i.IAccountsrvCudService;
import iih.bd.pp.accountsrv.s.model.AccountSrvMap;
import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新医疗服务与核算科目关系业务逻辑
 * 
 * @author hao_wu 2018-10-27
 *
 */
public class UpdateMedsrvAccountRelBp {

	/**
	 * 更新医疗服务与核算科目关系
	 * 
	 * @param srvAccountRelDtos 医疗服务与核算科目关系集合
	 * @throws BizException
	 */
	public void exec(MedsrvAccountRelDTO[] srvAccountRelDtos) throws BizException {
		if (ArrayUtils.isEmpty(srvAccountRelDtos)) {
			return;
		}

		updateMedsrvAccountRel(srvAccountRelDtos);
	}

	/**
	 * 更新医疗服务与核算科目关系
	 * 
	 * @param srvAccountRelDtos
	 * @throws BizException
	 */
	private void updateMedsrvAccountRel(MedsrvAccountRelDTO[] srvAccountRelDtos) throws BizException {

		String[] srvIds = DoUtils.getAttrValArr(srvAccountRelDtos, "Id_srv", String.class);
		IAccountSrvMap accMap = new AccountSrvMap(srvIds);

		ArrayList<AccountSrvDO> accountSrvDOList = new ArrayList<AccountSrvDO>();
		for (MedsrvAccountRelDTO medsrvAccountRelDTO : srvAccountRelDtos) {
			AccountSrvDO accountSrvDO = getAccountSrvDO(medsrvAccountRelDTO.getId_srv(),
					medsrvAccountRelDTO.getId_account(), IBdPpDictCodeConst.ID_ACCOUNT_GY, accMap);
			if (accountSrvDO != null) {
				accountSrvDOList.add(accountSrvDO);
			}
			accountSrvDO = getAccountSrvDO(medsrvAccountRelDTO.getId_srv(), medsrvAccountRelDTO.getId_account_op(),
					IBdPpDictCodeConst.ID_ACCOUNT_MZ, accMap);
			if (accountSrvDO != null) {
				accountSrvDOList.add(accountSrvDO);
			}
			accountSrvDO = getAccountSrvDO(medsrvAccountRelDTO.getId_srv(), medsrvAccountRelDTO.getId_account_ip(),
					IBdPpDictCodeConst.ID_ACCOUNT_ZY, accMap);
			if (accountSrvDO != null) {
				accountSrvDOList.add(accountSrvDO);
			}
		}

		if (accountSrvDOList.size() > 0) {
			IAccountsrvCudService accountsrvCudService = ServiceFinder.find(IAccountsrvCudService.class);
			accountsrvCudService.save(accountSrvDOList.toArray(new AccountSrvDO[0]));
		}

//		accMap.containsKey(key)
//		ArrayList<AccountSrvDO> accountSrvDOList = new ArrayList<AccountSrvDO>();
//		ArrayList<String> medsrvIds = new ArrayList<String>();
//		for (MedsrvAccountRelDTO medsrvAccountRelDTO : srvAccountRelDtos) {
//			if (StringUtils.isEmpty(medsrvAccountRelDTO.getId_srv())) {
//				continue;
//			}
//
//			medsrvIds.add(medsrvAccountRelDTO.getId_srv());
//
//			if (FBoolean.TRUE.equals(shareAcountSystem)) {
//				// 共用
//				AccountSrvDO accountSrvDO = getNewAccountSrvDO(medsrvAccountRelDTO.getId_srv());
//				accountSrvDO.setId_account(IBdPpDictCodeConst.ID_ACCOUNT_GY);
//				accountSrvDO.setId_accountca(medsrvAccountRelDTO.getId_account());
//				accountSrvDOList.add(accountSrvDO);
//			} else {
//				// 门诊
//				AccountSrvDO accountSrvDO = getNewAccountSrvDO(medsrvAccountRelDTO.getId_srv());
//				accountSrvDO.setId_account(IBdPpDictCodeConst.ID_ACCOUNT_MZ);
//				accountSrvDO.setId_accountca(medsrvAccountRelDTO.getId_account_op());
//				accountSrvDOList.add(accountSrvDO);
//				// 住院
//				accountSrvDO = getNewAccountSrvDO(medsrvAccountRelDTO.getId_srv());
//				accountSrvDO.setId_account(IBdPpDictCodeConst.ID_ACCOUNT_ZY);
//				accountSrvDO.setId_accountca(medsrvAccountRelDTO.getId_account_ip());
//				accountSrvDOList.add(accountSrvDO);
//			}
//		}

//		deleteAccMedsrvRel(medsrvIds.toArray(new String[0]));
//		insertAccMedsrvRel(accountSrvDOList.toArray(new AccountSrvDO[0]));
	}

	/**
	 * 获取需要保存的核算体系关系
	 * 
	 * @param id_srv
	 * @param id_account
	 * @param idAccountCa
	 * @param accMap
	 * @return
	 */
	private AccountSrvDO getAccountSrvDO(String id_srv, String id_account, String idAccountCa, IAccountSrvMap accMap) {

		AccountSrvDO accountSrvDO = accMap.get(id_srv, idAccountCa);
		if (StringUtils.isNotBlank(id_account) && accountSrvDO == null) {
			// 新增核算体系
			accountSrvDO = getNewAccountSrvDO(id_srv);
			accountSrvDO.setId_account(idAccountCa);
			accountSrvDO.setId_accountca(id_account);
			return accountSrvDO;
		}

		if (StringUtils.isNotBlank(id_account) && accountSrvDO != null
				&& !id_account.equals(accountSrvDO.getId_accountca())) {
			// 修改核算体系
			accountSrvDO.setId_accountca(id_account);
			accountSrvDO.setStatus(DOStatus.UPDATED);
			return accountSrvDO;
		}

		if (StringUtils.isBlank(id_account) && accountSrvDO != null) {
			// 删除核算体系
			accountSrvDO.setStatus(DOStatus.DELETED);
			return accountSrvDO;
		}
		return null;
	}

	/**
	 * 获取新医疗服务与核算科目关系
	 * 
	 * @param id_srv
	 * @return
	 */
	private AccountSrvDO getNewAccountSrvDO(String id_srv) {
		AccountSrvDO accountSrvDO = new AccountSrvDO();
		accountSrvDO.setStatus(DOStatus.NEW);
		accountSrvDO.setId_grp(Context.get().getGroupId());
		accountSrvDO.setId_org(Context.get().getOrgId());
		accountSrvDO.setId_srv(id_srv);
		return accountSrvDO;
	}

}
