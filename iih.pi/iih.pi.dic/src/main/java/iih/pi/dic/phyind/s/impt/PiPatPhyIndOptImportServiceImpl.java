package iih.pi.dic.phyind.s.impt;

import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import iih.pi.dic.phyind.i.IPiPatPhyIndOptDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者关注指标项目数据导入服务
 * @author ly
 *
 */
public class PiPatPhyIndOptImportServiceImpl extends BaseDataImport<PiPatPhyIndOptDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatPhyIndOptDO[] dos = getDOsFromImportDB(new PiPatPhyIndOptDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者关注指标项目导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatPhyIndOptDO.ID_PATPHYINDOPT,PiPatPhyIndOptDO.CODE,PiPatPhyIndOptDO.NAME), dos);
    	
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatPhyIndOptDO[] dos = getDOsFromImportDB(new PiPatPhyIndOptDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者关注指标项目导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPiPatPhyIndOptDOCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_phyindopt");//删除患者生理指标选项数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_phyindopt"};
	}
}
