package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班服务关联服务--数据导入服务
 * @author yank
 *
 */
public class ScSrvRelImportServiceImpl extends BaseDataImport<ScheduleSrvRelDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvRelDO[] scSrvRelDOs = getDOsFromImportDB(new ScheduleSrvRelDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scSrvRelDOs)){
    		return true;//throw new BizException("排班分类导入数据为空！");
    	}
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScheduleSrvRelDO.ID_SCSRVREL,ScheduleSrvRelDO.ID_MDSRV),scSrvRelDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvRelDO[] scSrvRelDOs = getDOsFromImportDB(new ScheduleSrvRelDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scSrvRelDOs)){
    		return true;//throw new BizException("排班分类导入数据为空！");
    	}
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scSrvRelDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IScheduleSrvRelDOCudService.class).insert(scSrvRelDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_srv_rel");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_srv_rel"};
	}
}
