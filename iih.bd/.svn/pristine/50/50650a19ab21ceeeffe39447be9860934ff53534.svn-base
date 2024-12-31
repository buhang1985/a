package iih.bd.srv.mrtplseg.s.bp;

import java.util.List;

import iih.bd.srv.d.EmrTplSegTreeDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class MrTreeDataBp {
	public EmrTplSegTreeDTO[] exe(String id)throws BizException{
		
//		MrTreeDataSql sql = new MrTreeDataSql(id);
		
//		EmrTplSegTreeDTO[] rtn=(EmrTplSegTreeDTO[])AppFwUtil.getDORstWithDao(sql, EmrTplSegTreeDTO.class);
		
		String sql,sql1,sql2;
		List<EmrTplSegTreeDTO> list = null;
		if(id.equals("0001AA1000000000ELNR") ){
			sql = "    select dept.name name , sec.id_dep id_emrtpl ,count(*)  num  , '1'  id_parent  "+
					"    from  bd_mrtpl_sec sec ,bd_dep dept where sec.id_dep = dept.id_dep and  sec.id_owtp = '"+id+"'  and  sec.ds =0 "+
	                "    group by  dept.name,sec.id_dep ";
			list = (List<EmrTplSegTreeDTO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplSegTreeDTO.class));
		}
			
		else if(id.equals("0001AA1000000000ELNQ")){
			sql1 = "    select ps.name name, sec.id_emp id_emrtpl,count(*)  num  , '2'  id_parent  "+
					"    from  bd_mrtpl_sec sec ,bd_psndoc ps where sec.id_emp  = ps.id_psndoc and  sec.id_owtp = '"+id+"'  and  sec.ds =0 "+
	                "    group by  ps.name, sec.id_emp ";
			list = (List<EmrTplSegTreeDTO>)new DAFacade().execQuery(sql1, new BeanListHandler(EmrTplSegTreeDTO.class));
		}			
			
		else if(id.equals("0001AA1000000000ELNS")){
			sql2 = "  select dg.name name , sec.id_dep id_emrtpl ,count(*)  num  , '0'  id_parent  "+
					"    from  bd_mrtpl_sec sec ,BD_DG  dg where sec.id_owtp = dg.id_dg and  sec.id_owtp = '"+id+"'  and  sec.ds =0 "+
	                "    group by  dg.name, sec.id_dep ";
			list = (List<EmrTplSegTreeDTO>)new DAFacade().execQuery(sql2, new BeanListHandler(EmrTplSegTreeDTO.class));
		}
			
		
		
		return list.toArray(new EmrTplSegTreeDTO[0]);
	}
}
