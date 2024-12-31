package iih.bl.st.hppireginfoimport.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bl.st.dto.d.BlEntInfoDTO;

public class BlEntInfoBp {
	
	@SuppressWarnings("unchecked")
	public BlEntInfoDTO[] getBlEntInfos(String dt_begin,String dt_end) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct A.DT_ACPT,D.CODE_HP,A.FG_ACPTVALID ")
		    .append("FROM EN_ENT A ")
		    .append("JOIN BL_CG_ITM_OEP B ON A.ID_ENT = B.ID_ENT ")
		    .append("JOIN BL_PROP_OEP C ON B.ID_STOEP = C.ID_STOEP ")
		    .append("JOIN BL_PROP_AR_OEP D ON C.ID_PROPOEP = D.ID_PROPOEP ")
		    .append("JOIN BD_HP E ON D.ID_HP = E.ID_HP AND E.SD_HPTP = '11' ")
		    .append("JOIN BL_ST_OEP F ON F.ID_STOEP = B.ID_STOEP AND F.EU_DIRECT = '1' AND F.EU_STTP = '31'")
		    .append("WHERE A.CODE_ENTP in ('00','01') ")
		    .append("AND A.DT_ACPT >= ? ")
		    .append("AND A.DT_ACPT <= ? ")
		    .append("AND A.FG_ACPTVALID = 'Y' ")
		    .append("AND A.FG_CANC = 'N' ")
		    .append("ORDER BY A.DT_ACPT ");
		SqlParam sqlp=new SqlParam();
		sqlp.addParam(dt_begin);
		sqlp.addParam(dt_end);
		List<BlEntInfoDTO> list = (List<BlEntInfoDTO>)new DAFacade().execQuery(sql.toString(),sqlp, new BeanListHandler(BlEntInfoDTO.class));
		return list.toArray(new BlEntInfoDTO[]{});
	}
	
}
