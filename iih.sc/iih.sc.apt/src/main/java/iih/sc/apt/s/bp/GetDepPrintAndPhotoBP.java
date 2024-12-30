package iih.sc.apt.s.bp;

import java.util.List;

import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.MtResDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预约确认后 查询 是否自动打印和自动拍照
 * @param id_apt
 * @return
 * @throws BizException
 */
public class GetDepPrintAndPhotoBP {

	/**
     * 预约确认后 查询 是否自动打印和自动拍照
     * @param id_apt
     * @return
	 * @throws DAException 
     * @throws BizException
     */
	public MtResDTO exec(String id_apt) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select par.fg_auto_prn,par.fg_auto_prn_bar,par.fg_auto_pho from sc_apt apt ");
		sql.append(" inner join sc_apt_appl appl on apt.id_apt = appl.id_scapt");
		sql.append(" inner join sc_dep_param par on par.id_scca = apt.id_scca and par.id_dep = appl.id_dep_mp");
		sql.append(" where apt.id_apt = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		List<MtResDTO> list = (List<MtResDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MtResDTO.class));
		MtResDTO result = new MtResDTO();
		if(list == null || list.size() == 0)
		{
			result.setFg_auto_pho(FBoolean.FALSE);
			result.setFg_auto_prn(FBoolean.FALSE);
			result.setFg_auto_prn_bar(FBoolean.FALSE);
		}
		else
		{
			result.setFg_auto_pho(list.get(0).getFg_auto_pho());
			result.setFg_auto_prn(list.get(0).getFg_auto_prn());
			result.setFg_auto_prn_bar(list.get(0).getFg_auto_prn_bar());
		}
		return result;
	}
}
