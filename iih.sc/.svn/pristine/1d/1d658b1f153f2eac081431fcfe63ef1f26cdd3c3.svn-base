package iih.sc.apt.s.bp.ip;

import com.mysql.jdbc.StringUtils;

import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.s.ep.AptIpEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/***
 * 住院预约-设置备注
 * @author FANLQ
 *
 */
public class SetNoteIpAptBP {
	/***
	 * 住院预约-设置备注
	 * @param aptDTO
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptDTO) throws BizException{
		AptIpDO aptIpDO = new AptIpDO();
		AptIpEP ep = new AptIpEP();
		if(aptDTO != null && !StringUtils.isNullOrEmpty(aptDTO.getId_scaptip())){
			aptIpDO = ep.find(aptDTO.getId_scaptip());
			if(aptIpDO != null)
				aptIpDO.setNote(aptDTO.getNote());
				//设置床位确认信息反馈,fanlq-2018.03.14
			    aptIpDO.setNote_apt(aptDTO.getInfofeedback());
			aptIpDO.setStatus(DOStatus.UPDATED);
			ep.save(new AptIpDO[]{aptIpDO});
		}
	}
}
