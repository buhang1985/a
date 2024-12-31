package iih.bl.inc.s.ep;

import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.d.desc.BlIncCancDODesc;
import iih.bl.inc.blinccanc.i.IBlinccancRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 空白作废发票扩展类
 * @author ly 2018/03/30
 *
 */
public class CancIncEP {

	/**
	 * 查询指定票号之后的作废空白票
	 * @param inccaId
	 * @param pkgCode
	 * @param incNo
	 * @return
	 * @throws BizException
	 */
	public BlIncCancDO[] findCancInc(String inccaId,String pkgCode,String incNo) throws BizException{
		
		IBlinccancRService rService = ServiceFinder.find(IBlinccancRService.class);
		String whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and %s.%s >= '%s'",
				BlIncCancDODesc.TABLE_ALIAS_NAME, BlIncCancDO.ID_INCCA, inccaId,
				BlIncCancDODesc.TABLE_ALIAS_NAME, BlIncCancDO.CODE_INCPKG, pkgCode,
				BlIncCancDODesc.TABLE_ALIAS_NAME, BlIncCancDO.INCNO,incNo);
	
		BlIncCancDO[] dos = rService.find(whereSql, "", FBoolean.FALSE);
		return dos;
	}
}
