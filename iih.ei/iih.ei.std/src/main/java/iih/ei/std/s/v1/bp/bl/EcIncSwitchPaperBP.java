package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.i.IBlIncCmdService;
import iih.ei.std.d.v1.bl.ecincswitchpaper.d.EcIncSwitchPaperDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 电子发票换开回写IIH数据
 * @author ly 2020/01/08
 *
 */
public class EcIncSwitchPaperBP {
	
	/**
	 * 电子发票换开回写IIH数据
	 * @param param
	 * @throws BizException
	 */
	public void exec(EcIncSwitchPaperDTO param) throws BizException{
		
		this.validate(param);
		
		IBlIncCmdService incService = ServiceFinder.find(IBlIncCmdService.class);
		
		// 查询门诊发票数据
		BlIncOepDO incOepDO = this.getOpIncData(param.getEcinc_code(), param.getEcincno());
		if(incOepDO != null){
			
			BlEcSwithPaperInDTO inDto = new BlEcSwithPaperInDTO();
			inDto.setId_st(incOepDO.getId_stoep());
			inDto.setPinc_code(param.getPinc_code());
			inDto.setPincno(param.getPincno());
			
			incService.ecIncWriteBackPaperOp(inDto);
			return;
		}
		
		// 查询住院发票数据
		BlIncIpDO incIpDO = this.getIpIncData(param.getEcinc_code(), param.getEcincno());
		if(incIpDO != null){
			//TODO
			return;
		}
		
		throw new BizException(String.format("未查询到电子发票数据,电子发票代码%s 电子发票号%s", param.getEcinc_code(), param.getEcincno()));
	}
	
	/**
	 * 校验入参
	 * @param param
	 * @throws BizException
	 */
	private void validate(EcIncSwitchPaperDTO param) throws BizException{
		
		if(param == null){
			throw new BizException("入参为空");
		}
		
		if(StringUtil.isEmpty(param.getEcinc_code())){
			throw new BizException("入参电子票据代码为空");
		}
		
		if(StringUtil.isEmpty(param.getEcincno())){
			throw new BizException("入参电票票据号为空");		
		}
		
		if(StringUtil.isEmpty(param.getPinc_code())){
			throw new BizException("入参纸质票据代码为空");
		}
		
		if(StringUtil.isEmpty(param.getPincno())){
			throw new BizException("入参纸质票号为空");
		}
	}

	/**
	 * 查询门诊票据信息
	 * @param ecIncCode
	 * @param ecIncNo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlIncOepDO getOpIncData(String ecIncCode,String ecIncNo) throws BizException{
		
		String sql= "select id_incoep,id_stoep from bl_inc_oep where ec_inc_code = ? and incno = ? ";
		SqlParam param = new SqlParam();
		param.addParam(ecIncCode);
		param.addParam(ecIncNo);
	
		DAFacade daf = new DAFacade();
		List<BlIncOepDO> list = (List<BlIncOepDO>)daf.execQuery(sql, param, new BeanListHandler(BlIncOepDO.class));
		if(ListUtil.isEmpty(list))
			return null;
		
		return list.get(0);
	}
	
	/**
	 * 查询门诊票据信息
	 * @param ecIncCode
	 * @param ecIncNo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlIncIpDO getIpIncData(String ecIncCode,String ecIncNo) throws BizException{
		
		String sql= "select id_incip,id_stip from bl_inc_ip where ec_inc_code = ? and incno = ? ";
		SqlParam param = new SqlParam();
		param.addParam(ecIncCode);
		param.addParam(ecIncNo);
	
		DAFacade daf = new DAFacade();
		List<BlIncIpDO> list = (List<BlIncIpDO>)daf.execQuery(sql, param, new BeanListHandler(BlIncIpDO.class));
		if(ListUtil.isEmpty(list))
			return null;
		
		return list.get(0);
	}
}
