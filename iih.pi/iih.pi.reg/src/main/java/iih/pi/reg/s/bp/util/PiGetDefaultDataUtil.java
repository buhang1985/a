package iih.pi.reg.s.bp.util;

import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.i.IPiPatConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;

/**
 * 患者相关默认值取得工具类
 * @author ly 2017/10/14
 *
 */
public class PiGetDefaultDataUtil {

	/**
	 * 获取中国
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static CountryZoneDO getChina() throws BizException{
		
		String whereSql = " upper(a0.code) = '" + IPiPatConst.CHINA_CODE + "' ";
		ICountryzoneRService countrySrv = ServiceFinder.find(ICountryzoneRService.class);
		CountryZoneDO[] czones = countrySrv.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(czones))
			return null;
			
		return czones[0];
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
	
}
