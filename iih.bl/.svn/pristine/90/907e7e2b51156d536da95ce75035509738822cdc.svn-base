package iih.bl.pay.blpaypat.impt;

import xap.mw.core.data.BizException;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

/**
 * 预交金导入类
 * @author tcy
 * @since 2017-5-7
 */
public class BlPayPatImportServiceImpl  extends BaseDataImport<BlPrePayPatDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlPrePayPatDO[] primdDOs = getDOsFromImportDB(new BlPrePayPatDO(),"1=1",false);
    	if (ArrayUtils.isEmpty(primdDOs))
    		throw new BizException("患者预交金导入数据为空！");
    	
    	//1、非空字段校验
    	checkNullValue(Arrays.asList(BlPrePayPatDO.ID_PAYPAT,BlPrePayPatDO.SD_PAYTP,BlPrePayPatDO.ID_PAYTP,BlPrePayPatDO.ID_PAT,BlPrePayPatDO.ID_ENTTP,BlPrePayPatDO.CODE_ENTTP,BlPrePayPatDO.ID_ORG,BlPrePayPatDO.ID_GRP,BlPrePayPatDO.EU_DIRECT,BlPrePayPatDO.AMT,BlPrePayPatDO.ID_PM,BlPrePayPatDO.SD_PM,BlPrePayPatDO.DT_PAY),primdDOs);
		return true;
	}
	
	@Override
	public boolean checkBusiness() throws BizException {
		
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlPrePayPatDO[] blPrePayPatDOs = getDOsFromImportDB(new BlPrePayPatDO(),"1=1",false);
    	if (ArrayUtils.isEmpty(blPrePayPatDOs))
    		throw new BizException("患者预交金导入数据为空！");
    	
    	 //2.系统表中校验
//    	boolean isFgSys = false;
//    	for (BlPrePayPatDO primdDO : blPrePayPatDOs) {
//    		if (primdDO.getFg_sys()==null || ("Y").equals(primdDO.getFg_sys()) || ("N").equals(primdDO.getFg_sys()))
//    		{
//    			if (!isFgSys){
//    				throw new BizException("定价模式此条数据未设置系统标志！数据："+primdDO.getName());
//    			}    			
//    			isFgSys = true;
//    		}
//		}
    	
		return true;
	}
	
	@Override
	public boolean importData() throws BizException {
    	
    	
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlPrePayPatDO[] blPrePayPatDOs = getDOsFromImportDB(new BlPrePayPatDO(),"1=1",true);
    	if (ArrayUtils.isEmpty(blPrePayPatDOs))
    		throw new BizException("定价模式导入数据为空！");
    	
    	//4、因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(blPrePayPatDOs);
    	
    	//5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IBlpaypatCudService.class).insert(blPrePayPatDOs);
    	
    	return true;
    }

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from BL_PREPAY_PAT");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"BL_PREPAY_PAT"};
	}
}
