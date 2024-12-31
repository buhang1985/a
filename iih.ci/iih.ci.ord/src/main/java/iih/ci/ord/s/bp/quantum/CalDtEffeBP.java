package iih.ci.ord.s.bp.quantum;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 门诊的开始时间取值逻辑判断 天，小时，间隔标识N,开始时间赋值逻辑：参数走（三种：不变更：变指定时间，默认频次第一次执行时间）
 * 
 * @author zhangwq
 *
 */
public class CalDtEffeBP {
	/**
	 * 门诊开始时间处理模式
	 * @param id_freq
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	public static FDateTime GetDtEffe(String id_freq) throws BizException{
		FDateTime dateTime = CiOrdAppUtils.getServerDateTime();
		//住院的也不处理
		if(CiOrdUtils.isEmpty(id_freq)){
			return dateTime;
		}
		FreqDefDO freqDef = CiOrdAppUtils.getFreqdefMDORService().findById(id_freq);
		String sd_frequnitct = freqDef.getSd_frequnitct(); 
		if(!CiOrdUtils.isEmpty(freqDef.getFg_interval())&&!freqDef.getFg_interval().booleanValue()){
			//周期类型为天或小时时
			if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)
					||sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
				try{
					String dtStr = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdCustomSysParamConst.TL_PARAM_Dt_EFFE_FORMAT);
					if(!CiOrdUtils.isEmpty(dtStr)){
						if(dtStr.contains(CiOrdUtils.SEMICOLON_STR)){
							String dateTimeStr = dtStr.split(CiOrdUtils.SEMICOLON_STR)[1];
							FDateTime time =new FDateTime(dateTime.getBeginDate(),new FTime(dateTimeStr)); 
							return time;
						}else if(dtStr.equals("0")){
							return dateTime;
						}else if(dtStr.equals("2")){
							FreqTimeDO[] freqTimes = CiOrdAppUtils.getFreqTimeDORService().find(String.format("a1.id_freq='%s'", id_freq), "a1.sortno", FBoolean.FALSE);
							return new FDateTime(dateTime.getBeginDate(),freqTimes[0].getTime_mp());
						}
					}
				}catch(Exception ex){
					return dateTime;
				}
				
			}
		}
		return dateTime;
	}
}
