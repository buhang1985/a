package iih.bd.srv.freqdef.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.freqdef.d.FreqDefDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


public class GetFreqDefTreeDataBP  implements IBdSrvDictCodeTypeConst {

	/**
	 * 构造树模型
	 * @return
	 * @throws BizException
	 */
	public FreqDefDTO[] exec() throws BizException { 
		
		String sql ="select name, ID_UDIDOC as id ,null as id_parent,code as sd from BD_UDIDOC "
				+ "where ID_UDIDOCLIST = '"+SD_FREQUNIT+"'  "
				+ " union "
				+ "select name,ID_FREQ as id, ID_FREQUNITCT as id_parent,sd_frequnitct as sd from BD_FREQ order by sd";
		List<FreqDefDTO> list= (List<FreqDefDTO>)new DAFacade().execQuery(sql, new BeanListHandler(FreqDefDTO.class));
		return list.toArray(new FreqDefDTO[0]);
	}
}
