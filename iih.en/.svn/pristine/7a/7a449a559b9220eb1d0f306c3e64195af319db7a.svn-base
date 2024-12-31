package iih.en.doc.s.bp.preg.qry;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeTypeConst;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 根据条件查询建档信息
 * 
 * @author fanlq
 *
 */
public class GetPregDocInfoBP {
	/**
	 * 根据条件查询建档信息
	 * 
	 * @param d_begin
	 *            开始日期
	 * @param d_end
	 *            结束日期
	 * @param isTexted
	 *            是否发短信
	 * @return
	 * @throws BizException
	 */
	public PregDocInfoDTO[] exec(FDateTime d_begin, FDateTime d_end, FBoolean isTexted) throws BizException {
		// 参数检查
		EnValidator.validateParam("d_begin", d_begin);
		EnValidator.validateParam("d_end", d_end);
		EnValidator.validateParam("isTexted", isTexted);

		List<PregDocInfoDTO> preDoclist = this.queryPreDoclist(d_begin, d_end, isTexted);
		if (preDoclist.isEmpty()) {
			return null;
		}

		// 设置预约状态和就诊状态名称
		this.setStatusName(preDoclist);

		return preDoclist.toArray(new PregDocInfoDTO[] {});
	}

	/**
	 * 查询建档未就诊列表
	 * 
	 * @param d_begin
	 * @param d_end
	 * @param isTexted
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PregDocInfoDTO> queryPreDoclist(FDateTime d_begin, FDateTime d_end, FBoolean isTexted) throws BizException {
		// 查询Sql
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select distinct ");
		sqlBuilder.append("apt.id_apt,");
		sqlBuilder.append("doc.id_pat,");
		sqlBuilder.append("doc.id_entdoc,");
		sqlBuilder.append("pat.code  Code_pat,");
		sqlBuilder.append("doc.name_pat  Name_pat,");
		sqlBuilder.append("doc.telno_pat Telno_pat,");
		sqlBuilder.append("preg.d_expect D_expect,");
		sqlBuilder.append("preg.dt_doc Dt_doc,");
		sqlBuilder.append("ent.dt_entry Dt_acpt,");
		sqlBuilder.append("op.sd_status  Sd_status,");
		sqlBuilder.append("preg.dt_appt  Dt_appt,");
		sqlBuilder.append("apt.sd_status Sd_status_apt,");
		sqlBuilder.append("case when flup.id_pat is null then '' else '已发送' end as Note_status ");
		sqlBuilder.append("from en_doc doc ");
		sqlBuilder.append("left join en_doc_preg preg on doc.id_entdoc = preg.id_entdoc ");
		sqlBuilder.append("left join en_doc_preg_stat stat on doc.id_entdoc = stat.id_entdoc ");
		sqlBuilder.append("left join sc_apt apt on stat.id_apt_last = apt.id_apt ");
		sqlBuilder.append("left join en_ent ent on ent.id_ent = stat.id_ent_last_op ");
		sqlBuilder.append("left outer join en_ent_op op on ent.id_ent = op.id_ent ");
		sqlBuilder.append("left join pi_pat pat on pat.id_pat = doc.id_pat ");
		sqlBuilder.append("left join en_doc_flup flup on flup.id_apt = apt.id_apt ");
		sqlBuilder.append("where apt.fg_canc = 'N' ");
		sqlBuilder.append("and apt.dt_b >= ? ");
		sqlBuilder.append("and apt.dt_b <= ? ");
		sqlBuilder.append("and apt.sd_status in (?,?) ");
		if (isTexted.booleanValue()) {
			sqlBuilder.append("and flup.id_pat is not null ");
		}

		// 查询参数
		SqlParam param = new SqlParam();
		param.addParam(d_begin);
		param.addParam(d_end);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);

		// 查询数据
		return (List<PregDocInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(PregDocInfoDTO.class));
	}

	/**
	 * 设置预约状态和就诊状态名称
	 * 
	 * @param preDoclist
	 * @throws BizException
	 */
	private void setStatusName(List<PregDocInfoDTO> preDoclist) throws BizException {
		UdiDocEP docep = new UdiDocEP();
		Map<String, UdidocDO> enmap = docep.getUdiDocsByCode(IEnDictCodeTypeConst.SD_STATUS);
		Map<String, UdidocDO> aptmap = docep.getUdiDocsByCode(IScDictCodeTypeConst.SD_STATUS_TP);
		for (PregDocInfoDTO obj : preDoclist) {
			if (enmap.get(obj.getSd_status()) != null) {
				obj.setName_status_en(enmap.get(obj.getSd_status()).getName());
			}
			if (aptmap.get(obj.getSd_status_apt()) != null) {
				obj.setName_status_apt(aptmap.get(obj.getSd_status_apt()).getName());
			}
		}
	}
}
