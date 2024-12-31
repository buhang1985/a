package iih.mp.dg.ws.op.i;

import iih.mp.dg.ws.op.d.BeginCollDrugParamDTO;
import iih.mp.dg.ws.op.d.BeginCollDrugResultDTO;
import iih.mp.dg.ws.op.d.BeginDispDrugParamDTO;
import iih.mp.dg.ws.op.d.BeginDispDrugResultDTO;
import iih.mp.dg.ws.op.d.DispDrugFinishParamDTO;
import iih.mp.dg.ws.op.d.DispDrugFinishResultDTO;
import iih.mp.dg.ws.op.d.GetWinNoParamDTO;
import iih.mp.dg.ws.op.d.GetWinNoResultDTO;

/**
 * 药品执行_调用门诊摆药机WebService
 * 
 * @author hao_wu 2018-11-20
 *
 */
public interface IMpDgCallCDMWebService {
	/**
	 * 开始配药</br>
	 * 摆药机应在此时开始配药</br>
	 * 预配窗口打印配药单
	 * 
	 * @param paramDto
	 * @return
	 */
	public abstract BeginCollDrugResultDTO[] beginCollDrug(BeginCollDrugParamDTO paramDto);

	/**
	 * 获取窗口号
	 * 
	 * @param paramDto
	 * @return
	 */
	public abstract GetWinNoResultDTO getWinNo(GetWinNoParamDTO paramDto);

	/**
	 * 开始发药</br>
	 * 摆药机应在此时亮灯
	 * 
	 * @param paramDto
	 * @return
	 */
	public abstract BeginDispDrugResultDTO[] beginDispDrug(BeginDispDrugParamDTO paramDto);

	/**
	 * 发药完成</br>
	 * 摆药机应在此时熄灯
	 * 
	 * @param paramDto
	 * @return
	 */
	public abstract DispDrugFinishResultDTO[] dispDrugFinish(DispDrugFinishParamDTO paramDto);
}
