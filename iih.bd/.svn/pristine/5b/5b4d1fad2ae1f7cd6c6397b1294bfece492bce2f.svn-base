package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.MmcaEventDTO;
import iih.bd.mm.iemsg.qry.MmcaEventSql;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;

/**
 * 获取物品类型修改后数据。
 * @author shao_yuan
 *
 */

public class MmcaEventBp {

	public MmcaEventDTO[] setMmcaDTO(MMCategoryDO[] mmcalist,String eventtype) throws BizException {		
		
		//获得物品类型数据信息
		MmcaEventSql sql = new MmcaEventSql();
		MmcaEventDTO[] ors=sql.setByStatu(mmcalist,eventtype);
		return ors;
	}	

}
