package iih.pi.overview.overview.s.impt;

import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者过敏史导入服务
 * @author ly 2017/05/10
 *
 */
public class PiPatAlImportServiceImpl  extends BaseDataImport<PiPatAlDO> implements IDataImport {

	/**
	 * 非空校验
	 */
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatAlDO[] dos = getDOsFromImportDB(new PiPatAlDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者过敏史导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatAlDO.ID_PAT), dos);
		return true;
	}

	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_al");//删除患者过敏史数据
		return true;
	}

	/**
	 * 导入表名
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_al"};
	}

	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {

		//1.取得数据
		PiPatAlDO[] dos = getDOsFromImportDB(new PiPatAlDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者过敏史导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPiPatAlDOCudService.class).insert(dos);
    	
		return true;
	}
}
