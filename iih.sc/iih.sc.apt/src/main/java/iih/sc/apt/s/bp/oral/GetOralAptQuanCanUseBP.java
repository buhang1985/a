package iih.sc.apt.s.bp.oral;

import iih.sc.apt.dto.d.AptOralDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 获取口腔预约号源池剩余数量BP
 * 
 * @author zhengcm
 * @date 2016-11-24 17:44:42
 *
 */
public class GetOralAptQuanCanUseBP {

	public int exec(AptOralDTO oralAptDTO) throws BizException {
		if (oralAptDTO == null) {
			return 0;
		}
		List<AptOralDTO> list = new ArrayList<AptOralDTO>();
		list.add(oralAptDTO);
		new SetOralAptQuanCanUseBP().exec(list);
		return list.get(0).getQuan_can_appt();
	}

}
