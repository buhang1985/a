package iih.bl.hp.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.hp.dto.d.HpIpOepTransDTO;
import iih.bl.hp.dto.d.HpTransDetailsDTO;
import iih.mi.biz.mihptransact.d.MiHpTransActDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author HanJQ
 * @datetime 2018-10-16 21:38
 */
public class GetHpTransActBP {
	
	public HpIpOepTransDTO[] exec(String condition) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ( ");
		sb.append("select oeptran.id_trans_oep as ID_HPTRANSACT,  ");
		sb.append("  oeptran.BUSINESS_CODE,	nvl(oeptran.CODE_ENTP,'00') CODE_ENTP,	oeptran.ID_ENT,	oeptran.ENT_CODE, ");
		sb.append("  oeptran.HP_ENT_SERIAL_NO,	oeptran.DT_TRANSACT ,	oeptran.ID_EMP_OPR, ");
		sb.append("  oeptran.CODE_HIS,	oeptran.CODE_HP,	oeptran.FG_CANCEL,	oeptran.EU_DIRECT, ");
		sb.append("  oeptran.ID_PAR,	oeptran.ID_PAT,	oeptran.status_trans, ");
		sb.append("  oeptran.SRCFUNC_DES,	oeptran.CODE_MEDKIND, ");
		sb.append("  to_char(substr(oeptran.INPUTINFO,1,2000)) INPUTINFO, ");
		sb.append("  to_char(substr(oeptran.OUTPUTINFO,1,2000)) OUTPUTINFO ");
		sb.append("FROM	hp_transact_oep oeptran  ");
		sb.append("WHERE oeptran.ds = 0  ");
		sb.append("UNION ");
		sb.append("SELECT	iptran.ID_TRANS_IP as ID_HPTRANSACT, ");
		sb.append(" iptran.BUSINESS_CODE,	nvl(iptran.CODE_ENTP,'10') CODE_ENTP,	iptran.ID_ENT,	ENT_CODE, ");
		sb.append("	iptran.HP_ENT_SERIAL_NO,	iptran.DT_TRANSACT,	iptran.ID_EMP_OPR,  ");
		sb.append("	iptran.CODE_HIS,	iptran.CODE_HP,	iptran.FG_CANCEL,	iptran.EU_DIRECT,  ");
		sb.append("	iptran.ID_PAR,	iptran.ID_PAT,	iptran.status_trans,  ");
		sb.append("	iptran.SRCFUNC_DES,	iptran.CODE_MEDKIND,  ");
		sb.append("	to_char(substr(iptran.INPUTINFO,1,2000)) INPUTINFO,  ");
		sb.append("	to_char(substr(iptran.OUTPUTINFO,1,2000)) OUTPUTINFO  ");
		sb.append("FROM	HP_TRANSACT_IP iptran ");
		sb.append("WHERE iptran.ds = 0   ");
		sb.append("ORDER BY DT_TRANSACT DESC ");
		sb.append(")  where 1=1 ");
		if(StringUtils.isNotBlank(condition)){
			sb.append(" and ").append(condition);
		}
		DAFacade facade = new DAFacade();
		List<HpIpOepTransDTO> miHpTransActDoes = (List<HpIpOepTransDTO>) facade
				.execQuery(sb.toString(), new BeanListHandler(HpIpOepTransDTO.class));
		return miHpTransActDoes.toArray(new HpIpOepTransDTO[miHpTransActDoes.size()]);		
	}
}
