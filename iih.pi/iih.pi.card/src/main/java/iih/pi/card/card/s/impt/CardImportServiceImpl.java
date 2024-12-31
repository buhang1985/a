package iih.pi.card.card.s.impt;

import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;

import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class CardImportServiceImpl  extends BaseDataImport<PiCardDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		
		PiCardDO[] dos = getDOsFromImportDB(new PiCardDO(),"1=1",false);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者就诊卡导入数据为空！");
    	
    	checkNullValue(Arrays.asList(PiCardDO.ID_PATCARDTP,PiCardDO.CODE,
    			PiCardDO.EU_CARDSU,PiCardDO.FG_GET,PiCardDO.FG_CANC),dos);
    	
    	return true;
	}
	
	@Override
	public boolean importData() throws BizException {
		
		PiCardDO[] dos = getDOsFromImportDB(new PiCardDO(),"1=1",true);
    	if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者就诊卡导入数据为空！");
    	
    	processDOs(dos);
    	
    	ServiceFinder.find(ICardCudService.class).insert(dos);
    	
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_card");//删除患者联系人数据
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_card"};
	}
}
