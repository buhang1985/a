package iih.ci.ord.s.external.obtain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.i.external.obtain.ICiOrdEnRService;
import iih.ci.ord.i.external.obtain.meta.en.PatEnInfoDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取EN域数据接口
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdEnRService.class }, binding = Binding.JSONRPC)
public class CiOrdEnRServiceImpl implements ICiOrdEnRService {

	/**
	 * 根据患者id获取住院患者信息，用于第三方URL展示参数
	 * @param id_en
	 * @throws DAException 
	 */
	@Override
	public PatEnInfoDTO getOpEnPatInfo(String id_en, String code_entp) throws DAException {

		SqlParam param = new SqlParam();
		param.addParam(id_en);
		String qrySql = null;
		
		// 门 急诊		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){
			qrySql = "select t.id_ent as id_en, %s as code_entp, pat.code as code_pat, pat.barcode_chis as pbar_code, p.times_op as en_times from pi_pat pat, en_ent t, en_ent_op p where t.id_ent = ? and t.id_pat = pat.id_pat and t.id_ent = p.id_ent";	
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){
			qrySql = "select t.id_ent as id_en, %s as code_entp, pat.code as code_pat, pat.code_amr_ip as pbar_code, p.times_ip as en_times from pi_pat pat, en_ent t, en_ent_ip p where t.id_ent = ? and t.id_pat = pat.id_pat and t.id_ent = p.id_ent";
		}
		
		qrySql = String.format(qrySql,code_entp);		
		PatEnInfoDTO patEnInfo = (PatEnInfoDTO) new DAFacade().execQuery(qrySql, param, new BeanHandler(PatEnInfoDTO.class));

		return patEnInfo;
	}

	@Override
	public String[] getLastEnDiIds(String id_en) throws BizException {
		//根据就诊提供接口查询本次抢救中前一次的诊断信息
		 IEn4CiQryService enService=(IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class);
		 EntDiDO[] enDiDos=enService.getErPreEntDis(id_en);
		 if(enDiDos==null || enDiDos.length<1)return null;
		 List<String> id_dis=new ArrayList<String>();
		 for (EntDiDO enDiDo : enDiDos) {
			 if(enDiDo.getId_di()!=null && !id_dis.contains(enDiDo.getId_di()))
				 id_dis.add(enDiDo.getId_di());
		 }
		 return id_dis.toArray(new String[id_dis.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAuthorisedDepIds(String id_en) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("select id_dep_to from en_ent_auth where id_ent = ? and dt_end > to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS')");
		param.addParam(id_en);
		return (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler<String>());
	}

}
