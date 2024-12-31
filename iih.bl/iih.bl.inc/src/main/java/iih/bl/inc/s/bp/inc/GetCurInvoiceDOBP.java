package iih.bl.inc.s.bp.inc;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoInDTO;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoOutDTO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncQryService;
import iih.bl.inc.s.ep.IncIssEP;
import iih.bl.params.BlParams;
import iih.bl.params.BlParamsAnalysisUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取当前票据DO
 * @author ly 2018/07/04
 *
 */
public class GetCurInvoiceDOBP {

	/**
	 * 获取当前票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return
	 * @throws BizException
	 */
	public BlIncIssDO exec(String empId, String hostId, String inccaId) throws BizException {
		
		if(StringUtil.isEmpty(empId) && StringUtil.isEmpty(hostId)){
			throw new ArgumentNullException("获取当前票据号","人员或PCid");
		}
		
		if(StringUtil.isEmpty(inccaId)){
			throw new ArgumentNullException("获取当前票据号","票据分类id");
		}
		
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		if(FBoolean.TRUE.equals(fgEcInc)){
			
			BlIncIssDO issDO = new BlIncIssDO();
			if(FBoolean.TRUE.equals(BlParams.BLINC0031())){
				IBlIncQryService qryService = ServiceFinder.find(IBlIncQryService.class);
				BlEcIncCurPIncnoInDTO inDto = new BlEcIncCurPIncnoInDTO();
				BlEcIncCurPIncnoOutDTO outDto = qryService.getPaperIncCurNO(inDto);
				
				issDO.setIncno_cur(outDto.getPincno());
			}else{
				issDO.setIncno_cur("动态电子票号");
			}
			return issDO;
		}else{
			IncIssEP ep = new IncIssEP();
			BlIncIssDO incIss = ep.findUsingInc(empId, hostId, inccaId);
			return incIss;
		}
	}
	
	/**
	 * 获取当前窗口类型对应票据号
	 * @description:
	 * @author:hanjq  2020年6月23日
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @param sdPttp
	 * @return
	 * @throws BizException 
	 */
	public BlIncIssDO exec(String empId, String hostId, String inccaId, String sdPttp) throws BizException {
		if(StringUtil.isEmpty(empId) && StringUtil.isEmpty(hostId)){
			throw new ArgumentNullException("获取当前票据号","人员或PCid");
		}
		
		if(StringUtil.isEmpty(inccaId)){
			throw new ArgumentNullException("获取当前票据号","票据分类id");
		}
		
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		if(FBoolean.TRUE.equals(fgEcInc)){
			
			BlIncIssDO issDO = new BlIncIssDO();
			if(FBoolean.TRUE.equals(BlParams.BLINC0031())){
				IBlIncQryService qryService = ServiceFinder.find(IBlIncQryService.class);
				BlEcIncCurPIncnoInDTO inDto = new BlEcIncCurPIncnoInDTO();
				BlEcIncCurPIncnoOutDTO outDto = qryService.getPaperIncCurNO(inDto);
				
				issDO.setIncno_cur(outDto.getPincno());
			}else{
				issDO.setIncno_cur("动态电子票号");
			}
			return issDO;
		}else{
			IncIssEP ep = new IncIssEP();
			BlIncIssDO incIss = ep.findUsingInc(empId, hostId, inccaId,sdPttp);
			if(StringUtils.isBlank(sdPttp)){
				incIss = ep.findUsingInc(empId, hostId, inccaId);
			}else{
				incIss = ep.findUsingInc(empId, hostId, inccaId,sdPttp);
			}			
			return incIss;
		}
	}
}
