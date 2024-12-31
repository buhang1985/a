package iih.ci.sdk.utils;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.sdk.cache.BDFreqTimeInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
/**
 * 医疗单工具类
 * @author Liuxiaoying
 *
 */
public class CiEmsUtils {


	/**
	 * 获取首日执行次数
	 * 
	 * @param id_freq
	 * @param dt_entry
	 * @return
	 * @throws BizException
	 */
	public static Integer getQuan_firday_mp(String id_freq, FDateTime dt_entry) throws BizException {
		if (StringUtils.isEmpty(id_freq) || dt_entry == null) {
			return 0;
		}
		FreqTimeDO[] freqTimeDOs = BDFreqTimeInfoCache.GetFreqTimeInfos(id_freq);
		if (ObjectUtils.isEmpty(freqTimeDOs )) {
			return 0;
		}
		Integer quan = 0;
		for(FreqTimeDO freqTime:freqTimeDOs){
			if (freqTime.getTime_mp().after(new FTime(dt_entry.getTime()))) {
				quan++;
			}
		}			
		return quan;
	}
	
	/**
	 * quan/factor求分子分母的算法
	 * 
	 * @param quan
	 *            医疗用量
	 * @param factor
	 *            mb
	 * @return
	 */
	public static int[] getNumDen(FDouble quan, FDouble factor) {
		int[] rtns = new int[] { 0, 0 };
		int[] iquans=getNumBen(quan);
		int[] ifactors=getNumBen(factor);
		
		int inum=iquans[0]*ifactors[1];
		int iben=ifactors[0]*iquans[1];
		int imaxdiv = getMaxComDivisor(inum, iben);
		if(imaxdiv== 0){
			rtns[0] = 0  ;
			rtns[1] = 0;
		}else{
			rtns[0] = inum / imaxdiv;
			rtns[1] = iben / imaxdiv;
		}
		
		return rtns;
	}
	/**
	 * 获得最大公约数
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getMaxComDivisor(int m, int n) {
		int k, y;
		if (m < n) {
			k = m;
			m = n;
			n = k;
		}
		if(n==0) return 0;
		while (m % n != 0) {
			y = m % n;
			m = n;
			n = y;
		}
		return n;
	}
	/**
	 * 获得对应的分数格式数据
	 * @param input
	 * @return
	 */
	private static int[] getNumBen(FDouble input){
		if(input==null)return new int[]{0,1};
		String sinput=input.toString();
		String[] sTs=sinput.split("\\.");
		if(sTs.length==1)return new int[]{input.intValue(),1};
		sTs[1]=numBenHandle(sTs[1]);
		return new int[]{Integer.valueOf(sTs[0]+sTs[1]),getNumV(sTs[1])};
		
	}
	private static String numBenHandle(String input){
		if(ObjectUtils.isEmpty(input))return "";
		int iL=input.length();
		String rtnstr="";
		char[] szInput = input.toCharArray();
		for(int i=iL-1;i>=0;i--){
			if (szInput[i] != '0')
			{
				rtnstr = input.substring(0, i+1);
				break;
			}
		}
		return rtnstr;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static int getNumV(String s){
		if(s==null || s.equals(""))return 1;
		String rtn="1";
		for(int i=0;i<s.length();i++){
			rtn+="0";
		}
		return Integer.valueOf(rtn);
	}
	
	/**
	 * 本服务定价模式 按编码
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_SRV.equals(id_primd);
	}

	/**
	 * 本服务定价模式 按ID
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd8Id(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd);
	}

	/**
	 * 对应物品价格模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvMMPri8Id(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_RES.equals(id_primd);
	}

	/**
	 * 服务不付费模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvFreePrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_FREE.equals(id_primd);
	}

	/**
	 * 服务组合定价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvCompPrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd);
	}

	/**
	 * 套成员合计计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberSumPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT.equals(id_primd);
	}

	/**
	 * 套成员个数加收计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemCntAdditionalPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_MU.equals(id_primd);
	}

	/**
	 * 套成员个数定价计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberCntPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_FIX.equals(id_primd);
	}

}
