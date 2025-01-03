package iih.ci.ord.s.bp.impt;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class OrTmplItmImportServiceImpl extends BaseDataImport<OrTplNItmDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(), "1=1 ", false);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医嘱模板明细导入数据为空！");

		// 2、名称编码校验
		// checkNullValue(Arrays.asList(OrTplNItmDO.NAME, OrTplNItmDO.CODE),
		// dos);

		return true;
	}

	@Override
	public boolean importData() throws BizException {
		//从中间表得到update的数据
		OrTplNItmDO[] dosUpdate = getDOsFromUpdateDB(new OrTplNItmDO(),"1=1");
		if (!ArrayUtils.isEmpty(dosUpdate)){
			//处理DO状态为update
			processUpdateDOs(dosUpdate);

			// 5、调用框架的新增方法(其中包括管控唯一性校验等)更新目标库
			ServiceFinder.find(IOrTplNItmDOCudService.class).update(dosUpdate);
		}
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(),"1=1",true);
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
		daFacade.execUpdate("delete from " + new OrTplNItmDO().getTableName() + ""+ " where "+new OrTplNItmDO().getPKFieldName() +" not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new OrTplNItmDO().getTableName() };
	}

	@Override
	public boolean checkBusiness() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
//		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(), "1=1", false);
	//	DAFacade daFacade = new DAFacade();
		DAFacade daFacade = new DAFacade();
		List<OrTplNItmDO> doses =(List<OrTplNItmDO>) daFacade.findByCond((new OrTplNItmDO()).getClass(), " (id_srv not in (select id_srv from bd_srv))");
		if (doses != null && doses.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (OrTplNItmDO orTplNItmDO : doses) {
				if (sb.length() == 0) {
					sb.append("'" + orTplNItmDO.getId_srv() + "'");
				} else {
					sb.append(",'" + orTplNItmDO.getId_srv() + "'");
				}
			}

			throw new BizException("IIH.CI.LC表[bd_srv_ortmpl_itm]的字段[id_srv]中的值"+sb.toString()+"在引用表[bd_srv]中查询不到相应记录！(请检查中间库和目标库数据)");
		}
		List<OrTplNItmDO> itmDOs =(List<OrTplNItmDO>) daFacade.findByCond((new OrTplNItmDO()).getClass(), " (id_ortmpl not in (select id_ortmpl from bd_srv_ortmpl))");
		if (itmDOs != null && itmDOs.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (OrTplNItmDO orTplNItmDO : itmDOs) {
				if (sb.length() == 0) {
					sb.append("'" + orTplNItmDO.getId_ortmpl() + "'");
				} else {
					sb.append(",'" + orTplNItmDO.getId_ortmpl() + "'");
				}
			}

			throw new BizException("IIH.CI.LC表[bd_srv_ortmpl_itm]的字段[id_ortmpl]中的值"+sb.toString()+"在引用表[bd_srv_ortmpl]中查询不到相应记录！(请检查中间库和目标库数据)");
		}
		return true;
	}

}
