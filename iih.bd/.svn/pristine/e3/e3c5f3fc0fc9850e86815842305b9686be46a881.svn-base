package iih.bd.pp.accountsubject.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.i.IAccountsrvCudService;
import iih.bd.pp.accountsrv.i.IAccountsrvRService;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.dto.d.AccountSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 核算分类移除功能
 * 
 * @author shao_yuan
 *
 */
public class AccSrvMoveToBp {
	/** 
	 * 核算分类移除功能
	 * @param accountSubjectDO
	 * @param accountSrvDTO
	 */
	public void exec(AccountSubjectDO accountSubjectDO,
			AccountSrvDTO[] accountSrvDTO) throws BizException {
		String[] IdArray = GetSrvIdArray(accountSrvDTO);
		if (IdArray == null || IdArray.length <= 0) {
			return;
		}
		deleteAccSrvByIds(IdArray);
		setAccSrvBy(accountSubjectDO,accountSrvDTO);
	}
	/** 
	 * 插入对照数据
	 * @param accountSubjectDO
	 * @param accountSrvDTO
	 */
	private void setAccSrvBy(AccountSubjectDO accountSubjectDO,
			AccountSrvDTO[] accountSrvDTO) throws BizException {
		ArrayList<AccountSrvDO> accSrvList = new ArrayList<AccountSrvDO>();
		for(AccountSrvDTO srvDto : accountSrvDTO){
			AccountSrvDO saccrvDO = new AccountSrvDO();
			saccrvDO.setId_account(accountSubjectDO.getId_account());
			saccrvDO.setId_accountca(accountSubjectDO.getId_accountca());
			saccrvDO.setId_grp(Context.get().getGroupId());
			saccrvDO.setId_org(Context.get().getOrgId());
			saccrvDO.setId_srv(srvDto.getId_srv());
			saccrvDO.setStatus(DOStatus.NEW);
			accSrvList.add(saccrvDO);
		}
		if (accSrvList == null || accSrvList.size() <= 0) {
			return;
		}
		IAccountsrvCudService iaccountsrvCudService = ServiceFinder.find(IAccountsrvCudService.class);
		iaccountsrvCudService.insert(accSrvList.toArray(new AccountSrvDO[0]));	
		
	}
	/** 
	 * 删除原有数据
	 * @param idArray
	 */
	private void deleteAccSrvByIds(String[] idArray) throws BizException {
		IAccountsrvCudService cudservice = ServiceFinder.find(IAccountsrvCudService.class);
		IAccountsrvRService rservice = ServiceFinder.find(IAccountsrvRService.class);
		AccountSrvDO[] srvdos = rservice.findByIds(idArray, FBoolean.FALSE);
		if(ArrayUtils.isEmpty(srvdos)) return;
		cudservice.delete(srvdos);
	}
	/** 
	 * 获取对照表主键数据
	 * @param accountSrvDTO
	 */
	private String[] GetSrvIdArray(AccountSrvDTO[] accountSrvDTO) {
		if (accountSrvDTO == null || accountSrvDTO.length <= 0) {
			return null;
		}
		ArrayList<String> IdList = new ArrayList<String>();
		for (AccountSrvDTO SrvDO : accountSrvDTO) {
			if (SrvDO != null && !StringUtils.isNullOrEmpty(SrvDO.getId_accsrv())) {
				IdList.add(SrvDO.getId_accsrv());
			}
		}
		return IdList.toArray(new String[0]);
	}

}
