package iih.ci.mrqc.autoqc.ruleclazz.common;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 自动质控公共调用类
 * @author Founder
 */
public class CommonRuleUtil {
	
	/**
	 * 判断该患者是否住院
	 * @param enEmrDTO
	 * @return
	 */
	public static boolean IsInHospital(EnEmrDTO enEmrDTO){
		return false;
	}
	
	/**
	 * 判断是否出院
	 * @param enEmrDTO
	 * @return
	 */
	public static boolean IsLeaveHospital(EnEmrDTO enEmrDTO){
		String sd_status = enEmrDTO.getSd_status();
		if(ICiDictCodeConst.SD_STATUS.equals(sd_status))
			return true;
		return false;
	}
	
	/**
	 * 判断该患者是否死亡
	 * @param enEmrDTO
	 * @return
	 */
	public static boolean IsDeath(EnEmrDTO enEmrDTO){
		String id_gowhere = enEmrDTO.getId_gowhere();
		if(ICiDictCodeConst.ID_GOWHERE.equals(id_gowhere))
			return true;
		return false;
	}
	
	/**
	 * 是否存在该患者的某种类型文书记录
	 * @throws Exception 
	 */
	public static boolean IsExistDocumentRecord(String strSqlIsHavedButOverTiem) throws Exception{
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiem, "", new FBoolean(false));
		if(ciMrDOArr.length > 0){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	
	/**
	 * 是否手术标志
	 * @return
	 */
	public static boolean IsOperation(EnEmrDTO enEmrDTO){
		boolean b = enEmrDTO.getFg_surg().booleanValue();//是否手术标志
		return b;
	}
	
	/**
	 * 判断是否存在该患者某种类型记录
	 * @param strSqlIsHaveMR 查询sql
	 * @return
	 * @throws BizException
	 */
	public static boolean IsHaveAR(String strSqlIsHaveMR) throws BizException{
		DAFacade daf=new DAFacade();
		int mrCount=(int) daf.execQuery(strSqlIsHaveMR, new ColumnHandler());
		if(mrCount>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 初始化StrSqlIsHavedButOverTiem sql语句
	 * @param enEmrDTO
	 * @param autoItmConfigDO
	 * @return
	 */
	public static String getStrSqlHowManyMrTask(EnEmrDTO enEmrDTO,
			AutoItmConfigDO autoItmConfigDO) {
		//拼strSqlIsHaveAR
		String strMrTps = autoItmConfigDO.getId_mr_types();
		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
			strMrTps=strMrTps.replaceAll(",","','");
			strMrTps="('"+strMrTps+"')";
		}
		//拼strSqlIsHavedButOverTiem
		String strSqlIsHavedButOverTiem = " a0.id_ent = '"+enEmrDTO.getId_ent()+"'  and a0.id_mrtp in " +strMrTps;
		return strSqlIsHavedButOverTiem;
	}
	/**
	 * 初始化StrSqlIsHaveMR sql语句判断是否有文书
	 * @param enEmrDTO
	 * @param autoItmConfigDO
	 * @return
	 */
	public static String getStrSqlIsHaveMR(EnEmrDTO enEmrDTO,
			AutoItmConfigDO autoItmConfigDO){
		//拼strSqlIsHaveAR
		String strMrTps = autoItmConfigDO.getId_mr_types();
		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
			strMrTps=strMrTps.replaceAll(",","','");
			strMrTps="('"+strMrTps+"')";
		}
		String strSqlIsHaveMR = " select count(id_mr) from CI_MR  where id_ent='"+enEmrDTO.getId_ent()+"' and sd_su_mr !='00' and id_mrtp in "+strMrTps;
		return strSqlIsHaveMR;
				
	}
	/**
	 * 初始化StrSqlIsHavedButOverTiem sql语句
	 * @param enEmrDTO
	 * @param autoItmConfigDO
	 * @return
	 */
	public static String getStrSqlIsHavedButOverTiem(EnEmrDTO enEmrDTO,
			AutoItmConfigDO autoItmConfigDO) {
		//拼strSqlIsHaveAR
		String strMrTps = autoItmConfigDO.getId_mr_types();
		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
			strMrTps=strMrTps.replaceAll(",","','");
			strMrTps="('"+strMrTps+"')";
		}
		//拼strSqlIsHavedButOverTiem
		String strSqlIsHavedButOverTiem = " id_ent = '"+enEmrDTO.getId_ent()+"' and sd_su_mr!='00' and id_mrtp in " +strMrTps;
		return strSqlIsHavedButOverTiem;
	}
	
	/**
	 * 根据任务初始化StrSqlIsHaveMR sql语句判断是否有文书
	 * @param enEmrDTO
	 * @param autoItmConfigDO
	 * @return
	 */
	public static String getStrSqlIsHaveMRByTask(MrTaskDO[] mrtasklist,
			AutoItmConfigDO autoItmConfigDO){
		//拼strSqlIsHaveAR
		if(mrtasklist.length==0){
			return null;
		}
		String strMrTps = autoItmConfigDO.getId_mr_types();
		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
			strMrTps=strMrTps.replaceAll(",","','");
			strMrTps="('"+strMrTps+"')";
		}
		String strSqlIsHaveMR = " select count(id_mr) from CI_MR  where id_ent='"+mrtasklist[0].getId_ent()+"' and sd_su_mr !='00' and id_mrtp in "+strMrTps;
		return strSqlIsHaveMR;
				
	}
	/**
	 * 根据任务初始化StrSqlIsHavedButOverTiem sql语句
	 * @param enEmrDTO
	 * @param autoItmConfigDO
	 * @return
	 */
	public static String getStrSqlIsHavedButOverTiemByTask(MrTaskDO[] mrtasklist,
			AutoItmConfigDO autoItmConfigDO) {
		//拼strSqlIsHaveAR
		String strMrTps = autoItmConfigDO.getId_mr_types();
		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
			strMrTps=strMrTps.replaceAll(",","','");
			strMrTps="('"+strMrTps+"')";
		}
		//拼strSqlIsHavedButOverTiem
		String strSqlIsHavedButOverTiem = " id_ent = '"+mrtasklist[0].getId_ent()+"' and sd_su_mr!='00' and id_mrtp in " +strMrTps;
		return strSqlIsHavedButOverTiem;
	}
	
  
	/**
	 * true 超时
	 * false 没有超时
	 * @param date
	 * @param limitTime
	 * @return
	 */
	public static boolean IsOverTimeCur(String date,Double limitTime){
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2=format.format(new Date());//当前时间
		try {
			if(CalcIsOverTime(date, date2 ,limitTime)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * true 超时
	 * false  没有超时
	 * @param date1
	 * @param date2
	 * @param limitTime
	 * @return
	 * @throws Exception
	 */
	public static boolean CalcIsOverTime(String date1, String date2 ,Double limitTime) throws Exception { 
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-M-d HH:mm:ss"); 
        java.util.Date start = sdf.parse(date1); 
        java.util.Date end = sdf.parse(date2); 
        long cha = end.getTime() - start.getTime(); 
        double result = cha * 1.0 / (1000 * 60 * 60); 
        if(result<=limitTime){
             return false; //不扣分
        }else{ 
             return true; 
        } 
    }
	
}
