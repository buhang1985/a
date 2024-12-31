package iih.en.pv.s.bp.ip.ws;

import iih.bd.base.utils.SqlUtils;
import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.bp.ip.ws.bean.InpatientInfoParam;
import iih.en.pv.s.bp.ip.ws.bean.InpatientInfoResult;
import iih.en.pv.s.bp.ip.ws.bean.InpatientInfoResultBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院病人信息
 * @author zhangpp
 *
 */
public class GetInpatientInfoBP {

	public String exec(String param)  {
		InpatientInfoResultBean resultBean = new InpatientInfoResultBean();
        try {
            final InpatientInfoParam params = WsXmlUtils.deSerializeBaseDO(param, InpatientInfoParam.class);
            //校验入参
    		this.checkParam(params);
    		//获取住院病人信息
    		InpatientInfoResult[] results = this.getInpatientInfo(params);
            resultBean.setData(results);
        } catch (BizException e) {
            BaseWsResult resultBeanErr = new BaseWsResult();
            resultBeanErr.setException(e);
            return WsXmlUtils.serialize(resultBeanErr);
        }
        return WsXmlUtils.serialize(resultBean);
    }
    
	/**
	 * 校验入参
	 * @param param
	 * @throws BizException
	 */
	private void checkParam(InpatientInfoParam params) throws BizException {
		if (EnValidator.isEmpty(params.getInpatientId())) {
			throw new BizException("住院号不允许为空");
		}
	}
	
	/**
	 * 获取住院病人信息
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private InpatientInfoResult[] getInpatientInfo(InpatientInfoParam params) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sb.append(" select ");
		sb.append(" pat.code as patientId, ");
		sb.append(" org.code as hospitalId, ");
		sb.append(" org.name as hospitalName, ");
		sb.append(" ent.id_dep_phy as deptId, ");
		sb.append(" dep.name as deptName, ");
		sb.append(" pat.name as patientName, ");
		sb.append(" ent.dt_acpt as inTime, ");
		sb.append(" ent.dt_end as outTime, ");
		sb.append(" entip.code_amr_ip as inpatientId, ");
		sb.append(" pat.id_code as idCardNo, ");
		sb.append(" '' as remark, ");
		sb.append(" '1' as isReadyCopy ");
		sb.append(" from en_ent_ip entip ");
		sb.append(" inner join en_ent ent on entip.id_ent = ent.id_ent ");
		sb.append(" inner join pi_pat pat on ent.id_pat = pat.id_pat ");
		sb.append(" left join bd_dep dep on ent.id_dep_phy = dep.id_dep ");
		sb.append(" left join bd_org org on ent.id_org = org.id_org ");
		sb.append(" where ");
		sb.append(" ent.code_entp = '10' ");
		sb.append(" and ent.fg_canc = 'N' ");
		sb.append(" and entip.sd_status = '28' ");
		//住院号
		if ( !EnValidator.isEmpty(params.getInpatientId()) ) {
			String sql = SqlUtils.getInSqlByIdsSplit(params.getInpatientId());
			sb.append(" and entip.code_amr_ip  "+sql);
		}
		//身份证号码
		if ( !EnValidator.isEmpty(params.getIdCardNo()) ) {
			sb.append(" and pat.id_code = ? ");
			sqlParam.addParam(params.getIdCardNo());
		}
		//住院患者唯一ID
		if ( !EnValidator.isEmpty(params.getPatientId()) ) {
			sb.append(" and pat.code = ? ");
			sqlParam.addParam(params.getPatientId());
		}

		List<InpatientInfoResult> list = (List<InpatientInfoResult>) new DAFacade().execQuery(sb.toString(), sqlParam, new BeanListHandler(InpatientInfoResult.class));
		
		return list.toArray(new InpatientInfoResult[0]);
	} 
	
}
