package iih.ei.bl.ecinc.i;

import java.util.List;

import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkOutDTO;
import xap.mw.core.data.BizException;

/**
 * 电子票据票据管理接口
 * @author ly 2019/12/02
 *
 */
public interface IEcIncManageService {

	/**
	 * 获取纸质发票有效票据代码
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/02
	 */
	public abstract EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> getPaperActiveIncCode(EcIncManagePaperIncCodeInDTO dto) throws BizException;
	
	/**
	 * 查询第三方电子票据的总开票数和总金额
	 * @param dto 入参：开票日期范围、开票点编码、收费/退费、数据类型写死：电子发票
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/02
	 */
	public abstract EcIncResultDTO<EcIncTotalChkOutDTO> qryTridTotalData(CheckTotalDataDTO dto) throws BizException;
	
	/**
	 * 查询第三方电子票据明细集合
	 * @param dto 入参：开票日期范围、开票点编码、收费/退费、数据类型写死：电子发票
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/02
	 */
	public abstract EcIncResultDTO<List<EcIncBillListDTO>> qryTridBillInfoList(CheckTotalDataDTO dto) throws BizException;
	
}
