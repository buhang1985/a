package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.i.IScScpCmdService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.i.IScplweekMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班周计划--数据导入服务
 * @author yank
 *
 */
public class ScPlWeekImportServiceImpl extends BaseDataImport<ScPlanWeekDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScPlanWeekDO[] weekDOs = getDOsFromImportDB(new ScPlanWeekDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(weekDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScPlanWeekDO.ID_DAYSLOT,ScPlanWeekDO.WEEKNO,ScPlanWeekDO.QUAN_TOTAL,ScPlanWeekDO.QUAN0_APPT,ScPlanWeekDO.QUAN_TOTAL_APPT,ScPlanWeekDO.SCPOLCN),weekDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScPlanWeekDO[] weekDOs = getDOsFromImportDB(new ScPlanWeekDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(weekDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(weekDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IScplweekMDOCudService.class).insert(weekDOs);
    	
    	//生成号位
    	this.generateTick(weekDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_pl_week");
		return true;
	}
	/**
	 * 生成号位
	 * @param weekDOs
	 * @throws BizException
	 */
	private void generateTick(ScPlanWeekDO[] weekDOs) throws BizException{
		IScScpCmdService service = ServiceFinder.find(IScScpCmdService.class);
		service.savePlanWeek(weekDOs, IScDictCodeConst.SD_TICKMD_TICK);
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_pl_week"};
	}
}
