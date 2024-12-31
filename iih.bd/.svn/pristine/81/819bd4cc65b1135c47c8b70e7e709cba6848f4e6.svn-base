package iih.bd.pp.dataimpt;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.accountsubject.d.desc.AccountSubjectDODesc;
import iih.bd.pp.accountsubject.i.IAccountsubjectCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 核算科目数据导入服务实现类
 * 
 * @author hao_wu 2018-5-28
 *
 */
public class AccountSubjectDataImportServiceImpl extends BaseDataImport<AccountSubjectDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		AccountSubjectDO[] result = getDOsFromImportDB(new AccountSubjectDO(), "1=1", false);
		if (ArrayUtils.isEmpty(result))
			throw new BizException("核算科目导入数据为空！");

		// 2、数据空值校验
		checkNullValue(Arrays.asList(AccountSubjectDO.ID_GRP, AccountSubjectDO.ID_ORG, AccountSubjectDO.ID_ACCOUNTCA,
				AccountSubjectDO.ID_ACCOUNT, AccountSubjectDO.CODE, AccountSubjectDO.NAME), result);
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		String sql = String.format("delete from %s", AccountSubjectDODesc.TABLE_NAME);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql);
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { AccountSubjectDODesc.TABLE_NAME };
	}

	@Override
	public boolean importData() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		AccountSubjectDO[] result = getDOsFromImportDB(new AccountSubjectDO(), "1 = 1", true);
		if (ArrayUtils.isEmpty(result))
			throw new BizException("核算科目导入数据为空！");

		// 3、状态改为New
		processDOs(result);

		// 5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		ServiceFinder.find(IAccountsubjectCudService.class).insert(result);

		return true;
	}

}
