package iih.ei.std.consis.v1.s;

import iih.ei.std.consis.v1.s.bp.BeginCollDrugBp;
import iih.ei.std.consis.v1.s.bp.BeginDispDrugBp;
import iih.ei.std.consis.v1.s.bp.DispDrugFinishBp;
import iih.ei.std.consis.v1.s.bp.GetWinNoBp;
import iih.mp.dg.ws.op.d.BeginCollDrugParamDTO;
import iih.mp.dg.ws.op.d.BeginCollDrugResultDTO;
import iih.mp.dg.ws.op.d.BeginDispDrugParamDTO;
import iih.mp.dg.ws.op.d.BeginDispDrugResultDTO;
import iih.mp.dg.ws.op.d.DispDrugFinishParamDTO;
import iih.mp.dg.ws.op.d.DispDrugFinishResultDTO;
import iih.mp.dg.ws.op.d.GetWinNoParamDTO;
import iih.mp.dg.ws.op.d.GetWinNoResultDTO;
import iih.mp.dg.ws.op.i.IMpDgCallCDMWebService;

/**
 * 门诊摆药机基础服务
 * 
 * @author hao_wu 2018-11-22
 *
 */
public class CallCDMWebService implements IMpDgCallCDMWebService {

	public BeginCollDrugResultDTO[] beginCollDrug(BeginCollDrugParamDTO paramDto) {
		BeginCollDrugBp bp = new BeginCollDrugBp();
		BeginCollDrugResultDTO[] resultDtos = bp.exec(paramDto);
		return resultDtos;
	}

	public GetWinNoResultDTO getWinNo(GetWinNoParamDTO paramDto) {
		GetWinNoBp bp = new GetWinNoBp();
		GetWinNoResultDTO resultDto = bp.exec(paramDto);
		return resultDto;
	}

	public BeginDispDrugResultDTO[] beginDispDrug(BeginDispDrugParamDTO paramDto) {
		BeginDispDrugBp bp = new BeginDispDrugBp();
		BeginDispDrugResultDTO[] resultDtos = bp.exec(paramDto);
		return resultDtos;
	}

	public DispDrugFinishResultDTO[] dispDrugFinish(DispDrugFinishParamDTO paramDto) {
		DispDrugFinishBp bp = new DispDrugFinishBp();
		DispDrugFinishResultDTO[] resultDtos = bp.exec(paramDto);
		return resultDtos;
	}
}
