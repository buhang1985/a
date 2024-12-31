package iih.pi.reg.pat.s.impt;

import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者卡信息数据导入服务
 * @author ly
 *
 */
public class PiPatCardImportServiceImpl extends BaseDataImport<PiPatCardDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatCardDO[] dos = getDOsFromImportDB(new PiPatCardDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者卡信息导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatCardDO.ID_PAT,PiPatCardDO.ID_PATCARDTP,
    			PiPatCardDO.SD_PATCARDTP,PiPatCardDO.CODE), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatCardDO[] dos = getDOsFromImportDB(new PiPatCardDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者卡信息导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPiPatCardDOCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_card");//删除患者卡信息数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_card"};
	}
}
