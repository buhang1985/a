package iih.bd.srv.s.bp.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.emrterm.d.EmrTermCaDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取术语分类树数据
 * @author hums
 *
 */
public class GetEmrTermCaTreeQry implements ITransQry{

	private EmrTermCaDO emrTermCaDO;
	
	@SuppressWarnings("unused")
	private GetEmrTermCaTreeQry(){
		
	}
	
	/**
	 * 术语分类查询构造方法
	 * @param emrTermCaDO 术语分类查询条件
	 */
	public GetEmrTermCaTreeQry(EmrTermCaDO emrTermCaDO ){
		this.emrTermCaDO = emrTermCaDO;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam param = new SqlParam();
		
		// 术语体系编码
		param.addParam(emrTermCaDO.getSd_mrtermsys());
		// 适用范围：个人、科室、全院
		param.addParam(emrTermCaDO.getSd_scopetp());
		// 启用标识
		param.addParam(FBoolean.TRUE);
		// 所属科室
		if(StringUtils.isNotBlank(emrTermCaDO.getId_dep())){
			param.addParam(emrTermCaDO.getId_dep());
		}
		// 创建人
		if(StringUtils.isNotBlank(emrTermCaDO.getCreatedby())){
			param.addParam(emrTermCaDO.getCreatedby());
		}
		// 可使用标识-门诊
		if(emrTermCaDO.getFg_entp_op() != null){
			param.addParam(emrTermCaDO.getFg_entp_op());
		}
		// 可使用标识_住院
		if(emrTermCaDO.getFg_entp_ip() != null){
			param.addParam(emrTermCaDO.getFg_entp_ip());
		}
		// 可使用标识_急诊
		if(emrTermCaDO.getFg_entp_er() != null){
			param.addParam(emrTermCaDO.getFg_entp_er());
		}
		// 可使用标识_家床
		if(emrTermCaDO.getFg_entp_fm() != null){
			param.addParam(emrTermCaDO.getFg_entp_fm());
		}
		// 可使用标识_体检
		if(emrTermCaDO.getFg_entp_pe() != null){
			param.addParam(emrTermCaDO.getFg_entp_pe());
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from bd_mra_termca where");
		buffer.append(" sd_mrtermsys = ? and sd_scopetp = ? and fg_active = ?");
		
		// 所属科室
		if(StringUtils.isNotBlank(emrTermCaDO.getId_dep())){
			buffer.append(" and id_dep = ?");
		}
		// 创建人
		if(StringUtils.isNotBlank(emrTermCaDO.getCreatedby())){
			buffer.append(" and id_emp = ?");
		}
		// 可使用标识-门诊
		if(emrTermCaDO.getFg_entp_op() != null){
			buffer.append(" and fg_entp_op = ?");
		}
		// 可使用标识_住院
		if(emrTermCaDO.getFg_entp_ip() != null){
			buffer.append(" and fg_entp_ip = ?");
		}
		// 可使用标识_急诊
		if(emrTermCaDO.getFg_entp_er() != null){
			buffer.append(" and fg_entp_er = ?");
		}
		// 可使用标识_家床
		if(emrTermCaDO.getFg_entp_fm() != null){
			buffer.append(" and fg_entp_fm = ?");
		}
		// 可使用标识_体检
		if(emrTermCaDO.getFg_entp_pe() != null){
			buffer.append(" and fg_entp_pe = ?");
		}
		
		return buffer.toString();
	}

}
