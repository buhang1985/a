package iih.pe.pps.i;

import iih.pe.pps.dto.pepositracklistdto.d.PePosiTrackListDTO;
import iih.pe.pwf.dto.pewfqcheckedovaldto.d.PeWfQcheckedOvalDTO;
import xap.mw.core.data.BizException;

public interface IPePosiTrackListQueryService {
    /// <summary>
    /// 条件查询体检阳性追踪人员列表
    /// </summary>
    /// <param name="name"></param>
	/// <param name="startTime"></param>
	/// <param name="endTime"></param>
	/// <param name="cardNo"></param>
	/// <param name="mob"></param>
    /// <returns></returns>
	public PePosiTrackListDTO[] findPePosiTrackList(String dt_pe, String ent_date,String room_id,String id_pecorpappt,String groupId, String curstate) throws BizException;
	
	//根据体检流程号进行检索
	PePosiTrackListDTO[] findPePosiTrackListDTOByCardPe(String cardPe) throws BizException;

}
