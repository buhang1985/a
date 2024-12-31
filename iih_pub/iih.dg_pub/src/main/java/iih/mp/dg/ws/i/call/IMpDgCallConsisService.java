package iih.mp.dg.ws.i.call;

import iih.mp.dg.dto.opdgdisp.d.PresDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * Consis系统WebService接口
 * 
 * @author dj.zhang
 * @data 2018年7月12日下午4:36:08
 * 
 */
public interface IMpDgCallConsisService {

	/**
	 * 根据处方信息获取窗口号
	 * 
	 * @param condition
	 * @return
	 */
	public abstract String getDrugWindowNo(String[] presIds, String depwh, String Code_encard);

	/**
	 * 根据处方发药或者发药完成
	 * 
	 * @param prescs
	 * @param lightOff
	 * @return
	 * @throws BizException
	 */
	public abstract String prescDisp(PresDTO[] prescs, FBoolean lightOff) throws BizException;

	/**
	 * 药品字典数据
	 * 
	 * @return
	 */
	public abstract String dgDicData();

	/**
	 * 药房药品货位数据
	 * 
	 * @return
	 */
	public abstract String pharmDgLocDate();

	/**
	 * 医院科室基本数据
	 * 
	 * @return
	 */
	public abstract String hosDepartBaseDate();

	/**
	 * 发药窗口基本数据
	 * 
	 * @return
	 */
	public abstract String dispDgWinBaseDate();

	/**
	 * 药师基本信息数据（药房药师）
	 * 
	 * @return
	 */
	public abstract String pharmacBaseDate();
}
