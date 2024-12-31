package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.refs.sql.OrMedSrvOrderBase;
import iih.bd.srv.medsrv.refs.sql.ip.IpWuweiMedSrvRefSql;
import iih.ci.ord.ciordems.d.EmsOrSrvSc;
import iih.ci.ord.dto.d.CiOrdQryParmaDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mp.nr.dto.d.ParamDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class GetWuWeiMedSrvScBindMMBP extends GetAbsMedSrvScBindMMBP{

	@Override
	public EmsOrSrvSc[] exec(String openType,String sd_inputmethod, String blurValue,CiEnContextDTO conetxtDTO) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public EmsOrSrvSc[] exec(String srvca, String srvName, String Healthca,CiEnContextDTO conetxtDTO)  {
//		return this.exec(srvca, srvName, Healthca, conetxtDTO.getCode_entp(),conetxtDTO.getId_pripat(),conetxtDTO.getId_hp_default());
//	}
//	/** 
//	 * @param srvca
//	 * @param srvName
//	 * @param Healthca
//	 * @return
//	 * @throws BizException
//	 */
//	public EmsOrSrvSc[] exec(String srvca, String srvName, String Healthca, String code_entp,String id_pripat,String id_hp)  {
//		List<String> whereStr = new ArrayList<String>();
//		EmsOrSrvSc[] emsOrScSrv = null;
//		if (srvca != null && srvca != "") {
//			if(srvca.contains(",")){
//				StringBuffer srvcaSql = new StringBuffer();
//				String[] srvcaArray = srvca.split(",");
//				int index=0;
//				for(String ca:srvcaArray){
//					if(index==0){
//						srvcaSql.append("(a0.sd_srvtp like '" + ca + "%'");	
//					}else{
//						srvcaSql.append("or a0.sd_srvtp like '" + ca + "%'");
//					}
//					index++;
//				}
//				srvcaSql.append(")");
//				whereStr.add(srvcaSql.toString());
//			}else{
//				whereStr.add("a0.sd_srvtp like '" + srvca + "%'");
//			}
//		}
//		if (srvName != null && srvName != "") {
//			srvName = srvName.toLowerCase();
//			srvName = srvName.replaceAll("[ ]+", "%");
//			srvName = srvName == "%" ? "" : srvName;
//			StringBuffer sb = new StringBuffer();
//			sb.append(" (");
//			sb.append("lower(a0.Name) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(" or ");
//			sb.append("lower(mm.name) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(" or ");
//			sb.append("lower(mm.pycode) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(" or ");
//			sb.append("lower(mm.wbcode) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(" or ");
//			sb.append("lower(a0.Pycode) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(" or ");
//			sb.append("lower(a0.Wbcode) like ");
//			sb.append("'%" + srvName + "%'");
//			sb.append(") ");
//			whereStr.add(sb.toString());
//		}
//		OrMedSrvOrderBase qrybp = new IpWuweiMedSrvRefSql();
//		DAFacade dafacade = new DAFacade();
//		List<Map<String, Object>> rsts;
//		try {
//			rsts = (List<Map<String, Object>>) dafacade
//					.execQuery(qrybp.getMySqlStr(code_entp, id_hp, srvName, id_pripat, whereStr), new MapListHandler());
//		
//
//		if (rsts != null && rsts.size() > 0) {
//			emsOrScSrv = new EmsOrSrvSc[rsts.size()];
//			int i = 0;
//			for (Map<String, Object> map : rsts) {
//				EmsOrSrvSc emsSrv = new EmsOrSrvSc();
//				emsSrv.setDes(map.get("des") == null ? null : (String) map.get("des"));
//				emsSrv.setId_srv(map.get("id_srv") == null ? null : (String) map.get("id_srv"));
//				emsSrv.setId_mm(map.get("id_mm") == null ? null : (String) map.get("id_mm"));
//				emsSrv.setName_srv(map.get("name_srv_desc") == null ? null : (String) map.get("name_srv_desc"));
//				emsSrv.setDes_pri(map.get("des_pri") == null ? null : (String) map.get("des_pri"));
//				emsSrv.setSd_srvtp(map.get("sd_srvtp").toString());
//				emsSrv.setName_srvca(map.get("name_srvca").toString());
//				emsSrv.setId_unit_sale(map.get("id_unit_sale") == null ? null : (String) map.get("id_unit_sale"));
//				emsSrv.setName_unit_sale(map.get("name_unit_sale") == null ? null : (String) map.get("name_unit_sale"));
//				emsOrScSrv[i] = emsSrv;
//				i++;
//			}
//		}
//		return emsOrScSrv;
//		} catch (DAException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return emsOrScSrv;
//	}
		
}
