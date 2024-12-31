package iih.bd.pp.dataimpt;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.d.desc.AccountSrvDODesc;
import iih.bd.pp.accountsrv.i.IAccountsrvCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 核算科目与收费项目的关联关系数据导入服务实现类
 * 
 * @author hao_wu
 *
 */
public class AccountSrvDataImportServiceImpl extends BaseDataImport<AccountSrvDO> implements IDataImport {
	@Override
	public boolean checkNotNull() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		AccountSrvDO[] result = getDOsFromImportDB(new AccountSrvDO(), "1=1", false);
		if (ArrayUtils.isEmpty(result))
			throw new BizException("核算科目与收费项目的关联关系导入数据为空！");

		// 2、数据空值校验
		checkNullValue(Arrays.asList(AccountSrvDO.ID_GRP, AccountSrvDO.ID_ORG, AccountSrvDO.ID_ACCOUNTCA,
				AccountSrvDO.ID_ACCOUNT, AccountSrvDO.ID_SRV), result);
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		String sql = String.format("delete from %s", AccountSrvDODesc.TABLE_NAME);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql);
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { AccountSrvDODesc.TABLE_NAME };
	}

	@Override
	public boolean importData() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		AccountSrvDO[] result = getDOsFromImportDB(new AccountSrvDO(), "1 = 1", true);
		if (ArrayUtils.isEmpty(result))
			throw new BizException("核算科目与收费项目的关联关系导入数据为空！");

		// 3、状态改为New
		processDOs(result);

		// 5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		ServiceFinder.find(IAccountsrvCudService.class).insert(result);

		return true;
	}
}
