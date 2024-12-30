package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班服务--数据导入服务
 * @author yank
 *
 */
public class ScSrvImportServiceImpl extends BaseDataImport<ScheduleSrvDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvDO[] scSrvDOs = getDOsFromImportDB(new ScheduleSrvDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scSrvDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScheduleSrvDO.ID_SCSRV,ScheduleSrvDO.NAME,ScheduleSrvDO.CODE,ScheduleSrvDO.ID_SCTP,ScheduleSrvDO.SD_SCTP,ScheduleSrvDO.ID_SRVTP,ScheduleSrvDO.SD_SRVTP,ScheduleSrvDO.SD_TICKMD,ScheduleSrvDO.ID_TICKMD,ScheduleSrvDO.ID_APPTRU,ScheduleSrvDO.ID_GRP,ScheduleSrvDO.ID_ORG),scSrvDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScheduleSrvDO[] scSrvDOs = getDOsFromImportDB(new ScheduleSrvDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scSrvDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scSrvDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(ISchedulesrvMDOCudService.class).insert(scSrvDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_srv");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_srv"};
	}
}
