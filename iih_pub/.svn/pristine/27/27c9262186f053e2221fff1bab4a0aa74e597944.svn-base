package iih.ei.bl.ecinc.s;

import java.util.List;

import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkOutDTO;
import iih.ei.bl.ecinc.i.IEcIncManageService;
import xap.mw.core.data.BizException;

/**
 * 电子票据票据管理基础类
 * @author ly 2019/12/02
 *
 */
public class EcIncManageBaseServiceImpl implements IEcIncManageService{

	@Override
	public EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> getPaperActiveIncCode(EcIncManagePaperIncCodeInDTO dto) throws BizException {
		throw new BizException("未实现获取纸质发票有效票据代码方法");
	}

	@Override
	public EcIncResultDTO<EcIncTotalChkOutDTO> qryTridTotalData(CheckTotalDataDTO dto) throws BizException {
		throw new BizException("未实现查询第三方电子票据的总开票数和总金额方法");
	}

	@Override
	public EcIncResultDTO<List<EcIncBillListDTO>> qryTridBillInfoList(CheckTotalDataDTO dto) throws BizException {
		throw new BizException("未实现查询第三方电子票据明细集合方法");
	}
}
