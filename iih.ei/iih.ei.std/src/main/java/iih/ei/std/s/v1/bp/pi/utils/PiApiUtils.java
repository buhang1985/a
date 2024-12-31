package iih.ei.std.s.v1.bp.pi.utils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class PiApiUtils {

    private static String[] CODE_ID_TYPE;//证件号类型范围
	
	static{
		CODE_ID_TYPE = new String[] { IPiDictCodeConst.SD_IDTP_IDENTITY, IPiDictCodeConst.SD_IDTP_JMHKB,
				IPiDictCodeConst.SD_IDTP_HZ,IPiDictCodeConst.SD_IDTP_JGZ,IPiDictCodeConst.SD_IDTP_JSZ,
				IPiDictCodeConst.SD_IDTP_GAJMZ,IPiDictCodeConst.SD_IDTP_TWJMZ,IPiDictCodeConst.SD_IDTP_QTFDZ};
	}
	
	/**
	 * 获取默认患者分类
	 * @return
	 */
	public static PiPatCaDO getDefPatCa() throws BizException {
		
		IPatientcategoryRService caService = ServiceFinder.find(IPatientcategoryRService.class);
		
		PiPatCaDO[] caDos = caService.find("a0.fg_def = 'Y' ", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(caDos)){
			return null;
		}
		
		return caDos[0];
	}
	
	/**
	 * 校验xml入参证件类型
	 * @param value
	 * @return
	 */
	public static Boolean checkIdType(String value) {
		
		for (String str : CODE_ID_TYPE) {
			if(str.equals(value)){
				return true;
			}
		}
		return false;
	}
}
