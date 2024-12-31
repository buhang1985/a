package iih.en.er.bp.enprquery;

import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErBasic4EditDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 通过预检id获取预检信息
 * 
 * @author fanlq
 *
 */
public class GetEnErBasicInfoBP {
	/***
	 * 通过预检id获取预检信息
	 * @param id_erpre 预检id
	 * @return
	 * @throws BizException 
	 */
	public EnErBasic4EditDTO exec(String id_erpre) throws BizException{
		if(EnValidator.isEmpty(id_erpre)) return new EnErBasic4EditDTO();
		StringBuffer sql = new StringBuffer();
		sql.append("select pre.fg_refuse_exa as Fg_refuse_exa, ");
		sql.append("pre.des_cmpt as Des_cmpt, " );
		sql.append("cons.id_udidoc as Id_level_sense, " );
		sql.append("cons.code as Sd_level_sense, " );
		sql.append("cons.name as Level_sense " );
		sql.append("from en_erpre pre " );
		sql.append("left join nmr_pkuf_earlywarn pkuf on pkuf.id_ent = pre.id_erpre " );
		sql.append("left join bd_udidoc cons on cons.id_udidoc = pkuf.id_conscious ");
		sql.append("where pre.id_erpre = ? " );
		SqlParam param = new SqlParam();
		param.addParam(id_erpre);
		@SuppressWarnings("unchecked")
		List<EnErBasic4EditDTO> list = (List<EnErBasic4EditDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnErBasic4EditDTO.class));
		return list !=null && list.size() > 0 ? list.get(0):new EnErBasic4EditDTO();
	}
}
