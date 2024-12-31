package iih.ei.bl.ecinc.bosssoft.v2.s;

import java.util.List;

import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncManageGetActicePIncCodeBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftQryBillInfoListBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftQryTotalDataBP;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkOutDTO;
import iih.ei.bl.ecinc.s.EcIncManageBaseServiceImpl;
import xap.mw.core.data.BizException;

/**
 * 博思电子发票票据管理处理
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncManageServiceImpl extends EcIncManageBaseServiceImpl{

	private static BossSoftEcIncManageServiceImpl instance;
	
	static{
		instance = new BossSoftEcIncManageServiceImpl();
	}
	
	public static BossSoftEcIncManageServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> getPaperActiveIncCode(EcIncManagePaperIncCodeInDTO dto) throws BizException {
		BossSoftEcIncManageGetActicePIncCodeBP bp = new BossSoftEcIncManageGetActicePIncCodeBP();
		return bp.exec(dto);
	}
	
	/**
	 * 获取第三方总笔数，总金额
	 */
	@Override
	public EcIncResultDTO<EcIncTotalChkOutDTO> qryTridTotalData(CheckTotalDataDTO dto) throws BizException {
		BossSoftQryTotalDataBP bp = new BossSoftQryTotalDataBP();
		return bp.exec(dto);
	}

	/**
	 * 根据业务时间获取开票信息接口
	 */
	@Override
	public EcIncResultDTO<List<EcIncBillListDTO>> qryTridBillInfoList(CheckTotalDataDTO dto) throws BizException {
		BossSoftQryBillInfoListBP bp = new BossSoftQryBillInfoListBP();
		return bp.exec(dto);
	}
}
