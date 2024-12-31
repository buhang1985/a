package iih.ci.mrqc.qaflt.s;

import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltRServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

@Service(serviceInterfaces={IQafltRServiceExt .class}, binding=Binding.JSONRPC)
public class QafltRServiceExtImpl implements IQafltRServiceExt {
	
	@Override
	public QaFltDO findUserAndDept( String id_ent) throws BizException {
	    	DAFacade daf = new DAFacade();  	
	    	StringBuilder sql = new StringBuilder();
					sql.append("select p.id_dep as id_rfm_dept,\n");
					sql.append("       p.id_psndoc as id_rfm_user\n");	
					sql.append("  from bd_psndoc p\n"); 		
					sql.append("  where p.id_psndoc in\n ");
					sql.append("  （select c.id_author\n");
					sql.append("     from ci_mr_fp c\n");
					sql.append("     where c.id_ent = '"+id_ent+"')\n");
					String sqlStr=sql.toString();
	       QaFltDO qaFltDO = (QaFltDO) daf.execQuery(sqlStr, new BeanHandler(QaFltDO.class));
	      
	       return qaFltDO;	       
	}
	
	@Override
	public QaFltDO findUserAndDeptNoCimrfp( String id_ent) throws BizException{	
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("select ee.id_dep_phy as id_rfm_dept,\n");
				sql.append("       ee.id_emp_phy as id_rfm_user\n");	
				sql.append("  from en_ent ee\n"); 		
				sql.append("  where ee.id_ent = '"+id_ent+"'\n");
				String sqlStr=sql.toString();
       QaFltDO qaFltDO = (QaFltDO) daf.execQuery(sqlStr, new BeanHandler(QaFltDO.class));      
       return qaFltDO;	      
	}
}