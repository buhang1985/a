package iih.pi.dic.phyind.s.impt;

import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.i.IPhyindMDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者关注指标数据导入服务
 * @author ly
 *
 */
public class PiPatPhyIndImportServiceImpl extends BaseDataImport<PiPatPhyIndDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatPhyIndDO[] dos = getDOsFromImportDB(new PiPatPhyIndDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者关注指标导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatPhyIndDO.ID_PATPHYIND,PiPatPhyIndDO.ID_ORG,PiPatPhyIndDO.ID_GRP,
    			PiPatPhyIndDO.CODE,PiPatPhyIndDO.NAME), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatPhyIndDO[] dos = getDOsFromImportDB(new PiPatPhyIndDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者关注指标导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPhyindMDOCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_phyind");//删除患者生理指标数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_phyind"};
	}
}
