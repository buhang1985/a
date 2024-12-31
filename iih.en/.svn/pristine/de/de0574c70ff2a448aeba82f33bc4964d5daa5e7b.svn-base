package iih.en.pv.s;

import iih.en.pv.dto.d.ObservationDTO;
import iih.en.pv.i.IEnEmCmdService;
import iih.en.pv.s.bp.ObsRegistBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 急诊命令服务
 * @author yankan
 * @date 2015-10-20
 *
 */
@Service(serviceInterfaces={IEnEmCmdService.class}, binding=Binding.JSONRPC)
public class EnEmCmdServiceImpl implements  IEnEmCmdService{
	/**
	 * 开急诊留观许可证
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	@Override
	public void openObsPermit(ObservationDTO obsDTO) throws BizException{
		ObsRegistBP obsRegistBP = new ObsRegistBP();
		obsRegistBP.openPermit(obsDTO);;
	}
	/**
	 * 取消许可
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	@Override
    public void cancObsPermit(ObservationDTO obsDTO) throws BizException{
		ObsRegistBP obsRegistBP = new ObsRegistBP();
		obsRegistBP.cancelPermit(obsDTO);
	}

	/**
	 * 确认留观许可
	 * @param obsDTO 留观DTO
	 * @throws BizException
	 */
	@Override
	public void cfmObsPermit(ObservationDTO obsDTO) throws BizException{
		ObsRegistBP obsRegistBP = new ObsRegistBP();
		obsRegistBP.confirmPermit(obsDTO);
	}	
}
