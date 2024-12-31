package iih.bd.srv.d;

import xap.mw.core.data.BaseDTO;

public class RefSrvItemDTO extends BaseDTO {

	public static final long serialVersionUID =1L;
	
	public static  String srv_name;
	public static  String srv_code;
	public static  String freq_id_freq;
	public static  String freq_name;
	public static  String  measdoc_id_measdoc;
	public static  String measdoc_name;
	public static  String rout_id_route;
	public static  String rout_name;
	// 新增的属性
	public static  String check;
	public static  String Id_grp;
	public static  String Quan_med;
	public static  String Fg_long;
	
	
	public static String getSrv_name() {
		return srv_name;
	}
	public static void setSrv_name(String srv_name) {
		RefSrvItemDTO.srv_name = srv_name;
	}
	public static String getSrv_code() {
		return srv_code;
	}
	public static void setSrv_code(String srv_code) {
		RefSrvItemDTO.srv_code = srv_code;
	}
	public static String getFreq_id_freq() {
		return freq_id_freq;
	}
	public static void setFreq_id_freq(String freq_id_freq) {
		RefSrvItemDTO.freq_id_freq = freq_id_freq;
	}
	public static String getFreq_name() {
		return freq_name;
	}
	public static void setFreq_name(String freq_name) {
		RefSrvItemDTO.freq_name = freq_name;
	}
	public static String getMeasdoc_id_measdoc() {
		return measdoc_id_measdoc;
	}
	public static void setMeasdoc_id_measdoc(String measdoc_id_measdoc) {
		RefSrvItemDTO.measdoc_id_measdoc = measdoc_id_measdoc;
	}
	public static String getMeasdoc_name() {
		return measdoc_name;
	}
	public static void setMeasdoc_name(String measdoc_name) {
		RefSrvItemDTO.measdoc_name = measdoc_name;
	}
	public static String getRout_id_route() {
		return rout_id_route;
	}
	public static void setRout_id_route(String rout_id_route) {
		RefSrvItemDTO.rout_id_route = rout_id_route;
	}
	public static String getRout_name() {
		return rout_name;
	}
	public static void setRout_name(String rout_name) {
		RefSrvItemDTO.rout_name = rout_name;
	}
	// 新增方法
	public static String getCheck() {
		return check;
	}
	public static void setCheck(String check) {
		RefSrvItemDTO.check = check;
	}
	
	public static String getId_grp() {
		return Id_grp;
	}
	public static void setId_grp(String Id_grp) {
		RefSrvItemDTO.Id_grp = Id_grp;
	}
	
	public static String getQuan_med() {
		return Quan_med;
	}
	public static void setQuan_med(String Quan_med) {
		RefSrvItemDTO.Quan_med = Quan_med;
	}
	
	public static String getFg_long() {
		return Fg_long;
	}
	public static void setFg_long(String Fg_long) {
		RefSrvItemDTO.Fg_long = Fg_long;
	}
	

}
