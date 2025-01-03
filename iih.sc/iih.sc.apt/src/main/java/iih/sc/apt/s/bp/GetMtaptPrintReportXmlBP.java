package iih.sc.apt.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scprtcfg.d.ScEuRangScca;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtaptPrintReportXmlBP {
	
	public String exec(MtAppDTO mtAppDTO) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select tmpl.path");
		sql.append(" from sc_prt_cfg scg");
		sql.append(" inner join sc_prt_tmpl tmpl");
		sql.append(" on tmpl.id_prttmpl = scg.id_prttmpl");
		sql.append(" where (scg.id_dep = ? or scg.id_dep  = '~' or scg.id_dep  is null)");
		if(IScDictCodeConst.SD_RPTTMPL_BAR.equals(mtAppDTO.getSd_rpttp())){//条码
			sql.append(" and scg.sd_rpttp = '02' ");
		}else if(IScDictCodeConst.SD_RPTTMPL_NOTE.equals(mtAppDTO.getSd_rpttp())){
			sql.append(" and scg.sd_rpttp = '01' ");
		}
		sql.append(" and (scg.id_scca = ? or scg.id_scca  = '~' or scg.id_scca  is null)");
		sql.append(" and (scg.id_scsrv = ? or scg.id_scsrv  = '~' or scg.id_scsrv  is null)");
		sql.append(" and (scg.ids_bdsrv like ? or scg.ids_bdsrv = '~' or scg.ids_bdsrv is null )");
		sql.append(" and scg.id_org = ? ");
		sql.append(" and scg.fg_active = 'Y' ");
		sql.append(" order by scg.level_pri desc");
		param.addParam(mtAppDTO.getId_dep_mp());
		param.addParam(mtAppDTO.getId_scca());
		param.addParam(mtAppDTO.getId_scsrv());
		param.addParam("%"+mtAppDTO.getId_srv()+"%");
		param.addParam(ScContextUtils.getOrgId());
		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(),param,new ColumnListHandler());
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
}
