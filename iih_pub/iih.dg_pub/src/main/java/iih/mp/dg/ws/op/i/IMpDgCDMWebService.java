package iih.mp.dg.ws.op.i;

/**
 * 药品执行_门诊摆药机WebService
 * 
 * @author hao_wu 2018-11-20
 *
 */
public interface IMpDgCDMWebService {

	/**
	 * 更新摆药信息</br>
	 * 摆药机在完成摆药后回写摆药人和摆药时间
	 * 
	 * @param paramDtos
	 * @return
	 */
	public abstract String updateCollDrugInfo(String param);
}
