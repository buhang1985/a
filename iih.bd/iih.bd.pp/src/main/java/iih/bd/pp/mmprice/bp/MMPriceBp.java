package iih.bd.pp.mmprice.bp;

import java.util.List;

import iih.bd.pp.mmprice.d.PriSrvRelMMDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MMPriceBp {

	@SuppressWarnings("unchecked")
	public PriSrvRelMMDTO[] GetDTOsByIDSrv(String id_srv) throws BizException{
		
		StringBuilder builder=new StringBuilder();
		//已经没有BD_SRV_REL_MM表了
//		builder.append("SELECT SM.ID_SRV,SM.SORTNO,SM.ID_DEP,SM.ID_MM,");
//		builder.append("DEP.NAME AS DEP_NAME,SUP.NAME AS SUP_NAME,");
//		builder.append("MM.NAME,MM.SPEC,MM.ID_SUP,MM.PRICE ");
//		builder.append("FROM BD_SRV_REL_MM SM ");
//		builder.append("INNER JOIN BD_MM MM ON SM.ID_MM=MM.ID_MM AND SM.ID_SRV=? ");
//		builder.append("LEFT JOIN BD_DEP DEP ON SM.ID_DEP=DEP.ID_DEP ");
//		builder.append("LEFT JOIN BD_SUP SUP ON MM.ID_SUP=SUP.ID_SUP ");
//		builder.append("ORDER BY SM.SORTNO");
		
		builder.append("SELECT SM.ID_SRV,Rownum SORTNO,");
		builder.append("MMC.ID_DEP,");
		builder.append("MM.ID_MM,");
		builder.append("DEP.NAME AS DEP_NAME,");
		builder.append("SUP.NAME AS SUP_NAME,");
		builder.append("MM.NAME,MM.SPEC,MM.ID_SUP,MM.PRICE ");
		builder.append("FROM BD_SRV SM ");
		builder.append("INNER JOIN BD_MM MM  ON SM.ID_SRV=MM.ID_SRV AND SM.ID_SRV=? ");
		builder.append("LEFT JOIN BD_SUP SUP ON MM.ID_SUP=SUP.ID_SUP ");
		builder.append("LEFT JOIN bd_mm_ctr MMC ON MM.ID_MM=MMC.ID_MM ");
		builder.append("LEFT JOIN BD_DEP DEP ON MMC.ID_DEP=DEP.ID_DEP ");		
		
		String sql=builder.toString();

		SqlParam param=new SqlParam();
		param.addParam(id_srv);
		
		List<PriSrvRelMMDTO> list=(List<PriSrvRelMMDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(PriSrvRelMMDTO.class));
		
		if(list!=null&&list.size()>0)
		{
			return list.toArray(new PriSrvRelMMDTO[0]);
		}
		
		return null;
	}
}
