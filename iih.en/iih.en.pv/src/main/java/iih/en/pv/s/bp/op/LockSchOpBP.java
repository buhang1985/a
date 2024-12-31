package iih.en.pv.s.bp.op;

import iih.en.comm.util.EnAppUtils;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.dto.d.SchLockDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 门诊排班锁号
 * @author fanlq
 * @date: 2019年10月22日 下午3:44:58
 */
public class LockSchOpBP {

	/***
	 * @Description:门诊排班锁号
	 * @param reginfo
	 * @return
	 * @throws BizException 
	 */
	public LockResultDTO exec(RegInfoDTO reginfo) throws BizException{
		LockResultDTO result = new LockResultDTO();
		if(reginfo == null){
			result.setErrmsg("挂号信息为空！");
			return result;
		}
		RegResDTO[] resDTOs = (RegResDTO[])reginfo.getRegresarray().toArray(new RegResDTO[]{});
		String id_session = EnAppUtils.getServerDate().toString().replace("-", "").replace(" ", "")
				+Context.get().getClientHost()+reginfo.getId_emp_entry();
		SchLockDTO dto = new SchLockDTO();
		dto.setId_session(id_session);
		dto.setId_pat(reginfo.getId_pat());
		dto.setId_sch(reginfo.getId_sch());
		dto.setId_emp(reginfo.getId_emp_entry());
		dto.setId_chl(resDTOs[0].getId_scchl());
		dto.setId_tick(reginfo.getId_tick());
		dto.setId_ticks(reginfo.getId_ticks());
		dto.setPolcn(resDTOs[0].getPolcn());
		IScSchOutCmdService service = ServiceFinder.find(IScSchOutCmdService.class);
		result = service.lockSchOp(dto);
		return result;
	}
}
