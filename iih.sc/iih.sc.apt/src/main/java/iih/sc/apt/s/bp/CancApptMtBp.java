package iih.sc.apt.s.bp;

import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.op.CancAptOpBP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScaptRService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消医技预约
 * 
 * @author ccj
 *
 */
public class CancApptMtBp {
	/**
	 * 取消医技预约
	 * 
	 * @param id_apt 预约id
	 * @throws BizException
	 */
	public void exec(String id_apt) throws BizException {
		if (StringUtils.isEmpty(id_apt))
			return;
		IScaptRService iScaptRService = ServiceFinder.find(IScaptRService.class);
		ScaptAggDO aggDO = iScaptRService.findById(id_apt);
		ScAptDO aptDO = aggDO.getParentDO();
		if (aptDO == null)
			return;
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(id_apt);// 预约id
		aptDTO.setId_scchl(aptDTO.getId_scchl());// 渠道id
		CancAptOpBP cancBP = new CancAptOpBP();
		cancBP.exec(aptDTO);
		UpdateSdSuObsBp obsBp = new UpdateSdSuObsBp();
		ScAptMtDO[] aptMtDOs = aggDO.getScAptMtDO();
		if (ArrayUtils.isEmpty(aptMtDOs))
			return;
		// obsBp.exec(aptMtDOs[0].getId_or(), FBoolean.FALSE);字段删除（zhengcm
		// 2017-08-23）
	}
}
