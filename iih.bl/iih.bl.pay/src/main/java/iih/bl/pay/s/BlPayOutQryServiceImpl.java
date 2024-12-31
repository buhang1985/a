package iih.bl.pay.s;

import java.util.Map;

import iih.bl.et.etaccountdto.d.ETAccountDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderInParamDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderOutParamDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blspclpatamt.d.BlSpclPatAmtDTO;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayAmountDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.bl.pay.s.bp.GetAccJudgeBP;
import iih.bl.pay.s.bp.GetAccJugeIpByentIdsBP;
import iih.bl.pay.s.bp.GetArrearsControlBP;
import iih.bl.pay.s.bp.GetOpRegPayDetailBP;
import iih.bl.pay.s.bp.GetPrepayAmountInfoBP;
import iih.bl.pay.s.bp.ip.GetPrepayInfoByIpStIdBP;
import iih.bl.pay.s.bp.op.GetPatCardAmtBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 收付款对外查询服务
 * @author yankan
 * @since 2017-07-06
 *
 */
@Service(serviceInterfaces={IBlPayOutQryService.class}, binding=Binding.JSONRPC)
public class BlPayOutQryServiceImpl implements IBlPayOutQryService {
	/**
	 * 根据门诊记账ID获取付款信息
	 * 
	 * (使用方：就诊领域使用)
	 * @param oepCgId 门诊记账ID
	 * @return 付款信息集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public BlPayPmDTO[] getOpRegPayDetailBP(String cgId)  throws BizException{
		GetOpRegPayDetailBP getPayDetailBP = new GetOpRegPayDetailBP();
		return getPayDetailBP.exec(cgId);
	}
	
	/**
	 * 查询患者卡交费押金
	 * 
	 * @param patcardIds 患者卡id
	 * @param euCardCgMod 卡计费类型
	 * @return
	 * @throws BizException
	 * @author ly 2018/05/21
	 */
	@Override
	public BlSpclPatAmtDTO[] getPatCardAmt(String[] patcardIds,String euCardCgMod) throws BizException{
		GetPatCardAmtBP bp = new GetPatCardAmtBP();
		return bp.exec(patcardIds, euCardCgMod);
	}

	/**
	 * 欠费判断接口
	 * 
	 * @param codeEnTp
	 * @param entId
	 * @param patId
	 * @param patCaTpId
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrePaidAccAmtDTO getAccJudge(BlPrepayCondDTO condDto) throws BizException {
		GetAccJudgeBP bp = new GetAccJudgeBP();
		return bp.exec(condDto);
	}
	
	/**
	 *
	 * 欠费控制是否可开立医嘱（费用）接口
	 * @author zhang.hw
	 * @date 2019年10月9日
	 * @param list
	 * @return
	 * @throws BizException
	 */
	@Override
	public ArrearsControlOrderOutParamDTO[] getArrearsControl(ArrearsControlOrderInParamDTO[] list)
			throws BizException {
		GetArrearsControlBP bp = new GetArrearsControlBP();
		return bp.exec(list);
	}

	/**
	 * 批量获取欠费数据
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrePaidAccAmtDTO[] getAccJugeIpByentIds(String[] entIds) throws BizException {
		GetAccJugeIpByentIdsBP bp = new GetAccJugeIpByentIdsBP();
		return bp.exec(entIds);
	}
	
	/**
	 * 急诊欠费判断接口
	 * 
	 * @param codeEnTp
	 * @param entId
	 * @param patId
	 * @param patCaTpId
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrePaidAccAmtDTO getETAccJudge(String codeEnTp, String entId, String patId, String patCaTpId)
			throws BizException {
		GetAccJudgeBP bp = new GetAccJudgeBP();
		return bp.getETAccJudge(codeEnTp, entId, patId, patCaTpId);
	}
	
	/**
	 * 获取预交金余额
	 * @param condDtos 检索条件
	 * @return 预交金余额信息
	 * @throws BizException
	 * @author ly 2019/03/01
	 */
	@Override
	public BlPrepayAmountDTO[] getPrepayAmountInfo(BlPrepayCondDTO[] condDtos) throws BizException{
		GetPrepayAmountInfoBP bp = new GetPrepayAmountInfoBP();
		return bp.exec(condDtos);
	}
	
	/**
	 * 查询本次住院结算的预交金信息
	 * @param stId
	 * @return
	 * @throws BizException
	 * @author wq.li 2019-4-28
	 */
	@Override
	public BlPrePayPatDO[] getPrepayInfoByIpStId(String stId) throws BizException {
		GetPrepayInfoByIpStIdBP bp=new GetPrepayInfoByIpStIdBP();
		return bp.exec(stId);
	}
	
	/**
	 * 得到急诊留观患者的账户信息
	 * @param codeEnTp
	 * @param entId
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public ETAccountDTO getETAccount(String codeEnTp,String entId) throws BizException 
	{
		GetAccJudgeBP bp = new GetAccJudgeBP();
		return bp.getETAccount(codeEnTp, entId);
}
	
	
	/**
	 * 得到许多急诊留观患者的账户信息(批量查询)
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public Map<String,ETAccountDTO> getETAccountByEnts(PatiVisitDO[] entDos) throws BizException{
		GetAccJudgeBP bp = new GetAccJudgeBP();
		return bp.getETAccountByEnts(entDos);
	}
}
