package iih.pi.reg.pat.s.impt;

import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPiPatHpDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者医保计划数据导入服务
 * @author ly
 *
 */
public class PiPatHpImportServiceImpl extends BaseDataImport<PiPatHpDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatHpDO[] dos = getDOsFromImportDB(new PiPatHpDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者医保计划导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatHpDO.ID_PAT,PiPatHpDO.ID_HP,PiPatHpDO.NO_HP), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatHpDO[] dos = getDOsFromImportDB(new PiPatHpDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者医保计划导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPiPatHpDOCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_hp");//删除患者医保数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_hp"};
	}
}
