package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检查就诊是否为持卡社保BP
 * 
 * @author zhengcm
 * @date 2017-11-20 09:26:42
 *
 */
public class CheckEntIsHpCardstBP {

	/**
	 * 检查就诊是否为持卡社保
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:26:58
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_ent) throws BizException {
		// 检查参数
		EnValidator.validateParam("id_ent", id_ent);

		// 查询数据
		List<PatiVisitDO> datas = this.queryDatas(id_ent);

		// 校验
		if (!EnValidator.isEmpty(datas)) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}

	/**
	 * 查询数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:38:55
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PatiVisitDO> queryDatas(String id_ent) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ent.* ");
		sb.append("from ");
		sb.append("en_ent ent ");
		sb.append("inner join bd_hp hp on hp.id_hp = ent.id_hp ");
		sb.append("where ");
		sb.append("hp.sd_hptp like '1%' ");
		sb.append("and hp.fg_cardst = 'Y' ");
		sb.append("and ent.id_ent = ? ");
		SqlParam params = new SqlParam();
		params.addParam(id_ent);
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(PatiVisitDO.class));
		return list;
	}
}
