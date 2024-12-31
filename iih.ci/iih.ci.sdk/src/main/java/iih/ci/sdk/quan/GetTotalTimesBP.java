package iih.ci.sdk.quan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.sdk.cache.BDFreqInfoCache;
import iih.ci.sdk.cache.BDFreqTimeInfoCache;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;

/**
 * 计算总次数的类入口
 * @author 张万青
 *
 */
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
public class GetTotalTimesBP {
	/**
	 * 草药：需要传入参数数据（服务类型sd_srvtp,代煎付数orders）其余参数可不传<BR/>
	 * 草药代煎费：需要传入参数数据 服务来源Eu_sourcemd，代煎付数Orders_boil 其余参数可不传<BR/>
	 * 备用医嘱：需要传入参数数据    备用医嘱标识 Fg_pmor 其余参数可不传<BR/>
	 * 频次类型为一次，总次数1<BR/>
	 * 需要通过计算获得总次数 传入参数：频次id_freq,使用天数use_day<BR/>
	 * 用法关联费用：总次数  =  在院执行次数。<BR/>
	 * 标本采集关联费用：总次数 =临床医嘱总次数。<BR/>
	 * 标本容器耗材费：总次数 = 临床医嘱总次数<BR/>
	 * 关联策略生成费用：总次数 = 1。
	 * @param QuantumParamDTO
	 * @return
	 * @throws BizException 
	 */
	
	// 频次下执行时刻
	private IFreqTimeDORService ifreqTimeDORService;

	public GetTotalTimesBP() {
		ifreqTimeDORService = CiOrdAppUtils.getFreqTimeDORService();
	}
	public Integer getTotalTimesBP(QuantumParamDTO param) throws BizException{
		if(IBdSrvDictCodeConst.SD_TOTALOPENMODE_TOTALNUM.equals(param.getSd_totalopenmode()) && FBoolean.TRUE.equals(param.getIsmulexec())){
			return param.getTimes_cur();
		}else{
			if (validate(param).booleanValue()) {
				// 草药类药品,总次数=医嘱付数
				if (!ObjectUtils.isEmpty(param.getSd_srvtp())
						&& param.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					return param.getOrders();
				}
				// 非草药类 ,通过计算获得
				else {
					return getTotalTimes(param.getId_freq(), param.getUse_day());
				}

			}
		}
		
		return 0;
	}
	/**
	 * 通过频次和使用天数计算获得总次数
	 * @param id_freq
	 * @param use_day
	 * @return
	 * @throws BizException
	 */
	public Integer getTotalTimes(String id_freq, Integer use_day) throws BizException {
		if (ObjectUtils.isEmpty(id_freq)) {
			return 0;
		}
		//FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		FreqDefDO freqParent = BDFreqInfoCache.GetFreqInfo(id_freq);// freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = BDFreqTimeInfoCache.GetFreqTimeInfos(id_freq);// freqdefAgg.getFreqTimeDO();

		if (freqParent == null) {
			return 0;
		}
		String sd_frequnitct = freqParent.getSd_frequnitct();// 频次周期类型编码
		Integer freqct = freqParent.getFreqct();// 频次周期下次数
		Integer frequnitct = freqParent.getFrequnitct();// 频次周期数

		Integer totalTimes = 0;
		// 备用医嘱,总次数为=1
		if (ObjectUtils.isTrue(freqParent.getFg_prnor())) {
			totalTimes = 1;
		}else{
			switch (sd_frequnitct) {
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE:// 频次周期类型为一次:总次数=1
				totalTimes = 1;
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// 频次周期类型为小时:总次数 =使用天数*24/周期数（除不尽时，直接取整数，不做进位处理）
				if (use_day != null) { 
					totalTimes = use_day * 24 / frequnitct;
				}
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// 频次周期类型为天:
				//totalTimes  = GetFreqDay(freqTimes,freqct,use_day);
				if (use_day != null) { 
					totalTimes = use_day / frequnitct * freqct;// 总次数=（使用天数 /周期数）*周期下次数  （使用天数 /周期数=整数）
					Integer remainder = use_day % frequnitct;
					if (remainder != 0) {
						// 总次数=（除法后整数部分*周期下次数）+（取小于等于除法后余数的频次下执行时刻数量）（使用天数 /周期数!=整数）
						for (FreqTimeDO freqtime : freqTimes) {
							Integer execDay = freqtime.getDay();
							if (!ObjectUtils.isEmpty(execDay) && execDay <= remainder) {
								totalTimes++;
							}
						}
					}
				}
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK:// 频次周期类型为周:
				if (use_day != null) { 
					totalTimes = getTimesCurOfWeek(id_freq,use_day,freqct);
				}
				break;
			}
		}

		return totalTimes;
	}
	
	private int GetFreqDay(FreqTimeDO[] freqTimes,Integer freqct, int use_day){
		 int times = 0;
		 FDateTime fdateTime = CiOrdAppUtils.getServerDateTime();
	      FTime fTime = fdateTime.getUFTime();
	      if(use_day==1){
    	    for(FreqTimeDO timesDO: freqTimes){
  	    	  if (timesDO.getTime_mp().after(fTime)) {
  					times++;
  				}
  	         }
	      }else{
	    	int temp = (use_day-1)* freqct;
	    	 for(FreqTimeDO timesDO: freqTimes){
	    		 if (timesDO.getTime_mp().after(fTime)) {
	  					times++;
	  				}
	  	         }
	    	times += temp;
	      }
	  
		 return times;
	}   
	
	
	/**
	 * 按周计算总次数
	 * 
	 * @param days
	 * @param freqct
	 * @return
	 * @throws BizException
	 */
	private int getTimesCurOfWeek(String id_freq, int days, int freqct) throws BizException {
        int times = 0;
		if (days % 7 == 0) {
			times = freqct * days / 7;
		}else{
			 times = this.GetResidualFrequency2(id_freq,days, freqct);
		}
		return times;
	}
	/**
	 * 
	 * @param id_freq
	 * @param days
	 * @return
	 */
	private int GetResidualFrequency2(String id_freq,int days,int freqct)throws BizException{
		int times = 0;
		int tempdays =0;
		// 获取服务器时间
		FDateTime fdateTime = CiOrdAppUtils.getServerDateTime();
		int dayOfWeek = fdateTime.getDate().getWeek();
		FTime fTime = fdateTime.getUFTime();

		
		FreqTimeDO[] freqTimeDOs = BDFreqTimeInfoCache.GetFreqTimeInfos(id_freq);// ifreqTimeDORService.find(whereStr, "sortno", FBoolean.FALSE);
		if (freqTimeDOs == null || freqTimeDOs.length == 0) {
			throw new BizException("未获取到频次id为" + id_freq + "下的执行时刻");
		}
		  tempdays =days%7;
		  times = GetDays(freqTimeDOs,dayOfWeek,tempdays,fTime);  
	      times += freqct * (days / 7);
		return times;
	}
	/**
	 * 不能整除7天的次数
	 * @param freqTimeDOs
	 * @param days
	 * @param fdateTime
	 * @return
	 */
	private int GetDays(FreqTimeDO[] freqTimeDOs,int dayOfWeek,int days,FTime fTime){
		int times = 0;
		int num =days;
		int winno =0;
		Map<Integer ,FreqTimeDO> map = getFreqTiems(freqTimeDOs);
		for(int i =0; i<num;i++){
			winno = dayOfWeek +i;
			if(winno > 6){
				 winno =winno -7;
			}
			FreqTimeDO TimesDO = map.get(winno);
			if(i == 0 && TimesDO != null){
			  if (TimesDO.getTime_mp().after(fTime)){
				   times++; 
				}
			}else{
				if(TimesDO != null){
					times++;
				}
			}
		  }
		
		return times;
	}
	
	private Map<Integer ,FreqTimeDO> getFreqTiems(FreqTimeDO[] freqTimeDOs){
		Map<Integer ,FreqTimeDO> map = new HashMap();
		for(FreqTimeDO timesDO: freqTimeDOs){
			map.put(timesDO.getWdno(), timesDO);
		}
		return map;
	}
	

	/**
	 * 获取当执行频次下剩余的执行次数
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */ 
	private int getResidualFrequency(String id_freq,int days) throws BizException {

		// 获取服务器时间
		FDateTime fdateTime = CiOrdAppUtils.getServerDateTime();
		int dayOfWeek = fdateTime.getDate().getWeek();
		FTime fTime = fdateTime.getUFTime();

		String whereStr = "id_freq = '" + id_freq + "'";
		FreqTimeDO[] freqTimeDOs = ifreqTimeDORService.find(whereStr, "sortno", FBoolean.FALSE);
		if (freqTimeDOs == null || freqTimeDOs.length == 0) {
			throw new BizException("未获取到频次id为" + id_freq + "下的执行时刻");
		}
		 if(days ==1){
			return OneDays(dayOfWeek,freqTimeDOs,fTime);	
			}  
        if(days >7){
          days =days%7;
        }
		int times = freqTimeDOs.length;
		for (FreqTimeDO freqTimeDO : freqTimeDOs){
			if (dayOfWeek > freqTimeDO.getWdno()){
				times--;
				continue;
			}
			if (fTime.after(freqTimeDO.getTime_mp())) {
				times--;
				continue;
			}

			break;
		}
		times +=DaysTime(dayOfWeek,days,freqTimeDOs);
		return times;
	}
	
	private int OneDays(int dayOfWeek,FreqTimeDO[] freqTimeDOs,FTime fTime ){
		int times =0;
		for(FreqTimeDO freqTimeDO : freqTimeDOs){
			if(dayOfWeek == freqTimeDO.getWdno()){
				if (freqTimeDO.getTime_mp().after(fTime)) {
					times++;
				}
			}
		}
		return times;
	}
	
	private int DaysTime(int dayOfWeek,int days,FreqTimeDO[] freqTimeDOs ){
		int tiems =0;
		int  daysnum = (dayOfWeek+days);
		if(daysnum>7){
			 daysnum = daysnum%7;
			if(daysnum > 0 && freqTimeDOs.length>0){
				for(FreqTimeDO freqTimeDO : freqTimeDOs){
					if(daysnum > freqTimeDO.getWdno()){
						tiems++;
					}
				}
			}
		}
		return tiems;
	}
	
	/**
	 * 药品领量天数计算，只有药品非草药类才需要计算
	 * 
	 * @param quan_cur
	 *            总量
	 * @param quan_medu
	 *            剂量
	 * @param factor
	 *            基本包装单位和总量单位间的换算系数
	 * @param factor_mb
	 *            医基换算系数
	 * @param id_freq
	 *            频次
	 * @return
	 * @throws BizException
	 */
	public Integer getDaysAvalidate(String sd_mupakgu, FDouble quan_cur, FDouble quan_medu, FDouble factor, FDouble factor_mb, String id_freq) 
			throws BizException {
		if (ObjectUtils.isEmpty(id_freq) || ObjectUtils.isEmpty(quan_cur) || ObjectUtils.isEmpty(quan_medu)
				|| ObjectUtils.isEmpty(factor_mb) || ObjectUtils.isEmpty(factor)) {
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdAppUtils.getFreqdefRService().findById(id_freq);
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		
		String sd_frequnitct = freqParent.getSd_frequnitct();// 频次周期类型编码
		Integer freqct = freqParent.getFreqct();// 频次周期下次数
		Integer frequnitct = freqParent.getFrequnitct();// 频次周期数
        
		Integer totalTimes = 0;
		//Integer  times =0;
		// 走舍位//考虑取整模式
		FDouble  times = this.calTimes(quan_cur, sd_mupakgu, quan_medu, factor_mb, factor);
		
		//频次的备用标志位true，走一日一次的逻辑
		if(!ObjectUtils.isEmpty(freqParent.getFg_prnor()) && freqParent.getFg_prnor().booleanValue()){
			totalTimes = times.intValue();
		}else{
			switch(sd_frequnitct){
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE:// 频次周期类型为一次（once），走一日一次的逻辑
				totalTimes =  times.intValue();
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// 频次周期类型为小时:领量天数 =总次数/频次下次数*周期数/24
				totalTimes = (times.div(new FDouble(freqct)).multiply(new FDouble(frequnitct)).mod(new FDouble(24))).intValue() == 0 ?
						(times.div(new FDouble(freqct)).multiply(new FDouble(frequnitct)).div(new FDouble(24))).intValue(): ((times.div(new FDouble(freqct)).multiply(new FDouble(frequnitct)).div(new FDouble(24))).intValue()  + 1);
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// 频次周期类型为天:
				totalTimes = times.intValue();
				Integer remainder_day = times.mod(new FDouble(freqct)).intValue();
				// 使用天数与周期数能整除
				if (remainder_day == 0 || frequnitct == 1) {
					// 领量天数 =总次数/频次下次数*周期数
					totalTimes = (times.div(new FDouble(freqct)).multiply(new FDouble(frequnitct))).intValue();
				}
				// 不能整除
				else {
					int count = 0;
					// 按照Day字段 升序排序
					// CiOrdUtils.SortFreqTimeDO(freqTimes, "Day");
					Arrays.sort(freqTimes, new Comparator<FreqTimeDO>() {

						@Override
						public int compare(FreqTimeDO o1, FreqTimeDO o2) {
							// TODO Auto-generated method stub
							if(o1.getDay().equals(o2.getDay())) {
								return 0;
							}
							return o1.getDay() > o2.getDay()? -1:1;
						}} );
					for (FreqTimeDO freqtime : freqTimes) {
						if (++count == remainder_day) {
							totalTimes = times.div(new FDouble(freqct)).multiply(new FDouble(frequnitct)).intValue()  + freqtime.getDay();
						}
					}
				}
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK:// 频次周期类型为周:
				totalTimes = times.intValue();
				Integer remainder_week = times.mod(new FDouble(freqct)).intValue();
				// 使用天数与周期数能整除
				if (remainder_week == 0) {
					totalTimes = (times.div(new FDouble(freqct)).multiply(new FDouble(7))).intValue();
				}
				// 不能整除
				else {
					int count = 0;
					// 排序
					// CiOrdUtils.SortFreqTimeDO(freqTimes, "Week");
					Arrays.sort(freqTimes, new Comparator<FreqTimeDO>() {

						@Override
						public int compare(FreqTimeDO o1, FreqTimeDO o2) {
							// TODO Auto-generated method stub
							if(o1.getWeek().equals(o2.getWeek())) {
								return 0;
							}
							return o1.getWeek() > o2.getWeek()? -1:1;
						}} );
					for (FreqTimeDO freqtime : freqTimes) {
						if (++count == remainder_week) {
							totalTimes =(times.div(new FDouble(freqct)).multiply(new FDouble(7))).intValue() + freqtime.getWeek();
						}
					}
				}
				break;
			}
		}

		return totalTimes;
	}

	/**
	 * 按取整模式
	 * @param quan_cur
	 * @param sd_mupakgu
	 * @param quan_medu
	 * @param factor_mb
	 * @param factor
	 * @return
	 * @throws BizException
	 */
	private FDouble calTimes(FDouble quan_cur, String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor)
			throws BizException {
		if (ObjectUtils.isEmpty(sd_mupakgu) || ObjectUtils.isEmpty(quan_medu) || ObjectUtils.isEmpty(factor_mb)
				|| ObjectUtils.isEmpty(factor))
			return new FDouble(0.0);
		// 按次取整
		if (sd_mupakgu.equals("0")) {
			return quan_cur.div(Math.ceil(quan_medu.div(factor_mb.multiply(factor)).getDouble()));
		}
		// 按批取整或不取整
		else if (sd_mupakgu.equals("1") || sd_mupakgu.equals("4")) {
			return quan_cur.multiply((factor_mb.multiply(factor))).div(quan_medu);
		} else {
			throw new BizException("计算药品领量总次数，取整模式配置错误，无法计算！");
		}
	}
	
	
	/// <summary>
    /// 物品计算的核心算法
    /// </summary>
    /// <param name="sd_mupakgu"></param>
    /// <param name="quan_medu"></param>
    /// <param name="factor_mb"></param>
    /// <param name="factor"></param>
    /// <param name="times"></param>
    /// <returns></returns>
     public FDouble getMMQuantum(String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor, Integer times)throws BizException
     {
    		if ( quan_medu != null){
    			if (factor == FDouble.ZERO_DBL){
    				throw new BizException("总量单位的换算系数为0");
    			}
    			if ( FDouble.ZERO_DBL.equals(quan_medu)) { // 按次取整
    				return new FDouble(Math.ceil((double) (Math
    						.ceil((double) (quan_medu.doubleValue() / factor_mb.doubleValue()))
    						/ factor.doubleValue())) * times);
    			} else if( "1".equals(sd_mupakgu)){ // 按批取整
    				return new FDouble(Math.ceil((double) (quan_medu.doubleValue() / factor_mb.doubleValue() * times
    						/ factor.doubleValue())));
    			}else{// 不取整
    				return new FDouble((double) (quan_medu.doubleValue() / factor_mb.doubleValue() * times
    						/ factor.doubleValue()));
    			}
    		}
    		return FDouble.ZERO_DBL;
	    }
	
	
	
	
	/**
	 * 校验参数
	 * @param param
	 * @return
	 */
	protected FBoolean validate(QuantumParamDTO param) {
		if (ObjectUtils.isEmpty(param))
			return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
}
