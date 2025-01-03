package iih.bd.srv.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医嘱模板分类树数据
 */
public class GetOrTmplCaTreeQry  implements ITransQry{

	private String code_entp;
	private String id_grp;//集团
	private String id_org;//组织
	private String id_dep;//科室
	private String id_emp;//个人
	private String id_ortmplca;//医嘱模板分类
	private FBoolean bFgactive;
	
	@SuppressWarnings("unused")
	private GetOrTmplCaTreeQry(){
		
	}
	
	/**
	 * 构造方法
	 */
	public GetOrTmplCaTreeQry(String code_entp, String id_grp,String id_org,String id_srvorrt,String id_dep,String id_emp,String id_ortmplca, FBoolean bFgactive){
		this.code_entp = code_entp;
		this.id_grp = id_grp;
		this.id_org = id_org;
		this.id_dep=id_dep;
		this.id_emp=id_emp;
		this.id_ortmplca=id_ortmplca;
		this.bFgactive = bFgactive;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		// 集团
//		param.addParam(id_grp);
//		// 组织
//		param.addParam(id_org);
//		// 适用范围
//		// param.addParam(id_srvorrt);
//		// 科室
//		if(StringUtils.isNotBlank(id_dep)){
//			param.addParam(id_dep);
//		}
//		// 个人
//		if(StringUtils.isNotBlank(id_emp)){
//			param.addParam(id_emp);
//		}
//		if(StringUtils.isNotBlank(id_ortmplca)){
//			param.addParam(id_ortmplca);
//		}
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t1.Id_ortmplcarel,t1.Id_ortmplca,t1.Fg_sync as Fg_sync_carel,t2.Id_ortmpl,t2.Sd_ortmpltp,t2.Name,");
		buffer.append("t2.Fg_entp_op,t2.Fg_entp_ip,t2.Fg_entp_er,t2.Fg_entp_er1,t2.Fg_entp_er2,t2.Fg_entp_pe,t2.Fg_entp_fm ");
		buffer.append("from bd_srv_ortmpl_ca_rel t1 left join bd_srv_ortmpl t2 on t1.Id_ortmpl=t2.Id_ortmpl ");
		buffer.append("where t2.fg_sync = 'N' and t2.Id_grp='"+this.id_grp+"' and t2.Id_org='"+this.id_org+"'");

		// 科室
		if(StringUtils.isNotBlank(id_dep)){
			buffer.append(" and t2.Id_dep='"+this.id_dep+"'");
		}
		// 个人
		if(StringUtils.isNotBlank(id_emp)){
			buffer.append(" and t2.Id_emp='"+this.id_emp+"'");
		}
		// 所属分类
		if(StringUtils.isNotBlank(id_ortmplca)){
			buffer.append(" and t1.Id_ortmplca in ("+this.id_ortmplca+")");
		}
		if(FBoolean.TRUE.equals(this.bFgactive)){
			buffer.append(" and t2.fg_active='Y' ");
		}
		buffer.append(this.getCodeEntpStr());
		buffer.append(" order by t2.Seqno");
		
		return buffer.toString();
	}
	
	public String getCodeEntpStr(){
		String str = "";
		switch (this.code_entp) {
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
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
			str += " and t2.fg_use_pip='Y' ";
		}
		return str;
	}
}
