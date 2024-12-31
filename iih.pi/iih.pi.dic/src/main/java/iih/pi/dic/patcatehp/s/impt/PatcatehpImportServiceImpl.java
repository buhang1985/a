package iih.pi.dic.patcatehp.s.impt;

import java.util.Arrays;

import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class PatcatehpImportServiceImpl extends BaseDataImport<PiPatCaHpDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatCaHpDO[] dos = getDOsFromImportDB(new PiPatCaHpDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者分类医保计划导入数据为空！");
    	
    	//2.非空校验
		checkNullValue(Arrays.asList(PiPatCaHpDO.ID_GRP, PiPatCaHpDO.ID_ORG,
				PiPatCaHpDO.ID_PATCA, PiPatCaHpDO.ID_HP), dos);
    	
		return true;
	}

	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_ca_hp");//删除患者分类医保计划
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_ca_hp"};
	}

	@Override
	public boolean importData() throws BizException {

		//1.取得数据
		PiPatCaHpDO[] dos = getDOsFromImportDB(new PiPatCaHpDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者分类医保计划导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(IPatcatehpCudService.class).insert(dos);
    	
		return true;
	}
}
