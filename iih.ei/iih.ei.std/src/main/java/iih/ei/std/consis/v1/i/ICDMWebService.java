package iih.ei.std.consis.v1.i;

/**
 * IIH提供给门诊配药机的WebService</br>
 * 用于门诊配药机系统调用IIH</br>
 * 可选用，如当前接口无法满足对接要求，可客开接口进行对接
 * 
 * @author hao_wu 2018-12-13
 *
 */
public interface ICDMWebService {

	/**
	 * 配药完成</br>
	 * 摆药机在完成配药后调用，完成摆药业务
	 * 
	 * @param paramDtos
	 * @return
	 */
	public abstract String collDrugFinish(String paramXml);

}
