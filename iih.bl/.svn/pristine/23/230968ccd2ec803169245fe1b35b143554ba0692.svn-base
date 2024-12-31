package iih.bl.hp.hppatblacklist.s.impt;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.hp.hppatblacklist.d.HpPatBlackListDO;
import iih.bl.hp.hppatblacklist.i.IHppatblacklistCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class BlhpBlackListImportServiceImpl  extends BaseDataImport<HpPatBlackListDO> implements IDataImport{
	@Override
	public boolean checkBusiness() throws BizException {
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		HpPatBlackListDO[] bdBltplItmDOs = getDOsFromImportDB(new HpPatBlackListDO(), "1 = 1", false);
		if (ArrayUtils.isEmpty(bdBltplItmDOs))
			throw new BizException("医保患者黑名单导入数据为空！");

		return true;
	}

	@Override
	public boolean checkNotNull() throws BizException {
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		HpPatBlackListDO[] hpPatBlackListDO = getDOsFromImportDB(new HpPatBlackListDO(), "1 = 1", false);
		if (ArrayUtils.isEmpty(hpPatBlackListDO))
			throw new BizException("医保患者黑名单导入数据为空！");

		// 1、非空字段校验
		checkNullValue(Arrays.asList(HpPatBlackListDO.SOCIAL_NO, HpPatBlackListDO.ID_GRP, HpPatBlackListDO.ID_ORG), hpPatBlackListDO);
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		String sql = String.format("DELETE FROM %s", new HpPatBlackListDO().getTableName());
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql);
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new HpPatBlackListDO().getTableName() };
	}

	@Override
	public boolean importData() throws BizException {
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		HpPatBlackListDO[] hpPatBlackListDO = getDOsFromImportDB(new HpPatBlackListDO(), "1 = 1", true);
		if (ArrayUtils.isEmpty(hpPatBlackListDO))
			throw new BizException("医保患者黑名单导入数据为空！");

		// 4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
		processDOs(hpPatBlackListDO);

		// 5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		ServiceFinder.find(IHppatblacklistCudService.class).insert(hpPatBlackListDO);

		return true;
	}

}
