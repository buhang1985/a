package iih.pi.dic.cardtype.s.impt;

import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者卡类型数据导入服务
 * @author ly
 *
 */
public class PiPatCardTypeImportServiceImpl extends BaseDataImport<PiPatCardTpDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		//1.取得数据
		PiPatCardTpDO[] dos = getDOsFromImportDB(new PiPatCardTpDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者卡类型导入数据为空！");
		
    	//2.非空校验
    	checkNullValue(Arrays.asList(PiPatCardTpDO.ID_CARDTP,PiPatCardTpDO.ID_ORG,PiPatCardTpDO.ID_GRP,PiPatCardTpDO.ID_PATCARDTP,
    			PiPatCardTpDO.SD_PATCARDTP,PiPatCardTpDO.CODE,PiPatCardTpDO.NAME), dos);
		return true;
	}
	
	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatCardTpDO[] dos = getDOsFromImportDB(new PiPatCardTpDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者卡类型导入数据为空！");
		
    	//3.设置status
    	processDOs(dos);
    	
    	//4.数据插入目标库
    	ServiceFinder.find(ICardtypeCudService.class).insert(dos);
    	
		return true;
	}
	
	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_cardtp");//删除患者生理指标数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_cardtp"};
	}
}
