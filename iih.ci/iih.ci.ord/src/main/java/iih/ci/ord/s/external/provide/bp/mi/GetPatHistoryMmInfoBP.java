package iih.ci.ord.s.external.provide.bp.mi;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.i.external.provide.meta.mi.MiOrSrvMmDTO;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatHistoryMmInfoBP {

	public FMap getPatMmQuanCur(String id_pat, FDateTime begin, FDateTime end) throws DAException {

		SqlParam param = new SqlParam();
		param.addParam(id_pat);
		param.addParam(begin);
		param.addParam(end);
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ord.id_or,ord.days_or"); 
		buffer.append(",orsrv.id_orsrv,orsrv.id_srv,orsrv.quan_medu,orsrv.id_medu,orsrv.id_dsdef");
		buffer.append(",mm.id_mm,mm.quan_cur,mm.id_pgku_cur,mm.factor,mm.factor_mb");
		buffer.append(" from ci_order ord,ci_or_srv orsrv,ci_or_srv_mm mm");
		buffer.append(" where ord.id_pat = ? and ord.dt_effe>=? and ord.dt_effe<= ?");
		buffer.append(" and ord.sd_srvtp like '01%' and ord.fg_sign='Y' and ord.fg_canc='N' and ord.sd_su_bl not in ('1','2') and ord.code_entp in('00','0101','0102') ");
		buffer.append(" and ord.id_or = orsrv.id_or and orsrv.id_orsrv=mm.id_orsrv");
		buffer.append(" and orsrv.fg_mm='Y' and orsrv.sd_su_bl not in ('1','2')  ");
		
		List<MiOrSrvMmDTO> miOrSrvList = (List<MiOrSrvMmDTO>) new DAFacade().execQuery(buffer.toString(),param, new BeanListHandler(MiOrSrvMmDTO.class));
		FMap map = new FMap();
		// TODO 拼接加病种id
		String id_dsdef = "";
		for(MiOrSrvMmDTO orSrvMm : miOrSrvList){
			String key = StringUtils.trimToEmpty(orSrvMm.getId_dsdef()) + orSrvMm.getId_mm();
			FDouble f = new FDouble();
			if(map.containsKey(key)){
				 f = (FDouble)map.get(key);
			}
			f= f.add(orSrvMm.getQuan_cur().multiply(orSrvMm.getFactor()).multiply(orSrvMm.getFactor_mb()));
			map.put(key, f);
		}
		return map;
	}
	
}
