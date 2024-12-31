package iih.ci.mr.cimr.s;

import java.util.List;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICimrDoPrintService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取替换的病历模板流
 */
@Service(serviceInterfaces={ICimrDoPrintService.class}, binding=Binding.JSONRPC)
public class CimrDoPrintServiceImpl implements ICimrDoPrintService{

	@Override
	public CiMrDO[] getCimrDo(String id_ent, String Id_mrcactm)
			throws BizException {
		
		if(id_ent==null||Id_mrcactm==null) return null;
		
		String sql= " select ed.dll_path,ed.name_class,su1.name as createby_name, bu.name as su_mr_name,bm.name as MRTP_NAME,su.name as MODIFIEDBY_NAME,c.* from ci_mr c"
                   //+" join  BD_MRCA_CTM_ITM bmci on( c.id_mrtp=bmci.id_mrtp)"
                   //+" join  BD_MRCA_CTM  bmc on( bmci.id_mrcactm=bmc.id_mrcactm)"
                   +" join  BD_MRCA_CTM  bmc on( c.id_mrcactm=bmc.id_mrcactm)"
                   +" join  BD_MRTP  bm  on ( c.id_mrtp=bm.id_mrtp)"
                   +" join  BD_MRED  ed  on ( c.id_mred=ed.id_mred)"
                   +" join  SYS_USER  su   on(su.id_user=c.modifiedby)"
                   +" join  SYS_USER  su1   on(su1.id_user=c.createdby)" 
                   +" join  BD_UDIDOC bu on(c.id_su_mr=bu.ID_UDIDOC)"
                   +" where c.ds=0 and c.id_ent = '"+id_ent+"'  and  bmc.id_mrcactm like '"+Id_mrcactm+"' "
                   +" order by bmc.sortno,c.dt_rd";
		List<CiMrDO> list= (List<CiMrDO>)new DAFacade().execQuery(sql, new BeanListHandler(CiMrDO.class));
		if(list.size()>0) return list.toArray(new CiMrDO[0]);
		return null;
	}

}
