package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvChlDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvChlDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班服务渠道--数据导入服务
 * @author yank
 *
 */
public class ScSrvChlImportServiceImpl extends BaseDataImport<ScheduleSrvChlDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvChlDO[] scSrvChlDOs = getDOsFromImportDB(new ScheduleSrvChlDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scSrvChlDOs))
    		return true;
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScheduleSrvChlDO.ID_SCSRVCHL,ScheduleSrvChlDO.SCPOLNO,ScheduleSrvChlDO.ID_SCCHL),scSrvChlDOs);
    
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvChlDO[] scSrvChlDOs = getDOsFromImportDB(new ScheduleSrvChlDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scSrvChlDOs))
    		return true;
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scSrvChlDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IScheduleSrvChlDOCudService.class).insert(scSrvChlDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_srv_chl");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_srv_chl"};
	}
}
