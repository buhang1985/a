package iih.bd.srv.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.emrterm.d.EmrTermDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取术语查询结果
 * 
 * @author hums
 *
 */
public class GetEmrTermQry implements ITransQry {

	private EmrTermDO emrTermDO;
	private String inputStr;

	@SuppressWarnings("unused")
	private GetEmrTermQry() {

	}

	/**
	 * 术语查询构造函数
	 * 
	 * @param emrTermDO
	 *            术语查询必要条件
	 * @param inputStr
	 *            输入查询条件，匹配术语编码、名称
	 */
	public GetEmrTermQry(EmrTermDO emrTermDO, String inputStr) {
		this.emrTermDO = emrTermDO;
		this.inputStr = inputStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		// 术语体系
		param.addParam(emrTermDO.getSd_mrtermsys());
		// 启用标识
		param.addParam(FBoolean.TRUE);
		// 病例术语分类
		if (StringUtils.isNotBlank(emrTermDO.getId_mratermca())) {
			param.addParam(emrTermDO.getId_mratermca());
		}
		// 病例术语分组
		if (StringUtils.isNotBlank(emrTermDO.getId_mratermgrp())) {
			param.addParam(emrTermDO.getId_mratermgrp());
		}
		// 输入查询条件
		if (StringUtils.isNotBlank(inputStr)) {
			// 对应code
			param.addParam( inputStr + "%");
			// 对应name
			param.addParam( inputStr + "%");
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		// 拼接术语查询语句
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from bd_mra_term where");
		// 术语体系、术语分类、术语分组、启用标识
		buffer.append(" sd_mrtermsys = ? and fg_active = ?");
		
		// 病例术语分类
		if (StringUtils.isNotBlank(emrTermDO.getId_mratermca())) {
			buffer.append(" and id_mratermca = ? ");
		}

		// 病例术语分组
		if (StringUtils.isNotBlank(emrTermDO.getId_mratermgrp())) {
			buffer.append("and id_mratermgrp = ? ");
		}
		// 通过输入查询条件过滤编码、名称
		if (StringUtils.isNotBlank(inputStr)) {
			buffer.append(" and ( code like ? or name like ?)");
		}

		return buffer.toString();
	}

}
