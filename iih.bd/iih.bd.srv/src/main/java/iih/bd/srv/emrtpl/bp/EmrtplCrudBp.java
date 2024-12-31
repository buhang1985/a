package iih.bd.srv.emrtpl.bp;

import java.util.List;

import iih.bd.srv.d.EmrTplTreeDTO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.emrtpl.bp.qry.EmrTplSrvPriDtoQry;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class EmrtplCrudBp {
	
	
	
	public EmrtplAggDO[] setCopyEmrTpl(EmrtplAggDO aggdos)
			throws BizException {

		EmrTplDO  emrTplDO = aggdos.getParentDO();
		emrTplDO.setVer(null);
		emrTplDO.setSd_su_mrptl("1");
		/*emrTplDO.setVer(emrTplDO.getVer()+1);
		emrTplDO.setFg_active(FBoolean.TRUE);*/
		DAFacade cade = new DAFacade();
		 cade.insertDO(emrTplDO);
		 //emrTplDOOld.setFg_active(FBoolean.FALSE);
		// cade.updateDO(emrTplDOOld);
		//List<EmrtplAggDO> list= (List<EmrtplAggDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrtplAggDO.class));
		
		return null;
	}
	
	public EmrTplTreeDTO[] getEmrTpTreeList(String Id_own) throws BizException {
		// TODO Auto-generated method stub
		String sql = "select  p.id_mrtp,p.code,p.name, l.sd_owtp, (case p.id_parent when '~'  then '0'"+
						"else  p.id_parent end ) id_parent"+
						" ,count(*) num    from bd_mrtp p,bd_mrtpl l  where p.ds = 0 and p.id_mrtp = l.id_mrtp"+
						"  and l.id_owtp='"+Id_own+"'"+
						"group by l.sd_owtp, p.id_mrtp,p.code,p.name,p.id_parent";
							 
		List<EmrTplTreeDTO> list= (List<EmrTplTreeDTO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplTreeDTO.class));
		return list.toArray(new EmrTplTreeDTO[0]);
	   }
		
	
	  public DiagDefDO[] GetDiagDefDo(String Id_mrtpl)throws BizException{
		  
		  EmrTplSrvPriDtoQry qry = new EmrTplSrvPriDtoQry(Id_mrtpl,"Id_mrtpl");
		  
		  DiagDefDO[] rtn=(DiagDefDO[])AppFwUtil.getDORstWithDao(qry, DiagDefDO.class);
				  
		  return rtn;
		  
	  }
	
}
