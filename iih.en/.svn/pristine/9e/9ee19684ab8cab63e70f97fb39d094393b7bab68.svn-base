package iih.en.er.bp.pre;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 *  获取患者在院抢救预检信息
 * 
 * @author liubin
 *
 */
public class GetErPreOfInHosEtFstaidBP {
    /**
     * 获取患者在院抢救预检信息
     * 
     * @param patId
     * @return
     */
	public EnErPreDO exec(String patId) throws BizException {
		if(EnValidator.isEmpty(patId)) 
			return null;
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append("select pre.* from en_erpre pre ");
		sql.append("inner join en_ent ent on ent.id_ent = pre.id_ent_last " );
		sql.append("inner join en_ent_op_er er on er.id_ent = ent.id_ent " );
		sql.append("where ent.code_entp = ? " );
		sql.append("and ent.fg_canc = ? " );
		sql.append("and er.id_bed is not null " );
		sql.append("and er.id_bed <> '~' " );
		sql.append("and ent.dt_end is null " );
		sql.append("and ent.sd_status <> ? " );
		sql.append("and pre.id_pat = ? ");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		param.addParam(FBoolean.FALSE);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		param.addParam(patId);
		// 查询数据
		@SuppressWarnings("unchecked")
		List<EnErPreDO> result = (List<EnErPreDO>) new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(EnErPreDO.class));
		return EnValidator.isEmpty(result) ? null : result.get(0);
	}
}
