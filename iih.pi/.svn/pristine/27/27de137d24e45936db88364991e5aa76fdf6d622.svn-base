package iih.pi.reg.pat.s.impt;

import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatContDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者联系人数据导入服务
 * @author ly
 *
 */
public class PiPatContImportServiceImpl extends BaseDataImport<PiPatContDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatContDO[] dos = getDOsFromImportDB(new PiPatContDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者联系人导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatContDO.ID_PAT,PiPatContDO.ID_CONTTP,PiPatContDO.SD_CONTTP,
    			PiPatContDO.NAME,PiPatContDO.CONTTEL), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatContDO[] dos = getDOsFromImportDB(new PiPatContDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者联系人导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPiPatContDOCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_cont");//删除患者联系人数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_cont"};
	}
}
