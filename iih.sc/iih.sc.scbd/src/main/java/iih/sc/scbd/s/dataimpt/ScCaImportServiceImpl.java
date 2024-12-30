package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班分类--数据导入服务
 * @author yank
 *
 */
public class ScCaImportServiceImpl extends BaseDataImport<ScheduleCADO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleCADO[] scCaDOs = getDOsFromImportDB(new ScheduleCADO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scCaDOs)){
    		return true;//throw new BizException("排班分类导入数据为空！");
    	}
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScheduleCADO.ID_SCCA,ScheduleCADO.NAME,ScheduleCADO.CODE,ScheduleCADO.ID_SCCA,ScheduleCADO.ID_SCTP,ScheduleCADO.SD_SCTP,ScheduleCADO.ID_GRP,ScheduleCADO.ID_ORG),scCaDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleCADO[] scCaDOs = getDOsFromImportDB(new ScheduleCADO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scCaDOs)){
    		return true;//throw new BizException("排班分类导入数据为空！");
    	}
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scCaDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(ISchedulecaCudService.class).insert(scCaDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_ca");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_ca"};
	}
}
