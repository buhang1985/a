package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.AuditEntryDTO;
import iih.bd.mm.iemsg.d.AuditEventDTO;
import iih.bd.mm.iemsg.qry.AuditEventSql;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import xap.mw.core.data.BizException;

public class AuditEventBp {

	public AuditEntryDTO[] setMmDTO(StockPriceAdjustDO[] dedos,String eventtype) throws BizException {
		//获得物品包装单位计量单位数据信息
		AuditEventSql sql = new AuditEventSql();
		AuditEntryDTO[] ors=sql.setByMmid(dedos,eventtype);
		return ors;
	}

	public AuditEventDTO setAuditEventDTO(AuditEntryDTO[] wareDTO,String eventtype) throws BizException {
				
		AuditEventSql sql = new AuditEventSql();
		AuditEventDTO dto = sql.converyArray2FArrayList(wareDTO,eventtype);
		
		return dto;
	}

}
