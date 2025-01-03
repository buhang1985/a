package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.defaultv.CiOrFgMpInDefaultVSetBP;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单默认值设置操作BP
 */
public class CiEmsDefaultValueSetBP {
	//非药品医嘱首日执行次数是否默认加1顿
	Boolean Times_firdayParam ;
	/**
	 * 医疗单默认值设置
	 * @param emsdto
	 * @throws BizException
	 */
	public void exec(CiEmsDTO emsdto)  throws BizException{
		
		//在院执行标识默认值设置处理逻辑  测试完之后将下属处理逻辑打开
		fgMpInDefaultVSet(emsdto);
		//设置长期QD首日执行次数为0时，将首日执行次数设置为1
		setLongQDFirMpTimes(emsdto);
		//设置天数
		setDays_or(emsdto);
	}
	
	private void setDays_or(CiEmsDTO emsdto) throws BizException {
		
		// 获取SD中频次
				IFreqdefMDORService ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
				FreqDefDO freqDef = ifreqdefMDORService.findById(emsdto.getId_freq());
				if (freqDef == null) {
					throw new BizException("获取频次SD失败！");
				}
				// 频次是一次的医嘱天数设置为1
				if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
					emsdto.setDays_or(1);
		 		} 
		
	}

	/**
	 * 在院执行标识默认值设置处理逻辑
	 * @param emsdto
	 * @throws BizException
	 */
	private void fgMpInDefaultVSet(CiEmsDTO emsdto) throws BizException{
		CiOrFgMpInDefaultVSetBP bp=new CiOrFgMpInDefaultVSetBP();
		bp.exec(emsdto);
	}
	/**
	 * 设置长期医嘱为天类型，首日执行次数为0是，将首日执行次数设置为1
	 * @param agg
	 * @throws BizException
	 */
	private void setLongQDFirMpTimes(CiEmsDTO emsdto) throws BizException {
		Integer quan_firday_mp = emsdto.getTimes_firday_mp();
		FBoolean isLong = emsdto.getFg_long();
		//住院，长期非药品或者长期药品首日执行次数为空，都要重新计算首日执行次数
		if ((isLong != null) && (isLong.booleanValue())
				&&(!emsdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)|| ((quan_firday_mp == null)))
				&&(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(emsdto.getCode_entp())||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(emsdto.getCode_entp()))) {
			String id_freq = emsdto.getId_freq();
			emsdto.setTimes_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(id_freq, emsdto.getDt_begin(),null, emsdto.getSd_srvtp(), emsdto.getCode_entp(), null, null));
		}
		if(!FBoolean.TRUE.equals(isLong)){
			emsdto.setTimes_firday_mp(null);
		}
		//0191963: 药品医嘱，临床赋值逻辑  草药的长临标志
	  if(emsdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
		  emsdto.setFg_long(FBoolean.FALSE);
	  }
	}
	/**
	 * @code 获取参数 CIOR0520  非药品医嘱首日执行次数是否默认加1顿
	 */
	private Boolean getTimes_firdayParam() {
		if(Times_firdayParam != null) 
			return Times_firdayParam;
		
		try {
			Times_firdayParam = ParamUtils.GetOrgParamFBooleanValue(ICiOrdNSysParamConst.SYS_PARAM_CIOR0520).booleanValue();
			return Times_firdayParam;
		} catch (BizException e) {
		    //记录日志
			ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
			logService.log("获取参数 CIOR0520（  非药品医嘱首日执行次数是否默认加1顿 ）失败，默认参数为true", Level.INFO);
			return true;
		}
	}
}
