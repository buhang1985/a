package iih.ei.bl.ecinc.i;

import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import xap.mw.core.data.BizException;

/**
 * 电子票据纸质票据操作接口
 * @author ly 2019/12/02
 *
 */
public interface IEcIncPaperService {

	/**
	 * 获取纸质发票当前票号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract EcIncResultDTO<EcIncPaperCurIncNoOutDTO> getCurIncNo(EcIncPaperCurIncNoInDTO dto) throws BizException;
	
	/**
	 * 换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract EcIncResultDTO<EcIncPaperSwitchOutDTO> swichPaperInc(EcIncPaperSwitchInDTO dto) throws BizException;

	/**
	 * 重新换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract EcIncResultDTO<EcIncPaperReSwitchOutDTO> reSwichPaperInc(EcIncPaperReSwitchInDTO dto) throws BizException;
}
