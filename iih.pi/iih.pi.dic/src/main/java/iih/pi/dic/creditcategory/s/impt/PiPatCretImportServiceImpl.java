package iih.pi.dic.creditcategory.s.impt;

import iih.pi.dic.creditcategory.d.PiPatCretDO;
import iih.pi.dic.creditcategory.i.ICreditcategoryCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者信用分类数据导入服务
 * @author ly
 *
 */
public class PiPatCretImportServiceImpl extends BaseDataImport<PiPatCretDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatCretDO[] dos = getDOsFromImportDB(new PiPatCretDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者信用分类导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatCretDO.ID_PATCRET,PiPatCretDO.ID_ORG,PiPatCretDO.ID_GRP,
    			PiPatCretDO.CODE,PiPatCretDO.NAME), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatCretDO[] dos = getDOsFromImportDB(new PiPatCretDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者信用分类导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(ICreditcategoryCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_cret");//删除患者生理指标数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_cret"};
	}
}
