package iih.ci.ord.s.bp.impt;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * @author li_cheng
 *
 */
public class MedSrvSetItemImportServiceImpl extends BaseDataImport<MedSrvSetItemDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvSetItemDO[] dos = getDOsFromImportDB(new MedSrvSetItemDO(), "1=1", false);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医疗服务套项目定义导入数据为空！");

		// 2、名称编码校验
		// checkNullValue(Arrays.asList(MedSrvDO.NAME, MedSrvDO.CODE), dos);
		return true;
	}

	@Override
	public boolean importData() throws BizException {
		//从中间表得到update的数据
		MedSrvSetItemDO[] dosUpdate = getDOsFromUpdateDB(new MedSrvSetItemDO(),"1=1");
		if (!ArrayUtils.isEmpty(dosUpdate)){
			//处理DO状态为update
			processUpdateDOs(dosUpdate);

			// 5、调用框架的新增方法(其中包括管控唯一性校验等)更新目标库
			ServiceFinder.find(IMedSrvSetItemDOCudService.class).update(dosUpdate);
		}
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvSetItemDO[] dos = getDOsFromImportDB(new MedSrvSetItemDO(),"1=1",true);
    	if (!ArrayUtils.isEmpty(dos)){			
			// 3、状态改为New
			processDOs(dos);
			
			// 调用框架的新增方法(其中包括管控唯一性校验等)插入目标库  ??   基础服务的校验不适用数据导入
			DAFacade daFacade = new DAFacade();
			daFacade.insertDOArrayWithPK(dos);
		}
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from " + new MedSrvSetItemDO().getTableName() + "" + " where "
				+ new MedSrvSetItemDO().getPKFieldName() + " not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new MedSrvSetItemDO().getTableName() };
	}
}
