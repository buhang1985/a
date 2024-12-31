package iih.bl.hp.s.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bl.hp.dto.d.DocInfoDTO;


public class GetDocsListBp {
   public PagingRtnData<DocInfoDTO>  exec(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException{
	   IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryNode);
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from (  ");
		sql.append("    select psn.id_psndoc, psn.code ,psn.name ,case when  phy.fg_presrt= 'Y' then '1' else '0' end as fg_presrt, udi.code as sexstr, udi.id_udidoclist,psn.mobile         ");
		sql.append("    from  bd_psndoc  psn                                                        ");
		sql.append("    join  bd_emp_phy  phy on psn.id_psndoc = phy.id_psndoc                                                      ");
		sql.append("    join  bd_udidoc   udi on psn.sex =udi.id_udidoc )                           ");
		sql.append("                                                                          ");
		sql.append("                                                                       ");
		sql.append("                                                                    ");
		sql.append("                                                                         ");
		if (whereStr == null) {
			sql.append(" where   id_udidoclist ='@@@@ZZ20000000000035'  ");
		} else {
			sql.append(" where     ");
			sql.append(whereStr);
			sql.append(" and  id_udidoclist ='@@@@ZZ20000000000035' ");
		}

		

		DocInfoDTO incdto = new DocInfoDTO();
		PagingServiceImpl<DocInfoDTO> pagingServiceImpl = new PagingServiceImpl<DocInfoDTO>();

		PagingRtnData<DocInfoDTO> prd = pagingServiceImpl.findByPageInfo(incdto, pg, sql.toString(), "", null);
		return prd;
  }
}
