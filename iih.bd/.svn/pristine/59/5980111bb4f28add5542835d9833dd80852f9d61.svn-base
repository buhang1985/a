package iih.bd.mm.meterial.s.rule.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据id更改药品通用名相关属性规则
 * 
 * @author shao_yuan
 *
 */
public class MaterialPropChangSetSrvBp {

	public void exec(String[] ids) throws BizException {
		if(ArrayUtils.isEmpty(ids)) {
			return;
		}
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		String sql = SetSqlStr(ids);

		MedSrvDO[] medDos = service.find(sql, "", FBoolean.FALSE);
		SetMedSrvActive(medDos);
		
	}
	/**
	 * 更改药品通用名相关属性
	 * 
	 * @param medDos
	 * @throws BizException
	 */
	private void SetMedSrvActive(MedSrvDO[] medDos) throws BizException {
		IMedsrvMDOCudService service = ServiceFinder.find(IMedsrvMDOCudService.class);
		List<MedSrvDO> list = new ArrayList();
		for(MedSrvDO dos : medDos){
			dos.setFg_active(FBoolean.FALSE);
			dos.setStatus(DOStatus.UPDATED);	
			list.add(dos);
		}
		if(list.size() <=0)return;
		service.update(list.toArray(new MedSrvDO[0]));
	}
	/**
	 * 获取sql
	 * 
	 * @param ids
	 */
	private String SetSqlStr(String[] ids) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");
		
		String wherePart = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, ids);
		if (wherePart != null && !wherePart.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		wherePartBuilder.append(" and id_srv not in (select id_srv from bd_mm where  ");		
		wherePartBuilder.append(" ds = 0 ");
		wherePartBuilder.append(" and fg_active = 'Y' ");
		String strsql = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		if(strsql != null && !strsql.isEmpty()){
			wherePartBuilder.append("and ");
			wherePartBuilder.append(strsql);
		}
		wherePartBuilder.append(" ) ");
		return wherePartBuilder.toString();
	}

}
