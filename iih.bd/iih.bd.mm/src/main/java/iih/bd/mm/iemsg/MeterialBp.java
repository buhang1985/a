package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.MeterialDTO;
import iih.bd.mm.iemsg.qry.MeterialSql;
import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.core.data.BizException;

/**
 * 获取物品修改后数据。
 * @author shao_yuan
 *
 */
public  class MeterialBp{

	public MeterialDTO[] setMmDTO(MeterialDO[] mmlist,String eventtype) throws BizException{
		
			//获得物品字典数据信息
			MeterialSql sql = new MeterialSql();
			MeterialDTO[] ors=sql.setByStatu(mmlist,eventtype);
			
			return ors;
	}	

}
