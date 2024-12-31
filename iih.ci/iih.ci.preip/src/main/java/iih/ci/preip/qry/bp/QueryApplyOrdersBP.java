package iih.ci.preip.qry.bp;

import java.util.List;

import iih.ci.core.utils.ObjectUtils;
import iih.ci.preip.qry.CiPreIPQryRst;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;

/**
 * 预住院查询申请项目逻辑实现
 * @author wangqingzhu
 *
 */
public class QueryApplyOrdersBP {

	/**
	 * 查询预住院申请医嘱执行实现逻辑
	 * @param id_en
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public CiPreIPQryRst[] exec(String id_en, String code_entp) throws BizException{
		// TODO: 编写预住院申请医嘱信息的查询逻辑
		List<CiPreIPQryRst> rstList = new SqlParamBuilder().select("code_or, bdsrv.code code_srv, name_or")
		.from("ci_ts_or").alias("ord")
		.leftJoin("bd_srv bdsrv", "bdsrv.id_srv = ord.id_srv")
		.where("ord.id_en", id_en)//.and("ord.code_entp", code_entp)
		.and("ord.fg_canc","N")
		.Q(CiPreIPQryRst.class);
		
		if(ObjectUtils.isEmpty(rstList)) {
			return null;
		}
		return rstList.toArray(new CiPreIPQryRst[1]);
	}
}
