package iih.bl.inc.s;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.dto.incprint.d.BlIncPrintInfoDTO;
import iih.bl.inc.dto.incprint.d.BlIncPrintInfoItemDTO;
import iih.bl.inc.i.IBlIncOutQryService;
import iih.bl.inc.s.bp.IncItmBP;
import iih.bl.inc.s.bp.PrintIncBP;
import iih.bl.inc.s.bp.opinc.GetIncInfoByEntIdBP;
import iih.bl.inc.s.bp.opinc.GetIncInfoByStIdBP;
import iih.bl.inc.s.bp.opinc.GetIncItmInfoBP;
import iih.bl.inc.s.bp.opinc.GetNotPrintedIncInfoBP;
import iih.bl.inc.s.bp.opinc.GetPatLastOpIncInfoBP;
import iih.bl.inc.s.bp.opinc.GetPatOpRegIncInfoBP;
import iih.bl.inc.s.ep.IncIssEP;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 票据对外查询服务
 * @author yankan
 * @since 2017-06-26
 *
 */
@Service(serviceInterfaces={IBlIncOutQryService.class}, binding=Binding.JSONRPC)
public class BlIncOutQryServiceImpl implements IBlIncOutQryService{
	
	/**
	 * 获取患者上次门诊发票信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/04
	 */
	@Override
	public RePrintInvoiceInfoDTO[] getPatLastOpIncInfo(String patId) throws BizException {
		GetPatLastOpIncInfoBP bp = new GetPatLastOpIncInfoBP();
		return bp.exec(patId);
	}
	
	/**
	 * 获取患者门诊挂号发票信息
	 * @param patId 患者id
	 * @param incno
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/04
	 */
	@Override
	public RePrintInvoiceInfoDTO getPatOpRegIncInfo(String patId,String incno) throws BizException{
		GetPatOpRegIncInfoBP bp = new GetPatOpRegIncInfoBP();
		return bp.exec(patId, incno);
	}
	
	/**
	 * 获取票据包指定数量的可用发票号
	 * 从当前可用号开始
	 * @param incIssId 票据包id
	 * @param num 数量
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/12
	 */
	@Override
	public String[] getAvailableIncno(String incIssId, int num) throws BizException{
		IncIssEP bp = new IncIssEP();
		return bp.getAvailableIncno(incIssId, num);
	}
	
	/**
	 * 获取门诊未打印发票
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public BlIncPrintInfoDTO[] getNotPrintedIncInfo(String patId)throws BizException{
		GetNotPrintedIncInfoBP bp=new GetNotPrintedIncInfoBP();
		return bp.exec(patId);
	}
	/**
	 * 获取发票对应的服务明细
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	public BlIncPrintInfoItemDTO[] getIncItmInfo(String incId) throws BizException{
		GetIncItmInfoBP bp = new GetIncItmInfoBP();
		return bp.exec(incId);
	}
	/**
	 * 获取门诊已有发票信息（不重新生成发票号）
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	
	@Override
	public BlIncItmVsTypeDTO[] getOpIncInfoByStId(String stId) throws BizException{
		GetIncInfoByStIdBP bp=new GetIncInfoByStIdBP();
		return bp.exec(stId);
	}
	/**
	 * 获取根据就诊id已有发票信息（不重新生成发票号）
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author zhangxin 2019年4月30日
	 */
	@Override
	public BlIncItmVsTypeDTO[] getOpIncInfoByEntId(String entId) throws BizException {
		GetIncInfoByEntIdBP bp = new GetIncInfoByEntIdBP();
		return bp.exec(entId);
	}
	

	/**
	 * 获取发票打印信息
	 * @param stId
	 * @return
	 * @throws BizException
	 * @date 2018年8月14日
	 * @author wq.li
	 */
	
	@Override
	public BlStIpPayInvoceInfoDTO GetIncIPInfo(String stId) throws BizException {
		PrintIncBP bp =new PrintIncBP();
		return bp.exec(stId);
	}

	@Override
	public BlStReFundBillDTO[] getIncItm(String[] incOepIds) throws BizException {
		IncItmBP bp = new IncItmBP();
		return bp.exec(incOepIds);
	}
}
