package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.op.CancAptOpBP;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消预约
 * @author yank
 *
 */
public class CancAptOpInRoomBP {
	/**
	 * 取消预约
	 * @param aptDTO 预约dto
	 * @throws BizException
	 */
	public void exec(OpAptDTO aptDTO) throws BizException{	
		ScValidator.validateParam("预约DTO", aptDTO);
		//1、验证渠道
		ISchedulechlMDORService schedulechlRService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO schedulechlDO = schedulechlRService.findById(aptDTO.getId_scchl());
		// 如果渠道是诊间时，需要控制必须是预约医生来取消
		if(!IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM.equals(schedulechlDO.getSd_scchltp())
				&& !IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT.equals(schedulechlDO.getSd_scchltp())){
			throw new BizException(IScMsgConst.SC_APT_NOT_IN_ROOM_CHL);
		}			
		
		//2、取消需预约医生取消
		if(StringUtil.isEmptyWithTrim(aptDTO.getId_emp_appt())){
			throw new BizException(IScMsgConst.SC_APT_HAS_NO_EMP);
		}
		if(!aptDTO.getId_emp_appt().equals(ScContextUtils.getPsnId())){
			throw new BizException(IScMsgConst.SC_APT_CAN_CANCEL_BY_APT_DOC);
		}
		
		CancAptOpBP cancBP = new CancAptOpBP();
		cancBP.exec(aptDTO);		
	}
}
