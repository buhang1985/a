package iih.ci.mr.hpqry;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
@Service(serviceInterfaces={IHpQryIsHaveMrService.class,IHpQryIsHaveMrService.class}, binding=Binding.JSONRPC)
public class HpQryIsHaveMrServiceImpl implements IHpQryIsHaveMrService{
	
	/**
	 * 判断指定就诊号 和 病历文书类型编码，在指定时间区域内的书写签署状态
	 * @param id_ent 就诊号
	 * @param bd_mrca_ctm.code 病历文书类型编码
	 * @param dt_begin 时间左区域
	 * @param dt_end 时间 右区域
	 * @return
	 * @throws BizException
	 */
	@Override
	public int IsHaveMr(String id_ent, String code, FDateTime dt_begin,
			FDateTime dt_end) throws BizException {
		if(isNull(id_ent) || isNull(code))
			return -1;
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from CI_MR mr where mr.id_ent = '");
		sb.append(id_ent + "' and mr.id_mrtp in (select itm.id_mrtp \n");
		sb.append(" from bd_mrca_ctm ctm join bd_mrca_ctm_itm itm on ctm.id_mrcactm = itm.id_mrcactm  \n");
		sb.append(" join bd_mrtp mrtp on mrtp.id_mrtp = itm.id_mrtp  \n");
		sb.append(" where mrtp.code = '" + code + "' or ctm.code = '"+code+"')  \n");
		if(!isNull(dt_begin)){
			sb.append(" and mr.createdtime > '" + dt_begin.toString() + "'");
		}
		if(!isNull(dt_end)){
			sb.append(" and mr.createdtime < '" + dt_end.toString() + "'");
		}

	
		DAFacade daf=new DAFacade();
		int countCiMr = (int) daf.execQuery(sb.toString(), new ColumnHandler());
		if(countCiMr <= 0){
			return 0;
		}
		sb.append(" and mr.sd_su_mr <> '00'");
		countCiMr = (int) daf.execQuery(sb.toString(), new ColumnHandler());
		if(countCiMr <= 0){
			return 1;
		}else{
			return 2;
		}
	}
	
	/**
	 * 非空校验
	 * @param obj
	 * @return
	 */
	private boolean isNull(Object obj){
		if(obj == null || obj.toString() == null || "".equals(obj.toString()))
			return true;
		else 
			return false;
	}



}
