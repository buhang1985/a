package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班渠道--数据导入服务
 * @author yank
 *
 */
public class ScChlImportServiceImpl extends BaseDataImport<SchedulechlDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		SchedulechlDO[] scSrvChlDOs = getDOsFromImportDB(new SchedulechlDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scSrvChlDOs))
    		return true;
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(SchedulechlDO.ID_SCCHL,SchedulechlDO.CODE,SchedulechlDO.ID_SCCHL,SchedulechlDO.ID_GRP,SchedulechlDO.ID_ORG),scSrvChlDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		SchedulechlDO[] scSrvChlDOs = getDOsFromImportDB(new SchedulechlDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scSrvChlDOs))
    		return true;
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scSrvChlDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(ISchedulechlMDOCudService.class).insert(scSrvChlDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_chl");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_chl"};
	}
}
