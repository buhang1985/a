package iih.en.pv.out.s;

import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.out.bp.cmd.UploadOpRegistBP;
import iih.en.pv.out.d.EnOpRegistBean;
import iih.en.pv.out.i.IEn4CiCmdService;
import iih.en.pv.out.i.IEn4ESCmdService;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.en.pv.s.bp.ip.RecordIpAcptDtBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 就诊对外接口（增删改）
 * 
 * @author jizb
 *
 */
@Service(serviceInterfaces = { IEn4CiCmdService.class, IEn4ESCmdService.class }, binding = Binding.JSONRPC)
public class EnOutCmdServiceImpl implements IEn4CiCmdService, IEn4ESCmdService {
	
	/****************IEn4CommCmdService****************/
	
	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	@Override
	public void setEntState(EntStateDTO entStateDTO) throws BizException {
		SetEntStateBP setBP = new SetEntStateBP();
		setBP.exec(entStateDTO);
	}
	
	/****************IEn4CiCmdService****************/
	/**
	 * 记录移动护理入科时间
	 * 
	 * @param patCode
	 * @param times_ip
	 * @param dt_acpt
	 * @param operatorCode
	 * @param flag
	 * @return
	 * @throws BizException
	 */
	@Override
	public String recordIpAcptDt(String patCode, String times_ip, String dt_acpt, String operatorCode, String flag) throws BizException {
		RecordIpAcptDtBP bp = new RecordIpAcptDtBP();
		String result = bp.exec(patCode, times_ip, dt_acpt, operatorCode, flag);
		return result;
	}
	
	/****************IEn4ESCmdService****************/
	/**
	 * 上传挂号信息
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	@Override
	public void uploadOpRegist(EnOpRegistBean opRegistInfo) throws BizException {
		new UploadOpRegistBP().exec(opRegistInfo);
	}

}
