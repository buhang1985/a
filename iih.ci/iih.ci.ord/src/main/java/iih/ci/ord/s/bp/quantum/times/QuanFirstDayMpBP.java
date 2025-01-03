package iih.ci.ord.s.bp.quantum.times;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.ci.ord.dto.quanfirstdaymprst.d.QuanFirstDayMpRstDTO;
import iih.ci.ord.params.CiParams;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 计算首日执行次数
 * @author zhangwq
 *
 */
public class QuanFirstDayMpBP {
	public static void main(String[] args){
		FDateTime dt_effe = new FDateTime("2019-12-18 15:38:00");
		FTime times = new FTime("00:00:00");
		FDate fd = dt_effe.getBeginDate().getDateAfter(1);
		FDateTime dtend = new FDateTime(fd.getMillis());
		String str = "";
	}
	public static QuanFirstDayMpRstDTO exec(String id_freq,FDateTime dt_effe,FDateTime dt_end,String sd_srvtp,String code_entp,String sd_orsrcfun,FBoolean fg_pres_outp) throws BizException{
		QuanFirstDayMpRstDTO rst = new QuanFirstDayMpRstDTO();
		if(CiOrdUtils.isEmpty(id_freq)){
			return rst;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		if(freqdefAgg==null){
			throw new BizException("频次不存在，请在频次定义中确认，该频次是否已被删除");
		}
		if(dt_effe == null){
			dt_effe = CiOrdAppUtils.getServerDateTime();
		}
		//首日的结束时间
		FDateTime firstDayEnd= null;
		if(dt_end != null){
			FDate dayLater = dt_effe.getBeginDate().getDateAfter(1);
			if(dt_end.getBeginDate().compareTo(dayLater) >=0){
				firstDayEnd = new FDateTime(dayLater.getMillis());
			}else{
				firstDayEnd = dt_end;
			}
		}else{
			FDate dayLater = dt_effe.getBeginDate().getDateAfter(1);
			firstDayEnd = new FDateTime(dayLater.getMillis());
		}
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		CiOrdUtils.SortFreqTimeDO(freqTimes,FreqTimeDO.SORTNO);
		String sd_frequnitct = freqParent.getSd_frequnitct();//频次sd
		Integer freqct = freqParent.getFreqct();//周期内次数
		Integer frequnitct = freqParent.getFrequnitct();//周期数
		

		//首周期执行次数等于周期内次数
		
		//首周期可执行数
		int firstCycleLiveTimes = 0;
		//首日执行数
		int times = 0;
		List<FDateTime> reList = new ArrayList<FDateTime>();
		String worktime = "";
		
		//频次周期类型为一次，总次数=1
		if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE)||FBoolean.TRUE.equals(freqParent.getFg_interval()))
		{
			return rst;
		}
		//备用医嘱,总次数为=1
		else if(!CiOrdUtils.isEmpty(freqParent.getFg_prnor())&&freqParent.getFg_prnor().booleanValue()){
			return rst;
		}
		//周期类型为小时
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)){
			// 涉及到隔日频次，执行时刻点必须从头开始计算
			FDate dt_date = new FDate(dt_effe.getDate().toLocalString());
			for (FreqTimeDO time : freqTimes) {
				FDateTime dt = new FDateTime(dt_date, time.getTime_mp());
				if (isDtValidate(dt_effe, firstDayEnd, dt)) {
					reList.add(dt);
					worktime +=";";
					firstCycleLiveTimes++;
				}
			}	
			
		}
		//周期类型为分钟
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_MINUTE)){
			//TODO 暂时什么都不做
		}
		//周期类型为天
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
			// 涉及到隔日频次，执行时刻点必须从头开始计算
			FDate dt_date = new FDate(dt_effe.getDate().toLocalString());
			//首周期的结束时间
			FDateTime dtend = new FDateTime(dt_effe.getBeginDate().getDateAfter(frequnitct).getMillis());
			if(dt_end != null){
				if(dt_end.compareTo(dtend)<=0){
					dtend = dt_end;
				}
			}
			for (FreqTimeDO time : freqTimes) {
				if(time.getWdno()==null){
					throw new BizException("医嘱频次维护，第几天不能为空");
				}
				// 周期类型为天时，Wdno代表第几天，第几天不会超过周期数
				FDateTime dt = new FDateTime(dt_date.getDateAfter(time.getWdno() - 1), time.getTime_mp());
				//首日执行次数
				if (isDtValidate(dt_effe, firstDayEnd, dt)) {
					reList.add(dt);
					worktime +=time.getTime_mp().toLocalString()+";";
				}
				//首周期可执行数
				if(isDtValidate(dt_effe, dtend, dt)){
					firstCycleLiveTimes++;
				}
			}	
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)){
			HashMap<Integer, List<FTime>> mapWeek = getFreqTimeHt(freqTimes);
			// 涉及到间隔频次，执行时刻点必须从头开始计算
			FDate dt_date_effe = new FDate(dt_effe.getDate().toLocalString());
			// 获取生效时间所在周的周一
			FDate dt_date = dt_date_effe.getDateAfter(1 - dt_date_effe.getWeek());
			//首周期的结束时间
			FDateTime dtend = new FDateTime(dt_date.getDateAfter(7).getMillis());
			if(dt_end != null){
				if(dt_end.compareTo(dtend)<=0){
					dtend = dt_end;
				}
			}
			FDate dt_cursor = (FDate) dt_date.clone();
			for (int i = 1; i <= 7; i++) {
				if (mapWeek.containsKey(i)) {
					List<FTime> listTimes = mapWeek.get(i);
					if (listTimes != null && listTimes.size() > 0) {
						for (FTime fTime : listTimes) {
							FDateTime dt = new FDateTime(dt_cursor, fTime);
							//首日执行次数
							if (isDtValidate(dt_effe, firstDayEnd, dt)){
								reList.add(dt);
								worktime += fTime.toLocalString()+";";
							}
							//首周期可执行数
							if(isDtValidate(dt_effe, dtend, dt)){
								firstCycleLiveTimes++;
							}
						}
					}
				}
				dt_cursor = dt_cursor.getDateAfter(1);
			}		
		}
		times = reList.size();
		int MaxTimes = 0;
		//首周期执行次数 freqct,首日执行次数 times,首周期可执行次数 firstCycleLiveTimes
		//首周期执行次数 == 首周期可执行次数,times==0,不默认加1,Max_times = 首周期执行次数
		//首周期执行次数 > 首周期可执行次数,times==0,默认加1，Max_times=首周期可执行次数+1>=首周期执行次数?首周期可执行次数:首周期可执行次数+1;
		if(freqct == firstCycleLiveTimes){
			if(times==0){
				MaxTimes = 1;
				if(sd_srvtp == null || sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					if (CiParams.ZZ_CIOR0002().booleanValue()) {
							times++;
							worktime = dt_effe.getUFTime().toLocalString()+";";
					}
				}else{
					if (CiParams.CIOR0520().booleanValue()) {
							times++;
							worktime = dt_effe.getUFTime().toLocalString()+";";
					}
				}
			}else if(times != firstCycleLiveTimes){
				MaxTimes = times;
			}else{
				MaxTimes = firstCycleLiveTimes;
			}
		}else{
			if(times == 0){
				if(sd_srvtp == null || sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					if (CiParams.ZZ_CIOR0002().booleanValue()) {
							times++;
							worktime = dt_effe.getUFTime().toLocalString()+";";
					}
				}else{
					if (CiParams.CIOR0520().booleanValue()) {
							times++;
							worktime = dt_effe.getUFTime().toLocalString()+";";
					}
				}
			}
			MaxTimes = firstCycleLiveTimes+1 > freqct?firstCycleLiveTimes:firstCycleLiveTimes+1;
		}
		
		
		rst.setMax_times(MaxTimes);
		rst.setQuan_firday_mp(times);
		rst.setWorktime(worktime.length()>0?worktime.substring(0,worktime.length()-1):"");
		return rst;
	
	}
	/**
	 * 区分物品和非物品
	 * @param id_freq 频次 ，必填
	 * @param dt_effe 开始时间 ，必填
	 * @param dt_end 结束时间 ，必填
	 * @param sd_srvtp 服务类型，必填
	 * @param code_entp 就诊类型，可为空
	 * @param sd_orsrcfun 医嘱来源功能sd,可为空
	 * @param fg_pres_outp 出院带药标识，可为空
	 * @return
	 * @throws BizException 
	 */
	public static Integer CalFirstDayMp(String id_freq,FDateTime dt_effe,FDateTime dt_end,String sd_srvtp,String code_entp,String sd_orsrcfun,FBoolean fg_pres_outp) throws BizException{
		if(CiOrdUtils.isEmpty(id_freq)){
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		if(freqdefAgg==null){
			throw new BizException("频次不存在，请在频次定义中确认，该频次是否已被删除");
		}
		if(dt_effe == null){
			dt_effe = CiOrdAppUtils.getServerDateTime();
		}
		if(dt_end != null){
			FDate dayLater = dt_effe.getBeginDate().getDateAfter(1);
			if(dt_end.getBeginDate().compareTo(dayLater) >=0){
				dt_end = new FDateTime(dayLater.getMillis());
			}
		}
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		String sd_frequnitct = freqParent.getSd_frequnitct();//频次sd
		Integer times = 0;
		//频次周期类型为一次，总次数=1
		if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE)||FBoolean.TRUE.equals(freqParent.getFg_interval()))
		{
			return null;
		}
		//备用医嘱,总次数为=1
		else if(!CiOrdUtils.isEmpty(freqParent.getFg_prnor())&&freqParent.getFg_prnor().booleanValue()){
			return null;
		}
		//周期类型为小时
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)){
			times = hour(dt_effe,dt_end,freqTimes);
		}
		//周期类型为天
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
			times = day(dt_effe,dt_end,freqTimes);
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)){
			times = week(dt_effe,dt_end,freqTimes);
		}
		if(sd_srvtp == null || sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
			if (CiParams.ZZ_CIOR0002().booleanValue()) {
				if (times == 0) {
					times++;
				}
			}
		}else{
			if (CiParams.CIOR0520().booleanValue()) {
				if (times == 0) {
					times++;
				}
			}
		}
		return times;
	}
	/**
	 * 获得首日执行次数(首日0加1)
	 * 
	 * @param id_freq
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	public static Integer CalFirstDayMp(String id_freq, FDateTime dt_effe) throws BizException {
		if(CiOrdUtils.isEmpty(id_freq)){
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		if(freqdefAgg==null){
			throw new BizException("频次不存在，请在频次定义中确认，该频次是否已被删除");
		}
		if(dt_effe == null){
			dt_effe = CiOrdAppUtils.getServerDateTime();
		}
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		String sd_frequnitct = freqParent.getSd_frequnitct();//频次sd
		Integer times = 0;
		//频次周期类型为一次，总次数=1
		if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE)||FBoolean.TRUE.equals(freqParent.getFg_interval()))
		{
			return null;
		}
		//备用医嘱,总次数为=1
		else if(!CiOrdUtils.isEmpty(freqParent.getFg_prnor())&&freqParent.getFg_prnor().booleanValue()){
			return null;
		}
		//周期类型为小时
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)){
			times = hour(dt_effe,null,freqTimes);
		}
		//周期类型为天
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
			times = day(dt_effe,null,freqTimes);
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)){
			times = week(dt_effe,null,freqTimes);
		}
		if (times == 0) {
			times++;
		}
		return times;
	}
	/**
	 * 周期类型为小时，首日执行次数
	 * @param dt_begin
	 * @param dtend
	 * @param freqTimes
	 * @return
	 */
	private static Integer hour(FDateTime dt_begin,FDateTime dtend,FreqTimeDO[] freqTimes){
		List<FDateTime> reList = new ArrayList<FDateTime>();
		// 涉及到隔日频次，执行时刻点必须从头开始计算
		FDate dt_date = new FDate(dt_begin.getDate().toLocalString());
		if(dtend == null){
			dtend = new FDateTime(dt_date.getDateAfter(1).getMillis());
		}
		if (new FDate(dtend.getDate().toLocalString()).compareTo(dt_date) >= 0) {
			for (FreqTimeDO time : freqTimes) {
				FDateTime dt = new FDateTime(dt_date, time.getTime_mp());
				if (isDtValidate(dt_begin, dtend, dt)) {
					reList.add(dt);
				}
			}
		}
		return reList.size();
	}
	/**
	 * 周期类型为天，首日执行次数
	 * @param dt_begin
	 * @param dtend
	 * @param freqTimes
	 * @return
	 * @throws BizException 
	 */
	private static Integer day(FDateTime dt_begin,FDateTime dtend,FreqTimeDO[] freqTimes) throws BizException{
		List<FDateTime> reList = new ArrayList<FDateTime>();
		// 涉及到隔日频次，执行时刻点必须从头开始计算
		FDate dt_date = new FDate(dt_begin.getDate().toLocalString());
		if(dtend == null){
			dtend = new FDateTime(dt_date.getDateAfter(1).getMillis());
		}
		if (new FDate(dtend.getDate().toLocalString()).compareTo(dt_date) >= 0) {
			for (FreqTimeDO time : freqTimes) {
				if(time.getWdno()==null){
					throw new BizException("医嘱频次维护，第几天不能为空");
				}
				// 周期类型为天时，Wdno代表第几天，第几天不会超过周期数
				FDateTime dt = new FDateTime(dt_date.getDateAfter(time.getWdno() - 1), time.getTime_mp());
				if (isDtValidate(dt_begin, dtend, dt)) {
					reList.add(dt);
				}
			}
		}
		return reList.size();
	}
	/**
	 * 周期类型为周，首日执行次数
	 * @param dt_begin
	 * @param dtend
	 * @param freqTimes
	 * @return
	 * @throws BizException 
	 */
	private static Integer week(FDateTime dt_begin,FDateTime dtend,FreqTimeDO[] freqTimes) throws BizException{
		HashMap<Integer, List<FTime>> mapWeek = getFreqTimeHt(freqTimes);
		// 涉及到间隔频次，执行时刻点必须从头开始计算
		FDate dt_date_effe = new FDate(dt_begin.getDate().toLocalString());
		// 获取生效时间所在周的周一
		FDate dt_date = dt_date_effe.getDateAfter(1 - dt_date_effe.getWeek());
		if(dtend==null){
			dtend = new FDateTime(dt_date.getDateAfter(1).getMillis());	
		}
		List<FDateTime> reList = new ArrayList<FDateTime>();
		if (new FDate(dtend.getDate().toLocalString()).compareTo(dt_date) >= 0) {
			FDate dt_cursor = (FDate) dt_date.clone();
			for (int i = 1; i <= 7; i++) {
				if (mapWeek.containsKey(i)) {
					List<FTime> listTimes = mapWeek.get(i);
					if (listTimes != null && listTimes.size() > 0) {
						for (FTime fTime : listTimes) {
							FDateTime dt = new FDateTime(dt_cursor, fTime);
							if (isDtValidate(dt_begin, dtend, dt))
								reList.add(dt);
						}
					}
				}
				dt_cursor = dt_cursor.getDateAfter(1);
			}
		}
		return reList.size();
	}
	/***
	 * 获得频次时刻键值对
	 * 
	 * @param freqtimes
	 * @return
	 */
	private static HashMap<Integer, List<FTime>> getFreqTimeHt(FreqTimeDO[] freqtimes) {
		HashMap<Integer, List<FTime>> ht = new HashMap<Integer, List<FTime>>();
		for (int i = 0; i < freqtimes.length; i++) {
			if (ht.containsKey(freqtimes[i].getWdno())) {
				List<FTime> listTimes = (List<FTime>) ht.get(freqtimes[i].getWdno());
				listTimes.add(freqtimes[i].getTime_mp());
			} else {
				List<FTime> listTimes = new ArrayList<FTime>();
				listTimes.add(freqtimes[i].getTime_mp());
				ht.put(freqtimes[i].getWdno(), listTimes);
			}
		}
		return ht;
	}

	private static boolean isDtValidate(FDateTime dtstart, FDateTime dtend, FDateTime dt){
		if (dt == null)
			return false;
		long day0 = dt.getMillisAfter(dtstart);
		long day1 = dtend==null?0:dtend.getMillisAfter(dt);
		if (day0 >= 0 && day1 >= 0)// 记头,记尾
			return true;
		return false;
	}
}
