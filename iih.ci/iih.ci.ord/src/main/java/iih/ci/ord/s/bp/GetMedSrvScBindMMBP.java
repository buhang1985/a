package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.er.ObsOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.er.ObsOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.ip.DrugCheckDisplayMd4IP;
import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefSrvSQLBuilder;
import iih.ci.ord.ciordems.d.EmsOrSrvSc;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
/**
 * 住院检索框，查询逻辑
 * @author zhangwq
 *
 */
public class GetMedSrvScBindMMBP extends GetAbsMedSrvScBindMMBP {
	private int showNumber = 21;
	@Override
	public EmsOrSrvSc[] exec(String openType,String sd_inputmethod, String blurValue,CiEnContextDTO encontex) {
		Logger.warn("参照入参：id_hp:"+encontex.getId_hp_default()+"--id_pripat:"+encontex.getId_pripat()+"--openType:"+openType+"--code_entp:"+encontex.getCode_entp()+"--blurValue:"+blurValue+"--sd_inputmethod:"+sd_inputmethod);
		StringBuffer buffer = null;
		//获取物品分组参数,为SQL拼接做准备  0175738：
		String mmGroupParam = DrugCheckDisplayMd4IP.getInstance().getDrugGroupParam();
		if(StringUtils.isNullOrEmpty(sd_inputmethod)) //输入方式为空就默认拼音，出院带药
			sd_inputmethod="10";
		if(StringUtils.isNullOrEmpty(openType)||"All".equals(openType)){//全部
			OpOrderRefSrvSQLBuilder refsrv = getOrderRefSrvSQLBuilder(encontex.getCode_entp());
			buffer = refsrv.getSQL(sd_inputmethod, encontex.getId_hp_default(), encontex.getId_pripat(), blurValue, null);
			
			buffer.append(" union ");
			OpOrderRefMMSQLBuilder refmm = getOrderRefMMSQLBuilder(encontex.getCode_entp());
			if("11".equals(getDrugDisplayMd())){
				buffer.append(refmm.getSrvMmPkgSQL(sd_inputmethod, encontex.getId_hp_default(), blurValue, null, mmGroupParam,null).toString());
			}else{
				buffer.append(refmm.getSrvMmSQL(sd_inputmethod, encontex.getId_hp_default(), blurValue, null, mmGroupParam,null).toString());
			}
			
		}else if(openType.startsWith("01")){//药品
			OpOrderRefMMSQLBuilder refsrv = getOrderRefMMSQLBuilder(encontex.getCode_entp());
			List<String> whereList = new ArrayList<String>();
			if(openType.contains(",")){
				whereList.add("'"+openType + "' like '%'||srv.sd_srvtp||'%'");
			}else{
				whereList.add("srv.sd_srvtp like '"+openType+"%'");
			}
			if("11".equals(getDrugDisplayMd())){
				buffer =  refsrv.getSrvMmPkgSQL(sd_inputmethod, encontex.getId_hp_default(), blurValue, whereList, mmGroupParam,null);
			}else{
				buffer = refsrv.getSrvMmSQL(sd_inputmethod, encontex.getId_hp_default(), blurValue, whereList, mmGroupParam,null);
			}
		}else{//非药品
			OpOrderRefSrvSQLBuilder refsrv = getOrderRefSrvSQLBuilder(encontex.getCode_entp());
			List<String> whereList = new ArrayList<String>();
			if(openType.contains(",")){
				whereList.add("'"+openType + "' like '%'||srv.sd_srvtp||'%'");
			}else{
				whereList.add("srv.sd_srvtp like '"+openType+"%'");
			}
			buffer = refsrv.getSQL(sd_inputmethod, encontex.getId_hp_default(), encontex.getId_pripat(), blurValue, whereList);
		}
		DAFacade dafacade = new DAFacade();
		List<Map<String, Object>> rsts;
		Logger.error(buffer.toString());
		try {
			rsts = (List<Map<String, Object>>) dafacade.execQuery(this.getQuerySql(buffer), new MapListHandler());
			List<EmsOrSrvSc> emsOrScSrvs = new ArrayList<EmsOrSrvSc>();
			if (rsts != null && rsts.size() > 0) {
				for (Map<String, Object> map : rsts) {
					EmsOrSrvSc emsSrv = new EmsOrSrvSc();
					emsSrv.setDes(map.get("des") == null ? null : (String) map.get("des"));
					emsSrv.setId_srv(map.get("id_srv") == null ? null : (String) map.get("id_srv"));
					emsSrv.setId_mm(map.get("id_mm") == null ? null : (String) map.get("id_mm"));
					emsSrv.setName_srv(map.get("name_srvmm") == null ? null : (String) map.get("name_srvmm"));
					emsSrv.setDes_pri(map.get("des_pri") == null ? null : (String) map.get("des_pri"));
					emsSrv.setSd_srvtp(map.get("sd_srvtp")==null ? null : map.get("sd_srvtp").toString());
					emsSrv.setName_srvca(map.get("srvtp") == null ? null : map.get("srvtp").toString());
					emsSrv.setId_unit_sale(map.get("id_unit_sale") == null ? null : (String) map.get("id_unit_sale"));
					emsSrv.setName_unit_sale(map.get("name_unit_sale") == null ? null : (String) map.get("name_unit_sale"));
					emsOrScSrvs.add(emsSrv);
				}
			}
			return emsOrScSrvs.toArray(new EmsOrSrvSc[0]);
		} catch (DAException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getDrugDisplayMd() {
		return DrugCheckDisplayMd4IP.getInstance().getDrugCheckDisplayMd4IP();
	}
	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp){
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){// 住院
			return new IpOrderRefSrvSQLBuilder();
		}
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){// 急诊留观
			return new ObsOrderRefSrvSQLBuilder();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefSrvSQLBuilder();
		}
		return new IpOrderRefSrvSQLBuilder();
	}
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp){
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){// 住院
			return new IpOrderRefMMSQLBuilder();
		}
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){// 急诊留观
			return new ObsOrderRefMMSQLBuilder();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefMMSQLBuilder();
		}
		return new IpOrderRefMMSQLBuilder();
	}
	private String getQuerySql(StringBuffer buffer){
		return "select * from (select srvmm.*,rownum r from (select *  from ("+ buffer.toString() +") order by length(name_srvmm) asc, pycode)srvmm) where r<50";
	}
}
