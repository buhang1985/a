package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.iemsg.d.IEIpFreqDictDTO;
import xap.mw.core.data.BaseDTO;

/**
 * 频次增、删、改事件
 *
 */
public class GetIEIpMsgInfo4FreqBP {

	public BaseDTO[] exec(FreqdefAggDO[] aggDOs, String eventType) {

		List<IEIpFreqDictDTO> dtolist = new ArrayList<>();
		for (FreqdefAggDO item : aggDOs) {
			FreqDefDO freq = item.getParentDO();
			IEIpFreqDictDTO dto = new IEIpFreqDictDTO();
			dto.setId_ieipfreqdict(freq.getId_freq());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(freq.getCode());
			dto.setName(freq.getName());
			dto.setPy_code(freq.getPycode());
			dto.setPrint_name(freq.getCode_disp());
			dto.setDomain_id("02");
			dto.setMzflag("0");
			if(freq.getSd_frequnitct()==IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK){
				dto.setWeek_day("Y");
			}else{
				dto.setWeek_day("N");
			}
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEIpFreqDictDTO[1]);

	}

}
