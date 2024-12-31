package iih.bd.srv.pub;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class BdSrvUtils {
	public static final String DOT_STR=".";
	public static final String COMMA_STR=",";
	public static final String AND_STR=" and ";
	public static final String OR_STR=" or ";
	public static final String EQUAL_STR="=";
	public static final String IN_STR=" in ";
	public static final String QUESTION_STR=" ? ";
	public static final String LBRACE_STR="(";
	public static final String RBRACE_STR=")";
	public static final String SQUOTE_MARK_STR="'";
	public static final String CASE_STR=" case ";
	public static final String CASE_WHEN_STR=" case when ";
	public static final String WHEN_STR=" when ";
	public static final String THEN_STR=" then ";
	public static final String ELSE_STR=" else ";
	public static final String END_STR=" end ";  
	/**
	 * 数组对象为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object[] objs){
		if(objs==null || objs.length==0)return true;
		return false;
	}
	
	/**
	 * Map列表为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FMap map){
		if(map==null || map.size()==0)return true;
		return false;
	}
	
	/**
	 * 数组列表为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FArrayList list){
		if(list==null || list.size()==0)return true;
		return false;
	}
	
	/**
	 * 数组列表为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(List<?> list){
		if(list==null || list.size()==0)return true;
		return false;
	}
	
	/**
	 * 是否为空串判断
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input){
		
		return StringUtils.isBlank(input);
	}
	
	/**
	 * 对象为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		if(obj==null)return true;
		return false;
	}
	
	/**
	 * list转换为数组
	 * @param list
	 * @param c
	 * @return
	 */
	public static <T extends BaseDO> BaseDO[] list2Array(List<?> list,Class<T> c){
		return (T[]) list.toArray((T[]) Array.newInstance(c, 0));
	}
	
	/**
	 * 字符串等匹配判断
	 * 空则匹配成功
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static boolean isStrEqualMatch(String m1,String m2){
		if(!isEmpty(m1) && !isEmpty(m2) && !m1.equals(m2)){
			return false;
		}
		return true;
	}
	
	/**
	 * 字符串等匹配判断
	 * 空则匹配成功
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static boolean isStrIncludeMatch(String m1,String m2){
		if(!isEmpty(m1) && !isEmpty(m2) && m2.indexOf(m1)!=0){
			return false;
		}
		return true;
	}
	
	/**
	 * 字母匹配判断
	 */
	public static boolean isInStr(String input,String matchstr){
		if(isEmpty(matchstr) || isEmpty(input))return false;
		if(input.indexOf(matchstr)>=0)return true;
		return false;
	}
	
	/**
	 * 首字母匹配判断
	 */
	public static boolean isCapitalInStr(String input,String matchstr){
		if(isEmpty(matchstr) || isEmpty(input))return false;
		if(input.indexOf(matchstr)==0)return true;
		return false;
	}
	

	
	/**
	 * 数组转换为字符串
	 * @param basedos
	 * @param attrname
	 * @return
	 */
	public static String array2String(BaseDO[] basedos,String attrname){
		if(isEmpty(basedos) || isEmpty(attrname))return null;
		String rtn="";
		for(int i=0;i<basedos.length;i++){
			rtn+=COMMA_STR+basedos[i].getAttrVal(attrname);
		}
		return rtn.substring(1);
	}
	public static String addLRCommaStr(String input){
		return COMMA_STR+input+COMMA_STR;
	}
	
	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * @param ids
	 * @return
	 */
	public static String getSqlInStrsWithOutIn(String[] ids){
		//有效性判断
		if(isEmpty(ids))return null;
		String instr="";

		//遍历
		for(int i=0;i<ids.length;i++){
			instr+=COMMA_STR+SQUOTE_MARK_STR+ids[i]+SQUOTE_MARK_STR;
		}
		//返回置处理
		return instr.substring(1);
	}
	
	/**
	 * 获得查询条件sql串（样式：in ('1','2','3')）
	 * @param ids
	 * @return
	 */
	public static String getSqlInStrsWithIn(String[] ids){
		//有效性判断
		if(isEmpty(ids))return null;
		String instr="";

		//遍历
		for(int i=0;i<ids.length;i++){
			instr+=COMMA_STR+SQUOTE_MARK_STR+ids[i]+SQUOTE_MARK_STR;
		}
		//返回置处理
		return IN_STR+LBRACE_STR+instr.substring(1)+RBRACE_STR;
	}
	
	/**
	 * 获得ids串对应的sql格式串
	 * @param idsstr
	 * @return
	 */
	public static String getIdsSqlStr(String idsstr){
		return SQUOTE_MARK_STR
				+ idsstr.replaceAll(COMMA_STR, SQUOTE_MARK_STR + COMMA_STR
						+ SQUOTE_MARK_STR) + SQUOTE_MARK_STR;
	}
	
	/**
	 * 获得ids串对应的sql格式串（含in）
	 * @param idsstr
	 * @return
	 */
	public static String getIdsSqlStrWithInStr(String idsstr){
		return IN_STR + LBRACE_STR + BdSrvUtils.getIdsSqlStr(idsstr)
				+ RBRACE_STR;
	}
	
	/**
	 * 获得sql条件串片段
	 * ids为逗号分隔的串
	 * @param _ids
	 * @return
	 */
	public static String getCondStrWithEqualOrIn(String _ids){
		if(_ids.indexOf(COMMA_STR)>0){
			return IN_STR+LBRACE_STR+_ids+RBRACE_STR;
		}
		
		return EQUAL_STR+_ids;
	}
	
	/**
	 * 获得sql条件串片段
	 * @param id
	 * @return
	 */
	public static String getSqlCondStrWithComma(String id){
		return COMMA_STR+SQUOTE_MARK_STR+id+SQUOTE_MARK_STR;
	}
	
	/**
	 *  获得就诊类型对应的字段名
	 * @param entp
	 * @return
	 */
	public static String getEntpFldNameStr(String entp){
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp))return "op";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp))return "ip";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(entp))return "pip";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(entp))return "er";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entp))return "er1";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entp))return "er2";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entp))return "pe";
		if(IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(entp))return "fm";
		
		return "";
	}
	
	/**
	 *  获得就诊类型对应的字段名
	 * @param entp
	 * @return
	 */
	public static String getEntpFldNameStr8Id(String entp){
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entp))return "op";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entp))return "ip";
		//if(IBdFcDictCodeConst.ID_CODE_ENTP_ET.equals(entp))return "er";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FLOW.equals(entp))return "er";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FSTAID.equals(entp))return "er1";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(entp))return "er2";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_PE.equals(entp))return "pe";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_FA.equals(entp))return "fm";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FLOW.equals(entp))return "er";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FSTAID.equals(entp))return "er1";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE.equals(entp)) return "pip";
		return "";
	}
	
	/***
	 * 是否为TRUE
	 * 
	 * @param isA
	 * @return
	 */
	public static boolean isTrue(FBoolean isA) {
		if (isA == null)
			return false;
		return isA.booleanValue();
	}
	
	/**
	 * 获得sql case when  片段
	 * @param expstr
	 * @param vstr
	 * @return
	 */

	public static String getWhenThenStr(String expstr,String vstr){
		return BdSrvUtils.WHEN_STR + BdSrvUtils.LBRACE_STR + (StringUtils.isEmpty(expstr)?("1=1"):expstr)
				+ BdSrvUtils.RBRACE_STR + BdSrvUtils.THEN_STR
				+ BdSrvUtils.SQUOTE_MARK_STR + vstr
				+ BdSrvUtils.SQUOTE_MARK_STR;
	}
	
	/**
	 * 获得sql串对应的Map
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static Map<String,Object> getRsMap(String sqlStr) throws BizException{
		try{
			return (Map<String,Object>)(new DAFacade().execQuery(sqlStr, new MapHandler()));
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}
	
	/**
	 * 获得sql串对应的MapList
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException{
		try{
			return (List<Map<String, Object>>)(new DAFacade().execQuery(sqlStr, new MapListHandler()));
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}
	
	/**
	 * 顺序一致处理逻辑
	 * @param prisrvs
	 * @param medsrvdos
	 * @param hm
	 * @return
	 */
	public static MedSrvDO[] InOutSeqSyncHandle(String[] id_srvs,MedSrvDO[] medsrvdos){
		HashMap<String,Integer> hm=getIdSrvs(id_srvs);
		
		//参数
		MedSrvDO[] rtns=new MedSrvDO[id_srvs.length];
		
		//遍历
		for(int i=0;i<medsrvdos.length;i++){
			rtns[(Integer)hm.get(medsrvdos[i].getId_srv())]=medsrvdos[i];
		}
		
		//返回值
		return rtns;
	}
	
	/**
	 * 获得医疗服务主键序号映射信息
	 * @param id_srvs
	 * @return
	 */
	private static HashMap<String,Integer> getIdSrvs(String[] id_srvs){
		//非空检验
		if(isEmpty(id_srvs))return null;
		
		//参数设置
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		
		//遍历
		for(int i=0;i<id_srvs.length;i++){
			hm.put(id_srvs[i], i);
		}
		
		//返回值
		return hm;
	} 
}
