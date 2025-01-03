package iih.bd.srv.s.bp.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.ortmplquerydto.d.OrTmplQueryDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医嘱模板分类树数据
 */
public class GetOrTmplCaTreeByEntpQry implements ITransQry{

	private OrTmplQueryDTO querydto;
	/**
	 * 构造方法
	 */
	public GetOrTmplCaTreeByEntpQry(OrTmplQueryDTO querydto){
		this.querydto = querydto;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		// 科室
		if(StringUtils.isNotBlank(this.querydto.getId_dep())){
			param.addParam(this.querydto.getId_dep());
		}
		// 个人
		if(StringUtils.isNotBlank(this.querydto.getId_emp())){
			param.addParam(this.querydto.getId_emp());
		}
		if(FBoolean.TRUE.equals(this.querydto.getFg_active())){
			param.addParam(this.querydto.getFg_active());
		}
		return param;
	}
	
	@Override
	public String getQrySQLStr() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select t1.Id_ortmplcarel,t1.Id_ortmplca,t1.Fg_sync as Fg_sync_carel,t2.Id_ortmpl,t2.Sd_ortmpltp,t2.Name,t2.Fg_entp_op,t2.Fg_entp_ip,t2.Fg_entp_er,t2.Fg_entp_pe,t2.Fg_entp_fm from bd_srv_ortmpl_ca_rel t1 left join bd_srv_ortmpl t2 on t1.Id_ortmpl = t2.Id_ortmpl where");
		buffer.append(" t2.Fg_sync = 'N'");
		buffer.append(" and t2.Id_grp = '"+this.querydto.getId_grp()+"' and t2.Id_org = '"+this.querydto.getId_org()+"'");

		// 科室
		if(StringUtils.isNotBlank(this.querydto.getId_dep())){
			buffer.append(" and t2.Id_dep = ?");
		}
		// 个人
		if(StringUtils.isNotBlank(this.querydto.getId_emp())){
			buffer.append(" and t2.Id_emp = ?");
		}
		// 所属分类
		if(StringUtils.isNotBlank(this.querydto.getId_ortmplca())){
			buffer.append(" and t1.Id_ortmplca in ("+this.querydto.getId_ortmplca()+")");
		}
		if(FBoolean.TRUE.equals(this.querydto.getFg_active())){
			buffer.append(" and t2.fg_active=? ");
		}
		if(StringUtils.isNotBlank(this.querydto.getCode_entp())){
			buffer.append(getCodeEntpStr(this.querydto.getCode_entp()));
		}
		buffer.append(" order by t2.Seqno");
		
		return buffer.toString();
	}
	public String getCodeEntpStr(String code_entp){
		String str = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			str += " and t2.fg_entp_op='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			str += " and t2.fg_entp_er='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			str += " and t2.fg_entp_er1='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			str += " and t2.fg_entp_er2='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			str += " and t2.fg_entp_ip='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			str += " and t2.fg_entp_fm='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			str += " and t2.fg_entp_pe='Y' ";
			break;
		}
		return str;
	}
}
