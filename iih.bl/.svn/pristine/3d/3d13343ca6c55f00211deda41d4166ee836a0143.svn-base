package iih.bl.hp.ep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 频次EP
 * 
 * @author yankan
 * @since 2017-09-15
 *
 */
public class FreqEP {
	private static final List<String> ONCE_FREQ_CODE_LIST = Arrays.asList("ST", "ONCE", "PRN");// 单次执行频次

	/**
	 * 是单次执行频次
	 * 
	 * @param freqCode 频次编码
	 * @return
	 */
	public boolean isOnceFreq(String freqCode) {
		return ONCE_FREQ_CODE_LIST.contains(freqCode.toLowerCase());
	}

	/**
	 * 获取单次频次数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public HashMap<String, String> getOnceFreqMap() throws BizException {
		String[] fields = new String[] { FreqDefDO.ID_FREQ, FreqDefDO.CODE };
		List<FreqDefDO> freqDOLst = (List<FreqDefDO>) new DAFacade().findByAttrValString(FreqDefDO.class, FreqDefDO.SD_FREQUNITCT,
				IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE, fields);
		HashMap<String, String> freqMap = new HashMap<String, String>();
		if (!ListUtil.isEmpty(freqDOLst)) {
			for (FreqDefDO freqDefDO : freqDOLst) {
				freqMap.put(freqDefDO.getId_freq(), freqDefDO.getCode());
			}
		}
		return freqMap;
	}

	/**
	 * 获取医嘱频次
	 * 
	 * @param freqIdList 频次ID集合
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> getFreqMap(List<String> freqIdList) throws BizException {
		Map<String, String> freqMap = new HashMap<String, String>();
		if (ListUtil.isEmpty(freqIdList)) {
			return freqMap;
		}
		String whereStr = SqlUtils.getInSqlByIds(FreqDefDO.ID_FREQ, freqIdList);
		String[] fields = new String[] { FreqDefDO.ID_FREQ, FreqDefDO.CODE };
		DAFacade dafacade = new DAFacade();
		List<FreqDefDO> freqDefDOLst = (List<FreqDefDO>) dafacade.findByCond(FreqDefDO.class, whereStr, fields);
		if (!ListUtil.isEmpty(freqDefDOLst)) {
			for (FreqDefDO freqDefDO : freqDefDOLst) {
				freqMap.put(freqDefDO.getId_freq(), freqDefDO.getCode());
			}
		}
		return freqMap;
	}
}
