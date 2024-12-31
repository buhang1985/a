package iih.mp.nr.i;

import iih.mp.nr.temperaturechart.d.TemperatureChartDTO;
import iih.mp.nr.temperaturechart.d.VitalsignData;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ITempExtService {

	/**
	 * 体温单视图数据检索
	 * @param qrycont
	 * @return
	 * @throws BizException
	 */
	public abstract VitalsignData GetSignsData(String qrycont) throws BizException;

	/**
	 * 区间获取患者体征信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract TemperatureChartDTO getTemperatureChart(String id_ent, String dt_begin, String dt_end, FBoolean fg_loadoper) throws BizException;

}
