package iih.ci.ord.s.external.outqry.bp;

import iih.ci.ord.external.outqry.d.OrdQueryParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OpPatientInfoQry implements ITransQry{
	

	private String code_en;
	private String pat_code;
	private int times_op; 
	public OpPatientInfoQry(OrdQueryParamDTO param) {
		this.code_en=param.getCode_en();
		this.pat_code=param.getCode_pat();
		if(CiOutQueryUtils.isStrEmpty(param.getTimes_en())) {
			this.times_op=0;
		}else {
			this.times_op=Integer.parseInt(param.getTimes_en());
		}
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if(!CiOutQueryUtils.isStrEmpty(code_en)) {
			param.addParam(code_en);
		}else {
			param.addParam(pat_code);
			if(this.times_op!=0)
			param.addParam(times_op);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String basesql=CiOutQueryUtils.getOpPatInfoBaseSql();
		basesql=basesql+" where 1=1 ";
		if(!CiOutQueryUtils.isStrEmpty(code_en)) {
			basesql=basesql+" and en_ent.code=? ";
		}else{
			basesql=basesql+" and pi_pat.code=? ";
			if(this.times_op!=0) {
				basesql=basesql+" and en_ent_op.times_op=?  ";
			}
		}
		return basesql;
	}

}
