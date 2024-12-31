package iih.bl.cg.blcgquery.Service.s;
import java.util.List;
import iih.bl.cg.blcgquery.Service.d.CreateBlcgqueryDTO;
import iih.bl.cg.blcgquery.Service.i.IBLBlcgqueryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
@Service(serviceInterfaces={IBLBlcgqueryService.class}, binding=Binding.JSONRPC)
public class IBLBlcgqueryServiceImpl<CreateInvoiceDTO> implements IBLBlcgqueryService {
	
	public CreateBlcgqueryDTO[] blcgFindByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException {
		//System.out.println("==================================");
    	String sql = "select"
				      +"a.code,"
				      +"a.name,"
				      +"b.dt_acpt,"
				      +"b.id_pripat,"      
				      +"c.id_dep_phydisc,"
				      +"d.amt_prepay - d.amt_uncg surplus"
				      +"from pi_pat a, en_ent b, EN_ENT_IP c, en_ent_acc d"
				      +" where a.id_pat = b.id_pat"
				      +" and b.id_ent = c.id_ent"
				      +"and b.id_ent = d.id_ent";

		StringBuffer bb =new StringBuffer();
		bb.append(sql);
		String[] attrNames= qryRootNodeDTO.getAttrNames();
		if(attrNames != null && attrNames.length > 0){
			for (int i = 0; i< attrNames.length; i++) {
				String attrName = attrNames[i];
				bb.append(qryRootNodeDTO.getAttrVal(attrName));
				if(i < (attrNames.length - 1)){
					bb.append(" and");
				}			
			}
		}

		sql=bb.toString();
		
		List<CreateBlcgqueryDTO> list  = (List<CreateBlcgqueryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(CreateBlcgqueryDTO.class));
		return list.toArray(new CreateBlcgqueryDTO[0]);
		
	}
		
}
