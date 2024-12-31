package iih.ci.test.utils;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 频次工具类
 * @author wangqingzhu
 *
 */
public class FreqInfoUtils {

	public static final String FreqCacheKey = "BD_FREQ_DEF_CACHEKEY";
	private static FreqInfoUtils ins = new FreqInfoUtils();;
	private FreqInfoUtils(){}
	
	public static FreqDefDO GetFreqDefDO(String id_freq) throws BizException{
			FreqdefAggDO	freqdefAggDO = ServiceFinder.find(IFreqdefRService.class).findById(id_freq);
		return freqdefAggDO.getParentDO();
	}
	
	public static String GetNameFreq(String id_freq) throws BizException{
		
		return GetFreqDefDO(id_freq).getName();
	}
	
	public static String GetSDFreq(String id_freq) throws BizException{
		
		return GetFreqDefDO(id_freq).getCode();
	}
	
	public static int GetFreqct(String id_freq) throws BizException{
		
		return GetFreqDefDO(id_freq).getFreqct();
	}
	
	public static FBoolean GetFgLong(String id_freq) throws BizException{
		
		return GetFreqDefDO(id_freq).getFg_long();
	} 

	public static String GetSdFrequnitct(String id_freq) throws BizException {

		return GetFreqDefDO(id_freq).getSd_frequnitct();
	}
	
	
	public static String getIdFrequnitct(String id_freq) throws BizException{
		return GetFreqDefDO(id_freq).getId_frequnitct();
	}


	
	
}
