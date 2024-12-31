package iih.ci.ord.s.bp.quantum.times;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;

/**
 * 计算总次数的类入口
 * @author 张万青
 *
 */
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
	public Integer getTotalTimesBP(QuantumParamDTO param) throws BizException{
		if(validate(param).booleanValue()){
			//草药类药品,总次数=医嘱付数
			if(!CiOrdUtils.isEmpty(param.getSd_srvtp())&&param.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
				return param.getOrders();
			}
			//非草药类 ,通过计算获得
			else{
				return getTotalTimes(param.getDt_effe(),param.getId_freq(),param.getUse_day());
			}
			
		}
		return 0;
	}
	/**
	 * 通过频次和使用天数计算获得总次数
	 * @param dt_effe 空，默认取当前系统时间
	 * @param id_freq
	 * @param use_day
	 * @return
	 * @throws BizException
	 */
	public Integer getTotalTimes(FDateTime dt_effe,String id_freq,Integer use_day) throws BizException {
		if(CiOrdUtils.isEmpty(id_freq) || use_day == null){
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
		//Integer freqct = freqParent.getFreqct();//周期内次数
		Integer frequnitct = freqParent.getFrequnitct();//周期数
		//频次周期类型为一次，总次数=1
		if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE))
		{
			return 1;
		}
		//备用医嘱,总次数为=1
		else if(!CiOrdUtils.isEmpty(freqParent.getFg_prnor())&&freqParent.getFg_prnor().booleanValue()){
			return 1;
		}
		//周期类型为小时
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)){
			
			return use_day*24/frequnitct;
		}
		//周期类型为分钟
		else if (IBdSrvDictCodeConst.SD_FREQNUNITCT_MINUTE.equals(sd_frequnitct)) {
			return use_day * 24 * 60 / frequnitct;
		}
		//周期类型为天
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
			List<FDateTime> reList = new ArrayList<FDateTime>();
			// 涉及到隔日频次，执行时刻点必须从头开始计算
			FDate dt_date = new FDate(dt_effe.getDate().toLocalString());
			FDateTime dtend = dt_effe.getDateTimeAfter(use_day);
			while (new FDate(dtend.getDate().toLocalString()).compareTo(dt_date) >= 0) {
				for (FreqTimeDO time : freqTimes) {
					if(time.getWdno()==null){
						throw new BizException("医嘱频次维护，第几天不能为空");
					}
					// 周期类型为天时，Wdno代表第几天，第几天不会超过周期数
					FDateTime dt = new FDateTime(dt_date.getDateAfter(time.getWdno() - 1), time.getTime_mp());
					if (isDtValidate(dt_effe, dtend, dt)) {
						reList.add(dt);
					}
				}
				dt_date = dt_date.getDateAfter(frequnitct);
			}
			return reList.size();
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)){
			HashMap<Integer, List<FTime>> mapWeek = getFreqTimeHt(freqTimes);
			// 涉及到间隔频次，执行时刻点必须从头开始计算
			FDate dt_date_effe = new FDate(dt_effe.getDate().toLocalString());
			// 获取生效时间所在周的周一
			FDate dt_date = dt_date_effe.getDateAfter(1 - dt_date_effe.getWeek());
			FDateTime dtend = dt_effe.getDateTimeAfter(use_day);
			List<FDateTime> reList = new ArrayList<FDateTime>();
			while (new FDate(dtend.getDate().toLocalString()).compareTo(dt_date) >= 0) {
				FDate dt_cursor = (FDate) dt_date.clone();
				for (int i = 1; i <= 7; i++) {
					if (mapWeek.containsKey(i)) {
						List<FTime> listTimes = mapWeek.get(i);
						if (listTimes != null && listTimes.size() > 0) {
							for (FTime fTime : listTimes) {
								FDateTime dt = new FDateTime(dt_cursor, fTime);
								if (isDtValidate(dt_effe, dtend, dt))
									reList.add(dt);
							}
						}
					}
					dt_cursor = dt_cursor.getDateAfter(1);
				}
				dt_date = dt_cursor;
			}
			return reList.size();
		}
		return 0;
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
	/**
	 * 指定时间点是否在有效区间内，此逻辑只试用医嘱拆分，包含记头不计尾
	 * 
	 * @param dtstart
	 * @param dtend
	 * @param dt
	 * @return
	 */
	public static boolean isDtValidate(FDateTime dtstart, FDateTime dtend, FDateTime dt) {
		if (dt == null)
			return false;
		long day0 = dt.getMillisAfter(dtstart);
		long day1 = dtend.getMillisAfter(dt);
		if (day0 >= 0 && day1 > 0)// 记头不记尾
			return true;
		return false;
	}
	protected FBoolean validate(QuantumParamDTO param){
		if(CiOrdUtils.isEmpty(param)) return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
	/**
	 * 药品领量天数计算，只有药品非草药类才需要计算
	 * @param quan_cur 总量
	 * @param quan_medu 剂量
	 * @param factor 基本包装单位和总量单位间的换算系数
	 * @param factor_mb 医基换算系数
	 * @param id_freq 频次
	 * @return
	 * @throws BizException
	 */
	public Integer getDaysAvalidate(String sd_mupakgu,FDouble quan_cur,FDouble quan_medu,FDouble factor,FDouble factor_mb,String id_freq) throws BizException{
		if(CiOrdUtils.isEmpty(id_freq)||CiOrdUtils.isEmpty(quan_cur)||CiOrdUtils.isEmpty(quan_medu)||CiOrdUtils.isEmpty(factor_mb)||CiOrdUtils.isEmpty(factor)){
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		String sd_frequnitct = freqParent.getSd_frequnitct();//频次sd
		Integer freqct = freqParent.getFreqct();//周期内次数
		Integer frequnitct = freqParent.getFrequnitct();//周期数
		//考虑取整模式
		//FDouble quancurV = this.calTimes(quan_cur, sd_mupakgu,  quan_medu,  factor_mb,  factor);
		//走舍位//考虑取整模式
		Integer times = this.calTimes(quan_cur, sd_mupakgu,  quan_medu,  factor_mb,  factor).intValue();
		//周期类型为一次（once）或频次的备用标志位true，走一日一次的逻辑
		if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE)||freqParent.getFg_prnor().booleanValue()){
			return times;
		}
		//小时数
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR)){
			return (times/freqct*frequnitct%24)==0?(times/freqct*frequnitct/24):(times/freqct*frequnitct/24+1);
		}
		//周期类型为分钟
		else if(IBdSrvDictCodeConst.SD_FREQNUNITCT_MINUTE.equals(sd_frequnitct)){
			return (times/freqct*frequnitct%(24*60))==0?(times/freqct*frequnitct/(24*60)):(times/freqct*frequnitct/(24*60)+1);
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)){
			Integer remainder = times%freqct;
			//使用天数与周期数能整除
			if(remainder == 0||frequnitct==1){
				//领量天数 =总次数/频次下次数*周期数
				return times/freqct*frequnitct;
			}
			//不能整除
			else{
				int count=0;
				//排序
				CiOrdUtils.SortFreqTimeDO(freqTimes,"Day");
				for(FreqTimeDO freqtime:freqTimes){
					if(++count== remainder){
						return times/freqct*frequnitct+freqtime.getDay();
					}
				}
				return times;
			}
		}
		//周期类型为周
		else if(sd_frequnitct.equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)){
			Integer remainder = times%freqct;
			//使用天数与周期数能整除
			if(remainder == 0){
				return times/freqct*7;
			}
			//不能整除
			else{
				int count=0;
				CiOrdUtils.SortFreqTimeDO(freqTimes,"Week");
				for(FreqTimeDO freqtime:freqTimes){ 
					if(++count== remainder){
						return times/freqct*7+freqtime.getWeek();
					}
				}
				return times;
			}
		}
		 return 0;
	}
	private FDouble calTimes(FDouble quan_cur,String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor) throws BizException{
		if (CiOrdUtils.isEmpty(sd_mupakgu) || CiOrdUtils.isEmpty(quan_medu) || CiOrdUtils.isEmpty(factor_mb) || CiOrdUtils.isEmpty(factor)) return new FDouble(0);
		// 按次取整
		if (sd_mupakgu.equals("0")) {
			return quan_cur.div(Math.ceil(quan_medu.div(factor_mb.multiply(factor)).getDouble()));
		}
		// 按批取整或不取整
		else if (sd_mupakgu.equals("1")||sd_mupakgu.equals("4")) {
			return quan_cur.multiply((factor_mb.multiply(factor))).div(quan_medu);
		}else {
			throw new BizException("计算药品领量总次数，取整模式配置错误，无法计算！");
		}
	}
}
