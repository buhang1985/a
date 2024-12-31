package iih.bl.hp.blhppatspec.impt;

import iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO;
import iih.bl.hp.blhppatspec.i.IBlHpPatSpecDiDOCudService;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保特殊病患者疾病
 * 
 * @author liwq  2017年7月7日16:26:17
 *
 */
public class BlHpPatSpecDiImportServiceImpl extends BaseDataImport<BlHpPatSpecDiDO> implements IDataImport{

	@Override
	public boolean checkNotNull() throws BizException {
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlHpPatSpecDiDO[] BlHpPatSpecDiDOs = getDOsFromImportDB(new BlHpPatSpecDiDO(),"1=1",false);
    	if (ArrayUtils.isEmpty(BlHpPatSpecDiDOs))
    		throw new BizException("医保特殊病患者疾病导入数据为空！");
    	
    	//1、非空字段校验
    	checkNullValue(Arrays.asList(BlHpPatSpecDiDO.ID_HPPATSPEC,BlHpPatSpecDiDO.CODE_DI,BlHpPatSpecDiDO.NAME_DI));
		return true;
	}
	
	@Override
	public boolean checkBusiness() throws BizException {		
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlHpPatSpecDiDO[] BlHpPatSpecDiDOs = getDOsFromImportDB(new BlHpPatSpecDiDO(),"1=1",false);
    	if (ArrayUtils.isEmpty(BlHpPatSpecDiDOs))
    		throw new BizException("医保特殊病患者疾病导入数据为空！");
		return true;
	}
	
	@Override
	public boolean importData() throws BizException {    	
	
		//从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		BlHpPatSpecDiDO[] BlHpPatSpecDiDOs = getDOsFromImportDB(new BlHpPatSpecDiDO(),"1=1",true);
    	if (ArrayUtils.isEmpty(BlHpPatSpecDiDOs))
    		throw new BizException("医保特殊病患者疾病导入数据为空！");
    	
    	//因 do 主键已经重新生成且替换、只用将状态设为 NEW
    	processDOs(BlHpPatSpecDiDOs);
    	
    	//调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
    	ServiceFinder.find(IBlHpPatSpecDiDOCudService.class).insert(BlHpPatSpecDiDOs);    	
    	return true;
    }

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bl_hp_pat_spec_di");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"bl_hp_pat_spec_di"};
	}
	
	
}
