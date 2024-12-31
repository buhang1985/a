package iih.mp.dg.params.constdef;

/**
 * 药品执行域参数编码常量定义
 * 
 * @author hao_wu
 *
 */
public interface MpDgParamCodeConst {

	/**
	 * 药房分窗口模式
	 */
	public final String MPDGOP0005 = "MPDGOP0005";

	/**
	 * 药品队列过号处理模式
	 */
	public final String MPDGOP0026 = "MPDGOP0026";

	/**
	 * 门诊发药处方有效时间（小时）
	 */
	public final String MPDGOP0034 = "MPDGOP0034";

	/**
	 * 门诊药房窗口摆药模式</br>
	 * 0:人工摆药</br>
	 * 1:摆药机摆药</br>
	 */
	public final String MPDGOP0035 = "MPDGOP0035";

	/**
	 * 获取允许非当前窗口发药模式(只对普通窗口有效 ) 
	 * 1: 提示患者的发药窗口，询问是否继续发药
	 * 0: 提示患者到指定窗口领药
	 */
	public final String MPDGOP0036 = "MPDGOP0036";
	
	/**
	 * 用于门诊药房签到时，慢病处方未缴费情况下，提示的缴费地点。
	 * 例如：兰陵县人民医院为：二楼收费处
	 */
	public final String MPDGOP0037 = "MPDGOP0037";
	
	/**
	 * 调用摆药机熄灯接口时机
	 * 0 每一个处方发药都调用熄灯接口 
	 * 1 所有处方发药完成调用熄灯接口
	 */
	public final String MPDGOP0039 = "MPDGOP0039";
	
	
	/**
	 * 门诊刷卡是否触发摆药完成事件 
	 * true 触发 false 不触发
	 */
	public final String MPDGOP0055 = "MPDGOP0055";
	
	/**
	 * 使用新接口
	 */
	public final String MPDGOP0099="MPDGOP0099";
}
