package iih.ei.bl.ecinc.bosssoft.v2.s;

import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncPaperCurIncNoBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncPaperReSwitchBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncPaperSwitchBP;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.s.EcIncPaperBaseServiceImpl;
import xap.mw.core.data.BizException;

/**
 * 博思电子发票纸质票据处理
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncPaperServiceImpl extends EcIncPaperBaseServiceImpl{

	private static BossSoftEcIncPaperServiceImpl instance;
	
	static{
		instance = new BossSoftEcIncPaperServiceImpl();
	}
	
	public static BossSoftEcIncPaperServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public EcIncResultDTO<EcIncPaperCurIncNoOutDTO> getCurIncNo(EcIncPaperCurIncNoInDTO dto) throws BizException {
		BossSoftEcIncPaperCurIncNoBP bp = new BossSoftEcIncPaperCurIncNoBP();
		return bp.exec(dto);
	}
	
	@Override
	public EcIncResultDTO<EcIncPaperSwitchOutDTO> swichPaperInc(EcIncPaperSwitchInDTO dto) throws BizException {
		BossSoftEcIncPaperSwitchBP bp = new BossSoftEcIncPaperSwitchBP();
		return bp.exec(dto);
	}
	
	@Override
	public EcIncResultDTO<EcIncPaperReSwitchOutDTO> reSwichPaperInc(EcIncPaperReSwitchInDTO dto) throws BizException {
		BossSoftEcIncPaperReSwitchBP bp = new BossSoftEcIncPaperReSwitchBP();
		return bp.exec(dto);
	}
}
