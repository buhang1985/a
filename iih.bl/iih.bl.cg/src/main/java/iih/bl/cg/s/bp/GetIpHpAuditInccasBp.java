package iih.bl.cg.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取住院医保审核账单项目
 * @author hanjq
 *
 */
public class GetIpHpAuditInccasBp {
	
	private FBoolean fgMomBBMerge;
	public GetIpHpAuditInccasBp() {
		this.fgMomBBMerge = BlParams.BLSTIP0005();
	}

	public BlStIpInccaInfoDTO[] exec(String wherePart) throws DAException {
		if(StringUtils.isBlank(wherePart)){
			throw new DAException("查询条件不能为空 ");
		}
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) daf.execQuery(getQrySQLStr(wherePart), new BeanListHandler(BlStIpInccaInfoDTO.class));
		BlStIpInccaInfoDTO[] array = new BlStIpInccaInfoDTO[0];
		if(list != null && list.size() > 0){
			return list.toArray(array);
		}
		return array;
	}
	
	public String getQrySQLStr(String wherePart) {
		StringBuilder sql = new StringBuilder();
		if(FBoolean.TRUE.equals(this.fgMomBBMerge)){
			sql.append(" select cg.name_inccaitm, cg.code_inccaitm, sum(cg.amt_ratio) amt_ratio				");
			sql.append(" ,sum(cg.amt_hp) amt_hp	,sum(cg.amt_pat) amt_pat									");
			sql.append(" from (	");
			sql.append(" select cg.name_inccaitm, cg.code_inccaitm, cg.amt_ratio * cg.eu_direct amt_ratio	");
			sql.append("	,decode(cg.fg_hp,'Y',cg.amt_ratio * cg.eu_direct,0) amt_hp 					");
			sql.append("	,decode(cg.fg_selfpay,'Y',cg.amt_ratio * cg.eu_direct,0) amt_pat				");
			sql.append("from bl_cg_ip cg			");
			sql.append("where cg.fg_real = 'Y'		");			
			sql.append(" and ").append(wherePart).append(" 	");
			
			sql.append("	union all	");
			
			sql.append(" select bb.name_inccaitm, bb.code_inccaitm, bb.amt_ratio * bb.eu_direct amt_ratio	");
			sql.append("	,decode(bb.fg_hp,'Y',bb.amt_ratio * bb.eu_direct,0) amt_hp 					");
			sql.append("	,decode(bb.fg_selfpay,'Y',bb.amt_ratio * bb.eu_direct,0) amt_pat				");
			sql.append("from bl_cg_ip cg			");
			sql.append("join bl_cg_ip bb on bb.id_ent_mom = cg.id_ent			");			
			sql.append("where cg.fg_real = 'Y'	and bb.fg_real = 'Y'	");			
			sql.append(" and ").append(wherePart).append(" 	");
			sql.append(" ) cg	");
			sql.append("group by cg.name_inccaitm, cg.code_inccaitm		");
		}else{
			sql.append(" select cg.name_inccaitm, cg.code_inccaitm, sum(cg.amt_ratio * cg.eu_direct) amt_ratio	");
			sql.append("	,sum(decode(cg.fg_hp,'Y',cg.amt_ratio * cg.eu_direct,0)) amt_hp 					");
			sql.append("	,sum(decode(cg.fg_selfpay,'Y',cg.amt_ratio * cg.eu_direct,0)) amt_pat				");
			sql.append("from bl_cg_ip cg			");
			sql.append("where cg.fg_real = 'Y'		");			
			sql.append(" 	and ").append(wherePart).append(" 	");
			sql.append("group by cg.name_inccaitm, cg.code_inccaitm		");
		}		

		return sql.toString();
	}

}
