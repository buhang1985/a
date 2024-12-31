package iih.bd.fc.pub;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.mdwfor.d.DeptMacroEnum;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class BdFcUtils {
	public static final String COMMA_STR=",";
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
	public static <T extends BaseDO> BaseDO[] list2Array(List list,Class<T> c){
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
	 * 是否门急诊
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpUrgentWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp) || IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否门诊
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否急诊
	 * @param sd_entp
	 * @return
	 */
	public static boolean isUrgentWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否住院
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(sd_entp))return true;
		return false;
	}
	
	/**
	 * 根据部门宏变量获得部门id值
	 * @param deptmacro
	 * @param param
	 * @return
	 */
	public static String getWfCfgDepID(String deptmacro,OrWfExDeptParamDTO param ){
		if(DeptMacroEnum.PIENDEPT.equals(deptmacro)){
			return param.getId_dept_en();
		}else if(DeptMacroEnum.OROPENDEPT.equals(deptmacro)){
			return param.getId_dept_or();
		}else if(DeptMacroEnum.PINSDEPT.equals(deptmacro)){
			return param.getId_dept_ns();
		}
		return null;
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
}
