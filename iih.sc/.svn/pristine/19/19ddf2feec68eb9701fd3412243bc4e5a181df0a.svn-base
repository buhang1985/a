package iih.sc.scbd.s.dataimpt;

import java.util.Arrays;

import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 排班计划--数据导入服务
 * @author yank
 *
 */
public class ScPlImportServiceImpl extends BaseDataImport<ScPlanDO> implements IDataImport{
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScPlanDO[] scSrvDOs = getDOsFromImportDB(new ScPlanDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(scSrvDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//2、非空字段校验
    	checkNullValue(Arrays.asList(ScPlanDO.NAME,ScPlanDO.CODE,ScPlanDO.ID_SCSRV,ScPlanDO.ID_SCRES,ScPlanDO.ID_SCTP,ScPlanDO.SD_SCTP,ScPlanDO.ID_DEP,ScPlanDO.SD_TICKMD,ScPlanDO.ID_TICKMD,ScPlanDO.SCPOLCN,ScPlanDO.ID_APPTRU,ScPlanDO.ID_GRP,ScPlanDO.ID_ORG),scSrvDOs);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		//1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		ScPlanDO[] scSrvDOs = getDOsFromImportDB(new ScPlanDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(scSrvDOs)){
    		return true;//throw new BizException("排班服务导入数据为空！");
    	}
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(scSrvDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IScplanCudService.class).insert(scSrvDOs);
		return true;
	}
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from sc_pl");
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"sc_pl"};
	}
}
